package JMarch03;

public class recursion_revisit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 0, 1, 1, 1, 1 }, { 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1 } };
//		boolean[][] visited = new boolean[mat.length][mat[0].length];
//		floodfill_proactive(mat, visited, 0, 0, 5, 5, "");
//		floodfill_reactive(mat, visited, 0, 0, 5, 5, "");
		
/*---------------------------------------------------------------------*/
		
		int queens = 2;
		int boxes = 5;
//		boolean[] arr = new boolean[boxes];
//		queenperm(queens, arr, 0, "");
//		System.out.println(cnt1);
//		queencomb(queens, arr, 0, 0, "");
//		System.out.println(cnt2);
		queenpermBM(boxes, queens, 0, 0, "");
		System.out.println(cnt3);
	}

	static int cnt1 = 0;
	static int cnt2 = 0;
	static int cnt3 = 0;
	
	public static void floodfill_proactive(int[][] mat, boolean[][] visited, int cr, int cc, int dr, int dc,
			String asf) {

		if (cc == dc && cr == dr) {
			System.out.println(asf);
			return;
		}

		// up
		if (cr - 1 >= 0 && mat[cr - 1][cc] == 1 && visited[cr - 1][cc] == false) {
			String asf1 = asf + 'U';
			visited[cr][cc] = true;
			floodfill_proactive(mat, visited, cr - 1, cc, dr, dc, asf1);
			visited[cr][cc] = false;
		}

		// down
		if (cr + 1 < mat.length && mat[cr + 1][cc] == 1 && visited[cr + 1][cc] == false) {
			String asf1 = asf + 'D';
			visited[cr][cc] = true;
			floodfill_proactive(mat, visited, cr + 1, cc, dr, dc, asf1);
			visited[cr][cc] = false;
		}

		// left
		if (cc - 1 >= 0 && mat[cr][cc - 1] == 1 && visited[cr][cc - 1] == false) {
			String asf1 = asf + 'L';
			visited[cr][cc] = true;
			floodfill_proactive(mat, visited, cr, cc - 1, dr, dc, asf1);
			visited[cr][cc] = false;
		}

		// right
		if (cc + 1 < mat[0].length && mat[cr][cc + 1] == 1 && visited[cr][cc + 1] == false) {
			String asf1 = asf + 'R';
			visited[cr][cc] = true;
			floodfill_proactive(mat, visited, cr, cc + 1, dr, dc, asf1);
			visited[cr][cc] = false;
		}
	}

	public static void floodfill_reactive(int[][] mat, boolean[][] visited, int cr, int cc, int dr, int dc,
			String asf) {

		if (cr == dr && cc == dc) {
			System.out.println(asf);
			return;
		}

		if (cr < 0 || cc < 0 || cr > dr || cc > dc || mat[cr][cc] == 0 || visited[cr][cc] == true) {
			return;
		}

		visited[cr][cc] = true;
		floodfill_reactive(mat, visited, cr - 1, cc, dr, dc, asf + 'L');
		floodfill_reactive(mat, visited, cr, cc - 1, dr, dc, asf + 'U');
		floodfill_reactive(mat, visited, cr + 1, cc, dr, dc, asf + 'D');
		floodfill_reactive(mat, visited, cr, cc + 1, dr, dc, asf + 'R');
		visited[cr][cc] = false;
	}

	public static void queenperm(int totalq, boolean[] boxes, int qno, String asf) {

		if (qno == totalq) {
			System.out.println(asf);
			cnt1++;
			return;
		}
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				queenperm(totalq, boxes, qno + 1, asf + "queen" + (qno) + " in box" + i + " ");
				boxes[i] = false;
			}
		}
	}
	
	public static void queencomb(int tq, boolean[] boxes , int cb, int qno, String asf) {
		
		if (qno == tq) {
			System.out.println(asf);
			cnt2++;
			return;
		}
		for (int i = cb; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				queencomb(tq, boxes, i+1, qno + 1, asf + "queen" + (qno + 1) + " in box" + i + " ");
				boxes[i] = false;
			}
		}
	}
	
	public static void queenpermBM(int tbox, int tq, int boxno, int qno, String asf) {
		
		if (qno == tq) {
			System.out.println(asf);
			cnt3++;
			return;
		} 
		
		for(int i = 0; i < tbox; i++) { // total boxes to represent no. of times loop runs
			
			int bm = 1 << i;
			
			int nboxno = bm | boxno;
			int temp = boxno;
			if(nboxno > boxno) {
				boxno = nboxno;
				String asf1 = asf + "queen" + (qno) + " in box" + i + " ";
				queenpermBM(tbox, tq, boxno, qno + 1, asf1);
				boxno = temp;
			}
		}
		
	}

}
