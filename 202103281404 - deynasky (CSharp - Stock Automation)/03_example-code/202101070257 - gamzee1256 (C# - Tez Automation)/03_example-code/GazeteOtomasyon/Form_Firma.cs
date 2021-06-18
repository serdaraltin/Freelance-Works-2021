using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GazeteOtomasyon
{
    public partial class Form_Firma : Form
    {
        int Id =0;
        public Form_Firma()
        {
            InitializeComponent();
        }
        public Form_Firma(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "tbl_firma";
        private void Form_Personel_Load(object sender, EventArgs e)
        {
           

            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    txt_Ad.Text = veriler[1].ToString();
                    txt_Slogan.Text = veriler[2].ToString(); 
                    txt_Il.Text = veriler[3].ToString();
                    txt_Ilce.Text = veriler[4].ToString();
                    txt_Adres.Text = veriler[5].ToString();
                    txt_Aciklama.Text = veriler[6].ToString();

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
                new ArrayList(){"FirmaAd",txt_Ad.Text},
                new ArrayList(){"Slogan",txt_Slogan.Text},
                new ArrayList(){"Il",txt_Il.Text},
                new ArrayList(){"Ilce",txt_Ilce.Text},
                new ArrayList(){"Adres",txt_Adres.Text},
                new ArrayList(){"Aciklama",txt_Aciklama.Text},
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
