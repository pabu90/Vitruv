/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.change.echange.impl;

import org.eclipse.emf.ecore.EClass;

import edu.kit.ipd.sdq.vitruvius.framework.change.echange.AtomicEChange;
import edu.kit.ipd.sdq.vitruvius.framework.change.echange.EChangePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic EChange</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class AtomicEChangeImpl extends EChangeImpl implements AtomicEChange {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected AtomicEChangeImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return EChangePackage.Literals.ATOMIC_ECHANGE;
	}

} //AtomicEChangeImpl