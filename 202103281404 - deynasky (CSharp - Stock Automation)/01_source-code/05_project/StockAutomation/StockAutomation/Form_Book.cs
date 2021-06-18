using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Book : Form
    {
        DBOperation operations = new DBOperation();
        string tableName;
        int Id = 0;
        public Form_Book()
        {
            InitializeComponent();
            cbType.SelectedIndex = 0;
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
        }
        public Form_Book(int _Id)
        {
            InitializeComponent();
            Id = _Id;
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();

            ArrayList data = operations.GetReg(tableName, Id);

            txtName.Text = data[1].ToString();
            cbType.Text = data[2].ToString();
            dtRelease.Text = data[3].ToString();
            txtPageNum.Text = data[4].ToString();
            txtPrice.Text = data[5].ToString();
            

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
                new ArrayList(){ "name",txtName.Text },
                new ArrayList(){ "type",cbType.Text },
                new ArrayList(){ "releaseDate",dtRelease.Value},
                new ArrayList(){ "pageNum",txtPageNum.Text},
                new ArrayList(){ "price",txtPrice.Text},
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
