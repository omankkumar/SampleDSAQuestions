package January12;

public class sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
						{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
						{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
						{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
						{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
						{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
						{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		sudoku(mat, 0);
		display(mat);
	}

	public static void sudoku(int[][] mat, int cp) {

		if (cp >= mat.length * mat.length) {
			System.out.println("-----------------");
			//display(mat);
			System.out.println("-----------------");
			return;
		}

		int r = cp / mat.length;
		int c = cp % mat.length; // cp is cell no.

		if (mat[r][c] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (pathsafe(mat, r, c, num) == true) {
					mat[r][c] = num;
					sudoku(mat, cp + 1);
					mat[r][c] = 0;// wapas tabhi aayega jab, tum kuch fill nahi kar paoge
				}				  // isliye no. ko remove kardiya, taki kuch aur fill karke try k
			}
		} else {
			sudoku(mat, cp + 1);
		}
	}

	public static boolean pathsafe(int[][] mat, int r, int c, int num) {
		for (int i = 0; i < mat.length; i++) {
			if (mat[i][c] == num) {
				return false;
			}
		}

		for (int i = 0; i < mat[0].length; i++) {
			if (mat[r][i] == num) {
				return false;
			}
		}
		int rs = (r / 3) * 3;
		int cs = (c / 3) * 3;

		for (int i = rs; i < rs + 3; i++) {
			for (int j = cs; j < cs + 3; j++) {
				if (mat[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
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
