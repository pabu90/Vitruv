package edu.kit.ipd.sdq.ocl2xocl4inv.generator

import java.util.List
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.ocl.ecore.CollectionItem
import org.eclipse.ocl.ecore.CollectionLiteralExp
import org.eclipse.ocl.ecore.Constraint
import org.eclipse.ocl.expressions.OCLExpression
import org.eclipse.ocl.ecore.OperationCallExp
import org.eclipse.ocl.ecore.PropertyCallExp
import org.eclipse.ocl.ecore.VariableExp
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.ocl.ecore.IteratorExp
import org.eclipse.ocl.ecore.Variable
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EReference
import org.eclipse.ocl.ecore.StringLiteralExp
import org.eclipse.ocl.ecore.IntegerLiteralExp
import org.eclipse.ocl.ecore.UnlimitedNaturalLiteralExp
import org.eclipse.ocl.ecore.RealLiteralExp
import org.eclipse.ocl.ecore.BooleanLiteralExp
import org.eclipse.ocl.ecore.IterateExp
import org.eclipse.ocl.ecore.NullLiteralExp
import org.eclipse.ocl.ecore.EnumLiteralExp
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EEnum
import org.eclipse.ocl.ecore.TypeExp
import org.eclipse.emf.ecore.EClass

class XOclGenerator implements IGenerator {

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		var oclInvariantExtractor = new OclInvariantExtractor();
		var constraintList = oclInvariantExtractor.getConstraints(input);
		
		var fileName = getFileName(input) + ".xocl";
		createXOclFile(fsa, fileName, constraintList);
	}

	private def String getFileName(Resource input) {
		var fileURI = input.getURI();
		var filename =  fileURI.lastSegment;
		
		if (filename.indexOf(".") > 0) {
			filename = filename.substring(0, filename.lastIndexOf("."));
		}
		
		return filename;
	}

	private def void createXOclFile(IFileSystemAccess fsa, String fileName, List<Constraint> constraints) {
		fsa.generateFile(
			fileName,
			'''
				import "TODO" as mdl
				�FOR constraint : constraints�
				invariant �constraint.name� ()
				context mdl.�constraint.specification.contextVariable.type.name�
				check �getExpression(constraint)�
				 
				�ENDFOR�'''
		);
	}
	
	private def String getExpression(Constraint constraint) {
		var specification = constraint.specification; // type ExpressionInOCL (contains bodyExpression and contextVariable)
		var expression = specification.bodyExpression; // type OCLExpression -> the root element of the OCL AST

		return createXOclInvariant(expression);
	}
	
	public def String createXOclInvariant(OCLExpression<?> expression) {
		return transform(expression);
	}		
	
	def dispatch String transform(OCLExpression<?> e) {
		throw new UnsupportedOperationException("No method for type: " + e.class.toString)
	}	
	
	def dispatch String transform(Void v) {
		throw new UnsupportedOperationException("Void dispatch function called")
	}
	
	def dispatch String transform(PropertyCallExp expression)
		'''�transform(expression.source)�.�transform(expression.referredProperty)�'''
		
	def dispatch String transform(IteratorExp expression) {	
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
		
		'''�source�.�iteratorName�[�iterator� | �expressionBody�]'''
	}
	
	def dispatch String transform(IterateExp expression) {
		'''�transform(expression.source)�.fold(�transform(expression.result.initExpression)�, [�transform(expression.result)�, �transform(expression.iterator)� | �transform(expression.body)�])'''
	}

	def dispatch String transform(EList<?> expression) {
		//don't use a whitespace between the separator if it's a list of numbers (e.g. (1,1) or (1,*))
		if(expression.findFirst[ element | element instanceof IntegerLiteralExp] != null ||
			expression.findFirst[ element | element instanceof UnlimitedNaturalLiteralExp] != null) {
			'''�FOR element : expression SEPARATOR ","��transform(element)��ENDFOR�'''
		}
		else {
			'''�FOR element : expression SEPARATOR ", "��transform(element)��ENDFOR�'''
		}
	}
	
	def dispatch String transform(CollectionLiteralExp expression) {
		//expression part is a EList
		'''�FOR part : expression.part SEPARATOR ", "��transform(part)��ENDFOR�'''
	}
		
	def dispatch String transform(CollectionItem expression)
		'''�transform(expression.item)�'''
	
	def dispatch String transform(OperationCallExp expression) {
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
			case 'not': return '''�referredOperation�(�source�)'''
			case 'implies': return '''(�source�).�referredOperation�(�arguments�)'''
			case 'at': { 
				operationCallSign = "."; useParentheses = true;
				//'at' expects a value > 0 but 'get' expects a value >= 0 --> decrement argument by one
				var arg = Integer.parseInt(arguments);
				arguments = (arg-1).toString; 
			}
			default: { operationCallSign = "."; useParentheses = true; }
		}

		if(useParentheses) {
			if(arguments.equals("")) {
				return '''�source��operationCallSign��referredOperation�'''
			}
			return '''�source��operationCallSign��referredOperation�(�arguments�)'''
		}

		return '''�source��operationCallSign��referredOperation� �arguments�'''
	}
	
	def dispatch String transform(EOperation expression) {
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

	def dispatch String transform(StringLiteralExp expression) {
		var apostrophe = "'";
		
		return '''�apostrophe��expression.stringSymbol��apostrophe�'''
	}

	def dispatch String transform(IntegerLiteralExp expression)
		'''�expression.integerSymbol�'''

	def dispatch String transform(UnlimitedNaturalLiteralExp expression) {
		if(expression.isUnlimited) {
			return "*";
		}
		else {
			//TODO: What todo if it is not unlimited?
			throw new UnsupportedOperationException("Method with type UnlimitedNaturalLiteralExp called")
		}
	}
	
	def dispatch String transform(RealLiteralExp expression)
		'''�expression.realSymbol�'''
	
	def dispatch String transform(BooleanLiteralExp expression)
		'''�expression.booleanSymbol�'''

	def dispatch String transform(EAttribute expression)
		'''�expression.name�'''
		
	def dispatch String transform(Variable expression) {
		//TODO: consider initExpression? See special handling of initExpression at IterateExp
		
		//self is a keyword in xbase so it has to be escaped
		if(expression.name.equals("self")) {
			return '''_�expression.name�'''
		}
		return '''�expression.name�'''
	}

	def dispatch String transform(VariableExp expression) {
		//self is a keyword in xbase so it has to be escaped
		if(expression.name.equals("self")) {
			return '''_�expression.name�'''
		}
		return '''�expression.name�'''
	}

	def dispatch String transform(EReference expression)
		'''�expression.name�'''
		
	def dispatch String transform(NullLiteralExp expression)
		'''null'''
		
	def dispatch String transform(EnumLiteralExp expression)
		'''�transform(expression.EType)�::�transform(expression.referredEnumLiteral)�'''
		
	def dispatch String transform(EEnumLiteral expression)
		'''�expression.name�'''
		
	def dispatch String transform(EEnum expression)
		'''�expression.name�'''
		
	def dispatch String transform(TypeExp expression)
		'''�transform(expression.referredType)�'''
		
	def dispatch String transform(EClass expression)
		'''�expression.name�'''

}