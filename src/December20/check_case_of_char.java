package December20;

import java.util.Scanner;

public class check_case_of_char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		char ch = str.charAt(0);
		
		if(ch>='a' && ch<='z')
		{
			System.out.println("Lower Case");
		}
		else
		{
			System.out.println("Upper Case");
		}
			
		
//		String val = "12345";
//		int val1 = Integer.parseInt(val);
//		
//		System.out.println(val1);
//		System.out.println(val);
		
		

	}

}
