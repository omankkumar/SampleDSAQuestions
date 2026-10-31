package December20;

import java.util.Scanner;

public class check_the_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int k = scn.nextInt();
		
		int bm = 1<<k;     //microprocessor wala funda use kar rahe hai.
		int res = bm & num;
		
		if((bm & num) == 0)
		{
			System.out.println("bit off");
		}
		else
		{
			System.out.println("bit on");
		}
		System.out.println(res);
		System.out.println(Integer.toBinaryString(res));

	}

}
