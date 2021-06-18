package week9;

import java.util.Scanner;

public class DigitPrinter {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number:");
		int number = in.nextInt();
		printDigits(number);
		in.close();

	}

	private static void printDigits(int num) {
		
		boolean flag = true;
		
		while(flag) {
			
			int remainder = num %10;
			
			System.out.println(remainder);
			
			if(num<10)
				flag= false;
			
			num = num/10;
			
		}

	}

}
