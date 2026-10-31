package June13;

import java.util.Arrays;

public class ActivitySelection {

	static class pair implements Comparable<pair> {
		int sp;
		int ep;

		pair(int sp, int ep) {
			this.sp = sp;
			this.ep = ep;
		}
		
		public int compareTo(pair other) {
			return this.ep - other.ep;
		}
	}

	public static int max(int[] sp, int[] ep) {

		pair[] arr = new pair[sp.length];
		for (int i = 0; i < sp.length; i++) {
			arr[i] = new pair(sp[i], ep[i]);
		}

		Arrays.sort(arr);

		int cnt = 1;
		int s = arr[0].sp;
		int e = arr[0].ep;
		String psf = "[" + s + ":" + e + "]";
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].sp >= e) {
				cnt++;
				s = arr[i].sp;
				e = arr[i].ep;
				psf = psf + "[" + s + ":" + e + "]";
			}
		}
		System.out.println(psf);
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sp = { 3, 0, 1, 8, 5, 5 };
		int[] ep = { 4, 6, 2, 9, 9, 7 };

		System.out.println(max(sp, ep));
	}

}
