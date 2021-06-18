public interface StackInterface {
    void push(int i);           //  pushes items in to stack
    void pop();                 //  removes top element of stack
    boolean isEmpty();          //  checks stack is empty or not
    public String top();           //  returns value of top element
    public boolean isFull();    //  checks stack is full or not
    public int size();          //  returns size of Stack
}
