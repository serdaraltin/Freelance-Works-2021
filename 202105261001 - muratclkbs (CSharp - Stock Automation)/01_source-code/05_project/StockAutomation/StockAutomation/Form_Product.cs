using System;
using System.Collections;
using System.Windows.Forms;

namespace StockAutomation
{
    public partial class Form_Product : Form
    {
        DBOperation operations = new DBOperation();
        string tableName = "product";
        int Id = 0;
        public Form_Product()
        {
            InitializeComponent();
        }
        public Form_Product(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Load(object sender, EventArgs e)
        {
            operations.ComboBoxList(cbCategory, "category", 1);
            operations.ComboBoxList(cbBrand, "brand", 1);
            if (Id != 0)
            {
                try
                {
                    ArrayList data = operations.GetReg(tableName, Id);
                    txtName.Text = data[1].ToString();
                    
                    operations.ComboBoxSelect(cbCategory, "category", Convert.ToInt32(data[2]));
                    operations.ComboBoxSelect(cbBrand, "brand", Convert.ToInt32(data[3]));

                    cbUnit.Text = data[4].ToString();
                    txtAmount.Text = data[5].ToString();
                    txtPrice.Text = data[6].ToString();

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
            int categoryId = operations.DataListGetId("category", cbCategory.SelectedIndex);
            int brandId = operations.DataListGetId("brand", cbBrand.SelectedIndex);


            ArrayList newReg = new ArrayList()
            {
                new ArrayList(){
                    "productName",txtName.Text
                },
                 new ArrayList(){
                    "categoryId",categoryId
                },
                new ArrayList(){
                    "brandId",brandId
                },
                new ArrayList(){
                    "unit",cbUnit.Text
                },
                new ArrayList(){
                    "amount",txtAmount.Text
                },
                new ArrayList(){
                    "price",txtPrice.Text
                },
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
