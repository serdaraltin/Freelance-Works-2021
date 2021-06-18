using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GazeteOtomasyon
{
    public partial class Form_Stok : Form
    {
        int Id =0;
        public Form_Stok()
        {
            InitializeComponent();
        }
        public Form_Stok(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "tbl_stok";
        List<string> Liste = new List<string>();
        private void Form_Personel_Load(object sender, EventArgs e)
        {
            islemler.CBDoldur(cb_Urun, "tbl_urun", 2);
            Liste = islemler.Donustur(islemler.Kayitlar("tbl_urun"), 0);

            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    islemler.CBSec(cb_Urun, Liste, Convert.ToInt32(veriler[1]));
                    txt_Adet.Text = veriler[2].ToString();
                    dt_EklenmeTarih.Text = veriler[3].ToString();

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
            int UrunId = Convert.ToInt32(Liste[cb_Urun.SelectedIndex]);
            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){"UrunID",UrunId},
                new ArrayList(){"Adet",Convert.ToInt32(txt_Adet.Text)},
                new ArrayList(){"EklemeTarih",dt_EklenmeTarih.Value},
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
