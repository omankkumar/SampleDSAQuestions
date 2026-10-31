package June13;

import java.util.Arrays;

public class FractionalKnapsack {

	static class item implements Comparable<item> {
		int wt;
		int val;
		double rate;

		item(int wt, int val) {
			this.wt = wt;
			this.val = val;
			this.rate = (val/ wt) ;
		}

		public int compareTo(item o) {
			if (this.rate < o.rate) {
				return -1;
			} else if (this.rate > o.rate) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static double Max(int[] wts, int[] vals, int cap) {

		item[] arr = new item[wts.length];
		for (int i = 0; i < wts.length; i++) {
			arr[i] = new item(wts[i], vals[i]);
		}
		Arrays.sort(arr);
		double price = 0;

		for (int i = arr.length - 1; i >= 0; i--) {
			item a = arr[i];
			if (cap > a.wt) {
				cap = cap - a.wt;
				price = price + a.val;
			} else if (cap < a.wt) {
				price = price + (a.rate * cap);
				break;
			}
		}
		return price;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wts = { 10, 40, 20, 30 };
		int[] vals = { 60, 40, 100, 120 };
		System.out.println(Max(wts, vals, 50));

	}

}
