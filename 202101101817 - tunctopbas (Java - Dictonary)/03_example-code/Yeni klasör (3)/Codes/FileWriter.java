package week11;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		PrintWriter out = new PrintWriter("D://SampleOutput.txt");
		out.println("Hello, World!"); 
		
		double total = 120;
		out.printf("Total: %8.2f\n", total);
		out.close();

	}

}
