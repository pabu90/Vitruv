package edu.kit.ipd.sdq.ocl2xocl4inv.handlers;

import edu.kit.ipd.sdq.commons.ecore2txt.handler.AbstractEcore2TxtHandler;
import edu.kit.ipd.sdq.commons.ecore2txt.util.Ecore2TxtUtil;
import edu.kit.ipd.sdq.ocl2xocl4inv.generator.Ocl2Xocl4InvGenerator;
import edu.kit.ipd.sdq.ocl2xocl4inv.generator.Ocl2Xocl4InvGeneratorModule;
import org.eclipse.core.resources.IFile;



public class Ocl2Xocl4InvGeneratorHandler extends AbstractEcore2TxtHandler {

	@Override
	public void executeEcore2TxtGenerator(Iterable<IFile> files) {
		Ocl2Xocl4InvGeneratorModule generatorModule = new Ocl2Xocl4InvGeneratorModule();
		Ocl2Xocl4InvGenerator generator = new Ocl2Xocl4InvGenerator();
		
		Ecore2TxtUtil.generateFromSelectedFilesInFolder(files, generatorModule, generator, "src-gen");
	}
}
