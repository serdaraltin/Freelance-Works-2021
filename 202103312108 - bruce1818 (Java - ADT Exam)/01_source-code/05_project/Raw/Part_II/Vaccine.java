
//ilgili kütüphanelerin dahil edilmesi
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
class myQueue<Item> implements Queue<Item> {

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

public class Vaccine {
    //sınıfa ait ilgili değerlerin değişkenleri
    public String nameOfGroup;
    public int numberOfStudent;
    
    //kurucu method ilgili değerleri parametre olarak almaktadır
    public Vaccine(String nameOfGroup, int numberOfStudent) {
        this.nameOfGroup = nameOfGroup;
        this.numberOfStudent = numberOfStudent;
    }

    //kurucu method (boş)
    public Vaccine() {
    }

    //toString methodunun ezilerek sınıftan türetilen nesnenin çağrıldığı string alanında ilgili değerin döndürülmesi
    @Override
    public String toString() {
        return nameOfGroup + " " + numberOfStudent;
    }
    
    //dosyadan okuma ve dosyadaki satırları bir String listesi olarak geriye döndürme
    public static List<String> fileRead(String filePath) {
        try {
            Path path = Paths.get(filePath);
            List<String> data = Files.readAllLines(path, StandardCharsets.UTF_8);
            return data;
        } catch (IOException ex) {
            Logger.getLogger(Vaccine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //ana method programın başlangıcı
    public static void main(String[] args) {
        //ilgili dosyanın okunması ve bir string listesine atanması
        List<String> lines = fileRead("COVID19.txt");

        //vQueue adında Vaccine türünde bir kuyruk tanımlama ve sağlık ocağı kapasitesinin
        //parametre olarak dosyadan okundan ilk satırın verilmesi
        myQueue<Vaccine> vQueue = new myQueue<>(Integer.valueOf(lines.get(0)));

        //ilgili değerlerin değişken tanımlamaları
        int numOfDay = 1;
        int numOfStudent = 0;
        int totalStudent = 0;
        
        System.out.print("Day"+numOfDay+": ");
        
        //bir döngü içinde dosyadaki tüm öğrenci gruplarının gezilmesi
        for (int i = 1; i < lines.size(); i++) {
            //o anki satırın bir diziye atanması
            String[] lineArray = lines.get(i).split(" ");
            Vaccine newItem = new Vaccine();

            //satırdaki grup adı
            newItem.nameOfGroup = lineArray[0];
            //satırdaki öğrenci sayısı
            newItem.numberOfStudent = Integer.valueOf(lineArray[1]);

            //eğer o anki öğrenci sayısı ve yeni gelecek öğrenci sayısı kapasiteyi aşıyorsa yeni bir güne geçilmesi
            if((numOfStudent + newItem.numberOfStudent) > 50){
                //yeni gün
                numOfDay++;
                numOfStudent = newItem.numberOfStudent;
                System.out.println();
                System.out.print("Day"+numOfDay+": ");
               
            }
            //yukardaki koşul sağlanmıyorsa ve kapasite aşılmıyorsa
            else{
                numOfStudent+=newItem.numberOfStudent;
            }
            //o an okunan satırın yazdırılması
            System.out.print(lines.get(i)+" ");
            //toplam öğrenci sayısının atanması
            totalStudent+=newItem.numberOfStudent;
            vQueue.enqueue(newItem);
        }
        //ilgili bilgilerin yazdırılması ve programın sonlandırılması
        System.out.println("\nTotal Student: "+totalStudent);
        System.out.println("Total Day: "+numOfDay);
        

    }
}
