package edu.kit.ipd.sdq.ocl2xocl4inv.generator

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.ocl.OCL
import org.eclipse.ocl.ecore.Constraint
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory
import org.eclipse.ocl.helper.OCLHelper

class OclInvariantExtractor {

	public def List<Constraint> getConstraints(Resource input) {
		var constraintList = new ArrayList<Constraint>();

		if(input.contents.size == 0) return constraintList;

		// access the root package element of the ecore file
		var data = input.contents.get(0);
		var package = data as EPackage;

		if(package == null) return constraintList;

		// create the ocl helper to parse the ocl invariants from string
		var ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		var oclHelper = ocl.createOCLHelper();

		checkPackageForConstraints(constraintList, oclHelper, package);

		return constraintList;
	}
	
	
	private def void checkPackageForConstraints(List<Constraint> constraintList, OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> oclHelper, EPackage ePackage) {
		var classifierList = ePackage.EClassifiers

		for (classifier : classifierList) {
			checkClassifierForDefaultConstraintStyle(constraintList, oclHelper, classifier);
			checkClassifierForOperationConstraintStyle(constraintList, oclHelper, classifier);
		}
		
		//check the subpackages
		var subpackages = ePackage.ESubpackages;
		for (packageItem : subpackages) {
			checkPackageForConstraints(constraintList, oclHelper, packageItem);
		}		
	}
	
	
		
	private def void checkClassifierForDefaultConstraintStyle(List<Constraint> constraintList, OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> oclHelper, EClassifier eClassifier) {
		// the names of the constraints are listed in an annotation with the key "constraints" (the names are sperated with a whitespace)
		var annotationWithConstraintNames = eClassifier.EAnnotations.findFirst [ annotation | annotation.details.get("constraints") != null ]
		if(annotationWithConstraintNames == null) return;

		var invariantNames = annotationWithConstraintNames.details.get("constraints");

		for (annotation : eClassifier.EAnnotations) {
			// iterate through the annotations and look for the constraint names as keys			
			for (annotationDetail : annotation.details) {
				if (invariantNames.contains(annotationDetail.key)) {
					try {
						oclHelper.setContext(eClassifier); // set the OCL context to the classifier
						val invariant = oclHelper.createInvariant(annotationDetail.value);
						invariant.name = annotationDetail.key;

						constraintList.add(invariant);
					} catch (Exception ex) {
						System.out.println(ex);
					}
				}
			}
		}
	}
	
	private def void checkClassifierForOperationConstraintStyle(List<Constraint> constraintList, OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> oclHelper, EClassifier eClassifier) {
		// the invariants are in an annotation with the key "body" in the eOperations. The invariant name is the name of the operation
		if (eClassifier instanceof EClass) {
			var eObject = eClassifier as EClass;
			var operations = eObject.EAllOperations;

			for (operation : operations) {
				var annotationWithConstraint = operation.EAnnotations.findFirst [ annotation | annotation.details.get("body") != null ]
				if(annotationWithConstraint == null) return;

				var constraintString = annotationWithConstraint.details.get("body");

				try {
					oclHelper.setContext(eClassifier); // set the OCL context to the classifier
					val invariant = oclHelper.createInvariant(constraintString);
					invariant.name = operation.name;

					constraintList.add(invariant);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		}
	}
}