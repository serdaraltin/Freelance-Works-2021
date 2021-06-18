using System;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace HotelAutomation
{
    public partial class Form_Login : Form
    {
        public Form_Login()
        {
            InitializeComponent();
        }

        DBOperation operation = new DBOperation();

        private void Form_Giris_Load(object sender, EventArgs e)
        {
            if (!operation.ConnectionTest() || (Setting.Default.Server == "" || Setting.Default.Database == ""))
            {
                Form form = new Form_DBConnection();
                form.ShowDialog();
            }
        }

        private void btnGiris_Click(object sender, EventArgs e)
        {
            if(txtUserName.Text == "" || txtPassword.Text == "")
            {
                //fill in the required fields
                MessageBox.Show("Fill in the required fields!!!", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (operation.UserControl(txtUserName.Text, txtPassword.Text))
            {
                Form form = new Form_MainPage();
                form.Show();
                this.Hide();
            }
            else
            {
                MessageBox.Show("Username or password wrong !!!", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
           
          
        }
    }
}
