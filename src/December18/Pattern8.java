package December18;

public class Pattern8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		for (int i = 0; i < n; i++) {
			int nCk = 1;
			for (int j = 0; j <= i; j++) {
				System.out.print(nCk + " ");
				int nCk1 = nCk * (i - j) / (j + 1);
				nCk = nCk1;
			}
			System.out.println();
		}
		System.out.println(-1 % 20);
	}
}
