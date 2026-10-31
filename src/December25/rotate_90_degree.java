package December25;

public class rotate_90_degree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		
		transpose(mat);
		mat_display(mat);
		System.out.println();
		reverse(mat);
		mat_display(mat);
		
	}
	public static void swap(int[][] mat1, int i1, int j1, int i2, int j2)
	{
		int temp = mat1[i1][j1];
		mat1[i1][j1] = mat1[i2][j2];
		mat1[i2][j2] = temp;
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
	
	public static void transpose(int[][] mat)
	{
		int row = mat.length -1;
		int col = mat[0].length - 1;
		for(int i = 0; i<=col;i++) 
		{
			for(int j = 0; j<=row; j++)
			{
				if(i<=j)
				{
					swap(mat, i, j, j, i);
				}
			}
		}
		
	}
	
	public static void reverse(int[][] mat)
	{
		int row = mat.length -1;
		int col = mat[0].length - 1;
		for(int i = 0; i<=row/2; i++)
		{
			for(int j = 0; j<=col; j++)
			{
				swap(mat, i, j, row - i, j);
			}
		}
	}

}
