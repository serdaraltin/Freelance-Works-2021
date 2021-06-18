using System;
using System.Drawing;
using System.Windows.Forms;

namespace AracKiralamaOtomasyon
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

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnKullanici_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("kullanici");
            form.ShowDialog();
        }

        private void btnArac_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("arac");
            form.ShowDialog();
        }

        private void btnMusteri_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("musteri");
            form.ShowDialog();
        }

        private void btnKiralama_Click(object sender, EventArgs e)
        {
            Form form = new Form_Islem("kiralama");
            form.ShowDialog();
        }

        private void veritabanıToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void programToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void Form_Anasayfa_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
    }
}
