package December24;

public class spiral_print_2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] mat = /*{{1,2,3},{5,6,7},{9,10,11},{13,14,15},{16,17,18}};*/{{1,2,3,4,5},
						{6,7,8,9,10},
						{11,12,13,14,15}/*,
						{16,17,18,19,20},
						{21,22,23,24,25}*/};
		int tne = mat.length * mat[0].length;
		int cnt = 1;
		int rmin = 0;
		int rmax = mat.length - 1;
		int cmin = 0;
		int cmax = mat[0].length - 1;
		
		while(true)
		{	// left wall
			for(int r = rmin; r<=rmax; r++)
			{
				System.out.print(mat[r][cmin] + " ");
				cnt++;
			}
			if(cnt>tne)
			{
				break;
			}
			cmin++;
			
			//bottom wall
			for(int c = cmin; c<=cmax; c++)
			{
				System.out.print(mat[rmax][c] + " ");
				cnt++;
			}
			if(cnt>tne)
			{
				break;
			}
			rmax--;
			
			//right wall
			for(int r = rmax; r>=rmin; r--)
			{
				System.out.print(mat[r][cmax] + " ");
				cnt++;
			}
			if(cnt>tne)
			{
				break;
			}
			cmax--;
			
			//top wall
			for(int c= cmax; c>=cmin; c--)
			{
				System.out.print(mat[rmin][c] + " ");
				cnt++;
			}
			if(cnt>tne)
			{
				break;
			}
			rmin++;
		}
		

	}

}
