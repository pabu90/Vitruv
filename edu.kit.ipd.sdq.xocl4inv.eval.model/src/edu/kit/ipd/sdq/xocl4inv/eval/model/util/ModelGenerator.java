package edu.kit.ipd.sdq.xocl4inv.eval.model.util;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage;

public class ModelGenerator {
	public static ModelGenerator instance = new ModelGenerator();

	public Map<EClass, Set<? extends EObject>> extents = new HashMap<EClass, Set<? extends EObject>>();

	public EObject model;

	protected ModelGenerator() {
		try {
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;

			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put("xmi", new XMIResourceFactoryImpl());

			ResourceSet resSet = new ResourceSetImpl();
			Map<String, Object> packageRegistry = resSet.getPackageRegistry();
			packageRegistry.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);

			Resource resource = resSet.getResource(URI.createURI("model.xmi"), true);
			resource.load(Collections.EMPTY_MAP);
			model = resource.getContents().get(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
