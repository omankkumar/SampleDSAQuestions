package JFebruary09;

public class unbounded_knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wts = { 2, 5, 1, 3, 4 };
		int[] price = { 15, 14, 10, 45, 30 };
		int cap = 7;

		int[] arr = new int[cap + 1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < wts.length; j++) {
				if (i - wts[j] >= 0) {
					int a1 = price[j] + arr[i - wts[j]];
					arr[i] = Math.max(a1, arr[i]);
				}
			}
		}
		System.out.println(arr[arr.length - 1]);
		display(arr);
	}

	public static void display(int[] mat) {
		for (int r = 0; r < mat.length; r++) {
				System.out.print(mat[r] + " ");
			}
		}
}
