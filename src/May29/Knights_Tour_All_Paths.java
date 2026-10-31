package May29;

public class Knights_Tour_All_Paths {
	
	public static boolean CanMove(int[][] mat, int i, int j) {
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
			return false;
		} else if (mat[i][j] != 0) {
			return false;
		} else {
			return true;
		}
	}
	
	static int count = 0;
	public static void KnightsTour(int[][] mat, int r, int c, int cnt) {
		
		if(r == 3 && c == 3) {
			System.out.println(cnt);
		}
		
		if (cnt == (mat.length * mat[0].length)) {
			count++;
//			mat[r][c] = cnt;
//			System.out.println("--------------" + count + "-------------");
//			Display(mat);
//			System.out.println("--------------" + count + "-------------");
			mat[r][c] = 0;
			return;
		}
		
		int i = 0;
		int j = 0;
		mat[r][c] = cnt;

		// dir1
		i = r - 2;
		j = c + 1;
		if (CanMove(mat, i, j)) {
			KnightsTour(mat, i, j, cnt + 1);
		}

		// dir2
		i = r - 1;
		j = c + 2;
		if (CanMove(mat, i, j)) {
			KnightsTour(mat, i, j, cnt + 1);
		}

		// dir3
		i = r + 1;
		j = c + 2;
		if (CanMove(mat, i, j)) {
			KnightsTour(mat, i, j, cnt + 1);
		}

		// dir4
		i = r + 2;
		j = c + 1;
		if (CanMove(mat, i, j)) {
			KnightsTour(mat, i, j, cnt + 1);
		}

		// dir5
		i = r + 2;
		j = c - 1;
		if (CanMove(mat, i, j)) {
			KnightsTour(mat, i, j, cnt + 1);
		}

		// dir6
		i = r + 1;
		j = c - 2;
		if (CanMove(mat, i, j)) {
			KnightsTour(mat, i, j, cnt + 1);
		}

		// dir7
		i = r - 1;
		j = c - 2;
		if (CanMove(mat, i, j)) {
			KnightsTour(mat, i, j, cnt + 1);
		}

		// dir8
		i = r - 2;
		j = c - 1;
		if (CanMove(mat, i, j)) {
			KnightsTour(mat, i, j, cnt + 1);
		}

		mat[r][c] = 0;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = new int[8][8];
		count = 0;
		KnightsTour(mat, 0, 0, 1);

	}
	
	public static void Display(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + "	");
			}
			System.out.println();
		}
	}

}
