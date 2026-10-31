package December23practice;

public class merge_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,6,2,8,7,9,1,5};
		merge_sort(arr);
		for(int val : arr)
		{
			System.out.print(val + " ");
		}
	}
	public static void merge_sort(int[] a)
	{
		int nL = a.length/2;
		int nR = (a.length) - (a.length/2);
		int[] left = new int[nL];
		int[] right = new int[nR];
		for(int i = 0; i < a.length/2; i++)
		{
			left[i] = a[i];
		}
		for(int j = a.length/2; j < a.length; j++)
		{
			right[j] = a[j];
		}
		merge_sort(left);
		merge_sort(right);
		merge(left,right,a);
		
	}
	public static void merge(int[] aL, int[] aR, int[] A)
	{
		int nL = aL.length;
		int nR = aR.length;
		int nA = A.length;
		int i=0 , j=0 , k=0;
		
		while(i<nL && j<nR)
		{
			if(aL[i]<=aR[j])
			{
				A[k] = aL[i];
				i++;
				k++;
			}
			else
			{
				A[k] = aR[j];
				j++;
				k++;
			}
		}
		while(i<nL)
		{
			A[k] = aL[i];
			i++;
			k++;
		}
		while(j<nR)
		{
			A[k] = aR[j];
			j++;
			k++;
		}
	}

}
