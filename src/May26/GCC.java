package May26;

import java.util.ArrayList;
import java.util.LinkedList;

import May26.GetConnectedComponents.Edge;

public class GCC {
	
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
	
	public static String GetComponent(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited) {
		String comp = "";
		LinkedList<Integer> queue = new LinkedList<>(); 
		queue.addLast(src);
		
		while(queue.size() > 0) {
			
			//get
			int rem = queue.getFirst();
			
			//remove
			queue.removeFirst();
			
			//mark*
			if(visited[rem] == true) {
				continue;
			} else {
				visited[rem] = true;
			}
			
			//work
			comp = comp + rem;
			
			//add neighbor*
			for(int i = 0; i < graph.get(rem).size(); i++) {
				Edge e = graph.get(rem).get(i);
				if(visited[e.n] == false) {
					queue.addLast(e.n);
				}
			}
		}
		return comp;
	}
	
	public static ArrayList<String> GetConnectedComponents(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<String> res = new ArrayList<>();
		
		boolean[] visited = new boolean[graph.size()];
		for(int i = 0; i < graph.size(); i++) {
			if(visited[i] == false) {
				String compnent = GetComponent(graph, i, visited);
				res.add(compnent);
			}
		}
		
		return res;
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			ArrayList<Edge> e = new ArrayList<>();
			graph.add(e);
		}
		
		AddEdge(graph, 0, 1, 10);
		AddEdge(graph, 0, 3, 10);
		AddEdge(graph, 2, 1, 10);
		AddEdge(graph, 2, 3, 10);
		AddEdge(graph, 4, 5, 10);
		AddEdge(graph, 5, 6, 10);
		AddEdge(graph, 6, 4, 10);
		AddEdge(graph, 7, 8, 10);
		
		ArrayList<String> ans = GetConnectedComponents(graph);
		System.out.println(ans);
	}

}
