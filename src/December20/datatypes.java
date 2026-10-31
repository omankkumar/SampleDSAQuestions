package December20;

import java.math.BigDecimal;
import java.util.Formatter.BigDecimalLayoutForm;

public class datatypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte by = (byte)128; //byte of 128 = -128
		
		System.out.println(by);
		System.out.println(Integer.toBinaryString(by));// takes input as integer
								//hence, by = -128 will go in the function
		int val = -128;
		System.out.println(Integer.toBinaryString(val));
		int myval = 128;
		System.out.println(Integer.toBinaryString(myval));
		
	}

}
