package JMarch10;

import java.util.ArrayList;

public class equisets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		equisets(arr, 1, arr[0] + " ", arr[0], "", 0);// to remove duplicates, we remove half side of the tree.
		equisets2(arr, 1, new ArrayList<Integer>(arr[0]), arr[0], new ArrayList<Integer>(), 0);
	}

	public static void equisets(int[] arr, int vidx, String set1, int sos1, String set2, int sos2) {

		if (vidx == arr.length) {
			if (sos1 == sos2) {
				System.out.println(set1 + ", " + set2);
			}
			return;
		}

		equisets(arr, vidx + 1, set1 + " " + arr[vidx], sos1 + arr[vidx], set2, sos2);
		equisets(arr, vidx + 1, set1, sos1, set2 + " " + arr[vidx], sos2 + arr[vidx]);

	}
	
	public static void equisets2(int[] arr, int vidx, ArrayList<Integer> set1, int sos1, ArrayList<Integer> set2, int sos2) {

		if (vidx == arr.length) {
			if (sos1 == sos2) {
				System.out.println(set1 + ", " + set2);
			}
			return;
		}
		
		set1.add(arr[vidx]);
		equisets2(arr, vidx + 1, set1, sos1 + arr[vidx], set2, sos2);
		set1.remove(set1.size() - 1);
		
		set2.add(arr[vidx]);
		equisets2(arr, vidx + 1, set1, sos1, set2, sos2 + arr[vidx]);
		set2.remove(set2.size() - 1);
	}
}
