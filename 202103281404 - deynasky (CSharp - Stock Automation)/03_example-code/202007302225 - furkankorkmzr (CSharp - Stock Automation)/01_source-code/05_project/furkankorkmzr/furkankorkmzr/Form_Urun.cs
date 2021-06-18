using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Data;
using System.Windows.Forms;

namespace furkankorkmzr
{
    public partial class Form_Urun : Form
    {
        int UrunId = 0;
        public Form_Urun()
        {
            InitializeComponent();
        }
        public Form_Urun(int Id)
        {
            InitializeComponent();
            UrunId = Id;
        }

        SqlConnection baglanti = new SqlConnection("Data Source=" + Ayarlar.Default.Sunucu + ";Initial Catalog=" + Ayarlar.Default.Veritabani + ";Integrated Security=True");

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            if (UrunId == 0)
            {
                try
                {
                    baglanti.Open();
                    SqlCommand komut = new SqlCommand("SP_Insert", baglanti);
                    komut.CommandType = CommandType.StoredProcedure;

                    komut.Parameters.AddWithValue("@Name", txt_UrunAd.Text);
                    komut.Parameters.AddWithValue("@Price", Convert.ToInt32(txt_Fiyat.Text));
                    komut.Parameters.AddWithValue("@Stock", Convert.ToInt32(txt_Stok.Text));
                    komut.ExecuteNonQuery();
                    komut.Dispose();
                    baglanti.Close();
                    MessageBox.Show("Ürün eklendi", "BİLGİ", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    this.Close();
                }
                catch
                {
                    baglanti.Close();
                    MessageBox.Show("Ürün eklenemedi!", "HATA", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
            }
            else
            {
                try
                {
                    baglanti.Open();
                    SqlCommand komut = new SqlCommand("SP_Update", baglanti);
                    komut.CommandType = CommandType.StoredProcedure;
                    komut.Parameters.AddWithValue("@Id", UrunId);
                    komut.Parameters.AddWithValue("@Name", txt_UrunAd.Text);
                    komut.Parameters.AddWithValue("@Price", Convert.ToInt32(txt_Fiyat.Text));
                    komut.Parameters.AddWithValue("@Stock", Convert.ToInt32(txt_Stok.Text));
                    komut.ExecuteNonQuery();
                    komut.Dispose();
                    baglanti.Close();
                    MessageBox.Show("Ürün güncellendi", "BİLGİ", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    this.Close();
                }
                catch
                {
                    baglanti.Close();
                    MessageBox.Show("Ürün güncellenemedi!", "HATA", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
            }
        }

        private void btn_Sil_Click(object sender, EventArgs e)
        {
            try
            {
                baglanti.Open();
                SqlCommand komut = new SqlCommand("SP_Delete", baglanti);
                komut.CommandType = CommandType.StoredProcedure;
                komut.CommandType = CommandType.StoredProcedure;
                komut.Parameters.AddWithValue("@Id", UrunId);

                komut.ExecuteNonQuery();
                komut.Dispose();
                baglanti.Close();
                MessageBox.Show("Ürün silindi", "BİLGİ", MessageBoxButtons.OK, MessageBoxIcon.Information);
                this.Close();
            }
            catch
            {
                baglanti.Close();
                MessageBox.Show("Ürün silinemedi!", "HATA", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
        }

        private void Form_Load(object sender, EventArgs e)
        {

            if (UrunId != 0)
            {
                this.Text += " Güncelle";
                btn_Ekle.Text = "Güncelle";
                btn_Sil.Visible = true;


                baglanti.Open();
                SqlCommand komut = new SqlCommand("SP_Select", baglanti);
                komut.CommandType = CommandType.StoredProcedure;
                komut.Parameters.AddWithValue("@Id", UrunId);
                SqlDataReader oku = komut.ExecuteReader();
                ArrayList veriler = new ArrayList();
                if (oku.Read())
                {
                    for (int i = 0; true; i++)
                    {
                        try { veriler.Add(oku[i]); }
                        catch { break; }
                    }
                }

                komut.Dispose();
                baglanti.Close();


                txt_UrunAd.Text = veriler[1].ToString();
                txt_Fiyat.Text = veriler[2].ToString();
                txt_Stok.Text = veriler[3].ToString();

            }
        }
    }
}
