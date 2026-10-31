package January3practice;

public class lexographical_order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lexo(20, 1);
	}

	public static void lexo(int n, int src) {
		if (src >= n) {
			return;
		}
		System.out.println(src);

		for (int i = 0; i <= 9 && (src * 10 + i) < n; i++) {
			lexo(n, ((src * 10) + i));
		}
		if(src<9)
		{
			lexo(n, src + 1);
		}

	}
}
