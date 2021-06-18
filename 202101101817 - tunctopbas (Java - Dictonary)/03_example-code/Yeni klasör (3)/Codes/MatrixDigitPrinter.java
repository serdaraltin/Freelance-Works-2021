package week10;

public class MatrixDigitPrinter {

	public static void main(String[] args) {

		char[][] digitOne = new char[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (j < 2) {
					digitOne[i][j] = '*';
				} else {
					digitOne[i][j] = ' ';
				}
			}
		}	
		
		char[][] digitTwo = new char[8][8];
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (i < 2  || i>=6 || (i==4) || (i<4 && j>=6) || (i>4 && j<2)) {
					digitTwo[i][j] = '*';
				} else {
					digitTwo[i][j] = ' ';
				}
			}
		}	
		

		printDigit(digitTwo, digitTwo, digitOne);

	}

	private static void printDigit(char[][] digitOne, char[][] digitTwo, char[][] digitThree) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				System.out.print(digitOne[i][j]);

			}
			
			System.out.print("    ");
			
			for (int j = 0; j < 8; j++) {

				System.out.print(digitTwo[i][j]);

			}
			
			System.out.print("    ");
			
			for (int j = 0; j < 8; j++) {

				System.out.print(digitThree[i][j]);

			}
			
			System.out.println();
		}

	}

}
