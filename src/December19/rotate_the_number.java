package December19;

public class rotate_the_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 123456;//answer is 561234
		int r = 4;
		int count = 0;
		int n = num;
		
		while(n!=0)
		{
			n = n/10;
			count++;
		}
		
		int r1 = count - r;
		int s = 0;
		int pow = 1;
		
		while(r1!=0)
		{
			int rem = num%10;
			num = num/10;
			s = s + rem*pow;
			pow = pow*10;
			r1--;
		}
		
		while(r!=0)
		{
			s = s*10;
			r--;
		}
		System.out.println(s + num);

	}

}
