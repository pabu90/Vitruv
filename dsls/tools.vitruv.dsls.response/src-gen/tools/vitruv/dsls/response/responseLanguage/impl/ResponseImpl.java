/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.response.responseLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.vitruv.dsls.response.responseLanguage.ImplicitRoutine;
import tools.vitruv.dsls.response.responseLanguage.Response;
import tools.vitruv.dsls.response.responseLanguage.ResponseLanguagePackage;
import tools.vitruv.dsls.response.responseLanguage.ResponsesSegment;
import tools.vitruv.dsls.response.responseLanguage.Trigger;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.response.responseLanguage.impl.ResponseImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link tools.vitruv.dsls.response.responseLanguage.impl.ResponseImpl#getName <em>Name</em>}</li>
 *   <li>{@link tools.vitruv.dsls.response.responseLanguage.impl.ResponseImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link tools.vitruv.dsls.response.responseLanguage.impl.ResponseImpl#getRoutine <em>Routine</em>}</li>
 *   <li>{@link tools.vitruv.dsls.response.responseLanguage.impl.ResponseImpl#getResponsesSegment <em>Responses Segment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResponseImpl extends MinimalEObjectImpl.Container implements Response
{
  /**
   * The default value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentation()
   * @generated
   * @ordered
   */
  protected static final String DOCUMENTATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentation()
   * @generated
   * @ordered
   */
  protected String documentation = DOCUMENTATION_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrigger()
   * @generated
   * @ordered
   */
  protected Trigger trigger;

  /**
   * The cached value of the '{@link #getRoutine() <em>Routine</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoutine()
   * @generated
   * @ordered
   */
  protected ImplicitRoutine routine;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResponseImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ResponseLanguagePackage.Literals.RESPONSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDocumentation()
  {
    return documentation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDocumentation(String newDocumentation)
  {
    String oldDocumentation = documentation;
    documentation = newDocumentation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSE__DOCUMENTATION, oldDocumentation, documentation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trigger getTrigger()
  {
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTrigger(Trigger newTrigger, NotificationChain msgs)
  {
    Trigger oldTrigger = trigger;
    trigger = newTrigger;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSE__TRIGGER, oldTrigger, newTrigger);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrigger(Trigger newTrigger)
  {
    if (newTrigger != trigger)
    {
      NotificationChain msgs = null;
      if (trigger != null)
        msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.RESPONSE__TRIGGER, null, msgs);
      if (newTrigger != null)
        msgs = ((InternalEObject)newTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.RESPONSE__TRIGGER, null, msgs);
      msgs = basicSetTrigger(newTrigger, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSE__TRIGGER, newTrigger, newTrigger));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplicitRoutine getRoutine()
  {
    return routine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRoutine(ImplicitRoutine newRoutine, NotificationChain msgs)
  {
    ImplicitRoutine oldRoutine = routine;
    routine = newRoutine;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSE__ROUTINE, oldRoutine, newRoutine);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoutine(ImplicitRoutine newRoutine)
  {
    if (newRoutine != routine)
    {
      NotificationChain msgs = null;
      if (routine != null)
        msgs = ((InternalEObject)routine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.RESPONSE__ROUTINE, null, msgs);
      if (newRoutine != null)
        msgs = ((InternalEObject)newRoutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.RESPONSE__ROUTINE, null, msgs);
      msgs = basicSetRoutine(newRoutine, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSE__ROUTINE, newRoutine, newRoutine));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResponsesSegment getResponsesSegment()
  {
    if (eContainerFeatureID() != ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT) return null;
    return (ResponsesSegment)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResponsesSegment(ResponsesSegment newResponsesSegment, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newResponsesSegment, ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResponsesSegment(ResponsesSegment newResponsesSegment)
  {
    if (newResponsesSegment != eInternalContainer() || (eContainerFeatureID() != ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT && newResponsesSegment != null))
    {
      if (EcoreUtil.isAncestor(this, newResponsesSegment))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newResponsesSegment != null)
        msgs = ((InternalEObject)newResponsesSegment).eInverseAdd(this, ResponseLanguagePackage.RESPONSES_SEGMENT__RESPONSES, ResponsesSegment.class, msgs);
      msgs = basicSetResponsesSegment(newResponsesSegment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT, newResponsesSegment, newResponsesSegment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetResponsesSegment((ResponsesSegment)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.RESPONSE__TRIGGER:
        return basicSetTrigger(null, msgs);
      case ResponseLanguagePackage.RESPONSE__ROUTINE:
        return basicSetRoutine(null, msgs);
      case ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT:
        return basicSetResponsesSegment(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT:
        return eInternalContainer().eInverseRemove(this, ResponseLanguagePackage.RESPONSES_SEGMENT__RESPONSES, ResponsesSegment.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.RESPONSE__DOCUMENTATION:
        return getDocumentation();
      case ResponseLanguagePackage.RESPONSE__NAME:
        return getName();
      case ResponseLanguagePackage.RESPONSE__TRIGGER:
        return getTrigger();
      case ResponseLanguagePackage.RESPONSE__ROUTINE:
        return getRoutine();
      case ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT:
        return getResponsesSegment();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.RESPONSE__DOCUMENTATION:
        setDocumentation((String)newValue);
        return;
      case ResponseLanguagePackage.RESPONSE__NAME:
        setName((String)newValue);
        return;
      case ResponseLanguagePackage.RESPONSE__TRIGGER:
        setTrigger((Trigger)newValue);
        return;
      case ResponseLanguagePackage.RESPONSE__ROUTINE:
        setRoutine((ImplicitRoutine)newValue);
        return;
      case ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT:
        setResponsesSegment((ResponsesSegment)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.RESPONSE__DOCUMENTATION:
        setDocumentation(DOCUMENTATION_EDEFAULT);
        return;
      case ResponseLanguagePackage.RESPONSE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ResponseLanguagePackage.RESPONSE__TRIGGER:
        setTrigger((Trigger)null);
        return;
      case ResponseLanguagePackage.RESPONSE__ROUTINE:
        setRoutine((ImplicitRoutine)null);
        return;
      case ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT:
        setResponsesSegment((ResponsesSegment)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.RESPONSE__DOCUMENTATION:
        return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
      case ResponseLanguagePackage.RESPONSE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ResponseLanguagePackage.RESPONSE__TRIGGER:
        return trigger != null;
      case ResponseLanguagePackage.RESPONSE__ROUTINE:
        return routine != null;
      case ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT:
        return getResponsesSegment() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (documentation: ");
    result.append(documentation);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ResponseImpl
