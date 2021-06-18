using System;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;


namespace furkankorkmzr
{
    public partial class Form_Products : Form
    {
        public Form_Products()
        {
            InitializeComponent();
        }
        SqlConnection baglanti = new SqlConnection("Data Source=" + Ayarlar.Default.Sunucu + ";Initial Catalog=" + Ayarlar.Default.Veritabani + ";Integrated Security=True");

        int Id = 0;
        public void Listele()
        {
            try
            {
                baglanti.Open();
                SqlCommand komut = new SqlCommand("SP_List", baglanti);
                komut.CommandType = CommandType.StoredProcedure;
                SqlDataAdapter da = new SqlDataAdapter(komut);
                DataSet ds = new DataSet();
                da.Fill(ds);
                dg_veriler.DataSource = ds.Tables[0];
                komut.Dispose();
                baglanti.Close();
            }
            catch
            {
                baglanti.Close();
            }

        }


        private void btn_Kapat_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btn_Yenile_Click(object sender, EventArgs e)
        {
            Listele();
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            Form form = new Form_Urun();
            form.ShowDialog();
        }

        private void btn_Guncelle_Click(object sender, EventArgs e)
        {
            Form form = new Form_Urun(Id);
            form.ShowDialog();
        }


        private void btn_Sil_Click(object sender, EventArgs e)
        {
            if (Id != 0)
            {
                try
                {
                    baglanti.Open();
                    SqlCommand komut = new SqlCommand("SP_Delete", baglanti);
                    komut.CommandType = CommandType.StoredProcedure;
                    komut.CommandType = CommandType.StoredProcedure;
                    komut.Parameters.AddWithValue("@Id", Id);

                    komut.ExecuteNonQuery();
                    komut.Dispose();
                    baglanti.Close();
                    MessageBox.Show("Ürün silindi", "BİLGİ", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }
                catch
                {
                    baglanti.Close();
                    MessageBox.Show("Ürün silinemedi!", "HATA", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
            }
        }

        private void Form_Load(object sender, EventArgs e)
        {
            Listele();
        }

        private void dg_veriler_CellMouseDoubleClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (Id != 0)
            {
                Form form = new Form_Urun(Id);
                form.ShowDialog();
            }
        }

        private void dg_veriler_RowEnter(object sender, DataGridViewCellEventArgs e)
        {
            Id = Convert.ToInt32(dg_veriler.Rows[e.RowIndex].Cells[0].Value);
        }
    }
}
