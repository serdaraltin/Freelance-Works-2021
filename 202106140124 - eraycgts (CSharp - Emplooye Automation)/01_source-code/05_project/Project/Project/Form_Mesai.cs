using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Mesai : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "mesai";
        int Id = 0;
        public Form_Mesai()
        {
            InitializeComponent();
        }
        public Form_Mesai(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            islemler.CBDoldur(cbPersonel, "personel", new int[] {1,2,3});
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    islemler.CBSec(cbPersonel, "personel", Convert.ToInt32(veriler[1]));
                    dtTarih.Text = veriler[2].ToString();
                    txtSure.Text = veriler[3].ToString();
                    txtUcret.Text = veriler[4].ToString();


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
            int personelId = islemler.GetirId("personel", cbPersonel.SelectedIndex);
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "personelId",personelId
                },
                new ArrayList(){
                    "tarih",dtTarih.Value.ToString()
                },
                 new ArrayList(){
                    "sure",txtSure.Text
                },
                  new ArrayList(){
                    "ucret",txtUcret.Text
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
