using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace soru3
{
   
    class Program
    {

        static int[] TekSayilariBul(params int[] sayiDizisi)
        {
            int[] geciciDizi = new int[sayiDizisi.Length];

            int a = 0;
            foreach (int sayi in sayiDizisi)
                if (sayi % 2 != 0)
                    geciciDizi[a++] = sayi;

            int[] sonucDizisi = new int[a];

            for (int i = 0; i < a; i++)
            {
                sonucDizisi[i] = geciciDizi[i];
            }

            return sonucDizisi;
        }
        static void Main(string[] args)
        {

            foreach (int sayi in TekSayilariBul(7, 20, 60, 111, 14, 65, 90, 125))
            {
                Console.Write(sayi+" ");
            }
           

            Console.ReadKey();

        }
    }
}
