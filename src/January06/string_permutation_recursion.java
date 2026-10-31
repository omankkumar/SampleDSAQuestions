package January06;

public class string_permutation_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 stringperm("abc", "");

		// StringBuilder ques2 = new StringBuilder("abc");
		// StringBuilder ans2 = new StringBuilder("");
		// stringperm1(ques2, ans2);

		 //stringperm2("abc", "");

//		StringBuilder ques2 = new StringBuilder("abc");
//		StringBuilder ans2 = new StringBuilder("");
//		stringperm3(ques2, ans2);
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

	public static void stringperm1(StringBuilder ques, StringBuilder ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);

			ques.deleteCharAt(i);
			ans.append(ch); // pre area, jate hue kuch kiya.
			stringperm1(ques, ans);
			ans.deleteCharAt(ans.length() - 1); // post rea, wapas aate hue vo
												// effects reverse kiye.
			ques.insert(i, ch);
		}
	}

	public static void stringperm2(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i <= ans.length(); i++) {
			char ch = ques.charAt(0);
			String ans1 = ans.substring(0, i) + ch + ans.substring(i);
			String ques1 = ques.substring(1);

			stringperm2(ques1, ans1);
		}
	}

	public static void stringperm3(StringBuilder ques, StringBuilder ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i <= ans.length(); i++) {
			char ch = ques.charAt(0);
			ans.insert(i, ch);
			ques.deleteCharAt(0);

			stringperm3(ques, ans);

			ans.deleteCharAt(i);
			ques.insert(0, ch);
		}
	}
}
