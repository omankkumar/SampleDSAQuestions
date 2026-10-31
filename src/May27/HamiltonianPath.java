package May27;

import java.util.*;

public class HamiltonianPath {
	
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
	
	public static void getPath(ArrayList<ArrayList<Edge>> graph, boolean[] visited, ArrayList<Integer> path, int src, int node) {
		if(path.size() == graph.size() - 1) {
			path.add(node);
			for(int i = 0; i < graph.get(src).size(); i++) {
				if(graph.get(src).get(i).n == node) {
					path.add(-1);
					System.out.println(path);
					path.remove(path.size() - 1);
					path.remove(path.size() - 1);
					return;
				}
			}
			path.add(-2);
			System.out.println(path);
			path.remove(path.size() - 1);
			path.remove(path.size() - 1);
			return;
		}
		
		visited[node] = true;
		path.add(node);
		
		for(int i = 0; i < graph.get(node).size(); i++) {
			Edge e = graph.get(node).get(i);
			if(visited[e.n] == false) {
				getPath(graph, visited, path, src, e.n);
			}
		}
		
		path.remove(path.size() - 1);
		visited[node] = false;
	}
	
	public static void PrintHamiltonianPath(ArrayList<ArrayList<Edge>> graph) {
		
		for(int i = 0; i < graph.size(); i++) {
			ArrayList<Integer> path = new ArrayList<>();
			boolean[] visited = new boolean[graph.size()];
			getPath(graph, visited, path, i, i);
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
		AddEdge(graph, 2, 5, 10);
		
		PrintHamiltonianPath(graph);

	}

}
