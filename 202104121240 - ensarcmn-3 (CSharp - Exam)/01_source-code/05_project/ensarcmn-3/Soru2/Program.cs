using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Soru2
{
    class dortgen
    {
        private int kenar1, kenar2, kenar3, kenar4;

        public dortgen()
        {
            kenar1 = kenar2 = kenar3 = kenar4 = 0;
        }

        public dortgen(int _kenar)
        {
            kenar1 = kenar2 = kenar3 = kenar4 = _kenar;
        }

        public dortgen(int _kenar1, int _kenar2)
        {
            kenar1 = kenar3 = _kenar1;
            kenar2 = kenar4 = _kenar2;
        }

        public dortgen(int _kenar1, int _kenar2, int _kenar3)
        {
            kenar1 = kenar3 = _kenar1;
            kenar2 = kenar4 = _kenar2;
        }

        public dortgen(int _kenar1, int _kenar2, int _kenar3, int _kenar4)
        {
            kenar1 = _kenar1;
            kenar2 = _kenar2;
            kenar3 = _kenar3;
            kenar4 = _kenar4;
        }

        public int cevreHesapla()
        {
            return kenar1 + kenar2 + kenar3 + kenar4;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            dortgen sifir = new dortgen();
            dortgen bir = new dortgen(3);
            dortgen iki = new dortgen(3, 4);
            dortgen uc = new dortgen(3, 4, 5);
            dortgen dort = new dortgen(3, 4, 5, 6);

            Console.WriteLine("Sifir parametreli -> cevreHesapla : "+sifir.cevreHesapla());
            Console.WriteLine("Bir parametreli(3) -> cevreHesapla : " + bir.cevreHesapla());
            Console.WriteLine("Iki parametreli(3,4) -> cevreHesapla : " + iki.cevreHesapla());
            Console.WriteLine("Uc parametreli(3,4,5) -> cevreHesapla : " + uc.cevreHesapla());
            Console.WriteLine("Dort parametreli(3,4,5,6) -> cevreHesapla : " + dort.cevreHesapla());

            Console.ReadKey();
        }
    }
}
