package December20;

import java.util.Scanner;

public class Case_converter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		char ch = str.charAt(0);
		
		if(ch>='a' && ch<='z')
		{
			char CH =(char)( ch - 'a' + 'A');//typcasting is done because
			System.out.println(CH);  // ch - 'a' + 'A' is ascii no.
		}
		else if(ch>='A' && ch<='Z')
		{
			System.out.println((char)(ch + 'a' - 'A'));
		}

	}

}
