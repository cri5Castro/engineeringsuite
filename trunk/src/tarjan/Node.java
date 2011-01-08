package tarjan;

/**
 * Node representation with values to work with Tarjan
 * 
 * @author algowiki.net. Modified by Pablo Salinas
 * 
 */
public class Node implements Comparable<Node> {

	final int name;
	boolean visited = false; // used for Kosaraju's algorithm and Edmonds's
								// algorithm
	int lowlink = -1; // used for Tarjan's algorithm
	int index = -1; // used for Tarjan's algorithm

	public Node(final int argName) {
		name = argName;
	}

	public int compareTo(final Node argNode) {
		return argNode == this ? 0 : -1;
	}

	public int getName() {
		return this.name;
	}

	/**
	 * Return the LowLink, index and visited values to their original values
	 */
	public void restart() {
		this.lowlink = -1;
		this.index = -1;
		this.visited = false;
	}

	/**
	 * @deprecated
	 */
	public void getAll() {
		System.out
				.println("Index: " + this.index + " Lowlink: " + this.lowlink);
	}
}
