package January19;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6 };
		InsertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/* Function to sort array using insertion sort */
	public static void InsertionSort(int arr[]) {
		for (int i = 1; i < arr.length; ++i) {
			int val = arr[i];
			int j = i - 1;

			// arrange the elements from 0 to i - 1 such that val is at its
			// correct location. In other words, insert val at its correct location.
			while (j >= 0 && arr[j] > val) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = val;
		}
	}
}
