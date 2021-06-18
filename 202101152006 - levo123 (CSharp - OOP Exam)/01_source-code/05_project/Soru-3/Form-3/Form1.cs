using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Form_3
{
    
    public partial class Form1 : Form
    {
        Hesaplama hesaplama = new Hesaplama();
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int a = Convert.ToInt32(ndA.Value);
            int b = Convert.ToInt32(ndB.Value);
            MessageBox.Show(hesaplama.topla(a, b).ToString());
        }

        private void button4_Click(object sender, EventArgs e)
        {
            int a = Convert.ToInt32(ndA.Value);
            int b = Convert.ToInt32(ndB.Value);
            MessageBox.Show(hesaplama.cikar(a, b).ToString());
        }

        private void button2_Click(object sender, EventArgs e)
        {
            int a = Convert.ToInt32(ndA.Value);
            int b = Convert.ToInt32(ndB.Value);
            MessageBox.Show(hesaplama.carp(a, b).ToString());
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int a = Convert.ToInt32(ndA.Value);
            int b = Convert.ToInt32(ndB.Value);
            MessageBox.Show(hesaplama.bol(a, b).ToString());
        }

        private void button5_Click(object sender, EventArgs e)
        {
            int a = Convert.ToInt32(ndA.Value);
            MessageBox.Show(hesaplama.kare(a).ToString());
        }

        private void button6_Click(object sender, EventArgs e)
        {
            int a = Convert.ToInt32(ndA.Value);
            MessageBox.Show(hesaplama.kup(a).ToString());
        }

        private void button7_Click(object sender, EventArgs e)
        {
            int a = Convert.ToInt32(ndA.Value);
            MessageBox.Show(hesaplama.fakt(a).ToString());
        }
    }
}
