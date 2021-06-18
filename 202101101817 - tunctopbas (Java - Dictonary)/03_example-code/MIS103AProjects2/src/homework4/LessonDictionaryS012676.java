package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


   

public class LessonDictionaryS012676 {

    static String fileDictonary = "dictonary.csv";
    static ArrayList<String[]> dictionaries = new ArrayList<>();

    public static boolean ReadFile(ArrayList<String[]> dictonaries, String fileName) {
        try {
            File file = new File(fileName);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(",")) {
                        dictonaries.add(new String[] {line.split(",")[0], line.split(",")[1], line.split(",")[2]});
                    }

                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LessonDictionaryS012676.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean WriteFile(ArrayList<String[]> dictonaries, String fileName) {
        try {
            new File(fileName).createNewFile();
            FileWriter fileWriter = new FileWriter(fileName);
            for (String[] dictonary : dictonaries) {
                fileWriter.write(dictonary[0]+","+dictonary[1]+","+dictonary[2]+"\n");
            }
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(LessonDictionaryS012676.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    static boolean Control(String[] dic) {
        for (String[] item : dictionaries) {
            if (dic[1].equals(item[1])) {
                return true;
            }
        }

        return false;
    }

    static int Search(String[] dic) {
        for (int i = 0; i < dictionaries.size(); i++) {
            if (dic[1].equals(dictionaries.get(i)[1])) {
                return i;
            }
        }
        return -1;
    }

    static boolean Add(String[] dic) {
        if (Control(dic)) {
            return false;
        }
        dictionaries.add(dic);
        return true;
    }

    static boolean Update(String[] dic) {
        int index = Search(dic);
        if (index == -1) {
            return false;
        }
        dictionaries.get(index)[0] = dic[0];
        dictionaries.get(index)[1] = dic[1];
        dictionaries.get(index)[2] = dic[2];
      
        return true;
    }

    static boolean Delete(String[] dic) {
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
        for (String[] dictionary : dictionaries) {
            System.out.println("Lesson : "+dictionary[0]+"\n"+"Word : "+dictionary[1]+"\n"+"Meaning : "+dictionary[2]+"\n");
        }
        return true;
    }

    static boolean Save() {
        return WriteFile(dictionaries, fileDictonary);
    }

    public static void main(String[] args) {
        System.out.println("Dictonary file name: " + args[0] + "\n");
        fileDictonary = args[0];
        ReadFile(dictionaries, fileDictonary);
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
                String[] dictonaryAdd = new  String[3];
                System.out.print("Lesson: ");
                dictonaryAdd[0] = scanner.next();
                System.out.print("Word: ");
                dictonaryAdd[1] =scanner.next();
                System.out.println("Meaning >> ");

                scanner.nextLine();
                dictonaryAdd[2] =scanner.nextLine();
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
                String[] dictonaryUp = new  String[3];
                System.out.print("Word: ");
                dictonaryUp[1] =scanner.next();
                if (!Control(dictonaryUp)) {
                    System.out.println("Not found !");
                    break;
                }
                System.out.print("Lesson: ");
                dictonaryUp[0] = scanner.next();
                System.out.println("Meaning >> ");

                scanner.nextLine();
                dictonaryUp[2] =scanner.nextLine();

                if (Update(dictonaryUp)) {
                    System.out.println("Updated.");
                } else {
                    System.out.println("Operation failed !");
                }
                break;
            case 3:
                String[] dictonaryDel = new  String[3];
                System.out.print("Word: ");
                dictonaryDel[1] =scanner.next();
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
                String[] dictonarySearch = new  String[3];
                System.out.print("Word: ");
                dictonarySearch[1] =scanner.next();
                if (!Control(dictonarySearch)) {
                    System.out.println("Not found !");
                    break;
                }
                int index = Search(dictonarySearch);
                System.out.println("Lesson : "+dictionaries.get(index)[0]+"\n"+"Word : "+dictionaries.get(index)[1]+"\n"+"Meaning : "+dictionaries.get(index)[2]+"\n");
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
