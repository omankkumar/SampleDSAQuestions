package JMarch10;

import java.util.ArrayList;

public class target_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		// tarsum(arr, 0, 0, 70, "");
		// tarsum(arr, 0, 70, new ArrayList<Integer>(), 0);
		System.out.println(targetsum(arr, 70, 0));

	}

	public static ArrayList<ArrayList<Integer>> targetsum(int[] arr, int tar, int vidx) {

		if (vidx == arr.length) {
			ArrayList<ArrayList<Integer>> rres = new ArrayList<>();
			ArrayList<Integer> res1 = new ArrayList<>();
			rres.add(res1);
			return rres;
		}

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<ArrayList<Integer>> sum1 = targetsum(arr, tar - arr[vidx], vidx + 1);
		ArrayList<ArrayList<Integer>> sum2 = targetsum(arr, tar, vidx + 1);

		for (int i = 0; i < sum2.size(); i++) {
			int sum = 0;
			for (int j = 0; j < sum2.get(i).size(); j++) {
				sum = sum + sum2.get(i).get(j);
			}
			if (sum == tar) {
				res.add(new ArrayList<Integer>(sum2.get(i)));
			}
		}

		for (int i = 0; i < sum1.size(); i++) {
			int sum = 0;
			for (int j = 0; j < sum1.get(i).size(); j++) {
				sum = sum + sum1.get(i).get(j);
			}
			if (sum + arr[vidx] == tar) {
				sum1.get(i).add(arr[vidx]);
				res.add(new ArrayList<Integer>(sum1.get(i)));
			}
		}

		return res;
	}

	public static void tarsum(int[] arr, int vidx, int n, int tar, String asf) {

		if (vidx == arr.length) {
			if (n == tar) {
				System.out.println(asf);
			}
			return;
		}

		tarsum(arr, vidx + 1, n, tar, asf);
		tarsum(arr, vidx + 1, n + arr[vidx], tar, asf + " " + arr[vidx]);
	}

	public static void tarsum(int[] arr, int vidx, int tar, ArrayList<Integer> set, int sos) {

		if (vidx == arr.length) {
			if (tar == sos) {
				System.out.println(set);
			}
			return;
		}

		tarsum(arr, vidx + 1, tar, set, sos);
		set.add(arr[vidx]);
		tarsum(arr, vidx + 1, tar, set, sos + arr[vidx]);
		set.remove(set.size() - 1);
	}
}
