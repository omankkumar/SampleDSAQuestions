package December26;

public class all_palandromic_substrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abacbcaba";
		for(int i = 0; i<s.length(); i++)
		{
			for(int j = i; j<s.length(); j++)
			{
				String s1 = s.substring(i , j+1);
				boolean resCheckPal = checkPal(s1);
				if(resCheckPal)
				{
					System.out.print((s1) +(" "));
				}
			}
		}
		

	}
	public static boolean checkPal(String str)
	{
		boolean IsPal = true;
		
		for(int i = 0; i<(str.length())/2; i++)
		{
			if(str.charAt(i) != str.charAt(str.length() - 1 - i))
			{
				IsPal = false;
				break;
			}
		}
		return IsPal;
	}

}
