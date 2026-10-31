package December21;

public class max_of_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,11,34,12,6,43,99,0,-4,777};
		int max = arr[0];
		for(int i =1; i < arr.length; i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
			}
		}
		System.out.println(max);
		findindx(4);

	}
	public static void findindx(int val)
	{
		int[] arr1 = {1,2,3,4,5,6};
		int fi = -1;
		for(int i =0; i<arr1.length;i++)
		{
			if(arr1[i] == val)
			{
				fi = i;
			}
		}
		System.out.println(fi);
	}

}
