package June04;

import java.util.LinkedList;

public class CoinChangeCombination {
	
	public static void cc(int[] arr, int sum) {
		int[] strg = new int[sum + 1];
		strg[0] = 1;
		
		for(int i = 0; i < arr.length; i++) {
			int val = arr[i];
			for(int j = 0; j < strg.length; j++) {
				if(j - val >= 0) {
					strg[j] = strg[j] + strg[j - val];
				}
			}
		}
		
		for(int i = 0; i < strg.length; i++) {
			System.out.print(strg[i] + " ");
		}
	} 
	
	static class pair{
		int sum;
		String psf;
		
		pair(int sum, String psf) {
			this.sum = sum;
			this.psf = psf;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,3,5,6};
		cc(arr, 7);
	}

}
