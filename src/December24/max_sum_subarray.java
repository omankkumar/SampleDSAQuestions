package December24;

import java.util.Arrays;

public class max_sum_subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 97, 0, -461, -125, -404, -59, -322, -495, -288, -341, -449, -313, -192, -214, -389, -202, -183,
				-72, -416, -455, -187, -242, -416, 39, -198, -338, -465, -248, -25, -398, -97, -461, -214, -423, -407,
				-77, -190, -67, -178, -410, -160, 72, -350, -31, -85, -247, -319, -462, -303, -48, -354, -110, 17, 60,
				19, 80, -218, -28, -426, -366, -140, 50 };
		int[] arr = {0, 0, -1, 0};
		int cs = arr[0];
		int os = arr[0];
		int cstart = 0;
		int cend = 0;
		int ostart = 0;
		int oend = 0;
		// System.out.println(arr.length);

		for (int i = 1; i < arr.length; i++) {

			if (cs >= 0) {
				cs = cs + arr[i];
				cend++;
			} else {
				cs = arr[i];
				cstart = i;
				cend = i;
			}
			if (os < cs) {
				os = cs;
				ostart = cstart;
				oend = cend;
			}
		}
		System.out.print(os);
		System.out.println();
		for (int i = ostart; i <= oend; i++) {
			System.out.print(arr[i] + " ");
		}

		// int[] arr = { 1, 2, 5, -7, 2, 5 };
		//
		// int cSum = arr[0];
		// int oSum = arr[0];
		// int cstart = 0;
		// int cEnd = 0;
		//
		// int ostart = 0;
		// int oEnd = 0;
		// for (int i = 1; i < arr.length; i++) {
		//
		// if (cSum >= 0) {
		// cSum += arr[i];
		// cEnd++;
		// } else {
		// cSum = arr[i];
		// cstart = i;
		// cEnd = i;
		// }
		//
		// if (oSum < cSum) {
		// oSum = cSum;
		// ostart = cstart;
		// oEnd = cEnd;
		//
		// }
		//
		// }
		// System.out.println("Max Sum is : " + oSum);
		// for (int i = ostart; i <= oEnd; i++) {
		// System.out.print(arr[i] + " ");
		// }
		

	}

}
