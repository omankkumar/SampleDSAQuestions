package January17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class testcode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Integer[] arr = { 55, 5, 53, 52, 4, 45 };
		Arrays.sort(arr, new sorter());
		System.out.println(Arrays.toString(arr));
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	}
}

class sorter implements Comparator<Integer> {
	public int compare(Integer a, Integer b) {
		String ab = a + "" + b;
		String ba = b + "" + a;
		return ba.compareTo(ab);
	}
}

// ArrayList<Integer>[] res = new ArrayList[2*mat.length - 1];
// int row = mat.length;
// int col = mat[0].length;
// for(int i = 0; i < res.length; i++)
// {
// if(i<col)
// {
// int r = 0;
// int c = i;
// while(c>=0 && r<row)
// {
// res[i].add(mat[r][c]);
// r++;
// c--;
// }
// }
// else
// {
// int c = col-1;
// int r = i - row + 1;
// while(c>=0 && r<row)
// {
// res[i].add(mat[r][c]);
// r++;
// c--;
// }
// }
// }
