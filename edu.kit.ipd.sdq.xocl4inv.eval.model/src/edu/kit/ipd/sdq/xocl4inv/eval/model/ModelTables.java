/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 * using:
 *   /edu.kit.ipd.sdq.xocl4inv.eval.model/Model.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package edu.kit.ipd.sdq.xocl4inv.eval.model;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * ModelTables provides the dispatch tables for the model for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class ModelTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final /*@NonNull*/ EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(ModelPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final /*@NonNull*/ ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_sfiss_s_xbase_s_model = IdManager.getNsURIPackageId("http://sdq.ipd.kit.edu/xocl4inv/eval/model", null, ModelPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Book = ModelTables.PACKid_http_c_s_s_sfiss_s_xbase_s_model.getClassId("Book", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Library = ModelTables.PACKid_http_c_s_s_sfiss_s_xbase_s_model.getClassId("Library", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Loan = ModelTables.PACKid_http_c_s_s_sfiss_s_xbase_s_model.getClassId("Loan", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Member = ModelTables.PACKid_http_c_s_s_sfiss_s_xbase_s_model.getClassId("Member", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ DataTypeId DATAid_EInt = ModelTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_0 = ValueUtil.integerValueOf("0");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_2 = ValueUtil.integerValueOf("2");
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Book_c_c_SufficientCopies = "Book::SufficientCopies";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Member_c_c_AtMostTwoLoans = "Member::AtMostTwoLoans";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Member_c_c_UniqueLoans = "Member::UniqueLoans";
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_Book = TypeId.BAG.getSpecializedId(ModelTables.CLSSid_Book);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_Loan = TypeId.BAG.getSpecializedId(ModelTables.CLSSid_Loan);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_Member = TypeId.BAG.getSpecializedId(ModelTables.CLSSid_Member);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Book = TypeId.ORDERED_SET.getSpecializedId(ModelTables.CLSSid_Book);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Loan = TypeId.ORDERED_SET.getSpecializedId(ModelTables.CLSSid_Loan);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Member = TypeId.ORDERED_SET.getSpecializedId(ModelTables.CLSSid_Member);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Book = TypeId.SEQUENCE.getSpecializedId(ModelTables.CLSSid_Book);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			ModelTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ModelTables::TypeParameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		static {
			Init.initStart();
			TypeParameters.init();
		}

		public static final /*@NonNull*/ EcoreExecutorType _Book = new EcoreExecutorType(ModelPackage.Literals.BOOK, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Library = new EcoreExecutorType(ModelPackage.Literals.LIBRARY, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Loan = new EcoreExecutorType(ModelPackage.Literals.LOAN, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Member = new EcoreExecutorType(ModelPackage.Literals.MEMBER, PACKAGE, 0);

		private static final /*@NonNull*/ EcoreExecutorType[] types = {
			_Book,
			_Library,
			_Loan,
			_Member
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ModelTables::Types and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		static {
			Init.initStart();
			Types.init();
		}

		private static final /*@NonNull*/ ExecutorFragment _Book__Book = new ExecutorFragment(Types._Book, ModelTables.Types._Book);
		private static final /*@NonNull*/ ExecutorFragment _Book__OclAny = new ExecutorFragment(Types._Book, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Book__OclElement = new ExecutorFragment(Types._Book, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Library__Library = new ExecutorFragment(Types._Library, ModelTables.Types._Library);
		private static final /*@NonNull*/ ExecutorFragment _Library__OclAny = new ExecutorFragment(Types._Library, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Library__OclElement = new ExecutorFragment(Types._Library, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Loan__Loan = new ExecutorFragment(Types._Loan, ModelTables.Types._Loan);
		private static final /*@NonNull*/ ExecutorFragment _Loan__OclAny = new ExecutorFragment(Types._Loan, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Loan__OclElement = new ExecutorFragment(Types._Loan, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Member__Member = new ExecutorFragment(Types._Member, ModelTables.Types._Member);
		private static final /*@NonNull*/ ExecutorFragment _Member__OclAny = new ExecutorFragment(Types._Member, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Member__OclElement = new ExecutorFragment(Types._Member, OCLstdlibTables.Types._OclElement);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ModelTables::Fragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The parameter lists shared by operations.
	 */
	public static class Parameters {
		static {
			Init.initStart();
			Fragments.init();
		}

		public static final /*@NonNull*/ ParameterTypes _ = TypeUtil.createParameterTypes();

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ModelTables::Parameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 */
	public static class Operations {
		static {
			Init.initStart();
			Parameters.init();
		}

		public static final /*@NonNull*/ ExecutorOperation _Book__isAvailable = new ExecutorOperation("isAvailable", Parameters._, Types._Book,
			0, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ModelTables::Operations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The property descriptors for each property of each type.
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}

		public static final /*@NonNull*/ ExecutorProperty _Book__copies = new EcoreExecutorProperty(ModelPackage.Literals.BOOK__COPIES, Types._Book, 0);
		public static final /*@NonNull*/ ExecutorProperty _Book__library = new EcoreExecutorProperty(ModelPackage.Literals.BOOK__LIBRARY, Types._Book, 1);
		public static final /*@NonNull*/ ExecutorProperty _Book__loans = new EcoreExecutorProperty(ModelPackage.Literals.BOOK__LOANS, Types._Book, 2);
		public static final /*@NonNull*/ ExecutorProperty _Book__name = new EcoreExecutorProperty(ModelPackage.Literals.BOOK__NAME, Types._Book, 3);
		public static final /*@NonNull*/ ExecutorProperty _Book__Loan__book = new ExecutorPropertyWithImplementation("Loan", Types._Book, 4, new EcoreLibraryOppositeProperty(ModelPackage.Literals.LOAN__BOOK));
		public static final /*@NonNull*/ ExecutorProperty _Book__Member__books = new ExecutorPropertyWithImplementation("Member", Types._Book, 5, new EcoreLibraryOppositeProperty(ModelPackage.Literals.MEMBER__BOOKS));

		public static final /*@NonNull*/ ExecutorProperty _Library__books = new EcoreExecutorProperty(ModelPackage.Literals.LIBRARY__BOOKS, Types._Library, 0);
		public static final /*@NonNull*/ ExecutorProperty _Library__loans = new EcoreExecutorProperty(ModelPackage.Literals.LIBRARY__LOANS, Types._Library, 1);
		public static final /*@NonNull*/ ExecutorProperty _Library__members = new EcoreExecutorProperty(ModelPackage.Literals.LIBRARY__MEMBERS, Types._Library, 2);
		public static final /*@NonNull*/ ExecutorProperty _Library__name = new EcoreExecutorProperty(ModelPackage.Literals.LIBRARY__NAME, Types._Library, 3);

		public static final /*@NonNull*/ ExecutorProperty _Loan__book = new EcoreExecutorProperty(ModelPackage.Literals.LOAN__BOOK, Types._Loan, 0);
		public static final /*@NonNull*/ ExecutorProperty _Loan__member = new EcoreExecutorProperty(ModelPackage.Literals.LOAN__MEMBER, Types._Loan, 1);
		public static final /*@NonNull*/ ExecutorProperty _Loan__weeks = new EcoreExecutorProperty(ModelPackage.Literals.LOAN__WEEKS, Types._Loan, 2);
		public static final /*@NonNull*/ ExecutorProperty _Loan__Book__loans = new ExecutorPropertyWithImplementation("Book", Types._Loan, 3, new EcoreLibraryOppositeProperty(ModelPackage.Literals.BOOK__LOANS));
		public static final /*@NonNull*/ ExecutorProperty _Loan__Library__loans = new ExecutorPropertyWithImplementation("Library", Types._Loan, 4, new EcoreLibraryOppositeProperty(ModelPackage.Literals.LIBRARY__LOANS));
		public static final /*@NonNull*/ ExecutorProperty _Loan__Member__loans = new ExecutorPropertyWithImplementation("Member", Types._Loan, 5, new EcoreLibraryOppositeProperty(ModelPackage.Literals.MEMBER__LOANS));

		public static final /*@NonNull*/ ExecutorProperty _Member__books = new EcoreExecutorProperty(ModelPackage.Literals.MEMBER__BOOKS, Types._Member, 0);
		public static final /*@NonNull*/ ExecutorProperty _Member__library = new EcoreExecutorProperty(ModelPackage.Literals.MEMBER__LIBRARY, Types._Member, 1);
		public static final /*@NonNull*/ ExecutorProperty _Member__loans = new EcoreExecutorProperty(ModelPackage.Literals.MEMBER__LOANS, Types._Member, 2);
		public static final /*@NonNull*/ ExecutorProperty _Member__name = new EcoreExecutorProperty(ModelPackage.Literals.MEMBER__NAME, Types._Member, 3);
		public static final /*@NonNull*/ ExecutorProperty _Member__Loan__member = new ExecutorPropertyWithImplementation("Loan", Types._Member, 4, new EcoreLibraryOppositeProperty(ModelPackage.Literals.LOAN__MEMBER));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ModelTables::Properties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		static {
			Init.initStart();
			Properties.init();
		}

		private static final /*@NonNull*/ ExecutorFragment[] _Book =
		{
			Fragments._Book__OclAny /* 0 */,
			Fragments._Book__OclElement /* 1 */,
			Fragments._Book__Book /* 2 */
		};
		private static final /*@NonNull*/ int[] __Book = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Library =
		{
			Fragments._Library__OclAny /* 0 */,
			Fragments._Library__OclElement /* 1 */,
			Fragments._Library__Library /* 2 */
		};
		private static final /*@NonNull*/ int[] __Library = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Loan =
		{
			Fragments._Loan__OclAny /* 0 */,
			Fragments._Loan__OclElement /* 1 */,
			Fragments._Loan__Loan /* 2 */
		};
		private static final /*@NonNull*/ int[] __Loan = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Member =
		{
			Fragments._Member__OclAny /* 0 */,
			Fragments._Member__OclElement /* 1 */,
			Fragments._Member__Member /* 2 */
		};
		private static final /*@NonNull*/ int[] __Member = { 1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Book.initFragments(_Book, __Book);
			Types._Library.initFragments(_Library, __Library);
			Types._Loan.initFragments(_Loan, __Loan);
			Types._Member.initFragments(_Member, __Member);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ModelTables::TypeFragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		static {
			Init.initStart();
			TypeFragments.init();
		}

		private static final /*@NonNull*/ ExecutorOperation[] _Book__Book = {
			ModelTables.Operations._Book__isAvailable /* isAvailable() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Book__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Book__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _Library__Library = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Library__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Library__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _Loan__Loan = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Loan__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Loan__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _Member__Member = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Member__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Member__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Book__Book.initOperations(_Book__Book);
			Fragments._Book__OclAny.initOperations(_Book__OclAny);
			Fragments._Book__OclElement.initOperations(_Book__OclElement);

			Fragments._Library__Library.initOperations(_Library__Library);
			Fragments._Library__OclAny.initOperations(_Library__OclAny);
			Fragments._Library__OclElement.initOperations(_Library__OclElement);

			Fragments._Loan__Loan.initOperations(_Loan__Loan);
			Fragments._Loan__OclAny.initOperations(_Loan__OclAny);
			Fragments._Loan__OclElement.initOperations(_Loan__OclElement);

			Fragments._Member__Member.initOperations(_Member__Member);
			Fragments._Member__OclAny.initOperations(_Member__OclAny);
			Fragments._Member__OclElement.initOperations(_Member__OclElement);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ModelTables::FragmentOperations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		static {
			Init.initStart();
			FragmentOperations.init();
		}

		private static final /*@NonNull*/ ExecutorProperty[] _Book = {
			ModelTables.Properties._Book__copies,
			ModelTables.Properties._Book__library,
			ModelTables.Properties._Book__loans,
			ModelTables.Properties._Book__name,
			ModelTables.Properties._Book__Loan__book,
			ModelTables.Properties._Book__Member__books
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Library = {
			ModelTables.Properties._Library__books,
			ModelTables.Properties._Library__loans,
			ModelTables.Properties._Library__members,
			ModelTables.Properties._Library__name
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Loan = {
			ModelTables.Properties._Loan__book,
			ModelTables.Properties._Loan__member,
			ModelTables.Properties._Loan__weeks,
			ModelTables.Properties._Loan__Book__loans,
			ModelTables.Properties._Loan__Library__loans,
			ModelTables.Properties._Loan__Member__loans
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Member = {
			ModelTables.Properties._Member__books,
			ModelTables.Properties._Member__library,
			ModelTables.Properties._Member__loans,
			ModelTables.Properties._Member__name,
			ModelTables.Properties._Member__Loan__member
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Book__Book.initProperties(_Book);
			Fragments._Library__Library.initProperties(_Library);
			Fragments._Loan__Loan.initProperties(_Loan);
			Fragments._Member__Member.initProperties(_Member);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ModelTables::FragmentProperties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		static {
			Init.initStart();
			FragmentProperties.init();
		}

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ModelTables::EnumerationLiterals and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 * The multiple packages above avoid problems with the Java 65536 byte limit but introduce a difficulty in ensuring that
	 * static construction occurs in the disciplined order of the packages when construction may start in any of the packages.
	 * The problem is resolved by ensuring that the static construction of each package first initializes its immediate predecessor.
	 * On completion of predecessor initialization, the residual packages are initialized by starting an initialization in the last package.
	 * This class maintains a count so that the various predecessors can distinguish whether they are the starting point and so
	 * ensure that residual construction occurs just once after all predecessors.
	 */
	private static class Init {
		/**
		 * Counter of nested static constructions. On return to zero residual construction starts. -ve once residual construction started.
		 */
		private static int initCount = 0;

		/**
		 * Invoked at the start of a static construction to defer residual cobstruction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual cobstruction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
				}
			}
		}
	}

	static {
		Init.initEnd();
	}

	/*
	 * Force initialization of outer fields. Inner fields are lazily initialized.
	 */
	public static void init() {}
}
