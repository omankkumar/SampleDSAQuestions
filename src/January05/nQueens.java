package January05;

public class nQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		placequeens(new boolean[n][n], 0, n, 0, "");
		// System.out.println(cnt);

	}

	static int cnt = 0;

	public static void placequeens(boolean[][] chess, int qno, int queens, int cp, String path) {
		if (qno == queens) {
			System.out.println((++cnt) + "." + path);
			return;
		}

		for (int i = cp; i < chess.length * chess.length; i++) {
			int row = i / chess.length;
			int col = i % chess.length; // i is box no.

			if (chess[row][col] == false) {
				if (pathsafe(chess, row, col) == true) {
					chess[row][col] = true;
					String ans = path + " q" + qno + "-b[" + row + "][" + col + "]";
					placequeens(chess, qno + 1, queens, i + 1, ans);

					chess[row][col] = false;
				}
			}
		}
	}

	public static boolean pathsafe(boolean[][] chess, int row, int col) {
		// for (int d = 0; d < chess.length; d++) {
		// // north
		// if (row - d >= 0 && chess[row - d][col] == true) {
		// return false;
		// }
		// // east
		// if (col + d < chess[0].length && chess[row][col + d] == true) {
		// return false;
		// }
		// // south
		// if (row + d < chess.length && chess[row + d][col] == true) {
		// return false;
		// }
		// // west
		// if (col - d >= 0 && chess[row][col - d] == true) {
		// return false;
		// }
		// // north-west
		// if (row - d >= 0 && col - d >= 0 && chess[row - d][col - d] == true)
		// {
		// return false;
		// }
		// // north-east
		// if (row - d >= 0 && col + d < chess[0].length && chess[row - d][col +
		// d] == true) {
		// return false;
		// }
		// // south-east
		// if (row + d < chess.length && col + d < chess[0].length && chess[row
		// + d][col + d] == true) {
		// return false;
		// }
		// // south-west
		// if (row + d < chess.length && col - d >= 0 && chess[row + d][col - d]
		// == true) {
		// return false;
		// }
		// }
		//
		// return true;

		int dim[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

		for (int dis = 1; dis < chess.length; dis++) {
			for (int[] dims : dim) {
				int rowdelta = dims[0];
				int coldelta = dims[1];

				int newrow = row + dis * rowdelta;
				int newcol = col + dis * coldelta;

				if (newrow >= 0 && newrow < chess.length && newcol >= 0 && newcol < chess[0].length) {
					if (chess[newrow][newcol] == true) {
						return false;
					}
				}
			}
		}
		return true;
	}

}

// for(int i = cpr; i<chess.length; i++)
// {
// for(int j = cpc; j<chess[0].length; j++)
// {
// if(chess[i][j] == false)
// {
// chess[i][j] = true;
// String ans = (path + " q" + qno + "-b" + (i) + (j));
//
// int cpc1 = j;
// int cpr1 = cpr;
// placequeens(chess,qno+1,queens,cpr1,cpc1,ans);
//
// chess[i][j] = false;
// }
// int
// }
// }