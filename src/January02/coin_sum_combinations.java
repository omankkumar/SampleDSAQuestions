package January02;

public class coin_sum_combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {2,3,5,6};
		coincomb(coins,0,10,0,"");

	}
	
	static int cnt = 0;
	
	public static void coincomb(int[] coins,int src, int dest,int lv, String ways)
	{
		if(src == dest)
		{
			System.out.println((++cnt)+ " " +ways);
			return;
		}
		for(int i = lv; i<coins.length; i++)
		{
			if(src + coins[i] <= dest)
			{
				String ways1 = ways+coins[i]; // same ways is for 2nd call, hence ways = "2", instead of "" for coin[i] = 3.
				int src1 = src + coins[i];
				coincomb(coins, src1,dest,i,ways1);
			}
		}
	}

}
