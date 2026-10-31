package June01;

import java.util.ArrayList;

public class Bridges_And_Articulation_Points {
	
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
	
	static int timer = 0;
	public static void BaAPs(ArrayList<ArrayList<Edge>> graph, boolean[] visited, int[] disc, int[] low, 
			ArrayList<Integer> aps, int par, int src) {
		
		visited[src] = true;
		disc[src] = ++timer;
		low[src] = ++timer;
		int counter = 0;
		
		for(int i = 0; i < graph.get(src).size(); i++) {
			Edge e = graph.get(src).get(i);
			int nbr = e.n;
			
			if(visited[nbr] == true && nbr == par) {
				
				continue;
			} else if(visited[nbr] == true && nbr != par) {
				
				low[src] = Math.min(low[src], disc[nbr]);
			} else {
				counter++;
				BaAPs(graph, visited, disc, low, aps, src, nbr);
				low[src] = Math.min(low[src], low[nbr]);
				if(disc[src] == 1) {
					if(counter == 2) {
						aps.add(src);
					}
				} else {
					if(low[nbr] >= disc[src]) {
						aps.add(src);
					}
				}
				
				if(low[nbr] > disc[src]) {
					System.out.println("Bridge between " + src + " and " + nbr);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		int vertices = 9;
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
		AddEdge(graph, 0, 8, 3);
		AddEdge(graph, 0, 7, 8);
		AddEdge(graph, 8, 7, 3);
		
		boolean[] visited = new boolean[graph.size()];
		int[] disc = new int[graph.size()];
		int[] low = new int[graph.size()];
		ArrayList<Integer> aps = new ArrayList<>();
		timer = 0;
		BaAPs(graph, visited, disc, low, aps, -1, 0);
		System.out.println(aps);
	}

}
