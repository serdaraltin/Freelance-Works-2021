using System;

namespace Zinckernagel10
{
    class Program
    {
        static string kodUret(int codeLength)
        {
            System.Text.StringBuilder sb = new System.Text.StringBuilder();

            System.Random objRandom = new System.Random();

            string[] strChars = { "A","B","C","D","E","F","G","H","I",

                            "J","K","L","M","N","O","P","Q","R",

                            "S","T","U","V","W","X","Y","Z",

                            "1","2","3","4","5","6","7","8","9","0"};

            int maxRand = strChars.GetUpperBound(0);

            for (int i = 0; i<codeLength; i++)
            {
                int rndNumber = objRandom.Next(maxRand);

                sb.Append(strChars[rndNumber]);
            }

            return sb.ToString();
        }
        static void Main(string[] args)
        {
            while (true)
            {
                string dogrulamaKod = kodUret(8);
                Console.WriteLine(dogrulamaKod + "\nEkranda gördüğünüz doğrulama kodunu giriniz");
                string cevap = Console.ReadLine();
                if (dogrulamaKod == cevap)
                {
                    Console.WriteLine("İşlem başarılı");
                }
                else
                {
                    Console.WriteLine("Yanlış giriş yaptınız");
                }

                Console.Write("Yeni bir doğrulama kodu üretilsin mi : ");
                string yeniCevap = Console.ReadLine();
                if(!(yeniCevap == "E" || yeniCevap == "e"))
                {
                    break;
                }
            }
    
        }
    }
}
