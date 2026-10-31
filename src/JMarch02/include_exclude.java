package JMarch02;

public class include_exclude {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,6,10,100,10,5};
		System.out.println(maxsum(arr));
	}
	
	public static int maxsum(int[] arr) {
		
		int incl = 0;
		int exl = 0;
		for(int i = 0; i < arr.length; i++) {
			int newincl = exl + arr[i];
			int newexl = Math.max(incl, exl);
			incl = newincl;
			exl = newexl;
		}
		
		return Math.max(incl, exl);
	}

}
