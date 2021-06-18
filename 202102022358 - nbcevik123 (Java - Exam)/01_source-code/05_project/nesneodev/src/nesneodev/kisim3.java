package nesneodev;

import java.util.Scanner;

public class kisim3 {

    public static String convert(String input) {

        String convertedText = "";
        String[] textArray = input.split(" ");

        for (String word : textArray) {
            int aPiece = 0;
            if (word.charAt(0) == 'a') {
                aPiece--;
            }
            for (int i = 0; i < word.length(); i++) {

                if (word.charAt(i) == 'a') {
                    aPiece++;
                    if (aPiece == 2) {
                        convertedText += 'A';
                        continue;
                    }
                }
                convertedText += word.charAt(i);
            }
            convertedText += " ";
        }

        return convertedText;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a text: ");
            String input = scanner.nextLine();
            System.out.println("Converted    : " + convert(input));
        }

    }
}
