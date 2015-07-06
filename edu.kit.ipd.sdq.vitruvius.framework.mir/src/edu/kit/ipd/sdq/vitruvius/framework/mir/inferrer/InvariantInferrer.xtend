package edu.kit.ipd.sdq.vitruvius.framework.mir.inferrer

import com.google.inject.Inject
import edu.kit.ipd.sdq.vitruvius.framework.mir.mIR.Invariant
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.xbase.XClosure

class InvariantInferrer implements InvariantInferrerProviding {
	/** 
	 * used to get closures to append to for an XExpression. 
	 */
	@Inject ClosureProvider closureProvider

	override void infer(Invariant inv) {
		var TreeAppendableClosure invariantClosure = closureProvider.getInvariantClosure(inv)

		// build DTO
		invariantClosure.addCode('''
			«inv.name»DTO dto = new «inv.name»DTO();
		''')

		invariantClosure.addCode('''
			dto.setContext(self);
		''')

		invariantClosure.addCode('''
			«FOR param : inv.parameters»
				«var value = convert(inv.expression, param.name)»
				dto.set«param.name.toFirstUpper»(«value»);
			«ENDFOR»
		''')

		invariantClosure.addCode("return dto;")

	// analyse expression
	// (Unary or MemberFeatureCall or FeatureCall)
	// MemberFeatureCall.memberCallTarget , .callArguments.data[0] (closure) , .feature == JvmOperation ListExtension, IterableExtension, someMethod (leading to MemberFeatureCall), formalParameter self
	// if (expression != null)
	// invariantClosure.addCode("/* Expression */" + expression.toString());
	// invariantClosure.addCode("throw new UnsupportedOperationException();")
	}

	def convert(XExpression expression, String param) {
		// transform expression
		var transformed = expression.transform(param)
		
		// evaluate expression and convert to string
		var result = transformed.evaluate

		return result;
	}
	
	def XExpression transform(XExpression expression, String param){
		switch (expression) {
			XUnaryOperation: expression.operand
			// throw new UnsupportedOperationException()
			default: expression
		}
	}

	def String evaluate(XExpression expression) {
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
