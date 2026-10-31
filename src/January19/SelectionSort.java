package January19;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String args[]) {
		int arr[] = { 64, 25, 12, 22, 11 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	// here, we divide the array in 2 parts, sorted and unsorted array. We find
	// the min element in the unsorted array and put it behind the sorted array,
	// then we increase the size of sorted array by 1 and decrease the size of
	// unsorted array by 1 and repeat the same process till the entire array is
	// sorted.
	public static void sort(int arr[]) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}
}
