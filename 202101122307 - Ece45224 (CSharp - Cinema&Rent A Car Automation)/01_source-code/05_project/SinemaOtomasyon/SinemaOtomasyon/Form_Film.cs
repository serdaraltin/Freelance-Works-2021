using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace SinemaOtomasyon
{
    public partial class Form_Film : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "film";
        int Id = 0;
        public Form_Film()
        {
            InitializeComponent();
        }
        public Form_Film(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            string[] kategoriler = new string[] { "Aksiyon", "Macera", "Animasyon", "Çocuk", "Komedi", "Suç", "Drama", "Epik", "Aile", "Fantazi", "Korku", "Müzikal", "Gizem/Gerilim", "Aşk", "Bilim Kurgu", "Spor", "Doğa Üstü", "Gerilim", "Western" };
            foreach (string kategori in kategoriler)
            {
                comboBox1.Items.Add(kategori);
            }

            for (int i = 2021; i > 1900; i--)
            {
                comboBox2.Items.Add(i.ToString());
            }
            comboBox1.SelectedIndex = comboBox2.SelectedIndex = 0;
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    txt_Ad.Text = veriler[2].ToString();
                    txtFilm.Text = veriler[3].ToString();
                    comboBox2.Text = veriler[4].ToString();
                    List<string> universiteler = islemler.Donustur(islemler.Kayitlar("tbl_universite"), 0);

                    islemler.CBSec(comboBox1, universiteler, Convert.ToInt32(veriler[1]));

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

            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "ad",txt_Ad.Text
                },
                new ArrayList(){
                    "kategori",comboBox1.Text
                },
                  new ArrayList(){
                    "yonetmen",txtFilm.Text
                },
                  new ArrayList(){
                    "yil",comboBox2.Text
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
    }
}
