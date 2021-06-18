using System;
using System.Data;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_OperationCustomer : Form
    {
        int customerId = 0;
        public Form_OperationCustomer()
        {
            InitializeComponent();
        }
        public Form_OperationCustomer(int _Id)
        {
            InitializeComponent();
            customerId = _Id;
        }

        DBOperation operation = new DBOperation();
        int Id = 0;
        public void List()
        {
            DataSet ds = operation.DataListSales(customerId);
            dgData.DataSource = ds.Tables[0];
        }

        private void dgData_RowEnter(object sender, DataGridViewCellEventArgs e)
        {
            try { Id = Convert.ToInt32(dgData.SelectedRows[0].Cells[0].Value); }
            catch { };
        }

        private void dgData_DoubleClick(object sender, EventArgs e)
        {
            int bookId = Convert.ToInt32(operation.GetReg("sales", Id)[1]);
            string bookName = operation.GetReg("book", bookId)[1].ToString();
            MessageBox.Show("Kitap Adı: "+bookName);
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
            new Form_Customer(customerId).ShowDialog();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            new Form_Login().Show();
            this.Close();
        }

        private void txtSearch_TextChanged(object sender, EventArgs e)
        {
        
            
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            if (txtSearch.Text == "")
            {
                List();
                return;
            }

            DataSet ds = operation.DataListSales(customerId, txtSearch.Text);
            dgData.DataSource = ds.Tables[0];
        }
    }
}
