
import java.util.Scanner;

public class soru6 {

    /*
    Galibiyet ve mağlubiyet olacak. 29 kere sorulacak kullanıcıya.
    yenen takım 2 puan alacak kaybeden takım 1 puan alacak.
    Puanların toplamının yüzdesi %55'i geçen takım çeyrek finale kalıyor.
     */
    public static void main(String[] args) {
        //ekrandan değer okuma için scanner nesnesi tanımlanması
        Scanner scanner = new Scanner(System.in);
        //A ve B takimlarının puanlarının tutulması için değişken tanımlamaları
        float puanA = 0, puanB = 0;

        //0-29 arasında dönen döngü
        for (int i = 0; i < 29; i++) {
            //kazanan tanım bilgisinin okunması
            System.out.print("Yenen takim (A/B): ");
            String yenen = scanner.nextLine();

            //A takımı kazanmışsa
            if (yenen.equals("A") || yenen.equals("a")) {
                puanA += 2;
                puanB += 1;
            //B takımı kazanmışsa
            } else if (yenen.equals("B") || yenen.equals("b")) {
                puanA += 1;
                puanB += 2;
                
            } 
            //hatalı bir değer girilmişse, döngü tekrar aynı adımı tekrarlar
            else {
                System.out.println("Hatali giris, tekrar deneyiniz");
                i--;
            }

        }
        //A ve B takımı puanları toplamı
        float toplam = puanA + puanB;

        //yuzde 55 değerinin hesaplanması
        float yuzde = ((toplam / 100) * 55);

        //A takımı %55 i geçmişse
        if (puanA > yuzde) {
            System.out.println("A takimi ceyrek finale kaldi.");
        }
        //B takımı %55 i geçmişse
        else if (puanB > yuzde) {
            System.out.println("B takimi ceyrek finale kaldi.");
        }
        //A takımının puanı B den fazlaysa
        else if (puanA > puanB) {
            System.out.println("A takimi ceyrek finale kaldi.");
        } 
        //B takımının puanı A dan fazlaysa
        else if (puanB > puanA) {
            System.out.println("B takimi ceyrek finale kaldi.");
        }
    }
}
