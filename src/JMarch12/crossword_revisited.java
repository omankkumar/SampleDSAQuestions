package JMarch12;

class crossword_revisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

		boolean[] used = new boolean[arr.length];

		cross(mat, arr, 0, used);
	}

	public static void cross(char[][] mat, String[] arr, int bno, boolean[] used) {

		if (bno == mat.length * mat[0].length) {
			boolean check = true; // check if all words are used
			for (int i = 0; i < used.length; i++) {
				if (used[i] == false) {
					check = false;
					break;
				}
			}
			if (check) { // if all words are used, print matrix
				System.out.println("-------------------");
				display(mat);
				System.out.println("-------------------");
			}
			return;
		}

		int r = bno / mat.length;
		int c = bno % mat[0].length;

		if (mat[r][c] == '+') {
			cross(mat, arr, bno + 1, used);
		} else {
			boolean check = false;
			for (int i = 0; i < arr.length; i++) {
				if (used[i] == false) {
					if (canplaceH(mat, r, c, arr[i])) {

						boolean[] reset = new boolean[arr[i].length()];
						used[i] = true;
						placeH(mat, r, c, arr[i], reset);
						check = true;

						cross(mat, arr, bno + 1, used);

						used[i] = false;
						unplaceH(mat, r, c, arr[i], reset);
					}

					if (canplaceV(mat, r, c, arr[i])) {

						boolean[] reset = new boolean[arr[i].length()];
						used[i] = true;
						placeV(mat, r, c, arr[i], reset);
						check = true;

						cross(mat, arr, bno + 1, used);

						used[i] = false;
						unplaceV(mat, r, c, arr[i], reset);
					}
				}
			}
			
			if (check == false) {
				cross(mat, arr, bno + 1, used);
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
