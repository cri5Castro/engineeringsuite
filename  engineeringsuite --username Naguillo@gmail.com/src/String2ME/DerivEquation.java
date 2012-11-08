package String2ME;

/**
 * A class to store the derivation of a function and the variable it was
 * differentiated from
 * 
 * @author Pablo salinas
 * 
 */
public class DerivEquation {
	/**
	 * The derivative of the function
	 */
	private String _Deriv;
	/**
	 * The variable
	 */
	private String _var;

	/**
	 * @param funcion
	 * @param variable
	 */
	public DerivEquation(String funcion, String var) {
		_Deriv = funcion;
		_var = var;
	}

	public DerivEquation(String var) {
		_var = var;
	}

	/**
	 * Returns the differentiation
	 * 
	 * @return String
	 */
	public String GetDeriv() {
		return _Deriv;
	}

	/**
	 * Returns the variable
	 * 
	 * @return String
	 */
	public String GetVar() {
		return _var;
	}

}
