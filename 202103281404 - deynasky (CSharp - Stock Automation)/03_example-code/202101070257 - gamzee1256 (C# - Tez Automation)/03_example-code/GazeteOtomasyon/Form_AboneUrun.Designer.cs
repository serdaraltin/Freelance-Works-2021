namespace GazeteOtomasyon
{
    partial class Form_AboneUrun
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
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.cb_Abone = new System.Windows.Forms.ComboBox();
            this.cb_Urun = new System.Windows.Forms.ComboBox();
            this.dt_BaslangicTarih = new System.Windows.Forms.DateTimePicker();
            this.dt_BitisTarih = new System.Windows.Forms.DateTimePicker();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.cb_Durum = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // btn_Sil
            // 
            this.btn_Sil.Location = new System.Drawing.Point(198, 184);
            this.btn_Sil.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Sil.Name = "btn_Sil";
            this.btn_Sil.Size = new System.Drawing.Size(91, 46);
            this.btn_Sil.TabIndex = 6;
            this.btn_Sil.Text = "SİL";
            this.btn_Sil.UseVisualStyleBackColor = true;
            this.btn_Sil.Visible = false;
            this.btn_Sil.Click += new System.EventHandler(this.btn_Sil_Click);
            // 
            // btn_Ekle
            // 
            this.btn_Ekle.Location = new System.Drawing.Point(61, 184);
            this.btn_Ekle.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Ekle.Name = "btn_Ekle";
            this.btn_Ekle.Size = new System.Drawing.Size(129, 46);
            this.btn_Ekle.TabIndex = 5;
            this.btn_Ekle.Text = "EKLE";
            this.btn_Ekle.UseVisualStyleBackColor = true;
            this.btn_Ekle.Click += new System.EventHandler(this.btn_Ekle_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 88);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(69, 17);
            this.label3.TabIndex = 55;
            this.label3.Text = "Başlangıç";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(42, 57);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(39, 17);
            this.label2.TabIndex = 54;
            this.label2.Text = "Ürün";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(35, 27);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(49, 17);
            this.label1.TabIndex = 53;
            this.label1.Text = "Abone";
            // 
            // cb_Abone
            // 
            this.cb_Abone.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cb_Abone.FormattingEnabled = true;
            this.cb_Abone.Location = new System.Drawing.Point(88, 24);
            this.cb_Abone.Name = "cb_Abone";
            this.cb_Abone.Size = new System.Drawing.Size(201, 24);
            this.cb_Abone.TabIndex = 0;
            // 
            // cb_Urun
            // 
            this.cb_Urun.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cb_Urun.FormattingEnabled = true;
            this.cb_Urun.Location = new System.Drawing.Point(88, 54);
            this.cb_Urun.Name = "cb_Urun";
            this.cb_Urun.Size = new System.Drawing.Size(201, 24);
            this.cb_Urun.TabIndex = 1;
            // 
            // dt_BaslangicTarih
            // 
            this.dt_BaslangicTarih.Location = new System.Drawing.Point(88, 85);
            this.dt_BaslangicTarih.Name = "dt_BaslangicTarih";
            this.dt_BaslangicTarih.Size = new System.Drawing.Size(201, 23);
            this.dt_BaslangicTarih.TabIndex = 2;
            // 
            // dt_BitisTarih
            // 
            this.dt_BitisTarih.Location = new System.Drawing.Point(88, 114);
            this.dt_BitisTarih.Name = "dt_BitisTarih";
            this.dt_BitisTarih.Size = new System.Drawing.Size(201, 23);
            this.dt_BitisTarih.TabIndex = 3;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(47, 118);
            this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(34, 17);
            this.label4.TabIndex = 59;
            this.label4.Text = "Bitiş";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(31, 146);
            this.label5.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(50, 17);
            this.label5.TabIndex = 61;
            this.label5.Text = "Durum";
            // 
            // cb_Durum
            // 
            this.cb_Durum.FormattingEnabled = true;
            this.cb_Durum.Items.AddRange(new object[] {
            "Devam",
            "Bitti"});
            this.cb_Durum.Location = new System.Drawing.Point(88, 143);
            this.cb_Durum.Name = "cb_Durum";
            this.cb_Durum.Size = new System.Drawing.Size(201, 24);
            this.cb_Durum.TabIndex = 4;
            // 
            // Form_AboneUrun
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(319, 251);
            this.Controls.Add(this.cb_Durum);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.dt_BitisTarih);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.dt_BaslangicTarih);
            this.Controls.Add(this.cb_Urun);
            this.Controls.Add(this.cb_Abone);
            this.Controls.Add(this.btn_Sil);
            this.Controls.Add(this.btn_Ekle);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form_AboneUrun";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Abone Ürün";
            this.Load += new System.EventHandler(this.Form_Personel_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btn_Sil;
        private System.Windows.Forms.Button btn_Ekle;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cb_Abone;
        private System.Windows.Forms.ComboBox cb_Urun;
        private System.Windows.Forms.DateTimePicker dt_BaslangicTarih;
        private System.Windows.Forms.DateTimePicker dt_BitisTarih;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ComboBox cb_Durum;
    }
}