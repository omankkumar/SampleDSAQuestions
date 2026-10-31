package JFebruary10;

public class minimum_palandromic_cut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abccbc";
		System.out.println(mpc(s));
	}

	public static int mpc(String s) {
		int[][] strg = new int[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = 0;
				} else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = 0;
					} else {
						strg[i][j] = 1;
					}
				} else {
					if (s.charAt(i) == s.charAt(j) && strg[i + 1][j - 1] == 0) {
						strg[i][j] = 0;
					} else {
						strg[i][j] = Integer.MAX_VALUE;
						for (int c = 1; c <= gap; c++) {
							int lp = strg[i][i + c - 1];
							int rp = strg[i + c][j];
							strg[i][j] = Math.min(strg[i][j], lp + rp + 1);
						}
					}
				}
			}
		}
		display(strg);
		return strg[0][s.length() - 1];
	}

	public static void display(int[][] mat) {
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[0].length; c++) {
				System.out.print(mat[r][c] + " ");
			}
			System.out.println();
		}
	}
}
