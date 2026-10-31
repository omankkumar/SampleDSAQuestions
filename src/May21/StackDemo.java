package May21;

import java.util.*;

public class StackDemo {

	public static void PrintSmallestNumber(String str) {
		Stack<Integer> st = new Stack<>();
		int num = 1;
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			st.push(num);
			if (str.charAt(i) == 'i') {
				while (st.size() > 0) {
					ans = ans + st.pop();
				}
			}
			num++;
		}
		st.push(num);
		while (st.size() > 0) {
			ans = ans + st.pop();
		}
		System.out.println(ans);
	}

	public static void NGE_Rev(int[] arr) {

		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			while (st.size() > 0 && st.peek() < arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(arr[i]);
		}

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}

	public static void NGE(int[] arr) {

		Stack<Integer> st = new Stack<>();
		st.push(0);
		int[] ans = new int[arr.length];
		for (int i = 1; i < arr.length; i++) {
			if (arr[st.peek()] > arr[i]) {
				st.push(i);
			} else {
				while (st.size() > 0 && arr[i] > arr[st.peek()]) {
					ans[st.pop()] = arr[i];
				}
				st.push(i);
			}
		}

		while (st.size() > 0) {
			ans[st.pop()] = -1;
		}

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}

	public static int[] rb(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				ans[i] = arr.length;
			} else {
				ans[i] = st.peek();
			}
			st.push(i);
		}

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();

		return ans;
	}

	public static int[] lb(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}
			st.push(i);
		}

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();

		return ans;
	}

	public static void MaxAreaOfHistogram(int[] heights) {

		int[] lb_array = lb(heights);
		int[] rb_array = rb(heights);
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			int temp = (rb_array[i] - lb_array[i] - 1) * heights[i];
			if (temp > max) {
				max = temp;
			}
		}
		System.out.println(max);
	}

	public static void SlidingWindow(int[] arr, int k) {

		int[] nge = new int[arr.length];
		Stack<Integer> st = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] < arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				nge[i] = arr.length;
			} else {
				nge[i] = st.peek();
			}
			st.push(i);
		}

		int[] res = new int[arr.length - k + 1];
		int j = 0;
		for (int i = 0; i < arr.length - k + 1; i++) {
			if (j < i) {
				j = i;
			}
			while (nge[j] < i + k) {
				j = nge[j];
			}

			res[i] = j;
		}

		for (int i = 0; i < res.length; i++) {
			System.out.print(arr[res[i]] + " ");
		}
		System.out.println();
	}

	public static void RedundantParanthesis(String s) {

		Stack<Character> st = new Stack<>();
		boolean check = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')') {
				st.push(s.charAt(i));
			} else {
				int count = 0;
				while (st.peek() != '(') {
					st.pop();
					count++;
				}
				st.pop();
				count++;
				if (count == 1) {
					check = true;
					break;
				}
			}
		}
		System.out.println(check);
	}

	public static int FindCelebrity(boolean[][] data) {
		int l = 0;
		int r = data.length - 1;

		while (l != r) {
			if (data[l][r] == true) {
				l++;
			} else {
				r--;
			}
		}

		for (int i = 0; i < data.length; i++) {
			if (data[l][i] == true) {
				return -1;
			}
			if (data[i][r] == false && i != l) {
				return -1;
			}
		}

		return l;
	}

	static class buncher implements Comparable<buncher> {
		public int st = 0;
		public int end = 0;

		buncher(int st, int end) {
			this.st = st;
			this.end = end;
		}

		@Override
		public int compareTo(buncher o) {
			return this.st - o.st;
		}
	}

	public static void GetBusyTimeTable(int[] start, int[] end) {

		buncher[] intervals = new buncher[start.length];

		for (int i = 0; i < start.length; i++) {
			buncher bunch = new buncher(start[i], end[i]);
			intervals[i] = bunch;
		}

		Arrays.sort(intervals);
		Stack<buncher> st = new Stack<>();
		st.push(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].st > st.peek().end) {
				st.push(intervals[i]);
			} else {
				st.peek().end = Math.max(st.peek().end, intervals[i].end);
			}
		}

		for (int i = 0; i < st.size(); i++) {
			System.out.println(st.get(i).st + " to " + st.get(i).end);
		}
	}

	public static void main(String[] args) {
		 String str = "iidddidd";
//		 PrintSmallestNumber(str);
		int[] arr = { 9, 1, 2, 7, 4, 6, 5, 3, 8 };
		// NGE_Rev(arr);
		// NGE(arr);
		int[] arr1 = { 6, 2, 5, 4, 15, 1, 6 };
		int[] arr2 = { 1 };
//		MaxAreaOfHistogram(arr2);
		 SlidingWindow(arr2, 1);
		String s1 = "((a+b)*((c+d)))";
		String s2 = "((a+b)*((c+d)*e))";
		String s3 = "(a)";
		// RedundantParanthesis(s1);
		// RedundantParanthesis(s2);
		// RedundantParanthesis(s3);

		boolean[][] data = { { false, true, true, false, true, true }, { true, false, true, true, true, true, },
				{ true, false, false, true, true, false }, { true, true, true, false, true, false },
				{ false, false, false, false, false, false }, { true, false, true, true, true, false } };

		// System.out.println(FindCelebrity(data));

		int[] start = { 22, 17, 19, 2, 6, 12, 3 };
		int[] end = { 26, 20, 23, 4, 9, 15, 7 };

		 GetBusyTimeTable(start, end);
		
		ArrayList<Integer> arl = new ArrayList<>();
		
	}

}
