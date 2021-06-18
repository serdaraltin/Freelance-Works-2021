using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Ilac : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "ilac";
        int Id = 0;
        public Form_Ilac()
        {
            InitializeComponent();
            cbTur.SelectedIndex = 0;
        }
        public Form_Ilac(int _Id)
        {
            InitializeComponent();
            Id = _Id;
            ArrayList veriler = islemler.Getir(tablo, Id);

            txtBarkod.Text = veriler[1].ToString();
            txtAd.Text = veriler[2].ToString();
            cbTur.Text = veriler[3].ToString();
            txtYanEtkiler.Text = veriler[4].ToString();


            this.Text += " Güncelle";
            btn_Ekle.Text = "Güncelle";
            btn_Sil.Visible = true;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
          
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "barkod",txtBarkod.Text
                },
                new ArrayList(){
                    "ad",txtAd.Text
                },
                 new ArrayList(){
                    "tur",cbTur.Text
                },
                   new ArrayList(){
                    "yanEtkiler",txtYanEtkiler.Text
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
