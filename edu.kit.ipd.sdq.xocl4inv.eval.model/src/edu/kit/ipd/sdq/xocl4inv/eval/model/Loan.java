/**
 */
package edu.kit.ipd.sdq.xocl4inv.eval.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getBook <em>Book</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getMember <em>Member</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getWeeks <em>Weeks</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getLoan()
 * @model
 * @generated
 */
public interface Loan extends EObject {
	/**
	 * Returns the value of the '<em><b>Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Book</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Book</em>' reference.
	 * @see #setBook(Book)
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getLoan_Book()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Loan!book'"
	 * @generated
	 */
	Book getBook();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getBook <em>Book</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Book</em>' reference.
	 * @see #getBook()
	 * @generated
	 */
	void setBook(Book value);

	/**
	 * Returns the value of the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' reference.
	 * @see #setMember(Member)
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getLoan_Member()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Loan!member'"
	 * @generated
	 */
	Member getMember();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getMember <em>Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member</em>' reference.
	 * @see #getMember()
	 * @generated
	 */
	void setMember(Member value);

	/**
	 * Returns the value of the '<em><b>Weeks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weeks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weeks</em>' attribute.
	 * @see #setWeeks(int)
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getLoan_Weeks()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Loan!weeks'"
	 * @generated
	 */
	int getWeeks();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan#getWeeks <em>Weeks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weeks</em>' attribute.
	 * @see #getWeeks()
	 * @generated
	 */
	void setWeeks(int value);

} // Loan
