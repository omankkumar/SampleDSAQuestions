package JFebruary17;

public class egg_drop_problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int eggs = 3;
		int floors = 10;
		int[][] mat = new int[eggs][floors + 1];
		for(int c = 0; c < mat[0].length; c++) {
			for(int r = 0; r < mat.length; r++) {
				if(r == 0) {
					mat[r][c] = c;
				} else if(c == 0) {
					mat[r][c] = 0;
				} else {
					mat[r][c] = Integer.MAX_VALUE;
					for(int k = 1; k <= c; k++) {
						int temp = Math.max(mat[r-1][k-1], mat[r][c- k]);
						mat[r][c] = Math.min(temp + 1, mat[r][c]);
					}
				}
			}
		}
		System.out.println(mat[mat.length - 1][mat[0].length - 1]);
		display(mat);
	}
	
	public static void display(int[][] mat) {
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[0].length; c++) {
				System.out.print(mat[r][c] + " ");
			}
			System.out.println();
		}
	}
}
