package December24;

public class matrix_multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat1 = {{10,0,1},{0,2,20}};
		int[][] mat2 = {{0,1},{2,2},{0,3}};
		int[][] res = new int[2][2];
		
		int row1 = mat1.length;
		int col1 = mat1[0].length;
		
		int row2 = mat2.length;
		int col2 = mat2[0].length;
		
		if(col1 != row2)
		{
			System.out.println("can't multiply");
			return;
		}
		
		for(int r = 0; r < row1/*no. of rows in mat1*/ ; r++)
		{
			for(int c= 0; c < col2/*no. of columns in mat2*/; c++)
			{
				int temp = 0;
				for(int i = 0; i < row2/*no. of columns1 or rows2 for addition*/ ; i++)
				{
					temp = temp + mat1[r][i]*mat2[i][c];
					res[r][c] = temp;/*result matrix size is res[row1][columns2]*/
				}
			}
		}
		mat_display(res);

	}
	public static void mat_display(int[][] mat)
	{
		for(int row = 0; row<mat.length; row++)
		{
			for(int col = 0; col < mat[0].length; col++)
			{
				System.out.print(mat[row][col] + " ");
			}
			System.out.println();
		}
	}

}
