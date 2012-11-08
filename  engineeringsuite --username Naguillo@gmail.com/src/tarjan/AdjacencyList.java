package tarjan;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Collection;

/**
 * Is the representation of a matrix in a List
 * 
 * @author algowiki.net. Modified by Pablo Salinas
 * 
 */
public class AdjacencyList {

	private Map<Node, ArrayList<Edge>> adjacencies = new HashMap<Node, ArrayList<Edge>>();

	public void addEdge(Node source, Node target, int weight) {
		ArrayList<Edge> list;
		if (!adjacencies.containsKey(source)) {
			list = new ArrayList<Edge>();
			adjacencies.put(source, list);
		} else {
			list = adjacencies.get(source);
		}
		list.add(new Edge(source, target, weight));
	}

	public ArrayList<Edge> getAdjacent(Node source) {
		return adjacencies.get(source);
	}

	public void reverseEdge(Edge e) {
		adjacencies.get(e.from).remove(e);
		addEdge(e.to, e.from, e.weight);
	}

	public void reverseGraph() {
		adjacencies = getReversedList().adjacencies;
	}

	public AdjacencyList getReversedList() {
		AdjacencyList newlist = new AdjacencyList();
		for (ArrayList<Edge> edges : adjacencies.values()) {
			for (Edge e : edges) {
				newlist.addEdge(e.to, e.from, e.weight);
			}
		}
		return newlist;
	}

	public Set<Node> getSourceNodeSet() {
		return adjacencies.keySet();
	}

	public Collection<Edge> getAllEdges() {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (List<Edge> e : adjacencies.values()) {
			edges.addAll(e);
		}
		return edges;
	}

	/**
	 * 
	 * @param name
	 * @return a node with that name. If there are more than one node with that
	 *         name, then this will return the first it found.
	 * @deprecated
	 */
	public Node getNode(int name) {
		Iterator<ArrayList<Edge>> it = adjacencies.values().iterator();
		Node aux;
		while (it.hasNext()) {
			Iterator<Edge> it2 = it.next().listIterator();
			while (it2.hasNext()) {
				aux = it2.next().getFrom();
				if (aux.getName() == name)
					return aux;
			}

		}
		// if not found, i return the first node
		it = adjacencies.values().iterator();
		Iterator<Edge> it2 = it.next().listIterator();
		return it2.next().getFrom();
	}

	/**
	 * @deprecated
	 * @param name
	 */
	public void eraseNode(int name) {
		Iterator<ArrayList<Edge>> it = adjacencies.values().iterator();
		Node aux;
		while (it.hasNext()) {
			Iterator<Edge> it2 = it.next().listIterator();
			while (it2.hasNext()) {
				aux = it2.next().getFrom();
				if (aux.getName() == name)
					it2.remove();
			}
		}
	}

	/**
	 * Restart all the nodes to their initial values
	 */
	public void RestartNodes() {
		Iterator<ArrayList<Edge>> it = adjacencies.values().iterator();
		Edge aux;
		while (it.hasNext()) {
			Iterator<Edge> it2 = it.next().listIterator();
			while (it2.hasNext()) {
				aux = it2.next();
				aux.getFrom().restart();
				aux.getTo().restart();
			}

		}
	}

}
