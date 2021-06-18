using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace GazeteOtomasyon
{
    public partial class Form_Islem : Form
    {
        string tablo;
        public Form_Islem()
        {
            InitializeComponent();
        }
        public Form_Islem(string _tablo)
        {
            InitializeComponent();
            tablo = _tablo;
        }

        Class_Islemler islemler = new Class_Islemler();
        int Id = 0;
        Form form = null;
        public void Listele()
        {
            dg_veriler.DataSource = islemler.Kayitlar(tablo).Tables[0];
        }
        private void Islem_Load(object sender, EventArgs e)
        {
            Listele(); 
        }

        private void btn_Sil_Click(object sender, EventArgs e)
        {
            if (Id == 0)
                islemler.MesajKutu(2,"seçim yapınız");
            if (islemler.Sil(tablo, Id))
            {
                islemler.MesajKutu("silme");
                Listele();
            }
            else
                islemler.MesajKutu(1,"silme");
        }

        private void dg_veriler_RowEnter(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                Id = Convert.ToInt32(dg_veriler.Rows[e.RowIndex].Cells[0].Value);
            }
            catch { }
        }

        private void dg_veriler_DoubleClick(object sender, EventArgs e)
        {
 
            switch (tablo.Substring(4))
            {
                case "abone":
                    form = new Form_Abone(Id);
                    break;
                case "aboneUrun":
                    form = new Form_AboneUrun(Id);
                    break;
                case "firma":
                    form = new Form_Firma(Id);
                    break;
                case "personel":
                    form = new Form_Personel(Id);
                    break;
                case "stok":
                    form = new Form_Stok(Id);
                    break;
                case "teslimat":
                    form = new Form_Teslimat(Id);
                    break;
                case "urun":
                    form = new Form_Urun(Id);
                    break;
                
            }
            form.ShowDialog();       
        }

        private void btn_Kapat_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btn_Yenile_Click(object sender, EventArgs e)
        {
            Listele();
        }

        private void btn_Ekle_Click(object sender, EventArgs e)
        {
            switch (tablo.Substring(4))
            {
                case "abone":
                    form = new Form_Abone();
                    break;
                case "aboneUrun":
                    form = new Form_AboneUrun();
                    break;
                case "firma":
                    form = new Form_Firma();
                    break;
                case "personel":
                    form = new Form_Personel();
                    break;
                case "stok":
                    form = new Form_Stok();
                    break;
                case "teslimat":
                    form = new Form_Teslimat();
                    break;
                case "urun":
                    form = new Form_Urun();
                    break;

            }
            form.ShowDialog();
        }


        private void btn_Guncelle_Click(object sender, EventArgs e)
        {

            switch (tablo.Substring(4))
            {
                case "abone":
                    form = new Form_Abone(Id);
                    break;
                case "aboneUrun":
                    form = new Form_AboneUrun(Id);
                    break;
                case "firma":
                    form = new Form_Firma(Id);
                    break;
                case "personel":
                    form = new Form_Personel(Id);
                    break;
                case "stok":
                    form = new Form_Stok(Id);
                    break;
                case "teslimat":
                    form = new Form_Teslimat(Id);
                    break;
                case "urun":
                    form = new Form_Urun(Id);
                    break;

            }
            form.ShowDialog();
        }
    }
}
