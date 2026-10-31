package December20;

import java.util.Scanner;

public class turn_bit_on {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int k = scn.nextInt();
		
		 int out1 = turn_on(num,k);
		 int out2 = turn_off(num,k);
		 int out3 = toggle(num,k);
		 System.out.println(Integer.toBinaryString(out));
		 System.out.println(Integer.toBinaryString(out1));
		 System.out.println(Integer.toBinaryString(out2));
		 System.out.println(Integer.toBinaryString(out3));
		 System.out.println(out2);

	}
	public static int turn_on(int num, int k)
	{
		int biton = 1<<k;
		int res = biton | num;
		return res;
	}
	public static int turn_off(int num, int k)
	{
		int biton = 1<<k;   //for 1100, not(1100) = 0011 in system but prints 11.
		int bitoff = ~biton;
		int res = bitoff & num;
		return res;
	}
	public static int toggle(int num, int k)
	{
		int biton = 1<<k;
		int res = biton ^ num;
		return res;
	}

}
