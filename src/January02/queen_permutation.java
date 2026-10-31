package January02;

public class queen_permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queenpositions(new boolean[4], 1, 2, "");

	}

	static int cnt = 0;

	public static void queenpositions(boolean[] boxes, int qno, int queens, String ans) {
		if (qno > queens) {
			System.out.println((++cnt) + ans);
			return;
		}
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;

				String asf = ans + " q" + (qno) + "-b" + i;
				queenpositions(boxes, qno + 1, queens, asf);

				boxes[i] = false;
			}
		}
	}

}
