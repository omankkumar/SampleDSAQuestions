package May29;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Krushkal {

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

	static class KEdge implements Comparable<KEdge> {

		int v1;
		int v2;
		int wt;

		KEdge(int v1, int v2, int wt) {
			this.v1 = v1;
			this.v2 = v2;
			this.wt = wt;
		}

		public int compareTo(KEdge other) {
			return this.wt - other.wt;
		}
	}

	public static int findsl(int[] pa, int v) {

//		while (true) {
//			if (pa[v] == v) {
//				return v;
//			} else {
//				v = pa[v];
//			}
//		}
		
		if (pa[v] == v) {
			return v;
		} else {
			v = pa[v];
			return findsl(pa, v);
		}
	}

	public static void merge(int[] pa, int[] ra, int v1sl, int v2sl) {
		if (ra[v1sl] < ra[v2sl]) {
			pa[v1sl] = v2sl;
		} else if (ra[v1sl] > ra[v2sl]) {
			pa[v2sl] = v1sl;
		} else {
			pa[v1sl] = v2sl;
			ra[v2sl]++;
		}
	}

	public static ArrayList<ArrayList<Edge>> MST(ArrayList<ArrayList<Edge>> graph) {

		ArrayList<ArrayList<Edge>> res = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			res.add(new ArrayList<>());
		}

		int[] pa = new int[graph.size()];
		int[] ra = new int[graph.size()];

		for (int i = 0; i < pa.length; i++) {
			pa[i] = i;
			ra[i] = 1;
		}

		PriorityQueue<KEdge> pq = new PriorityQueue<>();
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				Edge e = graph.get(i).get(j);
				if (i < e.n) {
					KEdge ke = new KEdge(i, e.n, e.wt);
					pq.add(ke);
				}
			}
		}

		int cnt = 0;
		while (pq.size() > 0 && cnt < graph.size() - 1) {

			KEdge rem = pq.remove();

			int v1sl = findsl(pa, rem.v1);
			int v2sl = findsl(pa, rem.v2);

			if (v1sl != v2sl) {
				AddEdge(res, rem.v1, rem.v2, rem.wt);
				cnt++;
				merge(pa, ra, v1sl, v2sl);
			}
		}

		return res;
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
		Display(graph);
		System.out.println("----------------------------");
		ArrayList<ArrayList<Edge>> res = MST(graph);
		Display(res);
		
	}

}
