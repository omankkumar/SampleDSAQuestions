package December23practice;

public class bubble_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,6,2,8,7,9,1,5};
		for(int i = 0; i<(arr.length-1); i++)
		{
			for(int j = 1; j<=(arr.length -1-i);j++)
			{
				if(arr[j-1]>=arr[j])
				{
					swap(arr,j);
				}
			}
		}
		for(int i = 0; i<= arr.length - 1; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	public static void swap(int[] a, int i)
	{
//		int temp = a[i];
//		a[i] = b[j];
//		b[j] = temp;
		int temp = a[i];
		a[i] = a[i-1];
		a[i-1] = temp;
	}
}
