package JFebruary03;

import java.util.ArrayList;

public class coin_change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int target = 7;
		int[] arr = new int[target + 1];
		arr[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			int cnt2 = 0;
			int cnt3 = 0;
			int cnt5 = 0;

			if (i - 2 >= 0) {
				cnt2 = arr[i - 2];
			}
			if (i - 3 >= 0) {
				cnt3 = arr[i - 3];
			}
			if (i - 5 >= 0) {
				cnt5 = arr[i - 5];
			}

			int cnt = cnt2 + cnt3 + cnt5;
			arr[i] = cnt;
		}
		display(arr);
		combination(7);
	}

	public static void combination(int target) {
		int arr[] = new int[target + 1];
		//ArrayList<String> res = new ArrayList<>();
		arr[0] = 1;
		int[] coins = { 2, 3, 5 };
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (j - coins[i] >= 0) {
					arr[j] = arr[j] + arr[j - coins[i]];
				}
			}
		}
		display(arr);
	}

	public static void display(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
}
