package December25practice;

import java.util.Scanner;

public class sadal_point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        int[][] mat = new int[row][col];
//		int[][] mat = {{17,8,9},{16,15,41},{3,1,2}};
//		int row = 3;
//		int col = 3;
        
        for(int r =0; r<row; r++)
        {
            for(int c = 0; c<col; c++)
            {
                mat[r][c] = scn.nextInt();
            }
        }
        int cnt = 0;
        //int min_index = 0;
        for(int r = 0; r<row; r++)
        {
        	int rmin = mat[r][0];
        	int min_index = 0;
            for(int c =0; c<col; c++)
            {
                if(mat[r][c]<=rmin)
                {
                    rmin = mat[r][c];
                    min_index = c;
                }
            }
//            System.out.print(rmin);
//            System.out.print(min_index);
            int cmax = mat[0][min_index];
           // System.out.println();
            for(int r1 = 0; r1<row; r1++)
            {
                if(mat[r1][min_index] >= cmax)
                {
                    cmax = mat[r1][min_index];                    
                }
            }
//            System.out.println(cmax);
            if(rmin == cmax)
            {
                System.out.println(cmax);
                cnt++;
            }
            
        }
        if(cnt == 0)
        {
            System.out.println("No Such Point Exist");
        }

	}

}
