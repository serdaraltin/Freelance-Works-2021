package Part_II;

//ilgili kütüphanelerin dahil edilmesi
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
