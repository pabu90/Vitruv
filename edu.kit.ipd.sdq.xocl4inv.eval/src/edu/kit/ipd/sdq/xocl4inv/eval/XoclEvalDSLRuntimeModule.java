package edu.kit.ipd.sdq.xocl4inv.eval;

import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures;

import com.google.inject.Binder;
import com.google.inject.name.Names;

import edu.kit.ipd.sdq.xocl4inv.eval.generator.InvariantGenerator;
import edu.kit.ipd.sdq.xocl4inv.eval.generator.TransformationGenerator;
import edu.kit.ipd.sdq.xocl4inv.eval.generator.XbaseOclGenerator;
import edu.kit.ipd.sdq.xocl4inv.eval.generator.XoclEvalDSLGenerator;
import edu.kit.ipd.sdq.xocl4inv.eval.linking.LinkingService;
import edu.kit.ipd.sdq.xocl4inv.eval.scoping.ExtensionProvider;
import edu.kit.ipd.sdq.xocl4inv.eval.scoping.ScopeProviderDelegate;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class XoclEvalDSLRuntimeModule extends AbstractXoclEvalDSLRuntimeModule {
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return LinkingService.class;
	}

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class)
				.annotatedWith(
						Names.named(org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
				.to(ScopeProviderDelegate.class);
	}

	@Override
	public Class<? extends IGenerator> bindIGenerator() {
		return XoclEvalDSLGenerator.class;
	}

	/**
	 *
	 * @return binding
	 */
	public Class<? extends ImplicitlyImportedFeatures> bindImplicitlyImportedFeatures() {
		return ExtensionProvider.class;
	}

	/**
	 *
	 * @return binding
	 */
	@SuppressWarnings("unused")
	private Class<? extends InvariantGenerator> bindInvariantGenerator() {
		return InvariantGenerator.class;
	}

	/**
	 *
	 * @return binding
	 */
	@SuppressWarnings("unused")
	private Class<? extends XbaseOclGenerator> bindXbaseOclGenerator() {
		return XbaseOclGenerator.class;
	}

	/**
	 *
	 * @return binding
	 */
	@SuppressWarnings("unused")
	private Class<? extends TransformationGenerator> bindTransformationGenerator() {
		return TransformationGenerator.class;
	}
}
