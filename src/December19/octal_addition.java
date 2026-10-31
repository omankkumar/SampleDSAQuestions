package December19;

public class octal_addition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 374;
		int num2 = 536;
		int sum = 0;
		int carry = 0;
		int pow =1;
		
		while((num1>0) || (num2>0) || (carry>0))// note that carry is also
		{                          // included here as addition also takes
			int rem1 = num1%10;    // place if carry is not zero.
			int rem2 = num2%10;    
			num1 = num1/10;
			num2 = num2/10;
			
			int s = rem1 + rem2 + carry;
			int rem = s%8;
			carry = s/8;
			sum = sum + rem*pow;
			pow = pow*10;
			
		}
		System.out.println(sum);
	}

}
