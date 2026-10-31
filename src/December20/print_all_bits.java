package December20;

import java.util.Scanner;

public class print_all_bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn = new Scanner(System.in);
//		int num = scn.nextInt();
		int num = 754;
		int n = num;
		int pos = 0;
		
		for(int i = 0;i<=31 ; i++)
		{
			int bm = 1<<i;
			if((bm & n) >0)
			{
				pos = i;
			}
		}
		for(int j = pos; j>=0;j--)
		{
			int bm1 = 1<<j;
			int m = bm1 & n;
			if(m>0)
			{
				System.out.print(1);
			}
			else
			{
				System.out.print(0);
			}
		}
//		System.out.println(res);

	}

}
