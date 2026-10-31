package January13;

import java.util.Arrays;

public class print_prime_no_fast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// long start = System.currentTimeMillis();
		// printprime(1000);
		// long end = System.currentTimeMillis();
		//
		// System.out.println(end - start);
		int[] a = { -7, -13 };
		int[] b = { 1, -5 };
		int[] A = { 4, 8, -7, -5, -13, 9, -7, 8 };
		int[] B = { 4, -15, -10, -3, -13, 12, 8, -8 };
		System.out.println(coverPoints(A, B));
	}

	public static void printprime(int n) {
		boolean[] arr = new boolean[n + 1];

		Arrays.fill(arr, true);
		arr[0] = false;
		arr[1] = false;

		for (int i = 2; i * i <= n; i++) {
			if ((arr[i] == true)) {
				// System.out.println(i + "----------");
				for (int j = i; j * i <= n; j++) {
					arr[j * i] = false;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == true) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public static int coverPoints(int[] a, int[] b) {

		int cnt = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < a[i + 1] && b[i] < b[i + 1]) {
				int s1 = a[i + 1] - a[i];
				int s2 = b[i + 1] - b[i];
				if (s1 > s2) {
					cnt = cnt + s1;
				} else {
					cnt = cnt + s1;
				}
				// continue;
			}
			if (a[i] < a[i + 1] && b[i] > b[i + 1]) {
				int s1 = a[i + 1] - a[i];
				int s2 = b[i] - b[i + 1];
				if (s1 > s2) {
					cnt = cnt + s1;
				} else {
					cnt = cnt + s1;
				}
				// continue;
			}
			if (a[i] > a[i + 1] && b[i] < b[i + 1]) {
				int s1 = a[i] - a[i + 1];
				int s2 = b[i + 1] - b[i];
				if (s1 > s2) {
					cnt = cnt + s1;
				} else {
					cnt = cnt + s1;
				}
				// continue;
			}
			if (a[i] > a[i + 1] && b[i] > b[i + 1]) {
				int s1 = a[i] - a[i + 1];
				int s2 = b[i] - b[i + 1];
				if (s1 > s2) {
					cnt = cnt + s1;
				} else {
					cnt = cnt + s1;
				}
				// continue;
			}
		}
		return cnt;
	}

}
