package week10;

public class PrintDigit {

	public static void main(String[] args) {
	
		int[] cardValues  = new int[6];
		
		
		int rdn1 = 4; // differen card value
		int rdn2  = 1 ;// multiple card value
		int cardno = 3;  // card no for dfifferent 1,2, 3,4,5,6
		
		
		
		
		cardValues[0] = rdn2;
		cardValues[1] = rdn2;
		cardValues[2] = rdn2;
		cardValues[3] = rdn2;
		cardValues[4] = rdn2;
		cardValues[5] = rdn2;
		
		cardValues[cardno] = rdn1;
		
		
		for(int cardNo: cardValues) {
			printDigit(cardNo);
		}

	}

	private static void printDigit(int i) {
		
		if(i==1) {
			printOne();
		}
		else if(i==4) {
			printFour();
		}
		else if(i==5) {
			printFive();
		}
		
	}

	private static void printFive() {
	
		System.out.println("5");
	}
	

	private static void printFour() {
	
		System.out.println("4");
	}

	private static void printOne() {
			System.out.println("1");
		
	}

}
