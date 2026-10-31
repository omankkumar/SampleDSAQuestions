package May23;

import java.util.Stack;

public class PostFixToInFix {

	public static int GetPriority(char ch) {

		if (ch == '^') {
			return 3;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else {
			return 1;
		}
	}

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

	public static void PostOperations(String str) {

		Stack<Integer> es = new Stack<>();
		Stack<String> is = new Stack<>();
		Stack<String> ps = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				es.push(ch - '0');
				
				String temp = ch + "";
				
				is.push(temp);
				
				ps.push(temp);
			} else {
				int val1 = es.pop();
				int val2 = es.pop();
				int ans = evaluate(val2, val1, ch);
				es.push(ans);
				
				String s1 = is.pop();
				String s2 = is.pop();
				String in = '(' + s2 + ch + s1 + ')';
				is.push(in);
				
				String s3 = ps.pop();
				String s4 = ps.pop();
				String pre = ch + s4 + s3;
				ps.push(pre);
			}
		}
		
		System.out.println(es.peek());
		System.out.println(is.peek());
		System.out.println(ps.peek());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "82+3/211*3+^+";
		String s = "24/32^-";
		PostOperations(s);
	}

}
