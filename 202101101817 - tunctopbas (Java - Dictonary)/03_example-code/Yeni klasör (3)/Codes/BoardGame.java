package week9;

public class BoardGame {

	public static void main(String[] args) {
	
		int[][] board = new int[8][8]; 

		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = (i+j) % 2;
			}
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.printf("%2d", board[i][j]);
			}
			System.out.printf("\n");
		}


	}

}
