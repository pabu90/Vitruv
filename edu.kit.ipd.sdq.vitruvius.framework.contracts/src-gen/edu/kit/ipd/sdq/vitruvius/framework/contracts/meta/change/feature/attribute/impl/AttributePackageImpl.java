/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.impl;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.ChangePackage;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.compound.CompoundPackage;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.compound.impl.CompoundPackageImpl;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.FeaturePackage;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.AttributeFactory;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.AttributePackage;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.InsertEAttributeValue;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.PermuteEAttributeValues;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.RemoveEAttributeValue;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.ReplaceSingleValuedEAttribute;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.UpdateEAttribute;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.impl.FeaturePackageImpl;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.list.ListPackage;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.list.impl.ListPackageImpl;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.reference.ReferencePackage;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.reference.impl.ReferencePackageImpl;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.root.RootPackage;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.root.impl.RootPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributePackageImpl extends EPackageImpl implements AttributePackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass updateEAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass replaceSingleValuedEAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass insertEAttributeValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass removeEAttributeValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass permuteEAttributeValuesEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.AttributePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private AttributePackageImpl() {
        super(eNS_URI, AttributeFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link AttributePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static AttributePackage init() {
        if (isInited) return (AttributePackage)EPackage.Registry.INSTANCE.getEPackage(AttributePackage.eNS_URI);

        // Obtain or create and register package
        AttributePackageImpl theAttributePackage = (AttributePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AttributePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AttributePackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        ChangePackageImpl theChangePackage = (ChangePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ChangePackage.eNS_URI) instanceof ChangePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ChangePackage.eNS_URI) : ChangePackage.eINSTANCE);
        FeaturePackageImpl theFeaturePackage = (FeaturePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FeaturePackage.eNS_URI) instanceof FeaturePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FeaturePackage.eNS_URI) : FeaturePackage.eINSTANCE);
        ListPackageImpl theListPackage = (ListPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ListPackage.eNS_URI) instanceof ListPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ListPackage.eNS_URI) : ListPackage.eINSTANCE);
        ReferencePackageImpl theReferencePackage = (ReferencePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReferencePackage.eNS_URI) instanceof ReferencePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReferencePackage.eNS_URI) : ReferencePackage.eINSTANCE);
        RootPackageImpl theRootPackage = (RootPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI) instanceof RootPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI) : RootPackage.eINSTANCE);
        CompoundPackageImpl theCompoundPackage = (CompoundPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CompoundPackage.eNS_URI) instanceof CompoundPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CompoundPackage.eNS_URI) : CompoundPackage.eINSTANCE);

        // Create package meta-data objects
        theAttributePackage.createPackageContents();
        theChangePackage.createPackageContents();
        theFeaturePackage.createPackageContents();
        theListPackage.createPackageContents();
        theReferencePackage.createPackageContents();
        theRootPackage.createPackageContents();
        theCompoundPackage.createPackageContents();

        // Initialize created meta-data
        theAttributePackage.initializePackageContents();
        theChangePackage.initializePackageContents();
        theFeaturePackage.initializePackageContents();
        theListPackage.initializePackageContents();
        theReferencePackage.initializePackageContents();
        theRootPackage.initializePackageContents();
        theCompoundPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theAttributePackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(AttributePackage.eNS_URI, theAttributePackage);
        return theAttributePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUpdateEAttribute() {
        return updateEAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReplaceSingleValuedEAttribute() {
        return replaceSingleValuedEAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInsertEAttributeValue() {
        return insertEAttributeValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRemoveEAttributeValue() {
        return removeEAttributeValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPermuteEAttributeValues() {
        return permuteEAttributeValuesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeFactory getAttributeFactory() {
        return (AttributeFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        updateEAttributeEClass = createEClass(UPDATE_EATTRIBUTE);

        replaceSingleValuedEAttributeEClass = createEClass(REPLACE_SINGLE_VALUED_EATTRIBUTE);

        insertEAttributeValueEClass = createEClass(INSERT_EATTRIBUTE_VALUE);

        removeEAttributeValueEClass = createEClass(REMOVE_EATTRIBUTE_VALUE);

        permuteEAttributeValuesEClass = createEClass(PERMUTE_EATTRIBUTE_VALUES);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        FeaturePackage theFeaturePackage = (FeaturePackage)EPackage.Registry.INSTANCE.getEPackage(FeaturePackage.eNS_URI);
        ChangePackage theChangePackage = (ChangePackage)EPackage.Registry.INSTANCE.getEPackage(ChangePackage.eNS_URI);
        ListPackage theListPackage = (ListPackage)EPackage.Registry.INSTANCE.getEPackage(ListPackage.eNS_URI);

        // Create type parameters
        ETypeParameter updateEAttributeEClass_T = addETypeParameter(updateEAttributeEClass, "T");
        ETypeParameter replaceSingleValuedEAttributeEClass_T = addETypeParameter(replaceSingleValuedEAttributeEClass, "T");
        ETypeParameter insertEAttributeValueEClass_T = addETypeParameter(insertEAttributeValueEClass, "T");
        ETypeParameter removeEAttributeValueEClass_T = addETypeParameter(removeEAttributeValueEClass, "T");
        ETypeParameter permuteEAttributeValuesEClass_T = addETypeParameter(permuteEAttributeValuesEClass, "T");

        // Set bounds for type parameters
        EGenericType g1 = createEGenericType(ecorePackage.getEJavaObject());
        updateEAttributeEClass_T.getEBounds().add(g1);
        g1 = createEGenericType(ecorePackage.getEJavaObject());
        replaceSingleValuedEAttributeEClass_T.getEBounds().add(g1);
        g1 = createEGenericType(ecorePackage.getEJavaObject());
        insertEAttributeValueEClass_T.getEBounds().add(g1);
        g1 = createEGenericType(ecorePackage.getEJavaObject());
        removeEAttributeValueEClass_T.getEBounds().add(g1);
        g1 = createEGenericType(ecorePackage.getEJavaObject());
        permuteEAttributeValuesEClass_T.getEBounds().add(g1);

        // Add supertypes to classes
        g1 = createEGenericType(theFeaturePackage.getEFeatureChange());
        EGenericType g2 = createEGenericType(ecorePackage.getEAttribute());
        g1.getETypeArguments().add(g2);
        updateEAttributeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theFeaturePackage.getUpdateSingleValuedEFeature());
        g2 = createEGenericType(replaceSingleValuedEAttributeEClass_T);
        g1.getETypeArguments().add(g2);
        replaceSingleValuedEAttributeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getUpdateEAttribute());
        g2 = createEGenericType(replaceSingleValuedEAttributeEClass_T);
        g1.getETypeArguments().add(g2);
        replaceSingleValuedEAttributeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theChangePackage.getSubtractiveEAttributeChange());
        g2 = createEGenericType(replaceSingleValuedEAttributeEClass_T);
        g1.getETypeArguments().add(g2);
        replaceSingleValuedEAttributeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theChangePackage.getAdditiveEAttributeChange());
        g2 = createEGenericType(replaceSingleValuedEAttributeEClass_T);
        g1.getETypeArguments().add(g2);
        replaceSingleValuedEAttributeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theListPackage.getInsertInEList());
        g2 = createEGenericType(insertEAttributeValueEClass_T);
        g1.getETypeArguments().add(g2);
        insertEAttributeValueEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getUpdateEAttribute());
        g2 = createEGenericType(insertEAttributeValueEClass_T);
        g1.getETypeArguments().add(g2);
        insertEAttributeValueEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theChangePackage.getAdditiveEAttributeChange());
        g2 = createEGenericType(insertEAttributeValueEClass_T);
        g1.getETypeArguments().add(g2);
        insertEAttributeValueEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theListPackage.getRemoveFromEList());
        g2 = createEGenericType(removeEAttributeValueEClass_T);
        g1.getETypeArguments().add(g2);
        removeEAttributeValueEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getUpdateEAttribute());
        g2 = createEGenericType(removeEAttributeValueEClass_T);
        g1.getETypeArguments().add(g2);
        removeEAttributeValueEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theChangePackage.getSubtractiveEAttributeChange());
        g2 = createEGenericType(removeEAttributeValueEClass_T);
        g1.getETypeArguments().add(g2);
        removeEAttributeValueEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theListPackage.getPermuteEList());
        g2 = createEGenericType(permuteEAttributeValuesEClass_T);
        g1.getETypeArguments().add(g2);
        permuteEAttributeValuesEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getUpdateEAttribute());
        g2 = createEGenericType(permuteEAttributeValuesEClass_T);
        g1.getETypeArguments().add(g2);
        permuteEAttributeValuesEClass.getEGenericSuperTypes().add(g1);

        // Initialize classes, features, and operations; add parameters
        initEClass(updateEAttributeEClass, UpdateEAttribute.class, "UpdateEAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(replaceSingleValuedEAttributeEClass, ReplaceSingleValuedEAttribute.class, "ReplaceSingleValuedEAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(insertEAttributeValueEClass, InsertEAttributeValue.class, "InsertEAttributeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(removeEAttributeValueEClass, RemoveEAttributeValue.class, "RemoveEAttributeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(permuteEAttributeValuesEClass, PermuteEAttributeValues.class, "PermuteEAttributeValues", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    }

} //AttributePackageImpl