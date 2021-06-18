
import java.util.Scanner;


public class soru4 {

    //gelen parametrelere göre katsayı hesabı yapam method
    static int ikiTerimliKatsayi(int n, int k) {
        int res = 1;

        //eğer k, n-k değerinden büyük ise
        if (k > n - k) {
            k = n - k;
        }
        //0 dan k değerine kadar dönen döngü
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        //ilgili değerin geriye döndürülmesi
        return res;
    }

    //gelen parametre değerine göre paskal ücgenini yazdıran method
    static void yazdirPaskal(int n) {
        //0 ile parametre değerine kadar dönen döngü
        for (int line = 0; line < n; line++) {
            //0 ile o anki döngü değerine kadar dönen döngü
            for (int i = 0; i <= line; i++) {
                //üst methoda o anki satir ve satırın sayısı kadar döngü içindeki değerlerin sırasıyla gönderilmesi
                //sonucu dönen değerlerin ekrana bastırılması
                System.out.print(ikiTerimliKatsayi(line, i) + " ");
            }
            //bir satır boşluk
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //ekrandan okuma için scanner nesnesi tanımlama
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Satir: ");
        //satır değerinin kullanıcıdan okunması
        int n = scanner.nextInt();
        //satır değerinin paskal üçgeninin üreten methoda parametre olarak gönderilmesi
        yazdirPaskal(n);
    }
}
