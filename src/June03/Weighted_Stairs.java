package June03;

import java.util.*;

public class Weighted_Stairs {

	public static int getways(int[] arr) {

		int[] ways = new int[arr.length];
		ways[ways.length - 1] = 1;
		for (int i = ways.length - 2; i >= 0; i--) {
			int way = 0;
			for (int j = 1; j <= arr[i]; j++) {
				if ((i + j) < ways.length) {
					way = way + ways[i + j];
				}
			}
			ways[i] = way;
		}
		Display(ways);
		return ways[0];

	}

	public static Integer[] MinSteps(int[] arr) {

		Integer[] steps = new Integer[arr.length];
		steps[steps.length - 1] = 0;
		for (int i = steps.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= arr[i]; j++) {
				if ((i + j) < steps.length) {
					if (steps[i + j] == null) {
						continue;
					} else if (steps[i + j] < min) {
						min = steps[i + j];
					}
				}
			}
			if (min == Integer.MAX_VALUE) {
				steps[i] = null;
			} else {
				steps[i] = min + 1;
			}
		}

		for (int i = 0; i < steps.length; i++) {
			System.out.print(steps[i] + " ");
		}
		System.out.println();

		return steps;
	}

	static class helper {
		int node;
		String psf;

		helper(int node, String psf) {
			this.node = node;
			this.psf = psf;
		}
	}

	public static void PrintAllPaths(int[] arr) {
		int src = 0;
		int dest = arr.length - 1;
		helper start = new helper(src, "");
		LinkedList<helper> queue = new LinkedList<>();
		queue.addLast(start);

		while (queue.size() > 0) {
			helper rem = queue.removeFirst();

			if (rem.node == dest) {
				System.out.println(rem.psf + dest);
			}

			for (int i = 1; i <= arr[rem.node]; i++) {
				if (rem.node + i < arr.length) {
					helper h = new helper(rem.node + i, rem.psf + rem.node);
					queue.addLast(h);
				}
			}
		}
	}

	public static void PrintMinPath(int[] arr, Integer[] steps) {
		int src = 0;
		int dest = arr.length - 1;
		helper start = new helper(src, "");
		LinkedList<helper> queue = new LinkedList<>();
		queue.addLast(start);
		while(queue.size() > 0) {
			helper rem = queue.removeFirst();
			
			if(rem.node == dest) {
				System.out.println(rem.psf + dest);
			}
			
			for(int i = 1; i <= arr[rem.node]; i++) {
				if(rem.node + i < arr.length) {
					if(steps[rem.node + i] != null && steps[rem.node + i] == steps[rem.node] - 1) {
						helper h = new helper(rem.node + i, rem.psf + rem.node);
						queue.addLast(h);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 2, 0, 2, 0, 2, 3, 2, 0 };
		Display(arr);
//		System.out.println(getways(arr));
		Integer[] steps = MinSteps(arr);
//		PrintAllPaths(arr);
		PrintMinPath(arr, steps);
	}

	public static void Display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
