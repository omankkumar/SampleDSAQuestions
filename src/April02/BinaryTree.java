package April02;

import java.util.*;

public class BinaryTree {

	public static class Node {
		public int data;
		public Node left;
		public Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node construct(int[] arr) {
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
			System.out.println(".-> " + root.data + " <-.");
			return;
		} else if (right == null) {
			System.out.println(left.data + " -> " + root.data + " <-.");
			Display(left);
		} else if (left == null) {
			System.out.println(".-> " + root.data + " <- " + right.data);
			Display(right);
		} else {
			System.out.println(left.data + " -> " + root.data + " <- " + right.data);
			Display(left);
			Display(right);
		}
	}

	public static int size(Node root) {
		int ls = 0, rs = 0;
		if (root.left != null) {
			ls = size(root.left);
		}
		if (root.right != null) {
			rs = size(root.right);
		}

		return ls + rs + 1;
	}

	public static int sum(Node node) {
		int ls = 0, rs = 0;
		if (node.left != null) {
			ls = sum(node.left);
		}
		if (node.right != null) {
			rs = sum(node.right);
		}

		return ls + rs + node.data;
	}

	public static int max(Node node) {

		int ls = Integer.MIN_VALUE, rs = Integer.MIN_VALUE;
		if (node.left != null) {
			ls = max(node.left);
		}
		if (node.right != null) {
			rs = max(node.right);
		}

		return Math.max(node.data, Math.max(ls, rs));
	}

	public static int height(Node node) {

		int lh = 0;
		int rh = 0;

		if (node.left != null) {
			lh = height(node.left);
		}
		if (node.right != null) {
			rh = height(node.right);
		}

		int ht = Math.max(lh, rh) + 1;
		return ht;
	}
	
	public static Node construct(int[] arr, int sp, int ep) {
        
        if(sp > ep) {
            return null;
        }
        
        int idx = findmax(arr, sp, ep);
        Node root = new Node(idx);
        
        Node lt = construct(arr, sp, idx - 1);
        Node rt = construct(arr, idx + 1, ep);
        
        root.left = lt;
        root.right = rt;
        
        return root;
    }
	
	public static int findmax(int[] arr, int sp, int ep) {
        int max = arr[sp];
        int idx = sp;
        for(int i = sp; i <= ep; i++) {
            if(arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    } 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
		Node root = construct(arr);
		Display(root);
		System.out.println(size(root));
		System.out.println(sum(root));
		System.out.println(max(root));
		System.out.println(height(root));
		
//		Display(root);
	}

}
