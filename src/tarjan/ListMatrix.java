package tarjan;

import gui.Config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Relation matrix. Is a matrix to represent with byte the relation between
 * functions and variables.
 * 
 * @author Pablo Salinas
 * 
 */
class ListMatrix {
	private ArrayList<ArrayList<Byte>> _NodeMatrix;
	final static byte cero = (byte) 0;
	final static byte dos = (byte) 2;

	/**
	 * Creates an empty matrix
	 * 
	 * @param col
	 */
	protected ListMatrix(int col) {
		_NodeMatrix = new ArrayList<ArrayList<Byte>>();
		ArrayList<Byte> aux = new ArrayList<Byte>();
		for (int k = 0; k < col; k++)
			aux.add(new Byte(cero));
		for (int i = 0; i < col; i++)
			this._NodeMatrix.add(new ArrayList<Byte>(aux));
	}

	/**
	 * 
	 * @param row
	 * @param col
	 * @return the value at that position
	 */
	protected byte getValue(int row, int col) {
		return _NodeMatrix.get(row).get(col).byteValue();
	}

	/**
	 * Change the value at the specified position
	 * 
	 * @param row
	 * @param col
	 * @param value
	 */
	protected void setValue(int row, int col, byte value) {
		ArrayList<Byte> aux = this._NodeMatrix.get(row);
		aux.set(col, Byte.valueOf(value));

		this._NodeMatrix.set(row, aux);

	}

	/**
	 * Erase the specified row and column
	 * 
	 * @param row
	 */
	protected void eraseRowCol(int rowcol) {
		this._NodeMatrix.remove(rowcol);

		for (ArrayList<Byte> nodes : this._NodeMatrix)
			nodes.remove(rowcol);
	}

	/**
	 * @return true if all the values in the diagonal are true
	 */
	protected boolean checkDiagonal() {
		for (int i = 0; i < this._NodeMatrix.size(); i++)
			if (getValue(i, i) == cero)
				return false;

		return true;

	}

	/**
	 * Clear the list
	 */
	protected void purge() {
		this._NodeMatrix.clear();
	}

	public String toString() {
		String salida = new String();
		for (ArrayList<Byte> nodes : _NodeMatrix) {
			for (Byte node : nodes)
				salida += node.toString() + " ";

			salida += Config.JumpLine;
		}
		return salida;
	}

	/**
	 * 
	 * @param row
	 * @return The number of variables in that row
	 */
	protected static int numberVariables(ArrayList<Byte> row) {
		int n = 0;
		for (Byte b : row)
			if (b != cero)
				n++;

		return n;
	}

	/**
	 * 
	 * @param Lista
	 * @param row
	 * @return A LinkedList updated with the position of the variables
	 */
	protected static LinkedList<Integer> AnalizeRow(LinkedList<Integer> Lista,
			ArrayList<Byte> row) {
		int i = 0;
		boolean found;
		for (Byte bol : row) {
			found = false;
			if (bol != cero) {
				for (Integer k : Lista)
					if (k.intValue() == i)
						found = true;

				if (!found)
					Lista.add(i);
			}
			i++;
		}

		return Lista;
	}

	/**
	 * 
	 * @param Row
	 * @return The number of variables in that row
	 */
	protected int numberVariable(int Row) {
		ArrayList<Byte> row = this._NodeMatrix.get(Row);
		return numberVariables(row);
	}

	/**
	 * 
	 * @param row1
	 * @param row2
	 * @return Returns the subtraction of row1 and row2; 0 = no relation; 1 =
	 *         relation ; 2 = that variable has been found in more than one
	 *         function 0 + 0 -> 0 ; 0 + 1 -> 1; 1 + 0 -> 1; 1 + 1-> 2 ; 2 + x
	 *         -> 2
	 * 
	 */
	protected ArrayList<Byte> OperateRow(ArrayList<Byte> row1,
			ArrayList<Byte> row2) {
		Iterator<Byte> it1 = row1.listIterator();
		Iterator<Byte> it2 = row2.listIterator();
		ArrayList<Byte> result = new ArrayList<Byte>();
		byte aux = cero;
		while (it1.hasNext()) {
			aux = (byte) (it1.next().byteValue() + it2.next().byteValue());

			if (aux > dos)
				aux = dos;

			result.add(aux);
		}
		return result;
	}

	/**
	 * 
	 * @return Number of rows
	 */
	public int size() {
		return this._NodeMatrix.size();
	}

	/**
	 * Erase all the rows and columns of the ListMatrix that are in the input
	 * list;
	 * 
	 * @param rows
	 */
	protected void refresh(LinkedList<Integer> Lista) {

		Collections.sort(Lista);// Order the list into ascending order
		ListIterator<Integer> it = Lista.listIterator(Lista.size());
		while (it.hasPrevious())
			this.eraseRowCol(it.previous());
	}

	protected ArrayList<Byte> getRow(int row) {
		return this._NodeMatrix.get(row);
	}

}