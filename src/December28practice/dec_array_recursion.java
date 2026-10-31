package December28practice;

public class dec_array_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3,4,5,6,7};
		int n = 0;
		int[] ar = pdo(arr, 0, n);
		for(int val : ar)
		{
			System.out.print(val + " ");
		}

	}
	
	public static int[] pdo(int[] a, int vidx, int cnt)
    {
        if(vidx == a.length)
        {
            int[] rres = new int[cnt];
            return rres;
        }
        cnt++;
        int[] res = new int[cnt];
        res = pdo(a,vidx+1,cnt);
        res[cnt -1] = a[a.length - vidx -1];
        return res;
    }

}
