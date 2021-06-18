using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp2
{
    class Program
    {
        static void Main(string[] args)
        {
            dortgen sekil = new dortgen();
            Console.WriteLine("Parametre Yok : " + sekil.cevreHesapla());
            sekil = new dortgen(1);
            Console.WriteLine("Parametreler(1) : " + sekil.cevreHesapla());
            sekil = new dortgen(1, 2);
            Console.WriteLine("Parametreler(1,2) : " + sekil.cevreHesapla());
            sekil = new dortgen(1, 2, 3);
            Console.WriteLine("Parametreler(1,2,3) : " + sekil.cevreHesapla());
            sekil = new dortgen(1, 2, 3, 4);
            Console.WriteLine("Parametreler(1,2,3,4) : " + sekil.cevreHesapla());

            Console.ReadKey();
        }
    }
}
