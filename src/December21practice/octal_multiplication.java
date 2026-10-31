package December21practice;

import java.util.Scanner;

public class octal_multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		int res = 0;
		if(n1<0 && n2>0)
		{
			n1 = n1*(-1);
			for(int i = 1; i<= n2; i = oct_add(i,1) )
			{
				res = oct_add(n1,res);
			}
			System.out.println(res*(-1));
		}
		else if(n2<0 && n1>0)
		{
			n2 = n2*(-1);
			for(int i = 1; i<= n2; i = oct_add(i,1) )
			{
				res = oct_add(n1,res);
			}
			System.out.println(res*(-1));
		}
		else if(n2<0 && n1<0)
		{
			n1 = n1*(-1);
			n2 = n2*(-1);
			for(int i = 1; i<= n2; i = oct_add(i,1) )
			{
				res = oct_add(n1,res);
			}
			System.out.println(res);
		}
		else
		{
			for(int i = 1; i<= n2; i = oct_add(i,1) )
			{
				res = oct_add(n1,res);
			}
			System.out.println(res);
		}
		
		

	}
	public static int oct_add(int num1,int num2)
	{
		int sum = 0;
		int carry = 0;
		int pow =1;
		
		while((num1>0) || (num2>0) || (carry>0))// note that carry is also
		{                          // included here as addition also takes
			int rem1 = num1%10;    // place if carry is not zero.
			int rem2 = num2%10;    
			num1 = num1/10;
			num2 = num2/10;
			
			int s = rem1 + rem2 + carry;
			int rem = s%8;
			carry = s/8;
			sum = sum + rem*pow;
			pow = pow*10;
			
		}
		return sum;
	}
}
