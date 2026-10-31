package December18practice;

public class P2p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int count = 1;
		for(int i =1; i<=n; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print(count + " ");
				count++;
			}
			System.out.println();
		}

	}

}
