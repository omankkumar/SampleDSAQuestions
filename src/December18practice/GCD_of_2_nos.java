package December18practice;

import java.util.Scanner;

public class GCD_of_2_nos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num1 = scn.nextInt();
		int num2 = scn.nextInt();
		int rem = 1;
		
		if(num1>num2)
		{
			while(rem!=0)
			{
				rem=num1%num2;
				num1 = num2;
				num2 = rem;
			}
			System.out.print(num1);
		}
		else
		{
			while(rem!=0)
			{
				rem=num2%num1;
				num2 = num1;
				num1 = rem;
			}
			System.out.print(num2);
		}
	}

}
