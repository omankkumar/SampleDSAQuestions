package December21;

public class binar_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7};
		int found = -1;
		int d =1;
		int lo = 0;
		int hi = arr.length-1 ;
		while(/*hi!=lo*/lo<=hi)
		{
			int mid = (hi + lo)/2;
			if(arr[mid] == d)
			{
				found = mid;
				break;
			}
			else
			{
				if(arr[mid]>d)
				{
					hi = mid-1;
				}
				if(arr[mid]<d)
				{
					lo = mid+1;
				}
			}
			
		}
		System.out.println(found);

	}

}
