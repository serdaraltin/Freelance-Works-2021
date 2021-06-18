package week9;

import java.util.Scanner;

/**
 * This program reads, scales, and reverses a sequence of numbers.
 */
public class Reverse {
	public static void main(String[] args) {
		double[] numbers = readInputs(5);
		multiply(numbers, 10);
		printReversed(numbers);
	}

	/**
	 * Reads a sequence of floating-point numbers.
	 * 
	 * @param numberOfInputs the number of inputs to read
	 * @return an array containing the input values
	 */
	public static double[] readInputs(int numberOfInputs) {
		System.out.println("Enter " + numberOfInputs + " numbers: ");
		Scanner in = new Scanner(System.in);
		double[] inputs = new double[numberOfInputs];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = in.nextDouble();
		}
		return inputs;
	}

	/**
	 * Multiplies all elements of an array by a factor.
	 * 
	 * @param values an array
	 * @param factor the value with which element is multiplied
	 */

	public static void multiply(double[] values, double factor) {
		for (int i = 0; i < values.length; i++) {
			values[i] = values[i] * factor;
		}
	}

	/**
	 * Prints an array in reverse order.
	 * 
	 * @param values an array of numbers
	 * @return an array that contains the elements of values in reverse order
	 */
	public static void printReversed(double[] values) {
		// Traverse the array in reverse order, starting with the last element
		for (int i = values.length - 1; i >= 0; i--) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}
}