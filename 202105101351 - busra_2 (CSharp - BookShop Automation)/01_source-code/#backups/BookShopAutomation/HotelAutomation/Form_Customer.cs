using System;
using System.Collections;
using System.Windows.Forms;

namespace BookShopAutomation
{
    public partial class Form_Customer : Form
    {
        DBOperation operations = new DBOperation();
        string tableName;
        int Id = 0;
        public Form_Customer()
        {
            InitializeComponent();
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
        }
        public Form_Customer(int _Id)
        {
            InitializeComponent();
            Id = _Id;
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
            ArrayList data = operations.GetReg(tableName, Id);

            txtSecNum.Text = data[1].ToString();
            txtName.Text = data[2].ToString();
            txtSurname.Text = data[3].ToString();
            cbSex.Text = data[4].ToString();
            txtPhone.Text = data[5].ToString();
            txtEmail.Text = data[6].ToString();
            txtAddress.Text = data[7].ToString();

            btnAdd.Text = "UPDATE";
            btnDelete.Visible = true;
        }

        private void Form_Load(object sender, EventArgs e)
        {
           
            Text = this.Name.Substring(this.Name.IndexOf("_") + 1);

            cbSex.SelectedIndex = 0;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {

            ArrayList newReg = new ArrayList()
            {
                new ArrayList(){ "secnum",txtSecNum.Text },
                new ArrayList(){ "name",txtName.Text },
                new ArrayList(){ "surname",txtSurname.Text},
                new ArrayList(){ "sex",cbSex.Text },
                new ArrayList(){ "phone",txtPhone.Text },
                new ArrayList(){ "email",txtEmail.Text },
                new ArrayList(){ "address",txtAddress.Text},
            };

            if (Id != 0)
            {
                newReg.Add(new ArrayList() { "Id", Id });
                if (operations.Update(tableName, newReg))
                    operations.MsgBox(tableName + " update");
                else
                    operations.MsgBox(2, tableName + " update");
                return;
            }
            if (operations.Add(tableName, newReg))
                operations.MsgBox(tableName + " add");
            else
                operations.MsgBox(2, tableName + " add");
            operations.ClearData(this);
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            operations.Delete(this, tableName, Id);
        }
    }
}
