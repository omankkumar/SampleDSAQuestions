package December26practice;

import java.util.Scanner;

public class subsets_of_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
//		int size = scn.nextInt();
//		int[] a = new int[size];
//		for (int i = 0; i < size; i++) {
//			a[i] = scn.nextInt();
//		}
		int[] a = {2,3,4};
		int n = a.length;
		int pow = 1;
		int num = 0;
		while (n != 0) {
			num = num + pow;
			pow = pow * 2;
			n--;
		}
		// System.out.println(num);
		for (int i = 0; i <= num; i++) {
			System.out.print("[");
			for (int j = 0; j < a.length; j++) {
				int bm = 1 << j;
				int res = (i & bm);
				int cnt = 0;
				if (res != 0) {
					System.out.print(a[j] + " ");
					cnt++;
				}
			}
			System.out.println("]");
		}

	}

}
