package January20;

import java.util.Arrays;

public class move_zeros_to_start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0 };

		int i = 0;
		int j = 0;
		while (i < arr.length) {
			if (arr[i] == 1) {
				i++;
			}
			if (arr[i] == 0) {
				swap(arr, i, j);
				i++;
				j++;
			}
		}
		System.out.println(Arrays.toString(arr));

	}
	public static void swap(int[] arr,int i,int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
