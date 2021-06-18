using System;
using System.Collections;
using System.Windows.Forms;

namespace CafeOtomasyon
{
    public partial class Form_Siparis : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "siparis";
        int Id = 0;
        public Form_Siparis()
        {
            InitializeComponent();
        }
        public Form_Siparis(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {

            islemler.CBDoldur(cbMasa, "masa", 1);
            islemler.CBDoldur(cbPersonel, "personel", new int[] { 2, 3, 1 });

            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);
                    islemler.CBSec(cbMasa, "masa", Convert.ToInt32(veriler[1]));
                    islemler.CBSec(cbPersonel, "personel", Convert.ToInt32(veriler[2]));

                    txtSiparisler.Text = veriler[3].ToString();
                    txtTutar.Text = veriler[4].ToString();
                    txtTarih.Text = veriler[5].ToString();


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
            int masaId = islemler.GetirId("masa", cbMasa.SelectedIndex);
            int personelId = islemler.GetirId("personel", cbPersonel.SelectedIndex);

            ArrayList kayit = new ArrayList()
            {
                   new ArrayList(){
                    "masaId",masaId
                },
                      new ArrayList(){
                    "personelId",personelId
                },
                 new ArrayList(){
                    "siparisler",txtSiparisler.Text
                },
                  new ArrayList(){
                    "tutar",Convert.ToInt32(txtTutar.Text)
                },

                new ArrayList(){
                    "tarih",txtTarih.Text
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
