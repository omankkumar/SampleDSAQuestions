package January23;

public class fibonacci_dynamic_programming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		long[] qb = new long[n+1];
		System.out.println(fibM(n, qb));
	}

	public static long fibM(int n, long[] qb) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (qb[n] != 0) {
			return qb[n];
		}

		long fbm1 = fibM(n - 1, qb);
		long fbm2 = fibM(n - 2, qb);
		long fn = fbm1 + fbm2;

		qb[n] = fn;
		return fn;
	}

}
