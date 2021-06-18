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
    public partial class Form_Abone : Form
    {
        int Id = 0;
        public Form_Abone()
        {
            InitializeComponent();
        }
        public Form_Abone(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "tbl_abone";
        private void Form_Personel_Load(object sender, EventArgs e)
        {
            cb_AboneTur.SelectedIndex = 0;

            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    cb_AboneTur.Text = veriler[1].ToString();
                    txt_TcNo.Text = veriler[2].ToString(); txt_TcNo.ReadOnly = true;
                    txt_Ad.Text = veriler[3].ToString();
                    txt_Soyad.Text = veriler[4].ToString();
                    txt_Telefon.Text = veriler[5].ToString();
                    txt_Email.Text = veriler[6].ToString();
                    cb_Meslek.Text = veriler[7].ToString();
                    txt_Adres.Text = veriler[8].ToString();
                    txt_AbonelikUcret.Text =veriler[9].ToString().Split(',')[0];

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
                new ArrayList(){"AboneTur",cb_AboneTur.Text},
                new ArrayList(){"TcNo",txt_TcNo.Text},
                new ArrayList(){"Ad",txt_Ad.Text},
                new ArrayList(){"Soyad",txt_Soyad.Text},
                new ArrayList(){"Telefon",txt_Telefon.Text},
                new ArrayList(){"Email",txt_Email.Text},
                new ArrayList(){"Meslek",cb_Meslek.Text},
                new ArrayList(){"Adres",txt_Adres.Text},
                new ArrayList(){"AbonelikUcret",  float.Parse(txt_AbonelikUcret.Text)}
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
