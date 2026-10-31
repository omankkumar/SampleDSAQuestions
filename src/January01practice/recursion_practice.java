package January01practice;

import java.util.Scanner;

public class recursion_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
        String ins = scn.nextLine();
        int div = scn.nextInt();
        int res = stringtonum(ins,0,0);
        System.out.print(res + " " + (res/div));

	}
	public static int stringtonum(String s, int sidx, int nupton)
    {
        if(sidx == s.length())
        {
            return nupton;
        }
        char ch = s.charAt(sidx);
        int val = ch - '0';
        int val1 = nupton*10 + val;
        int val2 = stringtonum(s,sidx+1,val1);
        return val2;
    }

}
