
import java.util.Scanner;

public class soru8 {

    //gelen parametreye gore Euler degerini hesaplayan ve geriye donduren method
    private static double Euler(int sayi) {
        //ilgili degiskenlerin tanimlanmasi
        double e = 1;
        double f = 1;
        
        //1 ile gelen parametre sayisina kadar donen dongu (sayi dahil)
        for (int i = 1; i <= sayi; i++) {
            //o anki f degerinin o anki dongu degeri ile islemden gecirilmesi ve tekrar f degerine esitlenmesi
            f = f * (1.0 / i);
            //f degeri sifir ise dongu kiriliyor
            if (f == 0) {
                break;
            }
            //e degeri uzerine o anki f degeri ekleniyor
            e += f;
        }
        //hesaplanan deger geriye donduruluyor
        return e;
    }

    public static void main(String[] args) {
        //ekrandan deger okunmasi icin scanner nesnesi tanimlanmasi
        Scanner input = new Scanner(System.in);
        System.out.print("Sayi: ");
        //kullanicidan sayi degerinin okunmasi
        int n = input.nextInt();
        //ilgili methoda sayi degeri gonderilerek Euler degerinin hesaplanmasi ve ekrana basitirlmasi
        System.out.println(Euler(n));

    }
}
