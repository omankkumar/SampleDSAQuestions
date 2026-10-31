package JFebruary03;

public class target_subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 7;
		int[] arr = { 2, 3, 5, 6, 1, 7 };
		boolean[][] mat = new boolean[arr.length + 1][target + 1];
		for (int i = 0; i < mat.length; i++) {
			mat[i][0] = true;
		}
		//boolean[][] check = new boolean[mat.length][mat[0].length];

		for (int r = 1; r < mat.length; r++) {
			for (int c = 1; c < mat[0].length; c++) {
				if (mat[r - 1][c] == true) {
					mat[r][c] = true;
				} else if ((c - arr[r - 1] >= 0) && (mat[r - 1][c - arr[r - 1]] == true)) {
					mat[r][c] = true;
				}
				//check[r][c] = true;
				// display(check);
				// System.out.println("_____________________________check");
				// display(mat);
				// System.out.println("_____________________________mat");
				// System.out.println(c - arr[r - 1]);
			}
		}

		if (mat[mat.length - 1][mat[0].length - 1] == true) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

		display(mat);
		printts(mat, arr, mat.length - 1, mat[0].length - 1, "", target);
	}

	public static void printts(boolean[][] mat, int[] arr, int r, int c, String psf, int target) {

		if (r == 0) {
			System.out.println(psf);
			return;
		}
		if (mat[r - 1][c] == true) {
			printts(mat, arr, r - 1, c, psf + "", target);
		}
		if (c - arr[r - 1] >= 0 && mat[r - 1][c - arr[r - 1]] == true) {
			printts(mat, arr, r - 1, c - arr[r - 1], psf + " " + arr[r - 1], target);
		}
	}

	public static void display(boolean[][] mat) {
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[0].length; c++) {
				if (mat[r][c] == true)
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}

	}

}
