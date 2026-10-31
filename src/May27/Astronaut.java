package May27;

import java.util.ArrayList;
import java.util.LinkedList;

public class Astronaut {
	
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
	
	public static int getComponents (int src, ArrayList<ArrayList<Edge>> graph, boolean[] visited) {
		
		int cnt = 1;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(src);
		
		while(queue.size() > 0) {
			int rem = queue.removeFirst();
			
			if(visited[rem] == true) {
				continue;
			} else {
				visited[rem] = true;
			}
			
			for(int i = 0; i < graph.get(rem).size(); i++) {
				Edge e = graph.get(rem).get(i);
				if(visited[e.n] == false) {
					queue.addLast(e.n);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static int FindWays(int[] arr1, int[] arr2, int verticies) {
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i = 0; i < verticies; i++) {
			ArrayList<Edge> al = new ArrayList<>();
			graph.add(al);
		}
		
		for(int i = 0; i < arr1.length; i++) {
			AddEdge(graph, arr1[i], arr2[i], 10);
		}
		
		boolean[] visited = new boolean[graph.size()];
		ArrayList<Integer> people = new ArrayList<>();
		
		for(int i = 0; i < graph.size(); i++) {
			if(visited[i] == false) {
				int men = getComponents(i, graph, visited);
				people.add(men);
			}
		}
		
		int ways = 0;
		
		for(int i = 0; i < people.size(); i++) {
			for(int j = i + 1; j < people.size(); j++) {
				ways = ways + (people.get(i) * people.get(j));
			}
		}
		System.out.println(people);
		return ways;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {1,6,8,2,9,10,0};
		int[] arr2 = {2,9,3,5,5,3,11};
		int verticies = 12;
		System.out.println(FindWays(arr1, arr2, verticies));

	}

}
