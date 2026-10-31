package JMarch28;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericTrees2 {

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

	public static void Mirror(Node node) {

		for (int i = 0; i < node.children.size(); i++) {
			Mirror(node.children.get(i));
		}

		for (int i = 0; i < node.children.size() / 2; i++) {
			Node temp = node.children.get(i);
			node.children.set(i, node.children.get(node.children.size() - 1 - i));
			node.children.set(node.children.size() - 1 - i, temp);
		}
	}

	public static boolean simstruct(Node root1, Node root2) {

		if (root1.children.size() != root2.children.size()) {
			return false;
		} else {
			boolean check = true;
			for (int i = 0; i < root1.children.size(); i++) {
				boolean check1 = simstruct(root1.children.get(i), root2.children.get(i));
				check1 = check1 & check;
				if (check1 == false) {
					return false;
				}
			}
			return check;
		}
	}

	public static boolean mirrorstruct(Node root1, Node root2) {

		if (root1.children.size() != root2.children.size()) {
			return false;
		} else {
			boolean check = true;
			for (int i = 0; i < root1.children.size(); i++) {
				boolean check1 = simstruct(root1.children.get(i), root2.children.get(root2.children.size() - 1 - i));
				check = check1 & check;
				if (check == false) {
					return false;
				}
			}
			return check;
		}
	}

	public static boolean symmetric(Node root) {

		boolean check = true;

		for (int i = 0; i < root.children.size() / 2; i++) {
			boolean check1 = mirrorstruct(root.children.get(i), root.children.get(root.children.size() - 1 - i));
			check = check1 & check;
			if (check == false) {
				return false;
			}
		}

		if (root.children.size() % 2 == 1) {
			boolean scheck = symmetric(root.children.get(root.children.size() / 2));
			check = check & scheck;
		}
		return check;
	}

	public static boolean symmetric2(Node root) {
		return mirrorstruct(root, root);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> dlist1 = new ArrayList<Integer>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80,
				110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));

		ArrayList<Integer> dlist2 = new ArrayList<Integer>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80,
				110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));

		ArrayList<Integer> dlist3 = new ArrayList<Integer>(Arrays.asList(1, 2, 5, -1, 6, -1, -1, 3, 7, -1, 8, 12, -1,
				13, -1, -1, 9, -1, -1, 4, 10, -1, 11, -1, -1, -1));

		Node root1 = construct(dlist1);
		Node root2 = construct(dlist2);
		Node root3 = construct(dlist3);

		System.out.println(symmetric2(root1));

	}

}
