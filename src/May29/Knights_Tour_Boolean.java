package May29;

import java.util.ArrayList;

public class Knights_Tour_Boolean {

	public static boolean CanMove(boolean[][] mat, int i, int j) {
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
			return false;
		} else if (mat[i][j] == true) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean Tour(boolean[][] mat, int r, int c, int cnt, ArrayList<String> ans) {

		if (cnt == (mat.length * mat[0].length) - 1) {
			//mat[r][c] = true;
			System.out.println(r + " " + c);
			return true;
		}
		int i = 0;
		int j = 0;

		mat[r][c] = true;
		ans.add(r + " " + c);
		cnt++;

		// dir1
		i = r - 2;
		j = c + 1;
		if (CanMove(mat, i, j)) {
			boolean c1 = Tour(mat, i, j, cnt, ans);
			if (c1 == true) {
				return true;
			}
		}

		// dir2
		i = r - 1;
		j = c + 2;
		if (CanMove(mat, i, j)) {
			boolean c1 = Tour(mat, i, j, cnt, ans);
			if (c1 == true) {
				return true;
			}
		}

		// dir3
		i = r + 1;
		j = c + 2;
		if (CanMove(mat, i, j)) {
			boolean c1 = Tour(mat, i, j, cnt, ans);
			if (c1 == true) {
				return true;
			}
		}

		// dir4
		i = r + 2;
		j = c + 1;
		if (CanMove(mat, i, j)) {
			boolean c1 = Tour(mat, i, j, cnt, ans);
			if (c1 == true) {
				return true;
			}
		}

		// dir5
		i = r + 2;
		j = c - 1;
		if (CanMove(mat, i, j)) {
			boolean c1 = Tour(mat, i, j, cnt, ans);
			if (c1 == true) {
				return true;
			}
		}

		// dir6
		i = r + 1;
		j = c - 2;
		if (CanMove(mat, i, j)) {
			boolean c1 = Tour(mat, i, j, cnt, ans);
			if (c1 == true) {
				return true;
			}
		}

		// dir7
		i = r - 1;
		j = c - 2;
		if (CanMove(mat, i, j)) {
			boolean c1 = Tour(mat, i, j, cnt, ans);
			if (c1 == true) {
				return true;
			}
		}

		// dir8
		i = r - 2;
		j = c - 1;
		if (CanMove(mat, i, j)) {
			boolean c1 = Tour(mat, i, j, cnt, ans);
			if (c1 == true) {
				return true;
			}
		}

		mat[r][c] = false;
		ans.remove(ans.size() - 1);
		return false;

	}

	public static boolean KT(boolean[][] mat, int r, int c) {
		ArrayList<String> ans = new ArrayList<>();
		return Tour(mat, r, c, 0, ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] mat = new boolean[5][5];
		
		System.out.println(KT(mat, 2, 1));
		DisPlay(mat);
	}

	public static void DisPlay(boolean[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
