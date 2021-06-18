package week9;
import java.util.Scanner;


public class StringConverter {

	public static void main(String[] args) {
		

		System.out.print("Please enter a string=");
		Scanner in = new Scanner(System.in);

		String str = in.nextLine();

		String upperStr = convert2Upper(str);
		
		System.out.println(upperStr);
	}

	private static String convert2Upper(String str) {
		
		
		String upperStr = "";
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			upperStr = upperStr + getUpperChar(ch);
		}
		
		return upperStr;
	}

	private static char getUpperChar(char ch) {
	
		switch (ch) {
		case 'a':return 'A';
		case 'b':return 'B';
		case 'c':return 'C';
		case 'd':return 'D';
		case 'e':return 'E';
		case 'f':return 'F';
		case 'g':return 'G';
		case 'h':return 'H';
		case 'i':return 'I';
		case 'j':return 'J';
		case 'k':return 'K';
		case 'l':return 'L';
		case 'm':return 'M';
		case 'n':return 'N';
		case 'o':return 'O';
		case 'p':return 'P';
		case 'q':return 'Q';
		case 'r':return 'R';
		case 's':return 'S';
		case 't':return 'T';
		case 'u':return 'U';
		case 'v':return 'V';
		case 'w':return 'W';
		case 'x':return 'X';
		case 'y':return 'Y';
		case 'z':return 'Z';
		default: return ch;
		}
	}

}
