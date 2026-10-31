package January23;

public class staircase_DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[] qb = new int[n+1];
		System.out.println(climbstair(n,qb));

	}

	public static int climbstair(int n, int[] qb) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		if (qb[n] != 0) {
			return qb[n];
		}
		int cnt = 0;
		for (int i = 1; i <= 3; i++) {
			if (n - i >= 0) {
				int cnt1 = climbstair(n - i, qb);
				cnt = cnt + cnt1;
			}
		}
		qb[n] = cnt;
		return cnt;
	}
}
