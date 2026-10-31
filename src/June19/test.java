package June19;

import java.util.Scanner;
import java.util.*;

public class test {

	public static int findUnsortedSubarray(int[] a) {
		// write your code here.
		int[] max = new int[a.length];
		int[] min = new int[a.length];

		max[0] = a[0];
		min[a.length - 1] = a[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			max[i] = Math.max(a[i], max[i - 1]);
		}

		for (int i = a.length - 2; i >= 0; i--) {
			min[i] = Math.min(a[i], min[i + 1]);
		}

		int sp = -1;
		int ep = -1;
		for (int i = 0; i < a.length; i++) {
			if (sp == -1 && max[i] != min[i]) {
				sp = i;
			}
			if (sp != -1 && max[i] != min[i]) {
				ep = i;
			}
		}
		return ep - sp + 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input for length of array.
		int length = sc.nextInt();

		int[] arr = new int[length];

		// Input for elements of array.
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(findUnsortedSubarray(arr));

	}

	// function to display an array.
	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}
}
