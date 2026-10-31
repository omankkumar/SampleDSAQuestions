package June01;

import java.util.*;

public class Topological_Sort {

	static class Edge {
		int n;
		int wt;

		Edge(int n, int wt) {
			this.n = n;
			this.wt = wt;
		}
	}

	private static void TS(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited, Stack<Integer> st) {

		visited[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			if (visited[e.n] == false) {
				TS(graph, e.n, visited, st);
			}
		}
		st.push(src);
	}

	public static void TS(ArrayList<ArrayList<Edge>> graph) {

		boolean[] visited = new boolean[graph.size()];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				TS(graph, i, visited, st);
			}
		}
		System.out.println(st);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		int v = 7;
		for (int i = 0; i < v; i++) {
			graph.add(new ArrayList<>());
		}

		graph.get(0).add(new Edge(1, 10));
		graph.get(4).add(new Edge(0, 10));
		graph.get(1).add(new Edge(2, 10));
		graph.get(2).add(new Edge(3, 10));
		graph.get(5).add(new Edge(4, 10));
		graph.get(5).add(new Edge(6, 10));
		graph.get(6).add(new Edge(3, 10));

		TS(graph);
	}

}
