using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Operasyon : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "operasyon";
        int Id = 0;
        int mevcutUcret = 0;
        public Form_Operasyon()
        {
            InitializeComponent();
            islemler.CBDoldur(cbHasta, "hasta", new int[] { 1, 2, 3 });
            islemler.CBDoldur(cbIlac, "ilac", new int[] { 1, 2 });
            cbSonuc.SelectedIndex = 0;
        }
        public Form_Operasyon(int _Id)
        {
            InitializeComponent();
            Id = _Id;

            islemler.CBDoldur(cbHasta, "hasta", new int[] { 1, 2, 3 });
            islemler.CBDoldur(cbIlac, "ilac", new int[] { 1, 2 });
            cbSonuc.SelectedIndex = 0;

            ArrayList veriler = islemler.Getir(tablo, Id);

            islemler.CBSec(cbHasta, "hasta", Convert.ToInt32(veriler[1]));
            txtAciklama.Text = veriler[2].ToString();
            txtTeshis.Text = veriler[3].ToString();
            islemler.CBSec(cbIlac, "ilac", Convert.ToInt32(veriler[4]));
            cbSonuc.Text = veriler[5].ToString();
            dtTarih.Text = veriler[6].ToString();
            txtUcret.Text = veriler[7].ToString();
            mevcutUcret = Convert.ToInt32(veriler[7].ToString());

            this.Text += " Güncelle";
            btn_Ekle.Text = "Güncelle";
            btn_Sil.Visible = true;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {

        }

        private void btn_Sil_Click(object sender, EventArgs e)
        {
            islemler.Sil(this, tablo, Id);
        }

        private void btn_Ekle_Click_1(object sender, EventArgs e)
        {

            if (txtUcret.Text == "")
                txtUcret.Text = "0";
            int hastaId = islemler.GetirId("hasta", cbHasta.SelectedIndex);
            int ilacId = islemler.GetirId("ilac", cbIlac.SelectedIndex);


            int sahipId = Convert.ToInt32(islemler.Getir("hasta", hastaId)[1]);
            int hesapId = Convert.ToInt32(islemler.Getir("sahip", sahipId)[1]);

            int toplamUcret = Convert.ToInt32(islemler.Getir("hesap", hesapId)[2]);
            string hesapTarih = islemler.Getir("hesap", hesapId)[1].ToString();

            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "hastaId",hastaId
                },
                new ArrayList(){
                    "aciklama",txtAciklama.Text
                },
                  new ArrayList(){
                    "teshis",txtTeshis.Text
                },

                     new ArrayList(){
                    "ilacId",ilacId
                },
                        new ArrayList(){
                    "sonuc",cbSonuc.Text
                },
                           new ArrayList(){
                    "tarih",dtTarih.Value.ToString()
                },
                                   new ArrayList(){
                    "ucret",txtUcret.Text
                },
            };
            ArrayList hesapKayit = new ArrayList()
            {
                new ArrayList() { "Id", hesapId },
                new ArrayList(){
                    "tarih",hesapTarih
                },

            };
            if (Id != 0)
            {
                kayit.Add(new ArrayList() { "Id", Id });
                if (islemler.Guncelle(tablo, kayit))
                {
                    toplamUcret -= mevcutUcret;
                    toplamUcret += Convert.ToInt32(txtUcret.Text);
                    hesapKayit.Add(new ArrayList() { "toplam", toplamUcret });

                    islemler.Guncelle("hesap", hesapKayit);
                    islemler.MesajKutu(tablo + " güncelleme");
                }
                else
                {
                    islemler.MesajKutu(2, tablo + " güncelleme");
                    return;
                }
                return;
            }
            if (islemler.Ekle(tablo, kayit))
            {
                toplamUcret += Convert.ToInt32(txtUcret.Text);
                hesapKayit.Add(new ArrayList() { "toplam", toplamUcret });
                islemler.Guncelle("hesap", hesapKayit);
                islemler.MesajKutu(tablo + " ekleme");
            }
            else
            {
                islemler.MesajKutu(2, tablo + " ekleme");
            }
            islemler.Temizle(this);
        }
    }

}
