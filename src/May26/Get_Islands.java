package May26;

import java.util.*;

public class Get_Islands {

	static class helper {
		int r;
		int c;

		helper(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static boolean IsValid(boolean[][] visited, int[][] ocean, int r, int c) {

		if (r < 0 || r >= ocean.length || c < 0 || c >= ocean[0].length) {
			return false;
		} else if (ocean[r][c] == 0) {
			return false;
		} else if (visited[r][c] == true) {
			return false;
		} else {
			return true;
		}
	}

	public static String finder(int r, int c, boolean[][] visited, int[][] ocean) {
		String ans = "";
		LinkedList<helper> queue = new LinkedList<>();
		queue.add(new helper(r, c));

		while (queue.size() > 0) {
			helper rem = queue.removeFirst();

			if (visited[rem.r][rem.c] == true) {
				continue;
			} else {
				visited[rem.r][rem.c] = true;
			}

			ans = ans + "[" + rem.r + "][" + rem.c + "] ";

			if (IsValid(visited, ocean, rem.r - 1, rem.c) == true) {
				queue.addLast(new helper(rem.r - 1, rem.c));
			}

			if (IsValid(visited, ocean, rem.r + 1, rem.c) == true) {
				queue.addLast(new helper(rem.r + 1, rem.c));
			}

			if (IsValid(visited, ocean, rem.r, rem.c - 1) == true) {
				queue.addLast(new helper(rem.r, rem.c - 1));
			}

			if (IsValid(visited, ocean, rem.r, rem.c + 1) == true) {
				queue.addLast(new helper(rem.r, rem.c + 1));
			}
		}
		return ans;
	}

	public static ArrayList<String> Find_Islands(int[][] ocean) {
		ArrayList<String> res = new ArrayList<>();
		boolean[][] visited = new boolean[ocean.length][ocean[0].length];
		for (int i = 0; i < ocean.length; i++) {
			for (int j = 0; j < ocean[0].length; j++) {
				visited[i][j] = false;
			}
		}
		for (int i = 0; i < ocean.length; i++) {
			for (int j = 0; j < ocean[0].length; j++) {
				if (visited[i][j] == false && ocean[i][j] == 1) {
					String ans = finder(i, j, visited, ocean);
					res.add(ans);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] ocean = { { 1, 1, 0, 1, 1 }, 
						  { 1, 0, 0, 0, 0 }, 
						  { 0, 1, 1, 1, 1 }, 
						  { 1, 0, 1, 0, 1 },
						  { 1, 0, 0, 0, 1 } };

		ArrayList<String> res = Find_Islands(ocean);
		System.out.println(res);
		System.out.println(res.size());

	}

}
