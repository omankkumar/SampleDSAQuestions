package JFebruary09;

public class longest_commen_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcd";
		String s2 = "aebd";

		int[][] mat = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					mat[i][j] = mat[i - 1][j - 1] + 1;
				} else {
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		System.out.println(mat[mat.length - 1][mat[0].length  -1]);
	}

}
