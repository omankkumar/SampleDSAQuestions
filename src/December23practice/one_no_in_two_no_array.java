package December23practice;

public class one_no_in_two_no_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={1,2,3,4,5,4,3,2,1};
		int res = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			res = res^arr[i];
		}
		System.out.println(res);
	}

}
