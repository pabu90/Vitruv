package edu.kit.ipd.sdq.xocl4inv.eval.scoping

import com.google.inject.Inject
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.Import
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.XoclEvalDSLPackage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider

class ScopeProviderDelegate extends XImportSectionNamespaceScopeProvider {
	@Inject
	QualifiedNameProvider qualifiedNameProvider;

	override getScope(EObject context, EReference reference) {
		if(reference.getEType.equals(EcorePackage.eINSTANCE.getEClass))
			return createQualifiedEClassScope(context.eResource)
		else if(reference.getEType.equals(
			EcorePackage.eINSTANCE.getEClassifier))
			return createQualifiedEClassifierScope(context.eResource)

		super.getScope(context, reference)
	}

	/**
	 * Returns all elements with the given EClass inside the Resource res.
	 */
	def getAllContentsOfEClass(Resource res, EClass namedParent,
		boolean allContents) {
		var contents = if(allContents)
				res.allContents.toList
			else
				res.contents

		return contents.filter[eClass.equals(namedParent)]

	}

	/**
	 * Returns all packages that have been imported by import statements
	 * in the given resource.
	 */
	def getImports(Resource res) {
		var contents = res.getAllContentsOfEClass(
			XoclEvalDSLPackage.eINSTANCE.import, true).toList
		return contents.map [
			if(it != null) {
				val import = it as Import
				if(import.name != null)
					return import
				else
					return null
			} else
				return null
		].filterNull
	}

	/**
	 * Creates and returns a {@link EObjectDescription} with a
	 * qualified name that also includes the name of the given
	 * {@link Import}.
	 */
	def createEObjectDescription(EClassifier classifier, Import imp) {
		return if(classifier == null)
			null
		else
			EObjectDescription.create(
				QualifiedName.create(imp.name).append(
					qualifiedNameProvider.getFullyQualifiedName(classifier).
						skipFirst(1)),
				classifier
			)
	}

	/**
	 * Create an {@link IScope} that represents all {@link EClassifier}s
	 * that are referencable inside the {@link Resource} via {@link Import}s
	 * by a fully qualified name.
	 */
	def createQualifiedEClassifierScope(Resource res) {
		val classifierDescriptions = res.imports.map [ import |
			import.package.EClassifiers.map[it.createEObjectDescription(import)]
		].flatten

		var resultScope = new SimpleScope(IScope.NULLSCOPE,
			classifierDescriptions)
		return resultScope
	}

	/**
	 * Create an {@link IScope} that represents all {@link EClass}es
	 * that are referencable inside the {@link Resource} via {@link Import}s
	 * by a fully qualified name.
	 * 
	 * @see MIRScopeProviderDelegate#createQualifiedEClassifierScope(Resource)
	 */
	def createQualifiedEClassScope(Resource res) {
		val classifierDescriptions = res.imports.map [ import |
			import.package.EClassifiers.filter(EClass).map [
				it.createEObjectDescription(import)
			]
		].flatten

		var resultScope = new SimpleScope(IScope.NULLSCOPE,
			classifierDescriptions)
		return resultScope
	}
}