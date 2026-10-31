package May29;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {

	static class Edge {
		int n;
		int wt;

		Edge(int n, int wt) {
			this.n = n;
			this.wt = wt;
		}
	}

	public static void AddEdge(ArrayList<ArrayList<Edge>> graph, int v1, int v2, int wt) {

		Edge e1 = new Edge(v2, wt);
		graph.get(v1).add(e1);

		Edge e2 = new Edge(v1, wt);
		graph.get(v2).add(e2);
	}

	public static void Display(ArrayList<ArrayList<Edge>> graph) {

		for (int v = 0; v < graph.size(); v++) {
			System.out.print(v + "-> ");
			for (int i = 0; i < graph.get(v).size(); i++) {
				Edge e = graph.get(v).get(i);
				System.out.print("[" + e.n + "@" + e.wt + "] ");
			}
			System.out.println();
		}
	}

	static class helper implements Comparable<helper> {
		int v;
		int a;
		int c;

		helper(int v, int a, int c) {
			this.v = v;
			this.a = a;
			this.c = c;
		}

		public int compareTo(helper other) {
			return this.c - other.c;
		}
	}

	public static ArrayList<ArrayList<Edge>> Prims_Algo(ArrayList<ArrayList<Edge>> graph) {

		ArrayList<ArrayList<Edge>> res_graph = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			res_graph.add(new ArrayList<>());
		}

		PriorityQueue<helper> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[graph.size()];
		helper start = new helper(0, -1, 0);

		pq.add(start);
		while (pq.size() > 0) {
			helper rem = pq.remove();
			if (visited[rem.v] == true) {
				continue;
			} else {
				visited[rem.v] = true;
			}

			if (rem.a != -1) {
				AddEdge(res_graph, rem.v, rem.a, rem.c);
			}

			for (int i = 0; i < graph.get(rem.v).size(); i++) {
				Edge e = graph.get(rem.v).get(i);
				pq.add(new helper(e.n, rem.v, e.wt));
			}
		}

		return res_graph;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		int v = 7;

		for (int i = 0; i < v; i++) {
			graph.add(new ArrayList<>());
		}

		AddEdge(graph, 0, 1, 10);
		AddEdge(graph, 0, 3, 40);
		AddEdge(graph, 1, 2, 10);
		AddEdge(graph, 2, 3, 10);
		AddEdge(graph, 3, 4, 2);
		AddEdge(graph, 4, 5, 3);
		AddEdge(graph, 4, 6, 8);
		AddEdge(graph, 5, 6, 3);

		ArrayList<ArrayList<Edge>> res = Prims_Algo(graph);
		Display(res);

	}

}
