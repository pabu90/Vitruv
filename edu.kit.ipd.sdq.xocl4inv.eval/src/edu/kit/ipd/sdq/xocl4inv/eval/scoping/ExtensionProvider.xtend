package edu.kit.ipd.sdq.xocl4inv.eval.scoping

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
			#[PureIterableExtensions, OclIterateExtensions, OclFunctionExtensions, OclCollectionExtensions]).toList
		}

		protected def override List<Class<?>> getStaticImportClasses() {
			// provide own IterableExtensions that are marked pure .filter[it != IterableExtensions]
			(super.staticImportClasses.filter[it != IterableExtensions] +
				#[PureIterableExtensions, OclIterateExtensions, OclFunctionExtensions, OclCollectionExtensions]).toList
			}
		}