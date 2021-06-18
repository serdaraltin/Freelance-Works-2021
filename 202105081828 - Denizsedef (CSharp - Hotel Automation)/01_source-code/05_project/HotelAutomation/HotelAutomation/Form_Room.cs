using System;
using System.Collections;
using System.Windows.Forms;

namespace HotelAutomation
{
    public partial class Form_Room : Form
    {
        DBOperation operations = new DBOperation();
        string tableName;
        int Id = 0;
        public Form_Room()
        {
            InitializeComponent();
            cbType.SelectedIndex = 0;
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
        }
        public Form_Room(int _Id)
        {
            InitializeComponent();
            Id = _Id;
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();

            ArrayList data = operations.GetReg(tableName, Id);

            txtNumber.Text = data[1].ToString();
            txtLayer.Text = data[2].ToString();
            cbType.Text = data[3].ToString();

            this.Text += " Update";
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
                new ArrayList(){ "number",txtNumber.Text },
                new ArrayList(){ "layer",txtLayer.Text },
                new ArrayList(){ "type",cbType.Text }
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
