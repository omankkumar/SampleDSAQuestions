package December18;

public class Pattern7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		for(int i =1; i<=n;i++)
		{
			for(int st = 1; st<= n; st++)
			{
				if((st==i )||(st + i ==n+1))
				{
					System.out.print("* ");
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
