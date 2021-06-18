using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace soru2
{
    class kesir
    {
        int pay, payda;
        public int Pay
        {
            get { return pay; }
            set { pay = value; }
        }
        public int Payda
        {
            get { return payda; }
            set { payda = value; }
        }
        public kesir() { pay = payda = 1; }
        public kesir(int py, int pyd)
        {
            pay = py;
            payda = (pyd == 0) ? 1 : pyd;
        }
        public static kesir operator +(kesir sol, kesir sag)
        {
            return new kesir(sol.pay * sag.payda + sag.pay * sol.payda, sag.payda * sol.payda);
        }
    }
    class Program
    {

        static void Main(string[] args)
        {
            kesir k1 = new kesir(), k2 = new kesir(), k3;

            Console.Write("Kesir 1 Pay : ");
            k1.Pay = Convert.ToInt32(Console.ReadLine());
            Console.Write("Kesir 1 Payda : ");
            k1.Payda = Convert.ToInt32(Console.ReadLine());

            Console.Write("Kesir 2 Pay : ");
            k2.Pay = Convert.ToInt32(Console.ReadLine());
            Console.Write("Kesir 2 Payda : ");
            k2.Payda = Convert.ToInt32(Console.ReadLine());

            k3 = k1 + k2;

            Console.WriteLine("Sonuc = " + k3.Pay + "/" + k3.Payda);

            Console.ReadKey();

        }
    }

}
