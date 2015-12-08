/**
 */
package edu.kit.ipd.sdq.xocl4inv.eval.model;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getCopies <em>Copies</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getLibrary <em>Library</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getLoans <em>Loans</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getBook()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SufficientCopies'"
 * @generated
 */
public interface Book extends EObject {
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
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getBook_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Book!name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Copies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copies</em>' attribute.
	 * @see #setCopies(int)
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getBook_Copies()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Book!copies'"
	 * @generated
	 */
	int getCopies();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getCopies <em>Copies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copies</em>' attribute.
	 * @see #getCopies()
	 * @generated
	 */
	void setCopies(int value);

	/**
	 * Returns the value of the '<em><b>Library</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library</em>' container reference.
	 * @see #setLibrary(Library)
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getBook_Library()
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getBooks
	 * @model opposite="books" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Book!library'"
	 * @generated
	 */
	Library getLibrary();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book#getLibrary <em>Library</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Library</em>' container reference.
	 * @see #getLibrary()
	 * @generated
	 */
	void setLibrary(Library value);

	/**
	 * Returns the value of the '<em><b>Loans</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Loan}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loans</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loans</em>' reference list.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getBook_Loans()
	 * @model volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * library.loans->select(book = self)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@Nullable\052/ /*@Thrown\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Library%> library = this.getLibrary();\nif (library == null) {\n    throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\\\'::Library::loans\\\'\");\n}\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>> loans = library.getLoans();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_loans = idResolver.createOrderedSetOfAll(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan, loans);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createOrderedSetAccumulatorValue(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR__1 = BOXED_loans.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> select;\nwhile (true) {\n    if (!ITERATOR__1.hasNext()) {\n        select = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%> _1 = (<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>)ITERATOR__1.next();\n    /**\n     * book = self\n     \052/\n    if (_1 == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\\\'::Loan::book\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Book%> book = _1.getBook();\n    final /*@Thrown\052/ boolean eq = book.equals(this);\n    //\n    if (eq == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n        accumulator.add(_1);\n    }\n}\nfinal <%java.util.List%><<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>> UNBOXED_select = select.asEcoreObjects(idResolver, edu.kit.ipd.sdq.xocl4inv.eval.model.Loan.class);\nassert UNBOXED_select != null;\nreturn (<%org.eclipse.emf.common.util.EList<edu.kit.ipd.sdq.xocl4inv.eval.model.Loan>%>)UNBOXED_select;'"
	 * @generated
	 */
	EList<Loan> getLoans();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * loans->size() < copies\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>> loans = this.getLoans();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_loans = idResolver.createOrderedSetOfAll(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan, loans);\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_loans));\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> copies = this.getCopies();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> BOXED_copies = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.integerValueOf(copies);\nfinal /*@Thrown\052/ boolean lt = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation%>.INSTANCE.evaluate(evaluator, size, BOXED_copies).booleanValue());\nreturn lt;'"
	 * @generated
	 */
	boolean isAvailable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv SufficientCopies:\n *   let severity : Integer[1] = \'Book::SufficientCopies\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : Boolean[1] = library.loans->select((book = self))\n *         ->size() <= copies\n *       in\n *         \'Book::SufficientCopies\'.logDiagnostic(self, diagnostics, context, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.STR_Book_c_c_SufficientCopies));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@Nullable\052/ /*@Thrown\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Library%> library = this.getLibrary();\n        if (library == null) {\n            throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\\\'::Library::loans\\\'\");\n        }\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>> loans = library.getLoans();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_loans = idResolver.createOrderedSetOfAll(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan, loans);\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createOrderedSetAccumulatorValue(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan);\n        /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR__1 = BOXED_loans.iterator();\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> select;\n        while (true) {\n            if (!ITERATOR__1.hasNext()) {\n                select = accumulator;\n                break;\n            }\n            /*@Nullable\052/ /*@NonInvalid\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%> _1 = (<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>)ITERATOR__1.next();\n            /**\n             * book = self\n             \052/\n            if (_1 == null) {\n                throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\\\'::Loan::book\\\'\");\n            }\n            final /*@NonNull\052/ /*@Thrown\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Book%> book = _1.getBook();\n            final /*@Thrown\052/ boolean eq = book.equals(this);\n            //\n            if (eq == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n                accumulator.add(_1);\n            }\n        }\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(select));\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> copies = this.getCopies();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> BOXED_copies = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.integerValueOf(copies);\n        final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, size, BOXED_copies).booleanValue());\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.STR_Book_c_c_SufficientCopies, this, diagnostics, context, severity_0, CAUGHT_status, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean SufficientCopies(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Book
