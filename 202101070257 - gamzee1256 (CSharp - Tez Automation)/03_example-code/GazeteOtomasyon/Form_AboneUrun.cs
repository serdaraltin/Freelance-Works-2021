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
    public partial class Form_AboneUrun : Form
    {
        int Id = 0;
        public Form_AboneUrun()
        {
            InitializeComponent();
        }
        public Form_AboneUrun(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "tbl_aboneUrun";
        List<string> Liste = new List<string>();
        List<string> Liste2 = new List<string>();
        private void Form_Personel_Load(object sender, EventArgs e)
        {
            cb_Durum.SelectedIndex = 0;

            islemler.CBDoldur(cb_Abone, "tbl_abone", new int[] { 3, 4});
            Liste = islemler.Donustur(islemler.Kayitlar("tbl_abone"), 0);

            islemler.CBDoldur(cb_Urun, "tbl_urun",2);
            Liste2 = islemler.Donustur(islemler.Kayitlar("tbl_urun"), 0);

            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);
                    islemler.CBSec(cb_Abone, Liste, Convert.ToInt32(veriler[1]));
                    islemler.CBSec(cb_Urun, Liste2, Convert.ToInt32(veriler[2]));
                    dt_BaslangicTarih.Text = veriler[3].ToString();
                    dt_BitisTarih.Text = veriler[4].ToString();
                    cb_Durum.Text = veriler[5].ToString();

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
            int UrunId = Convert.ToInt32(Liste2[cb_Urun.SelectedIndex]);
            int AboneId = Convert.ToInt32(Liste[cb_Abone.SelectedIndex]);


            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){"AboneId",AboneId},
                new ArrayList(){"UrunId",UrunId},
                new ArrayList(){"BaslangicTarih",dt_BaslangicTarih.Value},
                new ArrayList(){"BitisTarih",dt_BitisTarih.Value},
                new ArrayList(){"Durum",cb_Durum.Text},
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
