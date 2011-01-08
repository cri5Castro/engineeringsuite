package gui;

import java.awt.Cursor;

import javax.swing.JDialog;

import evaluation.DiffAndEvaluator;

import plot.PlotWindow;
import symbolicEvaluator.History;
import symbolicEvaluator.Translator;

/**
 * Mathematic's section methods
 * 
 * @author Pablo Salinas
 * 
 */
class MathematicsGUI {

	/**
	 * Creates a new window to plot equations
	 */
	protected void PlotButton() {
		JDialog windowplot = new PlotWindow(null);
		windowplot.setIconImage(SaveLoad.Icon);
		windowplot.pack();
		windowplot.setVisible(true);

	}

	/**
	 * Writes a string in the symbolic evaluator Console
	 * 
	 * @param In
	 */
	protected void WriteSymbolicEvaluator(String In, OutputTextPane Consola) {

		Consola.printOut("\n");
		Consola.printOut(In);
	}

	/**
	 * Inserts the text in the history, and calls the translator, which calls
	 * matheclipse
	 * 
	 * @param event
	 */
	protected void SymbolicCalc(boolean numerical, OutputTextPane Consola,
			eTextField jCommandInput) {
		MathPane.history = -1;

		try {
			// Sets the cursor to busy
			Principal.frame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			Consola.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			jCommandInput.setCursor(new Cursor(Cursor.WAIT_CURSOR));

			String Text = jCommandInput.getText();

			if (numerical) {
				Text = "Num[" + Text + "]";
			}
			jCommandInput.setText("");
			History.Insert(Text);

			String cadena;
			/*
			 * Search for an equal sign or ". In that case the result won't be
			 * assigned to ans Also search for I, because render print can't
			 * print I, so it will be translated to i that can be printed
			 */
			boolean equal = false;
			boolean irreal = false;
			for (int i = 0; i < Text.length(); i++) {
				if (Text.charAt(i) == 61) {
					equal = true;
				}// 61 in ASCII is =
				if (Text.charAt(i) == 34) {
					equal = true;
				}// 34 = " To avoid help to be assigned to ans
				if ((Text.charAt(i) == 105) | (Text.charAt(i) == 73)) {
					irreal = true;
				}// i and I respectively
			}
			// Input equation
			// This calls DiffAndEvaluator.MathML and then OutputTextPane to
			// print it
			if (MathPane.RenderPrint) {
				try {
					Consola.printOut(">>> ");
					if (irreal) {// irreal=true if there is any I in the input
									// equation
						String Text2 = Translator.Translate(Text);
						String aux = new String("");
						for (int i = 0; i < Text2.length(); i++) {
							if ((Text2.charAt(i) == 105)
									| (Text2.charAt(i) == 73)) {
								aux += "i";// i
							} else
								aux += Text2.charAt(i);
						}
						Consola.RenderPrint(DiffAndEvaluator.MathML(Translator
								.Retranslate(aux)));
					} else {
						Consola.RenderPrint(DiffAndEvaluator.MathML(Translator
								.Retranslate(Translator.Translate(Text))));
					}

				} catch (Exception e) {
					Consola.printOutColored("\n>>> " + Text + "");
				}

			} else
				Consola.printOutColored("\n>>> " + Text + "");

			// Output, solution
			if (equal) {
				cadena = symbolicEvaluator.Translator.Operation(Text);
			} else {// This is to make available the ans memory in the calc
				cadena = symbolicEvaluator.Translator.Operation("ans=" + Text);
			}

			if (DiffAndEvaluator.SymbolicEvaluatorError) {// If true then is a
															// error log
				Consola.printErr("\n" + Translator.Retranslate(cadena));
				DiffAndEvaluator.SymbolicEvaluatorError = false;
			} else {
				if (MathPane.RenderPrint) {// This calls DiffAndEvaluator.MathML
											// and then OutputTextPane to print
											// it
					if (!equal)
						Consola.printOut("\nANS= ");
					else {
						Consola.printOut("\n");
					}
					try {
						Consola.RenderPrint(DiffAndEvaluator.MathML(Translator
								.Retranslate(cadena)));
					} catch (Exception e) {
						Consola.printOutColored("\n"
								+ Translator.Retranslate(cadena));
					}
					Consola.printOut("\n");
				} else {
					if (!equal) {
						Consola.printOutColored("\nans = ");
					}
					Consola.printOutColored("\n"
							+ Translator.Retranslate(cadena) + "\n");
				}
			}

		} catch (Exception e) {
			Consola.printErr(Translation.Language.get(49));
		} finally {
			// Sets the cursor to default
			Principal.frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			Consola.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			jCommandInput.setCursor(new Cursor(Cursor.TEXT_CURSOR));

		}
	}

}