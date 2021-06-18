using System;
using System.Collections;
using System.Windows.Forms;

namespace HotelAutomation
{
    public partial class Form_Employees : Form
    {
        DBOperation operations = new DBOperation();
        string tableName;
        int Id = 0;
        public Form_Employees()
        {
            InitializeComponent();
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
        }
        public Form_Employees(int _Id)
        {
            InitializeComponent();
            Id = _Id;
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
            ArrayList data = operations.GetReg(tableName, Id);

            txtSecNum.Text = data[1].ToString();
            txtName.Text = data[2].ToString();
            txtSurname.Text = data[3].ToString();
            txtPhone.Text = data[4].ToString();
            txtEmail.Text = data[5].ToString();
            txtAddress.Text = data[6].ToString();
            txtSalary.Text = data[7].ToString();

            btnAdd.Text = "UPDATE";
            btnDelete.Visible = true;
        }

        private void Form_Load(object sender, EventArgs e)
        {  
            Text = this.Name.Substring(this.Name.IndexOf("_") + 1);

        }

        private void btnAdd_Click(object sender, EventArgs e)
        {

            ArrayList newReg = new ArrayList()
            {
                new ArrayList(){ "secnum",txtSecNum.Text },
                new ArrayList(){ "name",txtName.Text },
                new ArrayList(){ "surname",txtSurname.Text},
                new ArrayList(){ "phone",txtPhone.Text },
                new ArrayList(){ "email",txtEmail.Text },
                new ArrayList(){ "address",txtAddress.Text},
                 new ArrayList(){ "salary",txtSalary.Text},
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
