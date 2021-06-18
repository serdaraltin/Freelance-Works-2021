using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using dllKutuphane;

namespace ArdisikSayilar
{
    class Program
    {
        static void Main(string[] args)
        {
            Ardisik ardisikSayilar = new Ardisik();

            Console.Write("İlk Terim : ");
            ardisikSayilar.IlkTerim = Convert.ToInt32(Console.ReadLine());
            Console.Write("Son Terim : ");
            ardisikSayilar.SonTerim = Convert.ToInt32(Console.ReadLine());
            Console.Write("Artış Miktarı : ");
            ardisikSayilar.ArtisMiktari = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Ortanca Terim : " + ardisikSayilar.ortancaTerim());
            Console.WriteLine("Terim Sayısı : " + ardisikSayilar.terimSayisi());
            Console.WriteLine("Dizi Toplamı : " + ardisikSayilar.diziToplam());

            Console.ReadKey();
        }
    }
}
