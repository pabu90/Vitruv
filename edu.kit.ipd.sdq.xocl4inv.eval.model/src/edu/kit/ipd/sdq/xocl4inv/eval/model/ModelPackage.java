/**
 */
package edu.kit.ipd.sdq.xocl4inv.eval.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.kit.edu/xocl4inv/eval/model";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	ModelPackage eINSTANCE = edu.kit.ipd.sdq.xocl4inv.eval.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.LibraryImpl
	 * <em>Library</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.LibraryImpl
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.ModelPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Books</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIBRARY__BOOKS = 1;

	/**
	 * The feature id for the '<em><b>Loans</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIBRARY__LOANS = 2;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIBRARY__MEMBERS = 3;

	/**
	 * The number of structural features of the '<em>Library</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Library</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIBRARY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.BookImpl <em>Book</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.BookImpl
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.ModelPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Copies</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK__COPIES = 1;

	/**
	 * The feature id for the '<em><b>Library</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK__LIBRARY = 2;

	/**
	 * The feature id for the '<em><b>Loans</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK__LOANS = 3;

	/**
	 * The number of structural features of the '<em>Book</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Is Available</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK___IS_AVAILABLE = 0;

	/**
	 * The operation id for the '<em>Sufficient Copies</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK___SUFFICIENT_COPIES__DIAGNOSTICCHAIN_MAP = 1;

	/**
	 * The number of operations of the '<em>Book</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.MemberImpl
	 * <em>Member</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.MemberImpl
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.ModelPackageImpl#getMember()
	 * @generated
	 */
	int MEMBER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Library</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER__LIBRARY = 1;

	/**
	 * The feature id for the '<em><b>Loans</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER__LOANS = 2;

	/**
	 * The feature id for the '<em><b>Books</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER__BOOKS = 3;

	/**
	 * The number of structural features of the '<em>Member</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>At Most Two Loans</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER___AT_MOST_TWO_LOANS__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The operation id for the '<em>Unique Loans</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER___UNIQUE_LOANS__DIAGNOSTICCHAIN_MAP = 1;

	/**
	 * The number of operations of the '<em>Member</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.LoanImpl <em>Loan</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.LoanImpl
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.ModelPackageImpl#getLoan()
	 * @generated
	 */
	int LOAN = 3;

	/**
	 * The feature id for the '<em><b>Book</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOAN__BOOK = 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOAN__MEMBER = 1;

	/**
	 * The feature id for the '<em><b>Weeks</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOAN__WEEKS = 2;

	/**
	 * The number of structural features of the '<em>Loan</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOAN_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Loan</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOAN_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library <em>Library</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Library</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the attribute '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getName <em>Name</em>
	 * }'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getName()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Name();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getBooks
	 * <em>Books</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Books</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getBooks()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Books();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getLoans
	 * <em>Loans</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Loans</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getLoans()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Loans();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getMembers
	 * <em>Members</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Members</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getMembers()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Members();

	/**
	 * Returns the meta object for class '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book <em>Book</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Book</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the attribute '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getName()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getCopies <em>Copies</em>
	 * }'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Copies</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getCopies()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Copies();

	/**
	 * Returns the meta object for the container reference '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getLibrary
	 * <em>Library</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Library</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getLibrary()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_Library();

	/**
	 * Returns the meta object for the reference list '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getLoans <em>Loans</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Loans</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getLoans()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_Loans();

	/**
	 * Returns the meta object for the '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#isAvailable()
	 * <em>Is Available</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Is Available</em>' operation.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Book#isAvailable()
	 * @generated
	 */
	EOperation getBook__IsAvailable();

	/**
	 * Returns the meta object for the '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#SufficientCopies(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Sufficient Copies</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Sufficient Copies</em>' operation.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Book#SufficientCopies(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 */
	EOperation getBook__SufficientCopies__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member <em>Member</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Member</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Member
	 * @generated
	 */
	EClass getMember();

	/**
	 * Returns the meta object for the attribute '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getName <em>Name</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getName()
	 * @see #getMember()
	 * @generated
	 */
	EAttribute getMember_Name();

	/**
	 * Returns the meta object for the container reference '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getLibrary
	 * <em>Library</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Library</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getLibrary()
	 * @see #getMember()
	 * @generated
	 */
	EReference getMember_Library();

	/**
	 * Returns the meta object for the reference list '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getLoans <em>Loans</em>
	 * }'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Loans</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getLoans()
	 * @see #getMember()
	 * @generated
	 */
	EReference getMember_Loans();

	/**
	 * Returns the meta object for the reference list '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getBooks <em>Books</em>
	 * }'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Books</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getBooks()
	 * @see #getMember()
	 * @generated
	 */
	EReference getMember_Books();

	/**
	 * Returns the meta object for the '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#AtMostTwoLoans(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>At Most Two Loans</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the '<em>At Most Two Loans</em>' operation.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Member#AtMostTwoLoans(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 */
	EOperation getMember__AtMostTwoLoans__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#UniqueLoans(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Unique Loans</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Unique Loans</em>' operation.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Member#UniqueLoans(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 */
	EOperation getMember__UniqueLoans__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan <em>Loan</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Loan</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Loan
	 * @generated
	 */
	EClass getLoan();

	/**
	 * Returns the meta object for the reference '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getBook <em>Book</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Book</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getBook()
	 * @see #getLoan()
	 * @generated
	 */
	EReference getLoan_Book();

	/**
	 * Returns the meta object for the reference '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getMember <em>Member</em>
	 * }'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Member</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getMember()
	 * @see #getLoan()
	 * @generated
	 */
	EReference getLoan_Member();

	/**
	 * Returns the meta object for the attribute '
	 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getWeeks <em>Weeks</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Weeks</em>'.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getWeeks()
	 * @see #getLoan()
	 * @generated
	 */
	EAttribute getLoan_Weeks();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.LibraryImpl
		 * <em>Library</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.LibraryImpl
		 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.ModelPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIBRARY__NAME = eINSTANCE.getLibrary_Name();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LIBRARY__BOOKS = eINSTANCE.getLibrary_Books();

		/**
		 * The meta object literal for the '<em><b>Loans</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LIBRARY__LOANS = eINSTANCE.getLibrary_Loans();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LIBRARY__MEMBERS = eINSTANCE.getLibrary_Members();

		/**
		 * The meta object literal for the '
		 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.BookImpl
		 * <em>Book</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.BookImpl
		 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.ModelPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOOK__NAME = eINSTANCE.getBook_Name();

		/**
		 * The meta object literal for the '<em><b>Copies</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOOK__COPIES = eINSTANCE.getBook_Copies();

		/**
		 * The meta object literal for the '<em><b>Library</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BOOK__LIBRARY = eINSTANCE.getBook_Library();

		/**
		 * The meta object literal for the '<em><b>Loans</b></em>' reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BOOK__LOANS = eINSTANCE.getBook_Loans();

		/**
		 * The meta object literal for the '<em><b>Is Available</b></em>'
		 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation BOOK___IS_AVAILABLE = eINSTANCE.getBook__IsAvailable();

		/**
		 * The meta object literal for the '<em><b>Sufficient Copies</b></em>'
		 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation BOOK___SUFFICIENT_COPIES__DIAGNOSTICCHAIN_MAP = eINSTANCE
				.getBook__SufficientCopies__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '
		 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.MemberImpl
		 * <em>Member</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.MemberImpl
		 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.ModelPackageImpl#getMember()
		 * @generated
		 */
		EClass MEMBER = eINSTANCE.getMember();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MEMBER__NAME = eINSTANCE.getMember_Name();

		/**
		 * The meta object literal for the '<em><b>Library</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MEMBER__LIBRARY = eINSTANCE.getMember_Library();

		/**
		 * The meta object literal for the '<em><b>Loans</b></em>' reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MEMBER__LOANS = eINSTANCE.getMember_Loans();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MEMBER__BOOKS = eINSTANCE.getMember_Books();

		/**
		 * The meta object literal for the '<em><b>At Most Two Loans</b></em>'
		 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation MEMBER___AT_MOST_TWO_LOANS__DIAGNOSTICCHAIN_MAP = eINSTANCE
				.getMember__AtMostTwoLoans__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Unique Loans</b></em>'
		 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation MEMBER___UNIQUE_LOANS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMember__UniqueLoans__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '
		 * {@link edu.kit.ipd.sdq.xocl4inv.eval.model.impl.LoanImpl
		 * <em>Loan</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.LoanImpl
		 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.impl.ModelPackageImpl#getLoan()
		 * @generated
		 */
		EClass LOAN = eINSTANCE.getLoan();

		/**
		 * The meta object literal for the '<em><b>Book</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LOAN__BOOK = eINSTANCE.getLoan_Book();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LOAN__MEMBER = eINSTANCE.getLoan_Member();

		/**
		 * The meta object literal for the '<em><b>Weeks</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LOAN__WEEKS = eINSTANCE.getLoan_Weeks();

	}

} // ModelPackage
