/*******************************************************************************
 * Copyright (c) 2015 Nicolas Pätzold.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Pätzold - initial API and implementation and/or initial documentation
 *******************************************************************************/
package edu.kit.ipd.sdq.ocl2xocl4inv.generator

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EReference
import org.eclipse.ocl.ecore.BooleanLiteralExp
import org.eclipse.ocl.ecore.CollectionItem
import org.eclipse.ocl.ecore.CollectionLiteralExp
import org.eclipse.ocl.ecore.Constraint
import org.eclipse.ocl.ecore.EnumLiteralExp
import org.eclipse.ocl.ecore.IntegerLiteralExp
import org.eclipse.ocl.ecore.IterateExp
import org.eclipse.ocl.ecore.IteratorExp
import org.eclipse.ocl.ecore.NullLiteralExp
import org.eclipse.ocl.ecore.OperationCallExp
import org.eclipse.ocl.ecore.PropertyCallExp
import org.eclipse.ocl.ecore.RealLiteralExp
import org.eclipse.ocl.ecore.StringLiteralExp
import org.eclipse.ocl.ecore.TypeExp
import org.eclipse.ocl.ecore.UnlimitedNaturalLiteralExp
import org.eclipse.ocl.ecore.Variable
import org.eclipse.ocl.ecore.VariableExp
import org.eclipse.ocl.expressions.OCLExpression
import org.eclipse.ocl.ecore.PrimitiveType
import java.util.ArrayList
import org.eclipse.ocl.ecore.LetExp

 /**
 * This class transforms the ocl constraints to xocl4inv constraints.
 * 
 * @author npaetz
 */
public class XOclTransformer {
	
	private static ArrayList<String> variables;
	
	 /**
	 * Get the constraint expression.
	 * @param constraint Constraint
	 * @returns constraint expression as string
	 */
	public static def String getExpression(Constraint constraint) {
		var specification = constraint.specification; // type ExpressionInOCL (contains bodyExpression and contextVariable)
		var expression = specification.bodyExpression; // type OCLExpression -> the root element of the OCL AST

		return createXOclInvariant(expression);
	}
	
	 /**
	 * Creates the xocl4inv invariant.
	 * @param expression OCLExpression<?>
	 * @returns xocl invarint as string
	 */
	public static def String createXOclInvariant(OCLExpression<?> expression) {
		//in case the invariant contains a LetExp put all the variable declarations in the variables list
		variables = new ArrayList<String>();
		var expressionString = transform(expression);
		
		if(variables.size == 0) {
			return expressionString;
		}
		
		//the invariant contains a LetExp, put the variable declarations in front of the expression string
		return '''{«FOR variable : variables SEPARATOR " "»«variable»;«ENDFOR» «expressionString»}''';
	}		
	
	 /**
	 * Transforms the ocl expression.
	 * @param e OCLExpression<?>
	 * @returns expression as string
	 */
	static def dispatch String transform(OCLExpression<?> e) {
		//throw new UnsupportedOperationException("No method for type: " + e.class.toString)
		return "UnsupportedOperationException"
	}	
	
     /**
	 * Transforms the ocl expression.
	 * @param v Void
	 * @returns expression as string
	 */
	static def dispatch String transform(Void v) {
		//throw new UnsupportedOperationException("Void dispatch function called")
		return "UnsupportedOperationException"
	}
	
	 /**
	 * Transforms the PropertyCallExp expression.
	 * @param expression PropertyCallExp
	 * @returns expression as string
	 */
	static def dispatch String transform(PropertyCallExp expression)
		'''«transform(expression.source)».«transform(expression.referredProperty)»'''
		
	 /**
	 * Transforms the LetExp expression.
	 * @param expression LetExp
	 * @returns expression as string
	 */
	static def dispatch String transform(LetExp expression) {
		//put the variable declaration in the list because it has to be put in front of all other expressions
		variables.add('''var «expression.variable.name» = «transform(expression.variable.initExpression)»''');
		
		return transform(expression.in);
	}
		
	 /**
	 * Transforms the IteratorExp expression.
	 * @param expression IteratorExp
	 * @returns expression as string
	 */		
	static def dispatch String transform(IteratorExp expression) {	
		var source = transform(expression.source);
		var iterator = transform(expression.iterator);
		var expressionBody = transform(expression.body);	
		var iteratorName = "";
		
		switch expression.name {
			case 'select': iteratorName = "filter"
			case 'collect': iteratorName = "map"
			case 'collectNested': iteratorName = "map"
			case 'sortedBy': iteratorName = "sortedBy"	//in paper "sortBy"
			case 'any': iteratorName = "findFirst"
			case 'isUnique': iteratorName = "unique"
			case 'forAll': iteratorName = "forAll"	//in paper "forall"
			default: iteratorName = expression.name
		}
		
		'''«source».«iteratorName»[«iterator» | «expressionBody»]'''
	}
	
	 /**
	 * Transforms the IterateExp expression.
	 * @param expression IterateExp
	 * @returns expression as string
	 */			
	static def dispatch String transform(IterateExp expression) {
		'''«transform(expression.source)».fold(«transform(expression.result.initExpression)», [«transform(expression.result)», «transform(expression.iterator)» | «transform(expression.body)»])'''
	}

	 /**
	 * Transforms the EList<?> expression.
	 * @param expression EList<?>
	 * @returns expression as string
	 */	
	static def dispatch String transform(EList<?> expression) {
		//don't use a whitespace between the separator if it's a list of numbers (e.g. (1,1) or (1,*))
		if(expression.findFirst[ element | element instanceof IntegerLiteralExp] != null ||
			expression.findFirst[ element | element instanceof UnlimitedNaturalLiteralExp] != null) {
			'''«FOR element : expression SEPARATOR ","»«transform(element)»«ENDFOR»'''
		}
		else {
			'''«FOR element : expression SEPARATOR ", "»«transform(element)»«ENDFOR»'''
		}
	}
	
	 /**
	 * Transforms the CollectionLiteralExp expression.
	 * @param expression CollectionLiteralExp
	 * @returns expression as string
	 */				
	static def dispatch String transform(CollectionLiteralExp expression) {
		//expression part is a EList
		'''«FOR part : expression.part SEPARATOR ", "»«transform(part)»«ENDFOR»'''
	}

	 /**
	 * Transforms the CollectionItem expression.
	 * @param expression CollectionItem
	 * @returns expression as string
	 */			
	static def dispatch String transform(CollectionItem expression)
		'''«transform(expression.item)»'''

	 /**
	 * Transforms the OperationCallExp expression.
	 * @param expression OperationCallExp
	 * @returns expression as string
	 */			
	static def dispatch String transform(OperationCallExp expression) {
		var operationCallSign = "";
		var useParentheses = false;
		
		var source = transform(expression.source);
		var referredOperation = transform(expression.referredOperation);
		var arguments = transform(expression.argument);
		
		switch expression.referredOperation.name {
			case '<': operationCallSign = " "
			case '>': operationCallSign = " "
			case '<=': operationCallSign = " "
			case '>=': operationCallSign = " "			
			case '+': operationCallSign = " "
			case '-': operationCallSign = " "			
			case '*': operationCallSign = " "
			case '/': operationCallSign = " "
			case '=': operationCallSign = " "
			case '<>': operationCallSign = " "
			case 'and': operationCallSign = " "
			case 'or': operationCallSign = " "
			case 'not': return '''«referredOperation»(«source»)'''
			case 'implies': return '''(«source»).«referredOperation»(«arguments»)'''
			case 'at': { 
				operationCallSign = "."; useParentheses = true;
				//'at' expects a value > 0 but 'get' expects a value >= 0 --> decrement argument by one
				try {
					var arg = Integer.parseInt(arguments);
					arguments = (arg-1).toString; 
				}
				catch(Exception ex) {
					//can't cast it to int because it is an integer variable
					arguments = arguments + " - 1";
				}
			}
			default: { operationCallSign = "."; useParentheses = true; }
		}

		if(useParentheses) {
			if(arguments.equals("")) {
				return '''«source»«operationCallSign»«referredOperation»'''
			}
			return '''«source»«operationCallSign»«referredOperation»(«arguments»)'''
		}

		return '''«source»«operationCallSign»«referredOperation» «arguments»'''
	}

	 /**
	 * Transforms the EOperation expression.
	 * @param expression EOperation
	 * @returns expression as string
	 */			
	static def dispatch String transform(EOperation expression) {
		var operationName = "";

		switch expression.name {
			case 'includes': operationName = "contains"
			case 'includesAll': operationName = "containsAll"
			case 'isEmpty': operationName = "empty"
			case 'at': operationName = "get"
			case '=': operationName = "=="
			case '<>': operationName = "!="
			case 'not': operationName = "!"
			case 'and': operationName = "&&"
			case 'or': operationName = "||"
			default: operationName = expression.name
		}
		
		return operationName;
	}

	 /**
	 * Transforms the StringLiteralExp expression.
	 * @param expression StringLiteralExp
	 * @returns expression as string
	 */	
	static def dispatch String transform(StringLiteralExp expression) {
		var apostrophe = "'";
		
		return '''«apostrophe»«expression.stringSymbol»«apostrophe»'''
	}

	 /**
	 * Transforms the IntegerLiteralExp expression.
	 * @param expression IntegerLiteralExp
	 * @returns expression as string
	 */	
	static def dispatch String transform(IntegerLiteralExp expression)
		'''«expression.integerSymbol»'''

	 /**
	 * Transforms the UnlimitedNaturalLiteralExp expression.
	 * @param expression UnlimitedNaturalLiteralExp
	 * @returns expression as string
	 */	
	static def dispatch String transform(UnlimitedNaturalLiteralExp expression) {
		if(expression.isUnlimited) {
			return "*";
		}
		else {
			//TODO: What todo if it is not unlimited?
			throw new UnsupportedOperationException("Method with type UnlimitedNaturalLiteralExp called")
		}
	}
	
	 /**
	 * Transforms the RealLiteralExp expression.
	 * @param expression RealLiteralExp
	 * @returns expression as string
	 */	
	static def dispatch String transform(RealLiteralExp expression)
		'''«expression.realSymbol»'''

	 /**
	 * Transforms the BooleanLiteralExp expression.
	 * @param expression BooleanLiteralExp
	 * @returns expression as string
	 */	
	static def dispatch String transform(BooleanLiteralExp expression)
		'''«expression.booleanSymbol»'''

	 /**
	 * Transforms the EAttribute expression.
	 * @param expression EAttribute
	 * @returns expression as string
	 */	
	static def dispatch String transform(EAttribute expression)
		'''«expression.name»'''
		
	 /**
	 * Transforms the Variable expression.
	 * @param expression Variable
	 * @returns expression as string
	 */			
	static def dispatch String transform(Variable expression) {
		//TODO: consider initExpression? See special handling of initExpression at IterateExp
		
		//self is a keyword in xbase so it has to be escaped
		if(expression.name.equals("self")) {
			return '''_«expression.name»'''
		}
		return '''«expression.name»'''
	}

	 /**
	 * Transforms the VariableExp expression.
	 * @param expression VariableExp
	 * @returns expression as string
	 */		
	static def dispatch String transform(VariableExp expression) {
		//self is a keyword in xbase so it has to be escaped
		if(expression.name.equals("self")) {
			return '''_«expression.name»'''
		}
		return '''«expression.name»'''
	}

	 /**
	 * Transforms the EReference expression.
	 * @param expression EReference
	 * @returns expression as string
	 */		
	static def dispatch String transform(EReference expression)
		'''«expression.name»'''
	
	 /**
	 * Transforms the NullLiteralExp expression.
	 * @param expression NullLiteralExp
	 * @returns expression as string
	 */				
	static def dispatch String transform(NullLiteralExp expression)
		'''null'''
	
	 /**
	 * Transforms the EnumLiteralExp expression.
	 * @param expression EnumLiteralExp
	 * @returns expression as string
	 */				
	static def dispatch String transform(EnumLiteralExp expression)
		'''«transform(expression.EType)»::«transform(expression.referredEnumLiteral)»'''
	
	 /**
	 * Transforms the EEnumLiteral expression.
	 * @param expression EEnumLiteral
	 * @returns expression as string
	 */				
	static def dispatch String transform(EEnumLiteral expression)
		'''«expression.name»'''

	 /**
	 * Transforms the EEnum expression.
	 * @param expression EEnum
	 * @returns expression as string
	 */						
	static def dispatch String transform(EEnum expression)
		'''«expression.name»'''
		
	 /**
	 * Transforms the TypeExp expression.
	 * @param expression TypeExp
	 * @returns expression as string
	 */				
	static def dispatch String transform(TypeExp expression)
		'''«transform(expression.referredType)»'''

	 /**
	 * Transforms the PrimitiveType expression.
	 * @param expression PrimitiveType
	 * @returns expression as string
	 */			
	static def dispatch String transform(PrimitiveType expression)
		'''«expression.name»'''

	 /**
	 * Transforms the EClass expression.
	 * @param expression EClass
	 * @returns expression as string
	 */				
	static def dispatch String transform(EClass expression)
		'''«expression.name»'''
	
}