package January06;

import java.util.ArrayList;

public class complementry_targetsum_subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {10,20,30,40,50,60,70};
		
		//targetsumc(arr,0,new ArrayList<Integer>(), new ArrayList<Integer>(),0,0);
		targetsumCss(arr,0,"","", 0, 0);
	}
	
	public static void targetsumc(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int sos1, int sos2)
	{
		if(vidx == arr.length)
		{
			if(sos1 == sos2)
			{
				System.out.print(set1);
				System.out.print(" & ");
				System.out.print(set2);
				System.out.println();
			}
			return;
		}
		set1.add(arr[vidx]);
		targetsumc(arr,vidx + 1,set1,set2,sos1 + arr[vidx], sos2);
		set1.remove(set1.size() - 1);
		
		set2.add(arr[vidx]);
		targetsumc(arr, vidx + 1, set1, set2, sos1, sos2 + arr[vidx]);
		set2.remove(set2.size() - 1);
		
	}
	
	public static void targetsumCss(int[] arr, int vidx, String set1, String set2, int sos1, int sos2)
	{
		if(vidx == arr.length)
		{
			if(sos1 == sos2)
			{
				System.out.print(set1);
				System.out.print(" &");
				System.out.print(set2);
				System.out.println();
			}
			return;
		}
		
		String set1a = set1 + " " +arr[vidx];
		targetsumCss(arr,vidx+1,set1a,set2, sos1 + arr[vidx], sos2);
		
		String set2a = set2 + " " + arr[vidx];
		targetsumCss(arr, vidx+1, set1, set2a, sos1, sos2 + arr[vidx]);
		
	}

}
