using System;
using System.Collections.Generic;
using System.Text;

namespace Soru4
{
    class Program
    {
        static void Main(string[] args)
        {
            for (int a = 5; a >0; a--)
            {
                for (int i = 0; i <= a; i++)
                {
                    for (int j = 0; j < i; j++)
                    {
                        Console.Write(i);
                    }
                }
                Console.WriteLine();
            }
            
            Console.ReadKey();
        }
    }
}
