package April03;

import java.util.ArrayList;
import java.util.LinkedList;

import December20.print_all_bits;

public class BinaryTree2 {

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

	public static boolean find(Node root, int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		}
		boolean fl = find(root.left, data);
		if (fl == true) {
			return true;
		}
		boolean fr = find(root.right, data);
		if (fr == true) {
			return true;
		}
		return false;
	}

	public static ArrayList<Integer> n2rp(Node root, int data) {

		if (root == null) {
			return null;
		}
		if (root.data == data) {
			ArrayList<Integer> bl = new ArrayList<>();
			bl.add(root.data);
			return bl;
		}
		ArrayList<Integer> fl = n2rp(root.left, data);
		if (fl != null) {
			fl.add(root.data);
			return fl;
		}
		ArrayList<Integer> fr = n2rp(root.right, data);
		if (fr != null) {
			fr.add(root.data);
			return fr;
		}
		return null;
	}

	public static void KDown(Node root, int k) {
		if (k == 0 && root != null) {
			System.out.println(root.data);
			return;
		}
		if (root == null) {
			return;
		}
		KDown(root.left, k - 1);
		KDown(root.right, k - 1);
	}

	public static ArrayList<Node> n2rp2(Node root, int data) {
		if (root == null) {
			ArrayList<Node> bl = new ArrayList<>();
			return bl;
		}
		if (root.data == data) {
			ArrayList<Node> bl = new ArrayList<>();
			bl.add(root);
			return bl;
		}
		ArrayList<Node> fl = n2rp2(root.left, data);
		if (fl.size() != 0) {
			fl.add(root);
			return fl;
		}
		ArrayList<Node> fr = n2rp2(root.right, data);
		if (fr.size() != 0) {
			fr.add(root);
			return fr;
		}
		return (new ArrayList<Node>());
	}

	public static void KDown2(Node root, Node phbt, int k) {
		if (root == null || root == phbt) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		KDown2(root.left, phbt, k - 1);
		KDown2(root.right, phbt, k - 1);
	}

	public static void KFar(Node root, int data, int k) {

		ArrayList<Node> n2rp = n2rp2(root, data);
		System.out.println(n2rp.size() + "---------");

		for (int i = 0; i <= k && i < n2rp.size(); i++) {
			KDown2(n2rp.get(i), i == 0 ? null : n2rp.get(i - 1), k - i);
		}
	}

	public static void RemoveLeaves(Node root) {

		if (root.left == null && root.right == null) {
			return;
		} else if (root.right == null) {
			Node child = root.left;
			if (child.left == null && child.right == null) {
				root.left = null;
			} else {
				RemoveLeaves(child);
			}
		} else if (root.left == null) {
			Node child = root.right;
			if (child.left == null && child.right == null) {
				root.right = null;
			} else {
				RemoveLeaves(child);
			}
		} else {
			Node child = root.left;
			if (child.left == null && child.right == null) {
				root.left = null;
			} else {
				RemoveLeaves(child);
			}

			child = root.right;
			if (child.left == null && child.right == null) {
				root.right = null;
			} else {
				RemoveLeaves(child);
			}
		}
	}

	public static void PrintSingleChild(Node root) {
		if (root == null) {
			return;
		} else if (root.left == null && root.right != null) {
			System.out.println(root.right.data);
			PrintSingleChild(root.right);
		} else if (root.left != null && root.right == null) {
			System.out.println(root.left.data);
			PrintSingleChild(root.left);
		} else {
			PrintSingleChild(root.left);
			PrintSingleChild(root.right);
		}
	}

	public static void PrintPathToLeavesInRange(Node root, int low, int high, ArrayList<Integer> psf, int sum) {

		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			psf.add(root.data);
			sum = sum + root.data;
			if (sum >= low && sum <= high) {
				System.out.println(psf);
			}
			psf.remove(psf.size() - 1);
			return;
		}
		psf.add(root.data);
		PrintPathToLeavesInRange(root.left, low, high, psf, sum + root.data);
		PrintPathToLeavesInRange(root.right, low, high, psf, sum + root.data);
		psf.remove(psf.size() - 1);
	}

	public static void ToDuplicate(Node root) {

		if (root == null) {
			return;
		}

		Node nn = new Node(root.data);
		Node rl = root.left;
		root.left = nn;
		nn.left = rl;

		ToDuplicate(nn.left);
		ToDuplicate(root.right);

	}

	public static void FromDuplicate(Node root) {

		if (root == null) {
			return;
		}

		root.left = root.left.left;
		FromDuplicate(root.left);
		FromDuplicate(root.right);

	}

	public static Node ToLinkedList(Node root, char check) {

		if(root.left.left == null && root.right.right != null) {
			root.right = root;
			return root.left;
		}
		
		if(root.right.right == null && root.left.left != null) {
			root.left = root;
			return root.right;
		} 
		
		if(root.left.left == null && root.right.right == null) {
			root.left.right = root;
			root.right.left = root;
			if(check == 'l') {
				return root.right;
			} else {
				return root.left;
			}
		}
		
		Node ForLeft = ToLinkedList(root.left, 'l');
		Node ForRight = ToLinkedList(root.right, 'r');
		
		root.left = ForLeft;
		root.right = ForRight;
		
		ForRight.left = root;
		ForLeft.right = root;
		
		Node rn = root;
		if(check == 'l') {
			while(rn.right != null) {
				rn = rn.right;
			}
		} else {
			while(rn.left != null) {
				rn = rn.left;
			}
		}
		
		return rn;
	}

	public static void DisplayLL(Node root) {

		while (root != null) {
			System.out.print(root.data + " ");
			root = root.right;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
		int[] tree = { 1, 2, 4, 6, -1, 7, -1, -1, 5, 8, 10, 13, 17, -1, 18, -1, -1, 14, -1, -1, 11, 15, 19, 22, -1, 23,
				-1, -1, 20, -1, -1, 16, 21, -1, -1, -1, -1, 9, 12, -1, -1, -1, -1, 3, -1, -1 };
		Node root1 = constructor(tree);
		Node root = constructor(arr);
		Node ans = ToLinkedList(root, 'r');
		DisplayLL(ans);
	}

}
