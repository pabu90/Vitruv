package edu.kit.ipd.sdq.xocl4inv.eval.linking

import com.google.inject.Inject
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.Import
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.XoclEvalDSLPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode

class LinkingService extends DefaultLinkingService {

	@Inject
	private IValueConverterService valueConverterService;

	override getLinkedObjects(EObject context, EReference ref,
		INode node) throws IllegalNodeException {
		if(ref == XoclEvalDSLPackage.eINSTANCE.import_Package &&
			context instanceof Import) {
			var text = node as ILeafNode
			var ns = valueConverterService.toValue(text.getText(),
				getLinkingHelper().getRuleNameFrom(text.getGrammarElement()),
				text) as String;
				var package = EPackage.Registry.INSTANCE.
					getEPackage(ns) as EObject

				return #[package]
			}
			super.getLinkedObjects(context, ref, node)
		}

	}