package December19practice;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        int r = scn.nextInt();
	        
	        
	        
	        System.out.println(fact);

	}
	public static int fact(int no)
	{
		int fact = 1;
        
        while(n!=0)
        {
            fact = fact*n;
            n--;
        }
        return fact;
	}

}
