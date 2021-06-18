package week8;

import java.util.Scanner;

public class SyllableCounter {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter a word:");
		String word = in.next();
		in.close();
		
		int count = 0;
		boolean found = false;
		for (int i = 0; i < word.length(); i++) {

			char ch = word.charAt(i);
			boolean isLastChar = i == word.length() - 1;

			if (!isLastChar && (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y')) {
				if (!found) {
					count++;
				}
				found = true;
			} else if (isLastChar && (ch == 'a' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y')) {
				if (!found) {
					count++;
				}
			} else {
				found = false;
			}

		}

		if (count == 0) {
			count++;
		}

		System.out.println("Count:" + count);

	}

}
