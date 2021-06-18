using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace soru3
{
    class ornekSinif
    {
        public int[] tekSayilar(params int[] sayilar)
        {
            
            int adet = 0;
            foreach (int sayi in sayilar)
            {
                if (sayi % 2 != 0)
                    adet++;
            }
            int[] tekSayi = new int[adet];
            adet = 0;
            foreach (int sayi in sayilar)
            {
                if (sayi % 2 != 0)
                    tekSayi[adet++] = sayi;
            }

            return tekSayi;
        }
    }
    class Program
    {
        /*
        Değişken sayıda int tipinde parametre alabilen ve parametrelerinin tek olanlarından
        bir dizi oluşturarak bu diziyi dönen tekler adlı bir fonksiyon yazın (C#’ta C’den
        farklı olarak dizilerin de fonksiyonlardan dönülebildiğini hatırlayalım). Fonksiyon
        herhangi bir sınıf tipi tanımında yer alan bir üye metot olabilir. Örneğin,
        orneksinif adlı sınıfın public bir metodu olabilir. Bu durumda orneksinif
        tipinde bir nesnenin başvurusunun adı ob ise, fonksiyon ob.tekler(...?...)
        diye çağırılır. Örnek olarak, fonksiyona verilen parametrelerin değerleri sırasıyla 7, 20,
        60, 111, 14, 65, 90, 125 olursa (değişken sayıda parametrenin fonksiyona nasıl
        verilebileceği hakkındaki kararı siz verecek ve fonksiyon kodunu ona göre
        yazacaksınız), fonksiyondan dönülmesi gereken tamsayı dizisi [7, 111, 65, 125]
        olmalıdır.
        */
        

        static void Main(string[] args)
        {
            ornekSinif ob = new ornekSinif();


            foreach (int sayi in ob.tekSayilar(7, 20, 60, 111, 14, 65, 90, 125))
            {
                Console.Write(sayi+",");
            }
           

            Console.ReadKey();

        }
    }
}
