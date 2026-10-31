package January01practice;

import java.util.Scanner;

public class check_2_str_rev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        System.out.println(checks1s2(s1,s2,0));
    }
    
    public static boolean checks1s2(String s1, String s2, int sidx)
    {
        if(s1.length() != s2.length())
        {
            return false;
        }
        if(sidx == s1.length()/2)
        {
            return true;
        }
        if(s1.charAt(sidx) != s2.charAt(s1.length()-1 - sidx))
        {
            return false;
        }
        else
        {
            boolean check = checks1s2(s1,s2,sidx+1);
            return check;
        }
    }

}
