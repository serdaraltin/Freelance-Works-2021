package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSample {

	public static void main(String[] args) throws FileNotFoundException {
		
		File ff = new File("dddd.txt");
		Scanner in ;
		System.out.println("Program starts");
		try {
			System.out.println("Program executes");
			 in = new Scanner(ff);
				in.close();
			 
			while (in.hasNext()) {   
				String line  = in.nextLine();
				System.out.println(line);
			} 
			
			System.out.println("Program ends");
			
		}catch(FileNotFoundException dd) {
			System.out.println("File can not be found");
			System.out.println("Please enter a valid file");
		}finally {
				System.out.println("This code block executes last");

		}
	}
}
