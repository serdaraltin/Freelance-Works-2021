using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Soru1
{
    class Program
    {
        static string ilkYari(string metin)
        {
            string ilkYari = "";

            int bitis = metin.Length / 2 + 1;
            if (metin.Length % 2 == 0)
            {
                bitis = metin.Length / 2;
            }


            for (int i = 0; i < bitis; i++)
            {
                ilkYari += metin.ToCharArray()[i];
            }

            return ilkYari;
        }

        static string ikinciYari(string metin)
        {
            string ikinciYari = "";

            int baslangic = metin.Length / 2;
            for (int i = baslangic; i < metin.Length; i++)
            {
                ikinciYari += metin.ToCharArray()[i];
            }

            return ikinciYari;
        }
        static void Main(string[] args)
        {
            
            while (true)
            {

                Console.Write("Dizgi 1 Giriniz : ");
                string dizgi1 = Console.ReadLine();

                Console.Write("Dizgi 2 Giriniz : ");
                string dizgi2 = Console.ReadLine();

		string yeni = ilkYari(dizgi1) + ikinciYari(dizgi2);
                Console.WriteLine("Sonuc : " + yeni);

                Console.Write("Devam etmek istiyor musunuz? (E/H) : ");
                char cevap = Console.ReadLine()[0];
                if (!(cevap == 'E' || cevap == 'e'))
                    break;
            }

        }
    }
}
















