using System;
using System.Data;
using System.Windows.Forms;

namespace Project
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
    
        public void Listele()
        {

            DataSet ds = islemler.Kayitlar(tablo);

            dg_veriler.DataSource = ds.Tables[0];
        }
        private void Islem_Load(object sender, EventArgs e)
        {

            Text += " [" + tablo.ToUpper() + "]";
            Listele();
        }

        private void btn_Sil_Click(object sender, EventArgs e)
        {
            if (Id == 0)
                islemler.MesajKutu(2, "seçim yapınız");
            if (islemler.Sil(tablo, Id))
            {
                islemler.MesajKutu("silme");
                Listele();
            }
            else
                islemler.MesajKutu(1, "silme");
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
            btn_Guncelle.PerformClick();
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
            switch (tablo)
            {

                case "hasta":
                    new Form_Hasta().ShowDialog();
                    break;
                case "hesap":
                    new Form_Hesap().ShowDialog();
                    break;
                case "ilac":
                    new Form_Ilac().ShowDialog();
                    break;
                case "operasyon":
                    new Form_Operasyon().ShowDialog();
                    break;
                case "personel":
                    new Form_Personel().ShowDialog();
                    break;
                case "randevu":
                    new Form_Randevu().ShowDialog();
                    break;
                case "sahip":
                    new Form_Sahip().ShowDialog();
                    break;
                case "tedarikci":
                    new Form_Tedarikci().ShowDialog();
                    break;
                case "kullanici":
                    new Form_Kullanici().ShowDialog();
                    break;
            }
           
        }

        private void btn_Guncelle_Click(object sender, EventArgs e)
        {
            switch (tablo)
            {
                case "hasta":
                    new Form_Hasta(Id).ShowDialog();
                    break;
                case "hesap":
                    new Form_Hesap(Id).ShowDialog();
                    break;
                case "ilac":
                    new Form_Ilac(Id).ShowDialog();
                    break;
                case "operasyon":
                    new Form_Operasyon(Id).ShowDialog();
                    break;
                case "personel":
                    new Form_Personel(Id).ShowDialog();
                    break;
                case "randevu":
                    new Form_Randevu(Id).ShowDialog();
                    break;
                case "sahip":
                    new Form_Sahip(Id).ShowDialog();
                    break;
                case "tedarikci":
                    new Form_Tedarikci(Id).ShowDialog();
                    break;
                case "kullanici":
                    new Form_Kullanici(Id).ShowDialog();
                    break;
            }
        
        }

        private void btnDetayliAra_Click(object sender, EventArgs e)
        {

        }
    }
}
