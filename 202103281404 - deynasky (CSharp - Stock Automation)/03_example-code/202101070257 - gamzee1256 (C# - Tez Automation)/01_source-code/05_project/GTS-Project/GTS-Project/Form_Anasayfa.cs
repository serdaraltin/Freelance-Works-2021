using System;
using System.Drawing;
using System.Windows.Forms;

namespace GTS_Project
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
            Form_VeritabaniBaglanti veritabani = new Form_VeritabaniBaglanti();
            veritabani.ShowDialog();
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

        private void btn_Tez_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "tez");
            form.ShowDialog();
        }

        private void btn_Yazar_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "yazar");
            form.ShowDialog();
        }

        private void btn_Danisman_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "danisman");
            form.ShowDialog();
        }

        private void btn_Universite_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "universite");
            form.ShowDialog();
        }

        private void btn_Enstitu_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "enstitu");
            form.ShowDialog();
        }

        private void btn_Baslik_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "baslik");
            form.ShowDialog();
        }
    }
}
