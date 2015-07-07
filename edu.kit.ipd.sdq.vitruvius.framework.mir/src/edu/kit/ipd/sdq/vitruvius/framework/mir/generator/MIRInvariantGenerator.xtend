package edu.kit.ipd.sdq.vitruvius.framework.mir.generator

import edu.kit.ipd.sdq.vitruvius.framework.mir.helpers.MIRHelper
import edu.kit.ipd.sdq.vitruvius.framework.mir.mIR.Invariant
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.XBlockExpression

class MIRInvariantGenerator implements IGenerator {

	private static final String INVARIANT_PKG_NAME = "invariants";

	private static final char PATH_SEPERATOR = '/';

	private def packageNameToPath(String pkgName) {
		pkgName.replace('.', PATH_SEPERATOR)
	}

	private def type(EClass clazz) {
		clazz.instanceClass.simpleName
	}

	private def pkg(EClass clazz) {
		clazz.instanceClass.package.name
	}

	private def imprt(EClass clazz) {
		clazz.instanceClass.canonicalName
	}

	private def dto(Invariant inv) {
		inv.name + "DTO"
	}

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		val mir = MIRHelper.getMIR(input)
		val pkgName = (mir.generatedPackage + "." + INVARIANT_PKG_NAME)

		// generate Invs
		mir.invariants.forEach [
			fsa.generateFile(
				(pkgName + "." + it.name).packageNameToPath + ".xtend",
				'''
					package «pkgName»;
					
					«it.inferImports»
					
					public class «it.name» {
						«it.inferCheckMethod»
						
						«it.inferFindViolationsMethod»
					}
					
				'''
			)
		]

		// generate DTOs
		mir.invariants.forEach [
			fsa.generateFile(
				(pkgName + "." + it.dto).packageNameToPath + ".xtend",
				'''
					package «pkgName»;
					
					«it.inferImports»
					import java.util.List
					import org.eclipse.xtend.lib.annotations.Data
					
					@Data
					public class «it.dto» {
						«it.context.type» context
						
						«FOR param : it.parameters»
							List<«param.type.type»> «param.name»
						«ENDFOR»
					}
					
				'''
			)
		]
	}

	def String inferImports(Invariant invariant) {
		'''
			import «invariant.context.imprt»
			«FOR param : invariant.parameters»
				import «param.type.imprt»
			«ENDFOR»
		'''
	}

	def String inferCheckMethod(Invariant invariant) {
		'''
			def boolean check(«invariant.context.type» _self) {
				«invariant.expression.toXtend»
			}
		'''
	}

	def String inferFindViolationsMethod(Invariant invariant) {
		'''
			def «invariant.dto» findViolations(«invariant.context.type» _self) {
				var dto = new «invariant.dto»(_self
				«FOR param : invariant.parameters»
					, 
					«invariant.expression.toXtend»
				«ENDFOR»
				)
				
				return dto
			}
		'''
	}

	private def dispatch String toXtend(XUnaryOperation expression) {
		if (expression.feature.simpleName != "operator_not")
			throw new IllegalArgumentException("Unsuited operation for invariants")
		"!" + expression.operand.toXtend
	}

	private def dispatch String toXtend(XMemberFeatureCall expression) {
		val param = new StringBuilder();
		expression.memberCallArguments.forEach[param.append(it.toXtend)]

		expression.memberCallTarget.toXtend + "." + expression.feature.simpleName + "(" + param.toString + ")"
	}

	private def dispatch String toXtend(XFeatureCall expression) {
		val param = new StringBuilder();
		expression.featureCallArguments.forEach[param.append(it.toXtend)]

		expression.feature.simpleName + param.toString
	}

	private def dispatch String toXtend(XClosure expression) {
		val param = new StringBuilder()
		expression.declaredFormalParameters.forEach[param.append(it.name)]
		if (expression.explicitSyntax)
			param.append("|");
		"[" + param.toString + expression.expression.toXtend + "]"
	}

	private def dispatch String toXtend(XBlockExpression expression) {
		if (expression.expressions.size != 1)
			throw new IllegalArgumentException("Unsuited operation for invariants")
		expression.expressions.get(0).toXtend
	}

	private def dispatch String toXtend(XExpression expression) {
		throw new IllegalArgumentException("Unsuited operation for invariants")
	}

	private def XExpression transform(XExpression expression, String param) {
		switch (expression) {
			XUnaryOperation: expression.operand
			// throw new UnsupportedOperationException()
			default: expression
		}
	}

	private def String evaluate(XExpression expression) {
		switch (expression) {
			XMemberFeatureCall: {
				var target = expression.memberCallTarget.evaluate
				var operation = expression.feature.simpleName
				var param = if (expression.feature.simpleName.startsWith("get"))
						""
					else
						(expression.memberCallArguments.get(0) as XClosure).toString
				target + "." + operation + "(" + param + ")";
			}
			XFeatureCall: {
				if (!(expression.feature instanceof JvmFormalParameter))
					throw new UnsupportedOperationException()
				expression.feature.simpleName
			}
			XUnaryOperation: {
				expression.operand.evaluate
// throw new UnsupportedOperationException()
			}
			default:
				throw new UnsupportedOperationException()
		}
	}

}