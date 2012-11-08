package String2ME;

/**
 * This class is to return the type of the error and the character that makes
 * the error in the CheckString method
 * 
 * @author Pablo Salinas
 * 
 */
public class GramErr {
	/**
	 * The type of error. 0 if there are no errors. 1 if there is a illegal
	 * character error. 2 if there is a syntaxes general error. 3 If there are
	 * two operators followed. 4 If there is a dot or comma after a letter. 5 If
	 * there is not an equal sign 6 If there are more open parenthesis than
	 * close parenthesis or vice versa 7 If a special function is empty 8 If
	 * behind a number is a variable and not an operator 9 If an operator is at
	 * the end of the line or does not have a number or a variable behind 10 if
	 * a variable contains something different from a letter, number or _
	 */
	private byte _TypeError;
	/**
	 * The character that has provoke the error
	 */
	private char _caracter;
	/**
	 * The string that has provoke the error
	 */
	private String _cadena;

	/**
	 * 
	 * @param i
	 *            kind of error
	 * @param C
	 *            the conflictive char
	 */
	public GramErr(byte i, char C) {
		this._TypeError = i;
		this._caracter = C;
	}

	/**
	 * 
	 * @param i
	 *            kind of error
	 */
	public GramErr(byte i) {
		this._TypeError = i;
	}

	public GramErr(byte i, String s) {
		this._TypeError = i;
		this._cadena = s;
	}

	/**
	 * 
	 * @return byte, kind error
	 */
	public byte GetTypeError() {
		return _TypeError;
	}

	/**
	 * 
	 * @return char, conflictive character
	 */
	public char GetCaracter() {
		return _caracter;
	}

	public String getString() {
		return this._cadena;
	}

}