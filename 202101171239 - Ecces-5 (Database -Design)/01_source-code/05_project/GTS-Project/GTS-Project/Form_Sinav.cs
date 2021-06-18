using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_Sinav : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "sinav";
        int ders_Id = 0;
        List<string> dersler;
        int birinci_sinif, ikinci_sinif, ucuncu_sinif, dorduncu_sinif = 0;
        public Form_Sinav()
        {
            InitializeComponent();
        }
        private void Form_Personel_Load(object sender, EventArgs e)
        {
            islemler.CBDoldur(cbBolum, "bolum", 3);
            islemler.CBDoldur(cbDonem, "donem", new int[] { 1, 2, 3 });
            islemler.CBDoldur(cbOgretimUyesi, "ogretim_uyesi", new int[] { 3, 4});

            cbsinavSekil.SelectedIndex = cbSinavTur.SelectedIndex = 0;
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {


            if (ch1.Checked)
                birinci_sinif = 1;
            if (ch2.Checked)
                ikinci_sinif = 1;
            if (ch3.Checked)
                ucuncu_sinif = 1;
            if (ch4.Checked)
                dorduncu_sinif = 1;
            if (birinci_sinif == 0 && ikinci_sinif == 0 && ucuncu_sinif == 0 && dorduncu_sinif == 0)
            {
                MessageBox.Show("En az bir sınıf seçilmelidir !");
                return;
            }

            List<string> bolumler = islemler.Donustur(islemler.Kayitlar("bolum"), 0);
            List<string> donemler = islemler.Donustur(islemler.Kayitlar("donem"), 0);

            List<string> ogretimuyeleri = islemler.Donustur(islemler.Kayitlar("ogretim_uyesi"), 0);
            int bolum_Id = Convert.ToInt32(bolumler[cbBolum.SelectedIndex]);
            int donem_Id = Convert.ToInt32(donemler[cbDonem.SelectedIndex]);
            int ogretim_uyesi_Id = Convert.ToInt32(ogretimuyeleri[cbOgretimUyesi.SelectedIndex]);

      

            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "bolum_Id",bolum_Id
                },
                 new ArrayList(){
                    "donem_Id",donem_Id
                },
                  new ArrayList(){
                    "ogretim_uyesi_Id",ogretim_uyesi_Id
                },
                   new ArrayList(){
                    "ders_Id",ders_Id
                },
                    new ArrayList(){
                    "sinav_tarihi",dtTarih.Value
                },
                     new ArrayList(){
                    "sinav_saati",msSaat.Text
                },
                 new ArrayList(){
                    "sinav_turu",cbSinavTur.Text
                },
                   new ArrayList(){
                    "sinav_sekli",cbsinavSekil.Text
                },
                  new ArrayList(){
                    "sinav_suresi",txtSure.Text
                },

                 new ArrayList(){
                    "birinci_sinif",birinci_sinif
                },
                 new ArrayList(){
                    "ikinci_sinif",ikinci_sinif
                },
                 new ArrayList(){
                    "ucuncu_sinif",ucuncu_sinif
                },
                 new ArrayList(){
                    "dorduncu_sinif",dorduncu_sinif
                },

            };

            if (islemler.Ekle(tablo, kayit))
            {
                txtSure.Text = "";
                msSaat.Text = "";
                msSaat.Focus();
            }
               
        }

        private void txtSure_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
                btn_Ekle.PerformClick();
        }

        private void msSaat_KeyDown(object sender, KeyEventArgs e)
        {
            
        }

        private void msSaat_MaskInputRejected(object sender, MaskInputRejectedEventArgs e)
        {

        }

        private void cbDers_Leave(object sender, EventArgs e)
        {
            //cbDers.SelectedIndex = cbDers.SelectedIndex + 1;
        }

        private void btn_Sil_Click(object sender, EventArgs e)
        {
            //islemler.Sil(this, tablo, Id);
        }

        private void cbBolum_SelectedIndexChanged(object sender, EventArgs e)
        {
            List<string> bolumler = islemler.Donustur(islemler.Kayitlar("bolum"), 0);
            int bolum_Id = Convert.ToInt32(bolumler[cbBolum.SelectedIndex]);
            dersler = islemler.Donustur(islemler.Kayitlar("ders"), 0, 1, bolum_Id);
            islemler.CBDoldur(cbDers, "ders", 2, 1, bolum_Id);
        }

        private void cbDers_SelectedIndexChanged(object sender, EventArgs e)
        {
            ders_Id = Convert.ToInt32(dersler[cbDers.SelectedIndex]);
        }
    }
}
