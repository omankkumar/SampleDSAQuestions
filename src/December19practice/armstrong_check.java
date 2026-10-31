package December19practice;

import java.util.Scanner;

public class armstrong_check {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // TODO Auto-generated method stub
        Scanner scn = new Scanner(System.in);
        int arn = scn.nextInt();
        int sr = scn.nextInt();
        int er = scn.nextInt();
        boolean out1 = armcheck(arn);
        System.out.println(out1);
        
        for(int i = sr; i<=er; i++)
        {
            out1 = armcheck(i);
            if(out1 == true)
            {
                System.out.print(i +" ");
            }
        }
       
       
    }
    public static boolean armcheck(int n)
    {
       int count = 0;
       int m = n;
       while(m!=0)
       {
           m= m/10;
           count++;
       }
       
       int p = n;
       int s = 0;
       
       while(p!=0)
       {
           int count1 = count;
           int rem = p%10;
           p = p/10;
           
           int r1 = 1;
           while(count1!=0)
           {
               r1 = r1*rem;
               count1--;
           }
           s = s+r1;
           
       }
       if(s == n)
       {
           return true;
       }
       else
       {
           return false;
       }
    }
}
