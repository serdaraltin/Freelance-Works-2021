using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_Enstitu : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "tbl_enstitu";
        int Id = 0;
        public Form_Enstitu()
        {
            InitializeComponent();
        }
        public Form_Enstitu(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            islemler.CBDoldur(comboBox1, "tbl_universite", 1);
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    txt_Ad.Text = veriler[2].ToString();
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
            List<string> universiteler = islemler.Donustur(islemler.Kayitlar("tbl_universite"),0);
            int universite_Id = Convert.ToInt32(universiteler[comboBox1.SelectedIndex]);
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "ad",txt_Ad.Text
                },
                new ArrayList(){
                    "universite_Id",universite_Id
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
