using System;
using System.Collections;
using System.Windows.Forms;

namespace AracKiralamaOtomasyon
{
    public partial class Form_Arac : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "arac";
        int Id = 0;
        public Form_Arac()
        {
            InitializeComponent();
        }
        public Form_Arac(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            for (int i = 2021; i > 1920; i--)
            {
                cbYil.Items.Add(i.ToString());
            }
            cbYil.SelectedIndex = cbRenk.SelectedIndex = 0;
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    txtMarka.Text = veriler[1].ToString();
                    txtModel.Text = veriler[2].ToString();
                    cbYil.Text = veriler[3].ToString();
                    cbRenk.Text = veriler[4].ToString();
                    txtFiyat.Text = veriler[5].ToString();

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
                new ArrayList(){
                    "marka",txtMarka.Text
                },
                new ArrayList(){
                    "model",txtModel.Text
                },
                 new ArrayList(){
                    "yil",cbYil.Text
                },
                  new ArrayList(){
                    "renk",cbRenk.Text
                },
                   new ArrayList(){
                    "fiyat",float.Parse(txtFiyat.Text)
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

        private void cbYil_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }
    }
}
