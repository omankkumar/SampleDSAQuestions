package May26;

import java.util.LinkedList;

public class FireSpreadProblem {

	static class state {
		int r;
		int c;
		int t;

		state(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	public static boolean IsValid(int[][] city, int r, int c) {
		if (r < 0 || r >= city.length || c < 0 || c >= city[0].length) {
			return false;
		} else if (city[r][c] == -1) {
			return false;
		} else if(city[r][c] >= 0) {
			return false;
		} else {
			return true;
		}
	}

	// -2 is wood, -1 is water, 0 is fire
	public static void result(int[][] city, int time) {

		LinkedList<state> queue = new LinkedList<>();

		for (int i = 0; i < city.length; i++) {
			for (int j = 0; j < city[0].length; j++) {
				if (city[i][j] == 0) {
					state s = new state(i, j, 0);
					queue.addLast(s);
				}
			}
		}

		while (queue.size() > 0) {

			state rem = queue.removeFirst();

			if (city[rem.r][rem.c] > 0) {
				continue;
			} else {
				city[rem.r][rem.c] = rem.t;
			}

			System.out.println("City[" + rem.r + "][" + rem.c + "] Burn At t = " + rem.t);

			if (IsValid(city, rem.r - 1, rem.c)) {
				queue.addLast(new state(rem.r - 1, rem.c, rem.t + 1));
			}

			if (IsValid(city, rem.r + 1, rem.c)) {
				queue.addLast(new state(rem.r + 1, rem.c, rem.t + 1));
			}

			if (IsValid(city, rem.r, rem.c - 1)) {
				queue.addLast(new state(rem.r, rem.c - 1, rem.t + 1));
			}

			if (IsValid(city, rem.r, rem.c + 1)) {
				queue.addLast(new state(rem.r, rem.c + 1, rem.t + 1));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] city = { { -2, -2, 0, -2, -2, -2 }, 
						 { -2, -1, -1, -2, -1, -1 }, 
						 { -2, -2, -1, -2, -2, -2 },
						 { -2, -2, -2, -2, -1, -1 }, 
						 { -2, -1, -1, 0, -2, -2 } };
		int time = 4;
		result(city, time);

		for (int i = 0; i < city.length; i++) {
			for (int j = 0; j < city[0].length; j++) {
				if (city[i][j] == -1) {
					System.out.print("w ");
				} else {
					System.out.print(city[i][j] + " ");
				}
			}
			System.out.println();
		}

	}

}
