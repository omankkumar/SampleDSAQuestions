package December18;

import java.util.Scanner;

public class Pallandrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int num = input;
		int rem = 0;
		int output =0;
		while(num!=0)
		{
			rem = num%10;
			num = num/10;
			output = output*10 + rem;
		}
		if(output == input)
		{
			System.out.println("Pallendrome");
		}
		else
		{
			System.out.println("Not Pallendrome");
		}
		

	}

}
