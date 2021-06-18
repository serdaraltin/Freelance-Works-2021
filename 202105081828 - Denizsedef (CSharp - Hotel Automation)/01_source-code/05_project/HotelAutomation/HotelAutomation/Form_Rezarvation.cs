using System;
using System.Collections;
using System.Windows.Forms;

namespace HotelAutomation
{
    public partial class Form_Rezarvation : Form
    {
        DBOperation operations = new DBOperation();
        string tableName;
        int Id = 0;
        public Form_Rezarvation()
        {
            InitializeComponent();
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
        }
        public Form_Rezarvation(int _Id)
        {
            InitializeComponent();
            Id = _Id;
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
            operations.ComboBoxList(cbRoom, "room", new int[] { 1, 2, 3 });
            operations.ComboBoxList(cbCustomer, "customer", new int[] { 1, 2, 3 });

            ArrayList data = operations.GetReg(tableName, Id);

            operations.ComboBoxSelect(cbRoom, "room", Convert.ToInt32(data[1]));
            operations.ComboBoxSelect(cbRoom, "customer", Convert.ToInt32(data[2]));
            dtEntryDate.Text = data[3].ToString();
            dtReleaseDate.Text = data[4].ToString();
            txtPrice.Text = data[5].ToString();

            btnAdd.Text = "UPDATE";
            btnDelete.Visible = true;
        }

        private void Form_Load(object sender, EventArgs e)
        {
            Text = this.Name.Substring(this.Name.IndexOf("_") + 1);
            operations.ComboBoxList(cbRoom, "room", new int[] { 1, 2, 3 });
            operations.ComboBoxList(cbCustomer, "customer", new int[] { 1, 2, 3 });
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            int roomId = operations.DataListGetId("room", cbRoom.SelectedIndex);
            int customerId = operations.DataListGetId("customer", cbCustomer.SelectedIndex);
            ArrayList newReg = new ArrayList()
            {
                new ArrayList(){ "roomId",roomId},
                new ArrayList(){ "customerId",customerId},
                new ArrayList(){ "entryDate",dtEntryDate.Value},
                new ArrayList(){ "releaseDate",dtReleaseDate.Value},
                new ArrayList(){ "price",txtPrice.Text },
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
