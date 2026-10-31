package June06;
import java.util.*;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		int rod = 8;
		int[] strg = new int[rod + 1];
		strg[0] = 0;
		strg[1] = p[1];
		for (int i = 2; i < strg.length; i++) {
			int max = 0;
			int l = 0;
			int r = i;
			while(l <= r) {
				max = Math.max(max, strg[l] + strg[r]);
				r--;
				l++;
			}
			strg[i] = Math.max(max, p[i]);
		}
		Stack<Character> st = new Stack<>();
		String s1 = "", s2 = "";
		System.out.println(s1.equals(s2));
		
		System.out.println(strg[strg.length - 1]);
		for(int i = 0; i < strg.length; i++) {
			System.out.print(strg[i] + " ");
		}
		System.out.println();
	}

}
