using System;

namespace _05_project
{
    class Program
    {
        static bool WordControl(string word, string file)
        {
            string[] fileText = System.IO.File.ReadAllLines(file);
            foreach (string line in fileText)
            {
                if (line.Contains(word))
                    return true;
            }

            return false;
        }
        static void Main(string[] args)
        {
            string word = args[0];

            for (int i = 1; i < args.Length; i++)
            {
                if (WordControl(word, args[i]))
                {
                    Console.WriteLine("'" + word + "' metni '" + args[i] + "' dosyasında var.");
                }
            }
        }
    }
}
