using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_Fakulte : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "fakulte";
        int Id = 0;
        public Form_Fakulte()
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
                    "fakulte_ad",tad.Text
                },
                 new ArrayList(){
                    "kurulus_tarih",dateTimePicker1.Value
                },
             
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
