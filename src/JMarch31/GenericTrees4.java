package JMarch31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class GenericTrees4 {

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
		public int pred = 0;
		public int succ = 0;
		public int state = 0;
		public int prev = 0;
		public int curr = 0;
		public int ceil = Integer.MAX_VALUE;
		public int floor = Integer.MIN_VALUE;
	}

	// concept of state change
	public static void pred_succ(Node node, int data, HeapMover hm) {

		if (node.data == data) {
			hm.state++;
		} else if (hm.state == 1) {
			hm.succ = node.data;
			hm.state++;
		}
		if (hm.state == 0) {
			hm.pred = node.data;
		}

		for (int i = 0; i < node.children.size(); i++) {
			pred_succ(node.children.get(i), data, hm);
		}

	}

	// concept of previous and current
	public static void pred_succ2(Node node, int data, HeapMover hm) {

		hm.prev = hm.curr;
		hm.curr = node.data;
		if (hm.curr == data) {
			hm.pred = hm.prev;
		} else if (hm.prev == data) {
			hm.succ = hm.curr;
		}

		for (int i = 0; i < node.children.size(); i++) {
			pred_succ2(node.children.get(i), data, hm);
		}
	}

	public static void CeilFloor(Node node, int data, HeapMover hm) {

		if (node.data > data && node.data < hm.ceil) {
			hm.ceil = node.data;
		}
		if (node.data < data && node.data > hm.floor) {
			hm.floor = node.data;
		}

		for (int i = 0; i < node.children.size(); i++) {
			CeilFloor(node.children.get(i), data, hm);
		}
	}

	public static int KthLargest(Node node, int k) {

		int val = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			HeapMover hm = new HeapMover();
			CeilFloor(node, val, hm);
			val = hm.floor;
		}
		return val;
	}

	public static ArrayList<Integer> NodeToRootPath(Node node, int dtf) {

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
		// System.out.println(n2rpath1);
		// System.out.println(n2rpath2);
		int distance = n2rpath1.size() + n2rpath2.size() - 2 * cnt + 1;
		return distance;
	}

	public static int diameter(Node node, Node root) {
		int max = 0;
		for (int i = 0; i < node.children.size(); i++) {
			for (int j = 0; j < root.children.size(); j++) {
				int dis = Distance(root.children.get(i), node.data, root.children.get(j).data);
				max = Math.max(max, dis);
			}
			diameter(node.children.get(i), root);
		}
		return max;
	}

	public static void BFS(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() != 0) {
			Node nn = queue.removeFirst();
			System.out.print(nn.data + " ");
			for (int i = 0; i < nn.children.size(); i++) {
				queue.addLast(nn.children.get(i));
			}
		}
		System.out.println();
	}

	public static void BFSendl(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		while (queue.size() != 0) {
			Node nn = queue.removeFirst();
			if (nn == null) {
				if (queue.size() > 0) {
					queue.add(null);
					System.out.println();
					continue;
				} else {
					break;
				}
			} else {
				System.out.print(nn.data + " ");
			}
			for (int i = 0; i < nn.children.size(); i++) {
				queue.addLast(nn.children.get(i));
			}
		}
		System.out.println();
	}

	public static void BFSzigzag(Node root) {

		LinkedList<Node> stack1 = new LinkedList<>();
		LinkedList<Node> stack2 = new LinkedList<>();
		Boolean check = true;
		stack1.add(root);
		while (stack1.size() != 0 || stack2.size() != 0) {
			if (check == true) {
				Node nn = stack1.removeLast();
				for (int i = 0; i < nn.children.size(); i++) {
					stack2.addLast(nn.children.get(i));
				}
				System.out.print(nn.data + " ");
				if (stack1.size() == 0) {
					System.out.println();
					check = false;
				}
			} else {
				Node nn = stack2.removeLast();
				for (int i = nn.children.size() - 1; i >= 0; i--) {
					stack1.addLast(nn.children.get(i));
				}
				System.out.print(nn.data + " ");
				if (stack2.size() == 0) {
					System.out.println();
					check = true;
				}
			}
		}
	}

	public static void printzigzag2(Node root) {

		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);
		Boolean l2r = true;
		while (queue.size() > 0) {
			if (l2r) {
				Node nn = queue.removeFirst();
				System.out.print(nn.data + " ");
				for (int i = 0; i < nn.children.size(); i++) {
					stack.addFirst(nn.children.get(i));
				}
			} else {
				Node nn = queue.removeFirst();
				System.out.print(nn.data + " ");
				for (int i = nn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(nn.children.get(i));
				}
			}

			if (queue.size() == 0) {
				queue = stack;
				stack = new LinkedList<>();
				System.out.println();
				if (l2r) {
					l2r = false;
				} else {
					l2r = true;
				}
			}
		}
	}

	public static void PrePostRec(Node root) {

		System.out.print(root.data + "pre ");

		for (int i = 0; i < root.children.size(); i++) {
			PrePostRec(root.children.get(i));
			if (i < root.children.size() - 1) {
				System.out.print(root.data + "in" + (i + 1) + " ");
			}
		}

		System.out.print(root.data + "post ");
	}

	public static class NodeState {

		private Node node;
		private int state;

		NodeState(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static void PreInPostIterative(Node root) {

		NodeState ns = new NodeState(root, 0);
		LinkedList<NodeState> stack = new LinkedList<>();
		stack.addFirst(ns);
		while (stack.size() != 0) {
			ns = stack.getFirst();
			int cs = ns.node.children.size();
			if (ns.state == 0) {
				System.out.print(ns.node.data + "Pre ");
				ns.state++;
			} else if (ns.state >= 1 && ns.state <= cs) {
				Node child = ns.node.children.get(ns.state - 1);
				NodeState nsc = new NodeState(child, 0);
				stack.addFirst(nsc);
				if (ns.state > 1) {
					System.out.print(ns.node.data + "In" + (ns.state - 1) + " ");
				}
				ns.state++;
			} else if (ns.state == ns.node.children.size() + 1) {
				System.out.print(ns.node.data + "Post ");
				ns.state++;
			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	public static class KpcNode {
		private int ques;
		private String ans;
		private ArrayList<KpcNode> children;

		KpcNode(int ques) {
			this.ques = ques;
			this.ans = "";
			this.children = new ArrayList<>();
		}

	}

	public static void KpcIterative(int ques, String[] arr) {
		
		//Create Tree
		KpcNode root = new KpcNode(ques);
		LinkedList<KpcNode> queue = new LinkedList<>();
		queue.addLast(root);
		while (queue.size() > 0) {
			KpcNode nn = queue.removeFirst();
			int val = nn.ques;
			int sidx = nn.ques % 10;
			if (val == 0) {
				break;
			}
			String s = arr[sidx - 1];
			for (int i = 0; i < s.length(); i++) {
				KpcNode child = new KpcNode(val / 10);
				child.ans = s.charAt(i) + nn.ans;
				nn.children.add(child);
				queue.add(child);
			}
		}
		//Display Tree
		LinkedList<KpcNode> queue2 = new LinkedList<>();
		queue2.addLast(root);
		while (queue2.size() > 0) {
			KpcNode nn = queue2.removeFirst();
			for(int i = 0; i < nn.children.size(); i++) {
				queue2.addLast(nn.children.get(i));
			}
			if(nn.children.size() == 0) {
				System.out.print(nn.ans + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		ArrayList<Integer> dlist1 = new ArrayList<Integer>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80,
				110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));

		ArrayList<Integer> dlist2 = new ArrayList<Integer>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80,
				110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));

		ArrayList<Integer> dlist3 = new ArrayList<Integer>(Arrays.asList(1, 2, 5, -1, 6, -1, -1, 3, 7, -1, 8, 12, -1,
				13, -1, -1, 9, -1, -1, 4, 10, -1, 11, -1, -1, -1));

		Node root1 = construct(dlist1);
		Node root2 = construct(dlist2);
		Node root3 = construct(dlist3);
		HeapMover hm = new HeapMover();

		// pred_succ(root1, 10, hm);
		// System.out.println(hm.pred + " " + hm.succ);
//		 BFS(root1);
//		 BFSendl(root1);
//		 BFSzigzag(root1);
//		 printzigzag2(root1);

		// PrePostRec(root1);
		// PreInPostIterative(root1);

		String[] arr = { "abc", "def", "ghi", "jk", "lmno" };

		KpcIterative(543, arr);
	}

}
