package JMarch18practice;

public class cryptography {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "send";
		String s2 = "more";
		String s3 = "money";
		String uni = "sendmory";
		int[] assign = new int[26];
		boolean[] usedchar = new boolean[26];
		boolean[] usednum = new boolean[10];
		
		for (int i = 0; i < assign.length; i++) {
			assign[i] = -1;
		}

		crypto(s1, s2, s3, uni, assign, usedchar, usednum, 0);
	}
	
	public static int cnt = 0;
	
	public static void crypto(String s1, String s2, String s3, String uni, int[] assign, boolean[] usedchar,
			boolean[] usednum, int vidx) {

		// base case
		if (vidx == uni.length()) {

			// check if every char is assigned
			boolean check = true;
			for (int i = 0; i < uni.length(); i++) {
				if (usedchar[uni.charAt(i) - 'a'] == false) {
					check = false;
					break;
				}
			}
			// if all chars are used
			if (check == true) {
				int num1 = 0;
				int num2 = 0;
				int num3 = 0;

				while (s1.length() != 0) {
					char ch = s1.charAt(0);
					int c = assign[ch - 'a'];
					s1 = s1.substring(1);
					num1 = num1 * 10 + c;
				}

				while (s2.length() != 0) {
					char ch = s2.charAt(0);
					int c = assign[ch - 'a'];
					s2 = s2.substring(1);
					num2 = num2 * 10 + c;
				}

				while (s3.length() != 0) {
					char ch = s3.charAt(0);
					int c = assign[ch - 'a'];
					s3 = s3.substring(1);
					num3 = num3 * 10 + c;
				}

				if (num1 + num2 == num3) {
					cnt++;
					System.out.print(cnt + "). ");
					for (int i = 0; i < usedchar.length; i++) {
						if (usedchar[i] == true) {
							System.out.print((char) ('a' + i) + "->" + assign[i] + " ");
						}
					}
					System.out.println();
				}
			}
			return;
		}

		char ch = uni.charAt(vidx);
		for (int i = 0; i < usednum.length; i++) {
			if (usednum[i % 10] == false) {
				usedchar[ch - 'a'] = true;
				assign[ch - 'a'] = i % 10;
				usednum[i % 10] = true;

				crypto(s1, s2, s3, uni, assign, usedchar, usednum, vidx + 1);

				usedchar[ch - 'a'] = false;
				assign[ch - 'a'] = -1;
				usednum[i % 10] = false;
			}
		}
	}
}
