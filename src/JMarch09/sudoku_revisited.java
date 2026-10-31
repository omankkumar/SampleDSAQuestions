package JMarch09;

import java.awt.DisplayMode;

public class sudoku_revisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] mat = {{3,0,6,5,0,8,4,0,0},
					   {5,2,0,0,0,0,0,0,0},
					   {0,8,7,0,0,0,0,3,1},
					   {0,0,3,0,1,0,0,8,0},
					   {9,0,0,8,6,3,0,0,5},
					   {0,5,0,0,9,0,6,0,0},
					   {1,3,0,0,0,0,2,5,0},
					   {0,0,0,0,0,0,0,7,4},
					   {0,0,5,2,0,6,3,0,0}};
		
		sudoku(mat, 0);

	}
	
	public static void sudoku(int[][] board, int cp) {
		
		if(cp == 81) {
			display(board);
			return;
		}
		
		int r = cp / 9;
		int c = cp % 9;
		
		if(board[r][c] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(pathsafe(board, cp, i)) {
					board[r][c] = i;
					sudoku(board, cp + 1);
					board[r][c] = 0;
				}
				
			}
		} else {
			sudoku(board, cp + 1);
		}
	}
	
	public static boolean pathsafe(int[][] board, int cp, int num) {
		
		int r = cp / 9;
		int c = cp % 9;
		
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
		
		for(int i = sr; i < sr + 3; i++) {
			for(int j = sc; j < sc + 3; j++) {
				if(board[i][j] == num) {
					return false;
				}
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if(board[i][c] == num) {
				return false;
			}
			if(board[r][i] == num) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void display(int[][] mat) {
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
