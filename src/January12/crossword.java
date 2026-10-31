package January12;

import java.util.ArrayList;

public class crossword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] cross = { { '+', '+', '+', '+', '+', '+', '+', '+', '+', '-' },
						   { '-', '+', '+', '+', '+', '+', '+', '+', '+', '-' },
						   { '-', '-', '-', '-', '-', '-', '-', '+', '+', '-' },
						   { '-', '+', '+', '+', '+', '+', '+', '+', '+', '-' },
						   { '-', '+', '+', '+', '+', '+', '+', '+', '+', '-' },
						   { '-', '+', '+', '+', '+', '-', '-', '-', '-', '-' },
						   { '-', '-', '-', '-', '-', '-', '+', '+', '+', '-' },
						   { '-', '+', '+', '+', '+', '+', '+', '+', '+', '-' },
						   { '+', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
						   { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };

		char[][] crosswordFilled = { { '+', '+', '+', '+', '+', '+', '+', '+', '+', 'C' },
									 { 'P', '+', '+', '+', '+', '+', '+', '+', '+', 'H' },
									 { 'H', 'I', 'S', 'T', 'O', 'R', 'Y', '+', '+', 'E' },
									 { 'Y', '+', '+', '+', '+', '+', '+', '+', '+', 'M' },
									 { 'S', '+', '+', '+', '+', '+', '+', '+', '+', 'I' },
									 { 'I', '+', '+', '+', '+', 'M', 'A', 'T', 'H', 'S' },
									 { 'C', 'I', 'V', 'I', 'C', 'S', '+', '+', '+', 'T' },
									 { 'S', '+', '+', '+', '+', '+', '+', '+', '+', 'R' },
									 { '+', 'G', 'E', 'O', 'G', 'R', 'A', 'P', 'H', 'Y' },
									 { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };

		ArrayList<String> words = new ArrayList<>();
		words.add("PHYSICS");
		words.add("CHEMISTRY");
		words.add("MATHS");
		words.add("HISTORY");
		words.add("CIVICS");
		words.add("GEOGRAPHY");

		crossword(cross, 0, words);
	}

	public static void crossword(char[][] cross, int cp, ArrayList<String> words) {
		if (cp == cross.length * cross[0].length) {
			display(cross);
			return;
		}
		int r = cp / cross.length;
		int c = cp % cross.length;

		if (cross[r][c] == '-') {
			char dir = finddir(cross, r, c);
			if (dir == 'D') {
				int sizeofword = 0;
				for (int i = 0; i < cross.length - r; i++) {
					if (cross[r + i][c] != '+') {
						sizeofword++;
					} else {
						break;
					}
				}

				String word = "";
				for (int i = 0; i < words.size(); i++) {
					if (words.get(i).length() == sizeofword) {
						word = words.get(i);
						words.remove(i);
						break;
					}
				}

				for (int i = 0; i < word.length(); i++) {
					cross[r + i][c] = word.charAt(i);
				}
				crossword(cross, cp + 1, words);
				for (int i = 0; i < word.length(); i++) {
					cross[r + i][c] = '-';
				}
			}

			if (dir == 'A') {
				int sizeofword = 0;
				for (int i = 0; i < cross[0].length - c; i++) {
					if (cross[r][c + i] != '+') {
						sizeofword++;
					} else {
						break;
					}
				}

				String word = "";
				for (int i = 0; i < words.size(); i++) {
					if (words.get(i).length() == sizeofword) {
						word = words.get(i);
						words.remove(i);
						break;
					}
				}

				for (int i = 0; i < word.length(); i++) {
					cross[r][c + i] = word.charAt(i);
				}
				crossword(cross, cp + 1, words);
				for (int i = 0; i < word.length(); i++) {
					cross[r][c + i] = '-';
				}
			}

			if (dir == 'B') {
				int sowr = 0;
				int sowc = 0;
				for (int i = 0; i < cross[0].length - c; i++) {
					if (cross[r][c + i] != '+') {
						sowc++;
					} else {
						break;
					}
				}
				for (int i = 0; i < cross.length - r; i++) {
					if (cross[r + i][c] != '+') {
						sowr++;
					} else {
						break;
					}
				}

				String worda = "";
				String wordd = "";
				for (int i = 0; i < words.size(); i++) {
					if (words.get(i).length() == sowr) {
						wordd = words.get(i);
						words.remove(i);
						break;
					}
					if (words.get(i).length() == sowc) {
						worda = words.get(i);
						words.remove(i);
						break;
					}
				}
				if (worda.length() > wordd.length()) {
					for (int i = 0; i < worda.length(); i++) {
						cross[r][c + i] = worda.charAt(i);
					}
					crossword(cross, cp + 1, words);
					for (int i = 0; i < worda.length(); i++) {
						cross[r][c + i] = '-';
					}
				} else {
					for (int i = 0; i < wordd.length(); i++) {
						cross[r + i][c] = wordd.charAt(i);
					}
					crossword(cross, cp + 1, words);
					for (int i = 0; i < wordd.length(); i++) {
						cross[r + i][c] = '-';
					}
				}
			}
			if (dir == 'N') {
				crossword(cross, cp + 1, words);
			}
		} else if ((cross[r][c] != '-') && (cross[r][c] != '+')) {

			char dir = finddir(cross, r, c);
			if (dir == 'D') {
				int sizeofword = 0;
				for (int i = 0; i < cross.length - r; i++) {
					if (cross[r + i][c] != '+') {
						sizeofword++;
					} else {
						break;
					}
				}

				String word = "";
				for (int i = 0; i < words.size(); i++) {
					if ((words.get(i).length() == sizeofword) && (cross[r][c] == words.get(i).charAt(0))) {
						word = words.get(i);
						words.remove(i);
						break;
					}
				}

				for (int i = 0; i < word.length(); i++) {
					cross[r + i][c] = word.charAt(i);
				}
				crossword(cross, cp + 1, words);
				for (int i = 0; i < word.length(); i++) {
					cross[r + i + 1][c] = '-';
				}
			}

			if (dir == 'A') {
				int sizeofword = 0;
				for (int i = 0; i < cross[0].length - c; i++) {
					if ((cross[r][c + i] != '+')) {
						sizeofword++;
					} else {
						break;
					}
				}

				String word = "";
				for (int i = 0; i < words.size(); i++) {
					if (words.get(i).length() == sizeofword && (cross[r][c] == words.get(i).charAt(0))) {
						word = words.get(i);
						words.remove(i);
						break;
					}
				}

				for (int i = 0; i < word.length(); i++) {
					cross[r][c + i] = word.charAt(i);
				}
				crossword(cross, cp + 1, words);
				for (int i = 0; i < word.length(); i++) {
					cross[r][c + i + 1] = '-';
				}
			}

			if (dir == 'B') {
				int sowr = 0;
				int sowc = 0;
				for (int i = 0; i < cross[0].length - c; i++) {
					if (cross[r][c + i] != '+') {
						sowc++;
					} else {
						break;
					}
				}
				for (int i = 0; i < cross.length - r; i++) {
					if (cross[r + i][c] != '+') {
						sowr++;
					} else {
						break;
					}
				}

				String worda = "";
				String wordd = "";
				for (int i = 0; i < words.size(); i++) {
					if ((words.get(i).length() == sowr) && (cross[r][c] == words.get(i).charAt(0))) {
						wordd = words.get(i);
						words.remove(i);
						break;
					}
					if ((words.get(i).length() == sowc) && (cross[r][c] == words.get(i).charAt(0))) {
						worda = words.get(i);
						words.remove(i);
						break;
					}
				}
				if (worda.length() > wordd.length()) {
					for (int i = 0; i < worda.length(); i++) {
						cross[r][c + i] = worda.charAt(i);
					}
					crossword(cross, cp + 1, words);
					for (int i = 0; i < worda.length(); i++) {
						cross[r][c + i + 1] = '-';
					}
				} else {
					for (int i = 0; i < wordd.length(); i++) {
						cross[r + i][c] = wordd.charAt(i);
					}
					crossword(cross, cp + 1, words);
					for (int i = 0; i < wordd.length(); i++) {
						cross[r + i + 1][c] = '-';
					}
				}
			}
			if (dir == 'N') {
				crossword(cross, cp + 1, words);
			}
		} else {
			crossword(cross, cp + 1, words);
		}
	}

	public static char finddir(char cross[][], int r, int c) {
		if ((r + 1 < cross.length) && (c + 1 < cross[0].length) && (cross[r + 1][c] == '-')
				&& (cross[r][c + 1] != '-')) {
			return 'D';
		} else if ((c + 1 < cross[0].length) && (r + 1 < cross.length) && (cross[r][c + 1] == '-')
				&& (cross[r + 1][c] != '-')) {
			return 'A';
		} else if ((c + 1 < cross[0].length) && (r + 1 < cross.length) && (cross[r + 1][c] != '-')
				&& (cross[r][c + 1] != '-')) {
			return 'N';
		} else {
			return 'B';
		}
	}

	public static void display(char[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
