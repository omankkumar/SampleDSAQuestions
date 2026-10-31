package December17;

import java.util.Scanner;

public class nth_fibonnaci_no {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int num1 = 0;
		int num2 = 1;
		int num3 = 0;
		int count = 1;
		while(count <= num)
		{
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			
			count++;
		}
		System.out.print(num1);

	}

}
