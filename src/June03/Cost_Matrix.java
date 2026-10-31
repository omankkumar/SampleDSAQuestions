package June03;

public class Cost_Matrix {

	public static int[][] findcost(int[][] mat) {
		// meaning of block = block se destination tak ke kitne paise
		int[][] cost = new int[mat.length][mat[0].length];
		cost[cost.length - 1][cost[0].length - 1] = mat[mat.length - 1][mat[0].length - 1];

		for (int i = cost.length - 1; i >= 0; i--) {
			for (int j = cost[0].length - 1; j >= 0; j--) {
				if (i == cost.length - 1 && j == cost[0].length - 1) {
					cost[i][j] = mat[i][j];
				} else if (i == cost.length - 1) {
					cost[i][j] = cost[i][j + 1] + mat[i][j];
				} else if (j == cost[0].length - 1) {
					cost[i][j] = cost[i + 1][j] + mat[i][j];
				} else {
					cost[i][j] = Math.min(cost[i][j + 1], cost[i + 1][j]) + mat[i][j];
				}
			}
		}

		System.out.println(cost[0][0]);
		return cost;
	}

	public static void printpaths(int cost[][], int r, int c, String psf) {
		if (r == cost.length - 1 && c == cost[0].length - 1) {
			psf = psf + "[" + r + "][" + c + "] ";
			System.out.println(psf);
			return;
		}

		if (r == cost.length - 1) {
			printpaths(cost, r, c + 1, psf + "[" + r + "][" + c + "] ");
		} else if (c == cost[0].length - 1) {
			printpaths(cost, r + 1, c, psf + "[" + r + "][" + c + "] ");
		} else {
			if (cost[r + 1][c] == cost[r][c + 1]) {
				printpaths(cost, r + 1, c, psf + "[" + r + "][" + c + "] ");
				printpaths(cost, r, c + 1, psf + "[" + r + "][" + c + "] ");
			} else if (cost[r + 1][c] < cost[r][c + 1]) {
				printpaths(cost, r + 1, c, psf + "[" + r + "][" + c + "] ");
			} else {
				printpaths(cost, r, c + 1, psf + "[" + r + "][" + c + "] ");
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 2, 6, 5, 1, 3, 4 }, 
						{ 0, 4, 9, 2, 9, 0 }, 
						{ 4, 8, 1, 0, 6, 5 }, 
						{ 3, 3, 3, 1, 5, 4 },
						{ 1, 2, 7, 0, 6, 9 }, 
						{ 5, 7, 1, 3, 8, 2 } };
		int[][] cost = findcost(mat);
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[0].length; j++) {
				System.out.print(cost[i][j] + " ");
			}
			System.out.println();
		}

		printpaths(cost, 0, 0, "");
	}

}
