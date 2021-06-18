using System;
using System.Collections.Generic;
using System.Text;

namespace Soru1
{
    class Program
    {
        static string[] derslerim = new string[]
        {
           "Pazartesi,8:00,10:00" ,
           "Salı    ,9:00,10:00,15:00" ,
           "Çarşamba,10:00,11:00,15:00,17:00",
           "Perşembe,13:00" 
        };
        static void Main(string[] args)
        {
            foreach (string gun in derslerim){
                foreach(string parca in gun.Split(','))
                {
                    Console.Write(parca + "\t");
              
                }
                Console.WriteLine();
            }
            Console.ReadKey();
        }
    }
}
