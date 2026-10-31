package December19;

public class any_to_any_conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sn = 71;
		int sb = 8;
		int db = 2;
		int dn = converter(sb,sn,db);
		System.out.println("Output is " + dn);

	}
	public static int converter(int sb, int sn, int db)
	{
		int out;
		if(sb == 10)
		{
			out = decimal_to_any(sb,sn,db);
		}
		else if(db == 10)
		{
			out = any_to_decimal(sb,sn,db);
		}
		else
		{
			int out1 = any_to_decimal(sb,sn,10);
			out = decimal_to_any(10,out1,db);
		}
		return out;
	}
	public static int decimal_to_any(int sb, int sn, int db)
	{
		int num = sn;
		int pow = 1;
		int sum = 0;
		
		while(num!=0)
		{
			int rem = num%db;
			num = num/db;
			
			sum = sum + rem*pow;
			pow = pow*sb;
		}
		return sum;
	}
	public static int any_to_decimal(int sb, int sn, int db)
	{
		int num = sn;
		int pow = 1;
		int sum = 0;
		
		while(num!=0)
		{
			int rem = num%db;
			num = num/db;
			
			sum = sum + rem*pow;
			pow = pow*sb;
		}
		return sum;
	}

}
