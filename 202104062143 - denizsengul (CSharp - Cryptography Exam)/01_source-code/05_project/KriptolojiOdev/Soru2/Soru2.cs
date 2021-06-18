using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Soru2
{
    public partial class Soru2 : Form
    {
        public Soru2()
        {
            InitializeComponent();
        }

        char[] alfabeBuyuk = { 'A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'Ğ',
            'H', 'I', 'İ', 'J', 'K', 'L', 'M', 'N', 'O', 'Ö', 'P', 'R',
            'S', 'Ş', 'T', 'U', 'Ü', 'V', 'Y', 'Z'};
        char[] alfabeKucuk = { 'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ',
            'h', 'ı', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'ö', 'p', 'r',
            's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z' };

        private void btnSifrele_Click(object sender, EventArgs e)
        {
            int anahtar = Convert.ToInt32(ndAnahtar.Value);

            char[] harfListe = txtSifrelenecekMetin.Text.ToCharArray();


            string sifreliMetin = string.Empty;
            foreach (char harf in harfListe)
            {

                char degistirilecekHarf = ' ';

                for (int i = 0; i < alfabeBuyuk.Length; i++)
                {
                    int yeniIndis = (i+anahtar) % 28;
                    if (harf == alfabeBuyuk[i])
                    {
                        degistirilecekHarf = alfabeBuyuk[yeniIndis];
                        break;
                    }
                    else if (harf == alfabeKucuk[i])
                    {
                        degistirilecekHarf = alfabeKucuk[yeniIndis];
                        break;
                    }
                }
                sifreliMetin += degistirilecekHarf;
            }
            txtSifrelenmisMetin.Text = sifreliMetin;

        }
    }
}
