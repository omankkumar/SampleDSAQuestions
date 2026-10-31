package January09practice;

import java.util.ArrayList;
import java.util.Scanner;

public class permalist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		ArrayList<String> arl = permal(str, "", str.length());
		int n = arl.size();
		ArrayList<String> alp = new ArrayList<>();

		for (int i = 0; i < arl.size(); i++) {
			//if (checkarl(arl.get(i), alp) == false) {
				alp.add(arl.get(i));
			//}
		}

		System.out.println(alp.size());

		for (int i = 0; i < alp.size(); i++) {
			System.out.println(alp.get(i));
		}

	}

	public static ArrayList<String> permal(String ques, String ans, int size) {
		if (ques.length() == 0) {
			ArrayList<String> rres = new ArrayList<>();
			rres.add(ans);
			return rres;
		}
		ArrayList<String> res = new ArrayList<>();
		for (int i = ques.length()/2; i < ques.length(); i--) {
			char ch = ques.charAt(i);
			String ques1 = ques.substring(0, i) + ques.substring(i + 1);
			String ans1 = ans + ch;
			ArrayList<String> arr = permal(ques1, ans1, size);
			for (int j = 0; j < arr.size(); j++) {
				res.add(arr.get(j));
			}
			if (i == 0) {
				i = ques.length();
			}
			if (i == ques.length() / 2 + 1) {
				break;
			}
		}
		return res;
	}

	public static boolean checkarl(String s, ArrayList<String> arr) {
		for (int i = 0; i < arr.size(); i++) {
			if (s.equals(arr.get(i))) {
				return true;
			}
		}
		return false;
	}

}
