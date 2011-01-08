package tarjan;

import java.util.ArrayList;

/**
 * This class is only to Store the result of Tarjan and to compare then to get
 * the best of them.
 * 
 * @author Pablo Salinas
 * 
 */
class PotentialRelationMatrix implements Comparable<PotentialRelationMatrix> {
	ArrayList<ArrayList<Node>> SCC;
	int ValuesDownDiagonal = 0;

	/**
	 * Stores the SCC and the count of relations down the diagonal of the
	 * Relations Matrix
	 * 
	 * @param Relations
	 * @param SCC
	 */
	PotentialRelationMatrix(ListMatrix Relations, ArrayList<ArrayList<Node>> SCC) {
		this.SCC = SCC;
		int size = Relations.size();
		int aux = 0;
		for (int row = 0; row < size; row++) {
			aux = 0;
			while (aux <= row) {
				if (Relations.getValue(row, aux) != (byte) 0)
					ValuesDownDiagonal++;
				aux++;
			}
		}
	}

	public int compareTo(PotentialRelationMatrix PRM) {
		return PRM.ValuesDownDiagonal - this.ValuesDownDiagonal;
	}
}