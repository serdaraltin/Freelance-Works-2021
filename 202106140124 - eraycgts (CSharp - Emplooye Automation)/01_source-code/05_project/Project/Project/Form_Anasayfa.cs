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
            if(islemler.BaglantiTest())
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

        private void btnMasa_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("izin");
            form.ShowDialog();
        }

        private void btnPersonel_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("personel");
            form.ShowDialog();
        }

        private void btnKullanici_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("kullanici");
            form.ShowDialog();
        }

        private void btnSiparis_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("mesai");
            form.ShowDialog();
        }

        private void btnVeritabnai_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("departman");
            form.ShowDialog();
        }

        private void btnCikis_Click(object sender, EventArgs e)
        {
            new Form_VeritabaniBaglanti().ShowDialog();
        }

        private void Form_Anasayfa_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
    }
}
