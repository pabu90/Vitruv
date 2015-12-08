package edu.kit.ipd.sdq.xocl4inv.eval.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;

import com.google.inject.Inject;

/**
 * This class generates all required artifacts for TestGeneratorDSL.
 *
 * @author sfiss
 *
 */
public class XoclEvalDSLGenerator implements IGenerator {

	private JvmModelGenerator jvmModelGenerator;
	private InvariantGenerator invariantGenerator;
	private XbaseOclGenerator xbaseOclGenerator;
	private TransformationGenerator transformationGenerator;

	/**
	 * Constructs default generator.
	 *
	 * @param jvmModelGenerator
	 *            jvmModelGenerator
	 * @param invariantGenerator
	 *            invariantGenerator
	 * @param xbaseOclGenerator
	 *            xbaseOclGenerator
	 * @param transformationGenerator
	 *            transformationGenerator
	 */
	@Inject
	public XoclEvalDSLGenerator(JvmModelGenerator jvmModelGenerator, InvariantGenerator invariantGenerator,
			XbaseOclGenerator xbaseOclGenerator, TransformationGenerator transformationGenerator) {

		this.jvmModelGenerator = jvmModelGenerator;
		this.invariantGenerator = invariantGenerator;
		this.xbaseOclGenerator = xbaseOclGenerator;
		this.transformationGenerator = transformationGenerator;
	}

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		jvmModelGenerator.doGenerate(input, fsa);
		invariantGenerator.doGenerate(input, fsa);
		xbaseOclGenerator.doGenerate(input, fsa);
		transformationGenerator.doGenerate(input, fsa);
	}

}
