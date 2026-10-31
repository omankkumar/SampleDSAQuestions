package May27;

import java.util.*;

public class DetermineCycleInGraph {
	
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

//		Edge e2 = new Edge(v1, wt);
//		graph.get(v2).add(e2);
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
	
	private static boolean FindCycle (int src ,ArrayList<ArrayList<Edge>> graph, boolean[] visited) {
		
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(src);
		
		while(queue.size() > 0) {
			int rem = queue.removeFirst();
			
			if(visited[rem] == true) {
				return true;
			} else {
				visited[rem] = true;
			}
			
			for(int i = 0; i < graph.get(rem).size(); i++) {
				Edge e = graph.get(rem).get(i);
				if(visited[e.n] == false) {
					queue.addLast(e.n);
				}
			}
		}
		return false;
	}
		
	public static boolean CheckCycle(ArrayList<ArrayList<Edge>> graph) {
		
		boolean[] visited = new boolean[graph.size()];
		
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == false) {
				boolean check = FindCycle(i,graph, visited);
				if(check == true) {
					return true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		int vertices = 4;
		for (int i = 0; i < vertices; i++) {
			ArrayList<Edge> e = new ArrayList<>();
			graph.add(e);
		}
		
//		AddEdge(graph, 0, 1, 10);
//		AddEdge(graph, 1, 2, 10);
//		AddEdge(graph, 2, 3, 10);
//		//AddEdge(graph, 0, 3, 40);
//		AddEdge(graph, 3, 4, 2);
//		AddEdge(graph, 4, 5, 3);
//		AddEdge(graph, 4, 6, 8);
//		//AddEdge(graph, 5, 6, 3);
		
		AddEdge(graph, 0, 1, 1);
		AddEdge(graph, 1, 2, 1);
		AddEdge(graph, 2, 3, 1);
		AddEdge(graph, 3, 0, 1);
		
		System.out.println(CheckCycle(graph));
	}

}
