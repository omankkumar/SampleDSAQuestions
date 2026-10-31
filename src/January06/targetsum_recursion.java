package January06;

import java.util.ArrayList;

public class targetsum_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1,2,2,3,3,5,6};
		targetsum(arr, 6, 0, new ArrayList<Integer>(),0);
		//targetsumss(arr, 50, 0, "", 0);

	}

	public static void targetsum(int[] arr, int target, int vidx, ArrayList<Integer> set, int sumofset) {
		if (vidx == arr.length) {
			if ((sumofset == target)) {
				System.out.println(set);
			}
			return;
		}
		
		targetsum(arr, target, vidx + 1, set, sumofset);
		set.add(arr[vidx]);
		targetsum(arr, target, vidx + 1, set, sumofset + arr[vidx]);
		set.remove(set.size() - 1);
	}

	public static void targetsumss(int[] arr, int target, int vidx, String set, int sumofset) {
		if (vidx == arr.length) {
			if (target == sumofset) {
				System.out.println(set);
			}
			return;
		}
		targetsumss(arr, target, vidx + 1, set, sumofset);
		String set1 = set + " " + arr[vidx];
		targetsumss(arr, target, vidx + 1, set1, sumofset + arr[vidx]);
	}

}
