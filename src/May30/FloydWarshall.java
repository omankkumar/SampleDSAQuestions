package May30;

import java.util.ArrayList;

public class FloydWarshall {
	
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
	
	public static void fw(ArrayList<ArrayList<Edge>> graph) {
		
		int[][] res = new int[graph.size()][graph.size()];
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[0].length; j++) {
				if(i == j) {
					res[i][j] = 0;
				} else {
					res[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		for(int i = 0; i < graph.size(); i++) {
			for(int j = 0; j < graph.get(i).size(); j++) {
				res[i][graph.get(i).get(j).n] = graph.get(i).get(j).wt;
			}
		}
		
		for(int i = 0; i < graph.size(); i++) {
			for(int s = 0; s < graph.size(); s++) {
				for(int d = 0; d < graph.size(); d++) {
					if(s == i || d == i || s == d) {
						continue;
					} else if(res[s][i] == Integer.MAX_VALUE || res[i][d] == Integer.MAX_VALUE) {
						continue;
					} else {
						if(res[s][i] + res[i][d] < res[s][d]) {
							res[s][d] = res[s][i] + res[i][d];
						}
					}
				}
			}
		}
		
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + "	");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			graph.add(new ArrayList<>());
		}
		graph.get(0).add(new Edge(1, 2));
		graph.get(0).add(new Edge(2, 4));
		graph.get(0).add(new Edge(3, 8));
		
		graph.get(1).add(new Edge(2, 1));
		graph.get(1).add(new Edge(3, 5));
		
		graph.get(2).add(new Edge(3, 1));
		Display(graph);
		fw(graph);
	}

}
