package December26;

import java.util.Scanner;

public class char_of_stringdemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello-pep-coder";
		
		Scanner scn = new Scanner(System.in);
		String str = scn.next();//only takes  a word
		String str1 = scn.nextLine(); // takes entire line with spaces
		
		String s1 = printoddchar(str);
		System.out.println(s1);
		char[] arr = str.toCharArray(); // converts string to char array.
		
		StringBuilder sb = new StringBuilder("abc");
		StringBuilder sb1 = new StringBuilder();
		sb.append("def");
		sb1.append("xyz");
		sb.setCharAt(2, 'f');
		sb.deleteCharAt(1);
		System.out.println(sb);
		System.out.println(sb1);
	}
	public static String printoddchar(String str)
	{
		String res = "";
		for(int i = 1; i<str.length(); i = i+2)
		{
			//System.out.print(str.charAt(i) + " ");
			res = res+str.charAt(i);
		}
		return res;
	}

}
