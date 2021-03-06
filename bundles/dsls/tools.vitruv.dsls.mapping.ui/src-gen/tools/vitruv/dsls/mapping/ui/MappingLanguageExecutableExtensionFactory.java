/*
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.mapping.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import tools.vitruv.dsls.mapping.ui.internal.MappingActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MappingLanguageExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return MappingActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return MappingActivator.getInstance().getInjector(MappingActivator.TOOLS_VITRUV_DSLS_MAPPING_MAPPINGLANGUAGE);
	}
	
}
