package December18;

public class Pattern5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 5;
		int stars = 1;// we need to print nos instead of stars, hence same as previous
		int spaces = n;// code but we print different values in place of stars
		int val = 1;
		for(int i=1; i<=n; i++)
		{
			//System.out.println(spaces + " " + stars);
			
			for(int s = 1; s<=spaces; s++)
			{
				System.out.print("  ");
			}
			
			int myval = val;// myval is used so the value of val is preserved
			for(int st = 1; st <= stars; st++)
			{
				System.out.print(myval + " ");
				if(st<=stars/2)
				{
					myval++;//condition on st as when st is less than star/2 printed value is to be decresed
				}
				else
				{
					myval--;
				}
			}
			spaces--;
			stars += 2;
			val++;

//			if(i <= n/2)
//			{
//				spaces--;
//				stars += 2;
//				val++;
//			}
//			else
//			{
//				spaces++;
//				stars -=2;
//				val--;
//			}
			System.out.println();
		}
	}

}
