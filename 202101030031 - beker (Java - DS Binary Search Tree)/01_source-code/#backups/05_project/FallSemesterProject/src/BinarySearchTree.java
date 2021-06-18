
import java.util.ArrayList;
import java.util.Scanner;

class BinarySearchTree {

    class Node {
        int studentId;
        String name, surname;
        Node left, right;

        public Node(int item, String name, String surname) {
            studentId = item;
            this.name = name;
            this.surname = surname;
            left = right = null;
        }
    }

    Node root;
    static Scanner scanner = new Scanner(System.in);
    static BinarySearchTree tree = new BinarySearchTree();
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> hashName = new ArrayList<>();
    static ArrayList<Integer> hashNameCount = new ArrayList<>();

    BinarySearchTree() {
        root = null;
    }

    void deleteKey(int studentId) {
        root = deleteRec(root, studentId);
    }

    Node deleteRec(Node root, int studentId) {

        if (root == null) {
            return root;
        }

        if (studentId < root.studentId) {
            root.left = deleteRec(root.left, studentId);
        } else if (studentId > root.studentId) {
            root.right = deleteRec(root.right, studentId);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.studentId = minValue(root.right);

            root.right = deleteRec(root.right, root.studentId);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.studentId;
        while (root.left != null) {
            minv = root.left.studentId;
            root = root.left;
        }
        return minv;
    }

    public Node search(Node root, int studentId) {
        if (root == null || root.studentId == studentId) {
            return root;
        }

        if (root.studentId < studentId) {
            return search(root.right, studentId);
        }

        return search(root.left, studentId);
    }

    void insert(int studentId, String name, String surname) {
        root = insertRec(root, studentId, name, surname);
    }

    Node insertRec(Node root, int studentId, String name, String surname) {
        if (root == null) {
            root = new Node(studentId, name, surname);
            return root;
        }

        if (studentId < root.studentId) {
            root.left = insertRec(root.left, studentId, name, surname);
        } else if (studentId > root.studentId) {
            root.right = insertRec(root.right, studentId, name, surname);
        }

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.studentId + " " + root.name + " " + root.surname);
            inorderRec(root.right);
        }
    }

    void listDistinct() {
        names = new ArrayList<>();
        DistinctRec(root, names);
    }

    void DistinctRec(Node root, ArrayList<String> names) {
        if (root != null) {
            boolean flag = true;
            for (String name : names) {
                if (name.equals(root.name)) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println(root.studentId + " " + root.name + " " + root.surname);
                names.add(root.name);
            }
            DistinctRec(root.left, names);
            DistinctRec(root.right, names);
        }
    }

    void listNameCounts() {
        hashName = new ArrayList<>();
        listNameCountsRec(root, hashName);
        for (int i = 0; i < hashName.size(); i++) {
            System.out.println(hashName.get(i) + " : " + hashNameCount.get(i));
        }
    }

    void listNameCountsRec(Node root, ArrayList<String> hashName) {
        if (root != null) {
            boolean flag = true;
            for (int i = 0; i < hashName.size(); i++) {
                if (hashName.get(i).equals(root.name)) {
                    flag = false;
                    hashNameCount.set(i, hashNameCount.get(i) + 1);
                    break;
                }
            }
            if (flag) {
                hashName.add(root.name);
                hashNameCount.add(1);
            }
            listNameCountsRec(root.left, hashName);
            listNameCountsRec(root.right, hashName);
        }
    }

    public static void main(String[] args) {

    	//Bu kayıtlar örnektir silebilirsiniz
        tree.insert(50, "Ahmet", "Altan");
        tree.insert(30, "Kadir", "Yavuz");
        tree.insert(20, "Bekir", "Bilemis");
        tree.insert(40, "Serhat", "Keles");
        tree.insert(66, "Serhat", "Vatan");
        tree.insert(70, "Ayse", "Yagmus");
        tree.insert(77, "Sude", "Bal");
        tree.insert(60, "Sude", "Su");
        tree.insert(80, "Amile", "Vatan");

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
        String name, surname;

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
                tree.insert(studentId, name, surname);
                break;
            case 2:
                System.out.print("Student Id: ");
                studentId = scanner.nextInt();
                tree.deleteKey(studentId);
                break;
            case 3:
                System.out.print("Student Id: ");
                studentId = scanner.nextInt();
                Node node = tree.search(tree.root, studentId);
                System.out.println(node.studentId + " " + node.name + " " + node.surname);
                break;
            case 4:
                tree.inorder();
                break;
            case 5:
                tree.listDistinct();
                break;
            case 6:
                tree.listNameCounts();
                break;
            case 7:
                System.out.println("About : ...");
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }
        System.out.println("");
        menu();
    }

}
