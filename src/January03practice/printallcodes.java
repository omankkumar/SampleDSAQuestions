package January3practice;

import java.util.Scanner;

public class printallcodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scn = new Scanner(System.in);
		 String str = scn.next();

		codes(str, "", 0);

	}

	public static void codes(String ques, String ans, int qidx) {
		if (qidx >= ques.length()) {
			System.out.println(ans);
			return;
		}
		if (qidx == ques.length() - 1) {
			char chl = ques.charAt(qidx);
			if (chl != '0') {
				int cl = chl - '1' + 'a';
				char chl1 = (char) cl;
				String ansl = ans + chl1;
				codes(ques, ansl, qidx + 1);
				return;
			} else {
				codes(ques, ans, qidx + 1);
				return;
			}
		}

		char ch = ques.charAt(qidx);
		if (ch != '0') {
			int c = ch - '1' + 'a';
			char ch1 = (char) c;
			String ans1 = ans + ch1;

			codes(ques, ans1, qidx + 1);
		} else {
			codes(ques, ans, qidx + 1);
		}

		String s = ques.substring(qidx, qidx + 2);
		int c1 = Integer.parseInt(s);
		if (c1 >= 10 && c1 <= 26) {
			int c2 = c1 + 96;
			char ch2 = (char) c2;
			String ans2 = ans + ch2;
			codes(ques, ans2, qidx + 2);
		}
	}

}
