using System;
using System.Windows.Forms;
using System.Data.OleDb;
using System.Data;

namespace GorselProgramlama2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        string[] harfler = { };
        int hasta_id = 0;
        OleDbConnection baglanti = new OleDbConnection(@"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=hasta_bilgisi.mdb;");
        String[] sehirler ={"Adana","Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
            "Aydın", "Balıkesir","Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
            "Çankırı", "Çorum","Denizli","Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum ", "Eskişehir",
            "Gaziantep", "Giresun","Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
            "Kars", "Kastamonu", "Kayseri","Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya ", "Malatya",
            "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya",
            "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon  ", "Tunceli", "Şanlıurfa", "Uşak",
            "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt ", "Karaman", "Kırıkkale", "Batman", "Şırnak",
            "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük ", "Kilis", "Osmaniye ", "Düzce"};
        public bool BaglantiTest()
        {
            try
            {
                baglanti.Open();
                baglanti.Close();
                return true;
            }
            catch (Exception hata)
            {
                MessageBox.Show(hata.Message.ToString(), "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
        }

        public void HastaListele()
        {
            string harfliste = "";
            if (harfler.Length == 1)
                harfliste = harfler[0]+"%";
            harfliste = "[^" + harfler[0] + "-" + harfler[harfler.Length - 1] + "]%";
            baglanti.Open();
            OleDbCommand komut = new OleDbCommand("Select * From tbl_Hasta Where isim LIKE '"+harfliste+"'", baglanti);
            OleDbDataAdapter da = new OleDbDataAdapter(komut);
            DataSet ds = new DataSet();
            da.Fill(ds);
            dtVeriler.DataSource = ds.Tables[0];
            baglanti.Close();
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            cbDogumYeri.DataSource = sehirler;
            cbKanGrubu.SelectedIndex = 0;
            rdE.Checked = true;
            harfler = new string[] { "A" };
            HastaListele();

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

        public void Getir(int id)
        {

            try
            {
                baglanti.Open();
                OleDbCommand komut = new OleDbCommand("Select * From tbl_Hasta Where hasta_id=" + id, baglanti);
                OleDbDataReader reader = komut.ExecuteReader();
                if (reader.Read())
                {
                    txtIsimSoyisim.Text = reader["isim"].ToString();
                    txtDogumTarih.Text = reader["d_tarihi"].ToString();
                    cbDogumYeri.Text = reader["d_yeri"].ToString();
                    cbKanGrubu.Text = reader["kan_grubu"].ToString();
                    if (reader["cinsiyet"].ToString() == "E")
                        rdE.Checked = true;
                    else
                        rdK.Checked = true;

                    txtAdres.Text = reader["adres"].ToString();
                    txtTelNo.Text = reader["tel"].ToString();
                }
                baglanti.Close();
            }
            catch (Exception hata)
            {

            }
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
                OleDbCommand komut = new OleDbCommand("Insert Into tbl_Hasta (isim,d_tarihi,d_yeri,kan_grubu,cinsiyet,adres,tel)" +
                    "values(@isim,@d_tarihi,@d_yeri,@kan_grubu,@cinsiyet,@adres,@tel)", baglanti);
                komut.Parameters.AddWithValue("@isim", txtIsimSoyisim.Text);
                komut.Parameters.AddWithValue("@d_tarihi", txtDogumTarih.Text);
                komut.Parameters.AddWithValue("@d_yeri", cbDogumYeri.Text);
                komut.Parameters.AddWithValue("@kan_grubu", cbKanGrubu.Text);
                if (rdE.Checked)
                    komut.Parameters.AddWithValue("@cinsiyet", "E");
                else
                    komut.Parameters.AddWithValue("@cinsiyet", "K");
                komut.Parameters.AddWithValue("@adres", txtAdres.Text);
                komut.Parameters.AddWithValue("@tel", txtTelNo.Text);
                komut.ExecuteNonQuery();
                baglanti.Close();
                MessageBox.Show("Kayıt eklendi", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
                btnYeni.PerformClick();
            }
            catch (Exception hata)
            {
                MessageBox.Show(hata.Message.ToString(), "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            HastaListele();

        }

        private void btnDegistir_Click(object sender, EventArgs e)
        {
            if (hasta_id == 0)
            {
                MessageBox.Show("Herhangi bir kayıt seçilmedi !!", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (!Kontrol())
            {
                MessageBox.Show("Gerekli alanları doldurunuz !!", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            try
            {
                baglanti.Open();
                OleDbCommand komut = new OleDbCommand("Update tbl_Hasta set isim=@isim,d_tarihi=@d_tarihi" +
                    ",d_yeri=@d_yeri,kan_grubu=@kan_grubu,cinsiyet=@cinsiyet,adres=@adres,tel=@tel" +
                    " where hasta_id=" + hasta_id, baglanti);
                komut.Parameters.AddWithValue("@isim", txtIsimSoyisim.Text);
                komut.Parameters.AddWithValue("@d_tarihi", txtDogumTarih.Text);
                komut.Parameters.AddWithValue("@d_yeri", cbDogumYeri.Text);
                komut.Parameters.AddWithValue("@kan_grubu", cbKanGrubu.Text);
                if (rdE.Checked)
                    komut.Parameters.AddWithValue("@cinsiyet", "E");
                else
                    komut.Parameters.AddWithValue("@cinsiyet", "K");
                komut.Parameters.AddWithValue("@adres", txtAdres.Text);
                komut.Parameters.AddWithValue("@tel", txtTelNo.Text);
                komut.ExecuteNonQuery();
                baglanti.Close();
                MessageBox.Show("Kayıt güncellendi", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            catch (Exception hata)
            {
                MessageBox.Show(hata.Message.ToString(), "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            HastaListele();
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
                OleDbCommand komut = new OleDbCommand("Delete From tbl_Hasta" +
                    " where hasta_id=" + hasta_id, baglanti);
                komut.ExecuteNonQuery();
                baglanti.Close();
                MessageBox.Show("Kayıt silindi", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
                btnYeni.PerformClick();
            }
            catch (Exception hata)
            {
                MessageBox.Show(hata.Message.ToString(), "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            HastaListele();
        }

        private void dtVeriler_RowEnter(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                hasta_id = Convert.ToInt32(dtVeriler.Rows[e.RowIndex].Cells[0].Value);
                Getir(hasta_id);
            }
            catch { }
        }

        private void btnCikis_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void tabPage2_Click(object sender, EventArgs e)
        {
            harfler = new string[] { "A" };
            HastaListele();
        }

        private void tabPage1_Click(object sender, EventArgs e)
        {
            harfler = new string[] { "B","C","D" };
            HastaListele();
        }

        private void tabPage3_Click(object sender, EventArgs e)
        {
            harfler = new string[] { "E" };
            HastaListele();
        }

        private void tabPage4_Click(object sender, EventArgs e)
        {
            harfler = new string[] { "F", "G", "H" };
            HastaListele();
        }

        private void tabPage5_Click(object sender, EventArgs e)
        {
            harfler = new string[] { "I", "İ" };
            HastaListele();
        }

        private void tabPage6_Click(object sender, EventArgs e)
        {
            harfler = new string[] { "J", "K", "L", "M", "N" };
            HastaListele();
        }

        private void tabPage7_Click(object sender, EventArgs e)
        {
            harfler = new string[] { "O", "Ö" };
            HastaListele();
        }

        private void tabPage8_Click(object sender, EventArgs e)
        {
            harfler = new string[] { "P", "R", "T", "S" };
            HastaListele();
        }

        private void tabPage9_Click(object sender, EventArgs e)
        {
            harfler = new string[] { "U", "Ü" };
            HastaListele();
        }

        private void tabPage10_Click(object sender, EventArgs e)
        {
            harfler = new string[] { "V", "Y", "Z" };
            HastaListele();
        }

        private void btnRandevu_Click(object sender, EventArgs e)
        {
            if (hasta_id == 0)
            {
                MessageBox.Show("Herhangi bir kayıt seçilmedi !!", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            new Form2(hasta_id).ShowDialog();
        }

        private void tabControl1_Click(object sender, EventArgs e)
        {

        }
    }
}
