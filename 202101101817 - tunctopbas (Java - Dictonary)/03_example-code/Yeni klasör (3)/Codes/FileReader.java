package week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) throws FileNotFoundException {
	
		File inputFile = new File("D://SampleTextFile.txt"); 
		Scanner in = new Scanner(inputFile); 
		while (in.hasNext()) {   
			String line  = in.nextLine();
			System.out.println(line);
		} 
		in.close();

	}

}
