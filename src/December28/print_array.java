package December28;

public class print_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 7, 6, 5, 4, 8, 7, 5, 6, 5, 7, 4, 7 };
		print(arr, 0);
		System.out.println();

		print2(arr, arr.length - 1);
		System.out.println();

		int max = find_max(arr, 0);
		System.out.println(max);

		int d1 = lslast(arr, 0, 7);
		System.out.println(d1);

		int d2 = ls(arr, 0, 7);
		System.out.println(d2);

		int[] arr1 = findallindex(arr, 0, 7, 0);
		for (int val : arr1) {
			System.out.print(val + " ");
		}

	}

	public static void print(int[] a, int index) {
		// if (index < 0) {
		// return;
		// }
		// print(a, index - 1);
		// System.out.print(a[index] + " ");
		if (index == a.length) {
			return;
		}
		System.out.print(a[index] + " ");
		print(a, index + 1);
	}

	public static void print2(int[] a, int index) {
		if (index < 0) {
			return;
		}
		System.out.print(a[index] + " ");
		print2(a, index - 1);
	}

	public static int find_max(int[] a, int index) {
		if (index == a.length - 1) {
			return a[index];
		}
		int val = find_max(a, index + 1);
		if (val > a[index]) {
			return val;
		} else {
			return a[index];
		}
	}

	public static int lslast(int[] a, int index, int d) {
		if (index == a.length) {
			return -1;
		}
		int val = lslast(a, index + 1, d);
		if (val == -1) {
			if (a[index] == d) {
				return index;
			} else {
				return val;
			}
		} else {
			return val;
		}
	}

	public static int ls(int[] a, int index, int d) {
		if (index == a.length - 1) {
			return -1;
		}
		if (a[index] == d) {
			return index;
		}
		int res = ls(a, index + 1, d);
		return res;
	}

	public static int[] findallindex(int[] a, int vidx, int data, int cnt) {
		if (vidx == a.length) {
			int[] res = new int[cnt];
			return res;
		}
		if (a[vidx] == data) {
			cnt++;
		}
		int[] rres = new int[cnt];
		rres = findallindex(a, vidx + 1, data, cnt);
		if (a[vidx] == data) {
			rres[cnt - 1] = vidx;
		}
		return rres;
	}

}
