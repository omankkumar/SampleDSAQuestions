package December23practice;

public class selection_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,0,5,8};
		int index = 0;
		for(int i = 0; i<arr.length;i++)
		{
			index = min_index(arr,arr.length-1-i);
			swap(arr,index,arr.length-1-i);
		}
		for(int val : arr)
		{
			System.out.print(val + " ");
		}
	}
	public static void swap(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static int min_index(int[] a, int n)
	{
		int min_index = 0;
		for(int i = 0; i < n; i++)
		{
			if(a[i]>=a[min_index])
			{
				min_index = i;
			}
		}
		return min_index;
	}
}
