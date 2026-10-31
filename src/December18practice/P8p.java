package December18practice;

public class P7p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int nckp1;
		
		for(int i =0; i<=n; i++)
		{
			int nck =1;
			for(int j =0; j<=i; j++)
			{
				System.out.print(nck+" ");
				nckp1 = nck*(i-j)/(j+1);
				nck = nckp1;
			}
			System.out.println();
		}

	}

}
