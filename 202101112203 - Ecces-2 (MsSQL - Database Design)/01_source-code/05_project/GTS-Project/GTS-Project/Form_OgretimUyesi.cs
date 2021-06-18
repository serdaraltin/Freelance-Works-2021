using System;
using System.Collections;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_OgretimUyesi : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "ogretim_uyesi";
        int Id = 0;
        public Form_OgretimUyesi()
        {
            InitializeComponent();
        }
    

        private void Form_Personel_Load(object sender, EventArgs e)
        {
          
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "unvan",tunvan.Text
                },
                 new ArrayList(){
                    "tcno",ttc.Text
                },
                new ArrayList(){
                    "ad",tad.Text
                },
                new ArrayList(){
                    "soyad",tsoyad.Text
                },
                    new ArrayList(){
                    "telefon",ttel.Text
                },
                     new ArrayList(){
                    "eposta",teposta.Text
                },
                new ArrayList(){
                    "adres",tadres.Text
                }
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
