/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.impl;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.AttributePackage;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.UpdateEAttribute;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.impl.EFeatureChangeImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update EAttribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class UpdateEAttributeImpl<A extends EObject> extends EFeatureChangeImpl<A, EAttribute> implements UpdateEAttribute<A> {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UpdateEAttributeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AttributePackage.Literals.UPDATE_EATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * This is specialized for the more specific type known in this context.
     * @generated
     */
    @Override
    public void setAffectedFeature(EAttribute newAffectedFeature) {
        super.setAffectedFeature(newAffectedFeature);
    }

} //UpdateEAttributeImpl