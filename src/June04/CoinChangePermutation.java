package June04;

import java.util.LinkedList;

import June04.CoinChangeCombination.pair;

public class CoinChangePermutation {

	public static void cc(int[] arr, int n) {
		int[] strg = new int[n + 1];
		strg[0] = 1;

		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i - arr[j] >= 0) {
					strg[i] = strg[i] + strg[i - arr[j]];
				}
			}
		}
		System.out.println(strg[strg.length - 1]);

		for (int i = 0; i < strg.length; i++) {
			System.out.print(strg[i] + " ");
		}
		System.out.println();
	}

	public static void printperms(int[] arr, int val) {

		LinkedList<pair> queue = new LinkedList<>();
		pair st = new pair(0, "");

		queue.addLast(st);
		while (queue.size() > 0) {

			pair rem = queue.removeFirst();

			if (rem.sum == val) {
				System.out.println(rem.psf);
			} else {
				for (int i = 0; i < arr.length; i++) {
					if (rem.sum + arr[i] <= val) {
						queue.addLast(new pair(rem.sum + arr[i], rem.psf + arr[i]));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 5, 6 };
		cc(arr, 7);
		printperms(arr, 7);
	}

}
