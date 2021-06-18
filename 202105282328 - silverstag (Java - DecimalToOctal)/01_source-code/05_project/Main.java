import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String[] FileRead(String path) {
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

    public static String[] FirstLine(String path) {
        String firstLine = "";
        try {
            firstLine = Files.readAllLines(Paths.get(path)).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstLine.split(" ");
    }

    public static String[][] ArrayCreate(String[] arr) {
        String lastArray[][] = new String[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            String[] line = arr[i].split(" ");
            lastArray[i] = new String[line.length];
            lastArray[i] = line;
        }
        return lastArray;
    }

    public static List<Integer> ListCreate(String[] arr) {
        List<Integer> dataList = new ArrayList<>();
        for (String x : arr) {
            dataList.add(Integer.parseInt(x));
        }
        return dataList;
    }

    public static void Write(String s) {
  
        File output = new File("octal.txt");
        try {
            FileWriter fw = new FileWriter(output, true);
            fw.write(s + "\n");
            fw.close();
            
        } catch (IOException e) {
            System.out.println("Error has occurred");
        }
         
        for(String satir : s.split("\n")){
            System.out.println(satir);
        }
      
    }

    public static void main(String[] args) {
        String[] decimals_ = FileRead(args[0]);
        int[] decimals = StringToInt(decimals_);
        Process(decimals);
    }

    public static int[] StringToInt(String[] s) {
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }

    public static void Process(int[] d) {
        for (int x : d) {
            int tmp = x;
            Stack stack = new Stack();
            while (tmp > 0) {
                int mod = tmp % 8;
                stack.push((int) mod);
                int div = (int) tmp / 8;
                tmp = div;
            }
            Write(stack.toString());
        }
    }
}