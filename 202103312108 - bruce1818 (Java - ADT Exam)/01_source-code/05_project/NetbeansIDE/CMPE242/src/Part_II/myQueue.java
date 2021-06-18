package Part_II;

import java.util.NoSuchElementException;

//myQueue sınıfı için interface tanımlaması
interface Queue<Item> {

    //boş olma durumunda true değilse false döndürme
    public boolean isEmpty();

    //dolu olma durumunda true değilse false döndürme
    public boolean isFull();

    //o an kuyruktaki eleman sayısını döndürme
    public int size();

    //kuyruğa yeni eleman ekleme
    public void enqueue(Item item);

    //kuyruktan eleman çıkarma
    public Item dequeue();

    //kuyruğun ilk elemanını dönrüme
    public Item peek();

    //seçim işlemleri
    public int action();

    //kuyruktaki elemanları yazdırma
    public void print();
}

//Queue interfacesini implamente eden generic sınıf
public class myQueue<Item> implements Queue<Item> {

    //başlangıç kapasitesi
    private final static int INIT_CAPACITY = 4;
    //sağlık ocağı kapasitesi
    public int capacityOfHealtyCenter;

    //kuyruk için dizi, boyut, ilk eleman ve son eleman değişkenleri
    private Item[] q;
    private int n;
    private int first;
    private int last;

    //kurucu method, sağlık ocağı kapasitesini parametre olarak almaktadır
    public myQueue(int capacity) {
        capacityOfHealtyCenter = capacity;
        q = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    //boş olma durumunda true değilse false döndürme
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    //dolu olma durumunda true değilse false döndürme
    @Override
    public boolean isFull() {
        return INIT_CAPACITY == n;
    }

    //o an kuyruktaki eleman sayısını döndürme
    @Override
    public int size() {
        return n;
    }

    //kuyruğun dolması durumunda kapasitesini 2 katına çıkarma
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];

        for (int i = 0; i < n; i++) {
            copy[i] = q[(first + i) % q.length];
        }

        q = copy;
        first = 0;
        last = n;
    }

    //kuyruğa yeni eleman ekleme
    @Override
    public void enqueue(Item item) {
        if (n == q.length) {
            resize(2 * q.length);
        }
        q[last++] = item;
        if (last == q.length) {
            last = 0;
        }
        n++;
    }

    //kuyruktan eleman çıkarma
    @Override
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = q[first];
        q[first] = null;
        n--;
        first++;
        if (first == q.length) {
            first = 0;
        }
        if (n > 0 && n == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }

    //kuyruğun ilk elemanını dönrüme
    @Override
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return q[first];
    }

    //seçim işlemleri
    @Override
    public int action() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //kuyruktaki elemanları yazdırma
    @Override
    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(q[i]);
        }
    }

}
