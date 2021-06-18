package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Dictonary {

    private String lesson;
    private String word;
    private String meaning;

    public Dictonary() {
    }

    public Dictonary(String lesson, String word, String meaning) {
        this.lesson = lesson;
        this.word = word;
        this.meaning = meaning;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    
    public String toString() {
        return "\nLesson  : " + lesson + "\nWord    : " + word + "\nMeaning : " + meaning;
    }

    public String writeString() {
        return lesson + "," + word + "," + meaning;
    }

}

class FileIO {

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
public class LessonDictionaryS012676 {

    static String fileDictonary = "dictonary.csv";
    static ArrayList<Dictonary> dictionaries = new ArrayList<>();

    static boolean Control(Dictonary dic) {
        for (Dictonary item : dictionaries) {
            if (item.getWord().equals(dic.getWord())) {
                return true;
            }
        }

        return false;
    }

    static int Search(Dictonary dic) {
        for (int i = 0; i < dictionaries.size(); i++) {
            if (dic.getWord().equals(dictionaries.get(i).getWord())) {
                return i;
            }
        }
        return -1;
    }

    static boolean Add(Dictonary dic) {
        if (Control(dic)) {
            return false;
        }
        dictionaries.add(dic);
        return true;
    }

    static boolean Update(Dictonary dic) {
        int index = Search(dic);
        if (index == -1) {
            return false;
        }
        dictionaries.get(index).setWord(dic.getWord());
        dictionaries.get(index).setMeaning(dic.getMeaning());
        dictionaries.get(index).setLesson(dic.getLesson());
        return true;
    }

    static boolean Delete(Dictonary dic) {
        int index = Search(dic);
        if (index == -1) {
            return false;
        }
        dictionaries.remove(index);
        return true;
    }

    static boolean List() {
        if (dictionaries.size() == 0) {
            return false;
        }
        for (Dictonary dictionary : dictionaries) {
            System.out.println(dictionary);
        }
        return true;
    }

    static boolean Save() {
        return FileIO.WriteFile(dictionaries, fileDictonary);
    }

    public static void main(String[] args) {
        System.out.println("Dictonary file name: " + args[0] + "\n");
        fileDictonary = args[0];
        FileIO.ReadFile(dictionaries, fileDictonary);
        Menu();
    }

    static void Menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1) Add");
        System.out.println("2) Update");
        System.out.println("3) Delete");
        System.out.println("4) List");
        System.out.println("5) Search");
        System.out.println("6) Save");
        System.out.println("0) Exit");
        System.out.print("Choice : ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                System.out.println("Closing...");
                System.exit(0);
                break;
            case 1:
                Dictonary dictonaryAdd = new Dictonary();
                System.out.print("Lesson: ");
                dictonaryAdd.setLesson(scanner.next());
                System.out.print("Word: ");
                dictonaryAdd.setWord(scanner.next());
                System.out.println("Meaning >> ");

                scanner.nextLine();
                dictonaryAdd.setMeaning(scanner.nextLine());
                if (Control(dictonaryAdd)) {
                    System.out.println("Already exists !");
                    break;
                }
                if (Add(dictonaryAdd)) {
                    System.out.println("Saved.");
                } else {
                    System.out.println("Operation failed !");
                }

                break;
            case 2:
                Dictonary dictonaryUp = new Dictonary();
                System.out.print("Word: ");
                dictonaryUp.setWord(scanner.next());
                if (!Control(dictonaryUp)) {
                    System.out.println("Not found !");
                    break;
                }
                System.out.print("Lesson: ");
                dictonaryUp.setLesson(scanner.next());
                System.out.println("Meaning >> ");

                scanner.nextLine();
                dictonaryUp.setMeaning(scanner.nextLine());

                if (Update(dictonaryUp)) {
                    System.out.println("Updated.");
                } else {
                    System.out.println("Operation failed !");
                }
                break;
            case 3:
                Dictonary dictonaryDel = new Dictonary();
                System.out.print("Word: ");
                dictonaryDel.setWord(scanner.next());
                if (!Control(dictonaryDel)) {
                    System.out.println("Not found !");
                    break;
                }
                if (Delete(dictonaryDel)) {
                    System.out.println("Deleted.");
                } else {
                    System.out.println("Operation failed !");
                }
                break;
            case 4:
                if (!List()) {
                    System.out.println("Dictonary empty !");
                }
                break;
            case 5:
                Dictonary dictonarySearch = new Dictonary();
                System.out.print("Word: ");
                dictonarySearch.setWord(scanner.next());
                if (!Control(dictonarySearch)) {
                    System.out.println("Not found !");
                    break;
                }
                int index = Search(dictonarySearch);
                System.out.println(dictionaries.get(index));
                break;
            case 6:
                if (Save()) {
                    System.out.println("Saved.");
                } else {
                    System.out.println("Operation failed !");
                }
                break;
            default:
                System.out.println("Wrong choice !");
                break;
        }
        System.out.println();
        Menu();
        scanner.close();
    }
}
