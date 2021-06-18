package Part_I;

import java.util.EmptyStackException;

//myStack sınıfı için generic interface tanımlaması
interface Stack<T> {
    //stack boyutunu döndürme

    public int size();
    //stack boş ise true değil ise false döndürme

    public boolean isEmpty();
    //stack en üst item döndürme

    public T top() throws EmptyStackException;
    //stack içine eleman ekleme

    public void push(T element);
    //stack içinden eleman çıkarma

    public T pop() throws EmptyStackException;
    //stack yazdırma

    public void print();
}

//linkedlist için node(düğüm) tanımlaması
class Node<T> {
    //generic eleman tanımı

    private T element;
    //düğümün sonraki elemanı
    private Node<T> next;

    //sınıfın kurucu methodu
    public Node() {
        this(null, null);
    }
    //sınıfın 2. kurucu methodu başlangıç ve ardındaki elemanı parametre olarak almakta

    public Node(T e, Node<T> n) {
        element = e;
        next = n;
    }
    //mevcut durumdaki elemanı döndürme

    public T getElement() {
        return element;
    }
    //mevcut durumdan sonraki elemanı döndürme

    public Node<T> getNext() {
        return next;
    }
    //yeni eleman ekleme

    public void setElement(T newElem) {
        element = newElem;
    }
    //yeni elemanın sonrakisini belirleme

    public void setNext(Node<T> newNext) {
        next = newNext;
    }
}

//myStack sınıfı Stack intefacesini implemente etmektedir, generic sınıf
public class myStack<T> implements Stack<T> {
    //en üst elemanı gösteren düğüm

    protected Node<T> top;
    //stack boyutu
    protected int size;

    //sınıfın kurucu methodu
    public myStack() {
        top = null;
        size = 0;
    }
    //stack boyutunu döndürme

    @Override
    public int size() {
        return size;
    }
    //stack in boş olma durumunu döndürme

    @Override
    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }
    //stack in en üst elemanını döndürme

    @Override
    public T top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getElement();
    }
    //stack e eleman ekleme

    @Override
    public void push(T element) {
        Node<T> v = new Node<T>(element, top);
        top = v;
        size++;
    }
    //stack ten eleman çıkarma

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T temp = top.getElement();
        top = top.getNext();
        size--;
        return temp;
    }
    //stack teki elemanları yazdırma
    @Override
    public void print() {
        Node<T> temp = top;
        while (temp.getElement() != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

}
