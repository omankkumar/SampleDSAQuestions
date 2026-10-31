package June03;

public class DP_Revisted_ClimbStair {
	
	public static int ClimbStair (int floor, int[] ways) {
		if(floor == 0 || floor == 1) {
			return 1;
		}
		if(ways[floor] != 0) {
			return ways[floor];
		}
		
		int fm1 = 0, fm2 = 0, fm3 = 0;
		
		if(floor - 1 >= 0)
			fm1 = ClimbStair(floor - 1, ways);
		if(floor - 2 >= 0)
			fm2 = ClimbStair(floor - 2, ways);
		if(floor - 3 >= 0)
			fm3 = ClimbStair(floor - 3, ways);
		
		ways[floor] = fm1 + fm2 + fm3;
		return ways[floor];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[] ways = new int[n + 1];
		System.out.println(ClimbStair(n, ways));
	}

}
