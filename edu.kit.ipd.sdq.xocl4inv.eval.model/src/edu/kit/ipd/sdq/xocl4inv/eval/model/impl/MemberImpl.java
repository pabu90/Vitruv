/**
 */
package edu.kit.ipd.sdq.xocl4inv.eval.model.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.ocl.pivot.evaluation.Evaluator;

import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;

import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;

import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;

import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;

import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;

import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;

import edu.kit.ipd.sdq.xocl4inv.eval.model.Book;
import edu.kit.ipd.sdq.xocl4inv.eval.model.Library;
import edu.kit.ipd.sdq.xocl4inv.eval.model.Loan;
import edu.kit.ipd.sdq.xocl4inv.eval.model.Member;
import edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage;
import edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.MemberImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.MemberImpl#getLibrary <em>Library</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.MemberImpl#getLoans <em>Loans</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.MemberImpl#getBooks <em>Books</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemberImpl extends MinimalEObjectImpl.Container implements Member {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MEMBER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library getLibrary() {
		if (eContainerFeatureID() != ModelPackage.MEMBER__LIBRARY) return null;
		return (Library)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLibrary(Library newLibrary, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLibrary, ModelPackage.MEMBER__LIBRARY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLibrary(Library newLibrary) {
		if (newLibrary != eInternalContainer() || (eContainerFeatureID() != ModelPackage.MEMBER__LIBRARY && newLibrary != null)) {
			if (EcoreUtil.isAncestor(this, newLibrary))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLibrary != null)
				msgs = ((InternalEObject)newLibrary).eInverseAdd(this, ModelPackage.LIBRARY__MEMBERS, Library.class, msgs);
			msgs = basicSetLibrary(newLibrary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MEMBER__LIBRARY, newLibrary, newLibrary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Loan> getLoans() {
		/**
		 * library.loans->select(member = self)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@Nullable*/ /*@Thrown*/ Library library = this.getLibrary();
		if (library == null) {
		    throw new InvalidValueException("Null source for \'\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\'::Library::loans\'");
		}
		final /*@NonNull*/ /*@Thrown*/ List<Loan> loans = library.getLoans();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_loans = idResolver.createOrderedSetOfAll(ModelTables.ORD_CLSSid_Loan, loans);
		/*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ModelTables.ORD_CLSSid_Loan);
		/*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_loans.iterator();
		/*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
		while (true) {
		    if (!ITERATOR__1.hasNext()) {
		        select = accumulator;
		        break;
		    }
		    /*@Nullable*/ /*@NonInvalid*/ Loan _1 = (Loan)ITERATOR__1.next();
		    /**
		     * member = self
		     */
		    if (_1 == null) {
		        throw new InvalidValueException("Null source for \'\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\'::Loan::member\'");
		    }
		    final /*@NonNull*/ /*@Thrown*/ Member member = _1.getMember();
		    final /*@Thrown*/ boolean eq = member.equals(this);
		    //
		    if (eq == ValueUtil.TRUE_VALUE) {
		        accumulator.add(_1);
		    }
		}
		final List<Loan> UNBOXED_select = select.asEcoreObjects(idResolver, edu.kit.ipd.sdq.xocl4inv.eval.model.Loan.class);
		assert UNBOXED_select != null;
		return (EList<Loan>)UNBOXED_select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Book> getBooks() {
		/**
		 * loans->collect(book)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@Thrown*/ List<Loan> loans = this.getLoans();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_loans = idResolver.createOrderedSetOfAll(ModelTables.ORD_CLSSid_Loan, loans);
		/*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(ModelTables.SEQ_CLSSid_Book);
		/*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_loans.iterator();
		/*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		while (true) {
		    if (!ITERATOR__1.hasNext()) {
		        collect = accumulator;
		        break;
		    }
		    /*@Nullable*/ /*@NonInvalid*/ Loan _1 = (Loan)ITERATOR__1.next();
		    /**
		     * book
		     */
		    if (_1 == null) {
		        throw new InvalidValueException("Null source for \'\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\'::Loan::book\'");
		    }
		    final /*@NonNull*/ /*@Thrown*/ Book book = _1.getBook();
		    //
		    accumulator.add(book);
		}
		final List<Book> UNBOXED_collect = collect.asEcoreObjects(idResolver, edu.kit.ipd.sdq.xocl4inv.eval.model.Book.class);
		assert UNBOXED_collect != null;
		return (EList<Book>)UNBOXED_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AtMostTwoLoans(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv AtMostTwoLoans:
		 *   let severity : Integer[1] = 'Member::AtMostTwoLoans'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[1] = loans->size() <= 2
		 *       in
		 *         'Member::AtMostTwoLoans'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, ModelTables.STR_Member_c_c_AtMostTwoLoans));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, ModelTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		    try {
		        final /*@NonNull*/ /*@Thrown*/ List<Loan> loans = this.getLoans();
		        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_loans = idResolver.createOrderedSetOfAll(ModelTables.ORD_CLSSid_Loan, loans);
		        final /*@NonNull*/ /*@Thrown*/ IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_loans));
		        final /*@Thrown*/ boolean status = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, size, ModelTables.INT_2).booleanValue());
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, ModelTables.STR_Member_c_c_AtMostTwoLoans, this, diagnostics, context, severity_0, CAUGHT_status, ModelTables.INT_0).booleanValue());
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean UniqueLoans(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv UniqueLoans:
		 *   let severity : Integer[1] = 'Member::UniqueLoans'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[1] = loans->isUnique(book)
		 *       in
		 *         'Member::UniqueLoans'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, ModelTables.STR_Member_c_c_UniqueLoans));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, ModelTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		    try {
		        final /*@NonNull*/ /*@Thrown*/ List<Loan> loans = this.getLoans();
		        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_loans = idResolver.createOrderedSetOfAll(ModelTables.ORD_CLSSid_Loan, loans);
		        /*@NonNull*/ /*@Thrown*/ SetValue.Accumulator accumulator = ValueUtil.createSetAccumulatorValue(ModelTables.ORD_CLSSid_Loan);
		        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_loans.iterator();
		        /*@Thrown*/ boolean status;
		        while (true) {
		            if (!ITERATOR__1.hasNext()) {
		                status = ValueUtil.TRUE_VALUE;
		                break;
		            }
		            /*@Nullable*/ /*@NonInvalid*/ Loan _1 = (Loan)ITERATOR__1.next();
		            /**
		             * book
		             */
		            if (_1 == null) {
		                throw new InvalidValueException("Null source for \'\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\'::Loan::book\'");
		            }
		            final /*@NonNull*/ /*@Thrown*/ Book book = _1.getBook();
		            //
		            if (accumulator.includes(book) == ValueUtil.TRUE_VALUE) {
		                status = ValueUtil.FALSE_VALUE;			// Abort after second find
		                break;
		            }
		            else {
		                accumulator.add(book);
		            }
		        }
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, ModelTables.STR_Member_c_c_UniqueLoans, this, diagnostics, context, severity_0, CAUGHT_status, ModelTables.INT_0).booleanValue());
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MEMBER__LIBRARY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLibrary((Library)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MEMBER__LIBRARY:
				return basicSetLibrary(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModelPackage.MEMBER__LIBRARY:
				return eInternalContainer().eInverseRemove(this, ModelPackage.LIBRARY__MEMBERS, Library.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.MEMBER__NAME:
				return getName();
			case ModelPackage.MEMBER__LIBRARY:
				return getLibrary();
			case ModelPackage.MEMBER__LOANS:
				return getLoans();
			case ModelPackage.MEMBER__BOOKS:
				return getBooks();
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
			case ModelPackage.MEMBER__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.MEMBER__LIBRARY:
				setLibrary((Library)newValue);
				return;
			case ModelPackage.MEMBER__LOANS:
				getLoans().clear();
				getLoans().addAll((Collection<? extends Loan>)newValue);
				return;
			case ModelPackage.MEMBER__BOOKS:
				getBooks().clear();
				getBooks().addAll((Collection<? extends Book>)newValue);
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
			case ModelPackage.MEMBER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.MEMBER__LIBRARY:
				setLibrary((Library)null);
				return;
			case ModelPackage.MEMBER__LOANS:
				getLoans().clear();
				return;
			case ModelPackage.MEMBER__BOOKS:
				getBooks().clear();
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
			case ModelPackage.MEMBER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.MEMBER__LIBRARY:
				return getLibrary() != null;
			case ModelPackage.MEMBER__LOANS:
				return !getLoans().isEmpty();
			case ModelPackage.MEMBER__BOOKS:
				return !getBooks().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ModelPackage.MEMBER___AT_MOST_TWO_LOANS__DIAGNOSTICCHAIN_MAP:
				return AtMostTwoLoans((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ModelPackage.MEMBER___UNIQUE_LOANS__DIAGNOSTICCHAIN_MAP:
				return UniqueLoans((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MemberImpl
