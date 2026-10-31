package JFebruary;

public final class longest_increasing_subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		int[] mat = new int[arr.length];

		// for (int i = 0; i < arr.length; i++) {
		// int max = 1;
		// for (int j = 0; j < i; j++) {
		// if (mat[j] >= max && arr[j] < arr[i]) {
		// max = mat[j] + 1;
		// }
		// }
		// mat[i] = max;
		// }
		//
		// int max = 0;
		// for (int i = 0; i < mat.length; i++) {
		// if (mat[i] > max) {
		// max = mat[i];
		// }
		// }

		int max = 1;
		int indx = 0;
		for (int i = 0; i < arr.length; i++) {
			mat[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					mat[i] = Math.max(mat[i], mat[j] + 1);
				}
			}
			if (mat[i] > max) {
				max = mat[i];
				indx = i;
			}
		}
		display(mat);
		System.out.println();
		System.out.println(max);

		printss(arr, mat, indx, "" + arr[indx]);

	}

	public static void printss(int[] arr, int[] mat, int indx, String psf) {
		if (mat[indx] == 1) {
			System.out.println(psf);
			return;
		}
		for (int i = 0; i < indx; i++) {
			if (mat[i] == (mat[indx] - 1) && arr[i] < arr[indx]) {
				printss(arr, mat, i, arr[i] + " " + psf);
			}
		}
	}

	public static void display(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
	}
}
