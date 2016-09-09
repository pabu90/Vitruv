/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.mapping.mappingLanguage;

import org.eclipse.emf.common.util.EList;

import tools.vitruv.dsls.mirbase.mirBase.MetamodelImport;
import tools.vitruv.dsls.mirbase.mirBase.MirBaseFile;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.mapping.mappingLanguage.MappingFile#getImports <em>Imports</em>}</li>
 *   <li>{@link tools.vitruv.dsls.mapping.mappingLanguage.MappingFile#getMappings <em>Mappings</em>}</li>
 *   <li>{@link tools.vitruv.dsls.mapping.mappingLanguage.MappingFile#getDefaultRequirements <em>Default Requirements</em>}</li>
 * </ul>
 *
 * @see tools.vitruv.dsls.mapping.mappingLanguage.MappingLanguagePackage#getMappingFile()
 * @model
 * @generated
 */
public interface MappingFile extends MirBaseFile
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link tools.vitruv.dsls.mirbase.mirBase.MetamodelImport}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see tools.vitruv.dsls.mapping.mappingLanguage.MappingLanguagePackage#getMappingFile_Imports()
   * @model containment="true"
   * @generated
   */
  EList<MetamodelImport> getImports();

  /**
   * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
   * The list contents are of type {@link tools.vitruv.dsls.mapping.mappingLanguage.Mapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mappings</em>' containment reference list.
   * @see tools.vitruv.dsls.mapping.mappingLanguage.MappingLanguagePackage#getMappingFile_Mappings()
   * @model containment="true"
   * @generated
   */
  EList<Mapping> getMappings();

  /**
   * Returns the value of the '<em><b>Default Requirements</b></em>' containment reference list.
   * The list contents are of type {@link tools.vitruv.dsls.mapping.mappingLanguage.RequiredMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Requirements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Requirements</em>' containment reference list.
   * @see tools.vitruv.dsls.mapping.mappingLanguage.MappingLanguagePackage#getMappingFile_DefaultRequirements()
   * @model containment="true"
   * @generated
   */
  EList<RequiredMapping> getDefaultRequirements();

} // MappingFile
