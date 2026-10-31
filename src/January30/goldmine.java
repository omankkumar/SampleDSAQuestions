package January30;

public class goldmine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mine = { { 4, 5, 7, 3, 5 }, 
						 { 6, 7, 2, 0, 2 }, 
						 { 3, 0, 5, 4, 6 }, 
						 { 2, 4, 3, 0, 3 },
						 { 5, 7, 6, 4, 2 } };

		int[][] temp = new int[5][5];

		for (int i = 0; i < temp[0].length; i++) {
			temp[i][0] = mine[i][0];
		}

		for (int c = 1; c < mine[0].length; c++) {
			for (int r = 0; r < mine.length; r++) {
				if (r - 1 < 0) {
					int max = findmax(-1, temp[r][c - 1], temp[r + 1][c - 1]);
					temp[r][c] = mine[r][c] + max;
				}

				else if (r - 1 >= 0 && r + 1 < temp.length) {
					int max = findmax(temp[r - 1][c - 1], temp[r][c - 1], temp[r + 1][c - 1]);
					temp[r][c] = mine[r][c] + max;
				} else {
					int max = findmax(temp[r - 1][c - 1], temp[r][c - 1], -1);
					temp[r][c] = mine[r][c] + max;
				}
			}
		}

		int maxval = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i][temp[0].length - 1] > maxval) {
				maxval = temp[i][temp[0].length - 1];
			}
		}

		System.out.println(maxval);
		
		display(temp);

		for (int r = 0; r < temp.length; r++) {
			if (temp[r][temp[0].length - 1] == maxval) {
				printpath(temp, temp[0].length - 1, r, "");
			}
		}

	}

	public static void printpath(int[][] temp, int c, int r, String asf) {
		if (c == 0) {
			System.out.println(r + asf);
			return;
		}

		if (r - 1 < 0) {
			int max = findmax(-1, temp[r][c - 1], temp[r + 1][c - 1]);
			if (max == temp[r][c - 1]) {
				printpath(temp, c - 1, r, 'h' + asf);
			}
			if (max == temp[r + 1][c - 1]) {
				printpath(temp, c - 1, r + 1, 'd' + asf);
			}

		}

		else if (r - 1 >= 0 && r + 1 < temp.length) {
			int max = findmax(temp[r - 1][c - 1], temp[r][c - 1], temp[r + 1][c - 1]);
			if (max == temp[r][c - 1]) {
				printpath(temp, c - 1, r, 'h' + asf);
			}
			if (max == temp[r + 1][c - 1]) {
				printpath(temp, c - 1, r + 1, 'd' + asf);
			}
			if (max == temp[r - 1][c - 1]) {
				printpath(temp, c - 1, r - 1, 'u' + asf);
			}

		} else {
			int max = findmax(temp[r - 1][c - 1], temp[r][c - 1], -1);
			if (max == temp[r][c - 1]) {
				printpath(temp, c - 1, r, 'h' + asf);
			}
			if (max == temp[r + 1][c - 1]) {
				printpath(temp, c - 1, r + 1, 'd' + asf);
			}
		}
	}

	public static int findmax(int a, int b, int c) {
		int max = Math.max(a, b);
		int max1 = Math.max(max, c);
		return max1;
	}

	public static void display(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
