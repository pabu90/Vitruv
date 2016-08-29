/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.changes.echange.root.impl;

import edu.kit.ipd.sdq.vitruvius.framework.changes.echange.ChangePackage;
import edu.kit.ipd.sdq.vitruvius.framework.changes.echange.EObjectSubtractedEChange;
import edu.kit.ipd.sdq.vitruvius.framework.changes.echange.SubtractiveEChange;

import edu.kit.ipd.sdq.vitruvius.framework.changes.echange.root.RemoveRootEObject;
import edu.kit.ipd.sdq.vitruvius.framework.changes.echange.root.RootPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Remove Root EObject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.changes.echange.root.impl.RemoveRootEObjectImpl#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.changes.echange.root.impl.RemoveRootEObjectImpl#isIsDelete <em>Is Delete</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RemoveRootEObjectImpl<T extends EObject> extends RootEChangeImpl implements RemoveRootEObject<T> {
    /**
     * The cached value of the '{@link #getOldValue() <em>Old Value</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOldValue()
     * @generated
     * @ordered
     */
    protected T oldValue;

    /**
     * The default value of the '{@link #isIsDelete() <em>Is Delete</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsDelete()
     * @generated
     * @ordered
     */
    protected static final boolean IS_DELETE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsDelete() <em>Is Delete</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsDelete()
     * @generated
     * @ordered
     */
    protected boolean isDelete = IS_DELETE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RemoveRootEObjectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RootPackage.Literals.REMOVE_ROOT_EOBJECT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public T getOldValue() {
        if (oldValue != null && oldValue.eIsProxy()) {
            InternalEObject oldOldValue = (InternalEObject)oldValue;
            oldValue = (T)eResolveProxy(oldOldValue);
            if (oldValue != oldOldValue) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RootPackage.REMOVE_ROOT_EOBJECT__OLD_VALUE, oldOldValue, oldValue));
            }
        }
        return oldValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public T basicGetOldValue() {
        return oldValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOldValue(T newOldValue) {
        T oldOldValue = oldValue;
        oldValue = newOldValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RootPackage.REMOVE_ROOT_EOBJECT__OLD_VALUE, oldOldValue, oldValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsDelete() {
        return isDelete;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsDelete(boolean newIsDelete) {
        boolean oldIsDelete = isDelete;
        isDelete = newIsDelete;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RootPackage.REMOVE_ROOT_EOBJECT__IS_DELETE, oldIsDelete, isDelete));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RootPackage.REMOVE_ROOT_EOBJECT__OLD_VALUE:
                if (resolve) return getOldValue();
                return basicGetOldValue();
            case RootPackage.REMOVE_ROOT_EOBJECT__IS_DELETE:
                return isIsDelete();
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
            case RootPackage.REMOVE_ROOT_EOBJECT__OLD_VALUE:
                setOldValue((T)newValue);
                return;
            case RootPackage.REMOVE_ROOT_EOBJECT__IS_DELETE:
                setIsDelete((Boolean)newValue);
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
            case RootPackage.REMOVE_ROOT_EOBJECT__OLD_VALUE:
                setOldValue((T)null);
                return;
            case RootPackage.REMOVE_ROOT_EOBJECT__IS_DELETE:
                setIsDelete(IS_DELETE_EDEFAULT);
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
            case RootPackage.REMOVE_ROOT_EOBJECT__OLD_VALUE:
                return oldValue != null;
            case RootPackage.REMOVE_ROOT_EOBJECT__IS_DELETE:
                return isDelete != IS_DELETE_EDEFAULT;
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
        if (baseClass == SubtractiveEChange.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == EObjectSubtractedEChange.class) {
            switch (derivedFeatureID) {
                case RootPackage.REMOVE_ROOT_EOBJECT__OLD_VALUE: return ChangePackage.EOBJECT_SUBTRACTED_ECHANGE__OLD_VALUE;
                case RootPackage.REMOVE_ROOT_EOBJECT__IS_DELETE: return ChangePackage.EOBJECT_SUBTRACTED_ECHANGE__IS_DELETE;
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
        if (baseClass == SubtractiveEChange.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == EObjectSubtractedEChange.class) {
            switch (baseFeatureID) {
                case ChangePackage.EOBJECT_SUBTRACTED_ECHANGE__OLD_VALUE: return RootPackage.REMOVE_ROOT_EOBJECT__OLD_VALUE;
                case ChangePackage.EOBJECT_SUBTRACTED_ECHANGE__IS_DELETE: return RootPackage.REMOVE_ROOT_EOBJECT__IS_DELETE;
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
        result.append(" (isDelete: ");
        result.append(isDelete);
        result.append(')');
        return result.toString();
    }

} //RemoveRootEObjectImpl