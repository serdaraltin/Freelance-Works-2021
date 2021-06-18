
public class soru5 {

    public static void main(String[] args) {

        //1000-10000 arasında dönen döngü yani 4 basamaklı değerleri dönen döngü
        for (int i = 1000; i < 10000; i++) {

            //o anki ilgili değerlerin tutulması için değişken tanımlamaları
            int number = i, originalNumber, remainder, result = 0, n = 0;

            //mevcut sayı farklı bir değişkende daha sonra karşılatırma işlemi için tutulması
            originalNumber = number;

            //originalNumber değişkeni 0 dan farklı olduğu sürece her adımda onu 10 değerine bölen be n değerini 1 arttıran döngü
            for (; originalNumber != 0; originalNumber /= 10, ++n);

            originalNumber = number;

            //yukarıdaki döngüden tek farkı n değeri önceden elde edildiği için n değeri ile döngü içinde işlem yapılması
            for (; originalNumber != 0; originalNumber /= 10) {
                //10 a bölümden kalanın ilgili değişkene aktarılması
                remainder = originalNumber % 10;
                //sonucun üzerine üs alma methoduna kalan ve n değerinin gönderilerek dönen değerin eklenmesi
                result += Math.pow(remainder, n);
            }
            //eğer ilgili işlemler sonucu sayı sonuc değerine eşitse kontrolü 
            if (result == number) {
                System.out.println(number);
            }

        }
    }
}
