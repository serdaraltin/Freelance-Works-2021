using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Hesap : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "hesap";
        int Id = 0;
        public Form_Hesap()
        {
            InitializeComponent();
        }
        public Form_Hesap(int _Id)
        {
            InitializeComponent();
            Id = _Id;
            ArrayList veriler = islemler.Getir(tablo, Id);

            dtTarih.Text = veriler[1].ToString();
            txtUcret.Text = veriler[2].ToString();


            this.Text += " Güncelle";
            btn_Ekle.Text = "Güncelle";
            btn_Sil.Visible = true;

        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {


            
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            if (txtUcret.Text == "")
                txtUcret.Text = "0";
            ArrayList kayit = new ArrayList()
            {
                 new ArrayList(){
                    "tarih",dtTarih.Value.ToString()
                },
                  new ArrayList(){
                    "toplam",txtUcret.Text
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
