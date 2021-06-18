package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SampleThrows {

	public static void main(String[] args) {

		String fileName = "dddAA.txt";
		
		
		try {
			String content = getContent(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static String getContent(String fileName) throws FileNotFoundException {
	
		String ffCon = getFileContent(fileName);
		
		return ffCon;
	}

	private static String getFileContent(String fileName) throws FileNotFoundException {
		
		File ff = new File(fileName);
		String content = "";
		Scanner in = new Scanner(ff); 
		while (in.hasNext()) {   
			content = in.nextLine();
	
		} 
		in.close();
		
		return content;
	}

}
