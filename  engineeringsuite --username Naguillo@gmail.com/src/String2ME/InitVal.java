package String2ME;

/**
 * Storer class of the initial values of the variables
 * 
 * @author Pablo Salinas
 * 
 */
public class InitVal {
	/**
	 * Initial value
	 */
	private double Value;
	/**
	 * Variable
	 */
	private String Variable;

	/**
	 * Set the values
	 * 
	 * @param value
	 * @param variable
	 */
	public InitVal(double value, String variable) {
		this.Value = value;
		this.Variable = new String(variable);
	}

	/**
	 * 
	 * @return initial point
	 */
	public double getValue() {
		return Value;
	}

	/**
	 * 
	 * @return the variable
	 */
	public String getVariable() {
		return Variable;
	}

	public void setValue(double value) {
		this.Value = value;
	}

	public void setVariable(String variable) {
		this.Variable = variable;
	}
}