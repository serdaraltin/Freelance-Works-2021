using System;

namespace blm236
{
    class Program
    {
        /*
            Kullanıcıdan, kullanıcının girdisi “bitti” dizgisi olana kadar sırayla dizgiler okuyan
            ve okuduğu dizgilerdeki (son okuduğu “bitti” dizgisi hariç) ortalama karakter
            sayısını çıktılayan tam bir C# programı yazın. Örneğin okunan dizgiler sırasıyla,
            “blm236”, “nesneye”, “dayali”, “programlama”, “final”, “sinavini”, “da”,
            “sonunda”, “verdik” , “yasasin”, “bitti” olursa okunan dizgilerin toplam karakter
            sayisi 6 + 7 + 6 + 11 + 5 + 8 + 2 + 7 + 6 + 7 = 65 olur. Toplam on (10) dizgi okunduğu
            için, çıktılanması gereken değer 65/10 = 6.50 olacaktır.
            Not: Herhangi bir dizgiyi standart girdi aracından (klavyeden) okumanın yolu
            str = System.Console.Readline(); kodunu kullanmaktır:
         */
        static void Main(string[] args)
        {
            int adet = 0, toplam = 0;
            float ortalama = 0;

            string girdi = "";
            while (true)
            {
                Console.Write("Kelime Giriniz: ");
                girdi = Console.ReadLine();

                if (girdi == "bitti")
                    break;
                toplam += girdi.Length;
                adet++;
                ortalama = (float)toplam / adet;
            }

            Console.WriteLine(toplam + "/" + adet + " = " + ortalama);

            Console.ReadKey();
        }
    }
}
