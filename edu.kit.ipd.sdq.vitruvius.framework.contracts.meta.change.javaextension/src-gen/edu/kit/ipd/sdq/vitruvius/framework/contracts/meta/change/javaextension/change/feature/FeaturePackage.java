/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.FeatureFactory
 * @model kind="package"
 * @generated
 */
public interface FeaturePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "feature";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://edu.kit.ipd.sdq.vitruvius/Change/Java/Feature/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "feature";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FeaturePackage eINSTANCE = edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.impl.FeaturePackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.impl.JavaFeatureEChangeImpl <em>Java Feature EChange</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.impl.JavaFeatureEChangeImpl
	 * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.impl.FeaturePackageImpl#getJavaFeatureEChange()
	 * @generated
	 */
	int JAVA_FEATURE_ECHANGE = 0;

	/**
	 * The feature id for the '<em><b>Affected Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FEATURE_ECHANGE__AFFECTED_FEATURE = edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.FeaturePackage.FEATURE_ECHANGE__AFFECTED_FEATURE;

	/**
	 * The feature id for the '<em><b>Affected EObject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FEATURE_ECHANGE__AFFECTED_EOBJECT = edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.FeaturePackage.FEATURE_ECHANGE__AFFECTED_EOBJECT;

	/**
	 * The feature id for the '<em><b>Old Affected EObject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FEATURE_ECHANGE__OLD_AFFECTED_EOBJECT = edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.FeaturePackage.FEATURE_ECHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Feature EChange</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FEATURE_ECHANGE_FEATURE_COUNT = edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.FeaturePackage.FEATURE_ECHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Java Feature EChange</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FEATURE_ECHANGE_OPERATION_COUNT = edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.FeaturePackage.FEATURE_ECHANGE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.JavaFeatureEChange <em>Java Feature EChange</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Feature EChange</em>'.
	 * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.JavaFeatureEChange
	 * @generated
	 */
	EClass getJavaFeatureEChange();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.JavaFeatureEChange#getOldAffectedEObject <em>Old Affected EObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Affected EObject</em>'.
	 * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.JavaFeatureEChange#getOldAffectedEObject()
	 * @see #getJavaFeatureEChange()
	 * @generated
	 */
	EReference getJavaFeatureEChange_OldAffectedEObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FeatureFactory getFeatureFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.impl.JavaFeatureEChangeImpl <em>Java Feature EChange</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.impl.JavaFeatureEChangeImpl
		 * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.javaextension.change.feature.impl.FeaturePackageImpl#getJavaFeatureEChange()
		 * @generated
		 */
		EClass JAVA_FEATURE_ECHANGE = eINSTANCE.getJavaFeatureEChange();

		/**
		 * The meta object literal for the '<em><b>Old Affected EObject</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_FEATURE_ECHANGE__OLD_AFFECTED_EOBJECT = eINSTANCE.getJavaFeatureEChange_OldAffectedEObject();

	}

} //FeaturePackage
