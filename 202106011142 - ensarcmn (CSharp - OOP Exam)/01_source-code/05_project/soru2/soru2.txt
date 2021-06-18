using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace soru2
{
    class Program
    {
        /*
        Aşağıda eksik tanımı verilen kesir sınıfı için ikili (binary) + işlecinin üstüne
        yüklemek (operator overloading) istiyoruz.
        Sınıf tanımındaki pay üye değişkeni kesirin payını,
        payda üye değişkeni de paydasını göstermektedir.
        + işlecini  kullanarak iki kesir nesnesini toplamanın (k1 + k2) başka bir kesir nesnesi
        (k3) üretmesini sağlayacağız.
        Bu durumda kesirlerin paydasını eşitlemek ve doğru
        işlemleri yapmak gerekiyor. + işlecinin üstüne yükleme işini başaran fonksiyonun
        kodunu kutuya yazın.


        Örnek: 
        k1 kesirinin pay değeri 3, payda değeri 5;
        k2 kesirinin pay değeri 4, payda değeri 14 
        olduğunda
        k3 (k1 + k2) kesirinin pay değeri 62,
        payda değeri 70 olur. Üstüne yüklenen 
        + işleci yapılabilecek sadeleştirmeleri dikkate almayacaktır.

        class kesir {
        int pay, payda;
            public kesir() {pay = payda = 1;}
            public kesir (int py, int pyd)
            {
                 pay = py;
            payda = (pyd == 0) ? 1 : pyd;
        }
*/

  
        static void Main(string[] args)
        {
            kesir k1 = new kesir(3,5);
            kesir k2 = new kesir(4, 14);

            kesir k3 = k1 + k2;

            k3.yazdir();

            Console.ReadKey();
            
        }
    }
    class kesir
    {
        int pay, payda;
        public kesir() { pay = payda = 1; }
        public kesir(int py, int pyd)
        {
            pay = py;
            payda = (pyd == 0) ? 1 : pyd;
        }

        public void yazdir()
        {
            Console.WriteLine("Pay = "+pay+" Payda = "+payda);
        }
        public static kesir operator +(kesir a, kesir b)
        {
            int apay = a.pay, apayda = a.payda;
            int bpay = b.pay, bpayda = b.payda;

            apay = a.pay * b.payda;
            bpay = b.pay * a.payda;

            bpayda *= apayda;

            int pay = apay + bpay;

            kesir sonuc = new kesir(pay,bpayda);
            return sonuc ;
        }
    }
}
