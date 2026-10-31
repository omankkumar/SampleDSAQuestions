package December19;

public class decimal_to_binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 57;
		int sum = 0;
		int pow = 1;
		
		while(num!=0)
		{
			int rem  = num % 2;
			num = num/2;
			sum = sum + rem*pow;
			
			pow = pow*10;
		}
		System.out.println(sum);

	}

}
