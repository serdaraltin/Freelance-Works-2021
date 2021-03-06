using System;

namespace Soru1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Kaç aylık kredi kullanmak istiyorsunuz? : ");
            int ay = Convert.ToInt32(Console.ReadLine());

            string[] aylar = new string[] { "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık" };

            DateTime bugun = DateTime.Now;

            for (int i = 0; i < ay; i++)
            {
                if(bugun.Year < bugun.AddDays(30).Year)
                {
                    bugun = bugun.AddYears(1);
                }
                Console.WriteLine((i + 1) + ". ay ödemesi :" + bugun.Day + " " + aylar[bugun.Month] + " " + bugun.Year);
                bugun = bugun.AddDays(30);
            }
            Console.ReadKey();
        }
    }
}
