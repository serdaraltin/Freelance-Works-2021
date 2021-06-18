using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_Tez : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "tbl_tez";
        int Id = 0;
        public Form_Tez()
        {
            InitializeComponent();
        }
        public Form_Tez(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            islemler.CBDoldur(cbYazar, "tbl_yazar", new int[] { 1, 2 });
            islemler.CBDoldur(cbDanisman, "tbl_danisman", new int[] { 1, 2 });
            islemler.CBDoldur(cbUniversite, "tbl_universite", 1);
            islemler.CBDoldur(cbBaslik, "tbl_baslik", 1);
            cbTur.SelectedIndex = 0;
            cbDil.SelectedIndex = 0;

            for (int i = 2021; i >= 1950; i--)
            {
                cbYil.Items.Add(i.ToString());
            }
            cbYil.SelectedIndex = 0;
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    islemler.CBSec(cbYazar, islemler.Donustur(islemler.Kayitlar("tbl_yazar"), 0), Convert.ToInt32(veriler[1]));
                    islemler.CBSec(cbDanisman, islemler.Donustur(islemler.Kayitlar("tbl_danisman"), 0), Convert.ToInt32(veriler[2]));
                    islemler.CBSec(cbUniversite, islemler.Donustur(islemler.Kayitlar("tbl_universite"), 0), Convert.ToInt32(veriler[3]));
                    islemler.CBSec(cbEnstitu, islemler.Donustur(islemler.Kayitlar("tbl_enstitu"), 0), Convert.ToInt32(veriler[4]));
                    islemler.CBSec(cbBaslik, islemler.Donustur(islemler.Kayitlar("tbl_baslik"), 0), Convert.ToInt32(veriler[5]));
                    cbTur.Text = veriler[6].ToString();
                    txtOzet.Text = veriler[7].ToString();
                    cbDil.Text = veriler[8].ToString();
                    txtAnahtarKelime.Text = veriler[9].ToString();
                    cbYil.Text = veriler[10].ToString();
                    ndSayfa.Value = Convert.ToInt32(veriler[11]);
                    dtTeslimTarih.Value = (DateTime)veriler[12];
                  

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
            int yazar_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_yazar"), 0)[cbYazar.SelectedIndex]);
            int danisman_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_danisman"), 0)[cbDanisman.SelectedIndex]);
            int universite_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_universite"), 0)[cbUniversite.SelectedIndex]);
            int enstitu_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_enstitu"), 0)[cbEnstitu.SelectedIndex]);
            int baslik_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_baslik"), 0)[cbBaslik.SelectedIndex]);
            int yil = Convert.ToInt32(cbYil.Text);
            int sayfa_sayisi = Convert.ToInt32(ndSayfa.Value);
            DateTime teslim_tarihi = dtTeslimTarih.Value;

            ArrayList kayit = new ArrayList()
            {
                new ArrayList(){"yazar_Id",yazar_Id},
                new ArrayList(){ "danisman_Id", danisman_Id},
                new ArrayList(){ "universite_Id", universite_Id},
                new ArrayList(){ "enstitu_Id", enstitu_Id},
                new ArrayList(){ "baslik_Id", baslik_Id},
                new ArrayList(){"tur",cbTur.Text},
                new ArrayList(){"ozet",txtOzet.Text},
                new ArrayList(){"yil",yil},
                new ArrayList(){"dil",cbDil.Text},
                new ArrayList(){"sayfa_sayisi",sayfa_sayisi},
                new ArrayList(){"teslim_tarihi",teslim_tarihi},
                new ArrayList(){"anahtar_kelime",txtAnahtarKelime.Text},
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

        private void cbUniversite_SelectedIndexChanged(object sender, EventArgs e)
        {
            int universite_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_universite"), 0)[cbUniversite.SelectedIndex]);
            islemler.CBDoldur(cbEnstitu, "tbl_enstitu", 2, 1, universite_Id);

        }
    }
}
