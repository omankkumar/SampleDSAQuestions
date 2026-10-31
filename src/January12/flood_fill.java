package January12;

import java.util.ArrayList;

public class flood_fill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = { { 1, 0, 0, 1, 1 }, 
						 { 1, 0, 1, 1, 1 }, 
						 { 1, 0, 1, 0, 1 }, 
						 { 1, 1, 1, 0, 1 },
						 { 1, 0, 0, 1, 1 } };
		boolean[][] mazevisit = new boolean[maze.length][maze[0].length];
		// findpath(maze, mazevisit, 0, 0, 4, 4, "");

		// System.out.println(pathfinder(maze, mazevisit, 0, 0, 4, 4));
		floodfill2(maze, mazevisit, 0, 0, 4, 4, "");
	}

	public static ArrayList<String> pathfinder(int[][] mat, boolean[][] visit, int r, int c, int rd, int cd) {
		if ((r == rd) && (c == cd)) {
			ArrayList<String> rres = new ArrayList<>();
			rres.add("");
			return rres;
		}
		ArrayList<String> res = new ArrayList<>();
		// down
		if ((r + 1 <= rd) && (mat[r + 1][c] == 1) && (visit[r][c] == false)) {
			visit[r][c] = true;
			ArrayList<String> pun = pathfinder(mat, visit, r + 1, c, rd, cd);
			visit[r][c] = false;
			for (String s : pun) {
				res.add(s + 'D');
			}
			// return res;
		}
		// up
		if ((r - 1 >= 0) && (mat[r - 1][c] == 1) && (visit[r][c] == false)) {
			visit[r][c] = true;
			ArrayList<String> pun = pathfinder(mat, visit, r - 1, c, rd, cd);
			visit[r][c] = false;
			for (String s : pun) {
				res.add(s + 'U');
			}
			// return res;
		}
		// left
		if ((c - 1 >= 0) && (mat[r][c - 1] == 1) && (visit[r][c] == false)) {
			visit[r][c] = true;
			ArrayList<String> pun = pathfinder(mat, visit, r, c - 1, rd, cd);
			visit[r][c] = false;
			for (String s : pun) {
				res.add(s + 'L');
			}
			// return res;
		}
		// right
		if ((c + 1 <= cd) && (mat[r][c + 1] == 1) && (visit[r][c] == false)) {
			visit[r][c] = true;
			ArrayList<String> pun = pathfinder(mat, visit, r, c + 1, rd, cd);
			visit[r][c] = false;
			for (String s : pun) {
				res.add(s + 'R');
			}
			// return res;
		}
		return res;
	}

	public static void findpath(int[][] mat, boolean[][] visit, int r, int c, int rd, int cd, String path) {
		if ((r == rd) && (c == cd)) {
			System.out.println(path);
			return;
		}
		// up
		if ((mat[r][c] == 1) && (r - 1 >= 0) && (visit[r][c] == false)) {
			String path1 = path + 'U';
			visit[r][c] = true;
			findpath(mat, visit, r - 1, c, rd, cd, path1);
			visit[r][c] = false;
		}

		// down
		if ((mat[r][c] == 1) && (r + 1 <= rd) && (visit[r][c] == false)) {
			String path1 = path + 'D';
			visit[r][c] = true;
			findpath(mat, visit, r + 1, c, rd, cd, path1);
			visit[r][c] = false;
		}
		// left
		if ((mat[r][c] == 1) && (c - 1 >= 0) && (visit[r][c] == false)) {
			String path1 = path + 'L';
			visit[r][c] = true;
			findpath(mat, visit, r, c - 1, rd, cd, path1);
			visit[r][c] = false;
		}
		// right
		if ((mat[r][c] == 1) && (c + 1 <= cd) && (visit[r][c] == false)) {
			String path1 = path + 'R';
			visit[r][c] = true;
			findpath(mat, visit, r, c + 1, rd, cd, path1);
			visit[r][c] = false;
		}
	}

	public static void floodfill2(int[][] mat, boolean[][] visit, int r, int c, int rd, int cd, String path) {
		if (r == rd && c == cd) {
			System.out.println(path);
			return;
		}
		if (r < 0 || c < 0 || r > rd || c > cd || visit[r][c] == true || mat[r][c] == 0) {
			return;
		}
		visit[r][c] = true;
		floodfill2(mat, visit, r - 1, c, rd, cd, path + 'U');
		floodfill2(mat, visit, r + 1, c, rd, cd, path + 'D');
		floodfill2(mat, visit, r, c - 1, rd, cd, path + 'L');
		floodfill2(mat, visit, r, c + 1, rd, cd, path + 'R');
		visit[r][c] = false;
	}

}
