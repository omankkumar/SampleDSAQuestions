package December29;

import java.util.ArrayList;

public class subsequence_using_arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		ArrayList<String> result = getsubsequence(str);
		
		System.out.println(result);
//		for(int i = 0; i<result.size(); i++)
//		{
//			System.out.print(result.get(i) + " ");
//		}
		

	}
	public static ArrayList<String> getsubsequence(String str)
	{
		if(str.length() == 0)
		{
			ArrayList<String> arr1 = new ArrayList<>();
			arr1.add(""); // only one sub sequence for blank, i.e., [] (blank)
			return arr1;
		}
		char ch = str.charAt(0);
		String rs = str.substring(1);
		ArrayList<String> ss_of_rs = getsubsequence(rs); 
		ArrayList<String> res = new ArrayList<>();
		for(String ss : ss_of_rs)
		{
			res.add(ss);
			res.add(ch + ss);
		}
		return res;
	}

}
