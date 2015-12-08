package edu.kit.ipd.sdq.xocl4inv.eval;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class XoclEvalDSLStandaloneSetup extends XoclEvalDSLStandaloneSetupGenerated {

	/**
	 * 
	 */
	public static void doSetup() {
		new XoclEvalDSLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
