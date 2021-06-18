
import java.util.Scanner;

public class soru7 {

    //gelen parametreye göre %5 sapma ile maddenin sicakligi ile verilen sicakligin birbirini tutmasının değerlendirilmesi
    static boolean kaynamaKontrol(int sicaklik, int madde) {
        //o anki madde sıcaklıginin %5 inin hesaplanması
        int yuzdeBes = (madde / 100) * 5;

        //ilgili maddenin -%5 ve +%5 degerleri arasinda ise sicaklik degeri geriye true deger donulmesi
        if (sicaklik >= madde - yuzdeBes && sicaklik <= madde + yuzdeBes) {
            return true;
        }
        //yukaridaki sart saglanmisyorsa geriye false deger donulmesi
        return false;
    }

    public static void main(String[] args) {
        
        //ekrandan okuma icin scanner nesnesi tanimi
        Scanner scanner = new Scanner(System.in);
        //ilgil maddelerin kaynama noktalarinin degiskenlere atanmasi
        int su = 100, civa = 357, bakir = 1187, gumus = 2193, altin = 2660;

        System.out.print("Sicaklik: ");
        //sicaklik degerinin okunmasi
        int sicaklik = scanner.nextInt();

        //ilgili methoda o anki sicaklik degeri ve su maddesinin sicaklik degerinin gonderilmesi, donen sonuc true(yani kaynama eslesiyorsa) ise
        if (kaynamaKontrol(sicaklik, su)) {
            System.out.println("Kaynama Noktasi : Su");
        } 
        //ilgili methoda o anki sicaklik degeri ve civa maddesinin sicaklik degerinin gonderilmesi, donen sonuc true(yani kaynama eslesiyorsa) ise
        else if (kaynamaKontrol(sicaklik, civa)) {
            System.out.println("Kaynama Noktasi : Civa");
        }
        //ilgili methoda o anki sicaklik degeri ve bakir maddesinin sicaklik degerinin gonderilmesi, donen sonuc true(yani kaynama eslesiyorsa) ise
        else if (kaynamaKontrol(sicaklik, bakir)) {
            System.out.println("Kaynama Noktasi : Bakir");
        } 
        //ilgili methoda o anki sicaklik degeri ve gumus maddesinin sicaklik degerinin gonderilmesi, donen sonuc true(yani kaynama eslesiyorsa) ise
        else if (kaynamaKontrol(sicaklik, gumus)) {
            System.out.println("Kaynama Noktasi : Gumus");
        } 
        //ilgili methoda o anki sicaklik degeri ve altin maddesinin sicaklik degerinin gonderilmesi, donen sonuc true(yani kaynama eslesiyorsa) ise
        else if (kaynamaKontrol(sicaklik, altin)) {
            System.out.println("Kaynama Noktasi : Altin");
        }
        //yukasridaki sartlarin hicbiri saglanmiyorsa, yani sicaklik hicbir madde ile uyusmuyorsa
        else {
            System.out.println("5 maddeden biri degildir.");
        }

    }
}
