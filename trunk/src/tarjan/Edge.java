package tarjan;

/**
 * Stores the from a to nodes of an edge
 * 
 * @author algowiki.net. Modified by Pablo Salinas
 * 
 */
public class Edge implements Comparable<Edge> {

	final Node from, to;
	final int weight;

	public Edge(final Node argFrom, final Node argTo, final int argWeight) {
		from = argFrom;
		to = argTo;
		weight = argWeight;
	}

	public int compareTo(final Edge argEdge) {
		return weight - argEdge.weight;
	}

	public Node getFrom() {
		return this.from;
	}

	public Node getTo() {
		return this.to;
	}
}