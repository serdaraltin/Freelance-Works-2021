package week11;

import java.util.Scanner;

public class ConsoleReader {

	public static void main(String[] args) {
		
		System.out.print("Please enter data:");
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {   
			String line  = in.next();
			System.out.println(line);
		} 
	

	}

}
