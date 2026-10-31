package December29;

import java.util.ArrayList;
import java.util.Arrays;

public class array_list_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {1,2,3,3,4};
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(2, 40); // shifts array
//		arr.add(4, 50);
//		arr.remove(3);
//		arr.set(0,90);
		for (int data : arr) {
			System.out.print(data + " ");
		}
		System.out.println();

		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		
		System.out.println();
		System.out.println(arr);
		System.out.println(ar);  // gives address of array, i.e., location of 1st element.
	}

}
