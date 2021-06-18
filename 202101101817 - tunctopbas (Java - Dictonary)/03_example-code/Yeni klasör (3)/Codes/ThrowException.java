package week10;

public class ThrowException {

	public static void main(String[] args) {
	
		int balance = 400;
		int amount = 200;
		
		System.out.println("Execution starts here");
		
		if(amount>balance) {
			throw new IllegalArgumentException("Amount can not be greater than balance");
		}
		
		System.out.println("Execution finishes here");
	}

}
