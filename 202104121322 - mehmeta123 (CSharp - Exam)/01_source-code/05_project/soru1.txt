using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("dizgi1 :");
            string str1 = Console.ReadLine();

            Console.WriteLine("dizgi2 :");
            string str2 = Console.ReadLine();

            string yeniDizgi = "";

            int son = 0;
            if (str1.Length % 2 == 0)
            {
                son = str1.Length / 2;
            }
            else
            {
                son = str1.Length / 2+1 ;
            }
            for (int i = 0; i <son; i++)
            {    
                yeniDizgi += str1[i];
            }

 
            for (int i = str2.Length/2; i < str2.Length; i++)
            {
                yeniDizgi += str2[i];
            }
            Console.WriteLine(yeniDizgi);

            Console.ReadKey();
        }
    }
}
