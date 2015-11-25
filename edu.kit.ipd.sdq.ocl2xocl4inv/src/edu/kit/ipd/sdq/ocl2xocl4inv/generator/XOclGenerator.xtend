package edu.kit.ipd.sdq.ocl2xocl4inv.generator

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.impl.EPackageImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.ocl.OCL
import org.eclipse.ocl.ecore.Constraint
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

class XOclGenerator implements IGenerator {
		
	override doGenerate(Resource input, IFileSystemAccess fsa) {

		var constraintList = getConstraints(input);
		
		//TODO Transform the constraints

		var fileName = getFileName(input) + ".xocl";
		createXOclFile(fsa, fileName, constraintList);			
	}
	
	
	private def String getFileName(Resource input) {
		var fileURI = input.getURI();
		return fileURI.lastSegment;
	}
	
	
	private def List<Constraint> getConstraints(Resource input) {
		var constraintList = new ArrayList<Constraint>();
		
		//access the classifier elements of the ecore file
		if(input.contents.size == 0) return constraintList;
		
		var data = input.contents.get(0);			
		var packageImpl = data as EPackageImpl;
		var classifierList = packageImpl.EClassifiers
		
		// create an OCL instance for Ecore
		var ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);		
		var helper = ocl.createOCLHelper(); 

		for(classifier : classifierList) {
			for(annotation : classifier.EAnnotations) {
				//if the key is constraints the value is only the name of the constraint
				var list = annotation.details.filter[ !key.equals("constraints") ]
				
				for(annotationDetail : list) {
					helper.setContext(classifier);		// set the OCL context to the classifier
					val invariant = helper.createInvariant(annotationDetail.value);
					invariant.name = annotationDetail.key;
					
					constraintList.add(invariant);
				}
			}
		}
		
		return constraintList;
	}
	
	
	private def void createXOclFile(IFileSystemAccess fsa, String fileName, List<Constraint> constraintList) {
		fsa.generateFile(fileName,
			'''
			«FOR constraint : constraintList»
				«constraint.toString»
			«ENDFOR»	
			'''
		);
	}
	
}