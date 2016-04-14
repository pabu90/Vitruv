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

 /**
 * This class extracts the constraints from an ecore file.
 * 
 * @author npaetz
 */
class OclInvariantExtractor {

	private int modelCount = 1;

 	/**
	 * Get the constraints from an ecore file.
	 * @param input Resource
	 * @param constraintList List<String>
	 * @param importList List<String>
	 */
	public def void getConstraints(Resource input, List<String> constraintList, List<String> importList) {
		if(input.contents.size == 0) return;

		// access the root package element of the ecore file
		var data = input.contents.get(0);
		var package = data as EPackage;

		if(package == null) return;

		// create the ocl helper to parse the ocl invariants from string
		var ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		var oclHelper = ocl.createOCLHelper();

		createInvariantsFromPackage(constraintList, importList, oclHelper, package);
	}
	
 	/**
	 * Create the xocl4inv invariants for a specific epackage.
	 * @param constraintList List<String>
	 * @param importList List<String>
	 * @param oclHelper OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint>
	 * @param ePackage EPackage
	 */
	private def void createInvariantsFromPackage(List<String> constraintList, List<String> importList, OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> oclHelper, EPackage ePackage) {
		var classifierList = ePackage.EClassifiers
		var constraints = new ArrayList<Constraint>();

		for (classifier : classifierList) {
			checkClassifierForConstraints(constraints, oclHelper, classifier);
		}
		
		if(constraints.size != 0) {
			//create imports and xocl invariants			
			importList.add(
				'''
					import "«ePackage.nsURI»" as mdl«modelCount»
					''')
			
			for (constraint : constraints) {
				constraintList.add(
				'''
					invariant «constraint.name» ()
					context mdl«modelCount».«constraint.specification.contextVariable.type.name»
					check «XOclTransformer.getExpression(constraint)»
					 
					''')
			}	
			
			modelCount++;
		}
		
		//check the subpackages
		var subpackages = ePackage.ESubpackages;
		for (packageItem : subpackages) {
			createInvariantsFromPackage(constraintList, importList, oclHelper, packageItem);
		}		
	}
	
	 /**
	 * Checks the eClassifier element for constraints.
	 * @param constraintList List<String>
	 * @param importList List<String>
	 * @param oclHelper OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint>
	 * @param eClassifier EClassifier
	 */
	private def void checkClassifierForConstraints(List<Constraint> constraintList, OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> oclHelper, EClassifier eClassifier) {
		// the names of the constraints are listed in an annotation with the key "constraints" (the names are sperated with a whitespace)
		var annotationWithConstraintNames = eClassifier.EAnnotations.findFirst [ annotation | annotation.details.get("constraints") != null ]
		if(annotationWithConstraintNames == null) return;

		var invariantNames = annotationWithConstraintNames.details.get("constraints");

		for (annotation : eClassifier.EAnnotations) {
			// iterate through the annotations and look for the constraint names as keys			
			for (annotationDetail : annotation.details) {
				if (annotationDetail.key == null || invariantNames.contains(annotationDetail.key)) {
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
}