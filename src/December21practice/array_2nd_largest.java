package December21practice;

public class array_2nd_largest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,5,2,67,34,67,23,91,63,91};
		int max = 0;
		int max2 =0;
		if(arr[0]>arr[1])
		{
			max = arr[0];
			max2 = arr[1];
		}
		else
		{
			max = arr[1];
			max2 = arr[0];
		}
		for(int i = 2; i<arr.length; i++)
		{
			if(arr[i]>max)
			{
				max2 = max;
				max = arr[i];
			}
			else if(arr[i]>max2)
			{
				if(arr[i] == max)
				{
					continue;
				}
				else
				{
					max2 = arr[i];
				}
			}
		}
		System.out.println(max2);
		System.out.println(max);

	}

}
