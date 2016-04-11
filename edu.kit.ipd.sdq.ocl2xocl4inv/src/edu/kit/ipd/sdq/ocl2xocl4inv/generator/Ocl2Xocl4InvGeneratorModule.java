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
package edu.kit.ipd.sdq.ocl2xocl4inv.generator;

import edu.kit.ipd.sdq.commons.ecore2txt.generator.AbstractEcore2TxtGeneratorModule;


/**
* This class contains information for the generator module.
* 
* @author npaetz
*/
public class Ocl2Xocl4InvGeneratorModule extends AbstractEcore2TxtGeneratorModule {

 	/**
	 * Get the language name.
	 * @returns language name as string
	 */
	@Override
	protected String getLanguageName() {
		return "";
	}
	
 	/**
	 * Get the file extension.
	 * @returns file extension as string
	 */
	@Override
	protected String getFileExtensions() {
		return "ecore";
	}
}
