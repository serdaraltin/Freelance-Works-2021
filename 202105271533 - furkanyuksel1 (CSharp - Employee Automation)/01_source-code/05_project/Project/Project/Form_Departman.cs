using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Departman : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "departman";
        int Id = 0;
        public Form_Departman()
        {
            InitializeComponent();
        }
        public Form_Departman(int _Id)
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

                    txtAd.Text = veriler[1].ToString();
                    txtAmac.Text = veriler[2].ToString();
                    txtAciklama.Text = veriler[3].ToString();

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
                    "ad",txtAd.Text
                },
                new ArrayList(){
                    "amac",txtAmac.Text
                },
                 new ArrayList(){
                    "aciklama",txtAciklama.Text
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
