package June15;

import java.util.*;

public class LongestConsecutiveSubsequence {

	public static void lcs(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], arr[i]);
		}

		int max = 0;
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int key = arr[i];
			if (map.containsKey(key - 1)) {
				continue;
			} else {
				int cnt = 0;
				ArrayList<Integer> temp = new ArrayList<>();
				while (map.containsKey(key)) {
					temp.add(key);
					cnt++;
					key = key + 1;
				}
				System.out.println(temp);
				if (cnt > max) {
					max = cnt;
					res = temp;
				}
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 11, 3, 5, 9, 12, 2, 6, 8, 1, 10, 15, 25, 20, 16 };
		lcs(arr);
	}

}
