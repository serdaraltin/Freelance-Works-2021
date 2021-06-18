package week8;

public class ReturnSample {

	public static void main(String[] args) {
		System.out.println(isEven(13));

	}

	public static boolean isEven(int n) {

		if (n % 2 == 0) {
			return true;
			//System.out.println("Test Code");
		} else {
			return false;
		}
	}
}
