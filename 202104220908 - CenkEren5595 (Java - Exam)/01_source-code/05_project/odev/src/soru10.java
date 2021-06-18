
public class soru10 {

    public static void main(String[] args) {
        
        //çift sayıların ve tek sayıların toplamlarını tutan değişkenler
        int toplamCift = 0, toplamTek = 0;

        //0-200 arasında ilerleyen döngü
        for (int i = 0; i <= 200; i++) {
            //o anki döngü değerinin 2 ye tam bölünmesi kontrolü, tam bölünüyorsa çift sayıdır
            if (i % 2 == 0) {
                //toplam değeri üzerine o anki değerin eklenmesi
                toplamCift += i;
            }
            //yukarıdaki şartın sağlanmaması yani sayının tek bir sayı olması durumu
            else {
                //toplam değeri üzerine o anki değerin eklenmesi
                toplamTek += i;
            }
        }
        
        //ekrana ilgili bilgilerin yazdırılması
        System.out.println("Tek sayilarin toplami (0-200): " + toplamTek);
        System.out.println("Cift sayilarin toplami (0-200): " + toplamCift);
    }
}
