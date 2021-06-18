using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Soru_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        TextBox dinamikTextbox = new TextBox();
        Label dinamikLabel = new Label();
        private void button1_Click(object sender, EventArgs e)
        {
            Button dinamikButon1 = new Button();
            dinamikButon1.Location = new Point(170, 87);
            dinamikButon1.Size = new Size(100, 50);
            dinamikButon1.Text = "Dinamik Buton 1";
            dinamikButon1.Click += new EventHandler(dinamikButon1_Tiklanma);
            Controls.Add(dinamikButon1);

            Button dinamikButon2 = new Button();
            dinamikButon2.Location = new Point(170, 145);
            dinamikButon2.Size = new Size(100, 50);
            dinamikButon2.Text = "Dinamik Buton 2";
            dinamikButon2.Click += new EventHandler(dinamikButon2_Tiklanma);
            Controls.Add(dinamikButon2);

           
            dinamikTextbox.Location = new Point(21, 90);
            dinamikTextbox.Size = new Size(140, 40);
            dinamikTextbox.KeyPress += new KeyPressEventHandler(dinamikTextbox_IcerikDegisme);
            Controls.Add(dinamikTextbox);

            dinamikLabel.Location = new Point(25, 130);
            dinamikLabel.Size = new Size(100, 15);
            dinamikLabel.Text = "---";
      
            Controls.Add(dinamikLabel);
        }

        private void dinamikButon1_Tiklanma(object sender, EventArgs e)
        {
            MessageBox.Show(dinamikTextbox.Text);
        }

        private void dinamikButon2_Tiklanma(object sender, EventArgs e)
        {
            int sayi = Convert.ToInt32(dinamikTextbox.Text);
            int fakt=1;
            for (int i =2; i <= sayi; i++)
            {
                fakt *= i;
            }
            dinamikLabel.Text = "Faktoriyel : " + fakt.ToString();
        }
        private void dinamikTextbox_IcerikDegisme(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) &&
               (e.KeyChar != '.'))
            {
                e.Handled = true;
            }
            
            if ((e.KeyChar == '.') && ((sender as TextBox).Text.IndexOf('.') > -1))
            {
                e.Handled = true;
            }
        }
    }
}
