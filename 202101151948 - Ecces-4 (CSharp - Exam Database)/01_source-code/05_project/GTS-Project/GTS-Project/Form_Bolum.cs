using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_Bolum : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "bolum";
        int Id = 0;
        public Form_Bolum()
        {
            InitializeComponent();
        }
        private void Form_Personel_Load(object sender, EventArgs e)
        {
            islemler.CBDoldur(comboBox1, "fakulte", 1);
            islemler.CBDoldur(comboBox2, "ogretim_uyesi", new int[] { 3, 4, 2 });
            comboBox3.SelectedIndex = 0;
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            List<string> fakulteler = islemler.Donustur(islemler.Kayitlar("fakulte"), 0);
            int fakulte_Id = Convert.ToInt32(fakulteler[comboBox1.SelectedIndex]);

            List<string> ogretim_uyeleri = islemler.Donustur(islemler.Kayitlar("ogretim_uyesi"), 0);
            int bolum_baskan_Id = Convert.ToInt32(ogretim_uyeleri[comboBox1.SelectedIndex]);
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "fakulte_Id",fakulte_Id
                },
                 new ArrayList(){
                    "bolum_baskan_Id",bolum_baskan_Id
                },

                new ArrayList(){
                    "bolum_ad",tad.Text
                },
                 new ArrayList(){
                    "lisans_turu",comboBox3.Text
                }
            };

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
