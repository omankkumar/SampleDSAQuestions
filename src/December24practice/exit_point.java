package December24practice;

public class exit_point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{0,0,1,0},
					   {1,0,0,0},
					   {0,0,0,0},
					   {1,0,1,0}};
		
		int row = mat.length;
		int col = mat[0].length;
		int r = 0;
		int c = 0;
		int dir = 0;
		
		while(true)
		{
			if(dir == 0)
			{
				if(mat[r][c] == 0)
				{
					c++;
					dir = 0;
				}
				else
				{
					r++;
					dir = 1;
				}
			}
			else if(dir == 1)
			{
				if(mat[r][c] == 0)
				{
					r++;
					dir = 1;
				}
				else
				{
					c--;
					dir = 2;
				}
			}
			else if(dir == 2)
			{
				if(mat[r][c] == 0)
				{
					c--;
					dir = 2;
				}
				else
				{
					r--;
					dir = 3;
				}
			}
			else if(dir == 3)
			{
				if(mat[r][c] == 0)
				{
					r--;
					dir = 3;
				}
				else
				{
					c++;
					dir = 0;
				}
			}
			if(r == row)
			{
				r = r-1;
				break;
			}
			else if(c == col)
			{
				c = c-1;
				break;
			}
			else if(r == -1)
			{
				r = r+1;
				break;
			}
			else if(c == -1)
			{
				c = c+1;
				break;
			}
		}
		System.out.print(r + " " + c);
		
	}

}
