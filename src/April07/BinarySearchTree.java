package April07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;

public class BinarySearchTree {

	public static class Node {
		public int data;
		public Node left;
		public Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node constructor(int[] arr, int st, int end) {

		if (st > end) {
			return null;
		}

		int idx = (st + end) / 2;
		Node root = new Node(arr[idx]);

		Node left = constructor(arr, st, idx - 1);
		Node right = constructor(arr, idx + 1, end);

		root.left = left;
		root.right = right;

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

	public static int min(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.data;
	}

	public static int max(Node root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.data;
	}

	public static boolean find(Node root, int val) {

		while (root != null) {
			if (root.data == val) {
				return true;
			} else if (root.data > val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return false;
	}

	public static void PrintInRange(Node root, int lo, int hi) {

		if (root == null) {
			return;
		}
		if (root.data >= lo && root.data <= hi) {
			System.out.print(root.data + " ");
			PrintInRange(root.left, lo, hi);
			PrintInRange(root.right, lo, hi);
		}
		if (root.data > hi) { // agar hi se bada hai toh left mein jao
			PrintInRange(root.left, lo, hi);
		}
		if (root.data < lo) { // agar lo se chota hai to right mein jao
			PrintInRange(root.right, lo, hi);
		}
	}

	public static int rwSumOfLarge(Node root, int sum) {

		if (root == null) {
			return sum;
		}

		sum = rwSumOfLarge(root.right, sum);

		int rdata = root.data;
		root.data = sum;

		sum = rwSumOfLarge(root.left, sum + rdata);
		return sum;
	}

	public static class GSUM {
		int sum = 0;
	}

	public static void rwSumOfLarge2(Node root, GSUM gsum) {
		if (root == null) {
			return;
		}

		rwSumOfLarge2(root.right, gsum);

		int rdata = root.data;
		root.data = gsum.sum;
		gsum.sum = gsum.sum + rdata;

		rwSumOfLarge2(root.left, gsum);

	}

	public static void PairSum(Node node, Node root, int tar) {
		if (node == null) {
			return;
		}
		int num1 = node.data;
		int num2 = tar - num1;
		if (num1 < num2 && find(root, num2)) {
			System.out.println(num1 + " " + num2);
		}
		PairSum(node.left, root, tar);
		PairSum(node.right, root, tar);
	}

	private static void PairSumSpace(Node root, ArrayList<Integer> arr) {
		if (root == null) {
			return;
		}
		PairSumSpace(root.left, arr);
		arr.add(root.data);
		PairSumSpace(root.right, arr);
	}

	public static void PairSumSpace(Node root, int tar) {
		ArrayList<Integer> arr = new ArrayList<>();
		PairSumSpace(root, arr);
		int lo = 0;
		int hi = arr.size() - 1;
		while (lo < hi) {
			int num1 = arr.get(lo);
			int num2 = arr.get(hi);
			int sum = arr.get(lo) + arr.get(hi);
			if (sum == tar) {
				System.out.println(num1 + " " + num2);
				lo++;
				hi--;
			} else if (sum > tar) {
				hi--;
			} else {
				lo++;
			}
		}
	}

	public static class NodeState {
		Node node;
		int state;

		NodeState(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static void InOrderEularBST(Node root) {

		LinkedList<NodeState> stack = new LinkedList<>();
		NodeState nn = new NodeState(root, 0);
		stack.addFirst(nn);
		while(stack.isEmpty() == false) {
			NodeState top = stack.getFirst();
			if(top.state == 0) {
				if(top.node.left != null) {
					nn = new NodeState(top.node.left, 0);
					stack.addFirst(nn);
				}
				top.state++;
			} else if(top.state == 1) {
				System.out.print(top.node.data + " ");
				top.state++;
			} else if(top.state == 2) {
				if(top.node.right != null) {
					nn = new NodeState(top.node.right, 0);
					stack.addFirst(nn);
				}
				top.state++;
			} else {
				stack.removeFirst();
			}
		}
	}
	
	public static void PairSumLessSpace(Node root) {
		LinkedList<NodeState> leftstack = new LinkedList<>();
		LinkedList<NodeState> rightstack = new LinkedList<>();
		NodeState nn = new NodeState(root, 0);
		leftstack.addFirst(nn);
		rightstack.addFirst(nn);
		
		boolean moveleft = false;
		boolean moveright = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 12, 25, 37, 50, 62, 75, 87 };
		int[] arr1 = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };
		int[] arr2 = { 10, 20, 30, 50, 60, 70, 80 };
		Node root = constructor(arr, 0, arr.length - 1);
		Node root1 = constructor(arr1, 0, arr1.length - 1);
		Node root2 = constructor(arr2, 0, arr2.length - 1);
//		InOrderEularBST(root);
		rwSumOfLarge2(root1, new GSUM());
		Display(root1);
	}

}
