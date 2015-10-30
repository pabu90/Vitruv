/*******************************************************************************
* Copyright (c) 2015 Sebastian Fiss.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Sebastian Fiss - initial API and implementation and/or initial documentation
*******************************************************************************/
package edu.kit.ipd.sdq.xocl4inv.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;

import com.google.inject.Inject;

/**
 * This class generates all required artifacts for XOcl4Inv.
 *
 * @author sfiss
 *
 */
public class XOcl4InvGenerator implements IGenerator {

	private JvmModelGenerator jvmModelGenerator;
	private InvariantGenerator invariantGenerator;

	/**
	 * Constructs default generator.
	 *
	 * @param jvmModelGenerator
	 *            jvmModelGenerator
	 * @param invariantGenerator
	 *            invariantGenerator
	 */
	@Inject
	public XOcl4InvGenerator(JvmModelGenerator jvmModelGenerator, InvariantGenerator invariantGenerator) {

		this.jvmModelGenerator = jvmModelGenerator;
		this.invariantGenerator = invariantGenerator;
	}

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		jvmModelGenerator.doGenerate(input, fsa);
		invariantGenerator.doGenerate(input, fsa);
	}

}
