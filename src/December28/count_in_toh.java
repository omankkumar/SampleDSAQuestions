package December28;

public class count_in_toh {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A";
		String d = "B";
		String h = "C";
		int n = 3;
		int cnt = 0;
		int count = toh(s, d, h, n, cnt);
		System.out.println("Number of steps would be " + count);
	}
	
	public static int toh(String s, String d, String h, int n, int cnt) {
		if (n == 0) {
			return cnt;
		}
		int temp = toh(s, h, d, n - 1, cnt);
		if (n == 1) {
			System.out.println((temp + 1) + ". Move " + n + "st dics from " + s + " to " + d);
		} else if (n == 2) {
			System.out.println((temp + 1) + ". Move " + n + "nd dics from " + s + " to " + d);
		} else if (n == 3) {
			System.out.println((temp + 1) + ". Move " + n + "rd dics from " + s + " to " + d);
		} else {
			System.out.println((temp + 1) + ". Move " + n + "th dics from " + s + " to " + d);
		}
		temp++;
		int temp2 = toh(h, d, s, n - 1, temp);
		return temp2;
	}
}
