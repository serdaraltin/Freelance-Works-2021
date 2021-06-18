using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Soru_3_Form
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, System.EventArgs e)
        {
            Detay d = new Detay();
            d.ad = textBox1.Text;
            d.sehir = textBox2.Text;
            d.isyeri = textBox4.Text;
            d.yas = Convert.ToInt32(textBox3.Text);

            d.BilgileriYazdir(richTextBox1);
            d.IsyeriYazdir(richTextBox1);
            d.YasYazdir(richTextBox1);
        }
    }
}
