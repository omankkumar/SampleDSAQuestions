package June13;

import java.util.Arrays;

public class TrainScheduling {

	public static int MaxPlatform(int[] sp, int[] ep) {

		int cnt = 0;
		int max = 0;
		Arrays.sort(sp);
		Arrays.sort(ep);

		int i = 0;
		int j = 0;

		while (i < sp.length) {
			if (sp[i] < ep[j]) {
				cnt++;
				i++;
				if (cnt > max) {
					max = cnt;
				}
			} else if (sp[i] > ep[j]) {
				cnt--;
				j++;
			} else {
				i++;
				j++;
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sp = { 900, 940, 950, 1100, 1500, 1800 };
		int[] ep = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println(MaxPlatform(sp, ep));

	}

}
