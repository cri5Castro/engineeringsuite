package symbolicEvaluator;

import evaluation.DiffAndEvaluator;
import gui.MathPane;

/**
 * This class translate the upperCase Commands to the specified command that
 * MathEclipse understand
 * 
 * @author pablo Salinas
 * 
 */
public class Commands {

	static char comillas = (int) 34;// "

	/**
	 * Translate the upperCase string to the matheclipse syntaxes
	 * 
	 * @param aux
	 * @return The respective matheclipse command
	 */
	public static String translate(String aux) {// Pi=\u03c0 in unicode
		if (aux.equalsIgnoreCase("INFINITY"))
			return ("Infinity");// Infinity number
		if (aux.equalsIgnoreCase("COS"))
			return "Cos";
		if (aux.equalsIgnoreCase("SIN"))
			return "Sin";
		if (aux.equalsIgnoreCase("TAN"))
			return "Tan";
		if (aux.equalsIgnoreCase("PI"))
			return "Pi";
		if (aux.equalsIgnoreCase("E"))
			return "E";
		if (aux.equalsIgnoreCase("EXP"))
			return "Exp";
		if (aux.equalsIgnoreCase("LOG"))
			return "Log";
		if (aux.equalsIgnoreCase("SINH"))
			return "Sinh";
		if (aux.equalsIgnoreCase("COSH"))
			return "Cosh";
		if (aux.equalsIgnoreCase("TANH"))
			return "Tanh";
		if (aux.equalsIgnoreCase("ARCSIN"))
			return "ArcSin";
		if (aux.equalsIgnoreCase("ARCCOS"))
			return "ArcCos";
		if (aux.equalsIgnoreCase("ARCTAN"))
			return "ArcTan";
		if (aux.equalsIgnoreCase("TRACE"))
			return "Trace";
		if (aux.equalsIgnoreCase("DERIV"))
			return "D";// if D or N have a value, then matheclipse can't
		if (aux.equalsIgnoreCase("NUM"))
			return "N";// make derivatives, in order to avoid that
		if (aux.equalsIgnoreCase("PRIMEQ"))
			return "PrimeQ";// N and D are reserved words
		if (aux.equalsIgnoreCase("NEXTPRIME"))
			return "NextPrime";
		if (aux.equalsIgnoreCase("INVERSE"))
			return "Inverse";
		if (aux.equalsIgnoreCase("DET"))
			return "Det";
		if (aux.equalsIgnoreCase("EIGENVALUES"))
			return "Eigenvalues";
		if (aux.equalsIgnoreCase("EIGENVECTORS"))
			return "Eigenvectors";
		if (aux.equalsIgnoreCase("TRANSPOSE"))
			return "Transpose";
		if (aux.equalsIgnoreCase("MATRIXPOWER"))
			return "MatrixPower";
		if (aux.equalsIgnoreCase("HILBERTMATRIX"))
			return "HilbertMatrix";
		if (aux.equalsIgnoreCase("IDENTITYMATRIX"))
			return "IdentityMatrix";
		if (aux.equalsIgnoreCase("LUDECOMPOSITION"))
			return "LUDecomposition";
		if (aux.equalsIgnoreCase("LINEARSOLVE"))
			return "LinearSolve";
		if (aux.equalsIgnoreCase("FIBONACCI"))
			return "Fibonacci";
		if (aux.equalsIgnoreCase("SQRT"))
			return "Sqrt";
		if (aux.equalsIgnoreCase("BINOMIAL"))
			return "Binomial";
		if (aux.equalsIgnoreCase("EXPAND"))
			return "Expand";
		if (aux.equalsIgnoreCase("FACTOR"))
			return "Factor";// As i don't know exactly what is this i won't put
							// it on the help
		if (aux.equalsIgnoreCase("INTEGRATE"))
			return "Integrate";
		if (aux.equalsIgnoreCase("NINTEGRATE"))
			return "NIntegrate";
		if (aux.equalsIgnoreCase("FINDROOT"))
			return "FindRoot";
		if (aux.equalsIgnoreCase("TAYLOR"))
			return "Taylor";
		if (aux.equalsIgnoreCase("ABS"))
			return "Abs";
		if (aux.equalsIgnoreCase("CLEAR"))
			return "Clear";
		if (aux.equalsIgnoreCase("CLEARALL"))
			return "ClearAll";
		if (aux.equalsIgnoreCase("D"))
			return "Dd";// Later this must be translated to D
		if (aux.equalsIgnoreCase("N"))
			return "Nn";// Later this must be translated to N
		if (aux.equalsIgnoreCase("CATALANNUMBER"))
			return "CatalanNumber";
		if (aux.equalsIgnoreCase("HARMONICNUMBER"))
			return ("HarmonicNumber");
		if (aux.equalsIgnoreCase("FACTORINTEGER"))
			return ("FactorInteger");
		if (aux.equalsIgnoreCase("SUM"))
			return ("Sum");
		if (aux.equalsIgnoreCase("PRODUCT"))
			return ("Product");
		if (aux.equalsIgnoreCase("JACOBIMATRIX"))
			return ("JacobiMatrix");
		if (aux.equalsIgnoreCase("DIVERGENCE"))
			return ("Divergence");
		if (aux.equalsIgnoreCase("INFINITY"))
			return ("Infinity");
		if (aux.equalsIgnoreCase("EUCLIDIANDISTANCE"))
			return ("EuclidianDistance");
		if (aux.equalsIgnoreCase("LIMIT"))
			return ("Limit");// Doens't work in matheclipse 0.0.9, maybe in the
								// next release
		if (aux.equalsIgnoreCase("RE"))
			return ("Re");
		if (aux.equalsIgnoreCase("IM"))
			return ("Im");
		if (aux.equalsIgnoreCase("BRENT"))
			return ("Brent");
		if (aux.equalsIgnoreCase("BISECTION"))
			return ("Bisection");
		if (aux.equalsIgnoreCase("SOLVE"))
			return ("Solve");
		if (aux.equalsIgnoreCase("LIMIT"))
			return ("Limit");
		if (aux.equalsIgnoreCase("NROOTS"))
			return ("NRoots");
		if (aux.equalsIgnoreCase("ROOTS"))
			return ("Roots");

		if (aux.equals("QUICKHELP")) {// Returns a short list of help
			return "ñç@€\n"
					+ comillas
					+ gui.Translation.Language.get(142)
					+ comillas
					+ " cos[], sin[], tan[], sqrt[], log[], arctan[], arcsin[],"
					+ " arccos[], pi, e,i for complex number, exp[],sinh[], cosh[],tanh[]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(158)
					+ comillas
					+ " + - * . / ^ ! () = > < ==\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(159)
					+ comillas
					+ " e.g.-> x=3/(2+1) \n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(160)
					+ comillas
					+ " Clear[Variable] or ClearAll[Variable]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(161)
					+ comillas
					+ " {{vector},{vector}...}-> e.g:{{1,2},{2,2}}\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(162)
					+ comillas
					+ " {array}.{vector}\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(163)
					+ comillas
					+ " Deriv[function,variable] e.g.-> Deriv[Cos[x],x]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(164)
					+ comillas
					+ " Integrate[function,variable] e.g.-> Integrate[Sin[x],x]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(165)
					+ comillas
					+ " Inverse[{{1,2},{2,2}}]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(166)
					+ comillas
					+ " NIntegrate[Polynomial,{Variable,InitialPoint,FinalPoint}]\n"
					+ "" + comillas + gui.Translation.Language.get(167)
					+ comillas + " Det[{{1,2},{2,2}}]\n";

		}

		if (aux.equals("HELP")) {
			// Returns the whole help
			return "ñç@€\n"
					+ comillas
					+ gui.Translation.Language.get(142)
					+ comillas
					+ " cos[], sin[], tan[], sqrt[], log[], arctan[], arcsin[],"
					+ " arccos[], pi, e,i for complex number, exp[],sinh[], cosh[],tanh[]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(158)
					+ comillas
					+ " + - * . / ^ ! () = > < ==\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(159)
					+ comillas
					+ " e.g.-> x=3/(2+1) \n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(160)
					+ comillas
					+ " Clear[Variable] or ClearAll[Variable]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(161)
					+ comillas
					+ " {{vector},{vector}...}-> e.g:{{1,2},{2,2}}\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(162)
					+ comillas
					+ " {array}.{vector}\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(163)
					+ comillas
					+ " Deriv[function,variable] e.g.-> Deriv[Cos[x],x]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(164)
					+ comillas
					+ " Integrate[function,variable] e.g.-> Integrate[Sin[x],x]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(165)
					+ comillas
					+ " Inverse[{{1,2},{2,2}}]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(166)
					+ comillas
					+ " NIntegrate[Polynomial,{Variable,InitialPoint,FinalPoint}]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(167)
					+ comillas
					+ " Det[{{1,2},{2,2}}]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(168)
					+ comillas
					+ " LUdecomposition[{{1,2},{2,2}}]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(169)
					+ comillas
					+ " JacobiMatrix[{x^2+y,2*y},{x,y}]->{{2*X,1},{0,2}\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(170)
					+ comillas
					+ " IdentityMatrix[Number]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(171)
					+ comillas
					+ " eigenvalues[Matrix]\n"
					+ // Este no se si funciona
					""
					+ comillas
					+ gui.Translation.Language.get(172)
					+ comillas
					+ " eigenvectors[Matrix]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(173)
					+ comillas
					+ " EuclidianDistance[{vector},{vector}]; e.g:EuclidianDistance[{1,2,3,4},{5,6,7,8}]->(8)\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(174)
					+ comillas
					+ " MatrixPower[{{1,2},{3,4}},3] -> returns the matrix elevated to the number\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(175)
					+ comillas
					+ "HilbertMatrix[Number] -> returns the asociated HilbertMatrix\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(176)
					+ comillas
					+ "Returns the intermediate operations; e.g: Trace[D[Cos[x],x]] -> {D[Cos[x],x],(-1)*Sin[x]*D[x,x],(-1)*Sin[x]*D[x,x],{D[x,x],1},(-1)*1*Sin[x],(-1)*Sin[x]}\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(177)
					+ comillas
					+ " -> Says if the number is prime or not\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(178)
					+ comillas
					+ " -> Returns the following prime to that number\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(179)
					+ comillas
					+ " -> Returns the Number position of the fibonaccie sequence\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(180)
					+ comillas
					+ " -> Binomial[9,4] returns {126} \n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(181)
					+ comillas
					+ " e.g: FindRoot[Exp[x]==Pi^3,{x,-1,10},Bisection]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(182)
					+ comillas
					+ " e.g: FindRoot[Exp[x]==Pi^3,{x,-1,10},Brent]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(183)
					+ comillas
					+ " Taylor[Function,{variable,0,number of terms}]\n"
					+ // It seems it only makes McLaurin
					""
					+ comillas
					+ gui.Translation.Language.get(184)
					+ comillas
					+ " e.g. -> Expand[(-1+x)*(1+x)*(1+x^2)*(1+x^4)*(1+x^8)]->(-1+x^16)\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(185)
					+ comillas
					+ " e.g. -> Factor[-1+x^16]->(-1+x)*(1+x)*(1+x^2)*(1+x^4)*(1+x^8)\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(186)
					+ comillas
					+ " Abs[Number]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(187)
					+ comillas
					+ " Re[Number]; e.g: Re[1/3+I]->(1/3)\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(188)
					+ comillas
					+ " Im[Number]; e.g: Im[1/3+I]->(1)\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(189)
					+ comillas
					+ " CatalanNumber[Number]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(190)
					+ comillas
					+ " HarmonicNumber[Number]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(191)
					+ comillas
					+ " FactorInteger[Number]->{{Factor,exponent}}; e.g:FactorInteger[12]->{{2,2},{3,1}}->(2^2)*(3^1)\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(192)
					+ comillas
					+ " e.g: Pi==E->False; e.g: 4==8/2->True; e.g: 2<9/4->True\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(193)
					+ comillas
					+ " Sum[polynomial,{var,initial point,final point,step}]; e.g:Sum[x,{x,0,4,2}] ->(6)\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(194)
					+ comillas
					+ " Product[polynomial,{var,initial point,final point,step}]; e.g:Product[x,{x,1,4,1}] ->(24)\n"
					/*+ ""	//FUNCTIONS ELIMINATED BECAUSE THIS COMMANDS ARE NOT AVALAIBLE ON MECONSOLE0.0.9
					 * 		//AND HIGHER VERSION DOESN'T WORK AS GOOD AS THAT ONE
					+ comillas
					+ gui.Translation.Language.get(378)
					+ comillas
					+ " Limit[Function,Variavle->Value]; e.g: Limit[1+Sin[x]/x,x->Infinity] -> (1)\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(379)
					+ comillas
					+ " Solve[{Equation1,..., Equation N},{Variable1, ..., Variable N}]; e.g:Solve[{x^2==4,x+y^2==6},{x,y}]\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(380)
					+ comillas
					+ " Roots[Function]; e.g:Roots[x^2 - 4*x + 8] ->{2+I*2,2-I*2}\n"
					+ ""
					+ comillas
					+ gui.Translation.Language.get(381)
					+ comillas
					+ " NRoots[Function]; e.g:NRoots[Sin[13]*x^2 + 5*x + 10] ->{-2.5437534046413663,-9.356275778426076}\n"*/;

		}
		return aux;
	}

	/**
	 * Translate the cheats i made to avoid some troubles, for example to avoid
	 * the user using D as a variable (if D has a value then matheclipse can't
	 * derive) i decided to translate D to Dd so this method translate Dd to D
	 * so the user can't know the internal change
	 * 
	 * @param aux
	 * @return string
	 */
	public static String backTranslate(String aux) {
		if (aux.equals("D")
				& (DiffAndEvaluator.SymbolicEvaluatorError | !MathPane.RenderPrint))
			return "Deriv";
		if (aux.equals("N"))
			return "Num";
		if (aux.equals("Dd"))
			return "D";
		if (aux.equals("Nn"))
			return "N";
		if (aux.equals("I"))
			return "i";// as I can't be write in render print mode
		return aux; // we translate to i, that gives no problems
	}
	/**
	 * @return Complete List for Mathematics
	 */
	/*
	 * public static LinkedList<String> CommandList(){ LinkedList<String>
	 * Commands = new LinkedList<String>(); Commands.add(new String(""));
	 * Commands.add(new String("Cos[]")); Commands.add(new String("Sin[]"));
	 * Commands.add(new String("Tan[]")); Commands.add(new String("ArcTan[]"));
	 * Commands.add(new String("ArcSin[]")); Commands.add(new
	 * String("ArcCos[]")); Commands.add(new String("Pi")); Commands.add(new
	 * String("e")); Commands.add(new String("Exp[]")); Commands.add(new
	 * String("Log[]")); Commands.add(new String("Cosh[]")); Commands.add(new
	 * String("Sinh[]")); Commands.add(new String("Tanh[]")); Commands.add(new
	 * String("Clear[]")); Commands.add(new String("ClearAll[]"));
	 * Commands.add(new String("Deriv[]")); Commands.add(new
	 * String("Integrate[]")); Commands.add(new String("NIntegrate[]"));
	 * Commands.add(new String("Inverse[]")); Commands.add(new String("Det[]"));
	 * Commands.add(new String("Inverse[]")); Commands.add(new
	 * String("Divergence[]")); Commands.add(new String("Transpose[]"));
	 * Commands.add(new String("LUdecomposition[]")); Commands.add(new
	 * String("JacobiMatrix[]")); Commands.add(new String("IdentityMatrix[]"));
	 * Commands.add(new String("eigenvalues[]")); Commands.add(new
	 * String("eigenvectors[]")); Commands.add(new String("QuickHelp"));
	 * Commands.add(new String("Help")); Commands.add(new
	 * String("EuclidianDistance[]")); Commands.add(new
	 * String("MatrixPower[]")); Commands.add(new String("HilbertMatrix[]"));
	 * Commands.add(new String("Trace[]")); Commands.add(new
	 * String("PrimeQ[]")); Commands.add(new String("NextPrime[]"));
	 * Commands.add(new String("Fibonacci[]")); Commands.add(new
	 * String("Binomial[]")); Commands.add(new String("FindRoot[]"));
	 * Commands.add(new String("Taylor[]")); Commands.add(new
	 * String("Expand[]")); Commands.add(new String("Factor[]"));
	 * Commands.add(new String("Abs[]")); Commands.add(new String("Re[]"));
	 * Commands.add(new String("Im[]")); Commands.add(new
	 * String("CatalanNumber[]")); Commands.add(new String("HarmonicNumber[]"));
	 * Commands.add(new String("FactorInteger[]")); Commands.add(new
	 * String("Sum[]")); Commands.add(new String("Product[]")); return Commands;
	 * }
	 */

}