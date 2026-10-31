package May22;

import java.util.Stack;

public class Stacks {

	public static boolean BalancedParanthesis(String s) {

		Stack<Character> st = new Stack<>();
		boolean check = true;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') && (st.size() == 0)) {
				check = false;
				break;
			}
			if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
				while (st.peek() != '(' && st.peek() != '[' && st.peek() != '{') {
					st.pop();
				}
				if ((s.charAt(i) == ')' && st.peek() != '(') || (s.charAt(i) == ']' && st.peek() != '[')
						|| (s.charAt(i) == '}' && st.peek() != '{')) {
					check = false;
					break;
				}
				st.pop();
			} else {
				st.push(s.charAt(i));
			}
		}

		if (st.size() != 0) {
			check = false;
		}
		return check;
	}

	public static void StockSpan(int[] arr) {

		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (st.size() > 0 && arr[st.peek()] < arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}
			st.push(i);
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = i - ans[i];
		}

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		String s1 = "[{(a+b)+(c+d)}]";
		String s2 = "[{(a+b)+(c+d})]";
		String s3 = "[{(a+b)+(c+d)}";
		String s4 = "{(a+b)+(c+d)}]";
		System.out.println(BalancedParanthesis(s1));
		System.out.println(BalancedParanthesis(s2));
		System.out.println(BalancedParanthesis(s3));
		System.out.println(BalancedParanthesis(s4));

		int[] arr = { 3, 6, 2, 1, 5, 9, 5, 4, 3, 7, 6 };
		StockSpan(arr);
	}

}
