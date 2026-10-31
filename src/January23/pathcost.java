package January23;

import java.util.ArrayList;

public class pathcost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costmat = { { 2, 3, 6, 8, 1 }, 
							{ 7, 9, 4, 0, 4 }, 
							{ 4, 5, 9, 3, 7 }, 
							{ 5, 1, 0, 8, 4 },
							{ 1, 3, 8, 7, 6 }, 
							{ 8, 7, 0, 5, 1 }, 
							{ 0, 9, 6, 2, 2 } };
		
		int[][] mat = mincost(costmat);
		mincostpath(mat, 0, 0, "");

	}

	public static int[][] mincost(int[][] costmat) {
		int[][] mat = new int[costmat.length][costmat[0].length];

		for (int i = mat.length - 1; i >= 0; i--) {
			for (int j = mat[0].length - 1; j >= 0; j--) {
				if (i == mat.length - 1 && j == mat[0].length - 1) {
					mat[i][j] = costmat[i][j];
				} else if (j == mat[0].length - 1) {
					mat[i][j] = mat[i + 1][j] + costmat[i][j];
				} else if (i == mat.length - 1) {
					mat[i][j] = mat[i][j + 1] + costmat[i][j];
				} else {
					int temp1 = mat[i + 1][j] + costmat[i][j];
					int temp2 = mat[i][j + 1] + costmat[i][j];
					if (temp1 <= temp2) {
						mat[i][j] = temp1;
					} else {
						mat[i][j] = temp2;
					}
				}
			}
		}
		System.out.println(mat[0][0]);
		return mat;
	}

	public static void mincostpath(int[][] mat, int r, int c, String psf) {
		
		if (r == mat.length - 1 && c == mat[0].length - 1) {
			System.out.println(psf);
			return;
		} else if (r == mat.length - 1) {
			mincostpath(mat, r, c + 1, psf + 'H');
		} else if (c == mat[0].length - 1) {
			mincostpath(mat, r + 1, c, psf + 'V');
		} else {
			if (mat[r + 1][c] < mat[r][c + 1]) {
				mincostpath(mat, r + 1, c, psf + 'V');
			} else if (mat[r + 1][c] > mat[r][c + 1]) {
				mincostpath(mat, r, c + 1, psf + 'H');
			} else {
				mincostpath(mat, r + 1, c, psf + 'V');
				mincostpath(mat, r, c + 1, psf + 'H');
			}
		}
	}
}
