package January13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class testcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 97, 0, -461, -125, -404, -59, -322, -495, -288, -341, -449, -313, -192, -214, -389, -202, -183,
				-72, -416, -455, -187, -242, -416, 39, -198, -338, -465, -248, -25, -398, -97, -461, -214, -423, -407,
				-77, -190, -67, -178, -410, -160, 72, -350, -31, -85, -247, -319, -462, -303, -48, -354, -110, 17, 60,
				-19, -80, -218, -28, -426, -366, -140, -50 };

//		int[] arr1 = { -1,-1,1,-1 };
//		int[] ar = maxset(arr1);
//		for (int val : ar) {
//			System.out.print(val + " ");
//		}
		String s = Integer.toString(123);
		System.out.println(s);
//		int n = Math.min(a, b);
//		int b = Integer.parseInt(s);
//		int a = Long.parseLong(s);
		Arrays.sort(a, new Comparator<String>() {
			 public int compare(String a, String b){
		            return (b+a).compareTo(a+b);
		            (b+a).compareTo(a+b);
		        }
		});
	}

	public static int[] maxset(int[] a) {
		if ((a.length == 1) && (a[0] >= 0)) {
			return a;
		}
		if ((a.length == 1) && (a[0] < 0)) {
			int[] a1 = {};
			return a1;
		}
		int st = 0;
		int ed = 0;
		int cs = a[0];
		int os = a[0];
		int ost = 0;
		int oed = 0;
		for (int i = 1; i < a.length; i++) {
			if (cs >= 0) {
				cs = cs + a[i];
				ed++;
			} else {
				st = i;
				ed = i;
				cs = a[i];
			}
			if (os < cs) {
				if (os < cs) {
					oed = ed;
					ost = st;
					os = cs;
				} else if (os == cs) {
					if (oed - ost < ed - st) {
						ost = st;
						oed = ed;
					}
				}
			}
		}
		System.out.println(ost + " " + oed);
		int[] array = new int[oed - ost + 1];
		for (int i = 0; i <= oed - ost; i++) {
			array[i] = a[ost + i];
		}
		return array;
	}
}
