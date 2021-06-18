using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BKTEI
{
    class Program
    {
        static bool WordControl(string word, string file)
        {
            string[] fileText = System.IO.File.ReadAllLines(file);
            foreach (string line in fileText)
            {
                if (line.ToLower().Contains(word.ToLower()))
                    return true;
            }

            return false;
        }
        static void Main(string[] args)
        {
            if(args.Length == 0)
            {
                Console.WriteLine("Gerekli parametreler eksik.\n[aranacakkelime] [dosya1] [dosya2] ...");
                Console.ReadKey();
                return;
            }
            string word = args[0];

            for (int i = 1; i < args.Length; i++)
            {
                if (WordControl(word, args[i]))
                {
                    Console.WriteLine("'" + word + "' metni '" + args[i] + "' dosyasında var.");
                }
            }
            Console.ReadKey();
        }
    }
}
