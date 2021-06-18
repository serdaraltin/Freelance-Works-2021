package week10;

import java.util.Scanner;

public class NumberPrint_Horizontal {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// Digit size input.
		System.out.println("Enter Size of Digit:");
		int size = sc.nextInt();
		int rows = size * 5;
		
		//Student number input.
		System.out.println("Enter Student Number:");
		String number = "1234567890";
		//String number = sc.next();
		
		//Char input.
		System.out.println("Enter Character:");
		char ch = sc.next().charAt(0);
		
		
		// Row loop. Print characters row by row.
		for(int row = 1; row <= rows; row++) {
		
			
			// Digit printer loop.
			for(int i = 0; i < number.length(); i++) {
				
				int digit = Character.getNumericValue(number.charAt(i));
				
				// Line boolean variables.
				boolean upper = false;
				boolean upperLeft = false;
				boolean upperRight = false;
				boolean middle = false;
				boolean lowerLeft = false;
				boolean lowerRight = false;
				boolean lower = false;
				
				//Setting line boolean variables.
				if(digit != 1 && digit != 4) {upper = true;}
				if(digit != 2 && digit != 3) {upperLeft = true;}
				if(digit != 1 && digit != 5 && digit != 6) {upperRight = true;}
				if(digit != 0 && digit != 1 && digit != 7) {middle = true;}
				if(digit != 3 && digit != 4 && digit != 5 && digit != 7 && digit != 9) {lowerLeft = true;}
				if(digit != 1 && digit != 2) {lowerRight = true;}
				if(digit != 1 && digit != 4 && digit != 7) {lower = true;}
				
				// Print upper/middle/lower.
				if ((row <= size && upper) || ((2 * size) + 1 <= row && row <= (3 * size) && middle)
						|| (rows - size) < row && lower) {
					for (int c = 0; c < size * 3; c++) {
						System.out.print(ch);
					}
				}
			
					// Print upperLeft/upperRight/lowerLeft/lowerRight.
				else {
					int space = 0;

					// Print upperLeft/lowerLeft.
					if ((upperLeft && row <= size * 3) || (lowerLeft && row > size * 2)) {// if (6 <= row) {
						for (int c = 0; c < size; c++) {
							System.out.print(ch);
						}
					}

					else {// Starting space.
						space += size;
					}

					// Print middle and/or starting space.
					for (int c = 0; c < size + space; c++) {
						System.out.print(" ");
					}

					// Print upperRight/lowerRight
					if ((upperRight && row <= size * 3) || (lowerRight && row > size * 2)) {
						for (int c = 0; c < size; c++) {
							System.out.print(ch);
						}
					}

					else {// Ending space.
						for (int c = 0; c < size; c++) {
							System.out.print(" ");
						}
					}

				}
			
				System.out.print("     ");

			} // End of digit loop.

			System.out.println("");

		} // End of row loop.
	}
}
