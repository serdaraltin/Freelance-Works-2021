﻿using System;

namespace Soru2
{
    class Program
    {
        static float Hesapla(float vize,float final)
        {

            return ((vize / 100) * 40) + ((final / 100) * 60);
        }
        static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("Vize ve final puanlarınızı giriniz :");
                float vize = float.Parse(Console.ReadLine());
                if (vize < 0)
                {
                    Console.WriteLine("Program sonlandı.");
                    break;
                }
                float final = float.Parse(Console.ReadLine());
                if(final < 0)
                {
                    Console.WriteLine("Program sonlandı.");
                    break;
                }
                float not = Hesapla(vize, final);
                if (not >= 90 && not <= 100)
                {
                    Console.WriteLine("Notunuz : A");
                }
                else if (not >= 75 && not <= 89)
                {
                    Console.WriteLine("Notunuz : B");
                }
                else if (not >= 60 && not <= 74)
                {
                    Console.WriteLine("Notunuz : C");
                }
                else if (not >= 45 && not <= 59)
                {
                    Console.WriteLine("Notunuz : D");
                }
                else if (not >= 0 && not <= 44)
                {
                    Console.WriteLine("Notunuz : KALDI");
                }
            }
            Console.ReadKey();
           

        }
    }
}
