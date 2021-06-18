using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace GTS_Project
{
    public partial class Form_TezAra : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "tbl_tez";
        DataGridView dg_veriler;
        public Form_TezAra()
        {
            InitializeComponent();
        }
        public Form_TezAra(DataGridView _dg_veriler)
        {
            InitializeComponent();
            dg_veriler = _dg_veriler;
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
        }

        private void cbUniversite_SelectedIndexChanged(object sender, EventArgs e)
        {
            int universite_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_universite"), 0)[cbUniversite.SelectedIndex]);
            islemler.CBDoldur(cbEnstitu, "tbl_enstitu", 2, 1, universite_Id);

        }

        private void btn_Ara_Click(object sender, EventArgs e)
        {
            int yazar_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_yazar"), 0)[cbYazar.SelectedIndex]);
            int danisman_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_danisman"), 0)[cbDanisman.SelectedIndex]);
            int universite_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_universite"), 0)[cbUniversite.SelectedIndex]);
            int enstitu_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_enstitu"), 0)[cbEnstitu.SelectedIndex]);
            int baslik_Id = Convert.ToInt32(islemler.Donustur(islemler.Kayitlar("tbl_baslik"), 0)[cbBaslik.SelectedIndex]);
            int yil = Convert.ToInt32(cbYil.Text);
            int sayfa_sayisi = Convert.ToInt32(ndSayfa.Value);
            DateTime teslim_tarihi = dtTeslimTarih.Value;

            int sorguAdet = -1;
            string sorgu = "Select * From tbl_tez Where ";

            foreach (Control item in this.Controls)
            {
                if (item is CheckBox)
                {
                    if (((CheckBox)item).Checked)
                        sorguAdet++;
                }
            }


            if (chYazar.Checked)
            {
                sorgu += "yazar_Id=" + yazar_Id + " ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chDanisman.Checked)
            {
                sorgu += "danisman_Id=" + danisman_Id + " ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chUniversite.Checked)
            {
                sorgu += "universite_Id=" + universite_Id + " ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chEnstitu.Checked)
            {
                sorgu += "enstitu_Id=" + enstitu_Id + " ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chBaslik.Checked)
            {
                sorgu += "baslik_Id=" + baslik_Id + " ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chYil.Checked)
            {
                sorgu += "yil=" + yil + " ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chSayfa.Checked)
            {
                sorgu += "sayfa_sayisi=" + sayfa_sayisi + " ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chTeslimTarihi.Checked)
            {
                sorgu += "teslim_tarihi=" + teslim_tarihi + " ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chDil.Checked)
            {
                sorgu += "dil='" + cbDil.Text + "' ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chTur.Checked)
            {
                sorgu += "tur='" + cbTur.Text + "' ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chAnahtar.Checked)
            {
                sorgu += "anahtar_kelime LIKE '%" + txtAnahtarKelime.Text + "%' ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            if (chOzet.Checked)
            {
                sorgu += "ozet LIKE '%" + txtOzet.Text + "%' ";
                if (sorguAdet-- > 0)
                    sorgu += "or ";
            }

            SqlConnection baglanti = new SqlConnection("Data Source = " + Ayarlar.Default.Sunucu + ", 1433; Network Library = DBMSSOCN; Initial Catalog = " + Ayarlar.Default.Veritabani + "; User ID = " + Ayarlar.Default.Kullanici + "; Password = " + Ayarlar.Default.Parola + ";");

            baglanti.Open();
            SqlCommand komut = new SqlCommand(sorgu, baglanti);
            SqlDataAdapter da = new SqlDataAdapter(komut);
            DataSet ds = new DataSet();
            da.Fill(ds);
            komut.Dispose();
            baglanti.Close();

            dg_veriler.DataSource = ds.Tables[0];
        }
    }
}
