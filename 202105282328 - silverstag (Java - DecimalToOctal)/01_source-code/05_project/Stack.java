public class Stack {
    private int length;
    private final int MAX_SIZE;

    private class Node {
        int value;
        Node next;
    }

    Node topNode;

    Stack() {
        length = 0;
        MAX_SIZE = 20;
    }

    public void push(int i) {
        Node tempNode = new Node();
        if (!isFull()) {
            length++;
            tempNode.value = i;
            tempNode.next = topNode;
            topNode = tempNode;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            length--;
            topNode = topNode.next;
        }
    }

    public String top() {
        if (!isEmpty()) {
            return String.valueOf(topNode.value);
        } else {
            return "Stack is empty so there is no top element";
        }
    }

    public boolean isFull() {
        return length == MAX_SIZE;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public String toString() {
        String willPrint = "";
        try {
            Node tempNode = topNode;
            for (int i = 0; i <= size(); i++) {
                willPrint += tempNode.value + "";
                tempNode = tempNode.next;
            }
        } catch (Exception e) {
        }
        return willPrint;
    }
}