
import java.util.Random;

public class Soru4 {

    public static void main(String[] args) {
        int[][] dizi = new int[10][2]; //10 satir 2 sutun olan dizinin tanimlanmasi
        int min = -10; //minimum degerinin tutan degisken ve degeri
        int max = 11; //maximum degerinin tutan degisken ve degeri

        Random random = new Random(); //Random sinifindan yeni bir nesne uretilmesi, rastgele sayilar uretmek icin

        for (int i = 0; i < 10; i++) { //10 defa donen dongu
            for (int j = 0; j < 2; j++) { //2 defa donen dongu
                int rastgeleSayi = random.nextInt(max - min) + min; // -10-10 arasinda rastgele sayi uretilmesi
                dizi[i][j] = rastgeleSayi; //uretilen sayinin o anki dizi indisine atanmasi
            }
        }

        for (int i = 0; i < 10; i++) { //10 defa donen dongu
            System.out.println("x=" + dizi[i][0]+",y=" + dizi[i][1]);  //o anki indis degerindeki 1. ve 2. sutunlardaki degerlerin ekrana bastirilmasi
        }
    }

}
