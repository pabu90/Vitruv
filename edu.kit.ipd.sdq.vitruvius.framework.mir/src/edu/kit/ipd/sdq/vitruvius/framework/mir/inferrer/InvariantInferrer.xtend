package edu.kit.ipd.sdq.vitruvius.framework.mir.inferrer

import com.google.inject.Inject
import edu.kit.ipd.sdq.vitruvius.framework.mir.mIR.Invariant
import org.eclipse.xtext.xbase.XExpression

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
	
	def convert(XExpression expression, String param){
		// transform expression
		var transformed = expression
		
		// evaluate expression and convert to string
		var result = transformed.toString()
		return result;
	}

}
