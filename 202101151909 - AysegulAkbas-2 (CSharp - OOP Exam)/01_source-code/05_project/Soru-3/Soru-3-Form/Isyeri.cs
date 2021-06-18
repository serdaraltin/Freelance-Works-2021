using System;
using System.Windows.Forms;

namespace Soru_3_Form
{
    class Isyeri : Kullanici, Iİsyeri
    {
        public string isyeri;
        public void IsyeriYazdir(RichTextBox ric)
        {
            ric.Text += "İşyeri : " + isyeri+ "\n";
        }
    }
}
