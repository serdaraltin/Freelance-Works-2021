using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Soru_2_Form
{
  
    public partial class Form1 : Form
    {
        Sinif<string> sinif = new Sinif<string>();
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            sinif.DiziyeAt(textBox1.Text);
            for (int i = 0; i < sinif.i; i++)
            {
                listBox1.Items.Add(sinif.dizi[i].ToString());
            }

        }
    }
}
