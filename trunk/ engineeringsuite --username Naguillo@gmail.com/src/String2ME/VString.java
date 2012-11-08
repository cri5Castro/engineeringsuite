package String2ME;

/**
 * This class store a variable and the times it appears
 * 
 * @author Pablo Salinas
 * 
 */
public class VString implements Comparable<VString> {
	/**
	 * The variable
	 */
	private String _cadena;
	/**
	 * The count appearance
	 */
	private int _n;

	public VString(String in) {
		_cadena = in;
		_n = 1;
	}

	/**
	 * Adds one to the counter of the variable
	 */
	public void CountUp() {
		_n++;
	}

	/**
	 * Subtract one of the counter of the variable
	 */
	public void CountDown() {
		_n--;
	}

	/**
	 * 
	 * @return The counter of the variable
	 */
	public int getCount() {
		return _n;
	}

	public void setCount(int count) {
		this._n = count;
	}

	/**
	 * 
	 * @return The string of the variable
	 */
	public String getVar() {
		return _cadena;
	}

	/*
	 * public int compareTo(VString aux) { return this._n - aux.getCount(); }
	 */

	public int compareTo(VString aux) {
		return this._cadena.charAt(0) - aux._cadena.charAt(0);
	}

	/**
	 * Add a quantity to the counter of the variable
	 * 
	 * @param i
	 */
	public void addCount(int i) {
		this._n = i + this._n;
	}

}