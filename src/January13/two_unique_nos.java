package January13;

public class two_unique_nos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 9, 2, 2, 3, 1, 4, 5, 5, 6, 6, 7, 8, 8, 3, 9, 0, 0 };

		int xor = arr[0];  // for xor of 2 diff no., atleast 1 bit will be different, we work on that.
		for(int i = 1; i<arr.length; i++)
		{
			xor = xor^arr[i];
		}
		
		int bm = xor & (-xor);
		int x = 0;
		
		for(int i = 0; i<arr.length; i++)
		{
			if((bm & arr[i]) > 0)
			{
				x = x^arr[i];
			}
		}
		System.out.println(x);
		System.out.println(xor^x);
		
//		int[] a1 = new int[1000];
//		int min = arr[0];
//		int max = arr[0];
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] < min) {
//				min = arr[i];
//			}
//			if (arr[i] > max) {
//				max = arr[i];
//			}
//			a1[arr[i]]++;
//		}
//
//		for (int i = min; i <= max; i++) {
//			if (a1[i] == 1) {
//				System.out.println(i);
//			}
//		}		
	}

}
