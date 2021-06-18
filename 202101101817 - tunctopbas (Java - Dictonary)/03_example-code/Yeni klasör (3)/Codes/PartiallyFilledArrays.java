package week9;
import java.util.Scanner;

public class PartiallyFilledArrays {

	public static void main(String[] args) {

		final int LENGTH = 100;
		double[] values = new double[LENGTH];
		int currentSize = 0;
		Scanner in = new Scanner(System.in);

		while (in.hasNextDouble()) {
			if (currentSize < values.length) {
				values[currentSize] = in.nextDouble();
				currentSize++;
			}
		}

		for (int i = 0; i < currentSize; i++) {
			System.out.println(values[i]);
		}
	}
}
