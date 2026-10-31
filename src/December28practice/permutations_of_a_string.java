package December28practice;

import java.util.Scanner;

public class permutations_of_a_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("abc");
		int num = sb.length();
		int n = num;
		int fact = 1;
		while (n > 0) {
			fact = fact * n;
			n--;
		}
		for (int i = 0; i < fact; i++) {
			StringBuilder temp = new StringBuilder(sb);
			StringBuilder sb1 = new StringBuilder();
			for (int j = num; j >= 1; j--) {
				int index = i % j;
				sb1.append(temp.charAt(index));
				temp.deleteCharAt(index);

			}
			System.out.println(sb1);
		}
//		Scanner scn = new Scanner(System.in);    YASH KA CODE------BAKWAS PAR HACKERRANK WAALO NE LE LIYA
//		String s = scn.nextLine();
//		StringBuilder str = new StringBuilder(s);
//		int num = str.length();
//		int n1 = num;
//		int fact = 1;
//		while (n1 > 0) {
//			fact = fact * n1;
//			n1--;
//		}
//
//		for (int i = 0; i < fact; i++) {
//			int l = str.length();
//			StringBuilder sb = new StringBuilder(str);
//			StringBuilder sbb = new StringBuilder();
//			int n = i;
//			while (l > 0) {
//				int r = n % l;
//				n = n / l;
//				sbb.append(sb.charAt(r));
//				sb.deleteCharAt(r);
//				l--;
//			}
//			System.out.println(sbb);
//		}
	}

}

