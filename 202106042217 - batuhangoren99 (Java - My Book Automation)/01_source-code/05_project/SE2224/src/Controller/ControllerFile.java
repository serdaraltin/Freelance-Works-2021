package Controller;

import Model.Book;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerFile {

    public ArrayList<String[]> ReadData(String path) {
        try {
            ArrayList<String[]> data = new ArrayList<>();

            File file = new File(path);

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                data.add(line.split(","));
            }
            return data;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerFile.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void FillData(ArrayList<Book> books, ArrayList<String[]> data) {
        for (String[] element : data) {
            books.add(new Book(element));
        }
    }

    public boolean WriteData(ArrayList<Book> data, String path) {
        try {
            FileWriter fileWriter;

            File file = new File(path);
            if (file.exists()) {
                try (PrintWriter printWriter = new PrintWriter(file)) {
                    printWriter.print("");
                    printWriter.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ControllerFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            fileWriter = new FileWriter(file);
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                for (int i = 0; i < data.size(); i++) {
                    bufferedWriter.write(data.get(i).toString());
                    if (i < data.size() - 1) {
                        bufferedWriter.newLine();
                    }
                }
            }
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControllerFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
