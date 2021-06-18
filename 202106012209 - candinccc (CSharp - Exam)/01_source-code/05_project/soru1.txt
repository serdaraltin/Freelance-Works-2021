using System;

namespace blm236
{
    class Program
    {
        static float Ortalama(int toplam, int adet)
        {
            return (float)toplam / adet;
        }

        static void Main(string[] args)
        {
            int kelimeAdet = 0;
            int toplamHarf = kelimeAdet;
            string kelime = "";
            string bitisKelimesi = "bitti";
            while (kelime != bitisKelimesi)
            {
                Console.Write("Kelime = ");
                kelime = Console.ReadLine();

                toplamHarf += kelime.Length;
                kelimeAdet++;
            }
            kelimeAdet--;
            toplamHarf -= bitisKelimesi.Length;

            Console.WriteLine("Harf Toplami : "+ toplamHarf);
            Console.WriteLine("Sozcuk Toplami : " + kelimeAdet);
            Console.WriteLine("Ortalama : " + Ortalama(toplamHarf, kelimeAdet));

            Console.ReadKey();
        }
    }
}
