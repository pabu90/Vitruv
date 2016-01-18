/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.containment.impl;

import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.EFeatureChange;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.FeaturePackage;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.UpdateEFeature;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.UpdateMultiValuedEFeature;

import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.list.InsertInEList;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.list.ListPackage;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.list.UpdateSingleEListEntry;

import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.UpdateEReference;

import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.containment.ContainmentPackage;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.containment.CreateNonRootEObjectInList;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.containment.UpdateContainmentEReference;

import edu.kit.ipd.sdq.vitruvius.framework.meta.change.object.impl.CreateEObjectImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Non Root EObject In List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.containment.impl.CreateNonRootEObjectInListImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.containment.impl.CreateNonRootEObjectInListImpl#getNewValue <em>New Value</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.containment.impl.CreateNonRootEObjectInListImpl#getAffectedFeature <em>Affected Feature</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.containment.impl.CreateNonRootEObjectInListImpl#getOldAffectedEObject <em>Old Affected EObject</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.containment.impl.CreateNonRootEObjectInListImpl#getNewAffectedEObject <em>New Affected EObject</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateNonRootEObjectInListImpl<T extends EObject> extends CreateEObjectImpl<T> implements CreateNonRootEObjectInList<T> {
	/**
     * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIndex()
     * @generated
     * @ordered
     */
	protected static final int INDEX_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIndex()
     * @generated
     * @ordered
     */
	protected int index = INDEX_EDEFAULT;

	/**
     * The cached value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNewValue()
     * @generated
     * @ordered
     */
	protected T newValue;

	/**
     * The cached value of the '{@link #getAffectedFeature() <em>Affected Feature</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAffectedFeature()
     * @generated
     * @ordered
     */
	protected EReference affectedFeature;

	/**
     * The cached value of the '{@link #getOldAffectedEObject() <em>Old Affected EObject</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOldAffectedEObject()
     * @generated
     * @ordered
     */
	protected EObject oldAffectedEObject;

	/**
     * The cached value of the '{@link #getNewAffectedEObject() <em>New Affected EObject</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNewAffectedEObject()
     * @generated
     * @ordered
     */
	protected EObject newAffectedEObject;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CreateNonRootEObjectInListImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ContainmentPackage.Literals.CREATE_NON_ROOT_EOBJECT_IN_LIST;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getIndex() {
        return index;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIndex(int newIndex) {
        int oldIndex = index;
        index = newIndex;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__INDEX, oldIndex, index));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public T getNewValue() {
        return newValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNewValue(T newNewValue) {
        T oldNewValue = newValue;
        newValue = newNewValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_VALUE, oldNewValue, newValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAffectedFeature() {
        if (affectedFeature != null && affectedFeature.eIsProxy()) {
            InternalEObject oldAffectedFeature = (InternalEObject)affectedFeature;
            affectedFeature = (EReference)eResolveProxy(oldAffectedFeature);
            if (affectedFeature != oldAffectedFeature) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__AFFECTED_FEATURE, oldAffectedFeature, affectedFeature));
            }
        }
        return affectedFeature;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference basicGetAffectedFeature() {
        return affectedFeature;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAffectedFeature(EReference newAffectedFeature) {
        EReference oldAffectedFeature = affectedFeature;
        affectedFeature = newAffectedFeature;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__AFFECTED_FEATURE, oldAffectedFeature, affectedFeature));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EObject getOldAffectedEObject() {
        if (oldAffectedEObject != null && oldAffectedEObject.eIsProxy()) {
            InternalEObject oldOldAffectedEObject = (InternalEObject)oldAffectedEObject;
            oldAffectedEObject = eResolveProxy(oldOldAffectedEObject);
            if (oldAffectedEObject != oldOldAffectedEObject) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__OLD_AFFECTED_EOBJECT, oldOldAffectedEObject, oldAffectedEObject));
            }
        }
        return oldAffectedEObject;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EObject basicGetOldAffectedEObject() {
        return oldAffectedEObject;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOldAffectedEObject(EObject newOldAffectedEObject) {
        EObject oldOldAffectedEObject = oldAffectedEObject;
        oldAffectedEObject = newOldAffectedEObject;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__OLD_AFFECTED_EOBJECT, oldOldAffectedEObject, oldAffectedEObject));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EObject getNewAffectedEObject() {
        if (newAffectedEObject != null && newAffectedEObject.eIsProxy()) {
            InternalEObject oldNewAffectedEObject = (InternalEObject)newAffectedEObject;
            newAffectedEObject = eResolveProxy(oldNewAffectedEObject);
            if (newAffectedEObject != oldNewAffectedEObject) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_AFFECTED_EOBJECT, oldNewAffectedEObject, newAffectedEObject));
            }
        }
        return newAffectedEObject;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EObject basicGetNewAffectedEObject() {
        return newAffectedEObject;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNewAffectedEObject(EObject newNewAffectedEObject) {
        EObject oldNewAffectedEObject = newAffectedEObject;
        newAffectedEObject = newNewAffectedEObject;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_AFFECTED_EOBJECT, oldNewAffectedEObject, newAffectedEObject));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__INDEX:
                return getIndex();
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_VALUE:
                return getNewValue();
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__AFFECTED_FEATURE:
                if (resolve) return getAffectedFeature();
                return basicGetAffectedFeature();
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__OLD_AFFECTED_EOBJECT:
                if (resolve) return getOldAffectedEObject();
                return basicGetOldAffectedEObject();
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_AFFECTED_EOBJECT:
                if (resolve) return getNewAffectedEObject();
                return basicGetNewAffectedEObject();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__INDEX:
                setIndex((Integer)newValue);
                return;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_VALUE:
                setNewValue((T)newValue);
                return;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__AFFECTED_FEATURE:
                setAffectedFeature((EReference)newValue);
                return;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__OLD_AFFECTED_EOBJECT:
                setOldAffectedEObject((EObject)newValue);
                return;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_AFFECTED_EOBJECT:
                setNewAffectedEObject((EObject)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__INDEX:
                setIndex(INDEX_EDEFAULT);
                return;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_VALUE:
                setNewValue((T)null);
                return;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__AFFECTED_FEATURE:
                setAffectedFeature((EReference)null);
                return;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__OLD_AFFECTED_EOBJECT:
                setOldAffectedEObject((EObject)null);
                return;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_AFFECTED_EOBJECT:
                setNewAffectedEObject((EObject)null);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__INDEX:
                return index != INDEX_EDEFAULT;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_VALUE:
                return newValue != null;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__AFFECTED_FEATURE:
                return affectedFeature != null;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__OLD_AFFECTED_EOBJECT:
                return oldAffectedEObject != null;
            case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_AFFECTED_EOBJECT:
                return newAffectedEObject != null;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == UpdateEFeature.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == UpdateMultiValuedEFeature.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == UpdateSingleEListEntry.class) {
            switch (derivedFeatureID) {
                case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__INDEX: return ListPackage.UPDATE_SINGLE_ELIST_ENTRY__INDEX;
                default: return -1;
            }
        }
        if (baseClass == InsertInEList.class) {
            switch (derivedFeatureID) {
                case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_VALUE: return ListPackage.INSERT_IN_ELIST__NEW_VALUE;
                default: return -1;
            }
        }
        if (baseClass == EFeatureChange.class) {
            switch (derivedFeatureID) {
                case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__AFFECTED_FEATURE: return FeaturePackage.EFEATURE_CHANGE__AFFECTED_FEATURE;
                case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__OLD_AFFECTED_EOBJECT: return FeaturePackage.EFEATURE_CHANGE__OLD_AFFECTED_EOBJECT;
                case ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_AFFECTED_EOBJECT: return FeaturePackage.EFEATURE_CHANGE__NEW_AFFECTED_EOBJECT;
                default: return -1;
            }
        }
        if (baseClass == UpdateEReference.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == UpdateContainmentEReference.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == UpdateEFeature.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == UpdateMultiValuedEFeature.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == UpdateSingleEListEntry.class) {
            switch (baseFeatureID) {
                case ListPackage.UPDATE_SINGLE_ELIST_ENTRY__INDEX: return ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__INDEX;
                default: return -1;
            }
        }
        if (baseClass == InsertInEList.class) {
            switch (baseFeatureID) {
                case ListPackage.INSERT_IN_ELIST__NEW_VALUE: return ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_VALUE;
                default: return -1;
            }
        }
        if (baseClass == EFeatureChange.class) {
            switch (baseFeatureID) {
                case FeaturePackage.EFEATURE_CHANGE__AFFECTED_FEATURE: return ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__AFFECTED_FEATURE;
                case FeaturePackage.EFEATURE_CHANGE__OLD_AFFECTED_EOBJECT: return ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__OLD_AFFECTED_EOBJECT;
                case FeaturePackage.EFEATURE_CHANGE__NEW_AFFECTED_EOBJECT: return ContainmentPackage.CREATE_NON_ROOT_EOBJECT_IN_LIST__NEW_AFFECTED_EOBJECT;
                default: return -1;
            }
        }
        if (baseClass == UpdateEReference.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == UpdateContainmentEReference.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (index: ");
        result.append(index);
        result.append(", newValue: ");
        result.append(newValue);
        result.append(')');
        return result.toString();
    }

} //CreateNonRootEObjectInListImpl