/**
 */
package edu.kit.ipd.sdq.xocl4inv.eval.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getBooks <em>Books</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getLoans <em>Loans</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getLibrary_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Library!name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book}.
	 * It is bidirectional and its opposite is '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getLibrary_Books()
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getLibrary
	 * @model opposite="library" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Library!books'"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * Returns the value of the '<em><b>Loans</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loans</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loans</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getLibrary_Loans()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Library!loans'"
	 * @generated
	 */
	EList<Loan> getLoans();

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member}.
	 * It is bidirectional and its opposite is '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getLibrary_Members()
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getLibrary
	 * @model opposite="library" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Library!members'"
	 * @generated
	 */
	EList<Member> getMembers();

} // Library
