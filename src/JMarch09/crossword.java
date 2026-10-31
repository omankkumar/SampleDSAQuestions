package JMarch09;

public class crossword {

	public static void main(String[] args) {
		

		char[][] mat = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
						 { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
						 { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
						 { '+', '-', '-', '-', '-', '-', '+', '+', '+', '+' },
						 { '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
						 { '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
						 { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
						 { '+', '+', '-', '-', '-', '-', '-', '-', '+', '+' },
						 { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
						 { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' } };

		String[] arr = { "LONDON", "DELHI", "ICELAND", "ANKARA" };

		crossword(mat, arr, 0);
	}

	static boolean grandcheck = false;

	public static void crossword(char[][] mat, String[] arr, int vidx) {

		if (vidx == arr.length) {
			display(mat);
			System.out.print("-------------------");
			return;
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				if (canplaceH(mat, i, j, arr[vidx])) {

					boolean reset[] = new boolean[arr[vidx].length()];
					placeH(mat, i, j, arr[vidx], reset);
					crossword(mat, arr, vidx + 1);
					unplaceH(mat, i, j, arr[vidx], reset);
				}
				if (canplaceV(mat, i, j, arr[vidx])) {

					boolean reset[] = new boolean[arr[vidx].length()];
					placeV(mat, i, j, arr[vidx], reset);
					crossword(mat, arr, vidx + 1);
					unplaceV(mat, i, j, arr[vidx], reset);
				}

			}
		}
	}

	public static boolean canplaceH(char[][] mat, int r, int c, String s) {

		if (c + s.length() > mat.length) {
			return false;
		} else if (c > 0 && mat[r][c - 1] != '+') {
			return false;
		} else if (c + s.length() < mat.length && mat[r][c + s.length()] != '+') {
			return false;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (mat[r][c + i] != '-' && mat[r][c + i] != s.charAt(i)) {
					return false;
				}
			}
			return true;
		}
	}

	public static boolean canplaceV(char[][] mat, int r, int c, String s) {

		if (r + s.length() > mat[0].length) {
			return false;
		} else if (r > 0 && mat[r - 1][c] != '+') {
			return false;
		} else if (r + s.length() < mat[0].length && mat[r + s.length()][c] != '+') {
			return false;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (mat[r + i][c] != '-' && mat[r + i][c] != s.charAt(i)) {
					return false;
				}
			}
			return true;
		}
	}

	public static void placeH(char[][] mat, int r, int c, String s, boolean[] reset) {

		for (int i = 0; i < s.length(); i++) {
			if (mat[r][c + i] == '-') {
				reset[i] = true;
			}
			mat[r][c + i] = s.charAt(i);
		}
	}

	public static void placeV(char[][] mat, int r, int c, String s, boolean[] reset) {

		for (int i = 0; i < s.length(); i++) {
			if (mat[r + i][c] == '-') {
				reset[i] = true;
			}
			mat[r + i][c] = s.charAt(i);
		}
	}

	public static void unplaceH(char[][] mat, int r, int c, String s, boolean[] reset) {

		for (int i = 0; i < s.length(); i++) {
			if (reset[i]) {
				mat[r][c + i] = '-';
			}
		}
	}

	public static void unplaceV(char[][] mat, int r, int c, String s, boolean[] reset) {

		for (int i = 0; i < s.length(); i++) {
			if (reset[i]) {
				mat[r + i][c] = '-';
			}
		}
	}

	public static void display(char[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
