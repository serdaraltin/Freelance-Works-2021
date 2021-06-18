namespace GTS_Project
{
    partial class Form_Sinav
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btn_Sil = new System.Windows.Forms.Button();
            this.btn_Ekle = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.cbBolum = new System.Windows.Forms.ComboBox();
            this.cbDonem = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.dtTarih = new System.Windows.Forms.DateTimePicker();
            this.label2 = new System.Windows.Forms.Label();
            this.msSaat = new System.Windows.Forms.MaskedTextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.cbDers = new System.Windows.Forms.ComboBox();
            this.label5 = new System.Windows.Forms.Label();
            this.cbOgretimUyesi = new System.Windows.Forms.ComboBox();
            this.label6 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.ch4 = new System.Windows.Forms.CheckBox();
            this.ch3 = new System.Windows.Forms.CheckBox();
            this.ch2 = new System.Windows.Forms.CheckBox();
            this.ch1 = new System.Windows.Forms.CheckBox();
            this.cbSinavTur = new System.Windows.Forms.ComboBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.txtSure = new System.Windows.Forms.TextBox();
            this.cbsinavSekil = new System.Windows.Forms.ComboBox();
            this.label9 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // btn_Sil
            // 
            this.btn_Sil.Location = new System.Drawing.Point(231, 374);
            this.btn_Sil.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Sil.Name = "btn_Sil";
            this.btn_Sil.Size = new System.Drawing.Size(91, 46);
            this.btn_Sil.TabIndex = 3;
            this.btn_Sil.Text = "SİL";
            this.btn_Sil.UseVisualStyleBackColor = true;
            this.btn_Sil.Visible = false;
            this.btn_Sil.Click += new System.EventHandler(this.btn_Sil_Click);
            // 
            // btn_Ekle
            // 
            this.btn_Ekle.Location = new System.Drawing.Point(93, 374);
            this.btn_Ekle.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Ekle.Name = "btn_Ekle";
            this.btn_Ekle.Size = new System.Drawing.Size(129, 46);
            this.btn_Ekle.TabIndex = 2;
            this.btn_Ekle.Text = "EKLE";
            this.btn_Ekle.UseVisualStyleBackColor = true;
            this.btn_Ekle.Click += new System.EventHandler(this.btn_Ekle_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 29);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(47, 17);
            this.label1.TabIndex = 56;
            this.label1.Text = "Bölüm";
            // 
            // cbBolum
            // 
            this.cbBolum.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbBolum.FormattingEnabled = true;
            this.cbBolum.Location = new System.Drawing.Point(95, 29);
            this.cbBolum.Name = "cbBolum";
            this.cbBolum.Size = new System.Drawing.Size(227, 24);
            this.cbBolum.TabIndex = 57;
            this.cbBolum.SelectedIndexChanged += new System.EventHandler(this.cbBolum_SelectedIndexChanged);
            // 
            // cbDonem
            // 
            this.cbDonem.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbDonem.FormattingEnabled = true;
            this.cbDonem.Location = new System.Drawing.Point(95, 59);
            this.cbDonem.Name = "cbDonem";
            this.cbDonem.Size = new System.Drawing.Size(227, 24);
            this.cbDonem.TabIndex = 59;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(13, 62);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(53, 17);
            this.label3.TabIndex = 58;
            this.label3.Text = "Dönem";
            // 
            // dtTarih
            // 
            this.dtTarih.Location = new System.Drawing.Point(95, 89);
            this.dtTarih.Name = "dtTarih";
            this.dtTarih.Size = new System.Drawing.Size(227, 23);
            this.dtTarih.TabIndex = 60;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 94);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 17);
            this.label2.TabIndex = 61;
            this.label2.Text = "Tarih";
            // 
            // msSaat
            // 
            this.msSaat.Location = new System.Drawing.Point(95, 118);
            this.msSaat.Mask = "90:00";
            this.msSaat.Name = "msSaat";
            this.msSaat.Size = new System.Drawing.Size(48, 23);
            this.msSaat.TabIndex = 62;
            this.msSaat.Text = "0900";
            this.msSaat.ValidatingType = typeof(System.DateTime);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(13, 121);
            this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(37, 17);
            this.label4.TabIndex = 63;
            this.label4.Text = "Saat";
            // 
            // cbDers
            // 
            this.cbDers.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbDers.FormattingEnabled = true;
            this.cbDers.Location = new System.Drawing.Point(95, 147);
            this.cbDers.Name = "cbDers";
            this.cbDers.Size = new System.Drawing.Size(227, 24);
            this.cbDers.TabIndex = 65;
            this.cbDers.SelectedIndexChanged += new System.EventHandler(this.cbDers_SelectedIndexChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(13, 150);
            this.label5.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(38, 17);
            this.label5.TabIndex = 64;
            this.label5.Text = "Ders";
            // 
            // cbOgretimUyesi
            // 
            this.cbOgretimUyesi.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbOgretimUyesi.FormattingEnabled = true;
            this.cbOgretimUyesi.Location = new System.Drawing.Point(95, 177);
            this.cbOgretimUyesi.Name = "cbOgretimUyesi";
            this.cbOgretimUyesi.Size = new System.Drawing.Size(227, 24);
            this.cbOgretimUyesi.TabIndex = 67;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(13, 180);
            this.label6.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(76, 17);
            this.label6.TabIndex = 66;
            this.label6.Text = "Öğretim Ü.";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.ch4);
            this.groupBox1.Controls.Add(this.ch3);
            this.groupBox1.Controls.Add(this.ch2);
            this.groupBox1.Controls.Add(this.ch1);
            this.groupBox1.Location = new System.Drawing.Point(16, 207);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(306, 57);
            this.groupBox1.TabIndex = 68;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Sınıflar";
            // 
            // ch4
            // 
            this.ch4.AutoSize = true;
            this.ch4.Location = new System.Drawing.Point(234, 22);
            this.ch4.Name = "ch4";
            this.ch4.Size = new System.Drawing.Size(70, 21);
            this.ch4.TabIndex = 3;
            this.ch4.Text = "4. Sınıf";
            this.ch4.UseVisualStyleBackColor = true;
            // 
            // ch3
            // 
            this.ch3.AutoSize = true;
            this.ch3.Location = new System.Drawing.Point(158, 22);
            this.ch3.Name = "ch3";
            this.ch3.Size = new System.Drawing.Size(70, 21);
            this.ch3.TabIndex = 2;
            this.ch3.Text = "3. Sınıf";
            this.ch3.UseVisualStyleBackColor = true;
            // 
            // ch2
            // 
            this.ch2.AutoSize = true;
            this.ch2.Location = new System.Drawing.Point(82, 22);
            this.ch2.Name = "ch2";
            this.ch2.Size = new System.Drawing.Size(70, 21);
            this.ch2.TabIndex = 1;
            this.ch2.Text = "2. Sınıf";
            this.ch2.UseVisualStyleBackColor = true;
            // 
            // ch1
            // 
            this.ch1.AutoSize = true;
            this.ch1.Checked = true;
            this.ch1.CheckState = System.Windows.Forms.CheckState.Checked;
            this.ch1.Location = new System.Drawing.Point(6, 22);
            this.ch1.Name = "ch1";
            this.ch1.Size = new System.Drawing.Size(70, 21);
            this.ch1.TabIndex = 0;
            this.ch1.Text = "1. Sınıf";
            this.ch1.UseVisualStyleBackColor = true;
            // 
            // cbSinavTur
            // 
            this.cbSinavTur.FormattingEnabled = true;
            this.cbSinavTur.Items.AddRange(new object[] {
            "Çevrimiçi",
            "Ödev",
            "Yüz Yüze"});
            this.cbSinavTur.Location = new System.Drawing.Point(95, 270);
            this.cbSinavTur.Name = "cbSinavTur";
            this.cbSinavTur.Size = new System.Drawing.Size(227, 24);
            this.cbSinavTur.TabIndex = 70;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(13, 273);
            this.label7.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(69, 17);
            this.label7.TabIndex = 69;
            this.label7.Text = "Sınav Tür";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(13, 303);
            this.label8.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(38, 17);
            this.label8.TabIndex = 72;
            this.label8.Text = "Süre";
            // 
            // txtSure
            // 
            this.txtSure.Location = new System.Drawing.Point(95, 300);
            this.txtSure.Name = "txtSure";
            this.txtSure.Size = new System.Drawing.Size(149, 23);
            this.txtSure.TabIndex = 73;
            this.txtSure.Text = "40 dk";
            // 
            // cbsinavSekil
            // 
            this.cbsinavSekil.FormattingEnabled = true;
            this.cbsinavSekil.Items.AddRange(new object[] {
            "Vize",
            "Final",
            "Bütünleme"});
            this.cbsinavSekil.Location = new System.Drawing.Point(95, 329);
            this.cbsinavSekil.Name = "cbsinavSekil";
            this.cbsinavSekil.Size = new System.Drawing.Size(227, 24);
            this.cbsinavSekil.TabIndex = 75;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(13, 332);
            this.label9.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(77, 17);
            this.label9.TabIndex = 74;
            this.label9.Text = "Sınav Şekil";
            // 
            // Form_Sinav
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(347, 438);
            this.Controls.Add(this.cbsinavSekil);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.txtSure);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.cbSinavTur);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.cbOgretimUyesi);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.cbDers);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.msSaat);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.dtTarih);
            this.Controls.Add(this.cbDonem);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.cbBolum);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btn_Sil);
            this.Controls.Add(this.btn_Ekle);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form_Sinav";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Sınav";
            this.Load += new System.EventHandler(this.Form_Personel_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btn_Sil;
        private System.Windows.Forms.Button btn_Ekle;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cbBolum;
        private System.Windows.Forms.ComboBox cbDonem;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.DateTimePicker dtTarih;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.MaskedTextBox msSaat;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox cbDers;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ComboBox cbOgretimUyesi;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.CheckBox ch4;
        private System.Windows.Forms.CheckBox ch3;
        private System.Windows.Forms.CheckBox ch2;
        private System.Windows.Forms.CheckBox ch1;
        private System.Windows.Forms.ComboBox cbSinavTur;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox txtSure;
        private System.Windows.Forms.ComboBox cbsinavSekil;
        private System.Windows.Forms.Label label9;
    }
}