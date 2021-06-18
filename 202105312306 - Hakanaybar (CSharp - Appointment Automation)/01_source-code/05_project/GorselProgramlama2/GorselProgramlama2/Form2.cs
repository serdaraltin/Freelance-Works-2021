using System;
using System.Collections;
using System.Data;
using System.Data.OleDb;
using System.Windows.Forms;

namespace GorselProgramlama2
{
    public partial class Form2 : Form
    {
        int hasta_id;
        int randevu_id;
        public Form2(int hasta_id)
        {
            this.hasta_id = hasta_id;
            InitializeComponent();

        }
        OleDbConnection baglanti = new OleDbConnection(@"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=hasta_bilgisi.mdb;");

        ArrayList ilaclar = new ArrayList();
        private void dateTimePicker1_ValueChanged(object sender, EventArgs e)
        {
            txtTarih.Text = dtTarih.Value.ToShortDateString();
        }

        private void btnCikis_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void txtTarih_TextChanged(object sender, EventArgs e)
        {
            try
            {
                dtTarih.Text = txtTarih.Text;
            }
            catch { }
        }
        public void RandevuListele()
        {
            baglanti.Open();
            string sorgu =
            @"SELECT
            tbl_Randevu.randevu_id as [Hasta No], tbl_Hasta.isim as [Hasta İsim&Soyisim], tbl_Randevu.randevu_tarihi as [Randevu Tarihi], tbl_Randevu.teşhis as [Teşhis], tbl_Randevu.tedavi as [Tedavi], tbl_İlaç.ilaç_adı as [Verilen İlaç]
            FROM
            tbl_İlaç INNER JOIN(tbl_Hasta INNER JOIN tbl_Randevu
            ON
            tbl_Hasta.hasta_id = tbl_Randevu.randevu_hasta_id)
            ON
            tbl_İlaç.ilaç_id = tbl_Randevu.verilen_ilaç_id
            WHERE tbl_Randevu.randevu_hasta_id = " + hasta_id.ToString();
            OleDbCommand komut = new OleDbCommand(sorgu, baglanti);
            OleDbDataAdapter da = new OleDbDataAdapter(komut);
            DataSet ds = new DataSet();
            da.Fill(ds);
            dtVeriler.DataSource = ds.Tables[0];
            baglanti.Close();
        }
        public void IlacListele()
        {
            cbIlac.Items.Clear();
            ilaclar.Clear();
            baglanti.Open();
            string sorgu = "Select * From tbl_İlaç";
            OleDbCommand komut = new OleDbCommand(sorgu, baglanti);
            OleDbDataReader reader = komut.ExecuteReader();
            while (reader.Read())
            {
                ilaclar.Add(reader["ilaç_id"].ToString());
                cbIlac.Items.Add(reader["ilaç_adı"].ToString());
            }
            baglanti.Close();
            cbIlac.SelectedIndex = 0;
        }
        private void Form2_Load(object sender, EventArgs e)
        {
            txtTarih.Text = dtTarih.Value.ToShortDateString();


            baglanti.Open();
            OleDbCommand komut = new OleDbCommand("Select * From tbl_Hasta Where hasta_id=" + hasta_id, baglanti);
            OleDbDataReader reader = komut.ExecuteReader();
            if (reader.Read())
            {
                txtIsimSoyisim.Text = reader["isim"].ToString();

            }
            baglanti.Close();

            RandevuListele();
            IlacListele();
        }
        public bool Kontrol()
        {
            foreach (Control item in groupBox1.Controls)
            {
                if (item is TextBox)
                    if (((TextBox)item).Text == "")
                        return false;
                if (item is ComboBox)
                    if (((ComboBox)item).Text == "")
                        return false;
            }
            return true;
        }
        private void btnEkle_Click(object sender, EventArgs e)
        {
            if (!Kontrol())
            {
                MessageBox.Show("Gerekli alanları doldurunuz !!", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            try
            {
                baglanti.Open();
                OleDbCommand komut = new OleDbCommand("Insert Into tbl_Randevu (randevu_hasta_id,teşhis,tedavi,randevu_tarihi,verilen_ilaç_id)" +
                    "values(@randevu_hasta_id,@teşhis,@tedavi,@randevu_tarihi,@verilen_ilaç_id)", baglanti);
                komut.Parameters.AddWithValue("@randevu_hasta_id", hasta_id);
                komut.Parameters.AddWithValue("@teşhis", txtTeshis.Text);
                komut.Parameters.AddWithValue("@tedavi", txtTedavi.Text);
                komut.Parameters.AddWithValue("@randevu_tarihi", txtTarih.Text);
                komut.Parameters.AddWithValue("@verilen_ilaç_id", ilaclar[cbIlac.SelectedIndex]);

                komut.ExecuteNonQuery();
                baglanti.Close();
                MessageBox.Show("Kayıt eklendi", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
                RandevuListele();
                btnYeni.PerformClick();
            }
            catch (Exception hata)
            {
                MessageBox.Show(hata.Message.ToString(), "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            RandevuListele();

        }

        private void btnYeni_Click(object sender, EventArgs e)
        {

            foreach (Control item in groupBox1.Controls)
            {
                if (item is TextBox)
                    ((TextBox)item).Clear();
                if (item is ComboBox)
                    ((ComboBox)item).SelectedIndex = 0;
            }
        }

        public void SecIlac(int ilacId)
        {
            int i;
            for (i = 0; i < ilaclar.Count; i++)
            {
                if (ilacId == Convert.ToInt32(ilaclar[i]))
                    break;
            }
            cbIlac.SelectedIndex = i;
        }
        public void Getir(int id)
        {
            try
            {
                baglanti.Open();
                OleDbCommand komut = new OleDbCommand("Select * From tbl_Randevu Where randevu_id=" + id, baglanti);
                OleDbDataReader reader = komut.ExecuteReader();
                if (reader.Read())
                {
                    txtTarih.Text = reader["randevu_tarihi"].ToString();
                    txtTeshis.Text = reader["teşhis"].ToString();
                    txtTedavi.Text = reader["tedavi"].ToString();
                    SecIlac(Convert.ToInt32(reader["verilen_ilaç_id"].ToString()));
                }
                baglanti.Close();
                
            }
            catch (Exception hata)
            {

            }
        }
        private void btnDegistir_Click(object sender, EventArgs e)
        {

            if (!Kontrol())
            {
                MessageBox.Show("Gerekli alanları doldurunuz !!", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            try
            {
                baglanti.Open();
                OleDbCommand komut = new OleDbCommand("Update tbl_Randevu set" +
                    "teşhis=@teşhis,tedavi=@tedavi,randevu_tarihi=@randevu_tarihi,verilen_ilaç_id=@verilen_ilaç_id" +
                    " Where randevu_id=" + randevu_id, baglanti);

                komut.Parameters.AddWithValue("@teşhis", txtTeshis.Text);
                komut.Parameters.AddWithValue("@tedavi", txtTedavi.Text);
                komut.Parameters.AddWithValue("@randevu_tarihi", txtTarih.Text);
                komut.Parameters.AddWithValue("@verilen_ilaç_id", ilaclar[cbIlac.SelectedIndex]);

                komut.ExecuteNonQuery();
                baglanti.Close();
                MessageBox.Show("Kayıt güncellendi", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
                RandevuListele();
                btnYeni.PerformClick();
            }
            catch (Exception hata)
            {
                MessageBox.Show(hata.Message.ToString(), "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            RandevuListele();
        }

        private void dtVeriler_RowEnter(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                randevu_id = Convert.ToInt32(dtVeriler.Rows[e.RowIndex].Cells[0].Value);
                Getir(randevu_id);
            }
            catch { }
        }

        private void btnSil_Click(object sender, EventArgs e)
        {
            if (hasta_id == 0)
            {
                MessageBox.Show("Herhangi bir kayıt seçilmedi !!", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            try
            {
                baglanti.Open();
                OleDbCommand komut = new OleDbCommand("Delete From tbl_Randevu" +
                    " Where randevu_id=" + randevu_id, baglanti);
                komut.ExecuteNonQuery();
                baglanti.Close();
                MessageBox.Show("Kayıt silindi", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
                RandevuListele();
                btnYeni.PerformClick();
            }
            catch (Exception hata)
            {
                MessageBox.Show(hata.Message.ToString(), "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
        }

        private void btnRandevu_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
