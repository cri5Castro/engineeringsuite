package tarjan;

import java.util.ArrayList;

/**
 * @author algowiki.net.
 */
public class Tarjan {

	private int index = 0;
	private ArrayList<Node> stack = new ArrayList<Node>();
	private ArrayList<ArrayList<Node>> SCC = new ArrayList<ArrayList<Node>>();

	public ArrayList<ArrayList<Node>> tarjan(Node v, AdjacencyList list) {
		v.index = index;
		v.lowlink = index;
		index++;
		stack.add(0, v);
		for (Edge e : list.getAdjacent(v)) {
			Node n = e.to;
			if (n.index == -1) {
				tarjan(n, list);
				v.lowlink = Math.min(v.lowlink, n.lowlink);
			} else if (stack.contains(n)) {
				v.lowlink = Math.min(v.lowlink, n.index);
			}
		}
		if (v.lowlink == v.index) {
			Node n;
			ArrayList<Node> component = new ArrayList<Node>();
			do {
				n = stack.remove(0);
				component.add(n);
			} while (n != v);
			SCC.add(component);
		}
		return SCC;
	}
}
