using System.Collections.Generic;
using System.Data.SqlClient;
using System.Data;
using System.Collections;
using System;
using System.Windows.Forms;
using System.Linq;

namespace HotelAutomation
{
    class DBOperation
    {
        SqlConnection connection = new SqlConnection("Data Source=" + Setting.Default.Server + ";Initial Catalog=" + Setting.Default.Database + ";Integrated Security=True");

        //BAĞLANTI TEST
        public bool ConnectionTest() // Veritabanına bağlantının gerçekleşme durumunu test etme
        {
            try
            {
                connection.Open();
                connection.Close();
                return true;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString());
                return false;
            }
        }
        public bool UserControl(string userName, string password) //Kullanıcı bilgilerinin kontrolü
        {
            try
            {
                connection.Open();
                SqlCommand cmd = new SqlCommand("UserControl", connection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@username", userName);
                cmd.Parameters.AddWithValue("@password", password);
                SqlDataReader DTRead = cmd.ExecuteReader();
                if (DTRead.Read())
                {
                    connection.Close();
                    return true;
                }
                connection.Close();
                return false;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString());
                return false;
            }
        }
        //ANA İŞLEMLER
        public bool RegControl(string tableName, int Id) //Tabloda istenilen kaydın olup olmadığı kontrolü
        {
            try
            {
                connection.Open();
                SqlCommand cmd = new SqlCommand("ControlReg", connection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@Table", tableName);
                cmd.Parameters.AddWithValue("@Id", Id);
                SqlDataReader DTRead = cmd.ExecuteReader();
                if (DTRead.Read())
                {
                    connection.Close();
                    return true;
                }
                connection.Close();
                return false;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString());
                return false;
            }
        }
        public bool Add(string tableName, ArrayList data) //Herhangibir tabloya yeni kayıt adding
        {
            try
            {
                connection.Open();
                SqlCommand cmd = new SqlCommand(tableName + "_Add", connection);
                cmd.CommandType = CommandType.StoredProcedure;
                foreach (ArrayList Column in data)
                    cmd.Parameters.AddWithValue("@" + Column[0], Column[1]);
                cmd.ExecuteNonQuery();
                cmd.Dispose();
                connection.Close();
                return true;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString());
                return false;
            }
        }
        public bool Update(string tableName, ArrayList data) //Herhangibir tablodaki bir kaydı update
        {
            try
            {
                connection.Open();
                SqlCommand cmd = new SqlCommand(tableName + "_Update", connection);
                cmd.CommandType = CommandType.StoredProcedure;
                foreach (ArrayList Column in data)
                    cmd.Parameters.AddWithValue("@" + Column[0], Column[1]);
                cmd.ExecuteNonQuery();
                cmd.Dispose();
                connection.Close();
                return true;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString());
                return false;
            }
        }
        public bool Delete(string tableName, int Id) //Herhangibir tablodaki 1 kaydı deletion
        {
            if (!(RegControl(tableName, Id)))
                return false;
            try
            {
                connection.Open();
                SqlCommand cmd = new SqlCommand("DeleteReg", connection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@Table", tableName);
                cmd.Parameters.AddWithValue("@Id", Id);
                cmd.ExecuteNonQuery();
                cmd.Dispose();
                connection.Close();
                return true;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString());
                return false;
            }
        }
        public ArrayList GetReg(string tableName, int Id) //Herhangibir tablodan id bilgisine göre kayıt getirme
        {
            try
            {
                connection.Open();
                SqlCommand cmd = new SqlCommand("GetReg", connection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@Table", tableName);
                cmd.Parameters.AddWithValue("@Id", Id);
                SqlDataReader DTRead = cmd.ExecuteReader();
                ArrayList data = new ArrayList();
                if (DTRead.Read())
                {
                    for (int i = 0; true; i++)
                    {
                        try { data.Add(DTRead[i]); }
                        catch { break; }
                    }
                }

                cmd.Dispose();
                connection.Close();
                return data;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString());
                return null;
            }

        }
        public int DataListGetId(string tableName, int index) //Herhangibir tablodan index noya göre id bilgisini getirme
        {
            try
            {
                DataSet data = DataList(tableName);
                List<string> list = ConvertData(data, 0);
                int rvalue = Convert.ToInt32(list[index]);
                return rvalue;
            }
            catch { return -1; }
        }
        public string[] DataList(string tableName, string sorulan) //Herhangibir tablodan herhangibir column verisine göre kayıt getirme
        {
            try
            {
                DataSet data = DataList(tableName);
                ArrayList list = ConvertData(data);
                foreach (string[] items in list)
                    foreach (string dataset in items)
                        if (dataset == sorulan)
                            return items;
                return null;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString()); return null;
            }
        }
        public DataSet DataList(string tableName) //Herhangibir tablodaki tüm kayıtları listeleme
        {
            try
            {
                connection.Open();
                SqlCommand cmd = new SqlCommand("DataList", connection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@Table", tableName);
                SqlDataAdapter da = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                da.Fill(ds);
                cmd.Dispose();
                connection.Close();
                return ds;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString());
                return null;
            }
        }
        public ArrayList ConvertData(DataSet dataset) //Dataset türündeki bir veriyi ArrayList türüne dönüştürme
        {
            try
            {
                ArrayList data = new ArrayList();
                foreach (DataRow line in dataset.Tables[0].Rows)
                {
                    string[] seperated = string.Join(",", line.ItemArray).Split(',').ToArray();
                    data.Add(seperated);
                }
                return data;
            }
            catch { return null; }
        }
        public List<string> ConvertData(DataSet dataset, int column) //Dataset türündeki bir veriden tek bir kolonu List<string> türüne dönüştürme
        {
            try
            {
                List<string> data = new List<string>();
                foreach (DataRow line in dataset.Tables[0].Rows)
                {
                    string[] seperated = string.Join(",", line.ItemArray).Split(',').ToArray();
                    data.Add(seperated[column]);
                }
                return data;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString()); return null;
            }
        }
        public void Add(Form form, string tableName, ArrayList data)//Çağrılan formda verilen bilgilere göre hata veya uyarı mesaj kutusu oluşturma
        {
            if (Add(tableName, data))
                MsgBox(tableName + " adding");
            else
                MsgBox(2, tableName + " adding");
            ClearData(form);
        }
        public void Update(Form form, string tableName, ArrayList data, int Id)//Herhangi bir tablodaki bir kaydı update ve mesaj kutusu oluşturma
        {
            data.Add(new ArrayList() { "Id", Id });
            if (Update(tableName, data))
                MsgBox(tableName + " update");
            else
                MsgBox(2, tableName + " update");
            return;
        }
        public void Delete(Form form, string tableName, int Id)//Herhangi bir tablodaki bir kaydı deletion ve mesaj kutusu oluşturma
        {
            if (SoruKutu(tableName + " delete"))
            {
                if (Delete(tableName, Id))
                {
                    MsgBox("deletion");
                    form.Close();
                }
                else
                    MsgBox(2, "deletion");
            }
        }
        public void MsgBox(int tur, string islem)//Hata ve Warning türünde mesaj kutuları oluşturma
        {
            switch (tur)
            {
                case 1:
                    MessageBox.Show(islem.ToUpper() + " Fill in the required fields for the process.", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    break;
                case 2:
                    MessageBox.Show(islem.ToUpper() + " operation failed !!!!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    break;
            }
        }
        public void MsgBox(string islem)//Bilgi türünde mesaj kutusu oluşturma
        {
            MessageBox.Show(islem.ToUpper() + " operation successful.", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
        public bool SoruKutu(string soru)//Soru türünde mesaj kutusu oluşturma
        {
            DialogResult cevap = MessageBox.Show(soru.ToUpper() + " Are you sure you want?", "Question", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (cevap == DialogResult.Yes)
                return true;
            else
                return false;
        }
        public void ComboBoxSelect(ComboBox box, string tableName, int Id)//Herhangi bir Combobox nesnesinin verisetinden index seçme
        {
            List<string> data = ConvertData(DataList(tableName), 0);

            for (int i = 0; i < data.Count; i++)
                if (Id == Convert.ToInt32(data[i]))
                    box.SelectedIndex = i;
        }
        public void ComboBoxSelect(ComboBox box, List<string> data, int Id)//Herhangi bir Combobox nesnesinin verisetinden index seçme
        {
            for (int i = 0; i < data.Count; i++)
                if (Id == Convert.ToInt32(data[i]))
                    box.SelectedIndex = i;
        }
        public void ComboBoxList(ComboBox box, string tableName, int column)//Herhangi bir Combobox nesnesine bir tablonun bir kolonundan dataset aktarma
        {
            box.Items.Clear();
            try
            {
                ArrayList data = ConvertData(DataList(tableName));
                foreach (string[] item in data)
                    box.Items.Add(item[column]);
                box.SelectedIndex = 0;
            }
            catch
            {
                MsgBox(2, tableName + " record listing");
            }
        }
        public void ComboBoxList(ComboBox box, string tableName, int column, int k_kolon, int k_Id)//Herhangi bir Combobox nesnesine bir tablonun bir kolonundan dataset aktarma seçmeli
        {
            try
            {
                box.Items.Clear();
                ArrayList data = ConvertData(DataList(tableName));
                foreach (string[] item in data)
                {
                    if (Convert.ToInt32(item[k_kolon]) == k_Id)
                        box.Items.Add(item[column]);
                }

                box.SelectedIndex = 0;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString());
                // MsgBox(2, tableName + " record listing");
            }
        }
        public void ComboBoxList(ComboBox box, string tableName, int[] columns)//Herhangi bir Combobox nesnesine bir tablonun birçok kolonundan dataset aktarma
        {
            try
            {
                box.Items.Clear();
                ArrayList classes = ConvertData(DataList(tableName));
                foreach (string[] item in classes)
                {
                    string dataset = "";
                    for (int i = 0; i < columns.Length; i++)
                    {
                        dataset += item[columns[i]] + " ";
                    }
                    box.Items.Add(dataset);
                }

                box.SelectedIndex = 0;
            }
            catch (Exception err)
            {
                connection.Close();
                MsgBox(2, err.Message.ToString());
                //MsgBox(2, tableName + " record listing");
            }
        }

        public void ClearData(Form form)//Herhangi bir formdaki doldurulabilir nesnelerin içeriğini temizleme
        {
            foreach (Control item in form.Controls)
            {
                if (item is TextBox)
                    ((TextBox)item).Clear();
                if (item is MaskedTextBox)
                    ((MaskedTextBox)item).Clear();
                if (item is ComboBox)
                    if (((ComboBox)item).Items.Count > 0)
                        ((ComboBox)item).SelectedIndex = 0;
                if (item is DateTimePicker)
                    ((DateTimePicker)item).ResetText();
            }
        }

    }
}
