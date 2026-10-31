package January3practice;

import java.util.ArrayList;
import java.util.Scanner;

public class test_code {

	public static void main(String[] args) {
		
		ArrayList<String> res = mazepaths(0,0,2,2);
		//System.out.println(res);
		System.out.println(checkpar("ok)mk",0, ""));

	}
	
	public static boolean checkpar(String s,int sidx, String temp)
    {
        if(sidx == s.length())
        {
        	if(temp.length() == 0)
        	{
        		return true;
        	}
        	return false;
        }
        char ch = s.charAt(sidx);
        if(ch == '(' || ch == '{' || ch == '[')
        {
            String temp1 = temp + ch;
            boolean check1 = checkpar(s,sidx+1,temp1);
            return check1;
        }
        if((ch == ')' || ch == '}' || ch == ']')&&(temp.length()>1))
        {
            if((ch - temp.charAt(temp.length() - 1) == 2) ||(ch - temp.charAt(temp.length() - 1) == 1))
            {
                String temp2 = temp.substring(0,temp.length()-1);
                boolean check2 = checkpar(s,sidx+1,temp2);
                return check2;
            }
            else
            {
                return false;
            }
        }
        boolean check3 = checkpar(s,sidx+1,temp);
        return check3;
    }
	
	public static ArrayList<String> mazepaths(int sr, int sc, int dr, int dc)
	{
		if(sc == dc && sr == dr)
		{
			ArrayList<String> res1 = new ArrayList<>();
			res1.add("");
			return res1;
		}
		ArrayList<String> res = new ArrayList<>();
		for(int i = 1; i<=dc && dc-sc>=i; i++)
		{
			ArrayList<String> pun = mazepaths(sr,sc+i,dr,dc);
			for(int j = 0; j<pun.size(); j++)
			{
				res.add("H" + i + pun.get(j));
			}
		}
		for(int i = 1; i<=dr && dr-sr>=i; i++)
		{
			ArrayList<String> pun = mazepaths(sr+i,sc,dr,dc);
			for(int j = 0; j<pun.size(); j++)
			{
				res.add("V" + i + pun.get(j));
			}
		}
		for(int i = 1; i<=dc && i<=dr && dc-sc>=i && dr-sr>=i; i++)
		{
			ArrayList<String> pun = mazepaths(sr+i,sc+i,dr,dc);
			for(int j = 0; j<pun.size(); j++)
			{
				res.add("D" + i + pun.get(j));
			}
		}
		return res;
	}


}

