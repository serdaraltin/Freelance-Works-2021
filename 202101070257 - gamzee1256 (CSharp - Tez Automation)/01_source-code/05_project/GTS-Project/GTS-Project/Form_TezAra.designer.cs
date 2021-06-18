namespace GTS_Project
{
    partial class Form_TezAra
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
            this.btn_Ara = new System.Windows.Forms.Button();
            this.cbYazar = new System.Windows.Forms.ComboBox();
            this.cbDanisman = new System.Windows.Forms.ComboBox();
            this.cbUniversite = new System.Windows.Forms.ComboBox();
            this.cbEnstitu = new System.Windows.Forms.ComboBox();
            this.cbBaslik = new System.Windows.Forms.ComboBox();
            this.cbTur = new System.Windows.Forms.ComboBox();
            this.txtOzet = new System.Windows.Forms.TextBox();
            this.cbDil = new System.Windows.Forms.ComboBox();
            this.txtAnahtarKelime = new System.Windows.Forms.TextBox();
            this.cbYil = new System.Windows.Forms.ComboBox();
            this.ndSayfa = new System.Windows.Forms.NumericUpDown();
            this.dtTeslimTarih = new System.Windows.Forms.DateTimePicker();
            this.chYazar = new System.Windows.Forms.CheckBox();
            this.chDanisman = new System.Windows.Forms.CheckBox();
            this.chUniversite = new System.Windows.Forms.CheckBox();
            this.chEnstitu = new System.Windows.Forms.CheckBox();
            this.chBaslik = new System.Windows.Forms.CheckBox();
            this.chTur = new System.Windows.Forms.CheckBox();
            this.chOzet = new System.Windows.Forms.CheckBox();
            this.chDil = new System.Windows.Forms.CheckBox();
            this.chAnahtar = new System.Windows.Forms.CheckBox();
            this.chYil = new System.Windows.Forms.CheckBox();
            this.chSayfa = new System.Windows.Forms.CheckBox();
            this.chTeslimTarihi = new System.Windows.Forms.CheckBox();
            ((System.ComponentModel.ISupportInitialize)(this.ndSayfa)).BeginInit();
            this.SuspendLayout();
            // 
            // btn_Ara
            // 
            this.btn_Ara.Location = new System.Drawing.Point(123, 497);
            this.btn_Ara.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Ara.Name = "btn_Ara";
            this.btn_Ara.Size = new System.Drawing.Size(227, 46);
            this.btn_Ara.TabIndex = 2;
            this.btn_Ara.Text = "ARA";
            this.btn_Ara.UseVisualStyleBackColor = true;
            this.btn_Ara.Click += new System.EventHandler(this.btn_Ara_Click);
            // 
            // cbYazar
            // 
            this.cbYazar.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbYazar.FormattingEnabled = true;
            this.cbYazar.Location = new System.Drawing.Point(123, 25);
            this.cbYazar.Name = "cbYazar";
            this.cbYazar.Size = new System.Drawing.Size(227, 24);
            this.cbYazar.TabIndex = 57;
            // 
            // cbDanisman
            // 
            this.cbDanisman.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbDanisman.FormattingEnabled = true;
            this.cbDanisman.Location = new System.Drawing.Point(123, 55);
            this.cbDanisman.Name = "cbDanisman";
            this.cbDanisman.Size = new System.Drawing.Size(227, 24);
            this.cbDanisman.TabIndex = 59;
            // 
            // cbUniversite
            // 
            this.cbUniversite.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbUniversite.FormattingEnabled = true;
            this.cbUniversite.Location = new System.Drawing.Point(123, 85);
            this.cbUniversite.Name = "cbUniversite";
            this.cbUniversite.Size = new System.Drawing.Size(227, 24);
            this.cbUniversite.TabIndex = 61;
            this.cbUniversite.SelectedIndexChanged += new System.EventHandler(this.cbUniversite_SelectedIndexChanged);
            // 
            // cbEnstitu
            // 
            this.cbEnstitu.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbEnstitu.FormattingEnabled = true;
            this.cbEnstitu.Location = new System.Drawing.Point(123, 115);
            this.cbEnstitu.Name = "cbEnstitu";
            this.cbEnstitu.Size = new System.Drawing.Size(227, 24);
            this.cbEnstitu.TabIndex = 63;
            // 
            // cbBaslik
            // 
            this.cbBaslik.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbBaslik.FormattingEnabled = true;
            this.cbBaslik.Location = new System.Drawing.Point(123, 145);
            this.cbBaslik.Name = "cbBaslik";
            this.cbBaslik.Size = new System.Drawing.Size(227, 24);
            this.cbBaslik.TabIndex = 65;
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
            this.cbTur.Location = new System.Drawing.Point(123, 175);
            this.cbTur.Name = "cbTur";
            this.cbTur.Size = new System.Drawing.Size(227, 24);
            this.cbTur.TabIndex = 67;
            // 
            // txtOzet
            // 
            this.txtOzet.Location = new System.Drawing.Point(123, 205);
            this.txtOzet.Multiline = true;
            this.txtOzet.Name = "txtOzet";
            this.txtOzet.Size = new System.Drawing.Size(227, 76);
            this.txtOzet.TabIndex = 68;
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
            this.cbDil.Location = new System.Drawing.Point(123, 287);
            this.cbDil.Name = "cbDil";
            this.cbDil.Size = new System.Drawing.Size(227, 24);
            this.cbDil.TabIndex = 71;
            // 
            // txtAnahtarKelime
            // 
            this.txtAnahtarKelime.Location = new System.Drawing.Point(123, 317);
            this.txtAnahtarKelime.Multiline = true;
            this.txtAnahtarKelime.Name = "txtAnahtarKelime";
            this.txtAnahtarKelime.Size = new System.Drawing.Size(227, 76);
            this.txtAnahtarKelime.TabIndex = 72;
            // 
            // cbYil
            // 
            this.cbYil.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbYil.FormattingEnabled = true;
            this.cbYil.Location = new System.Drawing.Point(123, 419);
            this.cbYil.Name = "cbYil";
            this.cbYil.Size = new System.Drawing.Size(99, 24);
            this.cbYil.TabIndex = 75;
            // 
            // ndSayfa
            // 
            this.ndSayfa.Location = new System.Drawing.Point(254, 419);
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
            // dtTeslimTarih
            // 
            this.dtTeslimTarih.Location = new System.Drawing.Point(123, 453);
            this.dtTeslimTarih.Name = "dtTeslimTarih";
            this.dtTeslimTarih.Size = new System.Drawing.Size(227, 23);
            this.dtTeslimTarih.TabIndex = 78;
            // 
            // chYazar
            // 
            this.chYazar.AutoSize = true;
            this.chYazar.Location = new System.Drawing.Point(53, 27);
            this.chYazar.Name = "chYazar";
            this.chYazar.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chYazar.Size = new System.Drawing.Size(64, 21);
            this.chYazar.TabIndex = 80;
            this.chYazar.Text = "Yazar";
            this.chYazar.UseVisualStyleBackColor = true;
            // 
            // chDanisman
            // 
            this.chDanisman.AutoSize = true;
            this.chDanisman.Location = new System.Drawing.Point(27, 57);
            this.chDanisman.Name = "chDanisman";
            this.chDanisman.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chDanisman.Size = new System.Drawing.Size(90, 21);
            this.chDanisman.TabIndex = 81;
            this.chDanisman.Text = "Danışman";
            this.chDanisman.UseVisualStyleBackColor = true;
            // 
            // chUniversite
            // 
            this.chUniversite.AutoSize = true;
            this.chUniversite.Location = new System.Drawing.Point(27, 88);
            this.chUniversite.Name = "chUniversite";
            this.chUniversite.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chUniversite.Size = new System.Drawing.Size(90, 21);
            this.chUniversite.TabIndex = 82;
            this.chUniversite.Text = "Üniversite";
            this.chUniversite.UseVisualStyleBackColor = true;
            // 
            // chEnstitu
            // 
            this.chEnstitu.AutoSize = true;
            this.chEnstitu.Location = new System.Drawing.Point(47, 117);
            this.chEnstitu.Name = "chEnstitu";
            this.chEnstitu.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chEnstitu.Size = new System.Drawing.Size(70, 21);
            this.chEnstitu.TabIndex = 83;
            this.chEnstitu.Text = "Enstitü";
            this.chEnstitu.UseVisualStyleBackColor = true;
            // 
            // chBaslik
            // 
            this.chBaslik.AutoSize = true;
            this.chBaslik.Location = new System.Drawing.Point(53, 147);
            this.chBaslik.Name = "chBaslik";
            this.chBaslik.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chBaslik.Size = new System.Drawing.Size(64, 21);
            this.chBaslik.TabIndex = 84;
            this.chBaslik.Text = "Başlık";
            this.chBaslik.UseVisualStyleBackColor = true;
            // 
            // chTur
            // 
            this.chTur.AutoSize = true;
            this.chTur.Location = new System.Drawing.Point(68, 177);
            this.chTur.Name = "chTur";
            this.chTur.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chTur.Size = new System.Drawing.Size(49, 21);
            this.chTur.TabIndex = 85;
            this.chTur.Text = "Tür";
            this.chTur.UseVisualStyleBackColor = true;
            // 
            // chOzet
            // 
            this.chOzet.AutoSize = true;
            this.chOzet.Location = new System.Drawing.Point(60, 207);
            this.chOzet.Name = "chOzet";
            this.chOzet.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chOzet.Size = new System.Drawing.Size(57, 21);
            this.chOzet.TabIndex = 86;
            this.chOzet.Text = "Özet";
            this.chOzet.UseVisualStyleBackColor = true;
            // 
            // chDil
            // 
            this.chDil.AutoSize = true;
            this.chDil.Location = new System.Drawing.Point(74, 290);
            this.chDil.Name = "chDil";
            this.chDil.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chDil.Size = new System.Drawing.Size(43, 21);
            this.chDil.TabIndex = 87;
            this.chDil.Text = "Dil";
            this.chDil.UseVisualStyleBackColor = true;
            // 
            // chAnahtar
            // 
            this.chAnahtar.AutoSize = true;
            this.chAnahtar.Location = new System.Drawing.Point(32, 317);
            this.chAnahtar.Name = "chAnahtar";
            this.chAnahtar.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chAnahtar.Size = new System.Drawing.Size(85, 38);
            this.chAnahtar.TabIndex = 88;
            this.chAnahtar.Text = "Anahtar\r\nKelimeler";
            this.chAnahtar.UseVisualStyleBackColor = true;
            // 
            // chYil
            // 
            this.chYil.AutoSize = true;
            this.chYil.Location = new System.Drawing.Point(123, 396);
            this.chYil.Name = "chYil";
            this.chYil.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chYil.Size = new System.Drawing.Size(42, 21);
            this.chYil.TabIndex = 89;
            this.chYil.Text = "Yıl";
            this.chYil.UseVisualStyleBackColor = true;
            // 
            // chSayfa
            // 
            this.chSayfa.AutoSize = true;
            this.chSayfa.Location = new System.Drawing.Point(252, 396);
            this.chSayfa.Name = "chSayfa";
            this.chSayfa.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chSayfa.Size = new System.Drawing.Size(63, 21);
            this.chSayfa.TabIndex = 90;
            this.chSayfa.Text = "Sayfa";
            this.chSayfa.UseVisualStyleBackColor = true;
            // 
            // chTeslimTarihi
            // 
            this.chTeslimTarihi.AutoSize = true;
            this.chTeslimTarihi.Location = new System.Drawing.Point(9, 454);
            this.chTeslimTarihi.Name = "chTeslimTarihi";
            this.chTeslimTarihi.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.chTeslimTarihi.Size = new System.Drawing.Size(108, 21);
            this.chTeslimTarihi.TabIndex = 91;
            this.chTeslimTarihi.Text = "Teslim Tarihi";
            this.chTeslimTarihi.UseVisualStyleBackColor = true;
            // 
            // Form_TezAra
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(372, 560);
            this.Controls.Add(this.chTeslimTarihi);
            this.Controls.Add(this.chSayfa);
            this.Controls.Add(this.chYil);
            this.Controls.Add(this.chAnahtar);
            this.Controls.Add(this.chDil);
            this.Controls.Add(this.chOzet);
            this.Controls.Add(this.chTur);
            this.Controls.Add(this.chBaslik);
            this.Controls.Add(this.chEnstitu);
            this.Controls.Add(this.chUniversite);
            this.Controls.Add(this.chDanisman);
            this.Controls.Add(this.chYazar);
            this.Controls.Add(this.dtTeslimTarih);
            this.Controls.Add(this.ndSayfa);
            this.Controls.Add(this.cbYil);
            this.Controls.Add(this.txtAnahtarKelime);
            this.Controls.Add(this.cbDil);
            this.Controls.Add(this.txtOzet);
            this.Controls.Add(this.cbTur);
            this.Controls.Add(this.cbBaslik);
            this.Controls.Add(this.cbEnstitu);
            this.Controls.Add(this.cbUniversite);
            this.Controls.Add(this.cbDanisman);
            this.Controls.Add(this.cbYazar);
            this.Controls.Add(this.btn_Ara);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form_TezAra";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Tez Ara";
            this.Load += new System.EventHandler(this.Form_Personel_Load);
            ((System.ComponentModel.ISupportInitialize)(this.ndSayfa)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btn_Ara;
        private System.Windows.Forms.ComboBox cbYazar;
        private System.Windows.Forms.ComboBox cbDanisman;
        private System.Windows.Forms.ComboBox cbUniversite;
        private System.Windows.Forms.ComboBox cbEnstitu;
        private System.Windows.Forms.ComboBox cbBaslik;
        private System.Windows.Forms.ComboBox cbTur;
        private System.Windows.Forms.TextBox txtOzet;
        private System.Windows.Forms.ComboBox cbDil;
        private System.Windows.Forms.TextBox txtAnahtarKelime;
        private System.Windows.Forms.ComboBox cbYil;
        private System.Windows.Forms.NumericUpDown ndSayfa;
        private System.Windows.Forms.DateTimePicker dtTeslimTarih;
        private System.Windows.Forms.CheckBox chYazar;
        private System.Windows.Forms.CheckBox chDanisman;
        private System.Windows.Forms.CheckBox chUniversite;
        private System.Windows.Forms.CheckBox chEnstitu;
        private System.Windows.Forms.CheckBox chBaslik;
        private System.Windows.Forms.CheckBox chTur;
        private System.Windows.Forms.CheckBox chOzet;
        private System.Windows.Forms.CheckBox chDil;
        private System.Windows.Forms.CheckBox chAnahtar;
        private System.Windows.Forms.CheckBox chYil;
        private System.Windows.Forms.CheckBox chSayfa;
        private System.Windows.Forms.CheckBox chTeslimTarihi;
    }
}