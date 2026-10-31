package June04;

public class Goldmine {

	public static void goldmine(int[][] mine) {

		int[][] strg = new int[mine.length][mine[0].length];
		for (int i = 0; i < mine.length; i++) {
			strg[i][mine[0].length - 1] = mine[i][mine[0].length - 1];
		}

		for (int i = mine[0].length - 2; i >= 0; i--) {
			for (int j = 0; j < mine.length; j++) {
				if (j == 0) {
					strg[j][i] = mine[j][i] + Math.max(strg[j][i + 1], strg[j + 1][i + 1]);
				} else if (j == mine.length - 1) {
					strg[j][i] = mine[j][i] + Math.max(strg[j][i + 1], strg[j - 1][i + 1]);
				} else {
					strg[j][i] = mine[j][i]
							+ Math.max(strg[j][i + 1], Math.max(strg[j - 1][i + 1], strg[j + 1][i + 1]));
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < strg.length; i++) {
			if(strg[i][0] > max) {
				max = strg[i][0];
			}
		}
		
		for (int i = 0; i < strg.length; i++) {
			if(strg[i][0] == max) {
				printpath(strg, i, 0, "");
			}
		}
		System.out.println(max);
	}
	
	public static void printpath(int[][] strg, int r, int c, String psf) {
		
		if(c == strg[0].length - 1) {
			System.out.println(psf + "[" + r + "][" + c + "] ");
			return;
		}
		
		if(r == 0) {
			if(strg[r][c + 1] > strg[r + 1][c + 1]) {
				printpath(strg, r, c + 1, psf + "[" + r + "][" + c + "] ");
			} else if(strg[r][c + 1] < strg[r + 1][c + 1]) {
				printpath(strg, r + 1, c + 1, psf + "[" + r + "][" + c + "] ");
			} else {
				printpath(strg, r, c + 1, psf + "[" + r + "][" + c + "] ");
				printpath(strg, r + 1, c + 1, psf + "[" + r + "][" + c + "] ");
			}
		} else if(r == strg.length - 1) {
			if(strg[r][c + 1] > strg[r - 1][c + 1]) {
				printpath(strg, r, c + 1, psf + "[" + r + "][" + c + "] ");
			} else if(strg[r][c + 1] < strg[r - 1][c + 1]) {
				printpath(strg, r - 1, c + 1, psf + "[" + r + "][" + c + "] ");
			} else {
				printpath(strg, r, c + 1, psf + "[" + r + "][" + c + "] ");
				printpath(strg, r - 1, c + 1, psf + "[" + r + "][" + c + "] ");
			}
		} else {
			int max = Math.max(strg[r][c + 1], Math.max(strg[r + 1][c + 1], strg[r - 1][c + 1]));
			if(strg[r - 1][c + 1] == max) {
				printpath(strg, r - 1, c + 1, psf + "[" + r + "][" + c + "] ");
			}
			if(strg[r][c + 1] == max) {
				printpath(strg, r, c + 1, psf + "[" + r + "][" + c + "] ");
			}
			if(strg[r + 1][c + 1] == max) {
				printpath(strg, r + 1, c + 1, psf + "[" + r + "][" + c + "] ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] mine = {{2,5,0,1,3},
						{3,5,4,2,9},
						{4,2,0,1,7},
						{0,1,3,5,4},
						{3,4,8,2,4},
						{2,0,6,3,7}};
		
		goldmine(mine);
	}

}
