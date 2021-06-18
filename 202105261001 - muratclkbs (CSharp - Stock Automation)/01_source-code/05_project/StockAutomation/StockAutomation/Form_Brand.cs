using System;
using System.Collections;
using System.Windows.Forms;

namespace StockAutomation
{
    public partial class Form_Brand : Form
    {
        DBOperation operations = new DBOperation();
        string tableName = "brand";
        int Id = 0;
        public Form_Brand()
        {
            InitializeComponent();
        }
        public Form_Brand(int _Id)
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
                    "brandName",txtName.Text
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
