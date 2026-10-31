package December19practice;

import java.util.Scanner;

public class two_side_rotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int num = scn.nextInt();
        
        
        int count = 0;
        int n = num;
        
        while(n!=0)
            {
                n = n/10;
                count++;
            }
        
        if(r>0)
        {   
            if(r>count)
            {
                r = count%r;
            }
            int r1 = count - r;
            int s = 0;
            int pow = 1;
            int r1a = r1;
        
            while(r1!=0)
            {
                int rem = num%10;
                num = num/10;
                s = s + rem*pow;
                pow = pow*10;
                r1--;
            }
        
            while(r!=0)
            {
                s = s*10;
                r--;
            }
            if(s==0)
            {
                for(int i=1; i<=r1a; i++)
                {
                    System.out.print("0");
                }
            }
            System.out.println(s + num);
            
        }
        else
        {
            r = r*(-1);
            if(r>count)
            {
                r = count%r;
            }
            
            int r1 = count - r;
            int s = 0;
            int pow = 1;
            int ra = r;
        
            while(r!=0)
            {
                int rem = num%10;
                num = num/10;
                s = s + rem*pow;
                pow = pow*10;
                r--;
            }
        
            while(r1!=0)
            {
                s = s*10;
                r1--;
            }
            if(s==0)
            {
                for(int i=1; i<=ra; i++)
                {
                    System.out.print("0");
                }
            }
            System.out.println(s + num);
            
        }
	}

}
