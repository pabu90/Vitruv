/**
 */
package tools.vitruv.framework.change.echange.compound.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.vitruv.framework.change.echange.compound.CompoundPackage;
import tools.vitruv.framework.change.echange.compound.CreateAndInsertRoot;

import tools.vitruv.framework.change.echange.eobject.CreateEObject;

import tools.vitruv.framework.change.echange.root.InsertRootEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create And Insert Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.framework.change.echange.compound.impl.CreateAndInsertRootImpl#getCreateChange <em>Create Change</em>}</li>
 *   <li>{@link tools.vitruv.framework.change.echange.compound.impl.CreateAndInsertRootImpl#getInsertChange <em>Insert Change</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CreateAndInsertRootImpl<T extends EObject> extends CompoundEChangeImpl implements CreateAndInsertRoot<T> {
	/**
	 * The cached value of the '{@link #getCreateChange() <em>Create Change</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateChange()
	 * @generated
	 * @ordered
	 */
	protected CreateEObject<T> createChange;

	/**
	 * The cached value of the '{@link #getInsertChange() <em>Insert Change</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsertChange()
	 * @generated
	 * @ordered
	 */
	protected InsertRootEObject<T> insertChange;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateAndInsertRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompoundPackage.Literals.CREATE_AND_INSERT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateEObject<T> getCreateChange() {
		return createChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCreateChange(CreateEObject<T> newCreateChange, NotificationChain msgs) {
		CreateEObject<T> oldCreateChange = createChange;
		createChange = newCreateChange;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompoundPackage.CREATE_AND_INSERT_ROOT__CREATE_CHANGE, oldCreateChange, newCreateChange);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateChange(CreateEObject<T> newCreateChange) {
		if (newCreateChange != createChange) {
			NotificationChain msgs = null;
			if (createChange != null)
				msgs = ((InternalEObject)createChange).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompoundPackage.CREATE_AND_INSERT_ROOT__CREATE_CHANGE, null, msgs);
			if (newCreateChange != null)
				msgs = ((InternalEObject)newCreateChange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompoundPackage.CREATE_AND_INSERT_ROOT__CREATE_CHANGE, null, msgs);
			msgs = basicSetCreateChange(newCreateChange, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompoundPackage.CREATE_AND_INSERT_ROOT__CREATE_CHANGE, newCreateChange, newCreateChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InsertRootEObject<T> getInsertChange() {
		return insertChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInsertChange(InsertRootEObject<T> newInsertChange, NotificationChain msgs) {
		InsertRootEObject<T> oldInsertChange = insertChange;
		insertChange = newInsertChange;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompoundPackage.CREATE_AND_INSERT_ROOT__INSERT_CHANGE, oldInsertChange, newInsertChange);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsertChange(InsertRootEObject<T> newInsertChange) {
		if (newInsertChange != insertChange) {
			NotificationChain msgs = null;
			if (insertChange != null)
				msgs = ((InternalEObject)insertChange).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompoundPackage.CREATE_AND_INSERT_ROOT__INSERT_CHANGE, null, msgs);
			if (newInsertChange != null)
				msgs = ((InternalEObject)newInsertChange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompoundPackage.CREATE_AND_INSERT_ROOT__INSERT_CHANGE, null, msgs);
			msgs = basicSetInsertChange(newInsertChange, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompoundPackage.CREATE_AND_INSERT_ROOT__INSERT_CHANGE, newInsertChange, newInsertChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompoundPackage.CREATE_AND_INSERT_ROOT__CREATE_CHANGE:
				return basicSetCreateChange(null, msgs);
			case CompoundPackage.CREATE_AND_INSERT_ROOT__INSERT_CHANGE:
				return basicSetInsertChange(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompoundPackage.CREATE_AND_INSERT_ROOT__CREATE_CHANGE:
				return getCreateChange();
			case CompoundPackage.CREATE_AND_INSERT_ROOT__INSERT_CHANGE:
				return getInsertChange();
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
			case CompoundPackage.CREATE_AND_INSERT_ROOT__CREATE_CHANGE:
				setCreateChange((CreateEObject<T>)newValue);
				return;
			case CompoundPackage.CREATE_AND_INSERT_ROOT__INSERT_CHANGE:
				setInsertChange((InsertRootEObject<T>)newValue);
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
			case CompoundPackage.CREATE_AND_INSERT_ROOT__CREATE_CHANGE:
				setCreateChange((CreateEObject<T>)null);
				return;
			case CompoundPackage.CREATE_AND_INSERT_ROOT__INSERT_CHANGE:
				setInsertChange((InsertRootEObject<T>)null);
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
			case CompoundPackage.CREATE_AND_INSERT_ROOT__CREATE_CHANGE:
				return createChange != null;
			case CompoundPackage.CREATE_AND_INSERT_ROOT__INSERT_CHANGE:
				return insertChange != null;
		}
		return super.eIsSet(featureID);
	}

} //CreateAndInsertRootImpl