package tools.vitruv.dsls.common.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;

import tools.vitruv.dsls.mapping.ui.internal.MappingActivator;
import tools.vitruv.dsls.response.ui.internal.ResponseActivator;

/**
 * The activator class controls the plug-in life cycle
 */
public class MIRCommonActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "tools.vitruv.dsls.common.ui"; //$NON-NLS-1$

	// The shared instance
	private static MIRCommonActivator plugin;
	
	/**
	 * The constructor
	 */
	public MIRCommonActivator() {
		 mappingInjector = MappingActivator.getInstance().getInjector(MappingActivator.TOOLS_VITRUV_DSLS_MAPPING_MAPPINGLANGUAGE);
		 responseInjector = ResponseActivator.getInstance().getInjector(ResponseActivator.TOOLS_VITRUV_DSLS_RESPONSE_RESPONSELANGUAGE);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static MIRCommonActivator getDefault() {
		return plugin;
	}
	
	final public Injector mappingInjector;
	final public Injector responseInjector;
}
