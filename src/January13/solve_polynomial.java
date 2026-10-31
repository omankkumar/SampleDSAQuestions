package January13;

public class solve_polynomial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(2,3);
	}
	
	public static void solve(int x, int n)
	{
		int sum = 0;
		int x1 = x;
		while(n>=0)
		{
			sum = sum + n*x1;
			n--;
			x1= x1*x;
		}
		
		System.out.println(sum);
	}

}
