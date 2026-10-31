package December26;

public class subsets_of_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		char[] arr =str.toCharArray();
		int n = str.length();
		int pow = 1;
		int num = 0;
		while(n!=0)
		{
			num = num + pow;
			pow = pow*2;
			n--;
		}
//		System.out.println(num);
		for(int i = 0; i<=num; i++)
		{
			String s = "";
			for(int j = 0; j<str.length(); j++)
			{
				int bm = 1<<j;
				int res = (i & bm);
				if(res !=0)
				{
					s = s + str.charAt(str.length()-1-j);
				}
			}
			String s1 = str_rev(s);
			System.out.println(s1);
		}
		
	}
  /*c
	b
	bc
	a
	ac
	ab
	abc*/
	public static String str_rev(String s)
	{
		int l = s.length();
		int lo = 0;
		int hi = s.length() - 1;
		String s1 = "";
		char[] a = s.toCharArray(); 
		while(hi>=lo)
		{
			char c = a[lo];
			a[lo] = a[hi];
			a[hi] = c;
			hi--;
			lo++;
		}
		for(int i = 0;i<a.length ;i++)
		{
			s1 = s1 + a[i];
		}
		return s1;
	}

}
