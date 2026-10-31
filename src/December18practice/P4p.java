package December18practice;

public class P4p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int star =1;
		int space = n/2;
		
		for(int i =1; i<=n; i++)
		{
			for(int s =1; s<= space; s++)
			{
				System.out.print("  ");
			}
			for(int st = 1; st<=star; st++)
			{
				System.out.print("* ");
			}
			if(i<=n/2)
			{
				space--;
				star = star + 2;
			}
			else
			{
				space++;
				star = star - 2;
			}
			System.out.println();
		}

	}

}
