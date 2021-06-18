package week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSearcher {

	public static void main(String[] args) throws Exception {
		
		if(args.length<2) {
			throw new Exception("You entered wrong parameters. "
					+ "You should enter a keyword and at least one file name");
		}
		
		String keyword = args[0];
		
		for(int i=1; i<args.length; i++) {
			
			String fileName = args[i];
			System.out.printf("File search is executed for keyword %s and for file %s\n", keyword, fileName);
			search(keyword, fileName);
		}

	}

	private static void search(String keyword, String fileName) throws FileNotFoundException {
			
		File file = new File(fileName);
		
		Scanner in = new Scanner(file);
		
		while(in.hasNext()) {
			String fileLine = in.nextLine();
			
			if(fileLine.contains(keyword)) {
				System.out.printf("%s, %s, %s\n", keyword, fileName, fileLine);
			}
		}
		
		in.close();
		
		
	}

}
