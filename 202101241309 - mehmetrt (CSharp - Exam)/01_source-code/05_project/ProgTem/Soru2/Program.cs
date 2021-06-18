using System;
using System.Collections.Generic;
using System.Text;

namespace Soru2
{
    class Program
    {
        static bool hesapla(int sayi)
        {
            int[] seri = new int[sayi];
            seri[0] = 1;
            seri[1] = 2;

            for (int i =2; i < seri.Length; i++)
            {
                int toplam = seri[i - 1] + seri[i - 2] + 1;
                seri[i] = toplam;

                if(toplam == sayi)
                {
                    return true;
                }
            }
            return false;
        }
        static void Main(string[] args)
        {
        
            Console.WriteLine(hesapla(7));
            Console.WriteLine(hesapla(11));
            Console.WriteLine(hesapla(15));
            Console.WriteLine(hesapla(20));
            Console.ReadKey();
        }
    }
}
