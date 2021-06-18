using System;
using System.Windows.Forms;

namespace Soru_3_Form
{
    class Detay : Isyeri, IDetay
    {
        public int yas;
        public void YasYazdir(RichTextBox ric)
        {
            ric.Text += "Yaş : " + yas + "\n";
            Console.WriteLine("Yaş : " + yas);
        }
    }
}
