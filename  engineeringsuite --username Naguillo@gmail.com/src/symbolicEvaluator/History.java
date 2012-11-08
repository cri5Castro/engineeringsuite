package symbolicEvaluator;

import java.util.LinkedList;

/**
 * 
 * A list to store the history of commands introduced in the symbolic evaluator;
 * Maximun storage is 100.
 * 
 * @author pablo Salinas
 * 
 */
public class History {
	/**
	 * Maximum storage
	 */
	private static final byte storage = 100;
	private static LinkedList<String> history = new LinkedList<String>();

	/**
	 * This is a LIFO, Last In First Out, List
	 * 
	 * @return The string at the size-1-i position of the List
	 */
	public static String GetText(int i) {
		try {
			return history.get(history.size() - 1 - i);
		} catch (Exception e) {
			return "";
		}
	}

	public static int GetSize() {
		return history.size();
	}

	/**
	 * 
	 * @param Inserts
	 *            a string in the List. If the List is bigger than the storage
	 *            maximum then an element will be removed.
	 */
	public static void Insert(String cadena) {
		history.add(cadena);
		if (history.size() > storage) {
			history.removeFirst();
		}
	}

}