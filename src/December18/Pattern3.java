package December18;

public class Pattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0;
		int num2 =1;
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print(num1+" ");
				int num3 =num1+num2;
				num1 =num2;
				num2 = num3;
			}
			System.out.println();
		}

	}

}
