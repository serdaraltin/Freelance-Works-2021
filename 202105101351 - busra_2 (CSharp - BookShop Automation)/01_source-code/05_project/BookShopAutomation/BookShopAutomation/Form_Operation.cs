using System;
using System.Data;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Operation : Form
    {
        string tableName;
        public Form_Operation()
        {
            InitializeComponent();
        }
        public Form_Operation(string _tblName)
        {
            InitializeComponent();
            tableName = _tblName;
        }

        DBOperation operation = new DBOperation();
        int Id = 0;
        public void List()
        {
            DataSet ds = operation.DataList(tableName);
            dgData.DataSource = ds.Tables[0];
        }

        private void dgData_RowEnter(object sender, DataGridViewCellEventArgs e)
        {
            try { Id = Convert.ToInt32(dgData.SelectedRows[0].Cells[0].Value); }
            catch { };
        }

        private void dgData_DoubleClick(object sender, EventArgs e)
        {
            btnUpdate.PerformClick();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (Id == 0)
                operation.MsgBox(2, "please choose");
            if (operation.Delete(tableName, Id))
            {
                operation.MsgBox("deletion");
                List();
            }
            else
                operation.MsgBox(1, "deletion");
        }

        private void Form_Operation_Load(object sender, EventArgs e)
        {
            List();
        }

        private void btnRefresh_Click(object sender, EventArgs e)
        {
            List();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            switch (tableName)
            {
                case "book":
                    new Form_Book().ShowDialog();
                    break;
                case "users":
                    new Form_Users().ShowDialog();
                    break;
                case "customer":
                    new Form_Customer().ShowDialog();
                    break;
                case "sales":
                    new Form_Sales().ShowDialog();
                    break;
            }
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            new Form_Login().Show();
            this.Close();
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {

            switch (tableName)
            {
                case "book":
                    new Form_Book(Id).ShowDialog();
                    break;
                case "users":
                    new Form_Users(Id).ShowDialog();
                    break;
                case "customer":
                    new Form_Customer(Id).ShowDialog();
                    break;
                case "sales":
                    new Form_Sales(Id).ShowDialog();
                    break;
            }

        }
    }
}
