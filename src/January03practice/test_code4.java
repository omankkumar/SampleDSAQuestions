package January3practice;

import java.util.Scanner;

public class test_code4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int testcase = scn.nextInt();

		for (int i = 0; i < testcase; i++) {
			int n = scn.nextInt();
			long k = scn.nextLong();

			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scn.nextInt();
			}
			long sum = 0;

			for (int j = 0; j < n; j++) {
				sum = sum + arr[j];
			}
			
			int[] arrb = new int[2 * n];
			for (int l = 0; l < 2 * n; l++) {
				arrb[l] = arr[l % n];
			}

			if (sum <= 0) {
				System.out.println(findmax(arrb));
			}
			if (sum > 0) {
				System.out.println(findmax(arrb) + sum*(k-2));
			}
		}
	}

	public static long findmax(int[] a) {
		long cs = a[0];
		long os = a[0];

		for (int i = 1; i < a.length; i++) {
			if (cs >= 0) {
				cs = cs + a[i];
			} else {
				cs = a[i];
			}
			if (cs >= os) {
				os = cs;
			}
		}
		return os;
	}
}
