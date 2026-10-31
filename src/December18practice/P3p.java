package December18practice;

public class P3p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int a=0, b=1, c=1;
		for(int i = 1; i<=n;i++)
		{
			for(int j = 1; j<=i;)
			{
				System.out.print(a + " ");
				c = a+b;
				a=b;
				b=c;
				j++;
			}
			System.out.println();
		}

	}

}
