package May26;

import java.util.*;

public class Graphs2 {

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

	static class Thelper {
		int v;
		String psf;
		int dsf;

		Thelper(int v, String psf, int dsf) {
			this.v = v;
			this.psf = psf;
			this.dsf = dsf;
		}
	}

	public static boolean bfs(ArrayList<ArrayList<Edge>> graph, int src, int dst) {

		LinkedList<Thelper> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.size()];

		Thelper first = new Thelper(src, "" + src, 0);
		queue.addLast(first);
		while(queue.size() > 0) {
			
			Thelper rem = queue.getFirst();
			queue.removeFirst();
			
			System.out.println(rem.v + " via " + rem.psf + " @ " + rem.dsf);
			
			if(visited[rem.v] == true) {
				continue;
			} else {
				visited[rem.v] = true;
			}
			
			if(rem.v == dst) {
				return true;
			}
			
			for(int n = 0; n < graph.get(rem.v).size(); n++) {
				
				Edge ne = graph.get(rem.v).get(n);
				if(visited[ne.n] == false) {
					Thelper th = new Thelper(ne.n, rem.psf + ne.n, rem.dsf + ne.wt);
					queue.add(th);
				}
			}
		}
		return false;
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
		
		System.out.println(bfs(graph, 0, 6));

	}

}
