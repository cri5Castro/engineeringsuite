package tarjan;

/**
 * Class to store a node and the appearance count of this
 * 
 * @author Pablo Salinas
 * 
 */
class NodoNameCount {
	/**
	 * The name of the node
	 */
	private int _name;
	/**
	 * Appearance count
	 */
	private int _count;

	protected NodoNameCount(int name, int count) {
		this._name = name;
		this._count = count;
	}

	protected void setName(int name) {
		this._name = name;
	}

	protected void setCount(int count) {
		this._count = count;
	}

	protected int getName() {
		return this._name;
	}

	protected int getCount() {
		return this._count;
	}

}