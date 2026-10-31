package December20;

import java.util.Scanner;

public class print_rt_most_set_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		
		int res = 0;
		int n = num;
		
		for(int i = 0;; i++)
		{
			int bm = 1<<i;
			res = num & (bm);
			if(res > 0)
			{
				System.out.println(i);
				break;
			}
		}

	}

}
