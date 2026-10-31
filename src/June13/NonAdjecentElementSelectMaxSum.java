package June13;

public class NonAdjecentElementSelectMaxSum {

	public static int findsum(int[] arr) {
		int inc = arr[0];
		int exc = 0;
		for (int i = 1; i < arr.length; i++) {
			int temp = exc;
			exc = Math.max(temp, inc);
			inc = temp + arr[i];
		}
		return Math.max(inc, exc);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 6, 10, 100, 10 };
		int res = findsum(arr);
		System.out.println(res);
	}

}
