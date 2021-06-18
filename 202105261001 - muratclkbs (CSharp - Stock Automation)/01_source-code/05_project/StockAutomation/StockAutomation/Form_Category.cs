using System;
using System.Collections;
using System.Windows.Forms;

namespace StockAutomation
{
    public partial class Form_Category : Form
    {
        DBOperation operations = new DBOperation();
        string tableName = "category";
        int Id = 0;
        public Form_Category()
        {
            InitializeComponent();
        }
        public Form_Category(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Load(object sender, EventArgs e)
        {
            if (Id != 0)
            {
                try
                {
                    ArrayList data = operations.GetReg(tableName, Id);

                    txtName.Text = data[1].ToString();


                    this.Text += " Güncelle";
                    btnAdd.Text = "GÜNCELLE";
                    btnDelete.Visible = true;
                }
                catch
                {
                    return;
                }
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            ArrayList newReg = new ArrayList()
            {
                new ArrayList(){
                    "categoryName",txtName.Text
                }
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
