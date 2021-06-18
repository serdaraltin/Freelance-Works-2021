using System;
using System.Collections;

namespace ConsoleApp1
{
    class Program
    {
        //kendisine parametre olarak gelen karakterin bir operatör olup olmadığının kontrolünü yapan ve operatör ise true değilse false dönen method
        static bool operatorKontrol(char c)
        {
            //parametre olarak gelen karakterin "+-*/^' operatörlerinden birisi olma durumu kontrolü
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
            {
                //geriye true değer dönme
                return true;
            }
            //yukarıdaki kontrol sağlanmaz ise
            else
            {
                //geriye false değer dönme
                return false;
            }
        }

        //kendisine parametre olarak gelen metin değerini postfix ten infix e dönüştüren method
        static string postfix2Infix(string postfixMetin)
        {
            //yeni bir stack(yığın) oluşturma, değerler bu yığına aktarılacak
            Stack yigin = new Stack();

            //bir döngü ile parametre olarak gelen metnin tüm karakterlerini gezme
            for (int i = 0; i < postfixMetin.Length; i++)
            {
                //döngü içinde o anki karakterin operatör olmaması durumu kontrolü
                if (!operatorKontrol(postfixMetin[i]))
                {
                    //yığına o anki karakterin eklenmesi
                    yigin.Push(postfixMetin[i] + "");
                }
                //yukarıdaki koşulun sağlanmaması yani o anki karakterin bir operatör olması kontrolü
                else
                {
                    //eğer bir operatöre denk gelindi ve yığın boyutu 2 den küçükse kontrolü (bu durumda ifade hatalıdır)
                    if (yigin.Count < 2)
                    {
                        //geriye bilgi metni döndürme
                        return "Hatalı arttakı ifade";
                    }
                    //yığındaki son elemanın alınıp bir string değişkene atanması
                    string operator1 = (string)yigin.Peek();
                    //yığındaki son elemanın silinmesi
                    yigin.Pop();

                    //yığındaki son elemanın alınıp bir string değişkene atanması
                    string operator2 = (string)yigin.Peek();
                    //yığındaki son elemanın silinmesi
                    yigin.Pop();

                    //alınan son iki eleman ters sıra ile operator2 , o anki karakter, operator1 ve bu metnin başına sonuna parantezler
                    //konularak yığına ekleme yapılması
                    yigin.Push("(" + operator2 + postfixMetin[i] + operator1 + ")");
                }
            }
            //eğer sona gelindi ve yığında halen eleman varsa yani boş değilse kontrolü (bu durumda ifade hatalıdır)
            if (yigin.Count > 1)
            {
                //geriye bilgi metni döndürme
                return "Hatalı arttakı ifade";
            }

            //yığındaki son değerin yani nihayi infix değerinin geriye döndürülmesi
            return (string)yigin.Peek();
        }


        static void Main(string[] args)
        {

            //sonsuz döngü oluşturma, kullanıcıdan sürekli değer okuma ve işlem yapma için
            while (true)
            {
                //kullanıcıyı bilgilendirme
                Console.Write("\nArttakı ifade girin: ");
                //okunacak değer için string değişken tanımı
                string str;
                //ilgili değerin(arttakı) kullanıcıdan alınması
                str = Console.ReadLine();
                //kullanıcıyı bilgilendirme, gelen arttakı ifade değeri postfix2infix methoduna gönderilir ve geriye dönen değer konsola yazdırılır
                Console.WriteLine("İçtakı biçimi: " + postfix2Infix(str));

                //okunacak değer için string değişken tanımı
                string cevap;
                //kullanıcıyı bilgilendirme ve soru sorma
                Console.Write("\nDevam edilsin mi? (E/H): ");
                //cevabın bir değişkene atanması
                cevap = Console.ReadLine();
                //eğer cevap E veya e değilse döngünün kırılması/sonlandırılması
                if (!(cevap == "E" || cevap == "e"))
                    break;
            }
            //programın sonlandırıldığına dair bilgi metni
            Console.WriteLine("Programı sonlandırmak için herhangi bir tuşa basınız...");


            //konsolun doğrudan kapanmaması için kullanıcıdan herhangi bir değer okunmasının beklenmesi
            Console.ReadKey();
        }
    }
}
