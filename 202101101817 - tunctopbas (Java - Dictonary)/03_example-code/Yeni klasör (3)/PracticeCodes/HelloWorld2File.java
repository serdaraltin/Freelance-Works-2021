package week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HelloWorld2File {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter out = new PrintWriter("helloworldfile.txt");
		
		out.println("Hello World!");
		
		out.close();
		
		File infile = new File("helloworldfile.txt");
		
		Scanner fr = new Scanner(infile);
		
		String fileContent="";
		
		while(fr.hasNext()) {
			fileContent = fr.nextLine();
		}
		
		System.out.println(fileContent);
		
		fr.close();

	}

}
