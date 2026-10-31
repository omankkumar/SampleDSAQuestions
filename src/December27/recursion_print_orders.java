package December27;

public class recursion_print_orders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fpd(5);
		System.out.println();
		fpi(5);
		System.out.println();
		fpdi(5);
		System.out.println();
		evenodd(8);
		System.out.println();
		System.out.println(power(3, 4));
		
		
		test(3);

	}

	public static void fpd(int x) {
		if (x == 0) {
			return; // base case for final return.
		}
		System.out.print(x + " ");
		fpd(x - 1); // x-1 ko mann kar x ke liye chala diya.
	}

	public static void fpi(int x) {
		if (x == 0) {
			return;// base case for final return, hame 0 print toh karana he
					// nahi, toh return kara do.
		}
		fpi(x - 1);// pehle call karo fir print karao kyuki order increasing
					// hai.

		System.out.print(x + " ");// jabki decreasing mein pehle print fir call.

	}

	public static void fpdi(int x) {
		if (x == 1) {
			System.out.print(x + " ");// base case
			return;
		}
		System.out.print(x + " "); // pre-area, i.e., work is done before
									// calling
		fpdi(x - 1);
		System.out.print(x + " "); // post-area, i.e., work is done after
									// calling,i.e., while returning.
	}

	public static void evenodd(int x) {
		if (x <= 0) {
			return;
		}
		// System.out.print(x + " ");
		// evenodd(x - 2);
		// System.out.print((x - 1) + " ");

		if (x % 2 == 0) {
			System.out.print(x + " ");
		}
		evenodd(x - 1);
		if (x % 2 != 0) {
			System.out.print(x + " ");
		}
	}

	public static int power(int x, int n) {
		// if(n == 0)
		// {
		// return 1;
		// }
		// return (power(x,n-1) * x);
		if (n == 0) {
			return 1;
		}
		int xpnm1 = power(x, n - 1);
		int xpn = xpnm1 * x;
		return xpn;
	}

	public static void test(int n) {
		if (n == 0) {
			return;
		}
		System.out.print(n + " ");
		test(n - 1);
		System.out.print(n + " ");
		test(n - 1);
		System.out.print(n + " ");
	}
}
