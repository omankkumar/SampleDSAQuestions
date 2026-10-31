package April06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree3 {

	public static class Node {
		public int data;
		public Node left;
		public Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node constructor(int[] arr) {
		Node root = new Node(arr[0]);

		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(root);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != -1) {
				Node nn = new Node(arr[i]);
				Node top = stack.getFirst();
				if (top.left == null) {
					top.left = nn;
				} else {
					top.right = nn;
				}
				stack.addFirst(nn);
			} else {
				stack.removeFirst();
			}
		}
		return root;
	}

	public static void Display(Node root) {

		if (root == null) {
			return;
		}

		Node left = root.left;
		Node right = root.right;
		// print
		if (left == null && right == null) {
			System.out.println("  .-> " + root.data + " <-.");
			return;
		} else if (right == null) {
			System.out.println(left.data + " -> " + root.data + " <-.");
			Display(left);
		} else if (left == null) {
			System.out.println("  .-> " + root.data + " <- " + right.data);
			Display(right);
		} else {
			System.out.println(left.data + " -> " + root.data + " <- " + right.data);
			Display(left);
			Display(right);
		}
	}

	public static Node construct1(int[] pre, int[] in, int plo, int phi, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}

		Node root = new Node(pre[plo]);
		int foundAt = findidx(in, pre[plo]);

		root.left = construct1(pre, in, plo + 1, plo + (foundAt - ilo), ilo, foundAt - 1);
		root.right = construct1(pre, in, plo + (foundAt - ilo) + 1, phi, foundAt + 1, ihi);

		return root;
	}

	public static int findidx(int[] arr, int data) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == data) {
				return i;
			}
		}
		return -1;
	}

	public static Node construct2(int[] post, int[] in, int plo, int phi, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}

		Node root = new Node(post[phi]);

		int lhs = 0;
		while (in[ilo + lhs] != post[phi]) {
			lhs++;
		}

		root.left = construct2(post, in, plo, plo + lhs - 1, ilo, ilo + lhs - 1);
		root.right = construct2(post, in, plo + lhs, phi - 1, ilo + lhs + 1, ihi);

		return root;
	}

	public static Node construct3(int[] ca, int[] pa) {
		Node root = new Node(0);
		Node[] arr = new Node[101];
		for (int i = 0; i < ca.length; i++) {
			Node nn = new Node(ca[i]);
			arr[ca[i]] = nn;
		}

		for (int i = 0; i < pa.length; i++) {
			int child = ca[i];
			int parent = pa[i];

			if (parent == -1) {
				root = arr[child];
			} else {
				if (arr[parent].left == null) {
					arr[parent].left = arr[child];
				} else {
					arr[parent].right = arr[child];
				}
			}

		}
		return root;
	}

	public static Node construct4(int[] pre, int[] post, int prlo, int prhi, int polo, int pohi) {

		if (prlo == prhi) {
			Node nn = new Node(pre[prlo]);
			return nn;
		}

		Node root = new Node(pre[prlo]);
		int lhs = 0;
		while (post[polo + lhs] != pre[prlo + 1]) {
			lhs++;
		}

		root.left = construct4(pre, post, prlo + 1, prlo + lhs + 1, polo, polo + lhs);
		root.right = construct4(pre, post, prlo + lhs + 2, prhi, polo + lhs + 1, pohi - 1);

		return root;
	}

	public static int diameter(Node root, heapmover hm) {

		if (root == null) {
			return 0;
		}

		int htl = diameter(root.left, hm);
		int htr = diameter(root.right, hm);

		int dia = htl + htr + 1;
		if (dia > hm.dia) {
			hm.dia = dia;
		}

		return (Math.max(htl, htr) + 1);

	}

	public static heapmover IsBalanced(Node root) {

		if (root == null) {
			heapmover hm = new heapmover();
			hm.ht = 0;
			hm.gap = 0;
			hm.check = true;
			return hm;
		}

		heapmover left = IsBalanced(root.left);
		if (left.check == false) {
			return left;
		}
		heapmover right = IsBalanced(root.right);
		if (right.check == false) {
			return right;
		}

		heapmover mp = new heapmover();
		mp.ht = Math.max(left.ht, right.ht) + 1;
		mp.gap = Math.abs(left.ht - right.ht);
		if (mp.gap > 1) {
			mp.check = false;
		} else {
			mp.check = true;
		}
		return mp;
	}

	public static heapmover IsBST(Node root) {

		if (root == null) {
			heapmover bc = new heapmover();
			bc.check = true;
			return bc;
		}

		heapmover left = IsBST(root.left);
		if (left.check == false) {
			return left;
		}
		heapmover right = IsBST(root.right);
		if (right.check == false) {
			return right;
		}

		heapmover mp = new heapmover();
		if (left.max > root.data) {
			mp.check = false;
			return mp;
		} else if (right.min < root.data) {
			mp.check = false;
			return mp;
		} else {
			mp.max = Math.max(root.data, Math.max(left.max, right.max));
			mp.min = Math.min(root.data, Math.min(left.min, right.min));
			return mp;
		}
	}

	public static class heapmover {
		int dia = Integer.MIN_VALUE;
		int ht = 0;
		int gap = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int size = 0;
		Node root = null;
		boolean check = true;
	}

	public static heapmover LargestBST(Node root) {

		if (root == null) {
			heapmover bc = new heapmover();
			bc.check = true;
			return bc;
		}

		heapmover left = LargestBST(root.left);
		heapmover right = LargestBST(root.right);

		heapmover myset = new heapmover();

		if (left.check == false || right.check == false || root.data < left.max || root.data > right.min) {
			if (left.size > right.size) {
				myset = left;
			} else {
				myset = right;
			}
			myset.check = false;
		} else {
			myset.max = Math.max(root.data, Math.max(left.max, right.max));
			myset.min = Math.min(root.data, Math.min(left.min, right.min));
			myset.size = left.size + right.size + 1;
			myset.root = root;
			myset.check = true;
		}
		return myset;
	}

	public static ArrayList<Integer> lo = new ArrayList<>(Arrays.asList(50, 25, 75, 12, 37, 62, 87, 10, 30, 40, 90));

	public static Node In_Level(int[] in, int ilo, int inhi) {
		
		Node root = new Node(lo.get(0));
		int rootidx = -1;
		for(int i = ilo; i <= ihi; i++) {
			if(in[i] == root.data) {
				rootidx = i;
				break;
			}
		}
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 50, 25, 12, -1, 37, 24, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };

		int[] pre = { 50, 25, 12, 37, 30, 40, 75, 62, 60, 70, 87, 90 };
		int[] in = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87, 90 };
		int[] post = { 12, 40, 37, 25, 62, 87, 75, 50, };

		int[] ca = { 12, 25, 50, 75, 37, 80, 40, 87 };
		int[] pa = { 25, 50, -1, 50, 25, 87, 37, 75 };

		int[] pre4 = { 50, 25, 12, 37, 30, 40, 75, 62, 87 };
		int[] post4 = { 12, 30, 40, 37, 25, 62, 87, 75, 50 };

		heapmover hm = new heapmover();
		Node root = construct1(pre, in, 0, pre.length - 1, 0, in.length - 1);

		root = constructor(arr);
		Display(root);
//		hm = LargestBST(root);
//		System.out.println(hm.root.data);
//		System.out.println(hm.size);
//		Display(hm.root);
	}

}
