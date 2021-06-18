using System;
using System.Drawing;
using System.Windows.Forms;

namespace StockAutomation
{
    public partial class Form_MainPage : Form
    {
        public Form_MainPage()
        {
            InitializeComponent();
        }
        DBOperation operation = new DBOperation();
        Form form = null;
        private void Form_Anasayfa_Load(object sender, EventArgs e)
        {
            if(operation.ConnectionTest())
            {
                stlbStatus.Text = "Connection : OK";
                stlbStatus.ForeColor = Color.LimeGreen;
            }
            else
            {
                stlbStatus.Text = "Connection : Failed";
                stlbStatus.ForeColor = Color.PaleVioletRed;
            }
          
        }
        
        private void hakkındaToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void btnProduct_Click(object sender, EventArgs e)
        {
            form = new Form_Operation("product");
            form.ShowDialog();
        }

        private void btnStock_Click(object sender, EventArgs e)
        {
            form = new Form_Operation("stock");
            form.ShowDialog();
        }

        private void btnSales_Click(object sender, EventArgs e)
        {
            form = new Form_Operation("sales");
            form.ShowDialog();
        }

        private void btnCategory_Click(object sender, EventArgs e)
        {
            form = new Form_Operation("category");
            form.ShowDialog();
        }

        private void btnBrand_Click(object sender, EventArgs e)
        {
            form = new Form_Operation("brand");
            form.ShowDialog();
        }

        private void btnDatabase_Click(object sender, EventArgs e)
        {
            form = new Form_DBConnection();
            form.ShowDialog();
        }

        private void msAbout_Click(object sender, EventArgs e)
        {
            form = new Form_About();
            form.ShowDialog();
        }

        private void tsConnectionTest_Click(object sender, EventArgs e)
        {
            if (operation.ConnectionTest())
                MessageBox.Show("Connection test successfull", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            else
                MessageBox.Show("Connection test failed", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        private void tsRestart_Click(object sender, EventArgs e)
        {
            Application.Restart();
        }

        private void tsClose_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
