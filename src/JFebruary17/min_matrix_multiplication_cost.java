package JFebruary17;

public class min_matrix_multiplication_cost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6};
		System.out.println(mmc(arr));

	}
	
	public static int mmc(int[] arr)
	{
		int[][] strg = new int[arr.length - 1][arr.length - 1];
		
		for(int gap = 0; gap < strg.length; gap++){
			for(int i = 0, j = i + gap; j < strg.length; i++,j++){
				if(gap == 0){
					strg[i][j] = 0;
				} else if(gap == 1) {
					strg[i][j] = arr[i] * arr[j+1] * arr[j];
				} else {
					strg[i][j] = Integer.MAX_VALUE;
					for (int c = 1; c <= gap; c++) {
						int lp = strg[i][i + c - 1];
						int rp = strg[i + c][j];
						int temp = lp + rp + (arr[i] * arr[j+1] * arr[i+c]); 
						strg[i][j] = Math.min(strg[i][j], temp);//lp + rp + (st_pt * end_pt * st_pt_of_2nd_mat)
					}
				}
			}
		}
		display(strg);
		
		return strg[0][strg[0].length - 1];
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
