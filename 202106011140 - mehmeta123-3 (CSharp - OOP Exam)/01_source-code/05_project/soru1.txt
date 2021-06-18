using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace soru1
{
    class Program
    {
        static void Main(string[] args)
        {
            int kelime_sayisi = 0;
            int harf_toplam = 0;
            string girdi = string.Empty;
            float ort = 0;
            for (;;)
            {
                Console.Write("Sozcuk : ");
                girdi = Console.ReadLine();

                if (girdi == "bitti")
                    break;
                harf_toplam += girdi.Length;
                kelime_sayisi++;
                ort = (float)harf_toplam / kelime_sayisi;
            }

            Console.WriteLine("Sonuc : " + ort);

            Console.ReadKey();
        }
    }
}
