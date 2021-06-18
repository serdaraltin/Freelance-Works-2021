using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace AracKiralamaOtomasyon
{
    public partial class Form_Kiralama : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "kiralama";
        int Id = 0;
        public Form_Kiralama()
        {
            InitializeComponent();
        }
        public Form_Kiralama(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            islemler.CBDoldur(cbArac, "arac", new int[] { 1, 2, 4 });
            islemler.CBDoldur(cbMusteri, "musteri", new int[] { 2, 3, 1 });
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);


                    islemler.CBSec(cbArac, islemler.Donustur(islemler.Kayitlar("arac"), 0), Convert.ToInt32(veriler[1]));
                    islemler.CBSec(cbMusteri, islemler.Donustur(islemler.Kayitlar("musteri"), 0), Convert.ToInt32(veriler[2]));
                    txtGun.Text = veriler[3].ToString();
                    txtTutar.Text = veriler[4].ToString();

                    this.Text += " Güncelle";
                    btn_Ekle.Text = "Güncelle";
                    btn_Sil.Visible = true;
                }
                catch
                {
                    return;
                }
            }
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            List<string> araclar = islemler.Donustur(islemler.Kayitlar("arac"), 0);
            List<string> musteriler = islemler.Donustur(islemler.Kayitlar("musteri"), 0);
            int arac_Id = Convert.ToInt32(araclar[cbArac.SelectedIndex]);
            int musteri_Id = Convert.ToInt32(araclar[cbMusteri.SelectedIndex]);
            if (txtGun.Text == "")
            {
                MessageBox.Show("Gerekli alanları doldurunuz !");
                return;
            }
            float fiyat = float.Parse(islemler.Getir("arac", arac_Id)[5].ToString());
            float tutar = Convert.ToInt32(txtGun.Text) * fiyat;

            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "arac_Id",arac_Id
                },
                new ArrayList(){
                    "musteri_Id",musteri_Id
                },
                 new ArrayList(){
                    "gun",Convert.ToInt32(txtGun.Text)
                },
                   new ArrayList(){
                    "tutar",tutar
                },
            };

            if (Id != 0)
            {
                kayit.Add(new ArrayList() { "Id", Id });
                if (islemler.Guncelle(tablo, kayit))
                    islemler.MesajKutu(tablo + " güncelleme");
                else
                    islemler.MesajKutu(2, tablo + " güncelleme");
                return;
            }
            if (islemler.Ekle(tablo, kayit))
                islemler.MesajKutu(tablo + " ekleme");
            else
                islemler.MesajKutu(2, tablo + " ekleme");
            islemler.Temizle(this);
        }

        private void btn_Sil_Click(object sender, EventArgs e)
        {
            islemler.Sil(this, tablo, Id);
        }

        private void cbYil_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void txtGun_TextChanged(object sender, EventArgs e)
        {
            if (txtGun.Text == "")
            {
                txtTutar.Text = "";
                return;
            }

            List<string> araclar = islemler.Donustur(islemler.Kayitlar("arac"), 0);

            int arac_Id = Convert.ToInt32(araclar[cbArac.SelectedIndex]);

            int fiyat = Convert.ToInt32(islemler.Getir("arac", arac_Id)[5].ToString());
            int tutar = Convert.ToInt32(txtGun.Text) * fiyat;
            txtTutar.Text = tutar.ToString();

        }
    }
}
