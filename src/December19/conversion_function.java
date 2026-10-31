package December19;

public class conversion_function {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sn1 = 57;
		int sb = 10;
		int db = 2;
		
		int dn = converter(2, 111001, 10);
		System.out.println(dn);
		
		int dnB = converter(sb, sn1, db);
		System.out.println(dnB);
				

	}
	
	public static int converter(int sb, int sn, int db)
	{
		int num = sn;
		int sum = 0;
		int pow = 1;
		
		while(num!=0)
		{
			int rem  = num % db;
			num = num/db;
			sum = sum + rem*pow;
			
			pow = pow*sb;
		}
		return sum;
	}

}
