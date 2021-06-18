package week11;

public class CommandLineSample {

	public static void main(String[] args) {
		String argument1 = args[0];
		String argument2 = args[1];
		
		System.out.printf("You have entered %s and %s as a command\n" , argument1, argument2);
		
		if(argument1.equals("print")) {
			System.out.println("Print File is executed");
		}
		else if(argument1.equals("show")) {
			System.out.println("Showing directory is execeuted");
		} else {
			System.out.println("Unknown commad");
		}

	}

}
