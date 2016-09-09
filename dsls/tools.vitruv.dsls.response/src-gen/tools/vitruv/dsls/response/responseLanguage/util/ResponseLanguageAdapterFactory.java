/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.response.responseLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tools.vitruv.dsls.mirbase.mirBase.MirBaseFile;

import tools.vitruv.dsls.response.responseLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tools.vitruv.dsls.response.responseLanguage.ResponseLanguagePackage
 * @generated
 */
public class ResponseLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ResponseLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResponseLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ResponseLanguagePackage.eINSTANCE;
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
  protected ResponseLanguageSwitch<Adapter> modelSwitch =
    new ResponseLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseResponseFile(ResponseFile object)
      {
        return createResponseFileAdapter();
      }
      @Override
      public Adapter caseResponsesSegment(ResponsesSegment object)
      {
        return createResponsesSegmentAdapter();
      }
      @Override
      public Adapter caseResponse(Response object)
      {
        return createResponseAdapter();
      }
      @Override
      public Adapter caseInvariantViolationEvent(InvariantViolationEvent object)
      {
        return createInvariantViolationEventAdapter();
      }
      @Override
      public Adapter caseTrigger(Trigger object)
      {
        return createTriggerAdapter();
      }
      @Override
      public Adapter caseModelChange(ModelChange object)
      {
        return createModelChangeAdapter();
      }
      @Override
      public Adapter caseConcreteModelElementChange(ConcreteModelElementChange object)
      {
        return createConcreteModelElementChangeAdapter();
      }
      @Override
      public Adapter caseAtomicConcreteModelElementChange(AtomicConcreteModelElementChange object)
      {
        return createAtomicConcreteModelElementChangeAdapter();
      }
      @Override
      public Adapter caseAtomicRootObjectChange(AtomicRootObjectChange object)
      {
        return createAtomicRootObjectChangeAdapter();
      }
      @Override
      public Adapter caseAtomicFeatureChange(AtomicFeatureChange object)
      {
        return createAtomicFeatureChangeAdapter();
      }
      @Override
      public Adapter caseAtomicMultiValuedFeatureChange(AtomicMultiValuedFeatureChange object)
      {
        return createAtomicMultiValuedFeatureChangeAdapter();
      }
      @Override
      public Adapter caseAtomicSingleValuedFeatureChange(AtomicSingleValuedFeatureChange object)
      {
        return createAtomicSingleValuedFeatureChangeAdapter();
      }
      @Override
      public Adapter caseArbitraryModelElementChange(ArbitraryModelElementChange object)
      {
        return createArbitraryModelElementChangeAdapter();
      }
      @Override
      public Adapter caseRoutine(Routine object)
      {
        return createRoutineAdapter();
      }
      @Override
      public Adapter caseImplicitRoutine(ImplicitRoutine object)
      {
        return createImplicitRoutineAdapter();
      }
      @Override
      public Adapter caseMatching(Matching object)
      {
        return createMatchingAdapter();
      }
      @Override
      public Adapter caseEffect(Effect object)
      {
        return createEffectAdapter();
      }
      @Override
      public Adapter caseExplicitRoutine(ExplicitRoutine object)
      {
        return createExplicitRoutineAdapter();
      }
      @Override
      public Adapter caseRoutineInput(RoutineInput object)
      {
        return createRoutineInputAdapter();
      }
      @Override
      public Adapter caseTaggable(Taggable object)
      {
        return createTaggableAdapter();
      }
      @Override
      public Adapter caseRetrieveModelElement(RetrieveModelElement object)
      {
        return createRetrieveModelElementAdapter();
      }
      @Override
      public Adapter caseExistingElementReference(ExistingElementReference object)
      {
        return createExistingElementReferenceAdapter();
      }
      @Override
      public Adapter caseCreateElement(CreateElement object)
      {
        return createCreateElementAdapter();
      }
      @Override
      public Adapter caseDeleteElement(DeleteElement object)
      {
        return createDeleteElementAdapter();
      }
      @Override
      public Adapter caseCreateCorrespondence(CreateCorrespondence object)
      {
        return createCreateCorrespondenceAdapter();
      }
      @Override
      public Adapter caseRemoveCorrespondence(RemoveCorrespondence object)
      {
        return createRemoveCorrespondenceAdapter();
      }
      @Override
      public Adapter caseTagCodeBlock(TagCodeBlock object)
      {
        return createTagCodeBlockAdapter();
      }
      @Override
      public Adapter casePreconditionCodeBlock(PreconditionCodeBlock object)
      {
        return createPreconditionCodeBlockAdapter();
      }
      @Override
      public Adapter caseCorrespondingObjectCodeBlock(CorrespondingObjectCodeBlock object)
      {
        return createCorrespondingObjectCodeBlockAdapter();
      }
      @Override
      public Adapter caseExecutionCodeBlock(ExecutionCodeBlock object)
      {
        return createExecutionCodeBlockAdapter();
      }
      @Override
      public Adapter caseCodeBlock(CodeBlock object)
      {
        return createCodeBlockAdapter();
      }
      @Override
      public Adapter caseInsertRootChange(InsertRootChange object)
      {
        return createInsertRootChangeAdapter();
      }
      @Override
      public Adapter caseRemoveRootChange(RemoveRootChange object)
      {
        return createRemoveRootChangeAdapter();
      }
      @Override
      public Adapter caseMultiValuedFeatureInsertChange(MultiValuedFeatureInsertChange object)
      {
        return createMultiValuedFeatureInsertChangeAdapter();
      }
      @Override
      public Adapter caseMultiValuedFeatureRemoveChange(MultiValuedFeatureRemoveChange object)
      {
        return createMultiValuedFeatureRemoveChangeAdapter();
      }
      @Override
      public Adapter caseMultiValuedFeaturePermuteChange(MultiValuedFeaturePermuteChange object)
      {
        return createMultiValuedFeaturePermuteChangeAdapter();
      }
      @Override
      public Adapter caseSingleValuedFeatureReplace(SingleValuedFeatureReplace object)
      {
        return createSingleValuedFeatureReplaceAdapter();
      }
      @Override
      public Adapter caseMirBaseFile(MirBaseFile object)
      {
        return createMirBaseFileAdapter();
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
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.ResponseFile <em>Response File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.ResponseFile
   * @generated
   */
  public Adapter createResponseFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.ResponsesSegment <em>Responses Segment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.ResponsesSegment
   * @generated
   */
  public Adapter createResponsesSegmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.Response <em>Response</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.Response
   * @generated
   */
  public Adapter createResponseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.InvariantViolationEvent <em>Invariant Violation Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.InvariantViolationEvent
   * @generated
   */
  public Adapter createInvariantViolationEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.Trigger
   * @generated
   */
  public Adapter createTriggerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.ModelChange <em>Model Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.ModelChange
   * @generated
   */
  public Adapter createModelChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.ConcreteModelElementChange <em>Concrete Model Element Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.ConcreteModelElementChange
   * @generated
   */
  public Adapter createConcreteModelElementChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.AtomicConcreteModelElementChange <em>Atomic Concrete Model Element Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.AtomicConcreteModelElementChange
   * @generated
   */
  public Adapter createAtomicConcreteModelElementChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.AtomicRootObjectChange <em>Atomic Root Object Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.AtomicRootObjectChange
   * @generated
   */
  public Adapter createAtomicRootObjectChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.AtomicFeatureChange <em>Atomic Feature Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.AtomicFeatureChange
   * @generated
   */
  public Adapter createAtomicFeatureChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.AtomicMultiValuedFeatureChange <em>Atomic Multi Valued Feature Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.AtomicMultiValuedFeatureChange
   * @generated
   */
  public Adapter createAtomicMultiValuedFeatureChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.AtomicSingleValuedFeatureChange <em>Atomic Single Valued Feature Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.AtomicSingleValuedFeatureChange
   * @generated
   */
  public Adapter createAtomicSingleValuedFeatureChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.ArbitraryModelElementChange <em>Arbitrary Model Element Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.ArbitraryModelElementChange
   * @generated
   */
  public Adapter createArbitraryModelElementChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.Routine <em>Routine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.Routine
   * @generated
   */
  public Adapter createRoutineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.ImplicitRoutine <em>Implicit Routine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.ImplicitRoutine
   * @generated
   */
  public Adapter createImplicitRoutineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.Matching <em>Matching</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.Matching
   * @generated
   */
  public Adapter createMatchingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.Effect <em>Effect</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.Effect
   * @generated
   */
  public Adapter createEffectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.ExplicitRoutine <em>Explicit Routine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.ExplicitRoutine
   * @generated
   */
  public Adapter createExplicitRoutineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.RoutineInput <em>Routine Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.RoutineInput
   * @generated
   */
  public Adapter createRoutineInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.Taggable <em>Taggable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.Taggable
   * @generated
   */
  public Adapter createTaggableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.RetrieveModelElement <em>Retrieve Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.RetrieveModelElement
   * @generated
   */
  public Adapter createRetrieveModelElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.ExistingElementReference <em>Existing Element Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.ExistingElementReference
   * @generated
   */
  public Adapter createExistingElementReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.CreateElement <em>Create Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.CreateElement
   * @generated
   */
  public Adapter createCreateElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.DeleteElement <em>Delete Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.DeleteElement
   * @generated
   */
  public Adapter createDeleteElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.CreateCorrespondence <em>Create Correspondence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.CreateCorrespondence
   * @generated
   */
  public Adapter createCreateCorrespondenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.RemoveCorrespondence <em>Remove Correspondence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.RemoveCorrespondence
   * @generated
   */
  public Adapter createRemoveCorrespondenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.TagCodeBlock <em>Tag Code Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.TagCodeBlock
   * @generated
   */
  public Adapter createTagCodeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.PreconditionCodeBlock <em>Precondition Code Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.PreconditionCodeBlock
   * @generated
   */
  public Adapter createPreconditionCodeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.CorrespondingObjectCodeBlock <em>Corresponding Object Code Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.CorrespondingObjectCodeBlock
   * @generated
   */
  public Adapter createCorrespondingObjectCodeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.ExecutionCodeBlock <em>Execution Code Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.ExecutionCodeBlock
   * @generated
   */
  public Adapter createExecutionCodeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.CodeBlock <em>Code Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.CodeBlock
   * @generated
   */
  public Adapter createCodeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.InsertRootChange <em>Insert Root Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.InsertRootChange
   * @generated
   */
  public Adapter createInsertRootChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.RemoveRootChange <em>Remove Root Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.RemoveRootChange
   * @generated
   */
  public Adapter createRemoveRootChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.MultiValuedFeatureInsertChange <em>Multi Valued Feature Insert Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.MultiValuedFeatureInsertChange
   * @generated
   */
  public Adapter createMultiValuedFeatureInsertChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.MultiValuedFeatureRemoveChange <em>Multi Valued Feature Remove Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.MultiValuedFeatureRemoveChange
   * @generated
   */
  public Adapter createMultiValuedFeatureRemoveChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.MultiValuedFeaturePermuteChange <em>Multi Valued Feature Permute Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.MultiValuedFeaturePermuteChange
   * @generated
   */
  public Adapter createMultiValuedFeaturePermuteChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.response.responseLanguage.SingleValuedFeatureReplace <em>Single Valued Feature Replace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.response.responseLanguage.SingleValuedFeatureReplace
   * @generated
   */
  public Adapter createSingleValuedFeatureReplaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.mirbase.mirBase.MirBaseFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.mirbase.mirBase.MirBaseFile
   * @generated
   */
  public Adapter createMirBaseFileAdapter()
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

} //ResponseLanguageAdapterFactory
