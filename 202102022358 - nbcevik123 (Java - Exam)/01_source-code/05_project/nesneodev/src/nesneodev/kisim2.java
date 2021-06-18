package nesneodev;

import java.util.Scanner;

public class kisim2 {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a text: ");
            String text = scanner.nextLine();
            System.out.print("Reverse     : ");
            String[] textArray = text.split(" ");

            for (String word : textArray) {
                for (int i = word.length() - 1; i >= 0; i--) {
                    System.out.print(word.charAt(i));
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
