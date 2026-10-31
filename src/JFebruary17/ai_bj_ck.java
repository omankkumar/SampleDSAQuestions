package JFebruary17;

public class ai_bj_ck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcabc";
		int ai = 0;
		int bj = 0;
		int ck = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a') {
				ai = 1 + 2 * ai;
			} else if(str.charAt(i) == 'b') {
				bj = ai + 2 * bj;
			} else if(str.charAt(i) == 'c') {
				ck = bj + 2 * ck;
			}
		}
		System.out.println(ck);
	}

}
