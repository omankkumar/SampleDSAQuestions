package December26practice;

import java.util.Arrays;

public class target_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,0,0,0};
		Arrays.sort(a);
		
		int target = 0;
		int hi = a.length - 1;
		int lo = 0;
		
		while(hi>=lo)
		{
			int sum = a[hi] + a[lo];
			if(sum == target)
			{
				System.out.println(a[lo] + " and " + a[hi]);
				hi--;
				lo++;
			}
			else if(sum<target)
			{
				lo++;
			}
			else
			{
				hi--;
			}
		}	
	}

}
