package June01;

import java.util.*;

public class BellmanFordAlgorithm {
	
	static class Edge {
		int n;
		int wt;

		Edge(int n, int wt) {
			this.n = n;
			this.wt = wt;
		}
	}

	static class KEdge {
		int v1;
		int v2;
		int wt;

		KEdge(int v1, int v2, int wt) {
			this.v1 = v1;
			this.v2 = v2;
			this.wt = wt;
		}
	}

	public static void BF(ArrayList<ArrayList<Edge>> graph, int src) {

		ArrayList<KEdge> arr = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				Edge e = graph.get(i).get(j);
				arr.add(new KEdge(i, e.n, e.wt));
			}
		}

		int[] res = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			if (i == src) {
				res[i] = 0;
			} else {
				res[i] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < graph.size() - 1; i++) {
			for (int j = 0; j < arr.size(); j++) {
				KEdge ke = arr.get(j);
				int u = ke.v1;
				int v = ke.v2;
				int s = src;
				int uv = ke.wt;
				if (res[u] == Integer.MAX_VALUE) {
					continue;
				}
				if (res[u] + uv < res[v]) {
					res[v] = res[u] + uv;
				}
			}
		}
		
		for (int j = 0; j < arr.size(); j++) {
			KEdge ke = arr.get(j);
			int u = ke.v1;
			int v = ke.v2;
			int s = src;
			int uv = ke.wt;
			if (res[u] == Integer.MAX_VALUE) {
				continue;
			}
			if (res[u] + uv < res[v]) {
				System.out.println("Negetive Cycle Exists");
				return;
			}
		}

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		int v = 4;
		for (int i = 0; i < v; i++) {
			graph.add(new ArrayList<>());
		}

		graph.get(0).add(new Edge( 1, 2));
		graph.get(0).add(new Edge( 3, 9));
		graph.get(1).add(new Edge( 2, 4));
		graph.get(2).add(new Edge( 0, -15));
		graph.get(2).add(new Edge( 3, 1));

		ArrayList<ArrayList<Edge>> graph2 = new ArrayList<>();
		int v2 = 4;
		for (int i = 0; i < v2; i++) {
			graph2.add(new ArrayList<>());
		}

		graph2.get(0).add(new Edge(1, 2));
		graph2.get(0).add(new Edge(2, 4));
		graph2.get(0).add(new Edge(3, 8));

		graph2.get(1).add(new Edge(2, 1));
		graph2.get(1).add(new Edge(3, 5));

		graph2.get(2).add(new Edge(3, 1));
		int src = 0;
		BF(graph, src);
	}

}
