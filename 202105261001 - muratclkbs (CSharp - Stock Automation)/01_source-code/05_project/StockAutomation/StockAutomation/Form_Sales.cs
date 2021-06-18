using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace StockAutomation
{
    public partial class Form_Sales : Form
    {
        DBOperation operations = new DBOperation();
        string tableName = "sales";
        int Id = 0;
        ArrayList stocks;
        public Form_Sales()
        {
            InitializeComponent();
        }
        public Form_Sales(int _Id)
        {
            InitializeComponent();
            Id = _Id;
        }

        private void Form_Load(object sender, EventArgs e)
        {
            stocks = operations.ConvertData(operations.DataList("stock"));

            foreach (string[] stock in stocks)
            {
                int productId = Convert.ToInt32(stock[1]);
                int piece = Convert.ToInt32(stock[2]);
                DateTime date = Convert.ToDateTime(stock[3]);

                string productName = operations.GetReg("product", productId)[1].ToString();
                cbStock.Items.Add(productName + " / " + piece + " / " + date.Year + "." + date.Month + "." + date.Day + "");
            }
            cbStock.SelectedIndex = 0;

            if (Id != 0)
            {
                try
                {
                    ArrayList data = operations.GetReg(tableName, Id);

                    operations.ComboBoxSelect(cbStock, "stock", Convert.ToInt32(data[1]));
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
            int stockId = operations.DataListGetId("stock", cbStock.SelectedIndex);


            ArrayList newReg = new ArrayList()
            {
                new ArrayList(){
                    "stockId",stockId
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
            {
                operations.MsgBox(tableName + " add");

                string[] stock = (string[])stocks[cbStock.SelectedIndex];
                ArrayList updateStock = new ArrayList()
                 {

                new ArrayList(){
                    "productId",stock[1]
                },
                 new ArrayList(){
                    "piece",(Convert.ToInt32(stock[2])-Convert.ToInt32(ndPiece.Value))
                },
                new ArrayList(){
                    "date",dtDate.Value
                }
                 };
                updateStock.Add(new ArrayList() { "Id", stockId });
                operations.Update("stock", updateStock);


            }
            else
                operations.MsgBox(2, tableName + " add");
            operations.ClearData(this);
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            operations.Delete(this, tableName, Id);
        }

        private void cbStock_SelectedIndexChanged(object sender, EventArgs e)
        {
            string[] stock = (string[])stocks[cbStock.SelectedIndex];
            int piece = Convert.ToInt32(stock[2]);

            ndPiece.Maximum = piece;
            lbMax.Text = "Max: "+piece.ToString();
            if (piece <= 0)
            { 
                btnAdd.Enabled = false;
                return;
            }
            ndPiece.Value = 1;
            
            btnAdd.Enabled = true;

        }
    }
}
