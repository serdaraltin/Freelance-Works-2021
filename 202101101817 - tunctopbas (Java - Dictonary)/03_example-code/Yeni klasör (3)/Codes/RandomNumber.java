package week9;

public class RandomNumber {

	public static void main(String[] args) {
		
		
		for(int i=0; i<1000; i++) {
		
			int number = getRandomNumber();
			System.out.println(number);
		}

	}
	
	
	public static int getRandomNumber() {

		int number = (int) ( 10*Math.random()) + 1;
		
		return number;

	}

}
