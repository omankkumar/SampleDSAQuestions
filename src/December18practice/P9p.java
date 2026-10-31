package December18practice;

import java.util.Scanner;

public class P9p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int spaces = 2*n - 3;
		int star = 1;
		for(int i = 1; i<=n; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print(j);
				
			}
			for(int s = 1; s<= spaces; s++)
			{
				System.out.print(" ");
			}
			for(int k = i; k>=1; k--)
			{
				if(k==n)
				{
					continue;
				}
				else
				{
					System.out.print(k);
				}
			}
			spaces-=2;
			System.out.println();
		}
		
	}

}
