using System.Collections.Generic;
using System.Data.SqlClient;
using System.Data;
using System.Collections;
using System;
using System.Windows.Forms;
using System.Linq;

namespace GTS_Project
{
    class Class_Islemler
    {
        //SqlConnection baglanti = new SqlConnection("Data Source=" + Ayarlar.Default.Sunucu + ";Initial Catalog=" + Ayarlar.Default.Veritabani + ";User Id="+Ayarlar.Default.Kullanici+";Password="+Ayarlar.Default.Parola+";");
        SqlConnection baglanti = new SqlConnection("Data Source = " + Ayarlar.Default.Sunucu + ", 1433; Network Library = DBMSSOCN; Initial Catalog = " + Ayarlar.Default.Veritabani + "; User ID = " + Ayarlar.Default.Kullanici + "; Password = " + Ayarlar.Default.Parola + ";");
        //BAĞLANTI TEST
        public bool BaglantiTest() // Veritabanına bağlantının gerçekleşme durumunu test etme
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
        public bool Yonetici_Kontrol(string KullaniciAd, string Parola) //Yonetici bilgilerinin kontrolü
        {
            try
            {
                baglanti.Open();
                SqlCommand komut = new SqlCommand("Yonetici_Kontrol", baglanti);
                komut.CommandType = CommandType.StoredProcedure;
                komut.Parameters.AddWithValue("@KullaniciAd", KullaniciAd);
                komut.Parameters.AddWithValue("@Parola", Parola);
                SqlDataReader oku = komut.ExecuteReader();
                if (oku.Read())
                {
                    baglanti.Close();
                    return true;
                }
                baglanti.Close();
                return false;
            }
            catch
            {
                baglanti.Close();
                return false;
            }
        }
        //ANA İŞLEMLER
        public bool Kontrol(string tablo, int Id) //Tabloda istenilen kaydın olup olmadığı kontrolü
        {
            try
            {
                baglanti.Open();
                SqlCommand komut = new SqlCommand("Getir", baglanti);
                komut.CommandType = CommandType.StoredProcedure;
                komut.Parameters.AddWithValue("@Tablo", tablo);
                komut.Parameters.AddWithValue("@Id", Id);
                SqlDataReader oku = komut.ExecuteReader();
                if (oku.Read())
                {
                    baglanti.Close();
                    return true;
                }
                baglanti.Close();
                return false;
            }
            catch
            {
                baglanti.Close();
                return false;
            }
        }
        public bool Ekle(string tablo, ArrayList veriler) //Herhangibir tabloya yeni kayıt ekleme
        {
            try
            {

                baglanti.Open();
                SqlCommand komut = new SqlCommand(tablo + "_Ekle", baglanti);
                komut.CommandType = CommandType.StoredProcedure;
                foreach (ArrayList Kolon in veriler)
                    komut.Parameters.AddWithValue("@" + Kolon[0], Kolon[1]);
                komut.ExecuteNonQuery();
                komut.Dispose();
                baglanti.Close();
                return true;
            }
            catch
            {
                baglanti.Close();
                return false;
            }
        }
        public bool Guncelle(string tablo, ArrayList veriler) //Herhangibir tablodaki bir kaydı güncelleme
        {
            try
            {
                baglanti.Open();
                SqlCommand komut = new SqlCommand(tablo + "_Guncelle", baglanti);
                komut.CommandType = CommandType.StoredProcedure;
                foreach (ArrayList Kolon in veriler)
                    komut.Parameters.AddWithValue("@" + Kolon[0], Kolon[1]);
                komut.ExecuteNonQuery();
                komut.Dispose();
                baglanti.Close();
                return true;
            }
            catch
            {
                baglanti.Close();
                return false;
            }
        }
        public bool Sil(string tablo, int Id) //Herhangibir tablodaki 1 kaydı silme
        {
            if (!(Kontrol(tablo, Id)))
                return false;
            try
            {
                baglanti.Open();
                SqlCommand komut = new SqlCommand("Sil", baglanti);
                komut.CommandType = CommandType.StoredProcedure;
                komut.Parameters.AddWithValue("@Tablo", tablo);
                komut.Parameters.AddWithValue("@Id", Id);
                komut.ExecuteNonQuery();
                komut.Dispose();
                baglanti.Close();
                return true;
            }
            catch
            {
                baglanti.Close();
                return false;
            }
        }
        public ArrayList Getir(string tablo, int Id) //Herhangibir tablodan id bilgisine göre kayıt getirme
        {
            try
            {
                baglanti.Open();
                SqlCommand komut = new SqlCommand("Getir", baglanti);
                komut.CommandType = CommandType.StoredProcedure;
                komut.Parameters.AddWithValue("@Tablo", tablo);
                komut.Parameters.AddWithValue("@Id", Id);
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
                return veriler;
            }
            catch
            {
                baglanti.Close();
                return null;
            }

        }
        public string[] Getir(string tablo, string sorulan) //Herhangibir tablodan herhangibir kolon verisine göre kayıt getirme
        {
            try
            {
                DataSet veriler = Kayitlar(tablo);
                ArrayList liste = Donustur(veriler);
                foreach (string[] items in liste)
                    foreach (string veri in items)
                        if (veri == sorulan)
                            return items;
                return null;
            }
            catch { return null; }
        }
        public DataSet Kayitlar(string tablo) //Herhangibir tablodaki tüm kayıtları listeleme
        {
            try
            {
                baglanti.Open();
                SqlCommand komut = new SqlCommand("Kayitlar", baglanti);
                komut.CommandType = CommandType.StoredProcedure;
                komut.Parameters.AddWithValue("@Tablo", tablo);
                SqlDataAdapter da = new SqlDataAdapter(komut);
                DataSet ds = new DataSet();
                da.Fill(ds);
                komut.Dispose();
                baglanti.Close();
                return ds;
            }
            catch
            {
                baglanti.Close();
                return null;
            }
        }
        public ArrayList Donustur(DataSet veri) //Dataset türündeki bir veriyi ArrayList türüne dönüştürme
        {
            try
            {
                ArrayList veriler = new ArrayList();
                foreach (DataRow satir in veri.Tables[0].Rows)
                {
                    string[] parcalanmis = string.Join(",", satir.ItemArray).Split(',').ToArray();
                    veriler.Add(parcalanmis);
                }
                return veriler;
            }
            catch { return null; }
        }
        public List<string> Donustur(DataSet veri, int kolon) //Dataset türündeki bir veriden tek bir kolonu List<string> türüne dönüştürme
        {
            try
            {
                List<string> veriler = new List<string>();
                foreach (DataRow satir in veri.Tables[0].Rows)
                {
                    string[] parcalanmis = string.Join(",", satir.ItemArray).Split(',').ToArray();
                    veriler.Add(parcalanmis[kolon]);
                }
                return veriler;
            }
            catch { return null; }
        }
        public List<string> Donustur(DataSet veri, int kolon, int f_kolon, int f_Id) //Dataset türündeki bir veriden tek bir kolonu List<string> türüne dönüştürme
        {
            try
            {
                List<string> veriler = new List<string>();
                foreach (DataRow satir in veri.Tables[0].Rows)
                {
                    if (Convert.ToInt32(satir.ItemArray[f_kolon]) == f_Id)
                    {
                        string[] parcalanmis = string.Join(",", satir.ItemArray).Split(',').ToArray();
                        veriler.Add(parcalanmis[kolon]);
                    }
                }
                return veriler;
            }
            catch { return null; }
        }
        public void Ekle(Form form, string tablo, ArrayList veriler)//Çağrılan formda verilen bilgilere göre hata veya uyarı mesaj kutusu oluşturma
        {
            if (Ekle(tablo, veriler))
                MesajKutu(tablo + " ekleme");
            else
                MesajKutu(2, tablo + " ekleme");
            Temizle(form);
        }
        public void Guncelle(Form form, string tablo, ArrayList veriler, int Id)//Herhangi bir tablodaki bir kaydı güncelleme ve mesaj kutusu oluşturma
        {
            veriler.Add(new ArrayList() { "Id", Id });
            if (Guncelle(tablo, veriler))
                MesajKutu(tablo + " güncelleme");
            else
                MesajKutu(2, tablo + " güncelleme");
            return;
        }
        public void Sil(Form form, string tablo, int Id)//Herhangi bir tablodaki bir kaydı silme ve mesaj kutusu oluşturma
        {
            if (SoruKutu(tablo + "'i silmek"))
            {
                if (Sil(tablo, Id))
                {
                    MesajKutu("silme");
                    form.Close();
                }
                else
                    MesajKutu(2, "silme");
            }
        }
        public void MesajKutu(int tur, string islem)//Hata ve Uyarı türünde mesaj kutuları oluşturma
        {
            switch (tur)
            {
                case 1:
                    MessageBox.Show(islem.ToUpper() + " işlemi için gerekli alanları doldurunuz.", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    break;
                case 2:
                    MessageBox.Show(islem.ToUpper() + " işlemi başarısız !!!", "Hata", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    break;
            }
        }
        public void MesajKutu(string islem)//Bilgi türünde mesaj kutusu oluşturma
        {
            MessageBox.Show(islem.ToUpper() + " işlemi başarılı.", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
        public bool SoruKutu(string soru)//Soru türünde mesaj kutusu oluşturma
        {
            DialogResult cevap = MessageBox.Show(soru.ToUpper() + " istediğinize emin misiniz?", "Soru", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (cevap == DialogResult.Yes)
                return true;
            else
                return false;
        }
        public void CBSec(ComboBox box, List<string> veriler, int Id)//Herhangi bir Combobox nesnesinin verisetinden index seçme
        {
            for (int i = 0; i < veriler.Count; i++)
                if (Id == Convert.ToInt32(veriler[i]))
                    box.SelectedIndex = i;
        }
        public void CBDoldur(ComboBox box, string tablo, int kolon)//Herhangi bir Combobox nesnesine bir tablonun bir kolonundan veri aktarma
        {
            box.Items.Clear();
            try
            {
                ArrayList veriler = Donustur(Kayitlar(tablo));
                foreach (string[] item in veriler)
                    box.Items.Add(item[kolon]);
                box.SelectedIndex = 0;
            }
            catch
            {
                MesajKutu(2, tablo + " kaydı listeleme");
            }
        }
        public void CBDoldur(ComboBox box, string tablo, int kolon, int k_kolon, int k_Id)//Herhangi bir Combobox nesnesine bir tablonun bir kolonundan veri aktarma seçmeli
        {
            try
            {
                box.Items.Clear();
                ArrayList veriler = Donustur(Kayitlar(tablo));
                foreach (string[] item in veriler)
                {
                    if (Convert.ToInt32(item[k_kolon]) == k_Id)
                        box.Items.Add(item[kolon]);
                }

                box.SelectedIndex = 0;
            }
            catch
            {
                MesajKutu(2, tablo + " kaydı listeleme");
            }
        }
        public void CBDoldur(ComboBox box, string tablo, int[] kolonlar)//Herhangi bir Combobox nesnesine bir tablonun birçok kolonundan veri aktarma
        {
            try
            {
                box.Items.Clear();
                ArrayList siniflar = Donustur(Kayitlar(tablo));
                foreach (string[] item in siniflar)
                {
                    string veri = "";
                    for (int i = 0; i < kolonlar.Length; i++)
                    {
                        veri += item[kolonlar[i]] + " ";
                    }
                    box.Items.Add(veri);
                }

                box.SelectedIndex = 0;
            }
            catch
            {
                MesajKutu(2, tablo + " kaydı listeleme");
            }
        }

        public void Temizle(Form form)//Herhangi bir formdaki doldurulabilir nesnelerin içeriğini temizleme
        {
            foreach (Control item in form.Controls)
            {
                if (item is TextBox)
                    ((TextBox)item).Clear();
                if (item is MaskedTextBox)
                    ((MaskedTextBox)item).Clear();
                if (item is ComboBox)
                    if (((ComboBox)item).Items.Count > 0)
                        ((ComboBox)item).SelectedIndex = 0;
                if (item is DateTimePicker)
                    ((DateTimePicker)item).ResetText();
            }
        }

    }
}
