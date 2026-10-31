package June15;

import java.util.*;

public class HashMapDemo {

	public static void PrintMaxFreqChar(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		int max = 0;
		char cmax = 'a';
		ArrayList<Character> keys = new ArrayList<>(map.keySet());
		for (int i = 0; i < keys.size(); i++) {
			if (map.get(keys.get(i)) > max) {
				max = map.get(keys.get(i));
				cmax = keys.get(i);
			}
		}

		System.out.println(cmax + " occured " + max + " times.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abbccddaccbdaedcba";
		PrintMaxFreqChar(str);

	}

}
