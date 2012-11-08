package plot;

import java.util.StringTokenizer;

/**
 * Translates the input strins tu matheclipse
 */
class PlotTranslate {
	protected String converter(String aux) {// Pi=\u03c0 in unicode
		if (aux.equals("cos"))
			return "Cos";
		if (aux.equals("sin"))
			return "Sin";
		if (aux.equals("tan"))
			return "Tan";
		if (aux.equals("pi"))
			return "Pi";
		if (aux.equals("e"))
			return "E";
		if (aux.equals("exp"))
			return "Exp";
		if (aux.equals("log"))
			return "Log";
		if (aux.equals("sinh"))
			return "Sinh";
		if (aux.equals("cosh"))
			return "Cosh";
		if (aux.equals("tanh"))
			return "Tanh";
		if (aux.equals("arcsin"))
			return "ArcSin";
		if (aux.equals("arccos"))
			return "ArcCos";
		if (aux.equals("arctan"))
			return "ArcTan";
		return aux;
	}

	protected String translate(String aux) {
		String cadena = new String("");
		String aux2 = new String("");
		String n;
		for (int i = 0; i < aux.length(); i++) {
			cadena += Character.toLowerCase(aux.charAt(i));
		}
		StringTokenizer lector = new StringTokenizer(cadena, "+/*-()[]{} ^=!",
				true);
		while (lector.hasMoreTokens()) {
			n = lector.nextToken();
			if (!n.equals(" "))
				aux2 += converter(n);
		}

		return aux2;
	}
}