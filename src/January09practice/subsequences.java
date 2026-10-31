package January09practice;

import java.util.ArrayList;
import java.util.Scanner;

public class subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		count(str);
		System.out.println(substral(str, 0));
		substr(str, "");

	}

	public static void count(String s) {
		int num = s.length();
		int cnt = 1;

		while (num > 1) {
			cnt = num * cnt;
			num--;
		}

		System.out.println(cnt);
	}

	public static ArrayList<String> substral(String s, int sidx) {
		if (sidx == s.length()) {
			ArrayList<String> res1 = new ArrayList<>();
			res1.add("");
			return res1;
		}
		ArrayList<String> res = new ArrayList<>();
		ArrayList<String> res_of_ss = substral(s, sidx + 1);
		char ch = s.charAt(sidx);
		for (int i = 0; i < res_of_ss.size(); i++) {
			res.add(res_of_ss.get(i));
			res.add(ch + res_of_ss.get(i));
		}

		return res;
	}

	public static void substr(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String ques1 = ques.substring(1);
		String ans1 = ans + ch;

		substr(ques1, ans);
		substr(ques1, ans1);
	}

}
