namespace GTS_Project
{
    partial class Form_Tez
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
            this.cbYazar = new System.Windows.Forms.ComboBox();
            this.cbDanisman = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.cbUniversite = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            this.cbEnstitu = new System.Windows.Forms.ComboBox();
            this.label5 = new System.Windows.Forms.Label();
            this.cbBaslik = new System.Windows.Forms.ComboBox();
            this.label6 = new System.Windows.Forms.Label();
            this.cbTur = new System.Windows.Forms.ComboBox();
            this.label7 = new System.Windows.Forms.Label();
            this.txtOzet = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.cbDil = new System.Windows.Forms.ComboBox();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.txtAnahtarKelime = new System.Windows.Forms.TextBox();
            this.cbYil = new System.Windows.Forms.ComboBox();
            this.label11 = new System.Windows.Forms.Label();
            this.ndSayfa = new System.Windows.Forms.NumericUpDown();
            this.label12 = new System.Windows.Forms.Label();
            this.dtTeslimTarih = new System.Windows.Forms.DateTimePicker();
            this.label13 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.ndSayfa)).BeginInit();
            this.SuspendLayout();
            // 
            // btn_Sil
            // 
            this.btn_Sil.Location = new System.Drawing.Point(240, 492);
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
            this.btn_Ekle.Location = new System.Drawing.Point(104, 492);
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
            this.label1.Location = new System.Drawing.Point(6, 32);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(45, 17);
            this.label1.TabIndex = 56;
            this.label1.Text = "Yazar";
            // 
            // cbYazar
            // 
            this.cbYazar.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbYazar.FormattingEnabled = true;
            this.cbYazar.Location = new System.Drawing.Point(104, 29);
            this.cbYazar.Name = "cbYazar";
            this.cbYazar.Size = new System.Drawing.Size(227, 24);
            this.cbYazar.TabIndex = 57;
            // 
            // cbDanisman
            // 
            this.cbDanisman.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbDanisman.FormattingEnabled = true;
            this.cbDanisman.Location = new System.Drawing.Point(104, 59);
            this.cbDanisman.Name = "cbDanisman";
            this.cbDanisman.Size = new System.Drawing.Size(227, 24);
            this.cbDanisman.TabIndex = 59;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(6, 62);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(71, 17);
            this.label3.TabIndex = 58;
            this.label3.Text = "Danışman";
            // 
            // cbUniversite
            // 
            this.cbUniversite.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbUniversite.FormattingEnabled = true;
            this.cbUniversite.Location = new System.Drawing.Point(104, 89);
            this.cbUniversite.Name = "cbUniversite";
            this.cbUniversite.Size = new System.Drawing.Size(227, 24);
            this.cbUniversite.TabIndex = 61;
            this.cbUniversite.SelectedIndexChanged += new System.EventHandler(this.cbUniversite_SelectedIndexChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(6, 92);
            this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(71, 17);
            this.label4.TabIndex = 60;
            this.label4.Text = "Üniversite";
            // 
            // cbEnstitu
            // 
            this.cbEnstitu.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbEnstitu.FormattingEnabled = true;
            this.cbEnstitu.Location = new System.Drawing.Point(104, 119);
            this.cbEnstitu.Name = "cbEnstitu";
            this.cbEnstitu.Size = new System.Drawing.Size(227, 24);
            this.cbEnstitu.TabIndex = 63;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(6, 122);
            this.label5.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(51, 17);
            this.label5.TabIndex = 62;
            this.label5.Text = "Enstitü";
            // 
            // cbBaslik
            // 
            this.cbBaslik.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbBaslik.FormattingEnabled = true;
            this.cbBaslik.Location = new System.Drawing.Point(104, 149);
            this.cbBaslik.Name = "cbBaslik";
            this.cbBaslik.Size = new System.Drawing.Size(227, 24);
            this.cbBaslik.TabIndex = 65;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(6, 152);
            this.label6.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(45, 17);
            this.label6.TabIndex = 64;
            this.label6.Text = "Başlık";
            // 
            // cbTur
            // 
            this.cbTur.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbTur.FormattingEnabled = true;
            this.cbTur.Items.AddRange(new object[] {
            "Yüksek Lisans",
            "Doktora",
            "Tıpta Uzmanlık",
            "Sanatta Yeterlilik"});
            this.cbTur.Location = new System.Drawing.Point(104, 179);
            this.cbTur.Name = "cbTur";
            this.cbTur.Size = new System.Drawing.Size(227, 24);
            this.cbTur.TabIndex = 67;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(6, 182);
            this.label7.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(30, 17);
            this.label7.TabIndex = 66;
            this.label7.Text = "Tür";
            // 
            // txtOzet
            // 
            this.txtOzet.Location = new System.Drawing.Point(104, 209);
            this.txtOzet.Multiline = true;
            this.txtOzet.Name = "txtOzet";
            this.txtOzet.Size = new System.Drawing.Size(227, 76);
            this.txtOzet.TabIndex = 68;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(6, 212);
            this.label8.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(38, 17);
            this.label8.TabIndex = 69;
            this.label8.Text = "Özet";
            // 
            // cbDil
            // 
            this.cbDil.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbDil.FormattingEnabled = true;
            this.cbDil.Items.AddRange(new object[] {
            "Türkçe",
            "İngilizce",
            "Fransızca",
            "Almanca",
            "Rusça",
            "İspanyolca"});
            this.cbDil.Location = new System.Drawing.Point(104, 291);
            this.cbDil.Name = "cbDil";
            this.cbDil.Size = new System.Drawing.Size(227, 24);
            this.cbDil.TabIndex = 71;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(6, 294);
            this.label9.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(24, 17);
            this.label9.TabIndex = 70;
            this.label9.Text = "Dil";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(6, 324);
            this.label10.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(66, 34);
            this.label10.TabIndex = 73;
            this.label10.Text = "Anahtar \r\nKelimeler";
            // 
            // txtAnahtarKelime
            // 
            this.txtAnahtarKelime.Location = new System.Drawing.Point(104, 321);
            this.txtAnahtarKelime.Multiline = true;
            this.txtAnahtarKelime.Name = "txtAnahtarKelime";
            this.txtAnahtarKelime.Size = new System.Drawing.Size(227, 76);
            this.txtAnahtarKelime.TabIndex = 72;
            // 
            // cbYil
            // 
            this.cbYil.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbYil.FormattingEnabled = true;
            this.cbYil.Location = new System.Drawing.Point(104, 423);
            this.cbYil.Name = "cbYil";
            this.cbYil.Size = new System.Drawing.Size(99, 24);
            this.cbYil.TabIndex = 75;
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(101, 403);
            this.label11.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(23, 17);
            this.label11.TabIndex = 74;
            this.label11.Text = "Yıl";
            // 
            // ndSayfa
            // 
            this.ndSayfa.Location = new System.Drawing.Point(235, 423);
            this.ndSayfa.Maximum = new decimal(new int[] {
            5000,
            0,
            0,
            0});
            this.ndSayfa.Name = "ndSayfa";
            this.ndSayfa.Size = new System.Drawing.Size(96, 23);
            this.ndSayfa.TabIndex = 76;
            this.ndSayfa.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.ndSayfa.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(232, 403);
            this.label12.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(44, 17);
            this.label12.TabIndex = 77;
            this.label12.Text = "Sayfa";
            // 
            // dtTeslimTarih
            // 
            this.dtTeslimTarih.Location = new System.Drawing.Point(104, 457);
            this.dtTeslimTarih.Name = "dtTeslimTarih";
            this.dtTeslimTarih.Size = new System.Drawing.Size(227, 23);
            this.dtTeslimTarih.TabIndex = 78;
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(6, 461);
            this.label13.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(89, 17);
            this.label13.TabIndex = 79;
            this.label13.Text = "Teslim Tarihi";
            // 
            // Form_Tez
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(361, 554);
            this.Controls.Add(this.label13);
            this.Controls.Add(this.dtTeslimTarih);
            this.Controls.Add(this.label12);
            this.Controls.Add(this.ndSayfa);
            this.Controls.Add(this.cbYil);
            this.Controls.Add(this.label11);
            this.Controls.Add(this.label10);
            this.Controls.Add(this.txtAnahtarKelime);
            this.Controls.Add(this.cbDil);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.txtOzet);
            this.Controls.Add(this.cbTur);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.cbBaslik);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.cbEnstitu);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.cbUniversite);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.cbDanisman);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.cbYazar);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btn_Sil);
            this.Controls.Add(this.btn_Ekle);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form_Tez";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Tez";
            this.Load += new System.EventHandler(this.Form_Personel_Load);
            ((System.ComponentModel.ISupportInitialize)(this.ndSayfa)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btn_Sil;
        private System.Windows.Forms.Button btn_Ekle;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cbYazar;
        private System.Windows.Forms.ComboBox cbDanisman;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox cbUniversite;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox cbEnstitu;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ComboBox cbBaslik;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.ComboBox cbTur;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox txtOzet;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.ComboBox cbDil;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.TextBox txtAnahtarKelime;
        private System.Windows.Forms.ComboBox cbYil;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.NumericUpDown ndSayfa;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.DateTimePicker dtTeslimTarih;
        private System.Windows.Forms.Label label13;
    }
}