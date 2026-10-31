package JFebruary10;

import java.util.ArrayList;
import java.util.Collections;

public class permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<String> res = new ArrayList<>();
		 findperm("abc", "", res);
		 System.out.println(res);
		int[] arr = { 6, 4, 6, 4, 4, 6, 6, 6, 4, 6};
//		majority_element(arr);
	}

	public static void findperm(String ques, String ans, ArrayList<String> res) {

		if (ques.length() == 0) {
			res.add(ans);
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			String ans1 = ans + ques.charAt(i);
			String ques1 = ques.substring(0, i) + ques.substring(i + 1);

			findperm(ques1, ans1, res);
		}

	}
}
