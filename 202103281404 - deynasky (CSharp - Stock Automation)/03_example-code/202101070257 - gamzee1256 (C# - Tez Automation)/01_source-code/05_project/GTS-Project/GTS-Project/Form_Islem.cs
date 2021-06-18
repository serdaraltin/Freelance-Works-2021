using System;
using System.Data;
using System.Windows.Forms;

namespace GTS_Project
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

           /* DataRowCollection itemCol = ds.Tables[0].Rows;
            itemCol[1].Delete();
            ds.Tables[0].AcceptChanges();

            ds.Tables[0].Columns[1].DataType = typeof(string);
            ds.Tables[0].AcceptChanges();
            foreach (DataRow row in ds.Tables[0].Rows)
            {
                row[1] = "deneme";
            }

            ds.Tables[0].AcceptChanges();*/
            dg_veriler.DataSource = ds.Tables[0];
        }
        private void Islem_Load(object sender, EventArgs e)
        {
            if (tablo == "tbl_tez")
                btnDetayliAra.Visible = true;
            Text += " ["+tablo.Substring(4).ToUpper()+"]";
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
           switch (tablo.Substring(4))
          {
              case "tez":
                  form = new Form_Tez();
                  break;
              case "yazar":
                  form = new Form_Yazar();
                  break;
              case "danisman":
                  form = new Form_Danisman();
                  break;
              case "universite":
                  form = new Form_Universite();
                  break;
              case "enstitu":
                  form = new Form_Enstitu();
                  break;
              case "baslik":
                  form = new Form_Baslik();
                  break;
          }
            form.ShowDialog();
        }

        private void btn_Guncelle_Click(object sender, EventArgs e)
        {
            switch (tablo.Substring(4))
            {
                case "tez":
                    form = new Form_Tez(Id);
                    break;
                case "yazar":
                    form = new Form_Yazar(Id);
                    break;
                case "danisman":
                    form = new Form_Danisman(Id);
                    break;
                case "universite":
                    form = new Form_Universite(Id);
                    break;
                case "enstitu":
                    form = new Form_Enstitu(Id);
                    break;
                case "baslik":
                    form = new Form_Baslik(Id);
                    break;
            }
            form.ShowDialog();
        }

        private void btnDetayliAra_Click(object sender, EventArgs e)
        {
            Form ara = new Form_TezAra(dg_veriler);
            ara.Show();
        }
    }
}
