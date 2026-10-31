package JFebruary09;

import java.util.TreeMap;

public class knap_sack_0_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wts = { 2, 5, 1, 3, 4 };
		int[] price = { 15, 14, 10, 45, 30 };
		int cap = 7;
		int[][] mat = new int[wts.length + 1][cap + 1];

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if (j < wts[i - 1]) {
					mat[i][j] = mat[i - 1][j];
				} else {
					int a1 = mat[i - 1][j];
					int a2 = mat[i - 1][j - wts[i - 1]] + price[i - 1];
					mat[i][j] = Math.max(a1, a2);
				}
			}
		}
		display(mat);
		System.out.println(mat[mat.length - 1][mat[0].length - 1]);
		printpath(mat, price, wts);
	}

	public static void printpath(int[][] mat, int[] price, int[] wts) {
		String path = "";
		int c = mat[0].length - 1;
		int r = mat.length - 1;
		while (r > 0) {
			if (c == 0) {
				System.out.print("price(wts) format ==>");
				System.out.println(path);
				break;
			}
			if (mat[r - 1][c] == mat[r][c]) {
				r--;
			} else {
				c = c - wts[r - 1];
				path = price[r - 1] + "(" + wts[r-1] + ")" + " " + path;
			}
		}
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
