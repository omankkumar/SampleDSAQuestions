package JFebruary17;

public class string_with_no_00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ew0 = 1;
		int ew1 = 1;
		int n = 9;
		for(int i = 2; i <= n; i++) {
			int temp = ew1;
			ew1 = temp + ew0;
			ew0 = temp;
		}
		System.out.println(ew0 + ew1);
	}
}
