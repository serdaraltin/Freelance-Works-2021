
import java.util.Scanner;

public class soru2 {

    //parametre olarak aldığı değere kadar pi değerini hesaplayan ve geri döndüren method
    private static double PiHesapla(double n) {
        //pi değerini tutan değişken
        double pi = 0;
        //parametre değerine kadar dönen döngü
        for (int i = 1; i < n; i++) {
            //her adımda Math kütüphanesinden pow methodunu kullanarak o ani değere göre pi değeri üzerine ekleme yapma
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        //hesaplanan pi değerinin geriye döndürülmesi
        return 4 * pi;
    }

    public static void main(String[] args) {
        //ekrandan okuma için scanner nesnesi tanımlama
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Sayi: ");
        //sayi değerinin okunması
        int sayi = scanner.nextInt();
        
        //ilgili methodda sayi değerinin gönderilerek geriye dönen değerin ekrana bastırılması
        System.out.println("Sonuc: " + PiHesapla(sayi));

    }
}
