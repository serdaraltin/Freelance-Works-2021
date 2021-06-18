using System;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_VeritabaniBaglanti : Form
    {
        public Form_VeritabaniBaglanti()
        {
            InitializeComponent();
        }

        //Veritabanı bağlantı testi için fonksiyon
        public bool Baglanti_Test(string Sunucu,string Veritabani)
        {
            SqlConnection baglanti = new SqlConnection("Data Source="+ Sunucu+";Initial Catalog="+ Veritabani+"; Integrated Security=True");

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
          
        }
        //Test butonunun tıklanma olayı
        private void btn_Test_Click(object sender, EventArgs e)
        {
            if (Baglanti_Test(txt_Sunucu.Text, txt_Veritabani.Text))
                MessageBox.Show("Bağlantı Testi başarılı", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
            else
                MessageBox.Show("Bağlantı Testi başarısız", "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
        //Kayıt butonunun tıklanma olayı
        private void btn_Kayit_Click(object sender, EventArgs e)
        {
            if (!Baglanti_Test(txt_Sunucu.Text, txt_Veritabani.Text))
            {
                MessageBox.Show("Geçerli bir bağlantı giriniz !!!", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            Ayarlar.Default.Sunucu = txt_Sunucu.Text;
            Ayarlar.Default.Veritabani = txt_Veritabani.Text;
            
            Ayarlar.Default.Save();
            MessageBox.Show("Ayarlar kaydedildi program yeniden başlatılacak.", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
            Application.Restart();
        }
    }
}
