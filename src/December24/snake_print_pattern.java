package December24;

public class snake_print_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,2,3,4,5},
					   {6,7,8,9,10},
				       {11,12,13,14,15},
				       {16,17,18,19,20},
				       {21,22,23,24,25}};
		
		int row = mat.length;
		int col= mat[0].length;
		
		for(int c = 0; c < col; c++)
		{
			if(c%2 == 0)
			{
				for(int r = 0 ; r<row; r++)
				{
					System.out.print(mat[r][c] + " ");
				}
			}
			else
			{
				for(int r = row-1; r>=0; r--)
				{
					System.out.print(mat[r][c] + " ");
				}
			}
		}
	}
}
