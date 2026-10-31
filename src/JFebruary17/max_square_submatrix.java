package JFebruary17;

public class max_square_submatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 1, 1, 0, 1, 1, 0 }, { 0, 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1, 0 } };

		int[][] strg = new int[mat.length][mat[0].length];
		int r = 0;
		int c = 0;
		int max = 0;
		for (int i = mat.length - 1; i >= 0; i--) {
			for (int j = mat[0].length - 1; j >= 0; j--) {
				if (i == mat.length - 1 && j == mat[0].length - 1) {
					strg[i][j] = mat[i][j];
					if (mat[i][j] == 1) {
						r = i;
						c = j;
						max = 1;
					}
				} else if (i == mat.length - 1) {
					strg[i][j] = mat[i][j];
					if (mat[i][j] == 1) {
						r = i;
						c = j;
						max = 1;
					}
				} else if (j == mat[0].length - 1) {
					strg[i][j] = mat[i][j];
					if (mat[i][j] == 1) {
						r = i;
						c = j;
						max = 1;
					}
				} else {
					strg[i][j] = Integer.MAX_VALUE;
					if (mat[i][j] == 0) {
						strg[i][j] = 0;
					} else {
						int temp = Math.min(strg[i + 1][j], strg[i][j + 1]);
						int temp1 = Math.min(temp, strg[i + 1][j + 1]);
						strg[i][j] = Math.min(strg[i][j], temp1);
						strg[i][j]++;
						if (strg[i][j] > max) {
							max = strg[i][j];
							r = i;
							c = j;
						}
					}
				}
			}
		}
		display(strg);
		System.out.println(r + " " + c + " " + max);
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
