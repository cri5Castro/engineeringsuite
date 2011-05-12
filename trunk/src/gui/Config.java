package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/*-------------------------TAREAS PENDIENTES---------------------------*/
//HE VUELTO A MECONSOLE 0.0.9 PORQUE LAS NUEVAS VERSIONES NO FUNCIONAN BIEN
//VERSION 1.02

//SUBIR CAMBIOS REALIZADOS A LA PÁGINA
//HACER Y METER UN VIDEO EN LA PAGINA WEB: <wiki:video url="http://www.youtube.com/watch?v=3LkNlTNHZzE"/> 
//BUSCAR Y SOLUCIONAR ERRORES. INTENTAR TESTEAR LA APLICACIÓN
//EXPORTAR A PDF E IMPRIMIR RENDER PRINT
//VERSION 1.1

//INCLUIR NUEVAS FUNCIONES A MATHEMATICS: 3DPLOT?,...
//REVISAR LA IMPLEMENTACIÓN DEL ALGORITMO DE TARJAN Y MEJORARLA
//INTENTAR USAR TMB UN METODO DE OPTIMIZACIÓN GENÉTICO:
//JENES: http://jenes.ciselab.org/		(Interesante)
//JAGA: http://www.jaga.org/
//GAlib: http://sourceforge.net/projects/java-galib/
//JGAP: http://jgap.sourceforge.net/		(Interesante)
//COMMONS-MATH TMB INCLUYE METODOS GENETICOS...
//VERSION 1.2

//INCLUIR TABLAS Y GRAFICAS
//INCLUIR AREA DE DIBUJO. ¿TERPPAINT?
//INCLUIR MAS MATERIALES, SINCRONIZAR MATERIALES CON EL SERVIDOR, PERMITIR SUBIR MATERIALES A LOS USUARIOS?
//VERSION 1.3

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import String2ME.CheckString;

/**
 * This class stores global variables and reads and writes the configuration
 * file
 * 
 * @author Pablo Salinas
 */
public class Config {

	/**
	 * This string stores the Absolute path to the directory in Linux. In
	 * windows it's empty.
	 */
	public static String AbsolutePath = System.getProperty("java.class.path");

	/**
	 * Creates the String AbsolutePath. Linux = Absolute path. Windows = ""
	 */
	public static void getAbsolutePath() {
		if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
			int pos = 0;
			if (Config.AbsolutePath.contains("bin:"))// This is to work properly
														// while working with
														// eclipse
				pos = AbsolutePath.indexOf(System.getProperty("file.separator")
						+ "bin:");
			else
				pos = AbsolutePath.lastIndexOf(System
						.getProperty("file.separator"));

			Config.AbsolutePath = Config.AbsolutePath.substring(0, pos)
					+ System.getProperty("file.separator");
		} else
			Config.AbsolutePath = "";

	}

	/**
	 * The epsilon of the machine
	 */
	public static double epsilon = 1e-16;

	/**
	 * Computes the epsilon of the machine
	 */
	public static void makeEpsilon() {
		double ep = 1;
		while (1 + ep != 1)
			ep = ep / 10;
		epsilon = ep;
	}

	/**
	 * Stores the current FontName. By default Sans Serif.
	 */
	public static String CurrentFontName = new String(Font.SANS_SERIF);
	/**
	 * Stores the current font size. By default 14.
	 */
	public static int CurrentFontSize = 14;
	/**
	 * Stores the Current font in use in the SyntaxTextAreas
	 */
	public static Font CurrentFont = new Font(CurrentFontName, Font.PLAIN,
			CurrentFontSize);
	/**
	 * Stores the UITheme. By default Nimbus.
	 */
	public static String Theme = new String("Nimbus");
	/**
	 * Sets the iteration number at which the newton method will stop
	 */
	public static int MaxNumberOfIteration = 200;
	/**
	 * Sets the precision of the Newton method
	 */
	public static double Precision = Math.sqrt(epsilon);
	/**
	 * Maximum allowable jump between two steps
	 */
	public static double MaxJump = 0;
	/**
	 * The method to use in the resolution of system of equations 1 =
	 * Line-Search 2 = Double Dogleg 3 = Hebden-More 4 = Levenberg-Marquard
	 */
	public static byte MultiVariableMethod = 4;
	/**
	 * The method to use in the resolution of single equations 1 = Line-Search 2
	 * = Double Dogleg 3 = Hebden-More 4 = Levenberg-Marquard
	 */
	public static byte SingleVariableMethod = 4;
	/**
	 * If this is !=0 , if the optimization method ends in a minimum that is not
	 * a root the solver will call a newton step and then again the optimization
	 * method trying to avoid that minimum
	 */
	public static int IterationAntiMinimum = 0;// Antiminimum only for Gauss,
												// Dogleg and Hebden-Moré
	/**
	 * Sets the Language. By default English.
	 */
	public static String Language = new String("English");
	/**
	 * The line separator of the system, usually /n
	 */
	public static final String JumpLine = new String(System
			.getProperty("line.separator"));
	/**
	 * If an error is found while parsing the equations, the newton method will
	 * not start
	 */
	public static boolean ErrorFound = false;
	/**
	 * The initial value for all the variables which are not in InitValue
	 */
	public static double DefaultInitialValue = 1;
	/**
	 * This List stores the initial values set by the user. This values will be
	 * save in the .ris file.
	 */
	public static ArrayList<String2ME.InitVal> InitValue = new ArrayList<String2ME.InitVal>();
	/**
	 * This is the maximum time in seconds allowed to a count in the math
	 * section
	 */
	public static int MaxCalculateTime = 10;
	/**
	 * This is the maximum time in seconds allowed for solving the variables
	 */
	public static int MaxOperationsTime = 20;
	/**
	 * Maximum positive number allowed in plot
	 */
	public static double MaxPositivePlot = Integer.MAX_VALUE / 10000;
	/**
	 * Maximum negative number allowed in plot
	 */
	public static double MaxNegativePlot = -MaxPositivePlot;
	/**
	 * Set if the values calculated must be stored as initial values or not
	 */
	public static boolean RemeberLastValues = false;
	/**
	 * Precision at which the algorithm stops if the gradient is lower than that
	 */
	public static double GradientPrecision = Math.pow(epsilon, 1.0 / 3.0);
	/**
	 * The radius used in the trust region method; -1 means automatic selection
	 * by the algorithm
	 */
	public static double TrustRegionRadius = -1;
	/**
	 * If it is the first that the program is executed then this will be true
	 */
	protected static boolean FirstRun = false;

	/**
	 * This method reads the configuration file and sets the values. If there is
	 * none it will create one with the default values.
	 */
	public void ReadConfig() {

		FileReader r;
		try {
			r = new FileReader(Config.AbsolutePath + "config.txt");
			BufferedReader b = new BufferedReader(r);
			String s = null;

			// 1º The Font Name, can only be MONOSPACED, SERIF, or SANS_SERIF
			s = ReadConf(b.readLine());
			if ((s.equals(Font.MONOSPACED)) | ((s.equals(Font.SERIF)))
					| (s.equals(Font.SANS_SERIF)))
				CurrentFontName = s;
			else
				CurrentFontName = Font.MONOSPACED;

			// 2º The font size
			s = ReadConf(b.readLine());
			try {
				CurrentFontSize = Integer.parseInt(s);
			} catch (Exception e) {
				CurrentFontSize = 14;
			}

			// Sets the new font
			CurrentFont = new Font(CurrentFontName, Font.PLAIN, CurrentFontSize);

			// 3º theme. I don't check this, because, later if there is any
			// problem Nimbus will be forced to be the UI
			s = ReadConf(b.readLine());
			Theme = s;
			// 4º Maximum number of operations
			s = ReadConf(b.readLine());
			try {
				MaxNumberOfIteration = Integer.parseInt(s);
			} catch (Exception e) {
				e.printStackTrace(); /* Don't change the max number of operations */
			}

			// 5º Precision of the results
			s = ReadConf(b.readLine());
			try {
				Precision = Double.parseDouble(s);
			} catch (Exception e) {
				e.printStackTrace(); /* Don't change the precision */
			}

			// 6º Read the language
			s = ReadConf(b.readLine());
			Language = s;// This will be checked when the language file will be
							// loading

			// 7º Default Initial Value
			s = ReadConf(b.readLine());
			try {
				DefaultInitialValue = Double.parseDouble(s);
			} catch (Exception e) {
				e.printStackTrace(); /* Don't change the initial value */
			}

			// 8º Maximum time for an operation
			s = ReadConf(b.readLine());
			try {
				MaxCalculateTime = Integer.parseInt(s);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 9º Maximum positive Plot
			s = ReadConf(b.readLine());
			try {
				MaxPositivePlot = Double.parseDouble(s);
			} catch (Exception e) {
				e.printStackTrace(); /* Don't change the initial value */
			}

			// 10º Maximum Negative Plot
			s = ReadConf(b.readLine());
			try {
				MaxNegativePlot = Double.parseDouble(s);
			} catch (Exception e) {
				e.printStackTrace(); /* Don't change the initial value */
			}

			// 11º Radians or Degrees
			s = ReadConf(b.readLine());
			try {
				CheckString.Radianes = Boolean.parseBoolean(s);
			} catch (Exception e) {
				e.printStackTrace(); /* Don't change the initial value */
			}

			// 12º Maximum operations calculation time
			s = ReadConf(b.readLine());
			try {
				Config.MaxOperationsTime = Integer.parseInt(s);
			} catch (Exception e) {
				e.printStackTrace();/* Don't change the initial value */
			}

			// 13ºMaximum jump
			s = ReadConf(b.readLine());
			try {
				Config.MaxJump = Double.parseDouble(s);
			} catch (Exception e) {
				e.printStackTrace(); /* Don't change the initial value */
			}

			// 14ºGradient precision
			s = ReadConf(b.readLine());
			try {
				Config.GradientPrecision = Double.parseDouble(s);
			} catch (Exception e) {
				e.printStackTrace(); /* Don't change the initial value */
			}

			// 15º Antiminimum
			s = ReadConf(b.readLine());
			try {
				Config.IterationAntiMinimum = Integer.parseInt(s);
			} catch (Exception e) {
				e.printStackTrace();/* Don't change the initial value */
			}

			// 16º Maximum operations calculation time
			s = ReadConf(b.readLine());
			try {
				Config.SingleVariableMethod = Byte.parseByte(s);
			} catch (Exception e) {
				e.printStackTrace();/* Don't change the initial value */
			}

			// 17º Maximum operations calculation time
			s = ReadConf(b.readLine());
			try {
				Config.MultiVariableMethod = Byte.parseByte(s);
			} catch (Exception e) {
				e.printStackTrace();/* Don't change the initial value */
			}

			// 18º Remember last calculated values
			s = ReadConf(b.readLine());
			try {
				Config.RemeberLastValues = Boolean.parseBoolean(s);
			} catch (Exception e) {
				e.printStackTrace(); /* Don't change the initial value */
			}

			// 19ºGradient precision
			s = ReadConf(b.readLine());
			try {
				Config.TrustRegionRadius = Double.parseDouble(s);
			} catch (Exception e) {
				e.printStackTrace(); /* Don't change the initial value */
			}

			// Close the readers
			b.close();
			r.close();
		} catch (Exception e) {
			// Creates a configuration file and save the default values
			SaveConfig();
			// Show an example in the equation window explaining the program
			FirstRun = true;
		}

	}

	/**
	 * Saves the configuration in a textPlain file called config.txt
	 */
	public void SaveConfig() {
		try {
			FileWriter w = new FileWriter(Config.AbsolutePath + "config.txt");
			BufferedWriter o = new BufferedWriter(w);
			PrintWriter p = new PrintWriter(o);

			// 1º The Font Name, can only be MONOSPACED, SERIF, or SANS_SERIF
			if ((CurrentFontName.equals(Font.MONOSPACED))
					| ((CurrentFontName.equals(Font.SANS_SERIF)))
					| (CurrentFontName.equals(Font.SERIF)))
				p.println("Font: " + CurrentFontName);
			else
				p.println("Font: " + Font.MONOSPACED);

			// 2º the Font Size

			p.println("FontSize: " + CurrentFontSize);

			// 3º Theme
			if ((Theme.equals("Nimbus")) | ((Theme.equals("Metal")))
					| (Theme.equals("Motif")) | (Theme.equals("System")))
				p.println("Theme: " + Theme);
			else
				p.println("Theme: Nimbus");

			// 4º Maximum number of iterations
			p.println("MaxNumberOfIterations: " + MaxNumberOfIteration);

			// 5º Precision
			p.println("Precision: " + Precision);

			// 6º Language
			p.println("Language: " + Language);// This will be checked when the
												// language file exists

			// 7º Default initial value for the newton method
			p.println("DefaultInitialValue: " + DefaultInitialValue);

			// 8º Maximum time for an operation in seconds
			p.println("MaximumTimeOperation: " + MaxCalculateTime);

			// 9º Maximum positive plot number
			p.println("MaxPositivePlot: " + MaxPositivePlot);

			// 10º Maximum negative plot
			p.println("MaxNegativePlot: " + MaxNegativePlot);

			// 11º Degrees or Radians
			p.println("Radians: " + Boolean.toString(CheckString.Radianes));

			// 12º Maximum operation calculation time
			p.println("MaxOperationCalcTime: "
					+ Integer.toString(Config.MaxOperationsTime));

			// 13º Maximum jump step
			p.println("MaxJumpStep: " + Double.toString(Config.MaxJump));

			// 14º Gradient Precision
			p.println("GradientPrecision: "
					+ Double.toString(Config.GradientPrecision));

			// 15º Antiminimum
			p.println("Antiminimum: "
					+ Integer.toString(Config.IterationAntiMinimum));

			// 16º Single variable method
			p.println("SingleVariableMethod: "
					+ Byte.toString(Config.SingleVariableMethod));

			// 17º MultiVariable method
			p.println("MultiVariableMethod: "
					+ Byte.toString(Config.MultiVariableMethod));

			// 18º Remember last calculated values
			p.println("RemeberLastCalcValues: "
					+ Boolean.toString(Config.RemeberLastValues));

			// 19º Trust region radius
			p.println("TrustRegionRadius: "
					+ Double.toString(Config.TrustRegionRadius));

			// Close the writers
			p.close();
			o.close();
			w.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method reads the config file; This file is like this MaxNumber: 200;
	 * So MaxNumber: is ignored and only 200 is readed;
	 * 
	 * @param String
	 * @return The substring with the information of the config file.
	 */
	private String ReadConf(String aux) {
		String aux2 = new String("");
		aux2 = aux.replaceAll(" ", "");// Erase the spaces
		aux2 = aux2.substring(aux2.indexOf(58) + 1);// (char) 58 = :
		return aux2;
	}

	/**
	 * This is the safe method to use the Nimbus theme
	 * 
	 * @return A string to set Nimbus theme
	 */
	public static String getTheme(String tema) {
		if (tema.equalsIgnoreCase("Nimbus")) {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName()))
					return info.getClassName();
			}
		}
		if (tema.equalsIgnoreCase("Metal")) {
			return "javax.swing.plaf.metal.MetalLookAndFeel";
		}
		if (tema.equalsIgnoreCase("System")) {
			return UIManager.getSystemLookAndFeelClassName();
		}
		if (tema.equalsIgnoreCase("Motif")) {
			return "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		}

		return "javax.swing.plaf.metal.MetalLookAndFeel";
	}

	/**
	 * Writes an example if the there is not a configuration file.
	 */
	protected void writeInitialExample() {

		String aux = new String(
				"/**You can change the LANGUAGE and the THEME in edit/Preferences.\n"
						+ "There are two kind of commentaries:\nRed: Starts with /** and finish with */\n"
						+ "/*And green: starts with /* and finish with */\n"
						+ "/*Let's see two examples:\n\n*/"
						+ "/*First example, usual equation system:*/\n\n"
						+ "F = M * A\nM = 2 * 2 + 1 - 1 + sin(Pi) + sinh(e)\nA = 2^2*(exp(2/3)+log(1))\n\n"
						+ "/**Second example,use of thermodynamic functions:*/\n\n"
						+ "/**Temperature: Kelvin.\nCp: Kj/(Kg*Kelvin)\nAverage error: 0.24\nValidity: 273 to 1500*/\n"
						+ "Butane.Cp(Cp, Temperature)\n"
						+ "/*You can change the name of the variables Cp and temperature, but the order must be the same*/\n"
						+ "Temperature = 700\n\n"
						+ "/**Calculating TEMPERATURE or PRESSURE with this kind of thermodynamical equations may require and initial guess "
						+ "for the variable*/"
						+ "\n\n/*Use the PLAY button, or F3 to solve the equations\nUse F4 or the REFRESH button in"
						+ " Render equations in order to wirte the equations properly. */ "
						+ "\n/**Press F1 or go to HELP/HELP in the toolbar to get more information.*/"
						+ "\n\n/*This example is stored in the carpet of the program if you want to see it again.*/");
		Principal.TextArea.TextArea.setText(aux);
		JOptionPane.showMessageDialog(null,
				"This is the first time that you run eSuite.\n"
						+ "Read the example to start learning the program.\n"
						+ "This message and the example won't be shown again.",
				"Hello user", JOptionPane.OK_OPTION, new ImageIcon(
						Config.AbsolutePath + "icons/help-browser.png"));
	}

	/**
	 * Sets in every window the WaitCursor
	 */
	public void setAllWaitCursor() {
		Principal.frame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Principal.Rendered.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Principal.TextArea.TextArea.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Principal.ResultArea.TextArea.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Principal.LogArea.TextArea.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Principal.mathPane.Consola.setCursor(new Cursor(Cursor.WAIT_CURSOR));
	}

	/**
	 * Sets in every window the initial cursor
	 */
	public void setInitialCursor() {
		Principal.frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		Principal.Rendered.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		Principal.ResultArea.TextArea.setCursor(new Cursor(
				Cursor.DEFAULT_CURSOR));
		Principal.LogArea.TextArea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		Principal.mathPane.Consola.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		Principal.TextArea.TextArea.setCursor(new Cursor(Cursor.TEXT_CURSOR));
	}

}