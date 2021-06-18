﻿using System;
using System.Collections;
using System.Windows.Forms;

namespace HotelAutomation
{
    public partial class Form_Users : Form
    {
        DBOperation operations = new DBOperation();
        string tableName;
        int Id = 0;
        public Form_Users()
        {
            InitializeComponent();
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
            operations.ComboBoxList(cbEmployees, "employees", new int[] { 1, 2, 3 });
        }
        public Form_Users(int _Id)
        {
            InitializeComponent();
            Id = _Id;
            tableName = this.Name.Substring(this.Name.IndexOf("_") + 1).ToLower();
            operations.ComboBoxList(cbEmployees, "employees", new int[] { 1, 2, 3 });

            ArrayList data = operations.GetReg(tableName, Id);

            txtUserName.Text = data[1].ToString();
            txtPassword.Text = data[2].ToString();

            operations.ComboBoxSelect(cbEmployees, "employees", Convert.ToInt32(data[3]));

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
            int employeesId = operations.DataListGetId("employees", cbEmployees.SelectedIndex);
            ArrayList newReg = new ArrayList()
            {
                new ArrayList(){ "username",txtUserName.Text },
                new ArrayList(){ "password",txtPassword.Text },
                 new ArrayList(){ "employeesId",employeesId },
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
