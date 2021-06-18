using System;
using System.Drawing;
using System.Windows.Forms;

namespace HotelAutomation
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

        private void btn1_Click(object sender, EventArgs e)
        {
            new Form_Operation("customer").ShowDialog();
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            new Form_Operation("employees").ShowDialog();
        }

        private void btn3_Click(object sender, EventArgs e)
        {
            new Form_Operation("room").ShowDialog();
        }

        private void btn4_Click(object sender, EventArgs e)
        {
           new Form_Operation("rezarvation").ShowDialog();
        }

        private void btn5_Click(object sender, EventArgs e)
        {
            new Form_Operation("users").ShowDialog();
        }

        private void btn6_Click(object sender, EventArgs e)
        {
           new Form_DBConnection().ShowDialog();
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
