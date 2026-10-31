package December17;

import java.util.Scanner;

public class prime_no {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int count = 2; 
		boolean isprime = true;
//		while(count <= num/2)
//			{
//				if(num % count == 0)
//				{
//					System.out.println("Given no is composite");
//					return;					
//				}
//				count++;
//			}
//		System.out.println("Given no is prime");
		while(count <= num/2)
			{
				if(num % count == 0)
				{
					isprime = false;
					break;					
				}
				count++;
			}
		
		if(isprime == false)
		{
			System.out.println("composit no.");
		}
		else
		{
			System.out.println("prime no.");
		}
		
	}

}
