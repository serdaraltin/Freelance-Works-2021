package week8;

import java.util.Scanner;

public class FibonacciNumber {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number:");
		int number = in.nextInt();
		in.close();

		int fibonacciNumber = 0;
		int sum = 1;
		for (int i = 0; i < number; i++) {
			System.out.println(fibonacciNumber);
			int temp = sum;
			sum = fibonacciNumber + sum;
			fibonacciNumber = temp;
		}

	}
}
