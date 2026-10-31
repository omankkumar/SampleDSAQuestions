package December21;

public class linear_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,5,4,8,7,0,10};
		int d = 12;
		
		for(int i = 0; i< arr.length; i++)
		{
			if( arr[i] == d)
			{
				System.out.println("found");
				return;
			}
		}
		System.out.println(-1);

	}

}
