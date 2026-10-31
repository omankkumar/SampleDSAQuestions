package December26;

import java.util.Scanner;

public class print_substrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn = new Scanner(System.in);
//		String str = scn.nextLine();
		String str1 = "abcd";
		for(int i = 0; i< str1.length(); i++)
		{
			for(int j = i; j<str1.length(); j++)
			{
				String s = str1.substring(i, j+1);//last index is excluded in substring function, hence j+1 is used.
				System.out.println(s);
			}
			System.out.println();
		}

	}

}
