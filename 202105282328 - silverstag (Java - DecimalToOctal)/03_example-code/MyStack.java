public class MyStack implements StackInterface {
    private int length;
    private  final int MAX_SIZE;

    
    private class MyNode {
        int value;
        MyNode next;
    }
    MyNode topNode;

    //  constructor for assign values and create object
    MyStack() {
        length = 0;     //  it is counter. It shows how many item stores in stack i used in isEmpty()
        MAX_SIZE = 10;  //  max size of stack , i will use it for isFull()
    }

    //  ALL METHODS HAVE EXPLANATION IN INTERFACE

    public void push(int i) {
        MyNode tempNode = new MyNode();
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
        }
        else {
            return "Stack is empty so there is no top element";
        }
    }
    public boolean isFull(){
        return length == MAX_SIZE;
    }
    public boolean isEmpty() {
        return length == 0;
    }
    public int size(){
        return length;
    }

    public String toString() {
        String willPrint = "";
        try {
            MyNode tempNode = topNode;
            for (int i=0 ; i <= size() ; i++) {
                willPrint+=tempNode.value+"";
                tempNode = tempNode.next;
            }
        }
        catch (Exception e) {
        }
        return willPrint;
    }
}