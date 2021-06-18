using System;
using System.Drawing;
using System.Windows.Forms;

namespace GazeteOtomasyon
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

        private void firmaİşlemleriToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_firma");
            form.ShowDialog();
        }

        private void firmaBilgileriToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form form = new Form_Firma(1);
            form.ShowDialog();
        }

        private void btn_Abone_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_"+"abone");
            form.ShowDialog();
        }

        private void btn_Personel_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "personel");
            form.ShowDialog();
        }

        private void btn_Urun_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "urun");
            form.ShowDialog();
        }

        private void btn_Stok_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "stok");
            form.ShowDialog();
        }

        private void btn_AboneUrun_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "aboneUrun");
            form.ShowDialog();
        }

        private void btn_Teslimat_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("tbl_" + "teslimat");
            form.ShowDialog();
        }

        private void hakkındaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form form = new Form_Hakkinda();
            form.ShowDialog();
        }
    }
}
