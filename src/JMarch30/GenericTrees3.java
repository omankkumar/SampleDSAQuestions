package JMarch30;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericTrees3 {

	public static class Node {
		private int data;
		private ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	public static Node construct(ArrayList<Integer> dlist) {

		Node root = null;
		ArrayList<Node> nlist = new ArrayList<>();

		for (int i = 0; i < dlist.size(); i++) {

			if (dlist.get(i) == -1) {
				nlist.remove(nlist.size() - 1);
			} else {
				Node nn = new Node(dlist.get(i));
				if (nlist.size() == 0) {
					root = nn;
				} else {
					Node lastnode = nlist.get(nlist.size() - 1);
					lastnode.children.add(nn);
				}
				nlist.add(nn);
			}
		}
		return root;
	}

	public static void Display(Node root) {

		String s = root.data + "->";
		for (int i = 0; i < root.children.size(); i++) {
			s = s + " " + root.children.get(i).data;
		}
		System.out.println(s + ".");

		for (int i = 0; i < root.children.size(); i++) {
			Display(root.children.get(i));
		}
	}

	private static class HeapMover {
		public int size = 0;
		public int ht = 0;
		public int min = Integer.MAX_VALUE;
		public int max = Integer.MIN_VALUE;
		int ceil = Integer.MAX_VALUE;
		int floor = Integer.MIN_VALUE;
	}

	public static void MultiSolver(Node node, int depth, int data, HeapMover hm) {

		hm.size++;
		hm.ht = Integer.max(hm.ht, depth);
		hm.min = Integer.min(node.data, hm.min);
		hm.max = Integer.max(node.data, hm.max);
		if (node.data >= data && node.data < hm.ceil) {
			hm.ceil = node.data;
		}
		if (node.data <= data && node.data > hm.floor) {
			hm.floor = node.data;
		}
		for (int i = 0; i < node.children.size(); i++) {
			MultiSolver(node.children.get(i), depth + 1, data, hm);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> dlist1 = new ArrayList<Integer>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80,
				110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));
		
		Node root1 = construct(dlist1);
		HeapMover hm = new HeapMover();
		MultiSolver(root1, 0, 12, hm);
		if(hm.ceil == Integer.MAX_VALUE) {
			hm.ceil = -1;
		}
		if(hm.floor == Integer.MIN_VALUE) {
			hm.floor = -1;
		}
		System.out.println(hm.size + " " + hm.ht + " " + hm.max + " " + hm.min + " " + hm.ceil + " " + hm.floor);
	}
}
