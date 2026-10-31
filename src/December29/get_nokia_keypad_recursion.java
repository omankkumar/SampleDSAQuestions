package December29;

import java.util.ArrayList;

public class get_nokia_keypad_recursion {

	static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "12";
		System.out.println(get_nokia_keypad(str));
	}

	public static ArrayList<String> get_nokia_keypad(String str) {

		if (str.length() == 0) {
			ArrayList<String> res1 = new ArrayList<>();
			res1.add("");
			return res1;
		}
		char ch = str.charAt(0);
		int c = ch - '0';
		String ros = str.substring(1);
		ArrayList<String> ss_of_ros = get_nokia_keypad(ros);
		ArrayList<String> res = new ArrayList<>();
		for (int j = 0; j<ss_of_ros.size(); j++) {
			for (int i = 0; i < codes[c].length(); i++) {
				res.add(codes[c].charAt(i) + ss_of_ros.get(j));
			}
		}
		return res;
	}
}
