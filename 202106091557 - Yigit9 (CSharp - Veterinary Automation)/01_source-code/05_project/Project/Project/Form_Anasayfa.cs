using System;
using System.Drawing;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Anasayfa : Form
    {
        public Form_Anasayfa()
        {
            InitializeComponent();
        }
        Class_Islemler islemler = new Class_Islemler();
        private void Form_Anasayfa_Load(object sender, EventArgs e)
        {
            if (islemler.BaglantiTest())
            {
                stLb_Durum.Text = "Bağlantı Durumu : Tamam";
                stLb_Durum.ForeColor = Color.LimeGreen;
            }
            else
            {
                stLb_Durum.Text = "Bağlantı Durumu : Sorun Var";
                stLb_Durum.ForeColor = Color.PaleVioletRed;
            }

        }

        private void kontrolToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (islemler.BaglantiTest())
            {
                islemler.MesajKutu("Bağlantı Testi");
            }
            else
            {
                islemler.MesajKutu(2, "Bağlantı Testi");
            }
        }

        private void yenidenBaşlatToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Restart();
        }

        private void kapatToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }


        private void hakkındaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form form = new Form_Hakkinda();
            form.ShowDialog();
        }

        private void btnCikis_Click(object sender, EventArgs e)
        {
            new Form_Islem("kullanici").ShowDialog();
        }

        private void Form_Anasayfa_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            new Form_Islem("randevu").ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            new Form_Islem("sahip").ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            new Form_Islem("tedarikci").ShowDialog();
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            new Form_Islem("hasta").ShowDialog();
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            new Form_Islem("hesap").ShowDialog();
        }

        private void btn3_Click(object sender, EventArgs e)
        {
            new Form_Islem("ilac").ShowDialog();
        }

        private void btn4_Click(object sender, EventArgs e)
        {
            new Form_Islem("operasyon").ShowDialog();
        }

        private void btn5_Click(object sender, EventArgs e)
        {
            new Form_Islem("personel").ShowDialog();
        }

        private void ayarlarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form_VeritabaniBaglanti().ShowDialog();
        }
    }
}
