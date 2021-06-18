using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace soru2
{
    class kesir
    {
        int pay, payda;
        public int getPay()
        {
            return pay;
        }

        public int getPayda()
        {
            return payda;
        }
        public kesir() { pay = payda = 1; }
        public kesir(int py, int pyd)
        {
            pay = py;
            payda = (pyd == 0) ? 1 : pyd;
        }
        public static kesir operator+ (kesir k1,kesir k2)
        {
            int py = k1.pay * k2.payda + k2.pay * k1.payda;
            int pyd = k1.payda*k2.payda;

            return new kesir(py, pyd);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            kesir k1 = new kesir(3, 5);
            kesir k2 = new kesir(4, 14);
            kesir k3 = k1 + k2;

            Console.WriteLine("Sonuc : " + k3.getPay() + "/" + k3.getPayda());

            Console.ReadKey();
        }
    }
}
