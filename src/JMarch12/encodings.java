package JMarch12;

public class encodings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ques = "2324";
		encode(ques, "");

	}
	
	public static void encode(String ques, String ans) {
		
		if(ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		int c1 = ques.charAt(0) - '0';
		
		if(c1 == 0) {
			return;
		} else {
			String ans1 = ans + (char)('a' + c1 - 1);
			encode(ques.substring(1), ans1);
		}
		
		if(ques.length() > 1) {
			int c2 = ques.charAt(1) - '0';
			int c3 = c1 * 10 + c2;
			if(c3 <= 26) {
				String ans2 = ans + (char)('a' + c3 - 1);
				encode(ques.substring(2), ans2);
			}
		}
	}
}