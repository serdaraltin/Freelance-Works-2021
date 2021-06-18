using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace SinemaOtomasyon
{
    public partial class Form_Seans : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "seans";
        int Id = 0;
        public Form_Seans()
        {
            InitializeComponent();
        }
        public Form_Seans(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            islemler.CBDoldur(comboBox1, "film", 1);
            islemler.CBDoldur(comboBox2, "salon", 1);
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);


                    List<string> filmler = islemler.Donustur(islemler.Kayitlar("film"), 0);
                    islemler.CBSec(comboBox1, filmler, Convert.ToInt32(veriler[1]));
                    List<string> salonlar = islemler.Donustur(islemler.Kayitlar("salon"), 0);
                    islemler.CBSec(comboBox2, salonlar, Convert.ToInt32(veriler[2]));
                    dateTimePicker1.Value = (DateTime)veriler[3];
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
            List<string> filmler = islemler.Donustur(islemler.Kayitlar("film"), 0);
            List<string> salonlar = islemler.Donustur(islemler.Kayitlar("salon"), 0);
            int film_Id = Convert.ToInt32(filmler[comboBox1.SelectedIndex]);
            int salon_Id = Convert.ToInt32(salonlar[comboBox2.SelectedIndex]);
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "film_Id",film_Id
                },
                new ArrayList(){
                    "salon_Id",salon_Id
                },
                  new ArrayList(){
                    "tarih",dateTimePicker1.Value
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
