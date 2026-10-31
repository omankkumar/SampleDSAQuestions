package December17;

import java.util.Scanner;

public class print_till_n {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		
		int count = num;
		while(count>=1){
			System.out.print(count + " ");
			count--;
		}
			

	}

}
