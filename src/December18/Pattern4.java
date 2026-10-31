package December18;

public class Pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 5;
		int stars = 1;
		int spaces = n/2;
		for(int i=1; i<=n; i++)
		{
			//System.out.println(spaces + " " + stars);
			
			for(int s = 1; s<=spaces; s++)
			{
				System.out.print("  ");
			}
			for(int st = 1; st <= stars; st++)
			{
				System.out.print("* ");
			}
			if(i <= n/2)
			{
				spaces--;
				stars += 2;
			}
			else
			{
				spaces++;
				stars -=2;
			}
			System.out.println();
		}
	}

}
