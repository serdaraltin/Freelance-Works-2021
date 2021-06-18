namespace AracKiralamaOtomasyon
{
    partial class Form_Kiralama
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
            this.label3 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.cbMusteri = new System.Windows.Forms.ComboBox();
            this.txtTutar = new System.Windows.Forms.MaskedTextBox();
            this.cbArac = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtGun = new System.Windows.Forms.MaskedTextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.btn_Sil = new System.Windows.Forms.Button();
            this.btn_Ekle = new System.Windows.Forms.Button();
            this.dtBaslangic = new System.Windows.Forms.DateTimePicker();
            this.dtBitis = new System.Windows.Forms.DateTimePicker();
            this.label4 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(16, 62);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(54, 17);
            this.label3.TabIndex = 58;
            this.label3.Text = "Müşteri";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(16, 182);
            this.label5.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(42, 17);
            this.label5.TabIndex = 62;
            this.label5.Text = "Tutar";
            // 
            // cbMusteri
            // 
            this.cbMusteri.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbMusteri.FormattingEnabled = true;
            this.cbMusteri.Location = new System.Drawing.Point(105, 58);
            this.cbMusteri.Name = "cbMusteri";
            this.cbMusteri.Size = new System.Drawing.Size(208, 24);
            this.cbMusteri.TabIndex = 2;
            this.cbMusteri.SelectedIndexChanged += new System.EventHandler(this.cbYil_SelectedIndexChanged);
            // 
            // txtTutar
            // 
            this.txtTutar.Location = new System.Drawing.Point(105, 179);
            this.txtTutar.Mask = "00000";
            this.txtTutar.Name = "txtTutar";
            this.txtTutar.ReadOnly = true;
            this.txtTutar.Size = new System.Drawing.Size(108, 23);
            this.txtTutar.TabIndex = 4;
            // 
            // cbArac
            // 
            this.cbArac.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbArac.FormattingEnabled = true;
            this.cbArac.Location = new System.Drawing.Point(105, 28);
            this.cbArac.Name = "cbArac";
            this.cbArac.Size = new System.Drawing.Size(208, 24);
            this.cbArac.TabIndex = 63;
            this.cbArac.SelectedIndexChanged += new System.EventHandler(this.cbArac_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 32);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(37, 17);
            this.label1.TabIndex = 64;
            this.label1.Text = "Araç";
            // 
            // txtGun
            // 
            this.txtGun.Location = new System.Drawing.Point(105, 146);
            this.txtGun.Name = "txtGun";
            this.txtGun.ReadOnly = true;
            this.txtGun.Size = new System.Drawing.Size(108, 23);
            this.txtGun.TabIndex = 65;
            this.txtGun.TextChanged += new System.EventHandler(this.txtGun_TextChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 149);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(35, 17);
            this.label2.TabIndex = 66;
            this.label2.Text = "Gün";
            // 
            // btn_Sil
            // 
            this.btn_Sil.BackColor = System.Drawing.Color.Peru;
            this.btn_Sil.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Sil.ForeColor = System.Drawing.Color.White;
            this.btn_Sil.Image = global::AracKiralamaOtomasyon.Properties.Resources.Delete_32x32;
            this.btn_Sil.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btn_Sil.Location = new System.Drawing.Point(221, 227);
            this.btn_Sil.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Sil.Name = "btn_Sil";
            this.btn_Sil.Size = new System.Drawing.Size(92, 46);
            this.btn_Sil.TabIndex = 68;
            this.btn_Sil.Text = "SİL";
            this.btn_Sil.UseVisualStyleBackColor = false;
            this.btn_Sil.Visible = false;
            this.btn_Sil.Click += new System.EventHandler(this.btn_Sil_Click);
            // 
            // btn_Ekle
            // 
            this.btn_Ekle.BackColor = System.Drawing.Color.Yellow;
            this.btn_Ekle.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Ekle.Image = global::AracKiralamaOtomasyon.Properties.Resources.Save_32x32;
            this.btn_Ekle.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btn_Ekle.Location = new System.Drawing.Point(84, 227);
            this.btn_Ekle.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Ekle.Name = "btn_Ekle";
            this.btn_Ekle.Size = new System.Drawing.Size(129, 46);
            this.btn_Ekle.TabIndex = 67;
            this.btn_Ekle.Text = "EKLE";
            this.btn_Ekle.UseVisualStyleBackColor = false;
            this.btn_Ekle.Click += new System.EventHandler(this.btn_Ekle_Click);
            // 
            // dtBaslangic
            // 
            this.dtBaslangic.Location = new System.Drawing.Point(105, 88);
            this.dtBaslangic.Name = "dtBaslangic";
            this.dtBaslangic.Size = new System.Drawing.Size(208, 23);
            this.dtBaslangic.TabIndex = 69;
            this.dtBaslangic.ValueChanged += new System.EventHandler(this.dtBaslangic_ValueChanged);
            // 
            // dtBitis
            // 
            this.dtBitis.Location = new System.Drawing.Point(105, 117);
            this.dtBitis.Name = "dtBitis";
            this.dtBitis.Size = new System.Drawing.Size(208, 23);
            this.dtBitis.TabIndex = 70;
            this.dtBitis.ValueChanged += new System.EventHandler(this.dtBitis_ValueChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(16, 93);
            this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(69, 17);
            this.label4.TabIndex = 71;
            this.label4.Text = "Başlangıç";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(16, 122);
            this.label6.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(34, 17);
            this.label6.TabIndex = 72;
            this.label6.Text = "Bitiş";
            // 
            // Form_Kiralama
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Aqua;
            this.ClientSize = new System.Drawing.Size(332, 291);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.dtBitis);
            this.Controls.Add(this.dtBaslangic);
            this.Controls.Add(this.btn_Sil);
            this.Controls.Add(this.btn_Ekle);
            this.Controls.Add(this.txtGun);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.cbArac);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtTutar);
            this.Controls.Add(this.cbMusteri);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label3);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form_Kiralama";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Kiralama";
            this.Load += new System.EventHandler(this.Form_Personel_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ComboBox cbMusteri;
        private System.Windows.Forms.MaskedTextBox txtTutar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.MaskedTextBox txtGun;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox cbArac;
        private System.Windows.Forms.Button btn_Sil;
        private System.Windows.Forms.Button btn_Ekle;
        private System.Windows.Forms.DateTimePicker dtBaslangic;
        private System.Windows.Forms.DateTimePicker dtBitis;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label6;
    }
}