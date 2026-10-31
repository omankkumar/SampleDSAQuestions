package June06;

public class KnapSack0_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wts = {2,5,1,3,4};
		int[] prices = {15,14,10,45,30};
		int cap = 7;
		int[][] mat = new int[wts.length + 1][cap + 1];
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(i == 0 || j == 0) {
					mat[i][j] = 0;
				} else {
					int wo = mat[i -1][j];
					int w = 0;
					if(j - wts[i - 1] >= 0) {
						w = mat[i - 1][j - wts[i - 1]] + prices[i - 1];
					}
					
					mat[i][j] = Math.max(wo, w);
				}
			}
		}
		System.out.println(mat[mat.length - 1][mat[0].length - 1]);
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
