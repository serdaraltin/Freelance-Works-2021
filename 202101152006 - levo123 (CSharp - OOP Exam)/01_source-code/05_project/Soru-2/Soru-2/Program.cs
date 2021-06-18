using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Soru_2
{
    interface ITest<T>
    {
         void Ekle(T deger);
    }
    class Test<T>: ITest<T>
    {
        T[] degerler = new T[5];
        int count = 0;

        public void Ekle(T deger)
        {
            if(count +1 < 6)
            {
                degerler[count] = deger;
            }
            count++;
        }

        public T this[int index]
        {
            get { return degerler[index]; }
            set { degerler[index] = value; }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {  
            Test<string> test = new Test<string>();

            test.Ekle("Ahmet");
            test.Ekle("Bahar");
            test.Ekle("Leyla");    
            test.Ekle("Bekir");
            test.Ekle("Sude");

          
            for (int i = 0; i < 5; i++)
            {
                Console.WriteLine(test[i]);  
            }
            Console.ReadKey();
        }
    }
}
