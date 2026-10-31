package June17;

import java.util.*;
import java.util.Scanner;

public class PriorityQueueDemo {

	public static void KLargestElementsLessSpaceMoreTime(int[] arr, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (pq.peek() < arr[i]) {
				pq.remove();
				pq.add(arr[i]);
			}
		}

		for (int i = 0; i < k; i++) {
			System.out.print(pq.remove() + " ");
		}
		System.out.println();
	}

	public static void KLargestElementsMoreSpaceLessTime(int[] arr, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}

		for (int i = 0; i < k; i++) {
			System.out.print(pq.remove() + " ");
		}
		System.out.println();
	}

	public static void KSortedElement(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			pq.add(arr[i]);
			System.out.print(pq.remove() + " ");
		}

		while (pq.size() > 0) {
			System.out.print(pq.remove() + " ");
		}
	}

	public static boolean canReorder(int[] arr) {
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int key = arr[i];
			if (map.containsKey(key)) {
				int f = map.get(key);
				map.put(key, f + 1);
			} else {
				map.put(key, 1);
			}
		}

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		for (int i = 0; i < keys.size(); i++) {
			int key = keys.get(i);
			if (key == 0) {
				int f = map.get(key);
				if (f % 2 == 1) {
					return false;
				} else {
					map.remove(key);
				}
			}

			int f = map.get(key);
			int key2 = key * 2;
			if (map.get(key2) == null) {
				return false;
			}
			int f2 = map.get(key2);
			if (f2 < f) {
				return false;
			} else {
				f2 = f2 - f;
				map.remove(key);
				if (f2 == 0) {
					map.remove(key2);
				} else {
					map.put(key2, f2);
				}
			}
		}

		return true;
	}

	static class helper implements Comparable<helper> {
		int idx;
		int lidx;
		int val;

		helper(int idx, int lidx, int val) {
			this.idx = idx;
			this.lidx = lidx;
			this.val = val;
		}

		public int compareTo(helper o) {
			return this.val - o.val;
		}
	}

	public static void MergeKLists(ArrayList<ArrayList<Integer>> mat) {

		PriorityQueue<helper> pq = new PriorityQueue<>();
		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 0; i < mat.size(); i++) {
			pq.add(new helper(0, i, mat.get(i).get(0)));
		}

		while (pq.size() > 0) {
			helper rem = pq.remove();
			res.add(rem.val);

			if (rem.idx == mat.get(rem.lidx).size() - 1) {
				continue;
			} else {
				rem.idx = rem.idx + 1;
				rem.val = mat.get(rem.lidx).get(rem.idx);
				pq.add(rem);
			}
		}

		System.out.println(res);
	}

	
	static class pair implements Comparable<pair> {
		int c;
		int p;

		pair(int c, int p) {
			this.c = c;
			this.p = p;
		}

		public int compareTo(pair other) {
            return other.p - this.p;
        }
	}

	public static int findMaximizedCapital(int k, int w, int[] Profits, int[] Capital) {
		// write your code here

		pair[] arr = new pair[Capital.length];
		for (int i = 0; i < Capital.length; i++) {
			arr[i] = new pair(Capital[i], Profits[i]);
		}

		PriorityQueue<pair> pq = new PriorityQueue<>();
		Arrays.sort(arr);
		int idx = 0;
		int cnt = 0;
		while (pq.size() > 0 && k > 0) {
			while (arr[idx].c <= w) {
				pq.add(arr[idx]);
				idx++;
			}
            
            pair rem = pq.remove();
            w = w + rem.p;
            cnt++;
            pq.add(rem);
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 8, 14, 5, 6, 1, 9, 4, 20, 3, 11 };
		int k = 4;
		// KLargestElementsLessSpaceMoreTime(arr, k);

		int[] arr1 = { 2, 4, 1, 3, 5, 8, 6, 9, 7, 12, 11, 10 };
		// KSortedElement(arr1, 2);

		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
		mat.add(new ArrayList<>(Arrays.asList(2, 5, 9, 18, 20, 25)));
		mat.add(new ArrayList<>(Arrays.asList(3, 7, 8, 15, 22)));
		mat.add(new ArrayList<>(Arrays.asList(0, 4, 6, 12)));
		mat.add(new ArrayList<>(Arrays.asList(1, 10, 16, 21, 28)));

		MergeKLists(mat);
	}

}
