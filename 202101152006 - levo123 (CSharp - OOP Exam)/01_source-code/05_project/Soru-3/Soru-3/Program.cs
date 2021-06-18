using System;


namespace Soru_3
{
    interface temelIslemler
    {
        int topla(int a, int b);
        int cikar(int a, int b);
        int bol(int a, int b);
        int carp(int a, int b);
    }

    class TemelIslemler : temelIslemler
    {
        public int topla(int a, int b)
        {
            return a + b;
        }
        public int cikar(int a, int b)
        {
            return a - b;
        }
        public int carp(int a, int b)
        {
            return a * b;
        }
        public int bol(int a, int b)
        {
            return a / b;
        }
    }
    interface kare
    {
        int kare(int a);
    }
    class KareIslemler : TemelIslemler
    {
        public int kare(int a)
        {
            return carp(a, a);
        }

    }

    interface kup
    {
        int kup(int a);
    }

    class KupIslemler : KareIslemler, kup
    {
        public int kup(int a)
        {
            return carp(a, kare(a));
        }
    }
    interface faktoriyel
    {
        int fakt(int a);
    }

    class Hesaplama : KupIslemler, faktoriyel
    {
        public int fakt(int a)
        {
            int faktsonuc = 1;
            for (int i = 2; i <= a; i++)
            {
                faktsonuc += carp(faktsonuc, i);
            }
            return faktsonuc;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Hesaplama hesaplama = new Hesaplama();

            Console.WriteLine("Çarpım (2,3)   : " + hesaplama.carp(2, 3));
            Console.WriteLine("Bölüm (10,2)   : " + hesaplama.bol(10, 2));
            Console.WriteLine("Toplam (4,3)   : " + hesaplama.topla(4, 3));
            Console.WriteLine("Fark (20,3)    : " + hesaplama.cikar(20, 3));
            Console.WriteLine("Kare (3)       : " + hesaplama.kare(3));
            Console.WriteLine("Kup (3)        : " + hesaplama.kare(3));
            Console.WriteLine("Faktoriyer (5) : " + hesaplama.fakt(5));
            Console.ReadKey();

        }
    }
}
