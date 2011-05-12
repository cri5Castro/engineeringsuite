package evaluation;

import org.matheclipse.basic.EvaluationInterruptedException;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.eval.exception.DivisionByZero;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.form.output.StringBufferWriter;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;

import String2ME.CheckString;
import String2ME.VString;
import edu.jas.kern.ComputerThreads;
import gui.Config;

/**
 * This class is to communicate with matheclipse. You can evaluate a function,
 * derivate it, get the variables, etc.
 * 
 * @author Pablo Salinas
 * 
 */
public class DiffAndEvaluator {
	/**
	 * true if there is an error while evaluating a function
	 */
	public static boolean SymbolicEvaluatorError = false;
	/**
	 * If time limit for operations is reached then this will be true
	 */
	public static boolean TimeLimitExceeded = false;
	/**
	 * This strings saves the equation which haven been the source of the
	 * evaluation error
	 */
	public static String StringErrorEvaluating;
	/**
	 * If a variable becomes complex them this boolean will be true.
	 */
	public static boolean IrrealEvaluation = false;
	/**
	 * Matheclipse class to communicate with
	 */
	static EvalUtilities util = new EvalUtilities();

	/**
	 * This must be the first thing to start if you want matheclipse to work.
	 * But you only have to call it once.
	 */
	public static void PrepareME() {
		F.initSymbols(null);
	}

	/**
	 * Introduces a String like this:A=4;B=5;C=8 into the matheclipse engine.
	 * 
	 * @param Input
	 *            string, A=4;B=5;C=8
	 */
	public static void IntroduceValues(String input) {

		try {
			String[] values = input.split(";");
			for (String S : values)
				util.evaluate(S);
			// util.evaluate(s);

		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Evaluates a equation as a string in a point, the values must be
	 * introduced before using this method
	 * 
	 * @param A
	 *            string like this A*x/8-(1+c)
	 * @return A double of the equation evaluated
	 */
	public static double Evaluate(String s) {
		if (s != null) {
			try {				
				return Double.parseDouble(util.evaluate(s).fullFormString());
			} catch (DivisionByZero D) {
				D.printStackTrace();
				StringErrorEvaluating = s;
				Config.ErrorFound = true;
				throw new RuntimeException();
			} catch (NumberFormatException e) {
				if (e.getMessage().contains("ComplexNum@"))
					IrrealEvaluation = true;

				StringErrorEvaluating = s;
				Config.ErrorFound = true;
				throw new RuntimeException();

			} catch (EvaluationInterruptedException E) {
				TimeLimitExceeded = true;
				E.printStackTrace();
				Config.ErrorFound = true;
				throw new RuntimeException();
			} catch (SyntaxError e) {
				Config.ErrorFound = true;
				// throw new RuntimeException();
				return Double.NaN;
			} catch (Exception e) {
				e.printStackTrace();
				Config.ErrorFound = true;
				// throw new RuntimeException();
				return Double.NaN;
			}
		} else {
			return Double.NaN;
		}
	}

	/**
	 * 
	 * @param equation
	 * @param var
	 * @return The differentiation of the equation respect the variable
	 */
	public static String diff(String equation, String var) {
		try {
			if (equation.contains(var)) {
				String input = "D[" + equation + "," + var + "]";
				return util.evaluate(input).fullFormString();
			} else
				return "0";

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Returns the variables of an equation
	 * 
	 * @param equation
	 * @return Array of String with the variables
	 */
	public static String[] getVariables(String equation) {

		try {
			String input = "Variables[" + equation + "]";
			input = util.evaluate(input).fullFormString();
			input = input.substring(5, input.length() - 1);
			input = input.replace(" ", "");
			return input.split(",");

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * A method to clean the values of the variables in the matheclipse engine
	 */
	public static void PurgeVar() {

		@SuppressWarnings("unused")
		IExpr result;
		try {

			for (VString VS : CheckString.Var.Variables)
				result = util.evaluate("ClearAll[" + VS.getVar() + "]");

			for (VString S : CheckString.OneEquationVar)
				result = util.evaluate("ClearAll[" + S.getVar() + "]");

		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			ComputerThreads.terminate();
		}

	}

	/**
	 * Clear the value of the variable introduced
	 * 
	 * @param var
	 */
	public static void PurgeVar(String var) {
		@SuppressWarnings("unused")
		IExpr result;
		try {
			result = util.evaluate("ClearAll[" + var + "]");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method insert the string in the matheclipse engine and returns the
	 * result. This method has control time so this is the method to use with
	 * the Mathematics section.
	 * 
	 * @param In
	 * @returnThe result as a string
	 */
	public static String SymbolicEvaluator(String In) {
		Counter c = new Counter();
		Thread n = new Thread(c, "Clock");
		CalculateThread t = new CalculateThread(In);
		Thread m = new Thread(t, "Evaluator");
		n.start();
		m.start();
		while (m.isAlive())
			if (!n.isAlive())
				m.interrupt();

		return CalculateThread.getOutput();

		// The same but with no threads
		/*
		 * EvalUtilities util = new EvalUtilities(); IExpr result; try{ Counter
		 * c = new Counter(); Thread n = new Thread(c,"Clock"); n.start();
		 * result=util.evaluate(In); n.interrupt(); StringBufferWriter buf = new
		 * StringBufferWriter(); OutputFormFactory.get().convert(buf, result);
		 * return buf.toString();
		 * 
		 * 
		 * }catch (final Exception e) { e.printStackTrace();
		 * SymbolicEvaluatorError=true; return e.getMessage();//Returns the
		 * error as a string to print } //ñççñ this is only to identify the
		 * string and print it in red //return null
		 */
	}

	/**
	 * This method transform a string to mathML to later be used as a image to
	 * have a more elegant output
	 * 
	 * @param equation
	 * @return The string wrote in mathML syntaxes
	 */
	public static String MathML(String cadena) {
		EvalEngine EVAL = new EvalEngine();
		// IF RENDER IS SLOW MAYBE IT IS BECAUSE THERE ARE COMMENTS INSIDE THE
		// MATHML FORMULA
		// LOOK AT org.matheclipse.core.eval.MathMLUtilities.
		/*-----------------KNOWN ERRORS ---------------*/
		/*
		 * 1º Sometimes appears something like this 1/10^(-(-2)), it's true but
		 * it is not pretty. This can be workaround using / instead *
		 * :BAD->5,67*10^(-8) SOLUTION ->5,67/10^(8)
		 */

		/*
		 * 2º * appears before a division and after a division. This can be
		 * worked around using / instead * :BAD->5,67*10^(-8) SOLUTION
		 * ->5,67/10^(8)
		 */

		// As * are ignored i translate them into Xx to later translate it back
		// to *
		cadena = cadena.replace("*(", "(");
		cadena = cadena.replace(")*", ")");
		cadena = cadena.replace("*", " Xx ");
		MathMLWriter math = new MathMLWriter(EVAL, false);

		final StringBufferWriter buf = new StringBufferWriter();

		math.toMathML(cadena, buf);
		String aux = new String(buf.toString());
		/*--------Modifications to the MathML code--------*/
		// Now i translate back to *
		// aux2=aux2.replace("Dot(*", "*(");
		aux = aux.replace("Xx", "*");
		// Sometimes, the word Dot appears...so i erase it,
		// because upper and lower case cannot appear together
		aux = aux.replace("Dot", "");
		// To fix " (* " i erase the *
		aux = aux.replace("(</mo><mrow><mi>*", "(</mo><mrow><mi>");
		// To fix Error 2 ---> * /
		aux = aux.replace("*</mi></mrow><msup>", "</mi></mrow><msup>");

		return aux;
	}
}