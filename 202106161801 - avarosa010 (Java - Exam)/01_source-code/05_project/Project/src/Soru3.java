
import java.util.Random;
import java.util.Scanner;


/*
(2,1) = 2 makas kağıdı kesiyor 
(1,0) = 1 kağıt taşı kaplıyor 
(0,3) = 0 taş kertenkeleyi eziyor
(3,4) = 3 kertenkele Spock’ı zehirliyor
(4,2) = 4 Spock makası kırıyor
(2,3) = 2 makas kertenkelenin başını kesiyor
(3,1) = 3 kertenkele kağıdı yiyor
(1,4) = 1 kağıt Spock’ı çürütüyor
(4,0) = 4 Spock taşı buharlaştırıyor
(2,0) = 0 taş makası kırıyor
 */
public class Soru3 {

    public static String TurBelirle(int a) { //gelen sayiya gore secilen ogenin ismini geriye donen method
        switch (a) {
            case 0: //gelen sayi 0 ise
                return "taş"; //geriye taş metnini dönme
            case 1: //gelen sayi 1 ise
                return "kağıt"; //geriye kağıt metnini dönme
            case 2: //gelen sayi 2 ise
                return "makas"; //geriye makas metnini dönme
            case 3: //gelen sayi 3 ise
                return "kertenkele"; //geriye kertenkele metnini dönme
            case 4: //gelen sayi 4 ise
                return "spock"; //geriye spock metnini dönme
            default: //yanlış bir değer geldi ise
                break;
        }
        return "hatali secim"; //hatalı bir değer varsa
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //ekrandan okuma icin Scanner sinifindan nesne uretilmesi
        int a = new Random().nextInt(5); //0-4 arasinda rastgele bir sayi uretilmesi (bilgisayar secimi)

        System.out.println("Taş=0, kağıt=1, makas=2, kertenkele=3, spock=4 >>");
        int b = scanner.nextInt(); //kullanicidan seciminin okunmasi

        System.out.println("Kullanicinin Secimi : " + TurBelirle(b)); //TurBelirle methoduna kullanicinin secimi parametre olarak verilerek donen degerin yazdirilmasi
        System.out.println("Bilgisayarin Secimi : " + TurBelirle(a)); //TurBelirle methoduna bilgisayarin secimi parametre olarak verilerek donen degerin yazdirilmasi

        
        if ((a == 2 && b == 1) || (a == 1 && b == 2)) { //2-1 veya 1-2 olma durumu
            System.out.println("makas kağıdı kesiyor"); //sonucun ekrana yazdirilmasi
        }
        if ((a == 1 && b == 0) || (a == 0 && b == 1)) { //1-0 veya 0-1 olma durumu
            System.out.println("kağıt taşı kaplıyor"); //sonucun ekrana yazdirilmasi
        }
        if ((a == 0 && b == 3) || (a == 3 && b == 0)) { //0-3 veya 3-0 olma durumu
            System.out.println("taş kertenkeleyi eziyor"); //sonucun ekrana yazdirilmasi
        }
        if ((a == 3 && b == 4) || (a == 4 && b == 3)) { //3-4 veya 4-3 olma durumu
            System.out.println("kertenkele Spock’ı zehirliyor");
        }
        if ((a == 4 && b == 2) || (a == 2 && b == 4)) { //4-2 veya 2-4 olma durumu
            System.out.println("spock makası kırıyor"); //sonucun ekrana yazdirilmasi
        }
        if ((a == 2 && b == 3) || (a == 3 && b == 2)) { //2-3 veya 3-2 olma durumu
            System.out.println("makas kertenkelenin başını kesiyor"); //sonucun ekrana yazdirilmasi
        }
        if ((a == 3 && b == 1) || (a == 1 && b == 3)) { //3-1 veya 1-3 olma durumu
            System.out.println("kertenkele kağıdı yiyor"); //sonucun ekrana yazdirilmasi
        }
        if ((a == 1 && b == 4) || (a == 4 && b == 1)) { //1-4 veya 4-1 olma durumu
            System.out.println("kağıt spockı çürütüyor"); //sonucun ekrana yazdirilmasi
        }
        if ((a == 4 && b == 0) || (a == 0 && b == 4)) { //401 veya 0-4 olma durumu
            System.out.println("Spock taşı buharlaştırıyor"); //sonucun ekrana yazdirilmasi
        }
        if ((a == 2 && b == 0) || (a == 0 && b == 2)) { //2-0 veya 0-2 olma durumu
            System.out.println("taş makası kırıyor"); //sonucun ekrana yazdirilmasi
        }

    }

}
