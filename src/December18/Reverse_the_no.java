package December18;

import java.util.Scanner;

public class Reverse_the_no {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int rem = 1;
		int res = 0;
		while(num!=0)
		{
			rem = num%10;
			num = num/10;
			res = res*10 + rem;
		}
		System.out.println(res);
	}

}