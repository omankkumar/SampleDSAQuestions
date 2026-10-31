package June15;

import java.util.*;

public class PrintCommenElements1and2 {

	public static void PCE2(int[] a1, int[] a2) {
		HashMap<Integer, Integer> fmap1 = new HashMap<>();
		HashMap<Integer, Integer> fmap2 = new HashMap<>();

		for (int i = 0; i < a1.length; i++) {
			int key = a1[i];
			if (fmap1.containsKey(key)) {
				fmap1.put(key, fmap1.get(key) + 1);
			} else {
				fmap1.put(key, 1);
			}
		}

		for (int i = 0; i < a1.length; i++) {
			int key = a2[i];
			if (fmap2.containsKey(key)) {
				fmap2.put(key, fmap2.get(key) + 1);
			} else {
				fmap2.put(key, 1);
			}
		}

		ArrayList<Integer> arr = new ArrayList<>(fmap1.keySet());
		for (int i = 0; i < arr.size(); i++) {
			int key = arr.get(i);
			int v1 = Integer.MAX_VALUE;
			int v2 = Integer.MAX_VALUE;

			if (fmap1.containsKey(key)) {
				v1 = fmap1.get(key);
			}

			if (fmap2.containsKey(key)) {
				v2 = fmap2.get(key);
			}

			if (v1 != Integer.MAX_VALUE && v2 != Integer.MAX_VALUE) {
				int val = Math.min(v1, v2);
				for (int j = 0; j < val; j++) {
					System.out.print(key + " ");
				}
			}
		}

	}

	public static void PCE1(int[] a1, int[] a2) {
		
		HashMap<Integer, Integer> fmap1 = new HashMap<>();
		for (int i = 0; i < a1.length; i++) {
			int key = a1[i];
			if (fmap1.containsKey(key)) {
				fmap1.put(key, fmap1.get(key) + 1);
			} else {
				fmap1.put(key, 1);
			}
		}
		
		for(int i = 0; i < a2.length; i++) {
			int key = a2[i];
			if(fmap1.containsKey(key)) {
				System.out.print(key + " ");
				fmap1.remove(key);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 2, 1, 5, 1, 3, 2, 1 };
		int[] arr2 = { 4, 5, 2, 1, 2, 1, 2 };

		PCE1(arr1, arr2);
		PCE2(arr1, arr2);
	}

}
