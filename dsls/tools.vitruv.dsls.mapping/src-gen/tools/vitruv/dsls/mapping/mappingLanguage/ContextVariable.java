/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.mapping.mappingLanguage;

import org.eclipse.emf.ecore.EObject;

import tools.vitruv.dsls.mirbase.mirBase.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.mapping.mappingLanguage.ContextVariable#getRequiredMappingPath <em>Required Mapping Path</em>}</li>
 *   <li>{@link tools.vitruv.dsls.mapping.mappingLanguage.ContextVariable#getTargetClass <em>Target Class</em>}</li>
 * </ul>
 *
 * @see tools.vitruv.dsls.mapping.mappingLanguage.MappingLanguagePackage#getContextVariable()
 * @model
 * @generated
 */
public interface ContextVariable extends EObject
{
  /**
   * Returns the value of the '<em><b>Required Mapping Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Mapping Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Mapping Path</em>' containment reference.
   * @see #setRequiredMappingPath(RequiredMappingPathBase)
   * @see tools.vitruv.dsls.mapping.mappingLanguage.MappingLanguagePackage#getContextVariable_RequiredMappingPath()
   * @model containment="true"
   * @generated
   */
  RequiredMappingPathBase getRequiredMappingPath();

  /**
   * Sets the value of the '{@link tools.vitruv.dsls.mapping.mappingLanguage.ContextVariable#getRequiredMappingPath <em>Required Mapping Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Required Mapping Path</em>' containment reference.
   * @see #getRequiredMappingPath()
   * @generated
   */
  void setRequiredMappingPath(RequiredMappingPathBase value);

  /**
   * Returns the value of the '<em><b>Target Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Class</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Class</em>' reference.
   * @see #setTargetClass(ModelElement)
   * @see tools.vitruv.dsls.mapping.mappingLanguage.MappingLanguagePackage#getContextVariable_TargetClass()
   * @model
   * @generated
   */
  ModelElement getTargetClass();

  /**
   * Sets the value of the '{@link tools.vitruv.dsls.mapping.mappingLanguage.ContextVariable#getTargetClass <em>Target Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Class</em>' reference.
   * @see #getTargetClass()
   * @generated
   */
  void setTargetClass(ModelElement value);

} // ContextVariable
