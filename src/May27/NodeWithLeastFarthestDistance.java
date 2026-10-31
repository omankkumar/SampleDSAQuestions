package May27;

import java.util.*;

public class NodeWithLeastFarthestDistance {

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
		int dsf;
		String psf;

		helper(int node, int level, int dsf, String psf) {
			this.node = node;
			this.level = level;
			this.dsf = dsf;
			this.psf = psf;
		}
	}

	public static helper FindEnd(int src, ArrayList<ArrayList<Edge>> graph) {

		LinkedList<helper> queue = new LinkedList<>();
		queue.addLast(new helper(src, 0, 0, src + ""));
		boolean[] visited = new boolean[graph.size()];
		int max = 0;

		helper last = new helper(src, 0, 0, src + "");
		while (queue.size() > 0) {

			helper rem = queue.removeFirst();

			if (visited[rem.node] == true) {
				continue;
			} else {
				visited[rem.node] = true;
			}

			for (int i = 0; i < graph.get(rem.node).size(); i++) {
				Edge e = graph.get(rem.node).get(i);
				queue.add(new helper(e.n, rem.level + 1, rem.dsf + 1, rem.psf + "," + e.n));
			}
			if (rem.level > max) {
				last = rem;
				max = rem.level;
			}
		}
		//System.out.println(last.node + " " + last.level + " " + last.dsf + " " + last.psf);
		return last;
	}
	
	public static void FindCenter(ArrayList<ArrayList<Edge>> graph) {
		
		helper Fend = FindEnd(0, graph);
		helper Send = FindEnd(Fend.node, graph);
		
		System.out.println(Fend.node + " " + Fend.level + " " + Fend.dsf + " ->" + Fend.psf);
		System.out.println(Send.node + " " + Send.level + " " + Send.dsf + " ->" + Send.psf);
		
		String str = Send.psf;
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ',') {
				cnt++;
			}
		}
		
		int count = cnt/2;
		int i = 0;
		String ans = "";
		while(count != 0) {
			if(str.charAt(i) == ',') {
				count--;
			}
			if(count == 0) {
				i++;
				while(str.charAt(i) != ',') {
					ans = ans + str.charAt(i);
					i++;
				}
			}
			i++;
		}
		
		int res = 0;
		i = 0;
		while(i < ans.length()) {
			res = res*10 + (ans.charAt(i) - '0');
			i++;
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		
		for(int i = 0; i < 23; i++) {
			graph.add(new ArrayList<>());
		}
		
		AddEdge(graph, 0, 1, 10);
		AddEdge(graph, 1, 2, 10);
		AddEdge(graph, 1, 3, 10);
		AddEdge(graph, 3, 4, 10);
		AddEdge(graph, 4, 5, 10);
		AddEdge(graph, 4, 6, 10);
		AddEdge(graph, 6, 7, 10);
		AddEdge(graph, 7, 8, 10);
		AddEdge(graph, 7, 9, 10);
		AddEdge(graph, 3, 10, 10);
		AddEdge(graph, 10, 22, 10);
		AddEdge(graph, 22, 11, 10);
		AddEdge(graph, 11, 12, 10);
		AddEdge(graph, 12, 13, 10);
		AddEdge(graph, 12, 14, 10);
		AddEdge(graph, 12, 15, 10);
		AddEdge(graph, 15, 16, 10);
		AddEdge(graph, 16, 21, 10);
		AddEdge(graph, 16, 17, 10);
		AddEdge(graph, 21, 18, 10);
		AddEdge(graph, 18, 19, 10);
		AddEdge(graph, 18, 20, 10);
		
		FindCenter(graph);
	}

}
