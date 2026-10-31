package December23practice;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[] arr = { 4, 3, 6, 2, 8, 7, 9, 1, 5 };

		for (int i = 0; i <= arr.length - 1; i++) {
			int val = arr[i];
			for (int j = 0; j <= i; j++) {
				int index = 0;
				for (int k = 0; k <= j; k++) {
					if (arr[k] > val) {
						index = k;
						break;
					}
				}
				for (int l = j; l < index; l--) {
					arr[l] = arr[l - 1];
				}
				arr[index] = val;
			}
		}
		for(int myval : arr)
		{
			System.out.print(myval + " ");
		}

	}

}
