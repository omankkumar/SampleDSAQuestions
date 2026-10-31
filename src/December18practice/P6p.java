package December18practice;

public class P6p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int star =n/2;
		int space = 1;
		
		for(int i =1; i<=n; i++)
		{
			for(int st =1; st<= star+1; st++)
			{
				System.out.print("* ");
			}
			for(int s = 1; s<=space; s++)
			{
				System.out.print("  ");
			}
			for(int st =1; st<= star+1; st++)
			{
				System.out.print("* ");
			}
			if(i<=n/2)
			{
				star--;
				space = space + 2;
			}
			else
			{
				star++;
				space = space - 2;
			}
			System.out.println();
		}

	}

}
