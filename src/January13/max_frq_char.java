package January13;

public class max_frq_char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaaaaaaaaaabbbbbbbbcccccccc";
		highfreq(str);
		StringBuilder sb = new StringBuilder(str);
//		sb.setCharAt(index, ch);
//		sb.charAt(index);
//		str.cha
	}
	
	public static void highfreq(String str)
	{
		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			int num = ch - 'a';
			++arr[num];
		}
		int max = 0;
		int maxidx = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] > max)
			{
				max = arr[i];
				maxidx = i;
			}
		}
		System.out.println(max);
		System.out.println((char) (maxidx + 'a'));
	}

}
