package JFebruary10;

public class below_3_codes_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abccbc";
		// System.out.println(mpc(str));
		// System.out.println(lpss(str));
		// System.out.println(lpsq(str));
		// System.out.println(cpsq(str));
		System.out.println(palindromic_partition(str));
	}

	public static int palindromic_partition(String s) {
		int cuts = Integer.MAX_VALUE;
		int length = 0;
		boolean[][] strg = new boolean[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = true;
					length = gap + 1;
				} else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
					strg[i][j] = true;
					length = gap + 1;
				} else if (gap > 1 && s.charAt(i) == s.charAt(j) && strg[i + 1][j - 1] == true) {
					strg[i][j] = true;
					length = gap + 1;
				}
			}
		}
		if (length == s.length()) {
			return 0;
		}
		for(int i = 2; i < length; i++)
		{
			int temp = 0;
			f
		}
		return cuts;
	}

	public static int mpc(String s) {
		int[][] strg = new int[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = 0;
				} else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j))
						strg[i][j] = 0;
					else
						strg[i][j] = 1;
				} else {
					if (s.charAt(i) == s.charAt(j) && strg[i + 1][j - 1] == 0)
						strg[i][j] = 0;
					else {
						strg[i][j] = Integer.MAX_VALUE;
						for (int k = 0; k < gap; k++) {
							int lc = strg[i][i + k];
							int rc = strg[i + k + 1][j];
							strg[i][j] = Math.min(strg[i][j], lc + rc + 1);
						}
					}
				}
			}
		}
		display(strg);
		return strg[0][s.length() - 1];
	}

	public static int lpss(String s) {
		int length = 0;
		boolean[][] strg = new boolean[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = true;
					length = gap + 1;
				} else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
					strg[i][j] = true;
					length = gap + 1;
				} else if (gap > 1 && s.charAt(i) == s.charAt(j) && strg[i + 1][j - 1] == true) {
					strg[i][j] = true;
					length = gap + 1;
				}
			}
		}
		display(strg);
		return length;
	}

	public static int lpsq(String s) {
		int[][] strg = new int[s.length()][s.length()];

		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = 1;
				} else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j))
						strg[i][j] = 2;
					else {
						strg[i][j] = 1;
					}
				} else {
					if (s.charAt(i) == s.charAt(j))
						strg[i][j] = strg[i + 1][j - 1] + 2;
					else
						strg[i][j] = Math.max(strg[i + 1][j], strg[i][j - 1]);
				}
			}
		}
		display(strg);
		return strg[0][s.length() - 1];
	}

	public static int cpsq(String s) {
		int[][] strg = new int[s.length()][s.length()];

		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = 1;
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = strg[i + 1][j] + strg[i][j - 1] + 1;
					} else {
						strg[i][j] = strg[i + 1][j] + strg[i][j - 1] - strg[i + 1][j - 1];
					}
				}
			}
		}
		display(strg);
		return strg[0][s.length() - 1];
	}

	public static void display(boolean[][] mat) {
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[0].length; c++) {
				if (mat[r][c])
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
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
