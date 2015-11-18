/**
 */
package edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.util;

import edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.MappingLanguagePackage
 * @generated
 */
public class MappingLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MappingLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = MappingLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MappingLanguageSwitch<Adapter> modelSwitch =
    new MappingLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseMappingFile(MappingFile object)
      {
        return createMappingFileAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseMapping(Mapping object)
      {
        return createMappingAdapter();
      }
      @Override
      public Adapter caseSignature(Signature object)
      {
        return createSignatureAdapter();
      }
      @Override
      public Adapter caseNamedEClass(NamedEClass object)
      {
        return createNamedEClassAdapter();
      }
      @Override
      public Adapter caseRequiredMapping(RequiredMapping object)
      {
        return createRequiredMappingAdapter();
      }
      @Override
      public Adapter caseConstraintBlock(ConstraintBlock object)
      {
        return createConstraintBlockAdapter();
      }
      @Override
      public Adapter caseConstraintExpression(ConstraintExpression object)
      {
        return createConstraintExpressionAdapter();
      }
      @Override
      public Adapter caseSignatureConstraintBlock(SignatureConstraintBlock object)
      {
        return createSignatureConstraintBlockAdapter();
      }
      @Override
      public Adapter caseBodyConstraintBlock(BodyConstraintBlock object)
      {
        return createBodyConstraintBlockAdapter();
      }
      @Override
      public Adapter caseFeatureOfContextVariable(FeatureOfContextVariable object)
      {
        return createFeatureOfContextVariableAdapter();
      }
      @Override
      public Adapter caseContextVariable(ContextVariable object)
      {
        return createContextVariableAdapter();
      }
      @Override
      public Adapter caseRequiredMappingPathBase(RequiredMappingPathBase object)
      {
        return createRequiredMappingPathBaseAdapter();
      }
      @Override
      public Adapter caseRequiredMappingPathTail(RequiredMappingPathTail object)
      {
        return createRequiredMappingPathTailAdapter();
      }
      @Override
      public Adapter caseConstraintLiteral(ConstraintLiteral object)
      {
        return createConstraintLiteralAdapter();
      }
      @Override
      public Adapter caseVariableRef(VariableRef object)
      {
        return createVariableRefAdapter();
      }
      @Override
      public Adapter caseInExpression(InExpression object)
      {
        return createInExpressionAdapter();
      }
      @Override
      public Adapter caseEqualsLiteralExpression(EqualsLiteralExpression object)
      {
        return createEqualsLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseAttributeEquivalenceExpression(AttributeEquivalenceExpression object)
      {
        return createAttributeEquivalenceExpressionAdapter();
      }
      @Override
      public Adapter caseConstraintBooleanLiteral(ConstraintBooleanLiteral object)
      {
        return createConstraintBooleanLiteralAdapter();
      }
      @Override
      public Adapter caseConstraintNullLiteral(ConstraintNullLiteral object)
      {
        return createConstraintNullLiteralAdapter();
      }
      @Override
      public Adapter caseConstraintNumberLiteral(ConstraintNumberLiteral object)
      {
        return createConstraintNumberLiteralAdapter();
      }
      @Override
      public Adapter caseConstraintStringLiteral(ConstraintStringLiteral object)
      {
        return createConstraintStringLiteralAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.MappingFile <em>Mapping File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.MappingFile
   * @generated
   */
  public Adapter createMappingFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.Mapping <em>Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.Mapping
   * @generated
   */
  public Adapter createMappingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.Signature <em>Signature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.Signature
   * @generated
   */
  public Adapter createSignatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.NamedEClass <em>Named EClass</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.NamedEClass
   * @generated
   */
  public Adapter createNamedEClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.RequiredMapping <em>Required Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.RequiredMapping
   * @generated
   */
  public Adapter createRequiredMappingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintBlock <em>Constraint Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintBlock
   * @generated
   */
  public Adapter createConstraintBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintExpression <em>Constraint Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintExpression
   * @generated
   */
  public Adapter createConstraintExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.SignatureConstraintBlock <em>Signature Constraint Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.SignatureConstraintBlock
   * @generated
   */
  public Adapter createSignatureConstraintBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.BodyConstraintBlock <em>Body Constraint Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.BodyConstraintBlock
   * @generated
   */
  public Adapter createBodyConstraintBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.FeatureOfContextVariable <em>Feature Of Context Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.FeatureOfContextVariable
   * @generated
   */
  public Adapter createFeatureOfContextVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ContextVariable <em>Context Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ContextVariable
   * @generated
   */
  public Adapter createContextVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.RequiredMappingPathBase <em>Required Mapping Path Base</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.RequiredMappingPathBase
   * @generated
   */
  public Adapter createRequiredMappingPathBaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.RequiredMappingPathTail <em>Required Mapping Path Tail</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.RequiredMappingPathTail
   * @generated
   */
  public Adapter createRequiredMappingPathTailAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintLiteral <em>Constraint Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintLiteral
   * @generated
   */
  public Adapter createConstraintLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.VariableRef <em>Variable Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.VariableRef
   * @generated
   */
  public Adapter createVariableRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.InExpression <em>In Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.InExpression
   * @generated
   */
  public Adapter createInExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.EqualsLiteralExpression <em>Equals Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.EqualsLiteralExpression
   * @generated
   */
  public Adapter createEqualsLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.AttributeEquivalenceExpression <em>Attribute Equivalence Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.AttributeEquivalenceExpression
   * @generated
   */
  public Adapter createAttributeEquivalenceExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintBooleanLiteral <em>Constraint Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintBooleanLiteral
   * @generated
   */
  public Adapter createConstraintBooleanLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintNullLiteral <em>Constraint Null Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintNullLiteral
   * @generated
   */
  public Adapter createConstraintNullLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintNumberLiteral <em>Constraint Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintNumberLiteral
   * @generated
   */
  public Adapter createConstraintNumberLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintStringLiteral <em>Constraint String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.ConstraintStringLiteral
   * @generated
   */
  public Adapter createConstraintStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //MappingLanguageAdapterFactory