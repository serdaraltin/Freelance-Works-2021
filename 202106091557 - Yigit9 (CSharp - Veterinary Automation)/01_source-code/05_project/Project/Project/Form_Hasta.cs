using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Hasta : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "hasta";
        int Id = 0;
        public Form_Hasta()
        {
            InitializeComponent();
            islemler.CBDoldur(cbSahip, "sahip", new int[] { 2, 3, 4 });
            cbCinsiyet.SelectedIndex = 0;
        }
        public Form_Hasta(int _Id)
        {
            InitializeComponent();
            islemler.CBDoldur(cbSahip, "sahip", new int[] { 2, 3, 4 });

            Id = _Id;
            ArrayList veriler = islemler.Getir(tablo, Id);

            txtKimlikNo.Text = veriler[2].ToString();
            txtAd.Text = veriler[3].ToString();
            txtTur.Text = veriler[4].ToString();
            txtCins.Text = veriler[5].ToString();
            cbRenk.Text = veriler[6].ToString();
            cbCinsiyet.Text = veriler[7].ToString();
            dtDogumTarih.Text = veriler[8].ToString();


            islemler.CBSec(cbSahip, "sahip", Convert.ToInt32(veriler[0]));


            this.Text += " Güncelle";
            btn_Ekle.Text = "Güncelle";
            btn_Sil.Visible = true;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            int sahipId = islemler.GetirId("sahip", cbSahip.SelectedIndex);
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "sahipId",sahipId
                },
                   new ArrayList(){
                    "kimlikNo",txtKimlikNo.Text
                },
                      new ArrayList(){
                    "ad",txtAd.Text
                },

                 new ArrayList(){
                    "tur",txtTur.Text
                },


                 new ArrayList(){
                    "cins",txtCins.Text
                },

                 new ArrayList(){
                    "renk",cbRenk.Text
                },

                 new ArrayList(){
                    "cinsiyet",cbCinsiyet.Text
                },

                  new ArrayList(){
                    "dogumTarih",dtDogumTarih.Value.ToString()
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

        private void cbHesap_SelectedIndexChanged(object sender, EventArgs e)
        {


        }

    }
}
