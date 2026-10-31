package May27;

import java.util.*;

public class BiPartite_Graph {
	
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
	
	static class helper {
		int node;
		int level;
		
		helper(int node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
	private static boolean IsBiPartite(ArrayList<ArrayList<Edge>> graph, int[] visited, int src) {
		
		LinkedList<helper> queue = new LinkedList<>();
		
		queue.addLast(new helper(0, 0));
		while(queue.size() > 0) {
			helper rem = queue.removeFirst();
			
			if(visited[rem.node] != -1) {
				//cycle detected, check if it has odd vertices.
				if(visited[rem.node] == rem.level % 2) {
					continue;
				} else {
					return false;
				}
			} else {
				visited[rem.node] = rem.level % 2;
			}
			
			for(int i = 0; i < graph.get(rem.node).size(); i++) {
				Edge e = graph.get(rem.node).get(i);
				if(visited[e.n] == -1) {
					queue.addLast(new helper(e.n, rem.level + 1));
				}
			}
		}
		
		return true;
	}
	
	public static boolean IsBiPartite(ArrayList<ArrayList<Edge>> graph) {
		
		int[] visited = new int[graph.size()];
		for(int i = 0; i < visited.length; i++) {
			visited[i] = -1;
		}
		
		for(int i = 0; i < graph.size(); i++) {
			if(visited[i] == -1) {
				if(IsBiPartite(graph, visited, i) == false) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		
		for(int i = 0; i < 6; i++) {
			graph.add(new ArrayList<>());
		}
		
		AddEdge(graph, 0, 1, 10);
		AddEdge(graph, 1, 2, 10);
		AddEdge(graph, 2, 3, 10);
		AddEdge(graph, 0, 3, 10);
		AddEdge(graph, 3, 4, 10);
		AddEdge(graph, 4, 5, 10);
		AddEdge(graph, 2, 5, 10);
//		AddEdge(graph, 0, 2, 10);
		
		System.out.println(IsBiPartite(graph));

	}

}
