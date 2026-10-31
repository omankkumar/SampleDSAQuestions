package January09practice;

import java.util.ArrayList;
import java.util.Scanner;

public class testcode2 {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		count(str);

		System.out.println(permal(str, "", str.length()));
		stringperm(str, "");

	}

	public static void count(String s) {
		int n = s.length();
		int val = 1;
		while (n > 1) {
			val = val * n;
			n--;
		}
		System.out.println(val);
	}

	public static void stringperm(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			String ans1 = ans + ques.charAt(i);
			String ques1 = ques.substring(0, i) + ques.substring(i + 1);

			stringperm(ques1, ans1);
		}
	}

	public static ArrayList<String> permal(String ques, String ans, int size) {
		if (ques.length() == 0) {
			ArrayList<String> rres = new ArrayList<>();
			rres.add(ans);
			return rres;
		}
		ArrayList<String> res = new ArrayList<>();
		for (int i = 0; i <= ans.length(); i++) {
			char ch = ques.charAt(ques.length() - 1);
			String ques1 = ques.substring(0,ques.length()-1);
			String ans1 = ans.substring(0, i) + ch + ans.substring(i);
			ArrayList<String> arr = permal(ques1, ans1, size);
			for (int j = 0; j <arr.size(); j++) {
				res.add(arr.get(j));
			}
		}
		return res;
	}
}

/*
 *  6 
 *  [aab, aab, aba, aba, baa, baa]
 *  aab
 *  aba 
 *  aab 
 *  aba 
 *  baa 
 *  baa
 */
