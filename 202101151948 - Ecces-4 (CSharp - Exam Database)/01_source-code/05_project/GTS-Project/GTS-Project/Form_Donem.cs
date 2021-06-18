using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_Donem : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "donem";
        int Id = 0;
        public Form_Donem()
        {
            InitializeComponent();
        }
        private void Form_Personel_Load(object sender, EventArgs e)
        {
            for (int i = 2021; i > 1999; i--)
            {
                cbBas.Items.Add(i.ToString());
                cbBitis.Items.Add(i.ToString());
            }
            cbDonem.SelectedIndex= cbBitis.SelectedIndex= cbBas.SelectedIndex = 0;
          
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
          
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "donem_ad",cbDonem.Text
                },
                new ArrayList(){
                    "baslangic_yil",Convert.ToInt32(cbBas.Text)
                },
                 new ArrayList(){
                    "bitis_yil",Convert.ToInt32(cbBitis.Text)
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

        private void cbBitis_SelectedIndexChanged(object sender, EventArgs e)
        {

            int yil = Convert.ToInt32(cbBitis.SelectedItem);
            cbBas.Text = (yil - 1).ToString();
        }

        private void cbBas_SelectedIndexChanged(object sender, EventArgs e)
        {
            int yil = Convert.ToInt32(cbBas.SelectedItem);
            cbBitis.Text = (yil + 1).ToString();
        }
    }
}
