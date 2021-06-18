
import java.util.ArrayList;
import java.util.LinkedList;
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

    int getLevelUtil(Node node, int data, int level) {
        if (node == null) {
            return 0;
        }

        if (node.studentId == data) {
            return level;
        }

        int downlevel = getLevelUtil(node.left, data, level + 1);
        if (downlevel != 0) {
            return downlevel;
        }

        downlevel = getLevelUtil(node.right, data, level + 1);
        return downlevel;
    }

    int getLevel(Node node, int data) {
        return getLevelUtil(node, data, 1);
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

    /*void listDistinct() {
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
                System.out.println(root.studentId + " " + root.name );
                names.add(root.name);
            }
            DistinctRec(root.left, names);
            DistinctRec(root.right, names);
        }
    }*/

 /*   void listNameCounts() {
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
    }*/
}
