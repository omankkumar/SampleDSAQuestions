package January02;

public class coin_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 2, 3, 5, 6 };
		coinchange(coins, 0, 10, "");
	}

	static int cnt = 0;

	public static void coinchange(int[] coins, int src, int dest, String ways) {
		if (src == dest) {
			System.out.println((++cnt) + " " + ways);
			return;
		}
		for (int i = 0; i < coins.length; i++) {
			if (src + coins[i] <= dest) {
				String ways1 = ways + coins[i]; // same ways is for 2nd call,
												// hence ways = "2", instead of
												// "" for coin[i] = 3.
				int src1 = src + coins[i];
				coinchange(coins, src1, dest, ways1);
			}
		}
		// if(dest == 0)
		// {
		// System.out.println(ways);
		// return;
		// }
		// for(int i = 0; i<coins.length; i++)
		// {
		// if(dest - coins[i] >= 0)
		// {
		// coinchange(coins,dest-coins[i], ways + coins[i]);
		// }
		// }
	}

}
