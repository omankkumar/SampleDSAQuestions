package December26;

public class string_palandrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "nitin";  
		checkPallendrome(str);
	}
	public static void checkPallendrome(String str)
	{
		boolean palandrome = true;
		
		for(int i = 0; i<(str.length())/2; i++)
		{
			if(str.charAt(i) != str.charAt(str.length() - 1 - i))
			{
				palandrome = false;
				break;
			}
		}
		System.out.println(palandrome);
		
	}

}
