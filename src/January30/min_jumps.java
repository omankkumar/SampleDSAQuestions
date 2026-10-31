package January30;

public class min_jumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 0, 0, 2, 2, 4, 0, 3, 1, 2, 0, 1 };
		// { 3, 3, 0, 1, 2, 6 };

		int[] arr1 = { 13055, 19141, 12848, 11888, 1185, 9905, 3984, 14772, 18935, 6844, 9851, 13695, 17955, 16359,
				14969, 6200, 13436, 16940, 13893, 1639, 3233, 11861, 13475, 11963, 8193, 3413, 10952, 8585, 13807, 6320,
				4507, 1743, 454, 7983, 9677, 8348, 2496, 4585, 11022, 9103, 1096, 6770, 6745, 4350, 2334, 13024, 2738,
				9444, 1028, 5337, 2446, 272, 5799, 7397, 15000, 4848, 16772, 12860, 11773, 196, 3187, 14016, 1314, 1684,
				19858, 2598, 16111, 10577, 1643, 12252, 5835, 2819, 17898, 18210, 799, 5010, 19937, 1285, 9693, 18155,
				484, 9184, 7212, 3474, 14630, 18418, 10108, 1735, 3940, 2877, 18007, 14731, 10133, 10470, 15396, 7464,
				6936, 261 };
		Integer[] steps = new Integer[arr.length];

		steps[steps.length - 1] = 0;

		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] == 0) {
				steps[i] = null;
			} else {
				Integer min = Integer.MAX_VALUE;// 2147483647
				for (int j = 1; j <= arr[i] && i + j < arr.length; j++) {
					if (steps[i + j] == null) {
						continue;
					} else if (steps[i + j] < min) {
						min = steps[i + j];
					}
				}
				if (min == Integer.MAX_VALUE) {
					steps[i] = null;
				} else {
					steps[i] = min + 1;
				}
			}

		}
		// for(int i = arr.length - 2; i >=0; i--)
		// {
		// for(int j = i+1; j<= i + arr[i] && j < arr.length; j++)
		// {
		// if(steps[j] != null)
		// {
		// steps[i] = steps[i] == null?
		// steps[j]+1 :
		// Math.min(steps[i], steps[j] + 1);
		// }
		// }
		// }

		// System.out.println(steps[0]);
//		display(steps);
//		System.out.println();
//		totalways(arr);
		
		totalways(arr1);
	}

	public static void totalways(int[] arr) {
		Integer[] ways = new Integer[arr.length];
		// { 3, 0, 0, 2, 2, 4, 0, 3, 1, 2, 0, 1 };
		// { 3, 3, 0, 1, 2, 6 };
		ways[ways.length - 1] = 1;

		for (int i = ways.length - 2; i >= 0; i--) {
			if (arr[i] == 0) {
				ways[i] = 0;
			}
			int sum = 0;
			for (int j = i + 1; (j <= i + arr[i]) && (j < arr.length); j++) {
				sum = sum + ways[j];
			}
			ways[i] = sum;
		}
		display(ways);
		 System.out.println(ways[0]);
	}

	public static void display(Integer[] mat) {
		for (int j = 0; j < mat.length; j++) {
			System.out.print(mat[j] + " ");
		}
	}
}
