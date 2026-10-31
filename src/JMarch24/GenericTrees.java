package JMarch24;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericTrees {

	private static class Node {
		public int data;
		public ArrayList<Node> children;

		// without constructor data would be 0 and children variable, which is
		// created in stack would contain null, after constructor, data would
		// have give value, and new ArrayList would be created in heap and its
		// address would be present in stack.
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

	public static int getsize(Node node) {

		int size = 1;
		for (int i = 0; i < node.children.size(); i++) {
			size = size + getsize(node.children.get(i));
		}
		return size;

	}

	public static int getmax(Node node) {

		int max = node.data;
		for (int i = 0; i < node.children.size(); i++) {
			int temp = getmax(node.children.get(i));
			max = Math.max(max, temp);
		}
		max = Math.max(max, node.data);
		return max;
	}

	public static int getheight(Node node) {

		int height = 0;
		for (int i = 0; i < node.children.size(); i++) {
			int temp = getheight(node.children.get(i));
			height = Math.max(height, temp);
		}
		height = height + 1;
		return height;
	}

	public static boolean find(Node node, int dtf) {

		if (node.children.size() == 0) {
			if (node.data == dtf) {
				return true;
			} else {
				return false;
			}
		}

		if (node.data == dtf) {
			return true;
		}
		boolean check = false;
		for (int i = 0; i < node.children.size(); i++) {
			check = find(node.children.get(i), dtf);
			if (check == true) {
				return true;
			}
		}
		return check;
	}

	public static ArrayList<Integer> NodeToRootPath(Node node, int dtf) {

		// ArrayList<Integer> pun = new ArrayList<>();
		// for (int i = 0; i < node.children.size(); i++) {
		// pun = NodeToRootPath(node.children.get(i), dtf);
		// if (pun.size() != 0) {
		// pun.add(node.data);
		// break;
		// }
		// if(node.children.get(i).data == dtf) {
		// pun.add(dtf);
		// pun.add(node.data);
		// break;
		// }
		// }
		// return pun;

		if (node.data == dtf) {
			ArrayList<Integer> bl = new ArrayList<>();
			bl.add(node.data);
			return bl;
		}
		ArrayList<Integer> pun = new ArrayList<>();
		for (int i = 0; i < node.children.size(); i++) {
			pun = NodeToRootPath(node.children.get(i), dtf);
			if (pun.size() != 0) {
				pun.add(node.data);
				return pun;
			}
		}
		return pun;
	}

	public static int lca(Node node, int d1, int d2) {

		ArrayList<Integer> n2rpath1 = new ArrayList<>();
		ArrayList<Integer> n2rpath2 = new ArrayList<>();
		n2rpath1 = NodeToRootPath(node, d1);
		n2rpath2 = NodeToRootPath(node, d2);
		int cnt = 0;
		for (int i = n2rpath1.size() - 1, j = n2rpath2.size() - 1; i >= 0 && j >= 0; i--, j--) {
			if (n2rpath1.get(i) != n2rpath2.get(j)) {
				break;
			}
			cnt++;
		}
		System.out.println(n2rpath1);
		System.out.println(n2rpath2);
		int val = n2rpath1.get(n2rpath1.size() - cnt);
		return val;
	}

	public static int Distance(Node node, int d1, int d2) {

		ArrayList<Integer> n2rpath1 = new ArrayList<>();
		ArrayList<Integer> n2rpath2 = new ArrayList<>();
		n2rpath1 = NodeToRootPath(node, d1);
		n2rpath2 = NodeToRootPath(node, d2);
		int cnt = 0;
		for (int i = n2rpath1.size() - 1, j = n2rpath2.size() - 1; i >= 0 && j >= 0; i--, j--) {
			if (n2rpath1.get(i) != n2rpath2.get(j)) {
				break;
			}
			cnt++;
		}
		System.out.println(n2rpath1);
		System.out.println(n2rpath2);
		int distance = n2rpath1.size() + n2rpath2.size() - 2 * cnt + 1;
		return distance;
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

	public static void RemoveLeaves(Node node) {
		// note that remove function takes O(n) time, hence we create a new
		// ArrayList, add valid nodes/children, and equate it with current
		// children
		ArrayList<Node> newchildren = new ArrayList<>();
		for (int i = 0; i < node.children.size(); i++) {
			Node child = node.children.get(i);
			if (child.children.size() != 0) {
				newchildren.add(child);
				RemoveLeaves(child);
			}
		}
		node.children = newchildren;
	}

	// Linearise O(n^2)

	public static void Linearise(Node node) {

		for (int i = 0; i < node.children.size(); i++) {
			Linearise(node.children.get(i));
		}

		for (int i = 0; i < node.children.size(); i++) {
			Node ln = node.children.get(i);
			while (ln.children.size() != 0) {
				ln = ln.children.get(0);
			}
			if (i + 1 < node.children.size()) {
				ln.children.add(node.children.get(i + 1));
				node.children.remove(i + 1);
				i--;
			}
		}
	}

	//Linearise O(n)
	public static Node Linearise2(Node root) {

		if (root.children.size() == 0) {
			return root;
		}

		Node tail = null;
		for (int i = 0; i < root.children.size(); i++) {

			Node ln = Linearise2(root.children.get(i));

			if (i + 1 < root.children.size()) {
				ln.children.add(root.children.get(i + 1));
			}
			if (i == root.children.size() - 1) {
				tail = ln;
			}
		}
		for (int i = 1; i < root.children.size(); i++) {
			root.children.remove(i);
			i--;
		}
		return tail;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> dlist = new ArrayList<Integer>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110,
				-1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));

		Node root = construct(dlist);

		// Display(root);
		// int size = getsize(root);
		// System.out.println(size);
		// int max = getmax(root);
		// System.out.println(max);
		// int height = getheight(root);
		// System.out.println(height);
		// boolean check = find(root, 10);
		// System.out.println(check);
		//
		// System.out.println(NodeToRootPath(root, 10));

		// System.out.println(lca(root, 70, 120));

		// System.out.println(Distance(root, 70, 120));
		//
		// Display(root);
		// Mirror(root);
		// System.out.println("----------------");
		// Display(root);
		// Display(root);
		// RemoveLeaves(root);
		// System.out.println("----------------");
		// Display(root);

		Display(root);
		System.out.println("-------------");
		Linearise2(root);
		Display(root);
	}

}
