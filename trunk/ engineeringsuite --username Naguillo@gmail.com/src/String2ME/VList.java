package String2ME;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A list to store a variable and count the times it appears
 * 
 * @author Pablo Salinas
 * 
 */
public class VList {

	public List<VString> Variables = new ArrayList<VString>();

	/**
	 * At first we check if the variable is already in the List if is in the
	 * List the we will count one if not we well add it
	 * 
	 * @param cadena
	 */
	public void AddVar(String cadena) {
		boolean IsInIt = false;
		Iterator<VString> it = Variables.listIterator();
		VString aux;
		// We search for it
		while ((it.hasNext()) & (!IsInIt)) {
			aux = it.next();
			if (aux.getVar().equals(cadena)) {
				IsInIt = true;
				aux.CountUp();
			}
		}
		if (!IsInIt) {
			aux = new VString(cadena);
			Variables.add(aux);
		}
	}

	/**
	 * This method subtract one count of the count variable of a variable if
	 * this count reach the zero then the variable will be erase
	 * 
	 * @param cadena
	 * @return boolean. If the variable is not in the List then returns false
	 */
	public boolean Erase(String cadena) {
		boolean IsInIt = false;
		Iterator<VString> it = Variables.listIterator();
		VString aux;
		// We search for it
		while ((it.hasNext()) & (!IsInIt)) {
			aux = it.next(); // Maybe NullPointerException Error
			if (aux.getVar().equals(cadena)) {
				IsInIt = true;
				aux.CountDown();
				if (aux.getCount() == 0) {
					it.remove();
				}
			}
		}

		return IsInIt;
	}

	/**
	 * 
	 * @param i
	 * @return The variable at the i position
	 */
	public String getVar(int i) {
		return Variables.get(i).getVar();

	}

	/**
	 * 
	 * @param i
	 * @return the times a variable appears
	 */
	public int getCount(int i) {
		return Variables.get(i).getCount();
	}

	/**
	 * 
	 * @param String
	 *            , the variable
	 * @return the times that that variable appears
	 */
	public int getCount(String cadena) {
		boolean IsInIt = false;
		Iterator<VString> it = Variables.listIterator();
		VString aux;
		while ((it.hasNext()) & (!IsInIt)) {
			aux = it.next();
			if (aux.getVar().equals(cadena)) {
				IsInIt = true;
				return aux.getCount();
			}
		}

		return -1;

	}

	/**
	 * 
	 * @return the size of the List
	 */
	public int getSize() {
		return Variables.size();
	}

	public void addCountVar(String cadena, int counts) {
		boolean IsInIt = false;
		Iterator<VString> it = Variables.listIterator();
		VString aux;
		// We search for it
		while ((it.hasNext()) & (!IsInIt)) {
			aux = it.next();
			if (aux.getVar().equals(cadena)) {
				IsInIt = true;
				aux.addCount(counts);
			}
		}
		if (!IsInIt) {
			aux = new VString(cadena);
			Variables.add(aux);
			aux.addCount(counts - 1);
		}
	}

	/**
	 * This method eliminate one variable and it's count
	 * 
	 * @param cadena
	 */
	public void Exterminate(String cadena) {

		boolean IsInIt = false;
		Iterator<VString> it = Variables.listIterator();
		VString aux;
		int i = 0;
		// We search for it
		while ((it.hasNext()) & (!IsInIt)) {
			aux = it.next();
			i++;
			if (aux.getVar().equalsIgnoreCase(cadena)) {
				IsInIt = true;
				it.remove();
			}

		}
	}

}