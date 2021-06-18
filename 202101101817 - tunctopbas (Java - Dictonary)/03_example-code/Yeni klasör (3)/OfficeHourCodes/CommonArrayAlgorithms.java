package week10;

import java.util.Arrays;
import java.util.Scanner;

public class CommonArrayAlgorithms {

	public static int SIZE = 100;

	public static void main(String[] args) {

		int[] values = new int[SIZE];

		// Array Filling
		for (int i = 0; i < values.length; i++) {
			values[i] = i * i;
		}

		// Sum And Average Value
		double total = 0;
		for (double element : values) {
			total = total + element;
		}
		double average = 0;
		if (values.length > 0) {
			average = total / values.length;
		}

		System.out.printf("Total is %.2f  Average is %.2f\n ", total, average);

		// Largest And Minimum
		double largest = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] > largest) {
				largest = values[i];
			}
		}

		System.out.printf("Largest is %.2f\n ", largest);

		// Element Separator
		for (int i = 0; i < values.length; i++) {
			if (i > 0) {
				System.out.print(" | ");
			}
			System.out.print(values[i]);
		}

		System.out.println();
		// Linear Search
		int searchedValue = 100;
		int pos = 0;
		boolean found = false;
		while (pos < values.length && !found) {
			if (values[pos] == searchedValue) {
				found = true;
			} else {
				pos++;
			}
		}
		if (found) {
			System.out.println("Found at position: " + pos);
		} else {
			System.out.println("Not found");
		}

		// Array Copy Arrays.copyOf( array, length);
		int[] newValues = Arrays.copyOf(values, 2 * values.length);
		values = newValues;

		// Reading Input
		System.out.println("Enter Inputs");
		Scanner in = new Scanner(System.in);
		int NUMBER_OF_INPUTS = 5;
		double[] inputs = new double[NUMBER_OF_INPUTS];
		int currentSize = 0;
		while (in.hasNextDouble() && currentSize < inputs.length) {
			inputs[currentSize] = in.nextDouble();
			currentSize++;
		}
		

	}

}
