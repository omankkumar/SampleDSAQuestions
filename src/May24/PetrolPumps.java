package May24;

public class PetrolPumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] oil = { 6, 7, 2, 9, 1, 2, 1, 7, 8, 2, 1, 2 };
		int[] dis = { 4, 5, 3, 6, 4, 5, 2, 7, 5, 3, 2, 2 };
		int so = 0;
		int st = 0;
		int end = 0;

		while (st < oil.length) {
			if (so + oil[end] >= dis[end]) {
				so = so + oil[end] - dis[end];
				end = (end + 1) % oil.length;
				if (end == st) {
					System.out.println(end);
					break;
				}
			} else {
				if (end < st) {
					System.out.println("No Solution");
					break;
				}
				so = 0;
				st = end + 1;
				end = st;
			}
		}
		if(st == oil.length) {
			System.out.println("No Solution");
		}
	}

}
