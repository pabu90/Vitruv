/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.list;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Insert In EList</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.list.InsertInEList#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.list.ListPackage#getInsertInEList()
 * @model abstract="true" TBounds="org.eclipse.emf.ecore.EJavaObject"
 * @generated
 */
public interface InsertInEList<T extends Object> extends UpdateSingleEListEntry<T> {
	/**
     * Returns the value of the '<em><b>New Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>New Value</em>' attribute.
     * @see #setNewValue(Object)
     * @see edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.list.ListPackage#getInsertInEList_NewValue()
     * @model required="true"
     * @generated
     */
	T getNewValue();

	/**
     * Sets the value of the '{@link edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.list.InsertInEList#getNewValue <em>New Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>New Value</em>' attribute.
     * @see #getNewValue()
     * @generated
     */
	void setNewValue(T value);

} // InsertInEList