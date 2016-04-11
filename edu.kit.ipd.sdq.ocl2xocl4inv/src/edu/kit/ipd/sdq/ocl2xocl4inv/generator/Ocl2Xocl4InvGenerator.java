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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

/**
* This class starts the transformation.
* 
* @author npaetz
*/
public class Ocl2Xocl4InvGenerator implements IGenerator {

	private XOclGenerator xoclGenerator;

 	/**
	 * Constructs default generator.
	 *
	 */
	public Ocl2Xocl4InvGenerator() {
		this.xoclGenerator = new XOclGenerator();
	}
	
 	/**
	 * Start the transformation.
	 *
	 * @param input
	 *            Resource
	 * @param fsa
	 *            IFileSystemAccess
	 */
	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		xoclGenerator.doGenerate(input, fsa);
	}
}
