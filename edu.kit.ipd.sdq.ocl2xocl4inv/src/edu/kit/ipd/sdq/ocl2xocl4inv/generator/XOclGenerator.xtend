package edu.kit.ipd.sdq.ocl2xocl4inv.generator

import java.util.List
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.ocl.ecore.CollectionItem
import org.eclipse.ocl.ecore.CollectionLiteralExp
import org.eclipse.ocl.ecore.Constraint
//import org.eclipse.ocl.ecore.OCLExpression
import org.eclipse.ocl.expressions.OCLExpression
import org.eclipse.ocl.ecore.OperationCallExp
import org.eclipse.ocl.ecore.PrimitiveLiteralExp
import org.eclipse.ocl.ecore.PropertyCallExp
import org.eclipse.ocl.ecore.VariableExp
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.ocl.ecore.IteratorExp
import org.eclipse.ocl.ecore.Variable
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EReference

class XOclGenerator implements IGenerator {

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		var oclInvariantExtractor = new OclInvariantExtractor();
		var constraintList = oclInvariantExtractor.getConstraints(input);
		
		var fileName = getFileName(input) + ".xocl";
		createXOclFile(fsa, fileName, constraintList);
	}


	private def String getFileName(Resource input) {
		var fileURI = input.getURI();
		return fileURI.lastSegment;
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
		var specification = constraint.specification; // typ ExpressionInOCL (enthält bodyExpression und contextVariable)
		var expression = specification.bodyExpression; // typ OCLExpression -> ist das Root Element des OCL AST

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
	}

	def dispatch String transform(OperationCallExp expression) {
		//TODO: wie auf mehrere Argumente reagieren?; Cast?
		//TODO: Hier darauf reagieren jenachdem welche ReferredOperation es ist!
		'''«transform(expression.source)»''' + 
		'''«transform(expression.referredOperation)»(«FOR arg : expression.argument»«arg»«ENDFOR»)'''
	}
	
	def dispatch String transform(PropertyCallExp expression) 
		'''«transform(expression.source)».«transform(expression.referredProperty)»'''
	
	
	def dispatch String transform(CollectionLiteralExp expression)
		'''«FOR part : expression.part»«transform(part)»«ENDFOR»'''

	
	def dispatch String transform(CollectionItem expression)
		'''«transform(expression.item)»'''
		
	
	def dispatch String transform(IteratorExp expression)
		'''«transform(expression.source)»->«expression.name»[«transform(expression.iterator)» | «transform(expression.body)»]'''


	def dispatch String transform(EList<Variable> expression) {
		//TODO: kann es mehrere geben? Wenn ja wie voneinander trennen? «FOR variable : expression SEPERATOR ';'»
		'''«FOR variable : expression»«variable.name» : «variable.EGenericType.ERawType.name»«ENDFOR»'''
		}


	def dispatch String transform(PrimitiveLiteralExp expression)
		'''«expression.name»'''

	
	def dispatch String transform(EOperation expression) {
		var prefix = "";
		var operation = "";
		
		
		switch expression.name {
			case 'isEmpty': operation = "empty"
			default: operation = expression.name
		}
		
		//TODO: regex expression possible? (check for <,+,=,... (no letters))
		switch expression.name {
			case '<': prefix = " "
			case '>': prefix = " "
			case '<=': prefix = " "
			case '>=': prefix = " "			
			case '+': prefix = " "
			case '-': prefix = " "			
			case '*': prefix = " "
			case '/': prefix = " "
			case '=': prefix = " "
			default: prefix = "->"
		}
		
		'''«prefix»«operation»'''
	}
	
	
	def dispatch String transform(EAttribute expression)
		'''«expression.name»'''

		
	def dispatch String transform(VariableExp expression)
		'''«expression.name»'''

	
	def dispatch String transform(EReference expression)
		'''«expression.name»'''
	

}