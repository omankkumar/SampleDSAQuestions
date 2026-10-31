package JMarch10;

public class string_permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd";
		StringBuilder ques = new StringBuilder(s);
		StringBuilder ans = new StringBuilder();
		pac2(ques, ans);
	}

	public static void pqc(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			String ans1 = ans + ques.charAt(i);
			String ques1 = ques.substring(0, i) + ques.substring(i + 1);
			pqc(ques1, ans1);
		}
	}

	public static void pac(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		char ch = ques.charAt(0);
		String ques1 = ques.substring(1);
		for (int i = 0; i <= ans.length(); i++) {
			String ans1 = ans.substring(0, i) + ch + ans.substring(i);
			pac(ques1, ans1);
		}
	}

	public static void pqcnr(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		int bm = 0;

		for (int i = 0; i < ques.length(); i++) {
			String ans1 = ans + ques.charAt(i);

			if ((bm & (1 << (ques.charAt(i) - 'a'))) == 0) {
				String ques1 = ques.substring(0, i) + ques.substring(i + 1);
				pqcnr(ques1, ans1);
				bm = bm | (1 << (ques.charAt(i) - 'a'));
			}
		}
	}

	public static void pqc2(StringBuilder ques, StringBuilder ans) {

		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			ans.append(ch);
			ques.deleteCharAt(i);

			pqc2(ques, ans);

			ans.deleteCharAt(ans.length() - 1);
			ques.insert(i, ch);
		}
	}
	
	public static void pac2(StringBuilder ques, StringBuilder ans) {
		
		if(ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		
		char ch = ques.charAt(ques.length() - 1);
		for(int i = 0; i < ans.length() + 1; i++) {
			
			ans.insert(i, ch);
			ques.deleteCharAt(ques.length() - 1);
			
			pac2(ques, ans);
			
			ques.append(ch);
			ans.deleteCharAt(i);
		}
	}
}
