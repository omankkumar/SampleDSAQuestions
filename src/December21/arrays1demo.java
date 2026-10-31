package December21;

import java.util.Scanner;

public class arrays1demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] arr = new int[5];
//		arr[0] =1 ;
//		int val = arr[4];
		
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		
		int[] arr = new int[size];
		
		for(int i = 0; i<size; i++)
		{
			arr[i]  = scn.nextInt();
		}
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		int[] arr1 = {1,2,3,4};
		for(int val : arr1)
		{
			System.out.println(val);
		}

	}

}
