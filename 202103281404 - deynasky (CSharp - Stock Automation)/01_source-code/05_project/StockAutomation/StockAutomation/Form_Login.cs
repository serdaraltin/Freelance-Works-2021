using System;
using System.Collections;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace Project
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
                ArrayList userDate = operation.GetUser(txtUserName.Text, txtPassword.Text);
                int customerId = Convert.ToInt32(userDate[3]);
                if (customerId == 0)
                {
                    new Form_MainPage().Show();
                    this.Hide();
                    return;
                }
               
                new Form_OperationCustomer(customerId).Show();
                this.Hide();
            }
            else
            {
                MessageBox.Show("Username or password wrong !!!", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
           
          
        }

        private void btnRegister_Click(object sender, EventArgs e)
        {
            new Form_Customer().ShowDialog();
        }
    }
}
