package symbolicEvaluator;

import java.util.StringTokenizer;

import evaluation.DiffAndEvaluator;

/**
 * This class translate the commands introduced in the symbolic evaluator to
 * upperCase; As the commands introduced to mathEclipse are not insensitive to
 * upperCase or lowerCase they have to be translated. As this symbolic evaluator
 * use the same engine than the equationSolver i have decided that this use
 * upperCase and the other uses lowerCase to avoid conflicts in the evaluation
 * of the variables.
 * 
 * @author Pablo Salinas
 * 
 */
public class Translator {

	public static String Operation(String In) {

		String salida = Translate(In);

		if (salida.length() > 200)
			if (salida.substring(0, 8).equals("ANS=ñç@€"))// If true then the
															// error will be
															// print
				return salida.substring(8);

		return DiffAndEvaluator.SymbolicEvaluator(salida);
	}

	/**
	 *As the commands introduced to mathEclipse are not insensitive to
	 * upperCase or lowerCase they have to be translated. As this symbolic
	 * evaluator use the same engine than the equationSolver i have decided that
	 * this use upperCase and the other uses lowerCase to avoid conflicts in the
	 * evaluation of the variables.
	 * 
	 * @param In
	 * @return A String that matheclipse understand
	 */
	public static String Translate(String In) {
		// at first the characters are converted to upperCase
		String IN = new String("");
		for (int i = 0; i < In.length(); i++) {
			IN += Character.toUpperCase(In.charAt(i));

		}
		// Now commands must be detected and translated
		StringTokenizer lector = new StringTokenizer(IN, "+/*-()[]{} ^><,=!",
				true);
		String aux = "";
		String salida = new String("");
		while (lector.hasMoreTokens()) {
			aux = lector.nextToken();

			if (!aux.equals(" "))
				salida += Commands.translate(aux);
		}
		return salida;
	}

	/**
	 * Translate back matheclipse syntaxes to eSuite Math syntaxes
	 * 
	 * @param In
	 * @return
	 */
	public static String Retranslate(String In) {

		StringTokenizer lector = new StringTokenizer(In, "+/*-()[]{} ^=!", true);
		String aux = "";
		String salida = new String("");
		while (lector.hasMoreTokens()) {
			aux = lector.nextToken();
			salida += Commands.backTranslate(aux);
		}

		return salida;
	}

}