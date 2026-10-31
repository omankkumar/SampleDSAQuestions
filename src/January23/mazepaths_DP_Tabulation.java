package January23;

public class mazepaths_DP_Tabulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 2;
		int c = 2;
		int[][] mat = new int[r + 1][c + 1];
		// System.out.println(pathcnt(r, c, mat));

		System.out.println(cntmazepaths(r, c));

	}

	public static int pathcnt(int r, int c, int[][] qb) {
		if (r == 0 && c == 0) {
			return 1;
		}
		if (qb[r][c] != 0) {
			return qb[r][c];
		}
		int cnt1 = 0, cnt2 = 0;
		if (r != 0) {
			cnt1 = pathcnt(r - 1, c, qb);
		}
		if (c != 0) {
			cnt2 = pathcnt(r, c - 1, qb);
		}
		int cnt = cnt1 + cnt2;

		qb[r][c] = cnt;
		return cnt;
	}

	public static int cntmazepaths(int r, int c) {

		int[][] fn = new int[r + 1][c + 1];

		for (int i = r; i >= 0; i--) {
			for (int j = c; j >= 0; j--) {
				if (i == r && j == c) {
					fn[i][j] = 1;
				} else if (i == r) {
					fn[i][j] = fn[i][j + 1];
				} else if (j == c) {
					fn[i][j] = fn[i + 1][j];
				} else {
					int cnt1 = fn[i + 1][j];
					int cnt2 = fn[i][j + 1];
					int cnt = cnt1 + cnt2;
					fn[i][j] = cnt;
				}
			}
		}
		return fn[0][0];

	}

}
