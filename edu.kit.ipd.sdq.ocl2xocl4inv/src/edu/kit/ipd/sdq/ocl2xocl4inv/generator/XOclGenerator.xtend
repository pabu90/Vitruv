package edu.kit.ipd.sdq.ocl2xocl4inv.generator

import java.util.List
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.ocl.ecore.CollectionItem
import org.eclipse.ocl.ecore.CollectionLiteralExp
import org.eclipse.ocl.ecore.Constraint
import org.eclipse.ocl.ecore.OCLExpression
import org.eclipse.ocl.ecore.OperationCallExp
import org.eclipse.ocl.ecore.PrimitiveLiteralExp
import org.eclipse.ocl.ecore.PropertyCallExp
import org.eclipse.ocl.ecore.VariableExp
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

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
			'''
				«FOR constraint : constraints»
				context «constraint.specification.contextVariable.type.name»
				invariant «constraint.name» ()
				check «createXOclInvariant(constraint)»
				 
				«ENDFOR»	
			'''
		);
	}
	
	
	private def String createXOclInvariant(Constraint constraint) {
		var specification = constraint.specification; // typ ExpressionInOCL (enthält bodyExpression und contextVariable)
		var expression = specification.bodyExpression; // typ OCLExpression -> ist das Root Element des OCL AST
		var oclExpression = expression as OCLExpression;

		return visit(oclExpression);
	}		
	
	

	def dispatch String visit(OperationCallExp expression) {
		//TODO: wie auf mehrere Argumente reagieren?; Cast?
		'''
				«visit(expression.source as OCLExpression)»«visit(expression.referredOperation)»(«FOR arg : expression.argument»«arg.toString»«ENDFOR»)
		'''
	}
	
	def dispatch String visit(PropertyCallExp expression) {		
		'''
				«visit(expression.source as OCLExpression)».«visit(expression.referredProperty)»
		'''
	}
	
	def dispatch String visit(CollectionLiteralExp expression) {
		//TODO: why is the cast necessary?
		'''
			«FOR part : expression.part»«visit(part as CollectionItem)»«ENDFOR»
		'''
	}

	
	def dispatch String visit(CollectionItem expression) {
		//TODO cast
		'''
			«visit(expression.item as OCLExpression)»
		'''
	}



	def dispatch String visit(PrimitiveLiteralExp expression) {
		'''
			«expression.name»
		'''
	}
	
	def dispatch String visit(EOperation expression) {
		var prefix = "";
		
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
			default: prefix = "->"
		}
		
		'''
			«prefix»«expression.name»
		'''
	}
	
	def dispatch String visit(EAttribute expression) {
		'''
			«expression.name»
		'''
	}
		
	def dispatch String visit(VariableExp expression) {
		'''
			«expression.name»
		'''
	}
	
	
	

}