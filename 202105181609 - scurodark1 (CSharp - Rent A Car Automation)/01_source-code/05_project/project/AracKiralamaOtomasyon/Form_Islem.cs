using System;
using System.Data;
using System.Windows.Forms;

namespace AracKiralamaOtomasyon
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
                case "kullanici":
                    form = new Form_Kullanici();
                    break;
                case "arac":
                    form = new Form_Arac();
                    break;
                case "musteri":
                    form = new Form_Musteri();
                    break;
                case "kiralama":
                    form = new Form_Kiralama();
                    break;
            }
            form.ShowDialog();
        }

        private void btn_Guncelle_Click(object sender, EventArgs e)
        {
            switch (tablo)
            {
                case "kullanici":
                    form = new Form_Kullanici(Id);
                    break;
                case "arac":
                    form = new Form_Arac(Id);
                    break;
                case "musteri":
                    form = new Form_Musteri(Id);
                    break;
                case "kiralama":
                    form = new Form_Kiralama(Id);
                    break;
            }
            form.ShowDialog();
        }

        private void btnDetayliAra_Click(object sender, EventArgs e)
        {

        }
    }
}
