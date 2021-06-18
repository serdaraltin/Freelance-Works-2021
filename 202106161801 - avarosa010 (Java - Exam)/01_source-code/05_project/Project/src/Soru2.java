
import java.util.Random;

public class Soru2 {

    public static void main(String[] args) {
        int a; //rastgele belirlenecek sayi icin degisken tanimi
        float aritmetikOrtalama = 0, harmonikOrtalama = 0, geometrikOrtalama = 1; //ortalamalari tutacak olan degiskenlerin tanimi

        Random random = new Random(); //Random sinifindan yeni bir nesne uretilmesi, rastgele sayilar uretilmesi icin

        a = random.nextInt(15) + 10; //10-25 (aralik=15), baslangic 10 olan rastgele bir sayinin uretilmesi ve a degiskenine atanmasi

        System.out.println("Rastgele Belirlenen Sayi : " + a + "\n"); //rastgele belirlenen degerin ekrana bastirilmasi

        for (int i = 0; i < a; i++) { // rastgele belirlenen deger kadar donen dongu
            int sayi = random.nextInt(100) + 1; // 1-100 arasinda rastgele bir sayinin belirlenmesi ve atanmasi

            aritmetikOrtalama += (float) sayi; //o anki rastgele belirlenene sayinin artimetikOrtalam degerine eklenmesi
            geometrikOrtalama *= sayi; //o anki rastgele belirlenene sayinin artimetikOrtalam degerine carpilarak eklenmesi
            harmonikOrtalama += 1 / (float) sayi; //o anki rastgele belirlenene sayinin artimetikOrtalam degerine 1/deger olarak eklenmesi

            System.out.println("Uretilen Sayi : " + sayi); // o an uretilen rastgele sayinin ekrana bastirilmasi

        }
        aritmetikOrtalama /= a; //toplam degerinin adete bolumu

        geometrikOrtalama = (float) Math.pow(geometrikOrtalama, (1 / (float) a)); // geometrik ortalamanin hesaplanmasi

        harmonikOrtalama = a / harmonikOrtalama; //harmonik ortalamanin hesaplanmasi

        System.out.println("\nAritmetik Ortalama : " + aritmetikOrtalama); //aritmetik oralama sonucunun ekrana bastirilmasi
        System.out.println("Geometrik Ortalama : " + geometrikOrtalama); //geometrik oralama sonucunun ekrana bastirilmasi
        System.out.println("Harmonik  Ortalama : " + harmonikOrtalama); //harmonik oralama sonucunun ekrana bastirilmasi

    }

}
