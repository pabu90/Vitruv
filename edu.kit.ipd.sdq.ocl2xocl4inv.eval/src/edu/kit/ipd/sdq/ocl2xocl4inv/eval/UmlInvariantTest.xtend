package edu.kit.ipd.sdq.ocl2xocl4inv.eval

import edu.kit.ipd.sdq.ocl2xocl4inv.generator.XOclTransformer
import edu.kit.ipd.sdq.xocl4inv.ui.internal.XOcl4InvActivator
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.ArrayList
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.ocl.OCL
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory
import org.eclipse.uml2.uml.UMLPackage
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
import org.junit.Test

class UmlInvariantTest {
	
	@Test
	def void Uml_Invariant_Transformation_Test() {
		var lines = new ArrayList<String>();

		var path = Paths.get("src/edu/kit/ipd/sdq/ocl2xocl4inv/eval/umlInvariants.txt");
		var inputLines = Files.readAllLines(path);
				
		val ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		val oclHelper = ocl.createOCLHelper();
		
		for(inputLine : inputLines) {
			if(!inputLine.empty) {
				if(inputLine.startsWith("class ")) {
					var relevantPart = inputLine.replaceFirst("class ", "");

					try {
						//cheapest way to retrieve the eClass to set the context of the ocl helper
						var context = "get" + relevantPart;
					  	context = context.replaceAll("\\s","")	//remove possible whitespaces
					  	var method = UMLPackage.eINSTANCE.getClass().getMethod(context);
					  	var obj = method.invoke(UMLPackage.eINSTANCE);
					  	var eclass = obj as EClass;
					  
					  	oclHelper.setContext(eclass);
					  	lines.add("//The context is set to class: " + relevantPart + "\r\n");
					} catch (Exception exp) {
					  	lines.add("//Error while setting context. Exception type: " +exp.class.toString + "; Message: " + exp.message + "\r\n");
					}		
				}
				else if(inputLine.startsWith("invariant ")) {
					lines.add("//" + inputLine);
				}
				else {	
					try {
						//generate the ocl ast
						val invariant = oclHelper.createInvariant(inputLine);
						val specification = invariant.getSpecification(); 	// type ExpressionInOCL (contains bodyExpression and contextVariable)
						val expression = specification.getBodyExpression(); // type OCLExpression -> the root element of the OCL AST
					
						var expressionString = ""
						try {
							//do the transformation
		        			expressionString = XOclTransformer.createXOclInvariant(expression);
						}
						catch (Exception exp) {
							lines.add("//Error while transforming. Exception type: " + exp.class.toString + "; Message: " + exp.message + "\r\n");
						}

		        		lines.add("Original:  " + inputLine);
		        		lines.add("Generated: " + expressionString);
		        		lines.add("\r\n");
					}						
					catch (Exception exp) {
						lines.add("//Error while parsing. Exception type: " +exp.class.toString + "; Message: " + exp.message + "\r\n");
					}	
				}	
			} 
		}
		
		var filePath = Paths.get("src/edu/kit/ipd/sdq/ocl2xocl4inv/eval/umlXOclInvariants.txt");
		Files.write(filePath, lines, Charset.forName("UTF-8"));
  	}
	
	@Test
	def void Uml_Invariant_Transformation_Generation_Test() {
		//run the test as plug-in test
		//get the injector for the xocl4inv project
        var activator = XOcl4InvActivator.getInstance();
        var injector = activator.getInjector(XOcl4InvActivator.EDU_KIT_IPD_SDQ_XOCL4INV_XOCL4INV);
        
        val proj = ResourcesPlugin.workspace.root.getProject("edu.kit.ipd.sdq.ocl2xocl4inv");
        var rsProvider = injector.getInstance(typeof(IResourceSetProvider));
        val resourceSet = rsProvider.get(proj);
        
        var file = new File("src/edu/kit/ipd/sdq/ocl2xocl4inv/eval/invariants.xocl");

		var fileURI = URI.createFileURI(file.getAbsolutePath());
		var resource = resourceSet.getResource(fileURI, true);
		
        var generator = injector.getInstance(typeof(IGenerator));
        var javaFileSystemAccess = new JavaIoFileSystemAccess();
        javaFileSystemAccess.outputPath = "src/edu/kit/ipd/sdq/ocl2xocl4inv/eval/";
        
        // without this injection the fsa would not provide the encoding
        injector.injectMembers(javaFileSystemAccess);
   
		var jvmma = injector.getInstance(typeof(JvmModelAssociator))
		jvmma.discardDerivedState(resource as DerivedStateAwareResource)
		EcoreUtil2.resolveAll(resource);
		jvmma.installDerivedState(resource as DerivedStateAwareResource, false)
		
		//TODO: the generation is not working yet. There are problems to use the build in generator to create xocl code
        generator.doGenerate(resource, javaFileSystemAccess);
	}
}