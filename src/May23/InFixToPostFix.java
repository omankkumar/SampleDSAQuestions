package May23;

import java.util.Stack;

public class InFixToPostFix {

	public static int GetPriority(char ch) {

		if (ch == '^') {
			return 3;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else {
			return 1;
		}
	}

	public static String InToPost(String str) {
		String res = "";
		Stack<Character> os = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				res = res + ch;
			} else if (ch == '(') {
				os.push(ch);
			} else if (ch == ')') {
				while (os.peek() != '(') {
					res = res + os.pop();
				}
				os.pop();
			} else {
				while (os.size() > 0 && os.peek() != '(' && GetPriority(os.peek()) >= GetPriority(ch)) {
					res = res + os.pop();
				}
				os.push(ch);
			}
		}

		while (os.size() > 0) {
			res = res + os.pop();
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "(8+2)/3+2^(1*1+3)";
//		str = "2+3*4";
		System.out.println(InToPost(str));
	}

}
