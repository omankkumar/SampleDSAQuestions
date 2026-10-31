package December24practice;

public class DiagonalDisplay {

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int row = mat.length - 1;
		int col = mat[0].length - 1;
		int rmin = 0;
		int cmin = 0;
		int r = 0;
		int c = 0;
		boolean isDown = true;
		int cnt = 1;
		int tne = mat.length * mat[0].length;

		while (cnt <= tne) {

			if (r >= mat.length || c < 0 || r < 0 || c >= mat[0].length) {
				isDown = !isDown;
				if (r < 0) {
					r++;
				} else if (r >= mat.length) {

					r--;
				} else if (c < 0) {
					c++;
				} else if (c >= mat[0].length) {
					c--;
				}
				continue;

			} else {
				System.out.println(mat[r][c]);

				if (isDown) {
					r++;
					c--;
				} else {
					r--;
					c++;

				}
				cnt++;
			}

		}

	}

}
