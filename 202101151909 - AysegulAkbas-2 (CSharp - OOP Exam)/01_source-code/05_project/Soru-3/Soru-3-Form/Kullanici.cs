using System;
using System.Windows.Forms;

namespace Soru_3_Form
{
    class Kullanici : IKullanici
    {
        public string ad;
        public string sehir;
        public void BilgileriYazdir(RichTextBox ric)
        {
            ric.Text += "Ad : " + ad+"\n";
            ric.Text += "Sehir : " + sehir + "\n";
        }
    }
}
