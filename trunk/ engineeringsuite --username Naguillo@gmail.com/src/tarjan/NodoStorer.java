package tarjan;

/**
 * This class it's only used to store Nodes, and order them to call later to the
 * Tarjan algorithm
 * 
 * @author Pablo Salinas
 * 
 */
class NodoStorer implements Comparable<NodoStorer> {
	private Node _nodo;
	private int _count;

	NodoStorer(Node Node, int Count) {
		this._nodo = Node;
		this._count = Count;
	}

	protected Node getNode() {
		return this._nodo;
	}

	protected int getCount() {
		return this._count;
	}

	protected void setNode(Node node) {
		this._nodo = node;
	}

	protected void setCount(int Count) {
		this._count = Count;
	}

	// Order from less to more
	public int compareTo(NodoStorer aux) {
		return this._count - aux.getCount();
	}
}