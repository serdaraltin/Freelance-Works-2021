using System;
using System.Collections;
using System.Windows.Forms;

namespace Project
{
    public partial class Form_Sales : Form
    {
        DBOperation operations = new DBOperation();
        string tableName;
        int Id = 0;
        public Form_Sales()
        {
            InitializeComponent();
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
            operations.ComboBoxList(cbBook, "book", 1);
            operations.ComboBoxList(cbCustomer, "customer", new int[] { 1, 2, 3 });
        }
        public Form_Sales(int _Id)
        {
            InitializeComponent();
            Id = _Id;
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
            operations.ComboBoxList(cbBook, "book", 1);
            operations.ComboBoxList(cbCustomer, "customer", new int[] { 1, 2, 3 });

            ArrayList data = operations.GetReg(tableName, Id);

            operations.ComboBoxSelect(cbBook, "book", Convert.ToInt32(data[1].ToString()));
        
            operations.ComboBoxSelect(cbCustomer, "customer", Convert.ToInt32(data[2].ToString()));
            
            dtDate.Text = data[3].ToString();
            

            btnAdd.Text = "UPDATE";
            btnDelete.Visible = true;
        }
    

        private void Form_Load(object sender, EventArgs e)
        {
            Text = this.Name.Substring(this.Name.IndexOf("_") + 1);
         
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            int bookId = operations.DataListGetId("book", cbBook.SelectedIndex);
            int customerId = operations.DataListGetId("customer", cbCustomer.SelectedIndex);
            ArrayList newReg = new ArrayList()
            {
                new ArrayList(){ "bookId",bookId},
                new ArrayList(){ "customerId",customerId},
                new ArrayList(){ "date",dtDate.Value},
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
