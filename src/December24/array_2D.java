package December24;

import java.util.Scanner;

public class array_2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = new int[2][2];
		int[][] mat1 = {{1,2,3,4},{5,6,7,8}};
		Scanner scn = new Scanner(System.in);
		
		for(int row = 0; row<mat.length; row++)
		{
			for(int col = 0; col < mat[0].length; col++)
			{
				mat[row][col] = scn.nextInt();
			}
		}
		for(int row = 0; row<mat.length; row++)
		{
			for(int col = 0; col < mat[0].length; col++)
			{
				System.out.print(mat[row][col] + " ");
			}
			System.out.println();
		}
		for(int row = 0; row<mat1.length; row++)
		{
			for(int col = 0; col < mat1[0].length; col++)
			{
				System.out.print(mat1[row][col] + " ");
			}
			System.out.println();
		}

	}

}
