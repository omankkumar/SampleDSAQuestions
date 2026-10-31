package May23;

import java.util.Stack;

public class EvaluateInfix {

	public static int GetPriority(char ch) {

		if (ch == '^') {
			return 3;
		} else if (ch == '*' || ch == '/' || ch == '%') {
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

	public static int InfixEvaluation(String str) {

		Stack<Character> os = new Stack<>();
		Stack<Integer> vs = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				vs.push(ch - '0');
			} else if (ch == '(') {
				os.push(ch);
			} else if (ch == ')') {
				while (os.peek() != '(') {
					int val1 = vs.pop();
					int val2 = vs.pop();
					char operand = os.pop();
					int ans = evaluate(val2, val1, operand);
					vs.push(ans);
				}
				os.pop();
			} else {
				while (os.size() != 0 && os.peek() != '(' && GetPriority(os.peek()) >= GetPriority(ch)) {
					int val1 = vs.pop();
					int val2 = vs.pop();
					char operand = os.pop();
					int ans = evaluate(val2, val1, operand);
					vs.push(ans);
				}
				os.push(ch);
			}
		}

		while (os.size() > 0) {
			int val1 = vs.pop();
			int val2 = vs.pop();
			char operand = os.pop();
			int ans = evaluate(val2, val1, operand);
			vs.push(ans);
		}

		return vs.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "8+2/3+2^1*(1+3)";
		String str2 = "8+2/(3+2)^(1*1+3)";
		String str3 = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(InfixEvaluation(str1));
		System.out.println(InfixEvaluation(str2));
		System.out.println(InfixEvaluation(str3));
	}

}
