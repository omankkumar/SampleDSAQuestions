package December19;

public class octal_subtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 1000;
		int num2 = 1;
		int borrow = 0;
		int diff = 0;
		int pow = 1;
		if(num1>num2)
		{
			while(num2!=0 || num1!=0)
			{
				int rem1 = num1%10;
				int rem2 = num2%10;
				num1 = num1/10;
				num2 = num2/10;
				
				int r;
				if(rem1>rem2)
				{
					r = rem1-rem2 - borrow;
					borrow = 0;
				}
				else
				{
					r = 8 + rem1 - rem2 - borrow;
					borrow =1;
				}
				diff = diff + r*pow;
				pow = pow*10;
			}
			System.out.println(diff);

		}
				
		else
		{
			int n = num1;
			num1=num2;
			num2 = n;
			
			while(num2!=0 || num1!=0)
			{
				int rem1 = num1%10;
				int rem2 = num2%10;
				num1 = num1/10;
				num2 = num2/10;
				
				int r;
				if(rem1>rem2)
				{
					r = rem1-rem2 - borrow;
				}
				else
				{
					r = 8 + rem1 - rem2 - borrow;
					borrow =1;
				}
				diff = diff + r*pow;
				pow = pow*10;
			}
			System.out.println(diff*(-1));
		}

	}

}