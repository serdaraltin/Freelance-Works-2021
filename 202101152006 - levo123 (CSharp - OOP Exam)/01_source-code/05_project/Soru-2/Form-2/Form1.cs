using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Form_2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        Test<int> test = new Test<int>();
        private void button1_Click(object sender, EventArgs e)
        {
           
            test.Ekle(Convert.ToInt32(numericUpDown1.Value));

            richTextBox1.Text = "";
            for (int i = 0; i < 5; i++)
            {
                if (test[i] != 0)
                    richTextBox1.Text += test[i].ToString() + "\n";
            }
        }
    }
}
