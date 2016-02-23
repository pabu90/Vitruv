package edu.kit.ipd.sdq.ocl2xocl4inv.generator

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

class XOclGenerator implements IGenerator {

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		var imports = new ArrayList<String>();
		var constraints = new ArrayList<String>();
		
		var oclInvariantExtractor = new OclInvariantExtractor();
		oclInvariantExtractor.getConstraints(input, constraints, imports);
		
		var fileName = getFileName(input) + ".xocl";
		createXOclFile(fsa, fileName, constraints, imports);
	}

	private def String getFileName(Resource input) {
		var fileURI = input.getURI();
		var filename =  fileURI.lastSegment;
		
		if (filename.indexOf(".") > 0) {
			filename = filename.substring(0, filename.lastIndexOf("."));
		}
		
		return filename;
	}

	private def void createXOclFile(IFileSystemAccess fsa, String fileName, List<String> constraints, List<String> imports) {
		fsa.generateFile(
			fileName,
			'''
				«FOR imp : imports»«imp»«ENDFOR»
				 
				«FOR constraint : constraints»«constraint»«ENDFOR»'''
		);
	}
}