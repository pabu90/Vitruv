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
package edu.kit.ipd.sdq.xocl4inv;

import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures;

import com.google.inject.Binder;
import com.google.inject.name.Names;

import edu.kit.ipd.sdq.xocl4inv.generator.InvariantGenerator;
import edu.kit.ipd.sdq.xocl4inv.generator.XOcl4InvGenerator;
import edu.kit.ipd.sdq.xocl4inv.linking.LinkingService;
import edu.kit.ipd.sdq.xocl4inv.scoping.ExtensionProvider;
import edu.kit.ipd.sdq.xocl4inv.scoping.ScopeProviderDelegate;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class XOcl4InvRuntimeModule extends edu.kit.ipd.sdq.xocl4inv.AbstractXOcl4InvRuntimeModule {
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return LinkingService.class;
	}

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class)
				.annotatedWith(
						Names.named(org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
				.to(ScopeProviderDelegate.class);
	}

	@Override
	public Class<? extends IGenerator> bindIGenerator() {
		return XOcl4InvGenerator.class;
	}

	/**
	 *
	 * @return binding
	 */
	public Class<? extends ImplicitlyImportedFeatures> bindImplicitlyImportedFeatures() {
		return ExtensionProvider.class;
	}

	/**
	 *
	 * @return binding
	 */
	@SuppressWarnings("unused")
	private Class<? extends InvariantGenerator> bindInvariantGenerator() {
		return InvariantGenerator.class;
	}
}
