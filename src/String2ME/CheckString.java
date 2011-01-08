package String2ME;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import solver.PrepareUncmin;

import evaluation.DiffAndEvaluator;
import gui.Config;
import gui.MaterialMethods;
import gui.SolverGUI;

/**
 * A class to translate a equation into matheclipse syntaxes
 * 
 * @author Pablo salinas
 */

@SuppressWarnings("all")
public class CheckString {

	/**
	 * Saves the variables and the times a variable appears
	 */
	public static VList Var = new VList();
	/**
	 * Saves the Variables that can be solved in one equation
	 */
	public static LinkedList<String> CaseVariables = new LinkedList<String>();;
	public static LinkedList<VString> OneEquationVar = new LinkedList<VString>();
	/**
	 * List of all equations that are global
	 */
	public static List<EqStorer> Functions = new ArrayList<EqStorer>();// Antes
																		// era
																		// LinkedList
	/**
	 * List of equations that have been solved. This is only to write them in
	 * the log
	 */
	public static List<EqStorer> FunctionsSolved = new ArrayList<EqStorer>();

	/**
	 * List to avoid showing the formula when using a Thermodynamic formula.
	 * Like this : water.enthalpy(Temperature, Pressure)
	 */
	public static LinkedList<PositionStorer> ResidualWorkAround = new LinkedList<PositionStorer>();

	/**
	 * Variables of a single equation
	 */
	public VList VarThisEquation;

	public static final String SubsEqual = new String("-1*(");

	// variables that the equation has
	public static boolean Radianes;// Sets if we are working with degrees or not

	// ASCII values of the characters
	public static final char Por = (char) 42;
	public static final char Igual = (char) 61;
	public static final char Slash = (char) 47;
	public static final char Plus = (char) 43;
	public static final char Menos = (char) 45;
	public static final char Dot = (char) 46;
	public static final char Comma = (char) 44;
	public static final char OpenP = (char) 40;
	public static final char CloseP = (char) 41;
	public static final char Elevado = (char) 94;
	public static final char OpenC = (char) 91;
	public static final char CloseC = (char) 93;
	public static final char Exclamacion = (char) 33;
	public static final char Espacio = (char) 32;
	public static final char Barra = (char) 95;
	public static final char Tab = (char) 9;
	public static final char PuntoYcoma = (char) 59;

	/**
	 * The input string can't contain comments, use before calling this method
	 * SolverGUI.cleanComments
	 * 
	 * @param cadena
	 * @return A byte that means: 0 if there are no errors. 1 if there is a
	 *         illegal character error. 2 if there is a syntaxes general error.
	 *         3 If there are two operators followed. 4 If there is a dot or
	 *         comma after a letter. 5 If there is not an equal sign 6 If there
	 *         are more open parenthesis than close parenthesis or vice versa 7
	 *         If a special function is empty 8 If behind a number is a variable
	 *         and not an operator 9 If an operator is at the end of the line or
	 *         does not have a number or a variable behind 10 if a variable
	 *         contains something different from a letter, number or _ Also
	 *         returns a character
	 */
	public GramErr GramCheck(String cadena) {

		String aux = new String("");
		char c = Espacio;
		char pc = Espacio;
		int NumC;
		int i = 0;
		int j = 0;
		boolean Change;
		boolean Equalsign = false;

		while (i != cadena.length()) {
			Change = false;
			c = cadena.charAt(i);
			c = Character.toLowerCase(c);
			NumC = (int) c;

			// Comments are introduced with /* and close with */
			// Only abcdefghijklmnopqrstuvwxyz1234567890 + - * / , . ^ ( ) [ ] =
			// and Tabulator are allowed
			// This if is to check if a character is illegal. i.e:@ ; > < : | &
			// { } " # ? ~ % \ $
			// Note "_" it's only accepted because it it's translate to Gg
			if (((NumC <= 57) & (NumC >= 48)) | ((NumC >= 97) & (NumC <= 122))
					| (NumC == Igual) | (NumC == Plus) | (NumC == Menos)
					| (NumC == Slash) | (NumC == Espacio) | (NumC == Por)
					| (NumC == OpenP) | (NumC == CloseP) | (NumC == OpenC)
					| (NumC == CloseC) | (NumC == Dot) | (NumC == Comma)
					| (NumC == Elevado)/* |(NumC==Exclamacion) */
					| (NumC == Barra) | (NumC == Tab)) {/* Accepted characters */
			} else
				return (new GramErr((byte) 1, c));

			// At first erase tabs
			if (c == Tab) {
				Change = true;
			}

			// This is the way i decided to make a equation to look like this
			// 0=something from this
			// something=other something
			if (c == Igual) {
				if (Equalsign)
					return (new GramErr((byte) 2, c));
				aux += SubsEqual;
				Equalsign = true;
				Change = true;
			}

			// As matheclipse can't use "_" we make here a change to make it
			// possible, later we must
			// translate a "Gg" to a _ to show in the results
			if (c == Barra) {
				aux += "Gg";
				Change = true;
			}

			// To check if there are empty parenthesis
			if (c == CloseP | c == CloseC)
				if (pc == OpenP | pc == OpenC)
					return (new GramErr((byte) 7, c));

			// Comma and dots can only be behind a number
			if (((c == Comma) | (c == Dot)) & (!IsNumber(pc)))
				return (new GramErr((byte) 2, c));

			/*
			 * //Behind a number can't be a letter if(IsLetter(c) &
			 * IsNumber(pc)) return (new GramErr((byte) 8,c));
			 */

			// This is to check that there are not two operators followed
			// (except +,-)
			if ((CheckOperator(c)) & (CheckOperator(pc))) {
				if ((c == Plus) | (c == Menos)) {/* Ignore */
				} else
					return (new GramErr((byte) 3, c));
			}

			// This is to check that behind an operator there isn't a ) or a ]
			if ((CheckOperator(pc)) & ((c == CloseP) | (c == CloseC)))
				return (new GramErr((byte) 9, pc));

			// Looks for a missing operator or a dot or comma after a letter
			if ((IsLetter(pc)) & ((c == Comma) | (c == Dot)))
				return (new GramErr((byte) 4, c));

			// Because of the MathEclipse libraries does not use the commas,
			// only dots, i make this conversion to
			// allow both possibilities
			if (c == Comma) {
				Change = true;
				aux += ".";
			}

			// Write the character only if there were no changes
			if (!Change)
				aux += c;

			i++;

			if (i != cadena.length()) {
				j = i;
				i = SkipSpaces(cadena, i);
				if (j != i) {
					i--;
				}
			}
			// Save previous character
			if (c != Tab)
				pc = c;
		}
		// Checks if there is an operator at the end of the line for example x =
		// 2 / or x = 2 +
		if (CheckOperator(c))
			return (new GramErr((byte) 9, c));

		aux += ")";
		if (Equalsign) {
			VarThisEquation = new VList();
			String aux2 = new String("");
			String aux3 = new String("");
			String PrevToken = new String(" ");
			StringTokenizer lector = new StringTokenizer(aux, "+/*-()[]{} ^=!",
					true);
			while (lector.hasMoreTokens()) {

				aux3 = lector.nextToken();

				if (aux3.equals("ln"))
					aux3 = "log";// Translation of ln to log, thats if how ME
									// understand ln

				// Now we check if the "variable" is not a special function like
				// Sin or Pi, etc.
				// This is to check if it is a number, every number start with a
				// number. I mean there is no dot
				// at the beginning , i.e:0.5

				if (IsFunction(aux3)) {/* Ignore this tokens */
				} else {
					if ((aux3.equals("pi")) | (aux3.equals("e"))
							| (IsNumber(aux3.charAt(0)))) {
						if (!IsNumber(aux3) & IsNumber(aux3.charAt(0))) // This
																		// check
																		// if
																		// the
																		// "number"
																		// is a
							return (new GramErr((byte) 8, aux3/* aux3.charAt(0) */));
					}// variable that start with
					else { // a number
						if ((aux3.equals("+")) | (aux3.equals("-"))
								| (aux3.equals("/")) | (aux3.equals("*"))
								| (aux3.equals(" ")) | (aux3.equals("^"))
								| (aux3.equals("!"))) {
							// Ignore this tokens
						} else {
							if ((aux3.equals("(")) | (aux3.equals(")"))
									| (aux3.equals("[")) | (aux3.equals("]"))) {
								try {
									aux3 = P2C(aux3, PrevToken);
								} catch (Exception e) {
									return new GramErr((byte) 6);
								}
							} else {
								if ((PrevToken.equals("["))
										& ((aux3.equals("/"))
												| (aux3.equals("*"))
												| (aux3.equals("^")) | (aux3
												.equals("!")))) {
									return new GramErr((byte) 2);
								} else {
									// First i check the variable
									if (!checkVariable(aux3))
										return (new GramErr((byte) 10, aux3));

									// If it is not an operator, a special
									// function or a number
									// that means that it must be a variable
									VarThisEquation.AddVar(aux3);
								}
							}
						}
					}
				}
				// This checks if a special function is empty,unnecessary
				// if ((PrevToken.equals("["))&(aux3.equals("]"))){
				// return (new GramErr((byte) 7));}

				PrevToken = aux3;
				// If the token is a function or pi or e i must translate it to
				// the matheclipse syntaxes
				if ((IsFunction(aux3)) | (aux3.equals("e"))
						| (aux3.equals("pi"))) {
					aux3 = f2F(aux3);
				}
				aux2 += aux3;
			}

			String n;
			for (int m = 0; m < VarThisEquation.getSize(); m++) {
				n = VarThisEquation.getVar(m);
				Var.addCountVar(n, 1);
			}
			Functions.add(new EqStorer(aux2, VarThisEquation));

			Pila p = new Pila();
			if (p.GetSize() != -1) {// If after reading the whole equation are
									// non paired parenthesis
				// then the size will be different from -1
				// p.ErasePila();
				return (new GramErr((byte) 6));
			} else {
				// p.ErasePila();
				return (new GramErr((byte) 0));
			}
		}// Check if the line is empty or is part of a comment line, that means,
			// comment =true

		else {
			if (emptyString(aux))
				return (new GramErr((byte) 0));
			else
				return (new GramErr((byte) 5));
		}

	}

	/**
	 * @param c
	 * @return True if an operator is found
	 */
	public boolean CheckOperator(char c) {
		boolean OperatorFound = false;
		switch (c) {
		case Por:
			OperatorFound = true;
			break;
		case Slash:
			OperatorFound = true;
			break;
		case Igual:
			OperatorFound = true;
			break;
		case Plus:
			OperatorFound = true;
			break;
		case Menos:
			OperatorFound = true;
			break;
		case Exclamacion:
			OperatorFound = true;
			break;
		case Dot:
			OperatorFound = true;
			break;
		case Comma:
			OperatorFound = true;
			break;
		case Elevado:
			OperatorFound = true;
			break;
		}
		return OperatorFound;
	}

	// It won't have in consideration letters like ñ or ç
	// This checks if a character is a letter
	/**
	 * If is a letter returns true
	 */
	public boolean IsLetter(char c) {
		boolean LetterFound = false;
		int NumC = (int) c;
		if (((NumC <= 90) & (NumC >= 65)) || ((NumC <= 122) & (NumC >= 97)))
			LetterFound = true;

		return LetterFound;

	}

	/**
	 * Checks that the variable only has, numbers and letters(remember that _
	 * has been translated to Gg)
	 * 
	 * @param var
	 * @return true if everything is OK
	 */
	public boolean checkVariable(String var) {

		for (int i = 0; i < var.length(); i++)
			if (!IsNumber(var.charAt(i)))
				if (!IsLetter(var.charAt(i)))
					return false;

		return true;
	}

	// This checks if a character is a number
	/**
	 * If is a number returns true
	 */
	public boolean IsNumber(char c) {
		boolean NumFound = false;
		int NumC = (int) c;
		if ((NumC <= 57) & (NumC >= 48))
			NumFound = true;

		return NumFound;
	}

	/**
	 * Checks if a String have something different from a number
	 * 
	 * @param input
	 * @return true if is a number
	 */
	public boolean IsNumber(String input) {

		for (int i = 0; i < input.length(); i++) {
			if (!IsNumber(input.charAt(i)) & !CheckOperator(input.charAt(i)))
				return false;
		}
		return true;
	}

	// Checks if the string is a function
	/**
	 * If the input string is a function like Cos, Sin, Tan, Exp,etc. Returns
	 * true.
	 */
	public boolean IsFunction(String aux) {
		if ((aux.equalsIgnoreCase("cos")) | (aux.equalsIgnoreCase("sin"))
				| (aux.equalsIgnoreCase("tan")) | (aux.equalsIgnoreCase("exp"))
				| (aux.equalsIgnoreCase("log"))
				| (aux.equalsIgnoreCase("sinh"))
				| (aux.equalsIgnoreCase("cosh"))
				| (aux.equalsIgnoreCase("tanh"))
				| (aux.equalsIgnoreCase("arcsin"))
				| (aux.equalsIgnoreCase("arccos"))
				| (aux.equalsIgnoreCase("arctan")) | aux.equalsIgnoreCase("ln"))
			return true;
		else
			return false;

	}

	// Skip spaces
	/**
	 * This method is to ignore spaces
	 */
	public int SkipSpaces(String cadena, int i) {
		char c = cadena.charAt(i);
		while ((c == Espacio) & (i < cadena.length())) {// There was problems
														// when the space was at
														// the end of the line
			c = cadena.charAt(i);// i think it it's fixed with the
									// i<cadena.length()
			i++;

		}
		return i;
	}

	/**
	 * This method is to translate The Parenthesis in a usual equation into
	 * clasp when its necessary to matheclipse. I.E:Cos(x*(1)) into Cos[x*(1)]
	 * 
	 */
	public String P2C(String aux, String PrevToken) {

		Pila P = new Pila();
		byte b = (byte) 0;
		switch (aux.charAt(0)) {
		case CloseP:
			b = P.GetTerm();
			break;
		case CloseC:
			b = P.GetTerm();
			break;
		default: {
			if (IsFunction(PrevToken)) {
				if (IsTrigonometric(PrevToken) & (!Radianes)) {
					P.AddTerm((byte) 2);
					return "[Degree(";
				} else {
					P.AddTerm((byte) 1);
					return "[";
				}
			} else {
				P.AddTerm((byte) 0);
				return "(";
			}
		}
		}
		if (b == (byte) 1)
			return "]";
		if (b == (byte) 2)
			return ")]";
		if (b == (byte) 0)
			return ")";
		return "";
	}

	/**
	 * 
	 * @param Input
	 *            string
	 * @return if the input string is a function like, sin, cos, pi, e, tan,
	 *         exp,sinh,tanh,arcsin,artan,etc. Returns the one that mathEclipse
	 *         understand like Cos instead cos or ArcTan insted of arctan
	 */
	public String f2F(String aux) {
		if (aux.equalsIgnoreCase("cos"))
			return "Cos";
		if (aux.equalsIgnoreCase("sin"))
			return "Sin";
		if (aux.equalsIgnoreCase("tan"))
			return "Tan";
		if (aux.equalsIgnoreCase("pi"))
			return Double.toString(Math.PI);// Matheclipse understand -> "Pi"
		if (aux.equalsIgnoreCase("e"))
			return "E"; // But it gives some errors;
		if (aux.equalsIgnoreCase("exp"))
			return "Exp";
		if (aux.equalsIgnoreCase("log"))
			return "Log";
		if (aux.equalsIgnoreCase("sinh"))
			return "Sinh";
		if (aux.equalsIgnoreCase("cosh"))
			return "Cosh";
		if (aux.equalsIgnoreCase("tanh"))
			return "Tanh";
		if (aux.equalsIgnoreCase("arcsin"))
			return "ArcSin";
		if (aux.equalsIgnoreCase("arccos"))
			return "ArcCos";
		if (aux.equalsIgnoreCase("arctan"))
			return "ArcTan";

		return aux;
	}

	/**
	 * 
	 * @param aux
	 * @return True if the String is a trigonometric function
	 */
	public boolean IsTrigonometric(String aux) {
		if ((aux.equalsIgnoreCase("cos")) | (aux.equalsIgnoreCase("sin"))
				| (aux.equalsIgnoreCase("tan"))
				| (aux.equalsIgnoreCase("arcsin"))
				| (aux.equalsIgnoreCase("arccos"))
				| (aux.equalsIgnoreCase("arctan")))
			return true;

		else
			return false;

	}

	/**
	 * Checks if the input string has only spaces and at the end a )
	 * 
	 * @param input
	 * @return True if the string has only spaces
	 */
	private boolean emptyString(String input) {
		boolean empty = true;
		Character c;
		for (int i = 0; i < input.length() - 1; i++) {
			c = input.charAt(i);
			if (!c.equals(Espacio))
				empty = false;
		}

		return empty;
	}

	/**
	 * 
	 * @param cadena
	 *            Saves the variables of an equation in an array, but this
	 *            method saves the case information; This method ignores the
	 *            thermodynamic call functions
	 */
	public void getVariables(String cadena) {

		String aux = new String("");
		char c, pc;
		int i = 0;
		int j = 0;
		boolean Change;
		boolean Equalsign = false;

		while (i != cadena.length()) {
			Change = false;
			c = cadena.charAt(i);

			if (!false) {
				// At first erase tabs
				if (c == Tab) {
					Change = true;
				}

				// This is the way i decided to make a equation to look like
				// this 0=something from this
				// something=other something
				if (c == Igual) {
					aux += SubsEqual;
					Equalsign = true;
					Change = true;
				}
				if (c == OpenC) {
					aux += "(";
					Change = true;
				}
				if (c == CloseC) {
					aux += ")";
					Change = true;
				}
				// As matheclipse can't use "_" we make here a change to make it
				// possible, later we must
				// translate a "Gg" to a _ to show in the results
				if (c == Barra) {
					aux += "Gg";
					Change = true;
				}

				// Because of the MathEclipse libraries does not use the commas,
				// only dots, i make this conversion to
				// allow both possibilities
				if (c == Comma) {
					Change = true;
					aux += ".";
				}

				// Write the character only if there were no changes
				if (!Change)
					aux += c;

			}
			i++;

			if (i != cadena.length()) {// If something fails, maybe is this XD
				j = i;
				i = SkipSpaces(cadena, i);
				if (j != i) {
					i--;
				}
			}
			// Save previous character
			if (c != Tab)
				pc = c;
		}
		aux += ")";
		try {
			if (Equalsign) {
				String[] variables = DiffAndEvaluator.getVariables(aux);
				// Saves the variable only if it is not already in the List
				// and if it is not an special function like: cos, sin, pi, etc.
				for (String s : variables) {
					Change = true;
					if (IsFunction(s) | s.equalsIgnoreCase("e")
							| s.equalsIgnoreCase("Pi") | s.equalsIgnoreCase(""))
						Change = false;

					if (Change)
						for (String S : CheckString.CaseVariables)
							if (s.equalsIgnoreCase(S))
								Change = false;

					if (Change)
						CheckString.CaseVariables.add(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Saves the variables of an equation in an array, but this method saves the
	 * case information and have in consideration the thermodynamic calls.
	 * 
	 * @param cadena
	 * @param Materiales
	 * @param ch
	 */
	public void getVariables(String cadena, MaterialMethods Materiales,
			CheckString ch) {

		SolverGUI SGUI = new SolverGUI();
		// If the equation is a thermodynamic call it will be translated to it's
		// formula
		cadena = SGUI.searchThermodynamicFunction(cadena, Materiales, ch)
				.getString();
		String aux = new String("");
		char c, pc;
		int i = 0;
		int j = 0;
		boolean Change;
		boolean Equalsign = false;

		while (i != cadena.length()) {
			Change = false;
			c = cadena.charAt(i);

			if (!false) {
				// At first erase tabs
				if (c == Tab) {
					Change = true;
				}

				// This is the way i decided to make a equation to look like
				// this 0=something from this
				// something=other something
				if (c == Igual) {
					aux += SubsEqual;
					Equalsign = true;
					Change = true;
				}
				if (c == OpenC) {
					aux += "(";
					Change = true;
				}
				if (c == CloseC) {
					aux += ")";
					Change = true;
				}
				// As matheclipse can't use "_" we make here a change to make it
				// possible, later we must
				// translate a "Gg" to a _ to show in the results
				if (c == Barra) {
					aux += "Gg";
					Change = true;
				}

				// Because of the MathEclipse libraries does not use the commas,
				// only dots, i make this conversion to
				// allow both possibilities
				if (c == Comma) {
					Change = true;
					aux += ".";
				}

				// Write the character only if there were no changes
				if (!Change)
					aux += c;

			}
			i++;

			if (i != cadena.length()) {// If something fails, maybe is this XD
				j = i;
				i = SkipSpaces(cadena, i);
				if (j != i) {
					i--;
				}
			}
			// Save previous character
			if (c != Tab)
				pc = c;
		}
		aux += ")";
		try {
			if (Equalsign) {
				String[] variables = DiffAndEvaluator.getVariables(aux);
				// Saves the variable only if it is not already in the List
				// and if it is not an special function like: cos, sin, pi, etc.
				for (String s : variables) {
					Change = true;
					if (IsFunction(s) | s.equalsIgnoreCase("e")
							| s.equalsIgnoreCase("Pi") | s.equalsIgnoreCase(""))
						Change = false;

					if (Change)
						for (String S : CheckString.CaseVariables)
							if (s.equalsIgnoreCase(S))
								Change = false;

					if (Change)
						CheckString.CaseVariables.add(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method clean up all the variables used in iteration this is
	 * necessary because matheclipse remembers everything so if a variable was
	 * defined like a constant then in the next use of it it will still be a
	 * constant, so no derivatives will be possible
	 */
	public static void PurgeAll() {

		DiffAndEvaluator.PurgeVar();

		Functions.clear();

		CaseVariables.clear();

		FunctionsSolved.clear();

		Var.Variables.clear();

		OneEquationVar.clear();

		ResidualWorkAround.clear();

		// This is to erase the stack that checks and translates the parenthesis
		// and clasps
		Pila.ErasePila();

		// Clear Gradient, Hessian, Jacobian...whatever
		PrepareUncmin.clear();

		// Restart Global variables
		Config.ErrorFound = false;
		evaluation.DiffAndEvaluator.TimeLimitExceeded = false;
		SolverGUI.ResidualsHigh = false;

	}

}