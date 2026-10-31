package June23;

import java.util.*;

public class tester {

	static class mpq {
		PriorityQueue<Integer> pqmax;
		PriorityQueue<Integer> pqmin;

		mpq() {
			pqmax = new PriorityQueue<>(Collections.reverseOrder());
			pqmin = new PriorityQueue<>();
		}

		public void add(int data) {

			if (pqmin.size() > 0 && data < pqmin.peek()) {
				pqmin.add(data);
			} else {
				pqmax.add(data);
			}

			equalize();
		}

		public double givem() {
			if (pqmin.size() > pqmax.size()) {
				double temp = (double) (pqmin.peek());
				return temp;
			} else if (pqmin.size() < pqmax.size()) {
				double temp = (double) (pqmax.peek());
				return temp;
			} else {
				double temp1 = (double) (pqmax.peek());
				double temp2 = (double) (pqmin.peek());
				double temp = (temp1 + temp2) / 2;
				return temp;
			}
		}

		public void equalize() {
			int s1 = pqmin.size();
			int s2 = pqmax.size();
			if (s1 - s2 > 1) {
				int t = pqmin.remove();
				pqmax.add(t);
			} else if (s2 - s1 > 1) {
				int t = pqmax.remove();
				pqmin.add(t);
			}
		}
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		mpq pq = new mpq();
		for (int i = 0; i < 10; i++) {
			int num = arr[i];
			pq.add(num);
			System.out.println(pq.givem());
		}
	}

}
