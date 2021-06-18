namespace CafeOtomasyon
{
    partial class Form_Siparis
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_Siparis));
            this.btn_Sil = new System.Windows.Forms.Button();
            this.btn_Ekle = new System.Windows.Forms.Button();
            this.txtSiparisler = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.txtTutar = new System.Windows.Forms.MaskedTextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtTarih = new System.Windows.Forms.MaskedTextBox();
            this.cbPersonel = new System.Windows.Forms.ComboBox();
            this.cbMasa = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btn_Sil
            // 
            this.btn_Sil.BackColor = System.Drawing.Color.WhiteSmoke;
            this.btn_Sil.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Sil.Location = new System.Drawing.Point(222, 264);
            this.btn_Sil.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Sil.Name = "btn_Sil";
            this.btn_Sil.Size = new System.Drawing.Size(91, 46);
            this.btn_Sil.TabIndex = 9;
            this.btn_Sil.Text = "SİL";
            this.btn_Sil.UseVisualStyleBackColor = false;
            this.btn_Sil.Visible = false;
            this.btn_Sil.Click += new System.EventHandler(this.btn_Sil_Click);
            // 
            // btn_Ekle
            // 
            this.btn_Ekle.BackColor = System.Drawing.Color.WhiteSmoke;
            this.btn_Ekle.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Ekle.Location = new System.Drawing.Point(105, 264);
            this.btn_Ekle.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Ekle.Name = "btn_Ekle";
            this.btn_Ekle.Size = new System.Drawing.Size(108, 46);
            this.btn_Ekle.TabIndex = 8;
            this.btn_Ekle.Text = "EKLE";
            this.btn_Ekle.UseVisualStyleBackColor = false;
            this.btn_Ekle.Click += new System.EventHandler(this.btn_Ekle_Click);
            // 
            // txtSiparisler
            // 
            this.txtSiparisler.BackColor = System.Drawing.Color.WhiteSmoke;
            this.txtSiparisler.Location = new System.Drawing.Point(105, 101);
            this.txtSiparisler.Margin = new System.Windows.Forms.Padding(4);
            this.txtSiparisler.Multiline = true;
            this.txtSiparisler.Name = "txtSiparisler";
            this.txtSiparisler.Size = new System.Drawing.Size(208, 81);
            this.txtSiparisler.TabIndex = 5;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.BackColor = System.Drawing.Color.Transparent;
            this.label5.Location = new System.Drawing.Point(16, 104);
            this.label5.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(67, 17);
            this.label5.TabIndex = 64;
            this.label5.Text = "Siparişler";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.BackColor = System.Drawing.Color.Transparent;
            this.label6.ForeColor = System.Drawing.Color.White;
            this.label6.Location = new System.Drawing.Point(16, 73);
            this.label6.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(64, 17);
            this.label6.TabIndex = 63;
            this.label6.Text = "Personel";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.BackColor = System.Drawing.Color.Transparent;
            this.label7.Location = new System.Drawing.Point(16, 193);
            this.label7.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(42, 17);
            this.label7.TabIndex = 66;
            this.label7.Text = "Tutar";
            // 
            // txtTutar
            // 
            this.txtTutar.BackColor = System.Drawing.Color.WhiteSmoke;
            this.txtTutar.Location = new System.Drawing.Point(105, 190);
            this.txtTutar.Mask = "00000";
            this.txtTutar.Name = "txtTutar";
            this.txtTutar.Size = new System.Drawing.Size(100, 23);
            this.txtTutar.TabIndex = 6;
            this.txtTutar.ValidatingType = typeof(int);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Location = new System.Drawing.Point(16, 225);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(75, 17);
            this.label1.TabIndex = 68;
            this.label1.Text = "Tarih-Saat";
            // 
            // txtTarih
            // 
            this.txtTarih.BackColor = System.Drawing.Color.WhiteSmoke;
            this.txtTarih.Location = new System.Drawing.Point(105, 219);
            this.txtTarih.Mask = "00/00/0000 90:00";
            this.txtTarih.Name = "txtTarih";
            this.txtTarih.Size = new System.Drawing.Size(208, 23);
            this.txtTarih.TabIndex = 7;
            this.txtTarih.ValidatingType = typeof(System.DateTime);
            // 
            // cbPersonel
            // 
            this.cbPersonel.BackColor = System.Drawing.Color.WhiteSmoke;
            this.cbPersonel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cbPersonel.FormattingEnabled = true;
            this.cbPersonel.Location = new System.Drawing.Point(105, 70);
            this.cbPersonel.Name = "cbPersonel";
            this.cbPersonel.Size = new System.Drawing.Size(208, 24);
            this.cbPersonel.TabIndex = 70;
            // 
            // cbMasa
            // 
            this.cbMasa.BackColor = System.Drawing.Color.WhiteSmoke;
            this.cbMasa.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cbMasa.FormattingEnabled = true;
            this.cbMasa.Location = new System.Drawing.Point(105, 40);
            this.cbMasa.Name = "cbMasa";
            this.cbMasa.Size = new System.Drawing.Size(208, 24);
            this.cbMasa.TabIndex = 72;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.Color.Transparent;
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(16, 43);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(64, 17);
            this.label2.TabIndex = 71;
            this.label2.Text = "Masa No";
            // 
            // Form_Siparis
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(340, 513);
            this.Controls.Add(this.cbMasa);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.cbPersonel);
            this.Controls.Add(this.txtTarih);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtTutar);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.txtSiparisler);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.btn_Sil);
            this.Controls.Add(this.btn_Ekle);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form_Siparis";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Sipariş";
            this.Load += new System.EventHandler(this.Form_Personel_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btn_Sil;
        private System.Windows.Forms.Button btn_Ekle;
        private System.Windows.Forms.TextBox txtSiparisler;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.MaskedTextBox txtTutar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.MaskedTextBox txtTarih;
        private System.Windows.Forms.ComboBox cbPersonel;
        private System.Windows.Forms.ComboBox cbMasa;
        private System.Windows.Forms.Label label2;
    }
}