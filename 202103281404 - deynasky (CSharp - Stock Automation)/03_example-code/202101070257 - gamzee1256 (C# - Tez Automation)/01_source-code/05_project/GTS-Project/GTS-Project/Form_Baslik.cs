using System;
using System.Collections;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_Baslik : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "tbl_baslik";
        int Id = 0;
        public Form_Baslik()
        {
            InitializeComponent();
        }
        public Form_Baslik(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    txt.Text = veriler[1].ToString();
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
                new ArrayList(){
                    "baslik",txt.Text
                }
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
