package May29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

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
		int node;
		int dsf;
		String psf;

		helper(int node, int dsf, String psf) {
			this.node = node;
			this.dsf = dsf;
			this.psf = psf;
		}

		public int compareTo(helper other) {
			return this.dsf - other.dsf;
		}

	}

	static class sorter implements Comparator<String> {

		public int compare(String a, String b) {
			return a.length() - b.length();
		}
	}

	public static void Dijkstra_Algo(ArrayList<ArrayList<Edge>> graph, int src) {

		PriorityQueue<helper> pq = new PriorityQueue<>();

		helper start = new helper(src, 0, "" + src);
		boolean[] visited = new boolean[graph.size()];

		pq.add(start);

		while (pq.size() > 0) {
			// Get and Remove
			helper rem = pq.remove();

			// Mark*
			if (visited[rem.node] == true) {
				continue;
			} else {
				visited[rem.node] = true;
			}

			// Work
			System.out.println(rem.node + " via " + rem.psf + " @ " + rem.dsf);

			// Add The Children*
			for (int i = 0; i < graph.get(rem.node).size(); i++) {
				Edge e = graph.get(rem.node).get(i);
				helper h = new helper(e.n, rem.dsf + e.wt, rem.psf + e.n);
				pq.add(h);
			}
		}

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

		Dijkstra_Algo(graph, 0);

		String[] arr = { "", "abc", "a", "ab", "abcd" };

		Arrays.sort(arr, new sorter());

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
