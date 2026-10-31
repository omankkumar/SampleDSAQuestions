package December28practice;

public class recursion_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 7, 6, 5, 4, 8, 7, 5, 6, 5, 7, 4, 7 };

		pio(arr, 0);
		System.out.println();

		pdo(arr, 0);
		System.out.println();

		int max = find_max(arr, 0);
		System.out.println(max);

		int first_index = lsfirst(arr, 0, 7);
		System.out.println(first_index);

		int last_index = lslast(arr, 0, 7);
		System.out.println(last_index);
		
		int[] result = find_all_index(arr,0,7,0);
		for(int val : result)
		{
			System.out.print(val + " ");
		}
		System.out.println();

	}

	public static void pio(int[] a, int vidx) {
		if (vidx == a.length) {
			return;
		}
		System.out.print(a[vidx] + " ");
		pio(a, vidx + 1);
	}

	public static void pdo(int[] a, int vidx) {
		if (vidx == a.length) {
			return;
		}
		pdo(a, vidx + 1);
		System.out.print(a[vidx] + " ");
	}

	public static int find_max(int[] a, int vidx) {
		if (vidx == a.length - 1) {
			return a[vidx];
		}
		int max = find_max(a, vidx + 1);
		{
			if (max > a[vidx]) {
				return max;
			} else {
				return a[vidx];
			}
		}
	}

	public static int lsfirst(int[] a, int vidx, int data) {
		if (vidx == a.length) {
			return -1;
		}
		if (a[vidx] == data) {
			return vidx;
		} else {
			int val = lsfirst(a, vidx + 1, data);
			return val;
		}
	}

	public static int lslast(int[] a, int vidx, int data) {
		if (vidx == a.length) {
			return -1;
		}
		int val = lslast(a, vidx + 1, data);
		if (val == -1) {
			if (a[vidx] == data) {
				return vidx;
			} else {
				return -1;
			}
		} else {
			return val;
		}
	}

	public static int[] find_all_index(int[] a, int vidx, int data, int cnt) {
		if (vidx == a.length) {
			int[] res = new int[cnt];
			return res;
		}
		if (a[vidx] == data) {
			cnt++;
		}
		int[] rres = new int[cnt];
		rres = find_all_index(a, vidx + 1, data, cnt);
		if (a[vidx] == data) {
			rres[cnt - 1] = vidx;
		}
		return rres;
	}
}
