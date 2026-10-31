package December18;

public class Pattern6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int stars = n/2 +1;
		int spaces = 1;
		for(int i = 1; i<= n; i++)
		{
			for(int st =1 ;st <= stars; st++)
			{
				System.out.print("* ");
			}
			for(int s = 1; s<= spaces; s++)
			{
				System.out.print("  ");
			}
			for(int st =1 ;st <= stars; st++)
			{
				System.out.print("* ");
			}
			if(i<=n/2)
			{
				stars--;
				spaces+=2;
			}
			else
			{
				stars++;
				spaces-=2;
			}
			System.out.println();
		}

	}

}
