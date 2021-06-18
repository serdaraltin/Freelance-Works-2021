using System;
using System.Collections;
using System.Windows.Forms;

namespace Syllabus
{
    public partial class Form_Syllabus : Form
    {
        Class_Islemler islemler = new Class_Islemler();
        string tablo = "syllabus";
        int Id = 0;
        string[] veriler = null;
        public Form_Syllabus()
        {
            InitializeComponent();
        }
        public Form_Syllabus(string[] _veriler)
        {
            InitializeComponent();
            veriler = _veriler;
        }
        public Form_Syllabus(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Personel_Load(object sender, EventArgs e)
        {
            if(veriler != null)
            {
                Text = "AÇ";
                txtCode.Text = veriler[0];
                txtFall.Text = veriler[1];
                txtSpring.Text = veriler[2];
                txtTheory.Text = veriler[3];
                txtLab.Text = veriler[4];
                txtECTS.Text = veriler[6];
                ndCredit.Value = Convert.ToInt32(veriler[5]);
                btn_Ekle.Visible = false;
                btn_Sil.Visible = false;
                foreach(Control item in Controls)
                {
                    if(item is TextBox)
                    {
                        ((TextBox)item).ReadOnly = true;
                    }
                }
                ndCredit.ReadOnly = true;
                return;
            }
            if (Id != 0)
            {
                try
                {
                    ArrayList veriler = islemler.Getir(tablo, Id);

                    txtCode.Text = veriler[1].ToString();
                    txtFall.Text = veriler[2].ToString();
                    txtSpring.Text = veriler[3].ToString();
                    txtTheory.Text = veriler[4].ToString();
                    txtLab.Text = veriler[5].ToString();
                    txtECTS.Text = veriler[7].ToString();
                    ndCredit.Value = Convert.ToInt32(veriler[6].ToString());
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
                    "code",txtCode.Text
                },
                new ArrayList(){
                    "fall",txtFall.Text
                },
                 new ArrayList(){
                    "spring",txtSpring.Text
                },
                  new ArrayList(){
                    "theory",txtTheory.Text
                },
                   new ArrayList(){
                    "lab",txtLab.Text
                },
                    new ArrayList(){
                    "credit",Convert.ToInt32(ndCredit.Value)
                },
                     new ArrayList(){
                    "ects",txtECTS.Text
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
