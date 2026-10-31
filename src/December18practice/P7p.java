package December18practice;

public class P8p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int star = 1;
		for(int i =1; i<=n; i++)
		{
			for(int j =1; j<=n; j++)
			{
				if(j==i || j+i==n+1)
				{
					System.out.print(" *");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}
