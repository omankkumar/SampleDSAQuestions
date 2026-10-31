package January19;

import java.util.Arrays;

public class merge_sort {

	public static void main(String[] args) {
		
		int[] ques = { 7, 9, 8, 2, 5, 6, 1 };
		int[] c = mergeSort(ques, 0, ques.length - 1);
		System.out.println(Arrays.toString(c));

	}

	// we divide the array(from index lo to index hi) in 2 equal halfs and then
	// sort them individually, once sorted, merge the 2 sorted arrays and return
	// them. Do this process recursively till you get the complete array sorted.
	public static int[] mergeSort(int[] arr, int lo, int hi) {
		// if hi == lo, then it means we have only one element, then create a
		// new array of single element and return it.
		if (lo == hi) {
			int[] basearr = new int[1];
			basearr[0] = arr[lo];
			return basearr;
		}

		// divide the array in 2 parts.
		int mid = (hi + lo) / 2;

		// sort left hand side array
		int[] lsarr = mergeSort(arr, lo, mid);

		// sort the right hand side array.
		int[] rsarr = mergeSort(arr, mid + 1, hi);

		// merge the 2 sorted arrays.
		int[] marr = merge(lsarr, rsarr);

		// return the merged array.
		return marr;
	}
	
	// function to merge 2 sorted arrays.
	public static int[] merge(int[] one, int[] two) {
		int[] res = new int[one.length + two.length];
		int i = 0; // index for array one
		int j = 0; // index for array two
		int k = 0; // index for result array
		
		// while we have elements in both the arrays
		while (i < one.length && j < two.length) {
			if (one[i] <= two[j]) {
				res[k] = one[i];
				i++;
				k++;
			} else {
				res[k] = two[j];
				j++;
				k++;
			}
		}
		
		// if only array one remains
		while (i < one.length) {
			res[k] = one[i];
			k++;
			i++;
		}
		
		// if only array 2 remains
		while (j < two.length) {
			res[k] = two[j];
			k++;
			j++;
		}
		
		// return result array.
		return res;
	}

}
