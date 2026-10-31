package JFebruary;

import java.awt.DisplayMode;

public class max_rod_cost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int[] qb = new int[n + 1];
		int[] cost = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		// System.out.println(ways(8, qb));

		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = cost[1];
		for (int i = 2; i < cost.length; i++) {
			int maxsum = 0;
			for (int j = 1; j < i; j++) {
				if (strg[j] + strg[i - j] > maxsum) {
					maxsum = strg[j] + strg[i - j];
				}
			}
			strg[i] = Math.max(maxsum, cost[i]);
		}
		display(strg);
		System.out.println();
		System.out.println(strg[strg.length - 1]);
		
		maxPrice(n, cost);

	}

	public static int ways(int rl, int[] qb) {
		if (rl == 0) {
			return 1;
		} else if (rl <= 0) {
			return 0;
		}
		if (qb[rl] != 0) {
			return qb[rl];
		}
		int cnt = 0;
		for (int i = 1; i < qb.length - 1; i++) {
			if (rl - i >= 0) {
				int cnt1 = ways(rl - i, qb);
				cnt = cnt + cnt1;
			}
		}
		qb[rl] = cnt;
		return cnt;
	}

	public static void display(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
	}
	
	public static void maxPrice(int length, int[] cost) {
		
		int[] dp = new int[length + 1];
		dp[1] = cost[1];
		
		for(int i = 2; i < cost.length; i++) {
			int max = cost[i];
			int lo = 1;
			int hi = i-1;
			while(lo <= hi) {
				max = Math.max(dp[lo] + dp[hi], max);
				lo++;
				hi--;
			}
			dp[i] = max;
		}
		
		System.out.println("------------------------------");
		display(dp);
		System.out.println();
		System.out.println(dp[length]);
	}
}
