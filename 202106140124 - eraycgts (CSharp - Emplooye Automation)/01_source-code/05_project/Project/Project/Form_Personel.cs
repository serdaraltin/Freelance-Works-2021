using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Personel : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "personel";
        int Id = 0;
        public Form_Personel()
        {
            InitializeComponent();
        }
        public Form_Personel(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            islemler.CBDoldur(comboBox1,"departman",1);
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    txtTcno.Text = veriler[1].ToString();
                    txtAd.Text = veriler[2].ToString();
                    txtSoyad.Text = veriler[3].ToString();
                    txtTelefon.Text = veriler[4].ToString();
                    txtEposta.Text = veriler[5].ToString();
                    txtAdres.Text = veriler[6].ToString();
                    txtMaas.Text = veriler[8].ToString();

                    islemler.CBSec(comboBox1, "departman", Convert.ToInt32(veriler[7]));

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
            int departmanId = islemler.GetirId("departman", comboBox1.SelectedIndex);
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "tcno",txtTcno.Text
                },
                   new ArrayList(){
                    "ad",txtAd.Text
                },
                      new ArrayList(){
                    "soyad",txtSoyad.Text
                },

               new ArrayList(){
                    "telefon",txtTelefon.Text
                },

               new ArrayList(){
                    "eposta",txtEposta.Text
                },
               new ArrayList(){
                    "adres",txtAdres.Text
                },
                new ArrayList(){
                    "maas",Convert.ToInt32(txtMaas.Text)
                },
                new ArrayList(){
                    "departmanId",departmanId
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
