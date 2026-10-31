package January20;

import java.util.Arrays;

public class quick_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 5, 3, 11, 9, 7, 6 };
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	// in the given array, from index hi to lo, we will select a pivot element,
	// which in our case is arr[hi], then we will move the pivot element and
	// partition the array, from index lo to hi such that all the elements on
	// the left hand side of the pivot are smaller that pivot and all the
	// elements on the right hand side of pivot are greater than the pivot. We
	// will do this process recursively till we have sorted the array
	// completely.
	public static void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		// select the pivot as arr[hi], then call the partitioning function,
		// which returns the index of pivot in the partitioned array. Now all
		// the elements from lo to idx - 1 are less than pivot and all the
		// elemets from idx + 1 to hi are greater than the pivot.
		int idx = partitioning(arr, lo, hi, arr[hi]);

		// do the same process for left hand side array and right hand side
		// array.
		quicksort(arr, lo, idx - 1);
		quicksort(arr, idx + 1, hi);
	}

	// partitioning function. It's job is place the all the elements less than
	// pivot element before it and all the elements greater than pivot after it,
	// and then return the pivot index.
	public static int partitioning(int[] arr, int lo, int hi, int piviot) {

		// index at which unknown element is present.
		int i = lo;

		// last index where the element smaller than pivot is present.
		int j = lo;

		while (i <= hi) {
			// if arr[i] is greater than pivot then no swapping is needed, just
			// increase i.
			if (arr[i] > piviot) {
				i++;
			} else {

				// swap the elemets at i and j.
				swap(arr, i, j);

				// increase i and j by 1 each.
				// by doing this, j holds the last location at which an element
				// less than pivot is present
				i++;
				j++;
			}
		}
		return j - 1;
	}

	// swap function.
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
