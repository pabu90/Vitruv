/*******************************************************************************
 * Copyright (c) 2015 Nicolas Pätzold.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Pätzold - initial API and implementation and/or initial documentation
 *******************************************************************************/
package edu.kit.ipd.sdq.ocl2xocl4inv.handlers;

import edu.kit.ipd.sdq.commons.ecore2txt.handler.AbstractEcore2TxtHandler;
import edu.kit.ipd.sdq.commons.ecore2txt.util.Ecore2TxtUtil;
import edu.kit.ipd.sdq.ocl2xocl4inv.generator.Ocl2Xocl4InvGenerator;
import edu.kit.ipd.sdq.ocl2xocl4inv.generator.Ocl2Xocl4InvGeneratorModule;
import org.eclipse.core.resources.IFile;


/**
* This class is the handler class for the package explorer menu extension.
* 
* @author npaetz
*/
public class Ocl2Xocl4InvGeneratorHandler extends AbstractEcore2TxtHandler {

 	/**
	 * Executes the transformation for the selected files.
	 *
	 * @param files Iterable<IFile>
	 */
	@Override
	public void executeEcore2TxtGenerator(Iterable<IFile> files) {
		Ocl2Xocl4InvGeneratorModule generatorModule = new Ocl2Xocl4InvGeneratorModule();
		Ocl2Xocl4InvGenerator generator = new Ocl2Xocl4InvGenerator();
		
		Ecore2TxtUtil.generateFromSelectedFilesInFolder(files, generatorModule, generator, "src-gen");
	}
}
