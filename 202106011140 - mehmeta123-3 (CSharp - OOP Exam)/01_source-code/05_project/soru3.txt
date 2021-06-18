using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace soru3
{
    class sinif
    {
        public int[] Hesapla(params int[] dizi)
        {
            int i,j=0;
            for (i = 0; i < dizi.Length; i++)
                if (dizi[i] % 2 != 0)
                    j++;

            int[] tekDizi = new int[j];
            i = 0;
            foreach (int sayi in dizi)
            {
                if (sayi % 2 != 0)
                    tekDizi[i++] = sayi;
            }

            return tekDizi;
        }
    }
    class Program
    {
    
        static void Main(string[] args)
        {
            sinif s = new sinif();
            int[] tekSayilar = s.Hesapla(7,20,60,111,14,65,90,125);

            for (int i = 0; i < tekSayilar.Length; i++)
            {
                Console.WriteLine(tekSayilar[i]);
            }

            Console.ReadKey();
            
        }
    }
}
