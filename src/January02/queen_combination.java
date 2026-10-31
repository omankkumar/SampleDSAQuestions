package January02;

public class queen_combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queensc(new boolean[4], 1, 2, 0, ""); // queen ki choice
	}

	static int cnt = 0;

	public static void queensc(boolean[] box, int qno, int queens, int cp, String ans) {
		if (qno > queens) {
			System.out.println((++cnt) + ans);
			return;
		}
		for (int i = cp; i < box.length; i++) {
			if ((box[i] == false)) {
				box[i] = true;
				String asf = ans + " q" + (qno) + "-b" + i;
				queensc(box, qno + 1, queens, i, asf);

				box[i] = false;
			}
		}
	}
}
