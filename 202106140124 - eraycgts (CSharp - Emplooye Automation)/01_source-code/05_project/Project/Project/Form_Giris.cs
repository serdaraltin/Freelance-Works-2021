using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Giris : Form
    {
        public Form_Giris()
        {
            InitializeComponent();
        }

        Class_Islemler islemler = new Class_Islemler();
        private void Form_Giris_Load(object sender, EventArgs e)
        {

            if (!islemler.BaglantiTest() || Ayarlar.Default.Sunucu == "" || Ayarlar.Default.Veritabani == "") 
            {
                MessageBox.Show("Veritabanı bağlantısı için bilgileri giriniz!", "UYARI", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                Form veritabani = new Form_VeritabaniBaglanti();
                veritabani.ShowDialog();
            }
        }

        private void btnGiris_Click(object sender, EventArgs e)
        {
            if (!islemler.Kullanici_Kontrol(txtKullaniciAd.Text, txtParola.Text))
            {
                MessageBox.Show("Kullanıcı adına ait şifre doğrulanamadı!", "UYARI", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

          //  MessageBox.Show("Giriş Başarılı", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
            Form anasayfa = new Form_Anasayfa();
            anasayfa.Show();
            this.Hide();
        }

        private void txtParola_KeyDown(object sender, KeyEventArgs e)
        {
            
        }

        private void txtParola_KeyPress(object sender, KeyPressEventArgs e)
        {
            if((int)e.KeyChar == 13)
            {
                btnGiris.PerformClick();
            }
        }
    }
}
