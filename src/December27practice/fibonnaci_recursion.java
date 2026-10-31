package December27practice;

public class fibonnaci_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[1000];
		for(int i = 0; i<1000; i++)
		{
			arr[i] = -1;
		}
		
		for(int i =0; i <1000; i++)
		{
			System.out.print(fib(i,arr) + " ");
		}
		

	}

	public static int fib(int n, int[] a) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			if(a[n] != -1)
			{
				return a[n];
			}
			else
			{
				a[n]  = fib(n-1, a) + fib(n-2,a);
				return a[n];
			}
		}
	}

}

