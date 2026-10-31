package December25;

public class biggest_sqaure_submatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int[][] mat = { { 1, 1, 1, 1, 0, 1, 1 }, { 0, 1, 1, 1, 0, 1, 1 }, {
		 * 0, 1, 1, 1, 0, 0, 1 }, { 1, 1, 1, 0, 1, 1, 0 }, { 0, 1, 1, 1, 0, 1, 0
		 * }, { 0, 1, 0, 0, 1, 0, 0 } };
		 */
		int[][] mat = { { 1, 1, 1, 0, 1, 1, 0 }, { 0, 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1, 0 } };
		int row = mat.length;
		int col = mat[0].length;
		int[][] mat1 = new int[row][col];

		for (int i = 0; i < row; i++) {
			mat1[i][col - 1] = mat[i][col - 1];
		}
		for (int i = 0; i < col; i++) {
			mat1[row - 1][i] = mat[row - 1][i];
		}
		int max = 0;

		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				if (mat[i][j] == 0) {
					mat1[i][j] = 0;
				} else if ((((mat[i + 1][j] == 0) || (mat[i][j + 1] == 0) || (mat[i + 1][j + 1] == 0)))
						&& (mat[i][j] == 1)) {
					mat1[i][j] = 1;
				} else if ((mat1[i + 1][j] > 0) && (mat1[i][j + 1] > 0) && (mat1[i + 1][j + 1] > 0)) {
					int m = find_max(mat1[i + 1][j], mat1[i][j + 1], mat1[i + 1][j + 1]);
					mat1[i][j] = m;
					if (m >= max) {
						max = m;
					}
				}
			}
		}
		display(mat1);
		System.out.println(max);
	}

	public static void display(int[][] mat) {
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[0].length; c++) {
				System.out.print(mat[r][c] + " ");
			}
			System.out.println();
		}
	}

	public static int find_max(int a, int b, int c) {
		if ((a == b) && (b == c)) {
			return (a + 1);
		} else {
			if (a > b && a > c) {
				return a;
			} else if (b > c) {
				return b;
			} else {
				return c;
			}
		}
	}
}
