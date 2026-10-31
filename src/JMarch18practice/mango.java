package JMarch18practice;

import java.util.ArrayList;

public class mango {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "man", "go", "mango", "ice", "cream", "icecream", "coco", "nut", "coconut" };
		String str = "mangoicecreamcoconut";
		parrot(arr, str, "");
		
	}

	public static void parrot(String[] arr, String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i <= ques.length(); i++) {
			String s1 = ques.substring(0, i);
			String ans1 = "";
			String ques1 = "";

			for (int j = 0; j < arr.length; j++) {
				if (s1.equals(arr[j])) {
					if(ans == "") {
						ans1 = s1;
					} else {
						ans1 = ans + "-" + s1;
					}
					ques1 = ques.substring(i);
					parrot(arr, ques1, ans1);
					break;
				}
			}
		}
	}
}
