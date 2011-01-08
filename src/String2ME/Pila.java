package String2ME;

import java.util.*;

/**
 * This Class is to convert parenthesis into clasps because in matheclipse
 * functions like sin must be followed by a clasp
 * 
 * @author Pablo Salinas
 * 
 */
class Pila {// The list is a list of bytes, the meanings are: 0=Is a parenthesis
	// 1=Is a clasp but is not a trigonometric function or we are working with
	// radians
	// 2=Is a clasp and is a trigonometric function and we are working with
	// degrees so ")" must be add
	/**
	 * The list is a list of bytes, the meanings are: 0=Is a parenthesis 1=Is a
	 * clasp but is not a trigonometric function or we are working with radians
	 * 2=Is a clasp and is a trigonometric function and we are working with
	 * degrees so ")" must be add
	 */
	private static List<Byte> Pila = new LinkedList<Byte>();

	protected static void ErasePila() {
		ListIterator<Byte> it = Pila.listIterator();
		while (it.hasNext()) {
			Pila.remove(it.next());
		}
	}

	/**
	 * Add a byte to the stack
	 * 
	 * @param c
	 */
	public void AddTerm(byte c) {
		Pila.add(c);
	}

	/**
	 * Returns the value and erase it from the stack
	 * 
	 * @return a byte
	 */
	public byte GetTerm() {
		byte aux = Pila.get(Pila.size() - 1).byteValue();
		Pila.remove(Pila.size() - 1);
		return aux;
	}

	/**
	 * 
	 * @return the size of the stack
	 */
	public int GetSize() {
		return Pila.size() - 1;
	}

}