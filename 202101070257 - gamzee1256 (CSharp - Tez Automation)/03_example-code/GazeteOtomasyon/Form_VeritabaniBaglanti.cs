using System;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace GazeteOtomasyon
{
    public partial class Form_VeritabaniBaglanti : Form
    {
        public Form_VeritabaniBaglanti()
        {
            InitializeComponent();
        }

        //Veritabanı bağlantı testi için fonksiyon
        public bool Baglanti_Test(string Sunucu,string Veritabani,string Kullanici,string Parola)
        {
            SqlConnection baglanti = new SqlConnection("Data Source = "+Sunucu+", 1433; Network Library = DBMSSOCN; Initial Catalog = "+Veritabani+"; User ID = "+Kullanici+"; Password = "+Parola+";");

            try
            {
                baglanti.Open();
             
                return true;
            }
            catch{
                baglanti.Close();
                return false;
            }
        }

        //Formun load olayı
        private void Form_VeritabaniBaglanti_Load(object sender, EventArgs e)
        {
            txt_Sunucu.Text = Ayarlar.Default.Sunucu;
            txt_Veritabani.Text = Ayarlar.Default.Veritabani;
            txtParola.Text = Ayarlar.Default.Parola;
            txtKullanici.Text = Ayarlar.Default.Kullanici;
        }
        //Test butonunun tıklanma olayı
        private void btn_Test_Click(object sender, EventArgs e)
        {
            if (Baglanti_Test(txt_Sunucu.Text, txt_Veritabani.Text,txtKullanici.Text,txtParola.Text))
                MessageBox.Show("Bağlantı Testi başarılı", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
            else
                MessageBox.Show("Bağlantı Testi başarısız", "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
        //Kayıt butonunun tıklanma olayı
        private void btn_Kayit_Click(object sender, EventArgs e)
        {
            if (!Baglanti_Test(txt_Sunucu.Text, txt_Veritabani.Text, txtKullanici.Text, txtParola.Text))
            {
                MessageBox.Show("Geçerli bir bağlantı giriniz !!!", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            Ayarlar.Default.Sunucu = txt_Sunucu.Text;
            Ayarlar.Default.Veritabani = txt_Veritabani.Text;
            Ayarlar.Default.Kullanici = txtKullanici.Text;
            Ayarlar.Default.Parola = txtParola.Text;
            Ayarlar.Default.Save();
            MessageBox.Show("Ayarlar kaydedildi program yeniden başlatılacak.", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
            Application.Restart();
        }
    }
}
