package December30;

import java.util.ArrayList;

public class subsequences_and_dice_game {

	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		int cnt = 0;
		// printss(str, cnt);
		// printss2("abc", "");
		// printascii("bc", "");
		// getboardpath(0, 10, 6, "");
		System.out.println(alboardpath(0, 4));
		ArrayList<String> res1 = alboardpath(0,10);
		System.out.println(res1.size());
	}

	public static void printss(String str, int cnt) {
		if (cnt == 8) {
			return;
		}
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			int bm = 1 << i;
			if ((bm & cnt) > 0)
				s = s + str.charAt(i);
		}
		System.out.println(s);

		printss(str, cnt + 1);
	}

	public static void printss2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.print(ans); // work is done in pre - area..
			System.out.println();
			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		printss2(ros, ans);
		printss2(ros, ans + ch);
	}

	public static void printascii(String ques, String ans) {

		if (ques.equals("")) {
			System.out.print(ans); // work is done in pre - area..
			System.out.println();
			return;
		}

		char ch = ques.charAt(0);
		int c = ch;
		String ros = ques.substring(1);

		printascii(ros, ans);
		printascii(ros, ans + c);
		printascii(ros, ans + ch);
	}

	public static void getboardpath(int src, int dest, int max, String s) {
		if (src == dest) {
			System.out.println(s + " " + (++cnt));
			return;
		}
		for (int i = 1; i <= max; i++) {
			if (i <= dest - src) {
				String path = s + i;
				getboardpath(src + i, dest, max, path);
			}
		}
	}

	public static ArrayList<String> alboardpath(int src, int dest) {
		if (src == dest) {
			ArrayList<String> rres = new ArrayList<>();
			rres.add("");
			return rres;
		}
		ArrayList<String> res = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			if (i <= dest - src) {
				ArrayList<String> pun = alboardpath(src+i, dest);
				// for (String ss : pun) {
				// res.add(i + ss);
				// }
				for (int j = 0; j < pun.size(); j++) {
					res.add(i + pun.get(j));
				}
			}
		}
		return res;
	}

}
