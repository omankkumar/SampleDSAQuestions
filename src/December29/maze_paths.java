package December29;

import java.util.ArrayList;

public class maze_paths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> paths = getpaths(0, 0, 2, 2);
		System.out.println(paths);

	}

	public static ArrayList<String> getpaths(int sr, int sc, int dr, int dc) {
		if ((sr == dr) && (sc == dc)) {
			ArrayList<String> res1 = new ArrayList<>();
			res1.add("");
			return res1;
		}

		ArrayList<String> res = new ArrayList<>();
		if (sc != dc) {
			ArrayList<String> pun1 = getpaths(sr, sc + 1, dr, dc);
			for (String ss : pun1) {
				res.add("h" + ss);
			}
		}
		if (sr != dr) {
			ArrayList<String> pun2 = getpaths(sr + 1, sc, dr, dc);
			for (String ss1 : pun2) {
				res.add("v" + ss1);
			}
		}
		if ((sr != dr) && (sc != dc)) {
			ArrayList<String> pun3 = getpaths(sr + 1, sc + 1, dr, dc);
			for (String ss2 : pun3) {
				res.add("d" + ss2);
			}
		}
		return res;
	}
}
