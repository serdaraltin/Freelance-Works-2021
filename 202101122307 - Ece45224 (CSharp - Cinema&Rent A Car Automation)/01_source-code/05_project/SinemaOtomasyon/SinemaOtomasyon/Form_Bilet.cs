using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace SinemaOtomasyon
{
    public partial class Form_Bilet : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "bilet";
        int Id = 0, seans_Id = 0;
        public Form_Bilet()
        {
            InitializeComponent();
        }
        public Form_Bilet(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            dg_veriler.DataSource = islemler.Kayitlar("seans").Tables[0];
            comboBox1.SelectedIndex = 0;
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);
                    comboBox1.Text = veriler[1].ToString();
                    numericUpDown1.Value = Convert.ToInt32(veriler[3]);
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
            if(seans_Id == 0)
            {
                MessageBox.Show("Seans seçiniz !");
                return;
            }

            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "musteri_tipi",comboBox1.Text
                },
                new ArrayList(){
                    "seans_Id",seans_Id
                },
                  new ArrayList(){
                    "koltuk_no",(int)numericUpDown1.Value
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

        private void dg_veriler_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dg_veriler_RowEnter(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                seans_Id = Convert.ToInt32(dg_veriler.Rows[e.RowIndex].Cells[0].Value);
            }
            catch { }
        }
    }
}
