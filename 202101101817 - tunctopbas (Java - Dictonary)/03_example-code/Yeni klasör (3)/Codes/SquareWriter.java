package week8;

public class SquareWriter {

	public static void main(String[] args) {
	
		for(int i = 0; i<8; i++) {
			for(int j=0; j<8; j++) {
				
				System.out.printf("i=%d-j=%d ", i, j);
				
				// j==0 || (i<=3 && j==7) || i==4 || (i>4 && j==0)
			}
			System.out.println();
		}
	}

}
