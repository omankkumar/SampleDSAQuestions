package December27practice;

public class pascal_triange_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pascal(6);
		

	}
	public static void pascal(int n)
	{
		if(n == 0)
		{
			System.out.println(1);
			return;
		}
		pascal(n-1);
		int nck = 1;
		for(int i = 0; i<=n; i++)
		{
			System.out.print(nck + " ");
			int nckp1 = nck*(n-i)/(i+1);
			nck = nckp1;
		}
		System.out.println();
	}

}
