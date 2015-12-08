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
package edu.kit.ipd.sdq.xocl4inv.scoping

import edu.kit.ipd.sdq.xocl4inv.extensions.OclCollectionExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.OclFunctionExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.OclIterateExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.PureIterableExtensions
import java.util.List
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures

/**
 * @author sfiss
 */
public class ExtensionProvider extends ImplicitlyImportedFeatures {
	protected def override List<Class<?>> getExtensionClasses() {
		// provide own IterableExtensions that are marked pure .filter[it != IterableExtensions]
		(super.extensionClasses.filter[it != IterableExtensions] +
			#[PureIterableExtensions, OclIterateExtensions,
				OclFunctionExtensions, OclCollectionExtensions]).toList
		}

		protected def override List<Class<?>> getStaticImportClasses() {
			// provide own IterableExtensions that are marked pure .filter[it != IterableExtensions]
			(super.staticImportClasses.filter[it != IterableExtensions] +
				#[PureIterableExtensions, OclIterateExtensions,
					OclFunctionExtensions, OclCollectionExtensions]).toList
			}
		}