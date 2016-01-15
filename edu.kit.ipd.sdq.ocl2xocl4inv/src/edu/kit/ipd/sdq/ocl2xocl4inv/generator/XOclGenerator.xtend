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
			'''«FOR constraint : constraints»
				context «constraint.specification.contextVariable.type.name»
				invariant «constraint.name» ()
				check «getExpression(constraint)»
				 
				«ENDFOR»'''
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
		//TODO
		throw new UnsupportedOperationException
	}	
	
	def dispatch String transform(Void v) {
		// TODO
		throw new UnsupportedOperationException
	}
	
	def dispatch String transform(PropertyCallExp expression)
		'''«transform(expression.source)».«transform(expression.referredProperty)»'''
		
	def dispatch String transform(IteratorExp expression) {		
		var iteratorName = "";
		
		switch expression.name {
			case 'forAll': iteratorName = "forall"
			case 'select': iteratorName = "filter"
			case 'collect': iteratorName = "map"
			case 'collectNested': iteratorName = "map"
			case 'sortedBy': iteratorName = "sortBy"
			case 'any': iteratorName = "findFirst"
			case 'reject': {
				iteratorName = "filter";
				return '''«transform(expression.source)».«iteratorName»[«transform(expression.iterator)» | !(«transform(expression.body)»)]'''
			}
			default: iteratorName = expression.name
		}
		
		'''«transform(expression.source)».«iteratorName»[«transform(expression.iterator)» | «transform(expression.body)»]'''
	}
	
	def dispatch String transform(IterateExp expression) {
		'''«transform(expression.source)».fold(«transform(expression.result.initExpression)», [«transform(expression.result)», «transform(expression.iterator)» | «transform(expression.body)»])'''
	}

	def dispatch String transform(EList<?> expression)
		'''«FOR element : expression SEPARATOR ", "»«transform(element)»«ENDFOR»'''
		
	def dispatch String transform(CollectionLiteralExp expression) {
		//expression part is a EList
		'''«FOR part : expression.part SEPARATOR ", "»«transform(part)»«ENDFOR»'''
	}
		
	def dispatch String transform(CollectionItem expression)
		'''«transform(expression.item)»'''
	
	def dispatch String transform(OperationCallExp expression) {
		var prefix = "";
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
			case 'excludes': { operationCallSign = "."; useParentheses = true; prefix = "!"; }
			case 'notEmpty': { operationCallSign = "."; useParentheses = true; prefix = "!"; }
			default: { operationCallSign = "."; useParentheses = true; }
		}

		if(useParentheses) {
			if(arguments.equals("")) {
				return '''«prefix»«source»«operationCallSign»«referredOperation»'''
			}
			return '''«prefix»«source»«operationCallSign»«referredOperation»(«arguments»)'''
		}

		return '''«prefix»«source»«operationCallSign»«referredOperation» «arguments»'''
	}
	
	def dispatch String transform(EOperation expression) {
		var operationName = "";

		switch expression.name {
			case 'includes': operationName = "contains"
			case 'includesAll': operationName = "containsAll"
			case 'isEmpty': operationName = "empty"
			case 'notEmpty': operationName = "empty"
			case 'excludes': operationName = "contains"
			case 'at': operationName = "get"
			case '=': operationName = "=="
			case '<>': operationName = "!="
			default: operationName = expression.name
		}
		
		return operationName;
	}

	def dispatch String transform(StringLiteralExp expression)
		'''«expression.stringSymbol»'''

	def dispatch String transform(IntegerLiteralExp expression)
		'''«expression.integerSymbol»'''

	def dispatch String transform(UnlimitedNaturalLiteralExp expression) {
		//TODO
		throw new UnsupportedOperationException
	}
	
	def dispatch String transform(RealLiteralExp expression)
		'''«expression.realSymbol»'''
	
	def dispatch String transform(BooleanLiteralExp expression)
		'''«expression.booleanSymbol»'''

	def dispatch String transform(EAttribute expression)
		'''«expression.name»'''
		
	def dispatch String transform(Variable expression) {
		//TODO: initExpression? see IterateExp
		
		//self is a keyword in xbase so it has to be escaped
		if(expression.name.equals("self")) {
			return '''_«expression.name»'''
		}
		return '''«expression.name»'''
	}

	def dispatch String transform(VariableExp expression) {
		//self is a keyword in xbase so it has to be escaped
		if(expression.name.equals("self")) {
			return '''_«expression.name»'''
		}
		return '''«expression.name»'''
	}

	def dispatch String transform(EReference expression)
		'''«expression.name»'''
}