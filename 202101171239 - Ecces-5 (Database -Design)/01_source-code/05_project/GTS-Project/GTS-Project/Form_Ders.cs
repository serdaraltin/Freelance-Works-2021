using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_Ders : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "ders";
        int Id = 0;
        public Form_Ders()
        {
            InitializeComponent();
        }
        private void Form_Personel_Load(object sender, EventArgs e)
        {
            islemler.CBDoldur(comboBox1, "bolum", 3);

        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            List<string> bolumler = islemler.Donustur(islemler.Kayitlar("bolum"), 0);
            int bolum_Id = Convert.ToInt32(bolumler[comboBox1.SelectedIndex]);
            ArrayList kayit = new ArrayList()
            {

                new ArrayList(){
                    "bolum_Id",bolum_Id
                },
                 new ArrayList(){
                    "ders_ad",tad.Text
                },
                new ArrayList(){
                    "kredi",Convert.ToInt32(numericUpDown1.Value)
                }
            };

            if (islemler.Ekle(tablo, kayit))
                tad.Text = "";
        }

        private void btn_Sil_Click(object sender, EventArgs e)
        {
            islemler.Sil(this, tablo, Id);
        }

        private void tad_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                btn_Ekle.PerformClick();
            }
        }
    }
}
