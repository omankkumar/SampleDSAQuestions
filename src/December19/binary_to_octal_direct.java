package December19;

public class binary_to_octal_direct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 101100111;
		int sum = 0;
		int pow = 1;
		
		while(num!=0)
		{
			int rem = num%1000;
			num = num/1000;
			int rem1 = converter(2,rem,10);
			
			sum = sum + rem1*pow;
			pow = pow*10;
		}
		System.out.println(sum);

	}
	public static int converter(int sb, int sn, int db)
	{
		int num1 = sn;
		int sum1 = 0;
		int pow1 = 1;
		
		while(num1!=0)
		{
			int rem2  = num1 % db;
			num1 = num1/db;
			sum1 = sum1 + rem2*pow1;
			
			pow1 = pow1*sb;
		}
		return sum1;
	}

}
