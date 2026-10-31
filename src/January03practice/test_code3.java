package January3practice;

import java.util.Scanner;

public class test_code3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		//codes(str,"");
		 printall(str, "", 0);
	}

	static String[] alpha = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z" };

	public static void codes(String s, String ans) {
		if (s.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = s.charAt(0);
		int c = ch - '1';
		if (c > 0) {
			codes(s.substring(1), ans + alpha[c]);
		}
		String s1 = s.substring(0, 2);
		int ddig = Integer.parseInt(s1);

		if (ddig <= 26 && ddig >= 10) {
			codes(s.substring(2), ans + alpha[ddig]);
		}
	}

	public static void printall(String str, String ans, int i) {
		if (i >= str.length()) {
			System.out.println(ans);
			return;
		}
		if (i == str.length() - 1)// if length is one
		{
			int temp = 96 + (str.charAt(i) - '0');
			char ch = (char) temp;
			printall(str, ans + ch, i + 1);
			return;
		}
		int temp = 96 + (str.charAt(i) - '0');
		char ch = (char) temp;
		printall(str, ans + ch, i + 1);
		String twice = str.substring(i, i + 2);
		int temp2 = Integer.parseInt(twice);
		if (temp2 >= 10 && temp2 <= 26)/// important condition
		{
			temp = 96 + temp2;
			ch = (char) temp;
			printall(str, ans + ch, i + 2);
		}

	}

}
