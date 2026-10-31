package December18practice;

public class P5p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =5;
		int space = n/2;
		int val =1;
		int column = 1;
		for(int i =1; i<=n; i++)
		{
			for(int s =1; s<= space; s++)
			{
				System.out.print("  ");
			}
			
			int myval = val;
			for(int col = 1; col <= column; col++)
			{
				System.out.print(myval + " ");
				if(col <= column/2)
				{
					myval++;
				}
				else
				{
					myval--;
				}
			}
			if(i <= n/2)
			{
				space--;
				column = column + 2;
				val++;
			}
			else
			{
				space++;
				column = column - 2;
				val--;
			}
			System.out.println();
		}

	}

}
