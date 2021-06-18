using System;
using System.Collections;
using System.Data;
using System.IO;
using System.Windows.Forms;

namespace Syllabus
{
    public partial class Form_Islem : Form
    {
        string tablo = "syllabus";
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

            form = new Form_Syllabus();
            form.ShowDialog();
        }

        private void btn_Guncelle_Click(object sender, EventArgs e)
        {
            form = new Form_Syllabus(Id);
            form.ShowDialog();
        }

        private void btnDetayliAra_Click(object sender, EventArgs e)
        {

        }

        private void yenidenBaşlatToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Restart();
        }

        private void kapatToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void kontrolToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form_VeritabaniBaglanti().ShowDialog();
        }

        private void hakkındaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form_Hakkinda().ShowDialog();
        }

        private void yeniOluşturToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form_Syllabus().ShowDialog();
        }

        private void btnAra_Click(object sender, EventArgs e)
        {
            if (txtAra.Text == "")
            {
                Listele();
                return;
            }
            dg_veriler.DataSource = islemler.Kayitlar(tablo, txtAra.Text).Tables[0];
        }

        private void htmlOluşturToolStripMenuItem_Click(object sender, EventArgs e)
        {

            string html = "<table cellpadding='5' cellspacing='0' style='border: 1px solid #ccc;font-size: 9pt;font-family:arial'>";


            html += "<tr>";
            foreach (DataGridViewColumn column in dg_veriler.Columns)
            {
                html += "<th style='background-color: #B8DBFD;border: 1px solid #ccc'>" + column.HeaderText + "</th>";
            }
            html += "</tr>";

            int columCount = dg_veriler.ColumnCount;

            for (int i = 0; i < dg_veriler.RowCount; i++)
            {
                if (dg_veriler.Rows[i].Cells[0].Value == null)
                {
                    break;
                }
                html += "<tr>";
                for (int j = 0; j < columCount; j++)
                {

                    html += "<td style='width:120px;border: 1px solid #ccc'>" + dg_veriler.Rows[i].Cells[j].Value.ToString() + "</td>";
                }
                html += "</tr>";
            }


            html += "</table>";

            SaveFileDialog save = new SaveFileDialog();
            save.Title = "Html Oluştur";
            save.FileName = "veriler.html";
            save.Filter = "Html dosyaları | *.html";
            if (save.ShowDialog() == DialogResult.OK)
            {
                File.WriteAllText(save.FileName, html);
                MessageBox.Show("Html dosyası oluşturuldu.", "Başarılı", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

        }

        private void dışaAktarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (Id == 0)
            {
                MessageBox.Show("Bir kayıt seçiniz !");
                return;
            }
            ArrayList veriler = islemler.Getir(tablo, Id);
            string veri = "";
            for (int i = 1; i < veriler.Count; i++)
            {
                veri += veriler[i].ToString();
                if (i < veriler.Count - 1)
                    veri += "\n";
            }


            SaveFileDialog save = new SaveFileDialog();
            save.Title = "Dışa Aktar";
            save.FileName = "veriler.sys";
            save.Filter = "Kayıt dosyaları | *.sys";
            if (save.ShowDialog() == DialogResult.OK)
            {
                File.WriteAllText(save.FileName, veri);
                MessageBox.Show(veri);
                MessageBox.Show("Sys dosyası oluşturuldu.", "Başarılı", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

        private void içeAktarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog open = new OpenFileDialog();
            open.Title = "İçe Aktar";
            open.Filter = "Kayıt dosyaları | *.sys";
            if (open.ShowDialog() == DialogResult.OK)
            {
                string[] veriler = File.ReadAllLines(open.FileName);

                if (islemler.Kontrol(tablo, veriler[0]))
                {
                    MessageBox.Show(veriler[0] + " aynı koda sahip kayıt mevcut !");
                    return;
                }
                ArrayList kayit = new ArrayList()
            {
                new ArrayList(){
                    "code",veriler[0]
                },
                new ArrayList(){
                    "fall",veriler[1]
                },
                 new ArrayList(){
                    "spring",veriler[2]
                },
                  new ArrayList(){
                    "theory",veriler[3]
                },
                   new ArrayList(){
                    "lab",veriler[4]
                },
                    new ArrayList(){
                    "credit",Convert.ToInt32(veriler[5])
                },
                     new ArrayList(){
                    "ects",veriler[6]
                },

            };
                if (islemler.Ekle(tablo, kayit))
                    islemler.MesajKutu("içe aktrarma");
                Listele();
            }
        }

        private void açToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog open = new OpenFileDialog();
            open.Title = "İçe Aktar";
            open.Filter = "Kayıt dosyaları | *.sys";
            if (open.ShowDialog() == DialogResult.OK)
            {
                string[] veriler = File.ReadAllLines(open.FileName);

                Form syllabus = new Form_Syllabus(veriler);
                syllabus.ShowDialog();
         
            }
        }
    }
}
