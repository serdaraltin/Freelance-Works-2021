
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static class LNode {

        int studentId;
        String name, surname;

        public LNode(int item, String name, String surname) {
            studentId = item;
            this.name = name;
            this.surname = surname;
        }

        @Override
        public String toString() {
            return studentId + " " + name + " " + surname;
        }

    }

    static Scanner scanner = new Scanner(System.in);

    static BinarySearchTree bts = new BinarySearchTree();
    static LinkedList<LNode> linkedlist = new LinkedList<>();
    static Hashtable<Integer, String[]> hashtable = new Hashtable<>();
    static ArrayList<String> hashName = new ArrayList<>();
    static ArrayList<Integer> hashNameCount = new ArrayList<>();
    static ArrayList<String> names = new ArrayList<>();

    static void add(int studentId, String name, String surname) {
        bts.insert(studentId, name, surname);
        linkedlist.add(new LNode(studentId, name, surname));
        hashtable.put(studentId, new String[]{name, surname});
    }

    static void listDistinct() {
        names = new ArrayList<>();
        for (LNode lNode : linkedlist) {
            DistinctRec(lNode, names);
        }

    }

    static void DistinctRec(LNode node, ArrayList<String> names) {
        if (node != null) {
            boolean flag = true;
            for (String name : names) {
                if (name.equals(node.name)) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println(node.studentId + " " + node.name);
                names.add(node.name);
            }
        }
    }

    static void listNameCounts() {
        hashName = new ArrayList<>();
        for (LNode lNode : linkedlist) {
            listNameCountsRec(lNode, hashName);
        }

        for (int i = 0; i < hashName.size(); i++) {
            System.out.println(hashName.get(i) + " : " + hashNameCount.get(i));
        }
    }

    static void listNameCountsRec(LNode node, ArrayList<String> hashName) {
        if (node != null) {
            boolean flag = true;
            for (int i = 0; i < hashName.size(); i++) {
                if (hashName.get(i).equals(node.name)) {
                    flag = false;
                    hashNameCount.set(i, hashNameCount.get(i) + 1);
                    break;
                }
            }
            if (flag) {
                hashName.add(node.name);
                hashNameCount.add(1);
            }
        }
    }

    public static void main(String[] args) {

        //Bu kayıtlar örnektir silebilirsiniz
        add(180310101, "Ahmet", "Altan");
        add(180310102, "Kadir", "Yavuz");
        add(180310103, "Bekir", "Bilemis");
        add(180310104, "Serhat", "Keles");
        add(180310105, "Serhat", "Vatan");
        add(180310106, "Ayse", "Yagmus");
        add(180310107, "Sude", "Bal");
        add(180310108, "Sude", "Su");
        add(180310109, "Amile", "Vatan");

        menu();
    }

    public static void menu() {
        System.out.println("0. Exit");
        System.out.println("1. Add student");
        System.out.println("2. Delete student");
        System.out.println("3. Find student");
        System.out.println("4. List all students");
        System.out.println("5. List distinct names");
        System.out.println("6. List name counts");
        System.out.println("7. About");

        System.out.print("Enter your selection:");
        int choice = scanner.nextInt();

        int studentId;
        String name, surname, datas;

        switch (choice) {
            case 0:
                System.out.println("Closing...");
                System.exit(0);
                break;
            case 1:
                System.out.print("Student Id: ");
                studentId = scanner.nextInt();
                System.out.print("Name: ");
                name = scanner.next();
                System.out.print("Surname: ");
                surname = scanner.next();
                add(studentId, name, surname);
                break;
            case 2:
                System.out.print("Student Id: ");
                studentId = scanner.nextInt();
                bts.deleteKey(studentId);

                for (int i = 0; i < linkedlist.size(); i++) {
                    if (linkedlist.get(i).studentId == studentId) {
                        linkedlist.remove(i);
                        break;
                    }
                }
                hashtable.remove(studentId);
                break;
            case 3:
                System.out.print("Student Id: ");
                studentId = scanner.nextInt();
                BinarySearchTree.Node node = bts.search(bts.root, studentId);
                if (node != null) {
                    int level = bts.getLevel(bts.root, studentId);
                    System.out.println("level : " + level + "\n" + node.studentId + " " + node.name + " " + node.surname);
                }

                break;
            case 4:
                System.out.print("bts, linkedlist, hash : ");
                datas = scanner.next();
                if (datas.equals("bts")) {
                    bts.inorder();
                }
                if (datas.equals("linkedlist")) {
                    for (LNode lNode : linkedlist) {
                        System.out.println(lNode);
                    }
                }
                if (datas.equals("hash")) {
                    Enumeration<Integer> enumeration = hashtable.keys();

                    while (enumeration.hasMoreElements()) {
                        int key = enumeration.nextElement();
                        System.out.println(key + " " + hashtable.get(key)[0] + " " + hashtable.get(key)[1]);
                    }
                }
                break;
            case 5:
                listDistinct();
                break;
            case 6:
                listNameCounts();
                break;
            case 7:
                System.out.println("About : ali osman beker 180310100");
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }
        System.out.println("");
        menu();
    }

}
