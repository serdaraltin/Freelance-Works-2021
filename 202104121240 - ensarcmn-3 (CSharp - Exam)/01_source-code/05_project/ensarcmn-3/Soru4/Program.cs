using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Soru4
{
    class Program
    {
        static double minmaxort(params int[] sayilar)
        {
            int enBuyuk = sayilar[0], enKucuk = sayilar[0];
 
            for (int i = 0; i < sayilar.Length; i++)
            {
                enBuyuk = (enBuyuk < sayilar[i]) ? sayilar[i] : enBuyuk;
                enKucuk = (enKucuk > sayilar[i]) ? sayilar[i] : enKucuk;
            }
           
            return ((float)enKucuk + (float)enBuyuk)/2.0;
        }
        static void Main(string[] args)
        {

            int[] sayilar = new int[256];

            int i = 0;
            while (true)
            {
                Console.Write("Bir sayi giriniz : ");
                sayilar[i++] = Convert.ToInt32(Console.ReadLine());
                Console.Write("Sayi eklemek istiyor musunuz ? (E/H) : ");
                string cevap = Console.ReadLine();
                if (!(cevap == "E" || cevap == "e"))
                    break;
            }
            Console.WriteLine("Ortalama Sonuc : " + minmaxort(sayilar));

            Console.ReadKey();
        }
    }
}
