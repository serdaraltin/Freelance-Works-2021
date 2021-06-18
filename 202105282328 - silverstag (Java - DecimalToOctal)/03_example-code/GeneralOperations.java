import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GeneralOperations {

    public static String[] readFile(String path) {
        try {
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[length];
            for (String line : Files.readAllLines(Paths.get(path))) {
                results[i++] = line;
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //  Method which reads queue and stack , creates Array
    public static String[] readFirstLine(String path) {
        String firstLine = "";
        try {
            firstLine = Files.readAllLines(Paths.get(path)).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstLine.split(" ");
    }

    //  Method for creating 2 Dimensional Arrays
    public static String[][] creatingArr(String[] myArr) {
        String lastArray[][] = new String[myArr.length][];
        for (int i = 0; i < myArr.length; i++) {
            String[] line = myArr[i].split(" ");
            lastArray[i] = new String[line.length];
            lastArray[i] = line;
        }
        return lastArray;
    }

    // Method for creating useful data list
    public static List<Integer> creatingList(String[] myArr){
        List<Integer> dataList = new ArrayList<>();
        for (String x : myArr){
            dataList.add(Integer.parseInt(x));
        }
        return dataList;
    }

    public static void Write(String s){
        File output = new File("octal.txt");
        try {
            FileWriter fw = new FileWriter(output,true);
            fw.write(s + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error has occurred");
        }
    }
}