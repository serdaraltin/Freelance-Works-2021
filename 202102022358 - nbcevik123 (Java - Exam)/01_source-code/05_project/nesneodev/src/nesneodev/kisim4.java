package nesneodev;

import java.util.Scanner;

public class kisim4 {

    public static boolean balanceControl(String input) {
        int ch1Piece = 0, ch2Piece = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                ch1Piece++;
            }
            if (input.charAt(i) == ')') {
                ch2Piece++;
            }
        }
        return ch1Piece <= ch2Piece;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a String: ");
            String input = scanner.nextLine();

            if (balanceControl(input)) {
                System.out.println("This string is parenthesis-balanced.");
            } else {
                System.out.println("This string is not parenthesis-balanced.");
            }
        }
    }
}
