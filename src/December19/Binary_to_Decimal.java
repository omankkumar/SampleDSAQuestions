package December19;

public class Binary_to_Decimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 111001;
		int sum = 0;
		int pow = 1;
		while(num!=0)
		{
			int rem = num%10;
			num = num/10;
			sum = sum + rem*pow;
			
			pow = pow*2;
		}
		System.out.println(sum);

	}

}
