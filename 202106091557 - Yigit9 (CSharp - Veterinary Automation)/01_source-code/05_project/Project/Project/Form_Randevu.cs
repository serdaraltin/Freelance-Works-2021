using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Randevu : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "randevu";
        int Id = 0;
        public Form_Randevu()
        {
            InitializeComponent();
            islemler.CBDoldur(cbHasta, "hasta", new int[] { 1, 2, 3 });
        }
        public Form_Randevu(int _Id)
        {
            InitializeComponent();
            islemler.CBDoldur(cbHasta, "hasta", new int[] { 1, 2, 3 });
            Id = _Id;
            ArrayList veriler = islemler.Getir(tablo, Id);

            islemler.CBSec(cbHasta, "hasta", Convert.ToInt32(veriler[1]));

            dtTarih.Text = veriler[2].ToString();


            this.Text += " Güncelle";
            btn_Ekle.Text = "Güncelle";
            btn_Sil.Visible = true;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
      
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            int hastaId = islemler.GetirId("hasta", cbHasta.SelectedIndex);
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "hastaId",hastaId
                },
                new ArrayList(){
                    "tarih",dtTarih.Value.ToString()
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
