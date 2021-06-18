using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Soru1
{
    public partial class Soru1 : Form
    {
        public Soru1()
        {
            InitializeComponent();
        }

        string ByteToBitString(byte value)
        {
            string s = "";
            for (int i = 0; i < 8; i++)
            {
                s += (value & 0x80) > 0 ? "1" : "0";
                value <<= 1;
            }
            return s;
        }

        private void txtAcikMetin_TextChanged(object sender, EventArgs e)
        {
            char[] karakterListe = txtAcikMetin.Text.ToCharArray();
            byte[] byteListe = Encoding.ASCII.GetBytes(karakterListe);


            string bitDizesi = string.Empty;

            foreach(byte byt in byteListe)
            {
                bitDizesi += ByteToBitString(byt);
            }
            txtAcikMetinBit.Text = bitDizesi;
        }

        private void btnSifrele_Click(object sender, EventArgs e)
        {
            if (txtSifreDizini.Text.Length != 8)
            {
                txtSifreDizini.Text = "";
                MessageBox.Show("Şifre Dizini değeri 8 karakterden büyük veya küçük olmamalıdır !", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            char[] karakterListe = txtAcikMetin.Text.ToCharArray();
            byte[] sifrelenecekByteListe = Encoding.ASCII.GetBytes(karakterListe);  
            char[] bitAnahtar = txtSifreDizini.Text.ToCharArray();

         
            string sifreliMetin = string.Empty;

        
            foreach(byte sifrelenecekByte in sifrelenecekByteListe)
            {
                string bitListe = ByteToBitString(sifrelenecekByte);

                for (int i = 0; i < 8; i++)
                {
                    int sifrelemeBiti = Convert.ToInt32(bitAnahtar[i]);
                    int sifrelenecekBit = Convert.ToInt32(bitListe[i]);

                    if (sifrelemeBiti == sifrelenecekBit)
                        sifreliMetin += '0';
                    else
                        sifreliMetin += '1';

                }
            }

            txtSifreliDizin.Text = sifreliMetin;
        }

        private void txtSifreDizini_TextChanged(object sender, EventArgs e)
        {

        }


        private void txtSifreDizini_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.Handled = !(char.IsDigit(e.KeyChar) && (e.KeyChar == '0' || e.KeyChar == '1')))
            {

            }
        }
    }
}
