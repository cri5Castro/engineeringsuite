package solver;

/**
 * A class to store a double value and a boolean to know if this variable has
 * reach the solution
 * 
 * @author Pablo Salinas
 * 
 */
public class nodo {

	private double _valor;

	private boolean bool;

	private String _cadena;

	/**
	 * Set value to work with the X vector in the newton method
	 * 
	 * @param n
	 */
	public nodo(double n, String variable) {
		_valor = n;
		_cadena = variable;
		bool = false;
	}

	/**
	 * Only to work with the F vector in the newton method
	 * 
	 * @param variable
	 */
	public nodo(String variable) {
		_cadena = variable;
		bool = false;
	}

	/**
	 * 
	 * @return the double value
	 */
	public double GetValue() {
		return _valor;
	}

	/**
	 * 
	 * @return The Double value in a string
	 */
	public String GetStringValue() {
		return Double.toString(_valor);
	}

	/**
	 * 
	 * @return The value in a string but with only 3 numbers after the dot
	 */
	public String GetResult() {
		String aux = new String(Double.toString(_valor));
		String resultado = new String("");
		int j = 0;
		boolean dotfound = false;
		boolean Efound = false;

		for (int i = 0; i < aux.length(); i++) {

			if (aux.charAt(i) == (char) (46))
				dotfound = true;
			if (aux.charAt(i) == (char) (69))
				Efound = true;

			if (!dotfound) {
				resultado += aux.charAt(i);
			}
			if (dotfound & (j < 5) & !Efound) {
				j++;
				resultado += aux.charAt(i);
			}
			if (Efound)
				resultado += aux.charAt(i);
		}
		return resultado;
	}

	/**
	 * Set new value
	 * 
	 * @param n
	 */
	public void SetValue(double n) {
		_valor = n;
	}

	/**
	 * 
	 * @return True if solution is reached
	 */
	public boolean IsSolutionReach() {
		return bool;
	}

	/**
	 * set solution as reached
	 */
	public void SolutionReach() {
		bool = true;
	}

	public void SolutionNotReach() {
		bool = false;
	}

	/**
	 * 
	 * @return Returns the string stored, this can be a variable or a equation
	 */
	public String GetCadena() {
		return _cadena;
	}
}