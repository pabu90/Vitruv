/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.reactions.reactionsLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Creation And Insertion Change Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.ElementCreationAndInsertionChangeType#getCreateChange <em>Create Change</em>}</li>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.ElementCreationAndInsertionChangeType#getInsertChange <em>Insert Change</em>}</li>
 * </ul>
 *
 * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getElementCreationAndInsertionChangeType()
 * @model
 * @generated
 */
public interface ElementCreationAndInsertionChangeType extends ElementCompoundChangeType
{
  /**
   * Returns the value of the '<em><b>Create Change</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Create Change</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Create Change</em>' containment reference.
   * @see #setCreateChange(ElementCreationChangeType)
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getElementCreationAndInsertionChangeType_CreateChange()
   * @model containment="true"
   * @generated
   */
  ElementCreationChangeType getCreateChange();

  /**
   * Sets the value of the '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ElementCreationAndInsertionChangeType#getCreateChange <em>Create Change</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Create Change</em>' containment reference.
   * @see #getCreateChange()
   * @generated
   */
  void setCreateChange(ElementCreationChangeType value);

  /**
   * Returns the value of the '<em><b>Insert Change</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Insert Change</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Insert Change</em>' containment reference.
   * @see #setInsertChange(ElementInsertionChangeType)
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getElementCreationAndInsertionChangeType_InsertChange()
   * @model containment="true"
   * @generated
   */
  ElementInsertionChangeType getInsertChange();

  /**
   * Sets the value of the '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ElementCreationAndInsertionChangeType#getInsertChange <em>Insert Change</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Insert Change</em>' containment reference.
   * @see #getInsertChange()
   * @generated
   */
  void setInsertChange(ElementInsertionChangeType value);

} // ElementCreationAndInsertionChangeType
