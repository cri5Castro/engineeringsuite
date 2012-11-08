package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import edu.jas.kern.ComputerThreads;

import String2ME.InitVal;

/**
 * @author Pablo Salinas
 */
class SaveLoad {

	/**
	 * The icon for the windows
	 */
	public static final Image Icon = (Toolkit.getDefaultToolkit()
			.getImage(Config.AbsolutePath + "icons/logo.png"));

	/**
	 * Open dialog
	 * 
	 * @param The
	 *            TextArea(RSyntaxTextArea) you want to write the archive
	 */
	protected void Open(RSyntaxTextArea TextArea) {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"eSuite document RIS (.ris)", "ris");
		fc.addChoosableFileFilter(filter);
		fc.setFileFilter(filter);
		fc.setAcceptAllFileFilterUsed(false);
		try {
			int respuesta = fc.showOpenDialog(fc);
			if (respuesta == JFileChooser.APPROVE_OPTION) {

				File file = fc.getSelectedFile();
				fc.getChoosableFileFilters();

				String archivo = file.getAbsolutePath();
				// First i clean everything
				if (archivo.length() > 0)
					CleanAll();

				Principal.SaveFile = archivo;

				/* 1º Load equations method */
				FileReader r = new FileReader(archivo);
				BufferedReader b = new BufferedReader(r);
				String s = null;
				String text = new String();
				do {
					s = b.readLine();
					if (!s.equals("@$@%@EndOfEquationData@$@%@"))
						text += s + Config.JumpLine;
				} while ((!s.equals("@$@%@EndOfEquationData@$@%@")));
				TextArea.setText(text);

				/* 2º Load Initial Values data method */
				do {
					s = b.readLine();
					s = s.replace(" ", "");
					if (!s.equals("@$@%@EndOfInitialVariableValueData@$@%@")) {
						int k = s.indexOf((char) 61);// (char) 61 = equal sign
						try {
							Config.InitValue.add(new InitVal(
									Double.parseDouble(s.substring(k + 1, s
											.length())), s.substring(0, k)));
						} catch (NumberFormatException e) {
							e.printStackTrace();
							Config.InitValue.add(new InitVal(
									Config.DefaultInitialValue, s.substring(0,
											k)));
						}
					}

				} while ((!s.equals("@$@%@EndOfInitialVariableValueData@$@%@")));

				b.close();
				r.close();
			} else {/* Do nothing */
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Open File Error, or no file selected");
		} finally {
			// Sets the cursor at the beginning of the textArea
			Principal.TextArea.TextArea.setCaretPosition(0);
			// Erase all the undo/redo history
			Principal.TextArea.TextArea.discardAllEdits();
		}

	}

	/**
	 * Save dialog
	 * 
	 * @param The
	 *            TextArea(RSyntaxTextArea) you want to save
	 */
	protected void Save(RSyntaxTextArea TextArea, boolean SaveAs) {
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"eSuite document RIS (.ris)", "ris");
		fc.addChoosableFileFilter(filter);
		fc.setFileFilter(filter);

		try {
			String archivo;

			if (Principal.SaveFile.equals("NoFileSelected") | SaveAs) {
				int respuesta = fc.showSaveDialog(fc);
				if (respuesta == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					archivo = file.getAbsolutePath();
					Principal.SaveFile = archivo;
				} else {
					archivo = null;
				}
			} else {

				archivo = Principal.SaveFile;
			}

			if (!archivo.substring(archivo.length() - 4, archivo.length())
					.equals(".ris"))
				archivo += ".ris";
			/* 1º Save equations method */
			FileWriter w = new FileWriter(archivo);
			BufferedWriter o = new BufferedWriter(w);
			PrintWriter p = new PrintWriter(o);

			String s = new String("");
			StringReader J = new StringReader(TextArea.getText());
			BufferedReader BufJ = new BufferedReader(J);
			for (int i = 0; i < TextArea.getLineCount(); i++) {
				s = BufJ.readLine();

				if (s != null)
					p.println(s);
			}
			/*
			 * To the end of the TextArea i will add a final line, so later i
			 * can save more data, as tables for example
			 */
			p.println("@$@%@EndOfEquationData@$@%@");

			/*
			 * 2º Now i will save the initial values of the variables set at the
			 * preferences panel The values will be stored like this: Variable =
			 * Value
			 */
			for (int i = 0; i < Config.InitValue.size(); i++) {
				p.println(Config.InitValue.get(i).getVariable() + " = "
						+ Double.toString(Config.InitValue.get(i).getValue()));
			}
			/* The end of initial values */
			p.println("@$@%@EndOfInitialVariableValueData@$@%@");

			BufJ.close();
			J.close();
			p.close();
			o.close();
			w.close();
		} catch (NullPointerException NE) {
			System.out.println("No file selected");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Save File Error, or no file selected");
		}

	}

	/**
	 * Erase current document after a Confirm dialog
	 * 
	 * @param TextArea
	 */
	protected void NewFile() {

		int n = JOptionPane.showOptionDialog(null, Translation.Language
				.get(117), Translation.Language.get(41),
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				new ImageIcon(Config.AbsolutePath + "icons/help-browser.png"),
				null, null);
		// Yes = 0 ; No = 1

		if (n == 0) {

			CleanAll();
			Principal.SaveFile = "NoFileSelected";

		}

	}

	/**
	 * See if the document is not saved and after that ask you to save it if
	 * necessary or only ask the user if he is sure about exiting the program
	 */
	protected static void Salir() {
		Principal.frame.setEnabled(true);
		boolean save = false;
		String texto = Principal.TextArea.TextArea.getText();
		try {
			// Checks the saved document to see if the user is going to exit
			// with the document unsaved
			if (!Principal.SaveFile.equalsIgnoreCase("NoFileSelected")) {
				/* 1º Load equations method */
				FileReader r = new FileReader(Principal.SaveFile);
				BufferedReader b = new BufferedReader(r);
				String s = null;
				String text = new String();
				do {
					s = b.readLine();
					if (!s.equals("@$@%@EndOfEquationData@$@%@"))
						text += s + Config.JumpLine;
				} while ((!s.equals("@$@%@EndOfEquationData@$@%@")));

				if (!text.equalsIgnoreCase(texto))
					save = true;
			} else {
				if (texto.length() > 0)
					save = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String msg1 = Translation.Language.get(118);
			String icono = Config.AbsolutePath + "icons/help-browser.png";
			if (save) {
				msg1 = Translation.Language.get(349);
				icono = Config.AbsolutePath + "icons/dialog-warning.png";
			}
			int n = JOptionPane.showOptionDialog(null, msg1,
					Translation.Language.get(40), JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, new ImageIcon(icono), null,
					null);

			if (n == 0) {
				ComputerThreads.terminate();
				System.exit(0);
			}
		}
	}

	/**
	 * Cleans up all the text areas and information of a file, such as initial
	 * values
	 */
	private static void CleanAll() {

		Principal.TextArea.TextArea.setText("");// Clean the TextArea
		Principal.ResultArea.TextArea.setText("");// Clean the result Area
		Principal.LogArea.TextArea.setText("");// Clean the log area
		Principal.Rendered.setText("");// Clean the rendered area
		Config.InitValue.clear();// Clean the initial values
		Principal.TextArea.TextArea.discardAllEdits();
	}

}