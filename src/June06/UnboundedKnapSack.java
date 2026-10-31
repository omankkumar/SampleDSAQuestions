package June06;

public class UnboundedKnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] wts = {2,5,1,3,4};
		int[] prices = {15,14,10,45,30};
		int cap = 7;
		
		int[] strg = new int[cap + 1];
		for(int i = 0; i < strg.length; i++) {
			int max = 0;
			for(int j = 0; j < wts.length; j++) {
				if(i - wts[j] >= 0) {
					max = Math.max(max, prices[j] + strg[i - wts[j]]);
				}
			}
			strg[i] = max;
		}
		System.out.println(strg[strg.length - 1]);
		for(int i = 0; i < strg.length; i++) {
			System.out.print(strg[i] + " ");
		}
		System.out.println();
	}
}
