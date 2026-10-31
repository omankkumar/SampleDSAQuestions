package January20;

import java.util.Arrays;

public class sort_0_1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 2, 2, 1, 1, 1, 0, 0, 1, 0, 2, 0 };
		int[] arr1 = { 0, 2, 0, 2 };

		int u = 0;
		int t = 0;
		int o = 0;
		while (u < arr.length) {
			if (arr[u] == 2) {
				u++;
			} else if (arr[u] == 1) {
				swap(arr, u, t);
				u++;
				t++;
			} else if (arr[u] == 0) {
				swap(arr, u, t);
				swap(arr, t, o);
				u++;
				t++;
				o++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
