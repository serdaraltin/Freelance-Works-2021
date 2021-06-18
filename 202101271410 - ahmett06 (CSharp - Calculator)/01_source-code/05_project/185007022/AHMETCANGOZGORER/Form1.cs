using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace AHMETCANGOZGORER
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.Text = "Final_185007022";
            ndAltSinir.Value = 0;
            ndUstSinir.Value = 0;
            ndArtisMiktar.Value = 0;
            txtSonuc.Text = "";
            rdFor.Checked = false;
            rdWhile.Checked = false;
            rdDoWhile.Checked = false;
        }

        private void btnHesapla_Click(object sender, EventArgs e)
        {
            int altSinir = Convert.ToInt32(ndAltSinir.Value);
            int ustSinir = Convert.ToInt32(ndUstSinir.Value);
            int artisMiktari = Convert.ToInt32(ndArtisMiktar.Value);

            if (altSinir > ustSinir || altSinir == ustSinir)
            {
                MessageBox.Show("Alt Sınır Üst Sınırdan\nBÜYÜK veya EŞİT olamaz.!!", "UYARI");
                return;
            }
            if (artisMiktari == 0)
            {
                MessageBox.Show("Artış Miktarı Sıfır olamaz.!!", "UYARI");
                return;
            }
            if (rdFor.Checked == false && rdWhile.Checked == false && rdDoWhile.Checked == false)
            {
                MessageBox.Show("Döngü tipini seçmelisiniz...", "UYARI");
                return;
            }
            if (rdFor.Checked == true)
            {
                dongu("for");
            }
            if (rdWhile.Checked == true)
            {
                dongu("while");
            }
            if (rdDoWhile.Checked == true)
            {
                dongu("dowhile");
            }
        }

        private void dongu(string islemTipi)
        {
            pgTekrarAdet.Value = 0;
            int altSinir = Convert.ToInt32(ndAltSinir.Value);
            int ustSinir = Convert.ToInt32(ndUstSinir.Value);
            int artisMiktari = Convert.ToInt32(ndArtisMiktar.Value);
            string sonucMetin = "";
            int sonucSayi = 0;
            if (islemTipi == "for")
            {
                for (int i = altSinir; i <= ustSinir; i+=artisMiktari)
                {
                    sonucMetin += i.ToString();
                    if (altSinir < ustSinir)
                    {
                        sonucMetin += "+";
                    }
                    sonucSayi += i;

                    pgTekrarAdet.Value++;
                    lbTekrarAdet.Text = "Tekrar Adedi:" + pgTekrarAdet.Value;
                }
            }
            if (islemTipi == "while")
            {
                sonucSayi = 1;
                while (altSinir <= ustSinir)
                {

                    sonucMetin += altSinir;
                    if (altSinir < ustSinir)
                    {
                        sonucMetin += "*";
                    }
                    sonucSayi *= altSinir;
                    altSinir += artisMiktari;

                    pgTekrarAdet.Value++;
                    lbTekrarAdet.Text = "Tekrar Adedi:" + pgTekrarAdet.Value;
                }
               
            }

            if (islemTipi == "dowhile")
            {
                sonucSayi = 0;
                do
                {
                    int kare = altSinir * altSinir;
                    sonucMetin += kare.ToString();
                    if (altSinir < ustSinir)
                    {
                        sonucMetin += "+";
                    }
                    sonucSayi += kare;

                    altSinir += artisMiktari;

                    pgTekrarAdet.Value++;
                    lbTekrarAdet.Text = "Tekrar Adedi:" + pgTekrarAdet.Value;
                } while (altSinir <= ustSinir);
            }

            sonucMetin += "=" + sonucSayi.ToString();
            txtSonuc.Text = sonucMetin;
        }
    }
}
