package JFebruary10;

public class longest_palandromic_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abccbook";
		// System.out.println(lpsq(s));
		System.out.println(lpsqc(s));
	}

	public static int lpsq(String s) {
		int[][] strg = new int[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < strg.length; i++, j++) {
				if (gap == 0) {
					strg[i][j] = 1;
				} else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = 2;
					} else {
						strg[i][j] = 1;
					}
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = strg[i + 1][j - 1] + 2;
					} else {
						strg[i][j] = Math.max(strg[i + 1][j], strg[i][j - 1]);
					}
				}
			}
		}
		display(strg);
		return strg[0][strg.length - 1];
	}

	public static int lpsqc(String s) {
		int[][] strg = new int[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < strg.length; i++, j++) {
				if (gap == 0) {
					strg[i][j] = 1;
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = strg[i + 1][j] + strg[i][j - 1] + 1;
					} else {
						strg[i][j] = strg[i + 1][j] + strg[i][j - 1] - strg[i + 1][j - 1];
					}   // we subtract diagnal elements as they are included
					    // twice, once in suffix and once in prefix
				}
			}
		}
		display(strg);
		return strg[0][strg.length - 1];
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
