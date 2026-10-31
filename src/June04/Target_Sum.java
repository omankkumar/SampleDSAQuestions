package June04;

public class Target_Sum {

	public static boolean TS(int[] arr, int k) {

		boolean[][] mat = new boolean[arr.length + 1][k + 1];
		mat[0][0] = true;
		for (int i = 1; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i - 1][j] == true) {
					mat[i][j] = true;
				} else if (j - arr[i - 1] >= 0 && mat[i - 1][j - arr[i - 1]] == true) {
					mat[i][j] = true;
				} else {
					mat[i][j] = false;
				}
			}
		}
		if(mat[mat.length - 1][mat[0].length - 1]) {
			printsubsets(arr, mat, mat.length - 1, mat[0].length - 1, "");
		}
		return mat[mat.length - 1][mat[0].length - 1];
	}

	public static void printsubsets(int[] arr, boolean[][] mat, int r, int c, String psf) {

		if (c == 0) {
			System.out.println(psf);
			return;
		}
		
		if (mat[r - 1][c] == true) {
			printsubsets(arr, mat, r - 1, c, psf);
		}
		if (c - arr[r - 1] >= 0 && mat[r - 1][c - arr[r - 1]] == true) {
			printsubsets(arr, mat, r - 1, c - arr[r - 1], psf + arr[r - 1] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 5, 3, 1, 6 };
		System.out.println(TS(arr, 9));

	}

}
