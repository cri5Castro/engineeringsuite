package gui;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rtextarea.IconGroup;

import evaluation.DiffAndEvaluator;

import tarjan.PrepareMatrix;
import String2ME.CheckString;
import String2ME.DerivEquation;
import String2ME.EqStorer;
import String2ME.GramErr;
import String2ME.PositionStorer;
import String2ME.VString;

/**
 * This class is to store the commands that eSuite solver needs to work
 * properly.
 * 
 * @author Pablo Salinas
 * 
 */
public class SolverGUI {

	private final String CommaSubtitutor = "c1m2r4vghj";
	private final String BarraSubstitutor = "g1m2r4vghj";

	public static boolean ResidualsHigh = false;

	public void Execute() {

		// Erase the Log
		Principal.createLog();
		boolean error = false;
		long tiempoInicio = System.currentTimeMillis();
		try {
			Principal.ResultArea.TextArea.setText("");
			readJTextArea(false);

			if (CheckString.Functions.size() != CheckString.Var.getSize()
					+ CheckString.OneEquationVar.size()) {
				error = true;
				if (!Config.ErrorFound)
					PopUpWarning(Translation.Language.get(119));
				Config.ErrorFound = true;

			} else if (!error & !Config.ErrorFound) {

				/* Try to solve functions that now have one variable */
				PrepareMatrix.PreTarjan();
				/*
				 * Now call tarjan to order the system of equations, and call
				 * the proper solver
				 */
				PrepareMatrix DF = new PrepareMatrix();
				DF.PreNewton();

				/*-----PopUpWindow------*/
				long totalTiempo = System.currentTimeMillis() - tiempoInicio;

				if ((!error) & !Config.ErrorFound
						& !evaluation.DiffAndEvaluator.TimeLimitExceeded)
					JOptionPane.showMessageDialog(null, Translation.Language
							.get(120)
							+ totalTiempo + " ms", Translation.Language
							.get(121), JOptionPane.OK_OPTION, new ImageIcon(
							Config.AbsolutePath
									+ "icons/dialog-information.png"));

			}

		} catch (RuntimeException re) {
			if (evaluation.DiffAndEvaluator.TimeLimitExceeded)
				SolverGUI.PopUpWarning(Translation.Language.get(122));
			error = true;
		} catch (Exception e) {
			PopUpError("Unexpected error");

			error = true;
		}

	}

	/**
	 * A method to read from a jText the equations This method read the equation
	 * and then calls CheckString It will stop the evaluation if something wrong
	 * is found, i.e:Syntaxes errors
	 * 
	 * @deprecated
	 * @throws Exception
	 */
	public void readJTextArea() throws Exception {

		GramErr aux2 = new GramErr((byte) 0);
		CheckString aux = new CheckString();
		String s = new String("");
		StringReader J = new StringReader(
				cleanComments(Principal.TextArea.TextArea.getText()));
		BufferedReader BufJ = new BufferedReader(J);
		for (int i = 0; i < Principal.TextArea.TextArea.getLineCount(); i++) {
			s = BufJ.readLine();
			if (s != null) {
				// This saves the Variables with case information(this is less
				// robust)
				aux.getVariables(s);
				// This saves variables and functions in lowercase
				aux2 = aux.GramCheck(s);
				// If there is any kind of error a pop up window will be shown
				checkGram(aux2);
			}

		}
		J.close();
		BufJ.close();
	}

	/**
	 * A method to read from a jText the equations This method read the equation
	 * and then calls CheckString It will stop the evaluation if something wrong
	 * is founded, i.e:Syntaxes errors
	 * 
	 * @throws Exception
	 */
	public void readJTextArea(boolean Render) throws Exception {
		GramErr aux2 = new GramErr((byte) 0);
		GramErr aux3 = new GramErr((byte) 0);
		CheckString aux = new CheckString();
		String s = new String("");
		String error = new String("");
		StringReader J = new StringReader(
				cleanComments(Principal.TextArea.TextArea.getText()));
		BufferedReader BufJ = new BufferedReader(J);
		// Get the information of the materials
		MaterialMethods Materiales = new MaterialMethods();
		while (s != null) {
			s = BufJ.readLine();
			if (s != null) {
				// Save error string with space information so when i search for
				// it it can be founded
				error = s.substring(0);
				// Erase tabs and spaces
				s = s.replace(CheckString.Tab, CheckString.Espacio);
				s = s.replace(" ", "");
				if (!Render)// Search for Functions to change them for the
							// formula
					aux3 = searchThermodynamicFunction(s, Materiales, aux);
				else
					// Search for Functions to change them for a function to
					// show in the render area
					// water.Cp(Temperature,Cp) --> f(water,Cp)=(Temperature,Cp)
					aux3 = changeThermodynamicFunction(s, Materiales, aux);

				s = aux3.getString();

				// This saves the Variables with case information
				aux.getVariables(s);
				// This saves variables and functions in lower case
				aux2 = aux.GramCheck(s);

				if (aux3.GetTypeError() == (byte) 0) {
					// If there is any kind of error a pop up window will be
					// shown
					checkGram(aux2);
					if (aux2.GetTypeError() != (byte) 0) {
						// For illegal character found i prefer to show only the
						// character
						if (aux2.GetTypeError() == (byte) 1) {
							Principal.TextArea.TextArea.setCaretPosition(0);
							Principal.TextArea.Search(Character.toString(aux2
									.GetCaracter()));
						} else
							showError(error);
						break;
					} else {
					}
				} else {
					Config.ErrorFound = true;
					SolverGUI.PopUpError(Translation.Language.get(365)
							+ Config.JumpLine + "<" + s + ">");
					// Search the error in the text area
					showError(error);
					break;
				}
			}
		}
		J.close();
		BufJ.close();
		Materiales.clear();
		// Call Garbage Collector
		System.runFinalization();
		System.gc();

	}

	/**
	 * Reads the variables from the equation text area and stores them in
	 * CheckString.CaseVariables
	 */
	public void readVariables() {
		CheckString aux = new CheckString();
		StringReader J = new StringReader(
				cleanComments(Principal.TextArea.TextArea.getText()));
		String s = new String("");
		BufferedReader BufJ = new BufferedReader(J);
		// Get the information of the materials
		MaterialMethods Materiales = new MaterialMethods();
		try {
			while (s != null) {
				s = BufJ.readLine();
				s = s.replace(CheckString.Tab, CheckString.Espacio);
				s = s.replace(" ", "");
				// This saves the Variables with case information
				aux.getVariables(s, Materiales, aux);
			}
			J.close();
			BufJ.close();
		} catch (Exception e) {
		}

	}

	/**
	 * Set the font and color for all token types.Also it enables the
	 * antialiasing and the icons.
	 * 
	 * @param textArea
	 *            The text area to modify.
	 * @param font
	 *            The font to use.
	 */
	@SuppressWarnings("static-access")
	public void PrepareSyntaxText(RSyntaxTextArea textArea, Font font,
			boolean editable) {
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		// Icons for the popup window (cut, copy, paste...)
		IconGroup group = new IconGroup("group",
				Config.AbsolutePath + "icons/", null, "png");
		textArea.setIconGroup(group);
		textArea.setTextAntiAliasHint("VALUE_TEXT_ANTIALIAS_ON");
		if (font != null) {
			SyntaxScheme ss = textArea.getSyntaxScheme();
			ss = (SyntaxScheme) ss.clone();
			for (int i = 0; i < ss.styles.length; i++)
				if (ss.styles[i] != null)
					ss.styles[i].font = font;

			textArea.setSyntaxScheme(ss);
			textArea.setFont(font);
		}

		SyntaxScheme scheme = textArea.getSyntaxScheme();
		if (editable)
			scheme.styles[Token.LITERAL_STRING_DOUBLE_QUOTE].foreground = Color.black;// " "
		else {
			textArea.setFont(new Font(Font.MONOSPACED, font.PLAIN, font
					.getSize()));
			scheme.styles[Token.LITERAL_STRING_DOUBLE_QUOTE].font = new Font(
					Font.SANS_SERIF, font.BOLD, 16);// " "
			scheme.styles[Token.LITERAL_STRING_DOUBLE_QUOTE].foreground = Color.red;
		}
		scheme.styles[Token.FUNCTION].foreground = Color.black;// long, math,
																// double...
		scheme.styles[Token.DATA_TYPE].foreground = Color.black;// int, char...
		scheme.styles[Token.RESERVED_WORD].foreground = Color.black;// While,
																	// for...
		scheme.styles[Token.VARIABLE].foreground = Color.black;
		scheme.styles[Token.COMMENT_EOL].foreground = Color.black;// -> //
		scheme.styles[Token.ERROR_CHAR].foreground = Color.black;
		scheme.styles[Token.ERROR_IDENTIFIER].foreground = Color.black;
		scheme.styles[Token.ERROR_NUMBER_FORMAT].foreground = Color.black;
		scheme.styles[Token.ERROR_STRING_DOUBLE].foreground = Color.black;
		scheme.styles[Token.IDENTIFIER].foreground = Color.black;
		scheme.styles[Token.LITERAL_BOOLEAN].foreground = Color.black;// true,
																		// false
		scheme.styles[Token.LITERAL_CHAR].foreground = Color.black;
		scheme.styles[Token.LITERAL_NUMBER_DECIMAL_INT].foreground = Color.blue;
		scheme.styles[Token.LITERAL_NUMBER_FLOAT].foreground = Color.blue;
		scheme.styles[Token.LITERAL_NUMBER_HEXADECIMAL].foreground = Color.black;
		scheme.styles[Token.MARKUP_TAG_ATTRIBUTE].foreground = Color.black;
		scheme.styles[Token.MARKUP_TAG_DELIMITER].foreground = Color.black;
		scheme.styles[Token.MARKUP_TAG_NAME].foreground = Color.black;
		scheme.styles[Token.PREPROCESSOR].foreground = Color.black;
		// scheme.styles[Token.SEPARATOR].foreground = Color.black; // () [] {}
		scheme.styles[Token.WHITESPACE].foreground = Color.black;

	}

	/**
	 * Reads the equations of the TextArea to print them in the RenderPane
	 * 
	 * @param RenderPane
	 * @param TextArea
	 */
	public void RenderEquations(OutputTextPane RenderPane,
			RSyntaxTextArea TextArea) {

		long tiempoInicio = System.currentTimeMillis();
		// At first i read the equations and clean the output Pane
		RenderPane.setText("");
		boolean temporal = CheckString.Radianes;
		try {
			// As working with degrees adds parenthesis to the equations i made
			// this trick
			// to avoid introducing those extra parenthesis
			CheckString.Radianes = true;
			readJTextArea(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CheckString.Radianes = temporal;
		}
		// Translate the functions to equations
		// The are stored like this x-1*(2) and i want them like this x=2
		// then i will print them
		ListIterator<EqStorer> it = CheckString.Functions.listIterator();
		String aux = new String("");
		String aux2 = new String("");

		int i;
		EqStorer Eqaux;
		while (it.hasNext()) {
			Eqaux = it.next();
			aux = Eqaux.getEquation();
			i = findEqual(aux);
			aux2 = aux.substring(0, i - 3) + "="
					+ aux.substring(i + 1, aux.length() - 1);
			aux2 = aux2.replace("Degree", "");
			aux2 = aux2.replace("Gg", "_");
			aux2 = aux2.replace("3.141592653589793", "Pi");
			if (i == -1) {// No equal sign found
				PopUpWarning("No equal sign found");
				aux2 = aux;
			}
			// This is for changing the variables with no case information to
			// the CaseVariables
			for (DerivEquation e : Eqaux.aux)
				for (String s : CheckString.CaseVariables)
					if (e.GetVar().equalsIgnoreCase(s)) {
						aux2 = aux2.replace(e.GetVar(), s);
						// When the variable has been replaced then we move to
						// the next variable.
						break;
					}

			// if is a thermodynamic function then translate
			try {// to a function(Substance,property) = (Variables)
				if (aux2.substring(0, 10).equalsIgnoreCase("function*(")) {
					// This means is a thermodynamic function
					aux = DiffAndEvaluator.MathML(aux2);
					aux = aux.replace(CommaSubtitutor, ",");
					aux = aux.replace(BarraSubstitutor, "_");
					aux = aux.replace("=", ") = (");
					aux = aux.replace("Function", "Function(");
					int pos = aux.indexOf("<", aux.lastIndexOf(","));
					aux = aux.substring(0, pos - 1) + ")" + aux.substring(pos);
				} else
					aux = DiffAndEvaluator.MathML(aux2);
			} catch (Exception e) {
				aux = DiffAndEvaluator.MathML(aux2);
			}

			RenderPane.RenderPrint(aux);
			RenderPane.printErr("");
		}
		RenderPane.setCaretPosition(0);
		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		JOptionPane.showMessageDialog(null, "Time elapsed: " + totalTiempo
				+ " ms", "Operations finished", JOptionPane.OK_OPTION,
				new ImageIcon("icons/dialog-information.png"));

	}

	/**
	 * Translate the functions to equations; The equations are stored like this
	 * x-1*(2) and i want them like this x=2
	 * 
	 * @param s
	 * @return the position of the ( that substitute =; in the example position
	 *         4
	 */
	private int findEqual(String s) {
		/*
		 * Byte = 0 first parenthesis Byte = 1 other parenthesis
		 */
		final char OpenP = (char) 40;
		final char CloseP = (char) 41;

		int pos = -1;
		// Stack is a First in last out implementation
		ArrayList<Byte> stack = new ArrayList<Byte>();
		int i = s.length() - 1;// i don't want to read the latest character i
								// already know that is a )

		stack.add((byte) 0);// the first parenthesis
		Character c;
		while (i > 0) {
			i--;
			c = s.charAt(i);
			if (c.equals(OpenP)) {
				if (stack.get(stack.size() - 1) == (byte) 0) {
					pos = i;
					i = -1;
				}

				stack.remove(stack.size() - 1);
			}
			if (c.equals(CloseP))
				stack.add((byte) 1);
		}

		return pos;
	}

	/**
	 * This will show a JOptionPane.Message dialog with the input string and an
	 * error icon
	 * 
	 * @param msg
	 */
	public static void PopUpError(String msg) {

		JOptionPane.showMessageDialog(null, msg, "Error",
				JOptionPane.ERROR_MESSAGE/* JOptionPane.OK_OPTION */,
				new ImageIcon(Config.AbsolutePath + "icons/dialog-error.png"));
	}

	/**
	 * This will show a JOptionPane.Message dialog with the input string and a
	 * warning icon
	 * 
	 * @param msg
	 */
	public static void PopUpWarning(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Warning",
				JOptionPane.OK_OPTION, new ImageIcon(Config.AbsolutePath
						+ "icons/dialog-warning.png"));
	}

	/**
	 * Print the log; Variables and their count.
	 */
	public void printLog() {

		// for(int k=0;k<CheckString.Var.getSize();k++){
		for (VString vs : CheckString.Var.Variables) {
			String aux = getVariable(vs.getVar());
			aux = aux.replace("Gg", "_");
			Principal.LogArea.TextArea.append(aux);
			int n = 40;
			for (int i = 0; i < n - aux.length(); i++)
				Principal.LogArea.TextArea.append(".");

			Principal.LogArea.TextArea.append(vs.getCount() + Config.JumpLine);
		}

		// Erase undo history
		Principal.LogArea.TextArea.discardAllEdits();
	}

	/**
	 * Evaluates the functions and prints them in the log
	 */
	public void printResiduals() {
		// Prepare the WorkAround
		Iterator<PositionStorer> WA = CheckString.ResidualWorkAround
				.listIterator();
		PositionStorer PS = new PositionStorer("", "");
		if (WA.hasNext())
			PS = WA.next();
		// End of the preparation
		CheckString Ch = new CheckString();
		CheckString.FunctionsSolved.addAll(CheckString.Functions);
		Iterator<EqStorer> it = CheckString.FunctionsSolved.listIterator();
		Principal.LogArea.TextArea.append(Config.JumpLine + Config.JumpLine);
		Principal.LogArea.TextArea.append(Translation.Language.get(133)
				+ Config.JumpLine + Config.JumpLine);
		String aux;
		String aux2 = new String("");
		String aux3 = new String("");
		int i = 0;
		NumberFormat BigNumber = new DecimalFormat("#####0.##E0");
		NumberFormat AverageNumber = new DecimalFormat("##0.#####");
		NumberFormat SmallNumber = new DecimalFormat("#.#####E0");
		double result = 0;
		EqStorer Eqaux;
		while (it.hasNext()) {
			Eqaux = it.next();
			aux = Eqaux.getEquation();
			i = findEqual(aux);
			aux2 = aux.substring(0, i - 3) + "="
					+ aux.substring(i + 1, aux.length() - 1);
			aux2 = aux2.replace("Degree", "");
			aux2 = aux2.replace("Gg", "_");
			aux2 = aux2.replace("3.141592653589793", "Pi");

			// This is to change the variables with no case information to the
			// CaseVariables
			StringTokenizer lector = new StringTokenizer(aux2,
					"+/*-()[]{} ^=!", false);
			while (lector.hasMoreTokens()) {
				aux3 = lector.nextToken();
				if (!Ch.IsNumber(aux3) & !Ch.IsFunction(aux3))
					for (String s : CheckString.CaseVariables)
						if (aux3.equalsIgnoreCase(s)) {
							aux2 = aux2.replace(aux3, s);
							break;
						}
			}
			// If the equation is one that belongs to the thermodynamic list
			// it won't be show
			if (PS.getOriginal().equalsIgnoreCase(aux2)) {
				aux2 = PS.getSubstitutor();
				if (WA.hasNext())
					PS = WA.next();
			}

			// Add the text to the LogArea
			Principal.LogArea.TextArea.append(aux2);
			Principal.LogArea.TextArea.append(".....");

			for (int j = 0; j < 80 - aux2.length(); j++)
				Principal.LogArea.TextArea.append(".");

			result = DiffAndEvaluator.Evaluate("N[" + aux + "]");

			if (Math.abs(result) < 10000 & Math.abs(result) >= 1e-5)
				Principal.LogArea.TextArea.append(AverageNumber.format(result));

			if (Math.abs(result) == 0)
				Principal.LogArea.TextArea.append(AverageNumber.format(result));

			if (Math.abs(result) < 1e-5 & Math.abs(result) != 0)
				Principal.LogArea.TextArea.append(SmallNumber.format(result));

			if (Math.abs(result) >= 10000)
				Principal.LogArea.TextArea.append(BigNumber.format(result));

			if (Math.abs(result) > Config.Precision)
				ResidualsHigh = true;

			Principal.LogArea.TextArea.append(Config.JumpLine);

		}

		// Erase undo history
		Principal.LogArea.TextArea.discardAllEdits();
	}

	/**
	 * Prints the solutions in the results area and if Config.RememberValues =
	 * true then stores the calculated values as initial values
	 */
	public void printResults() {

		NumberFormat BigNumber = new DecimalFormat("00000.#####E0");
		NumberFormat AverageNumber = new DecimalFormat("####0.#######");
		NumberFormat SmallNumber = new DecimalFormat("0.#####E0");
		int columnas = Principal.ResultArea.TextArea.getSize().width / 8;
		Principal.ResultArea.TextArea.getCaretPosition();
		int pos = columnas / 4;
		int n = 0;
		int col = 0;
		int aux = 0;
		double result;
		String resultado;
		String VaR;

		// This is to store last calculated values as initial values
		if (Config.RemeberLastValues & !DiffAndEvaluator.TimeLimitExceeded
				& !Config.ErrorFound)
			Config.InitValue.clear();

		// Print results
		for (VString vs : CheckString.Var.Variables) {
			result = evaluation.DiffAndEvaluator.Evaluate(vs.getVar());

			VaR = getVariable(vs.getVar());
			resultado = ">> " + VaR + " = ";
			resultado = resultado.replace("Gg", "_");
			if (Math.abs(result) < 100000 & Math.abs(result) >= 1e-5)
				resultado += AverageNumber.format(result);
			if (Math.abs(result) == 0)
				resultado += AverageNumber.format(result);
			if (Math.abs(result) < 1e-5 & Math.abs(result) != 0)
				resultado += SmallNumber.format(result);
			if (Math.abs(result) >= 100000)
				resultado += BigNumber.format(result);

			Principal.ResultArea.TextArea.append(resultado);

			col += resultado.length();
			n++;
			switch (n) {
			case 1:
				aux = pos;
				break;
			case 2:
				aux = pos * 2;
				break;
			case 3:
				aux = pos * 3;
				break;
			default:
				aux = 0;
				break;
			}

			while (col < aux) {
				Principal.ResultArea.TextArea.append(" ");
				col++;
			}

			if (n >= 4) {

				Principal.ResultArea.TextArea.append(Config.JumpLine);
				n = 0;
				col = 0;
			}

			// If Save calculated values
			if (Config.RemeberLastValues & !DiffAndEvaluator.TimeLimitExceeded
					& !Config.ErrorFound)
				Config.InitValue.add(new String2ME.InitVal(result, VaR));

		}

		// Erase all the undo history
		Principal.ResultArea.TextArea.discardAllEdits();
	}

	/**
	 * Check if the variable is in CheckString.CaseVariables
	 * 
	 * @param input
	 * @return
	 */
	private String getVariable(String input) {
		try {
			for (String s : CheckString.CaseVariables)
				if (input.equalsIgnoreCase(s))
					return s;
			return input;
		} catch (Exception e) {
			return input;
		}

	}

	protected static int LastWindowFocused = 0;

	/**
	 * @return an Integer representing which text area is focused; 1 = textarea;
	 *         2 = Render area; 3 = LogArea; 4 = Result Area; 5 = Mathematics
	 *         input; 6 mathematics console; 7 = jSearch of text area; 8 =
	 *         jSearch of log area; 9 = jSearch of result area
	 */
	protected static int windowFocused() {
		int retorno = 0;
		if (Principal.TextArea.TextArea.isFocusOwner())
			retorno = 1;
		if (Principal.Rendered.isFocusOwner())
			retorno = 2;
		if (Principal.LogArea.TextArea.isFocusOwner())
			retorno = 3;
		if (Principal.ResultArea.TextArea.isFocusOwner())
			retorno = 4;
		if (Principal.mathPane.jCommandInput.isFocusOwner())
			retorno = 5;
		if (Principal.mathPane.Consola.isFocusOwner())
			retorno = 6;
		if (Principal.TextArea.jSearch.isFocusOwner())
			retorno = 7;
		if (Principal.LogArea.jSearch.isFocusOwner())
			retorno = 8;
		if (Principal.ResultArea.jSearch.isFocusOwner())
			retorno = 9;

		if (retorno != 0)
			LastWindowFocused = retorno;

		return retorno;

	}

	/**
	 * Set disable or not this buttons of the menu bar
	 * 
	 * @param redo
	 * @param undo
	 * @param cut
	 * @param copy
	 * @param paste
	 */
	public static void setMenustatus(boolean redo, boolean undo, boolean cut,
			boolean copy, boolean paste) {
		Principal.mainmenu.jUndo.setEnabled(undo);
		Principal.mainmenu.jRedo.setEnabled(redo);
		Principal.mainmenu.jPaste.setEnabled(paste);
		Principal.mainmenu.jCopy.setEnabled(copy);
		Principal.mainmenu.jCut.setEnabled(cut);
	}

	/**
	 * Comments starts with /* and finish with * / (Together).
	 * 
	 * @param input
	 * @return The input without comments
	 */
	private String cleanComments(String input) {
		boolean comments = false;
		char c;
		char pc = CheckString.Espacio;
		String aux = new String("");
		StringReader J = new StringReader(input);
		BufferedReader BufJ = new BufferedReader(J);
		String s = new String("");
		int count = 0, line = 0;

		for (int i = 0; i < input.length(); i++) {

			try {// this is only to introduce line-separators while ignoring
					// comments
				if (count == line)
					s = BufJ.readLine();
				if (s != null) {
					line = s.length();
				} else
					line = 0;
			} catch (Exception e) {
				line = 0;
			}

			c = input.charAt(i);
			count++;

			if (pc == CheckString.Slash & c == CheckString.Por) {
				// This is to erase the previous character that was inserted in
				// aux
				aux = aux.substring(0, aux.length() - 1);
				comments = true;
				pc = CheckString.Espacio;
			}

			if (comments) {
				if (count == line)
					if (pc == CheckString.Por & c == CheckString.Slash) {/*
																		 * Do
																		 * nothing
																		 */
					} else
						aux += Config.JumpLine;

			} else
				aux += c;

			if (pc == CheckString.Por & c == CheckString.Slash)
				comments = false;

			if (count == line)
				count = 0;
			// save previous character
			pc = c;

		}
		return aux;
	}

	/**
	 * Reads the error type and show if necessary a PopUpwindow with information
	 * 
	 * @param aux2
	 * @param i
	 */
	public void checkGram(GramErr aux2) {
		/* If there is any kind of error a pop up window will be shown */
		if (!Config.ErrorFound)// Just one error, every time
			switch (aux2.GetTypeError()) {
			// Maybe i should show the matheclipse error if the error is
			// different
			case 0:
				break;// There are no errors
			case 1:
				PopUpWarning(Translation.Language.get(123) + aux2.GetCaracter()
						+ ">");
				Config.ErrorFound = true;
				break;
			case 2:
				PopUpWarning(Translation.Language.get(125) + aux2.GetCaracter()
						+ ">");
				Config.ErrorFound = true;
				break;
			case 3:
				PopUpWarning(Translation.Language.get(126) + aux2.GetCaracter()
						+ ">");
				Config.ErrorFound = true;
				break;
			case 4:
				PopUpWarning(Translation.Language.get(127) + aux2.GetCaracter()
						+ ">");
				Config.ErrorFound = true;
				break;
			case 5:
				PopUpWarning(Translation.Language.get(128));
				Config.ErrorFound = true;
				break;
			case 6:
				PopUpWarning(Translation.Language.get(129));
				Config.ErrorFound = true;
				break;
			case 7:
				PopUpWarning(Translation.Language.get(130));
				Config.ErrorFound = true;
				break;
			case 8:
				PopUpWarning(Translation.Language.get(131) + ". "
						+ Translation.Language.get(195) + "<"
						+ aux2.getString() + ">" + Config.JumpLine
						+ Translation.Language.get(132));
				Config.ErrorFound = true;
				break;
			case 9:
				PopUpWarning(Translation.Language.get(196) + aux2.GetCaracter()
						+ ">");
				Config.ErrorFound = true;
				break;
			case 10:
				PopUpWarning(Translation.Language.get(127) + aux2.getString()
						+ ">");
				Config.ErrorFound = true;
				break;

			}
	}

	/**
	 * 
	 * @param input
	 * @param Materiales
	 * @param check
	 * @return If there is a call function(I.E: water.Cp(Temperature,Cp,...))
	 *         the output string will contain the equation if not, the output
	 *         string will be the same of the input. The byte of the GramErr ==
	 *         1 if the substance/property is not found else == 0
	 */
	public GramErr searchThermodynamicFunction(String input,
			MaterialMethods Materiales, CheckString ch) {
		try {// I don't know why but it gives an error if the first variable
				// it's call T by the user

			if (checkSubstance(input, Materiales)) {
				StringTokenizer lector = new StringTokenizer(input, ".(),",
						true);
				String aux, material = null, property = null, PrevToken = null;
				LinkedList<String> Variables = new LinkedList<String>();
				// The functions are to be like this:
				// water.Cp(Temperature,Cp,...)
				while (lector.hasMoreTokens()) {
					aux = lector.nextToken();
					if (aux.equalsIgnoreCase("."))// The previous token must be
													// the material
						material = new String(PrevToken);
					if (aux.equalsIgnoreCase("("))// The previous token must be
													// the property
						property = new String(PrevToken);
					if (aux.equalsIgnoreCase(","))// The previous token must be
													// a variable
						Variables.add(new String(PrevToken));
					if (aux.equalsIgnoreCase(")"))// The previous token must be
													// last variable
						Variables.add(new String(PrevToken));
					PrevToken = aux;
				}

				// Search the substance and property
				for (MaterialList m : Materiales.Materials)
					if (m.getMaterial().equalsIgnoreCase(material))
						for (MaterialStore ms : m.getPropertyList())
							if (ms.getProperty().equalsIgnoreCase(property)) {
								aux = ms.getFormula();
								// Erase the spaces in the variables and then
								// split
								String[] aux2 = ms.getVariables().replace(" ",
										"").split(",");

								// Replace the variables
								aux = aux.replace(" ", "");
								lector = new StringTokenizer(aux,
										"+/*-()[]{} ^=!", true);
								String cadena = "";
								String resultado = new String("");
								int pos = -1;
								while (lector.hasMoreTokens()) {
									cadena = lector.nextToken();
									try {
										pos = this.varPosition(cadena, aux2);
										if (pos != -1)
											resultado += Variables.get(pos);
										else
											resultado += cadena;
									} catch (Exception e) {
										resultado += cadena;
									}

								}
								// Material found. Add workaround for residuals
								// and return
								CheckString.ResidualWorkAround
										.add(new PositionStorer(resultado,
												input));
								return new GramErr((byte) 0, resultado);
							}
				// If the functions arrives here then the material or property
				// does not exists
				return new GramErr((byte) 1, input);

			}
			return new GramErr((byte) 0, input);

		} catch (Exception e) {
			return new GramErr((byte) 0, input);
		}

	}

	/**
	 * 
	 * @param var
	 * @param list
	 * @return The position of the variable. -1 means not found
	 */
	private int varPosition(String var, String[] list) {
		int i = 0;
		for (String s : list) {
			if (s.equalsIgnoreCase(var))
				return i;
			i++;
		}
		return -1;
	}

	/**
	 * 
	 * @param input
	 * @param check
	 * @return Change the input function water.Cp(Temp,Cp) --> f(water,Cp) =
	 *         (TempCcCp) the Cc is only because later the matheclipse can give
	 *         some errors if there is a real comma
	 */
	private GramErr changeThermodynamicFunction(String input,
			MaterialMethods Materiales, CheckString ch) {
		try {
			if (checkSubstance(input, Materiales)) {
				StringTokenizer lector = new StringTokenizer(input, ".(),",
						true);
				String aux, material = null, property = null, PrevToken = null;
				LinkedList<String> Variables = new LinkedList<String>();
				// The functions are to be like this:
				// water.Cp(Temperature,Cp,...)
				while (lector.hasMoreTokens()) {
					aux = lector.nextToken();
					if (aux.equalsIgnoreCase("."))// The previous token must be
													// the material
						material = new String(PrevToken);
					if (aux.equalsIgnoreCase("("))// The previous token must be
													// the property
						property = new String(PrevToken);
					if (aux.equalsIgnoreCase(","))// The previous token must be
													// a variable
						Variables.add(new String(PrevToken));
					if (aux.equalsIgnoreCase(")"))// The previous token must be
													// last variable
						Variables.add(new String(PrevToken));
					PrevToken = aux;
				}
				aux = "Function*(" + material + CommaSubtitutor + property
						+ ") = (";
				for (String s : Variables)
					aux += s + CommaSubtitutor;
				aux = aux.substring(0, aux.length()
						- (CommaSubtitutor.length() - 1));// For erasing the
															// last cc
				aux += ")";

				aux = aux.replace("_", BarraSubstitutor);
				return new GramErr((byte) 0, aux);

			} else
				return new GramErr((byte) 0, input);

		} catch (Exception e) {
			return new GramErr((byte) 0, input);
		}

	}

	/**
	 * Checks if the input string has a call function. Like water.Cp(Temp,Cp)
	 * 
	 * @param s
	 * @return true if there is a call function
	 */
	private boolean checkSubstance(String input, MaterialMethods Materiales) {
		int pos = input.indexOf(".");
		if (!input.contains("."))
			return false;
		else {
			String aux = input.substring(0, pos);
			for (String s : Materiales.getMaterials())
				if (aux.equalsIgnoreCase(s))
					return true;

			return false;

		}
	}

	/**
	 * Search for the input string in the textarea. If not found at the first
	 * time the string is reduced by one character and the search starts again.
	 * Until something is found or until the string is reduced to zero
	 * 
	 * @param error
	 */
	private void showError(String error) {
		boolean found = false;
		while (!found & error.length() != 0) {
			Principal.TextArea.TextArea.setCaretPosition(0);
			found = Principal.TextArea.Search(error);
			if (!found & error.length() != 0)
				error = error.substring(0, error.length() - 1);
		}
	}

}
