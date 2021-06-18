import java.util.Scanner;
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
class myStack<T> implements Stack<T> {
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
        while(!isEmpty()){
            System.out.println(pop());
        }
    }

}

//ana sınıf
public class VaccineStock {
    //her bir öğe için tanımlı değişkenler
    public int serialNumber;
    public String countryName;
    public int numberOfVaccines;
    
    //sınıfın kurucu methodu (boş)
    public VaccineStock() {
        this.serialNumber = 0;
        this.countryName = "";
        this.numberOfVaccines = 0;
    }
    //sınıfın 2. kurucu methodu ilgili değerler parametre olarak
    public VaccineStock(int serialNumber, String countryName, int numberOfVaccines) {
        super();
        this.serialNumber = serialNumber;
        this.countryName = countryName;
        this.numberOfVaccines = numberOfVaccines;
    }
    //toString methodu aşırı yüklenerek sınıfın String olarak çağrılma işleminde ilgili değeri döndürmesi
    @Override
    public String toString() {
        return serialNumber + ", " + countryName + ", " + numberOfVaccines;
    }
    
    //myStack sınıfından VaccineStock türünde bir nesne tanımlama
    static myStack<VaccineStock> vStock = new myStack<VaccineStock>();

    //ekrandan okuma işlemleri için scanner nesnesi tanımlama
    static Scanner scanner = new Scanner(System.in);

    //stack ten çıkarma işlemi
    static void popItem() {
        VaccineStock deleted = vStock.pop();
        System.out.println(deleted.serialNumber + ", " + deleted.countryName + ", " + deleted.numberOfVaccines);
        return;
    }
    
    //stack e ekleme işlemi
    static void pushItem() {

        VaccineStock newVacSt = new VaccineStock();

        System.out.println("Enter ITEM DATA?");
        newVacSt.serialNumber = scanner.nextInt();
        scanner.nextLine();
        newVacSt.countryName = scanner.nextLine();
        newVacSt.numberOfVaccines = scanner.nextInt();

        vStock.push(newVacSt);
        return;
    }
    //seçim işlemleri için geriye değer döndürme
    static int action() {

        System.out.println("Enter COMMAND?");
        String command = scanner.nextLine();
        switch (command) {
            case "ADD":
                return 1;
            case "DELETE":
                return 2;
            case "EXIT":
                return 3;
            default:
                break;
        }
        return 0;
    }
    //main methodu, programın başlangıcı
    public static void main(String[] args) {
        //EXIT komutu verilene kadar dönen döngü
        while (true) {
            //action methodundan dönen değerin kontrolü ve ilgili işlemin yapılması
            int rvalue = action();
            switch (rvalue) {
                case 1:
                    pushItem();
                    scanner.nextLine();
                    break;
                case 2:
                    popItem();
                    break;
                case 3:
                    vStock.print();
                    System.exit(0);
                    break;

                default:
                    System.exit(0);
            }

        }
    }

}
