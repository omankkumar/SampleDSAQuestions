package December26;

public class string_compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder str =new  StringBuilder("aaabbbbcccddeff");
		
		mod1(str);
		mod2(str);

	}
	public static void mod1(StringBuilder str)
	{
		StringBuilder sb1 =new  StringBuilder("");
		
		char temp = str.charAt(0);
		
		sb1.append(temp);
		for(int i = 0; i<str.length(); i++)
		{
			if(str.charAt(i) != temp)
			{
				temp = str.charAt(i);
				sb1.append(temp);			
			}
		}
		System.out.println(sb1);
	}
	
	public static void mod2(StringBuilder str)
	{
		StringBuilder sb1 =new  StringBuilder("");
		char temp = str.charAt(0);
		int cnt = 0;
		sb1.append(temp);
		
		for(int i = 0; i<str.length(); i++)
		{
			if(str.charAt(i) == temp)
			{
				cnt++;
			}
			else
			{
				temp = str.charAt(i);
				sb1.append(cnt);
				sb1.append(temp);
				cnt = 1;
			}
		}
		sb1.append(cnt);
		System.out.println(sb1);
	}

}
