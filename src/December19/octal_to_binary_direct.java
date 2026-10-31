package December19;

public class octal_to_binary_direct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 547;
		int sum = 0;
		int n = num;
		int pow = 1;
		
		while(n!=0)
		{
			int rem = n % 10;
			n = n/10;
			int rem1 = converter(10,rem,2);
			
			sum = sum + rem1*pow;
			
			pow = pow*1000;
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
