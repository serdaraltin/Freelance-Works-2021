package week11;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		PrintWriter out = new PrintWriter("D://tempdir//mis103a.txt");
		out.println("MIS103 is a course."); 
		out.print("In this course, ");
		out.print("Java programming language ");
		out.println("is used.");

		int courseCode = 103;
		out.printf("Course code is %d\n", courseCode);
		out.close();

	}

}
