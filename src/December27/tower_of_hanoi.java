package December27;

public class tower_of_hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "s";
		String d = "d";
		String h = "h";
		int n = 3;
		toh(s,d,h,n);
	}

	public static void toh(String s, String d, String h, int n) {
		if (n == 0) {
			return;
		}
		toh(s,h,d,n-1);
		System.out.println("move " + n + "th dics from " + s + " to " + d);
		toh(h,d,s,n-1);
	}

}
