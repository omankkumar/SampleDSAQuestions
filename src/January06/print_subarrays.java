package January06;

public class print_subarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30 };
		printss(arr, 0, "");

	}

	public static void printss(int[] arr, int vidx, String ans) {
		if (vidx == arr.length) {
			System.out.println(ans);
			return;
		}
		printss(arr, vidx + 1, ans);  // arr[vidx] nahi aaya
		String ans1 = ans + " " + arr[vidx];
		printss(arr, vidx + 1, ans1);  // arr[vidx] aa gya
	}
}
