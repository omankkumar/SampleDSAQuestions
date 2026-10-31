package December17;

import java.util.Scanner;

public class prime_no_till_n {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int i =2;
		while(i<=num)
		{
			int count = 2; 
		    int isprime = 1;
			while(count <= i/2)
				{
					if(i % count == 0)
					{
						isprime = 0;
						break;					
					}
					count++;
				}
			if(isprime == 1)
			{
				System.out.print(i + " ");
			}
			i++;
		}

	}

}
