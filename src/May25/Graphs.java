package May25;

import java.util.ArrayList;

// class graph
public class Graphs {

	// defining edge of a graph, n stands for neighbor of the vertex connected
	// to that edge and wt for weight of edge
	static class Edge {
		int n;
		int wt;

		Edge(int n, int wt) {
			this.n = n;
			this.wt = wt;
		}
	}

	// add edge function adds edge between vertex v1 and v2, since it is and
	// undirected graph, if there is an edge from v1 to v2, then there is also
	// an edge from v2 to v1.
	public static void AddEdge(ArrayList<ArrayList<Edge>> graph, int v1, int v2, int wt) {

		Edge e1 = new Edge(v2, wt);
		graph.get(v1).add(e1);

		Edge e2 = new Edge(v1, wt);
		graph.get(v2).add(e2);
	}
	
	// display function to display the graph
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

	public static boolean HasPath(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited) {

		if (dest == src) {
			return true;
		}
		visited[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			if (visited[e.n] == false) {
				boolean IsPresent = HasPath(graph, e.n, dest, visited);
				if (IsPresent == true) {
					return true;
				}
			}
		}
		visited[src] = false;
		return false;
	}

	public static void PrintAllPaths(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited, String psf,
			int wsf, ArrayList<String> paths) {
		if (dest == src) {
			System.out.println(psf + " " + wsf);
			paths.add(psf + " " + wsf);
			return;
		}
		visited[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			if (visited[e.n] == false) {
				PrintAllPaths(graph, e.n, dest, visited, psf + e.n, wsf + e.wt, paths);
			}
		}
		visited[src] = false;
	}

	public static int maxwt = Integer.MIN_VALUE;
	public static int minwt = Integer.MAX_VALUE;
	public static int cpd = Integer.MIN_VALUE;
	public static int fpd = Integer.MAX_VALUE;

	public static String pathmax = "";
	public static String pathmin = "";
	public static String cp = "";
	public static String fp = "";

	public static void PrintMinWeightPath(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited,
			String psf, int wsf, int factor) {

		if (dest == src) {
			if (wsf < minwt) {
				pathmin = psf;
				minwt = wsf;
			}
			if (wsf > maxwt) {
				pathmax = psf;
				maxwt = wsf;
			}
			if (wsf >= factor && wsf < fpd) {
				fpd = wsf;
				fp = psf;
			}
			if (wsf <= factor && wsf > cpd) {
				cpd = wsf;
				cp = psf;
			}

			System.out.println(psf + " " + wsf);
			return;
		}
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			if (visited[e.n] == false) {
				visited[e.n] = true;
				PrintMinWeightPath(graph, e.n, dest, visited, psf + e.n, wsf + e.wt, factor);
				visited[e.n] = false;
			}
		}
	}

	public static void KthLargestPath(ArrayList<ArrayList<Edge>> graph, int k) {
		ArrayList<String> paths = new ArrayList<>();
		boolean[] visited = new boolean[graph.size()];
		visited[0] = true;
		for (int i = 1; i < visited.length; i++) {
			visited[i] = false;
		}
		PrintAllPaths(graph, 0, 6, visited, "0", 0, paths);
		System.out.println("---------------");
		System.out.println(paths.get(paths.size() - k - 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		int vertices = 7;
		for (int i = 0; i < vertices; i++) {
			ArrayList<Edge> e = new ArrayList<>();
			graph.add(e);
		}

		AddEdge(graph, 0, 1, 10);
		AddEdge(graph, 1, 2, 10);
		AddEdge(graph, 2, 3, 10);
		AddEdge(graph, 0, 3, 40);
		AddEdge(graph, 3, 4, 2);
		AddEdge(graph, 4, 5, 3);
		AddEdge(graph, 4, 6, 8);
		AddEdge(graph, 5, 6, 3);

		// Display(graph);

		boolean[] visited = new boolean[graph.size()];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		KthLargestPath(graph, 3);
		// System.out.println(HasPath(graph, 0, 6, visited));
		// visited[0] = true;
		// int ceil = 46;
		// int floor = 46;
		// PrintMinWeightPath(graph, 0, 6, visited, "0", 0, 46);
		// System.out.println("----------------------");
		// System.out.println(pathmax + " " + maxwt);
		// System.out.println(pathmin + " " + minwt);
		// System.out.println(cp + " " + cpd);
		// System.out.println(fp + " " + fpd);
	}

}
