package January05;

public class nKnights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		placeghoda(new boolean[4][4], 0, 4, 0, "");

	}

	static int cnt = 0;

	public static boolean isBoardSafe(boolean[][] chess) {

		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				if (chess[i][j] == true) {
					if (pathsafe(chess, i, j) == false) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void placeghoda(boolean[][] chess, int gno, int ghode, int cp, String path) {
		if (gno == ghode) {
			if (isBoardSafe(chess))
				System.out.println((++cnt) + "." + path);
			return;
		}

		for (int i = cp; i < chess.length * chess.length; i++) {
			int row = i / chess.length;
			int col = i % chess.length; // i is box no.

			if (chess[row][col] == false) {
				// if (pathsafe(chess, row, col) == true) {
				chess[row][col] = true;
				String ans = path + " g" + gno + "-b[" + row + "][" + col + "]";
				placeghoda(chess, gno + 1, ghode, i + 1, ans);

				chess[row][col] = false;
				// }
			}
		}
	}

	public static boolean pathsafe(boolean[][] chess, int r, int c) {
		int[][] dims = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };

		for (int i = 0; i < dims.length; i++) {
			int rdelta = dims[i][0];
			int cdelta = dims[i][1];

			int newrow = r + rdelta;
			int newcol = c + cdelta;

			if (newrow >= 0 && newrow < chess.length && newcol >= 0 && newcol < chess[0].length) {
				if (chess[newrow][newcol] == true) {
					return false;
				}
			}
		}
		return true;
	}

}
