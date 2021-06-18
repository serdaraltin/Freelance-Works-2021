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

namespace furkankorkmzr
{
    public partial class Form_Giris : Form
    {
        public Form_Giris()
        {
            InitializeComponent();
        }

        SqlConnection baglanti = new SqlConnection("Data Source=" + Ayarlar.Default.Sunucu + ";Initial Catalog=" + Ayarlar.Default.Veritabani + ";Integrated Security=True");

        public bool BaglantiTest()
        {
            try
            {
                baglanti.Open();
                baglanti.Close();
                return true;
            }
            catch
            {
                baglanti.Close();
                return false;
            }
        }
        private void Form_Giris_Load(object sender, EventArgs e)
        {

            if (!BaglantiTest())
            {
                MessageBox.Show("Veritabanı bağlantısı için bilgileri giriniz!", "UYARI", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                Form veritabani = new Form_VeritabaniBaglanti();
                veritabani.ShowDialog();
            }
        }

        private void btnGiris_Click(object sender, EventArgs e)
        {

            int sonuc = 0;

            baglanti.Open();
            SqlCommand komut = new SqlCommand("SP_UserLogin", baglanti);
            komut.CommandType = CommandType.StoredProcedure;
            komut.Parameters.AddWithValue("@UserName", txtKullaniciAd.Text);
            komut.Parameters.AddWithValue("@Password", txtParola.Text);

            SqlParameter RuturnValue = new SqlParameter("@ReturnValue", SqlDbType.Int);
            RuturnValue.Direction = ParameterDirection.Output;
            komut.Parameters.Add(RuturnValue);

            komut.ExecuteNonQuery();
            sonuc = (int)komut.Parameters["@ReturnValue"].Value;

            baglanti.Close();

            if (sonuc == -1)
            {
                MessageBox.Show("Kullanıcı adına ait şifre doğrulanamadı!", "UYARI", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            else if (sonuc == 0)
            {
                MessageBox.Show("Kullanıcı adını ve şifreyi kontrol ediniz!", "UYARI", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            else if (sonuc == 1)
            {
                MessageBox.Show("Giriş Başarılı", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
                Form product = new Form_Products();
                product.Show();
                this.Hide();
            }
          
        }
    }
}
