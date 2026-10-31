package December26practice;

import java.util.Arrays;
import java.util.Scanner;

public class target_sum_triplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] a = { 4, 3, 6, 1, 2, 0, 7, 9, 8, 5 };
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = scn.nextInt();
		}
		int target = scn.nextInt();

		Arrays.sort(a);
		// int target = 7;
		for (int i = 0; i < a.length; i++) {
			int hi = a.length - 1;
			int lo = i + 1;
			while (hi > lo) {
				int sum = a[i] + a[hi] + a[lo];
				if (sum == target) {
					System.out.println(a[i] + " " + a[lo] + " " + a[hi]);
					hi--;
					lo++;
				} else if (sum < target) {
					lo++;
				} else {
					hi--;
				}
			}
		}

	}

}
