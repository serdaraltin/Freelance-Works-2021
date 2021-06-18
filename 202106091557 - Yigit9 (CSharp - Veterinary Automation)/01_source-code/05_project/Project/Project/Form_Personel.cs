using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Personel : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "personel";
        int Id = 0;
        public Form_Personel()
        {
            InitializeComponent();
            cbCinsiyet.SelectedIndex = 0;
        }
        public Form_Personel(int _Id)
        {
            InitializeComponent();
            Id = _Id;
            ArrayList veriler = islemler.Getir(tablo, Id);

            txtTcno.Text = veriler[1].ToString();
            txtAd.Text = veriler[2].ToString();
            txtSoyad.Text = veriler[3].ToString();
            cbCinsiyet.Text = veriler[4].ToString();
            txtTelefon.Text = veriler[5].ToString();
            txtEposta.Text = veriler[6].ToString();
            txtAdres.Text = veriler[7].ToString();
            txtMeslek.Text = veriler[8].ToString();
            txtMaas.Text = veriler[9].ToString();

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
                    "tcno",txtTcno.Text
                },
                   new ArrayList(){
                    "ad",txtAd.Text
                },
                      new ArrayList(){
                    "soyad",txtSoyad.Text
                },

                 new ArrayList(){
                    "cinsiyet",cbCinsiyet.Text
                },
               new ArrayList(){
                    "telefon",txtTelefon.Text
                },

               new ArrayList(){
                    "eposta",txtEposta.Text
                },
               new ArrayList(){
                    "adres",txtAdres.Text
                },
                 new ArrayList(){
                    "meslek",txtMeslek.Text
                },
                new ArrayList(){
                    "maas",Convert.ToInt32(txtMaas.Text)
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
