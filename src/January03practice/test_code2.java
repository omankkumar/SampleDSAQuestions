package January3practice;

import java.util.Scanner;

public class test_code2 {
	
	static String[] weekdays = {"mon","tue","wed","thur","fri","sat","sun"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
        int testcase = scn.nextInt();
        
        int[] arrnum = new int[testcase];
        String[] arrday = new String[testcase];
        
        for(int i = 0; i<testcase; i++)
        {
            arrnum[i] = scn.nextInt();
            arrday[i] = scn.next();
        }
        int fday=0;
        for(int i = 0; i<testcase; i++)
        {
        	for(int j = 0; j<weekdays.length; j++)
        	{
        		if(arrday[i].equals(weekdays[j]))
        		{
        			fday = j;
        			break;
        		}
        	}
        	int[] res = num_of_days(arrnum[i], fday);
        	for(int val : res)
        	{
        		System.out.print(val + " ");
        	}
        	System.out.println();
        }

	}
	
	public static int[] num_of_days(int tdays, int fday)
    {
        int temp = tdays;
        int[] daycnt = new int[7];
        temp = temp/7;
        for(int i = 0; i<7; i++)
        {
            daycnt[i] = daycnt[i]+temp;;
        }
        tdays = tdays%7;
        
        for(int i = fday;tdays>0; i++ )
        {
            daycnt[i%7] = daycnt[i%7] + 1;
            tdays--;
        }
        
        return daycnt;
    }

}
