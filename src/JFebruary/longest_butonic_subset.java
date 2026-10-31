package JFebruary;

import java.util.ArrayList;

public class longest_butonic_subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		int[] mat = new int[arr.length];

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

		int[] dat = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			dat[i] = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					dat[i] = Math.max(dat[i], dat[j] + 1);
				}
			}
		}

		int max1 = 1;
		for (int i = 0; i < mat.length; i++) {
			if (mat[i] + dat[i] - 1 > max) {
				max1 = mat[i] + dat[i] - 1;
				indx = i;
			}
		}
		display(dat);
		System.out.println();
		display(mat);
		System.out.println();
		System.out.println(max1);

		ArrayList<String> res1 = new ArrayList<>();
		ArrayList<String> res2 = new ArrayList<>();
		ArrayList<String> res = new ArrayList<>();

		printaso(res1, mat, arr, indx, arr[indx] + "");
		printdso(res2, dat, arr, indx, arr[indx] + "");

		for (int i = 0; i < res2.size(); i++) {
			String s = rev(res2.get(i));
			res2.set(i, s);
		}

		for (int i = 0; i < res1.size(); i++) {
			for (int j = 0; j < res2.size(); j++) {
				res.add(res1.get(i) + res2.get(j));
			}
		}
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res);
	}

	public static void printaso(ArrayList<String> res, int[] mat, int[] arr, int indx, String psf) {
		if (mat[indx] == 1) {
			res.add(psf + " ");
			return;
		}
		for (int i = 0; i < indx; i++) {
			if (mat[i] == (mat[indx] - 1) && arr[i] < arr[indx]) {
				printaso(res, mat, arr, i, arr[i] + " " + psf);
			}
		}
	}

	public static void printdso(ArrayList<String> res, int[] dat, int[] arr, int indx, String psf) {
		if (dat[indx] == 1) {
			res.add(psf + " ");
			return;
		}

		for (int i = indx; i < dat.length; i++) {
			if (dat[i] == (dat[indx] - 1) && arr[i] < arr[indx]) {
				printdso(res, dat, arr, i, arr[i] + " " + psf);
			}
		}
	}

	public static String rev(String str) {
		String revs = "";
		String temp = "";
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != ' ') {
				temp = temp + str.charAt(i);
			} else {
				revs = temp + " " + revs;
				temp = "";
			}
		}
		//revs = temp + " " + revs;
		return revs;
	}

	public static void display(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
	}
}
