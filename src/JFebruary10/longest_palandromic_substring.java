package JFebruary10;

public class longest_palandromic_substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abccbc";
		System.out.println("Max length is " + lpstr(s));
	}

	public static int lpstr(String s) {
		int length = 1;
		int cnt = 0;
		boolean[][] strg = new boolean[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = true;
					length = 1;
					cnt++;
				} else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
					strg[i][j] = true;
					length = gap + 1;
					cnt++;
				} else if (gap > 1 && s.charAt(i) == s.charAt(j) && strg[i + 1][j - 1] == true) {
					strg[i][j] = true;
					length = gap + 1;
					cnt++;
				}
			}
		}
		display(strg);
		System.out.println("Count is " + cnt);
		return length;
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
}
