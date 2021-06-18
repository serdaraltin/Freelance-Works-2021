using System;
using System.Collections;
using System.Windows.Forms;

namespace StockAutomation
{
    public partial class Form_Stock : Form
    {
        DBOperation operations = new DBOperation();
        string tableName = "stock";
        int Id = 0;
        public Form_Stock()
        {
            InitializeComponent();
        }
        public Form_Stock(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Load(object sender, EventArgs e)
        {
            operations.ComboBoxList(cbProduct, "product",1);
         
            if (Id != 0)
            {
                try
                {
                    ArrayList data = operations.GetReg(tableName, Id);
            
                    operations.ComboBoxSelect(cbProduct, "product", Convert.ToInt32(data[1]));
                    ndPiece.Value = Convert.ToInt32(data[2]);
                    dtDate.Text = data[3].ToString();


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
            int productId = operations.DataListGetId("product", cbProduct.SelectedIndex);
          

            ArrayList newReg = new ArrayList()
            {
                new ArrayList(){
                    "productId",productId
                },
                 new ArrayList(){
                    "piece",Convert.ToInt32(ndPiece.Value)
                },
                new ArrayList(){
                    "date",dtDate.Value
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
