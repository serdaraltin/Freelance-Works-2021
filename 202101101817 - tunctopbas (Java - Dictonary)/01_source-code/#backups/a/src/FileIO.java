
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileIO {

    public static boolean ReadFile(ArrayList<Dictonary> dictonaries, String fileName) {
        try {
            File file = new File(fileName);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(",")) {
                        dictonaries.add(new Dictonary(line.split(",")[0], line.split(",")[1], line.split(",")[2]));
                    }

                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean WriteFile(ArrayList<Dictonary> dictonaries, String fileName) {
        try {
            new File(fileName).createNewFile();
            FileWriter fileWriter = new FileWriter(fileName);
            for (Dictonary dictonary : dictonaries) {
                fileWriter.write(dictonary.writeString());
            }
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
