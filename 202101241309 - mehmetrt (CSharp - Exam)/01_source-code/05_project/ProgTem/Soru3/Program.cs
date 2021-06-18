using System;
using System.Collections.Generic;
using System.Text;

namespace Soru3
{
    class Program
    {
        static int asal(int[] dizi)
        {
            int asalToplam = 0;
            int sayi = 0;
            for (int i = 0; i < dizi.Length; i++)
            {
                sayi = dizi[i];
                bool kontrol = true;
                for (int j = 2; j < sayi; j++)
                {
                    if (sayi % j == 0)
                    {
                        kontrol = false;
                        break;
                    }
                }
                if (kontrol)
                    asalToplam++;
                
            }
            return asalToplam;
        }

        static void Main(string[] args)
        {
            Console.WriteLine(asal(new int[] { 3, 45, 67, 8, 19, 4 }));
            Console.ReadKey();
        }
    }
}
