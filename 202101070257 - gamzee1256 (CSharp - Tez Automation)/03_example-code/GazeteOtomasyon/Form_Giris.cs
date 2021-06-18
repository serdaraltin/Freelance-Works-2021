using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace GazeteOtomasyon
{
    public partial class Form_Giris : Form
    {
        public Form_Giris()
        {
            InitializeComponent();
        }
        Class_Islemler islemler = new Class_Islemler();
        private void btn_Giris_Click(object sender, EventArgs e)
        {
            if (txt_KullaniciAd.Text != "" && txt_Parola.Text != "")
            {
                if (islemler.Yonetici_Kontrol(txt_KullaniciAd.Text, txt_Parola.Text))
                {
                    MessageBox.Show("Hoşgeldiniz", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    Form form = new Form_Anasayfa();
                    form.Show();
                    this.Hide();
                }
                else
                    MessageBox.Show("Hatalı Kullanıcı Adı veya Parola", "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
                MessageBox.Show("Gerekli alanladı doldurunuz !!!", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            
        }

        private void Form_Giris_Load(object sender, EventArgs e)
        {
            if (!islemler.BaglantiTest())
            {
                MessageBox.Show("Veritabanı bağlantı yapılandırması gerekli !!!", "Dikkat", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                Form form = new Form_VeritabaniBaglanti();
                form.ShowDialog();
                Application.Restart();
            }
        }
    }
}
