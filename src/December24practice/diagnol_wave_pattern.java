package December24practice;

public class diagnol_wave_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,2,3,4,5},
					   {6,7,8,9,10},
					   {11,12,13,14,15},
					   {16,17,18,19,20},
					   {21,22,23,24,25}};  
		int row = mat.length - 1;
		int col = mat[0].length - 1;
		int rmin = 0;
		int cmin = 0;
		int rmax = 0;
		int cmax = 0;
		int sum = 0;
		int sum_max = row + col;
		while(sum<=sum_max)
		{
			if(sum<sum_max/2)
			{
				if(sum%2 == 0)
				{
					int rp = rmin;
					int cp = cmax;
					while(rp<=rmax && cp>=cmin)
					{
						System.out.print(mat[rp][cp] + " ");
						rp++;
						cp--;
					}
					if(rmax < row)
					{
						rmax++;
					}
					if(cmax < col)
					{
						cmax++;
					}
				}
				else
				{
					int rp = rmax;
					int cp = cmin;
					while(rp>=rmin && cp<=cmax)
					{
						System.out.print(mat[rp][cp] + " ");
						rp--;
						cp++;
					}
					if(rmax < row)
					{
						rmax++;
					}
					if(cmax < col)
					{
						cmax++;
					}
				}
			}
			else
			{
				if(sum%2 == 0)
				{
					int rp = rmin;
					int cp = cmax;
					while(rp<=rmax && cp>=cmin)
					{
						System.out.print(mat[rp][cp] + " ");
						rp++;
						cp--;
					}
					if(rmin < row)
					{
						rmin++;
					}
					if(cmin < col)
					{
						cmin++;
					}
				}     
				else
				{
					int rp = rmax;
					int cp = cmin;
					while(rp>=rmin && cp<=cmax)
					{
						System.out.print(mat[rp][cp] + " ");
						rp--;
						cp++;
					}
					if(rmin < row)
					{
						rmin++;
					}
					if(cmin < col)
					{
						cmin++;
					}
				}
			}
			sum++;
		}
		System.out.println();
//		System.out.println(rmin + " " + rmax + " " + cmin + " " + cmax + " " + sum);      
	}
}
