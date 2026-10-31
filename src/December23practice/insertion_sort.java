package December23practice;

public class insertion_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,6,2,8,7,9,1,5};
		
		for(int i = 0; i<arr.length; i++)
		{
			int val = arr[i];
			int hole = i;
			while(hole>0 && arr[hole - 1]<val)
			{
				arr[hole] = arr[hole-1];
				hole--;
			}
			arr[hole] = val; 
		}
		for(int myval : arr)
		{
			System.out.print(myval + " ");
		}
	}
}
