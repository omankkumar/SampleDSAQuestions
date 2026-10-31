package May23;

import java.util.Stack;

public class PreFixToInFix {

	public static int evaluate(int val2, int val1, char op) {
		if (op == '^') {
			return (int) (Math.pow(val2, val1));
		} else if (op == '/') {
			return val2 / val1;
		} else if (op == '*') {
			return val2 * val1;
		} else if (op == '+') {
			return val2 + val1;
		} else if (op == '-') {
			return val2 - val1;
		} else {
			return 0;
		}
	}

	public static void PreFixOperations(String str) {

		Stack<Integer> es = new Stack<>();
		Stack<String> is = new Stack<>();
		Stack<String> ps = new Stack<>();

		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				es.push(ch - '0');

				String temp = ch + "";

				is.push(temp);

				ps.push(temp);
			} else {
				int val1 = es.pop();
				int val2 = es.pop();
				int ans = evaluate(val1, val2, ch);
				es.push(ans);
				
				String s1 = is.pop();
				String s2 = is.pop();
				String inval = "(" + s1 + ch + s2 + ")";
				is.push(inval);
				
				String s3 = ps.pop();
				String s4 = ps.pop();
				String pval = s3 + s4 + ch;
				ps.push(pval);
			}
		}

		System.out.println(es.peek());
		System.out.println(is.peek());
		System.out.println(ps.peek());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "-/24^32";
		PreFixOperations(str);
	}

}
