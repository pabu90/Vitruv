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
package edu.kit.ipd.sdq.ocl2xocl4inv.generator

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

/**
* This class generates the xocl file with the transformed invariants.
* 
* @author npaetz
*/
class XOclGenerator implements IGenerator {

 	/**
	 * Start the transformation.
	 *
	 * @param input Resource
	 * @param fsa IFileSystemAccess
	 */
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		var imports = new ArrayList<String>();
		var constraints = new ArrayList<String>();
		
		var oclInvariantExtractor = new OclInvariantExtractor();
		oclInvariantExtractor.getConstraints(input, constraints, imports);
		
		var fileName = getFileName(input) + ".xocl";
		createXOclFile(fsa, fileName, constraints, imports);
	}

 	/**
	 * Get the file name.
	 *
	 * @param input Resource
	 * @returns filename as string
	 */
	private def String getFileName(Resource input) {
		var fileURI = input.getURI();
		var filename =  fileURI.lastSegment;
		
		if (filename.indexOf(".") > 0) {
			filename = filename.substring(0, filename.lastIndexOf("."));
		}
		
		return filename;
	}

	 /**
	 * Create the xocl file.
	 * @param fsa IFileSystemAccess
	 * @param fileName String
	 * @param constraints List<String>
	 * @param imports List<String>
	 */
	private def void createXOclFile(IFileSystemAccess fsa, String fileName, List<String> constraints, List<String> imports) {
		fsa.generateFile(
			fileName,
			'''
				«FOR imp : imports»«imp»«ENDFOR»
				 
				«FOR constraint : constraints»«constraint»«ENDFOR»'''
		);
	}
}