package edu.kit.ipd.sdq.vitruvius.framework.mir.generator

import edu.kit.ipd.sdq.vitruvius.framework.mir.helpers.MIRHelper
import edu.kit.ipd.sdq.vitruvius.framework.mir.mIR.Invariant
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.XIfExpression

class MIRInvariantGenerator implements IGenerator {

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
		val pkgName = (mir.generatedPackage + "." + MIRCodeGenerator.INV_PKG_NAME)

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

	private def String featureName(JvmIdentifiableElement feature) {
		switch (feature) {
			JvmOperation:
				if (feature.simpleName == "operator_not")
					"!"
				else if (feature.simpleName == "operator_equals")
					" == "
				else if (feature.simpleName == "operator_notEquals")
					" != "
				else if (feature.simpleName == "operator_lessThan")
					" < "
				else if (feature.simpleName == "operator_lessEqualsThan")
					" <= "
				else if (feature.simpleName == "operator_greaterThan")
					" > "
				else if (feature.simpleName == "operator_greaterEqualsThan")
					" >= "
				else if (feature.simpleName == "operator_and")
					" && "
				else if (feature.simpleName == "operator_or")
					" || "
				else
					feature.simpleName
			default:
				feature.simpleName
		}
	}

	private def dispatch String toXtend(XUnaryOperation expression) {
		if (expression.feature.simpleName != "operator_not")
			throw new IllegalArgumentException("Unsuited operation for invariants")
		"!" + expression.operand.toXtend
	}

	private def dispatch String toXtend(XBinaryOperation expression) {
		expression.leftOperand.toXtend + expression.feature.featureName + expression.rightOperand.toXtend
	}

	private def dispatch String toXtend(XMemberFeatureCall expression) {
		val param = new StringBuilder();
		expression.memberCallArguments.forEach[param.append(it.toXtend)]

		expression.memberCallTarget.toXtend + "." + expression.feature.featureName + "(" + param.toString + ")"
	}

	private def dispatch String toXtend(XFeatureCall expression) {
		val param = new StringBuilder();
		expression.featureCallArguments.forEach[param.append(it.toXtend)]

		expression.feature.featureName + param.toString
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

	private def dispatch String toXtend(XNullLiteral expression) {
		"null"
	}

	private def dispatch String toXtend(XBooleanLiteral expression) {
		if(expression.isIsTrue) "true" else "false"
	}

	private def dispatch String toXtend(XStringLiteral expression) {
		"\"" + expression.value + "\""
	}

	private def dispatch String toXtend(XNumberLiteral expression) {
		expression.value
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

}