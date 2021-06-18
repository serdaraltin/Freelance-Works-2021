using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp3
{
    class Program
    {
        public static double minmaxort(params int[] dizi)
        {
            int kucuk = dizi[0];
            int buyuk = dizi[0];

            for (int i = 0; i < dizi.Length; i++)
            {
                if(dizi[i] > buyuk)
                {
                    buyuk = dizi[i];
                }
            }
            for (int i = 0; i < dizi.Length; i++)
            {
                if (dizi[i] < kucuk)
                {
                    kucuk = dizi[i];
                }
            }

            double toplam= ((double)buyuk+(double)kucuk);

            return toplam/2.0;
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Test(55,32,12,10) : " + minmaxort(55, 32, 12, 10));
            Console.WriteLine("Test(1,2,9) : " + minmaxort(1, 2, 9));
            Console.WriteLine("Test(111,-10,0,10,5,8) : " + minmaxort(111, -10, 0, 10, 5, 8));
            Console.WriteLine("Test(5,32,3,80,63,22,99,125) : " + minmaxort(5, 32, 3, 80, 63, 22, 99, 125));

            Console.ReadKey();
        }
    }
}
