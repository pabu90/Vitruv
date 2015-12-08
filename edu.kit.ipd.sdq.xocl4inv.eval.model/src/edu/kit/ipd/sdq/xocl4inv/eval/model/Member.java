/**
 */
package edu.kit.ipd.sdq.xocl4inv.eval.model;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getLibrary <em>Library</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getLoans <em>Loans</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getBooks <em>Books</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getMember()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AtMostTwoLoans UniqueLoans'"
 * @generated
 */
public interface Member extends EObject {
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
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getMember_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Member!name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Library</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library</em>' container reference.
	 * @see #setLibrary(Library)
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getMember_Library()
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.Library#getMembers
	 * @model opposite="members" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://sdq.ipd.kit.edu/xocl4inv/eval/model!Member!library'"
	 * @generated
	 */
	Library getLibrary();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.xocl4inv.eval.model.Member#getLibrary <em>Library</em>}' container reference.
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
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getMember_Loans()
	 * @model volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * library.loans->select(member = self)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@Nullable\052/ /*@Thrown\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Library%> library = this.getLibrary();\nif (library == null) {\n    throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\\\'::Library::loans\\\'\");\n}\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>> loans = library.getLoans();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_loans = idResolver.createOrderedSetOfAll(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan, loans);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createOrderedSetAccumulatorValue(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR__1 = BOXED_loans.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> select;\nwhile (true) {\n    if (!ITERATOR__1.hasNext()) {\n        select = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%> _1 = (<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>)ITERATOR__1.next();\n    /**\n     * member = self\n     \052/\n    if (_1 == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\\\'::Loan::member\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Member%> member = _1.getMember();\n    final /*@Thrown\052/ boolean eq = member.equals(this);\n    //\n    if (eq == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n        accumulator.add(_1);\n    }\n}\nfinal <%java.util.List%><<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>> UNBOXED_select = select.asEcoreObjects(idResolver, edu.kit.ipd.sdq.xocl4inv.eval.model.Loan.class);\nassert UNBOXED_select != null;\nreturn (<%org.eclipse.emf.common.util.EList<edu.kit.ipd.sdq.xocl4inv.eval.model.Loan>%>)UNBOXED_select;'"
	 * @generated
	 */
	EList<Loan> getLoans();

	/**
	 * Returns the value of the '<em><b>Books</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.xocl4inv.eval.model.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' reference list.
	 * @see edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage#getMember_Books()
	 * @model volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * loans->collect(book)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>> loans = this.getLoans();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_loans = idResolver.createOrderedSetOfAll(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan, loans);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.SEQ_CLSSid_Book);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR__1 = BOXED_loans.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\nwhile (true) {\n    if (!ITERATOR__1.hasNext()) {\n        collect = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%> _1 = (<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>)ITERATOR__1.next();\n    /**\n     * book\n     \052/\n    if (_1 == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\\\'::Loan::book\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Book%> book = _1.getBook();\n    //\n    accumulator.add(book);\n}\nfinal <%java.util.List%><<%edu.kit.ipd.sdq.xocl4inv.eval.model.Book%>> UNBOXED_collect = collect.asEcoreObjects(idResolver, edu.kit.ipd.sdq.xocl4inv.eval.model.Book.class);\nassert UNBOXED_collect != null;\nreturn (<%org.eclipse.emf.common.util.EList<edu.kit.ipd.sdq.xocl4inv.eval.model.Book>%>)UNBOXED_collect;'"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv AtMostTwoLoans:\n *   let severity : Integer[1] = \'Member::AtMostTwoLoans\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let status : Boolean[1] = loans->size() <= 2\n *       in\n *         \'Member::AtMostTwoLoans\'.logDiagnostic(self, diagnostics, context, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.STR_Member_c_c_AtMostTwoLoans));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>> loans = this.getLoans();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_loans = idResolver.createOrderedSetOfAll(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan, loans);\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_loans));\n        final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, size, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.INT_2).booleanValue());\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.STR_Member_c_c_AtMostTwoLoans, this, diagnostics, context, severity_0, CAUGHT_status, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean AtMostTwoLoans(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv UniqueLoans:\n *   let severity : Integer[1] = \'Member::UniqueLoans\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let status : Boolean[1] = loans->isUnique(book)\n *       in\n *         \'Member::UniqueLoans\'.logDiagnostic(self, diagnostics, context, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.STR_Member_c_c_UniqueLoans));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>> loans = this.getLoans();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_loans = idResolver.createOrderedSetOfAll(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan, loans);\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSetAccumulatorValue(<%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.ORD_CLSSid_Loan);\n        /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR__1 = BOXED_loans.iterator();\n        /*@Thrown\052/ boolean status;\n        while (true) {\n            if (!ITERATOR__1.hasNext()) {\n                status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n                break;\n            }\n            /*@Nullable\052/ /*@NonInvalid\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%> _1 = (<%edu.kit.ipd.sdq.xocl4inv.eval.model.Loan%>)ITERATOR__1.next();\n            /**\n             * book\n             \052/\n            if (_1 == null) {\n                throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://sdq.ipd.kit.edu/xocl4inv/eval/model\\\'::Loan::book\\\'\");\n            }\n            final /*@NonNull\052/ /*@Thrown\052/ <%edu.kit.ipd.sdq.xocl4inv.eval.model.Book%> book = _1.getBook();\n            //\n            if (accumulator.includes(book) == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n                status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\t\t\t// Abort after second find\n                break;\n            }\n            else {\n                accumulator.add(book);\n            }\n        }\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.STR_Member_c_c_UniqueLoans, this, diagnostics, context, severity_0, CAUGHT_status, <%edu.kit.ipd.sdq.xocl4inv.eval.model.ModelTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean UniqueLoans(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Member
