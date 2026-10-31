package December21;

public class array_inverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {3,4,2,0,1};
		int[] a2 = new int[5];
		int mi = 1;
		
		for(int i = 0; i<a1.length;i++)
		{
			a2[a1[i]] = i;
		}
		for(int val : a2)
		{
			System.out.print(val + " ");
		}
		
		for(int j = 0; j<a1.length; j++)// 
		{
			if(a1[j] != a2[j])
			{
				System.out.println("not mirror inverse");
				return;
			}
		}
		System.out.println(" mirror inverse");
				

	}

}
