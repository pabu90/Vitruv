package edu.kit.ipd.sdq.ocl2xocl4inv.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

public class Ocl2Xocl4InvGenerator implements IGenerator {

	private XOclGenerator xoclGenerator;

	public Ocl2Xocl4InvGenerator() {
		this.xoclGenerator = new XOclGenerator();
	}
	
	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		xoclGenerator.doGenerate(input, fsa);
	}
}
