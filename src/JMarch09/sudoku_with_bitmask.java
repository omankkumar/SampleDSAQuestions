package JMarch09;

public class sudoku_with_bitmask {

	static int[] rowbm = new int[9];
	static int[] colbm = new int[9];
	static int[][] submatbm = new int[3][3];
	
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

		for (int j = 0; j < 9; j++) {
			int bm = 0;
			for (int i = 0; i < 9; i++) {
				bm = bm | (1 << mat[i][j]);
			}
			colbm[j] = bm;
		}

		for (int i = 0; i < 9; i++) {
			int bm = 0;
			for (int j = 0; j < 9; j++) {
				bm = bm | (1 << mat[i][j]);
			}
			rowbm[i] = bm;
		}

		for (int sr = 0; sr < 3; sr++) {
			for(int sc = 0; sc < 3; sc++) {
				int bm = 0;
				for (int i = sr * 3; i < sr * 3 + 3; i++) {
					for (int j = sc * 3; j < sc * 3 + 3; j++) {
						bm = bm | (1 << mat[i][j]);
					}
				}
				submatbm[sr][sc] = bm;
			}
		}
		sudoku(mat, 0);
	}
	
	public static void sudoku(int[][] board, int cp) {
		
		if(cp == 81) {
			displaymat(board);
			return;
		}
		
		int r = cp / 9;
		int c = cp % 9;
		
		if(board[r][c] == 0){
			for(int i = 1; i <= 9; i++) {
				if(pathsafe(cp, i)){
					
					rowbm[r] = (1<<i) | rowbm[r];
					colbm[c] = (1<<i) | colbm[c];
					submatbm[r/3][c/3] = (1<<i) | submatbm[r/3][c/3];
					board[r][c] = i;
		
					sudoku(board, cp + 1);
					
					rowbm[r] = (~(1<<i)) & rowbm[r];
					colbm[c] = (~(1<<i)) & colbm[c];
					submatbm[r/3][c/3] = (~(1<<i)) & submatbm[r/3][c/3];
					board[r][c] = 0;
				}
			}
		}
		else {
			sudoku(board, cp + 1);
		}
	}
	
	public static boolean pathsafe(int cp, int num) {
		
		int r = cp / 9;
		int c = cp % 9;
		int bm = 1 << num;
		
		int c1 = rowbm[r] & bm;
		int c2 = colbm[c] & bm;
		int c3 = submatbm[r/3][c/3] & bm;
		
		if(c1 == 0 && c2 == 0 && c3 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void displaymat(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void displayarr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
}
