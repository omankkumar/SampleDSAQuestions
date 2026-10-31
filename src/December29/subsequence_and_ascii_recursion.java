package December29;

import java.util.ArrayList;

public class subsequence_and_ascii_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getsub("bc"));

	}
	
	public static ArrayList<String> getsub(String str)
	{
		if(str.length() == 0)
		{
			ArrayList<String> res1 = new ArrayList<>();
			res1.add("");
			return res1;
		}
		char c = str.charAt(0);
		int ch = c;		
		String ros = str.substring(1);
		ArrayList<String> ss_of_ros = getsub(ros);
		ArrayList<String> res = new ArrayList<>();
		for(String ss : ss_of_ros)
		{
			res.add(ss);
			res.add(ch + ss);
			res.add(c + ss);
		}
		return res;
	}

}
