/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.mirbase.mirBase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.mirbase.mirBase.MirBaseFile#getMetamodelImports <em>Metamodel Imports</em>}</li>
 * </ul>
 *
 * @see tools.vitruv.dsls.mirbase.mirBase.MirBasePackage#getMirBaseFile()
 * @model
 * @generated
 */
public interface MirBaseFile extends EObject
{
  /**
   * Returns the value of the '<em><b>Metamodel Imports</b></em>' containment reference list.
   * The list contents are of type {@link tools.vitruv.dsls.mirbase.mirBase.MetamodelImport}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel Imports</em>' containment reference list.
   * @see tools.vitruv.dsls.mirbase.mirBase.MirBasePackage#getMirBaseFile_MetamodelImports()
   * @model containment="true"
   * @generated
   */
  EList<MetamodelImport> getMetamodelImports();

} // MirBaseFile
