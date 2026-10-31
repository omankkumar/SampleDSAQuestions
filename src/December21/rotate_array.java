package December21;

public class rotate_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,1,2,3,4,5,6};
		int r = 3;
//		while((r-1)>=0)
//		{
//			int val = a[6];
//			for(int i= a.length-2; i>=0; i--)
//			{
//				a[i+1] = a[i];
//			}
//			a[0] = val;
//			r--;
//		} above code is correct but has time complexity of n^2, now we do in n.
		
		revArr(a,0,a.length-1-r);//revp1
		revArr(a,a.length-r,a.length-1);//revp2
		revArr(a,0,a.length-1);//revp3
		
		for(int val : a)
		{
			System.out.print(val + " ");
		}

	}
	public static void revArr(int[] a, int lo, int hi)
	{
		while(lo<hi)
		{
			int temp = a[lo];
			a[lo] = a[hi];
			a[hi] = temp;
			lo++;
			hi--;
		}
	}

}
