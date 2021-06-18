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
    public partial class Form_Teslimat : Form
    {
        int Id = 2;
        public Form_Teslimat()
        {
            InitializeComponent();
        }
        public Form_Teslimat(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "tbl_teslimat";
        List<string> Liste = new List<string>();
        List<string> Liste2 = new List<string>();
        int aboneId = 0, urunId = 0;
        private void Form_Personel_Load(object sender, EventArgs e)
        {
            dg_AboneUrun.DataSource = islemler.Kayitlar("tbl_aboneUrun").Tables[0];

            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    dg_AboneUrun.Enabled = false;
                    dg_AboneUrun.Visible = false;
                    txt_Abone.Clear();
                    txt_Urun.Clear();
                    int AboneUrunId = Convert.ToInt32(veriler[1]);

                    int _aboneId = Convert.ToInt32(islemler.Getir("tbl_aboneUrun", AboneUrunId)[1]);
                    int _urunId = Convert.ToInt32(islemler.Getir("tbl_aboneUrun", AboneUrunId)[2]);

                    txt_Abone.Text = islemler.Getir("tbl_abone", _aboneId)[3].ToString() + " " + islemler.Getir("tbl_abone", _aboneId)[4].ToString();
                    txt_Urun.Text = islemler.Getir("tbl_urun", _urunId)[2].ToString();

                    txt_Sayi.Text = veriler[2].ToString();
                    dt_TeslimatTarih.Text = veriler[3].ToString();
                    txt_Aciklama.Text = veriler[4].ToString();


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
                new ArrayList(){"AboneUrunId",1},
                new ArrayList(){"Sayi",Convert.ToInt32(txt_Sayi.Text)},
                new ArrayList(){"TeslimatTarih",dt_TeslimatTarih.Value},
                new ArrayList(){"Aciklama",txt_Aciklama.Text},
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

        private void cb_Abone_SelectedIndexChanged(object sender, EventArgs e)
        {
           
        }

        private void dg_AboneUrun_RowEnter(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                aboneId = Convert.ToInt32(dg_AboneUrun.Rows[e.RowIndex].Cells[1].Value);
                urunId = Convert.ToInt32(dg_AboneUrun.Rows[e.RowIndex].Cells[2].Value);

                txt_Abone.Text = islemler.Getir("tbl_abone", aboneId)[3].ToString() + " " + islemler.Getir("tbl_abone", aboneId)[4].ToString();
                txt_Urun.Text = islemler.Getir("tbl_urun", urunId)[2].ToString();
            }
            catch { }
        }
    }
}
