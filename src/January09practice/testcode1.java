package January09practice;

public class testcode1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		int n = str.length();
		for (int i = n / 2 + 1; i >= 0; i++) {
			System.out.println(str.charAt(i));
			if (i == n - 1) {
				i = -1;
			}
			if (i == n / 2) {
				break;
			}
		}

	}

}
