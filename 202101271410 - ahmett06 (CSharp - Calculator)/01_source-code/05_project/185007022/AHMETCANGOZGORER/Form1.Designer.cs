namespace AHMETCANGOZGORER
{
    partial class Form1
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
            this.ndAltSinir = new System.Windows.Forms.NumericUpDown();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.ndUstSinir = new System.Windows.Forms.NumericUpDown();
            this.label3 = new System.Windows.Forms.Label();
            this.ndArtisMiktar = new System.Windows.Forms.NumericUpDown();
            this.btnHesapla = new System.Windows.Forms.Button();
            this.rdFor = new System.Windows.Forms.RadioButton();
            this.rdWhile = new System.Windows.Forms.RadioButton();
            this.rdDoWhile = new System.Windows.Forms.RadioButton();
            this.txtSonuc = new System.Windows.Forms.TextBox();
            this.lbSonuc = new System.Windows.Forms.Label();
            this.lbTekrarAdet = new System.Windows.Forms.Label();
            this.pgTekrarAdet = new System.Windows.Forms.ProgressBar();
            ((System.ComponentModel.ISupportInitialize)(this.ndAltSinir)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.ndUstSinir)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.ndArtisMiktar)).BeginInit();
            this.SuspendLayout();
            // 
            // ndAltSinir
            // 
            this.ndAltSinir.Location = new System.Drawing.Point(15, 35);
            this.ndAltSinir.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.ndAltSinir.Maximum = new decimal(new int[] {
            50,
            0,
            0,
            0});
            this.ndAltSinir.Name = "ndAltSinir";
            this.ndAltSinir.Size = new System.Drawing.Size(77, 26);
            this.ndAltSinir.TabIndex = 0;
            this.ndAltSinir.Value = new decimal(new int[] {
            5,
            0,
            0,
            0});
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(18, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(64, 19);
            this.label1.TabIndex = 1;
            this.label1.Text = "Alt Sınır";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(113, 12);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(67, 19);
            this.label2.TabIndex = 3;
            this.label2.Text = "Üst Sınır";
            // 
            // ndUstSinir
            // 
            this.ndUstSinir.Location = new System.Drawing.Point(110, 35);
            this.ndUstSinir.Margin = new System.Windows.Forms.Padding(4);
            this.ndUstSinir.Maximum = new decimal(new int[] {
            50,
            0,
            0,
            0});
            this.ndUstSinir.Name = "ndUstSinir";
            this.ndUstSinir.Size = new System.Drawing.Size(77, 26);
            this.ndUstSinir.TabIndex = 2;
            this.ndUstSinir.Value = new decimal(new int[] {
            5,
            0,
            0,
            0});
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(208, 12);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(98, 19);
            this.label3.TabIndex = 5;
            this.label3.Text = "Artış Miktarı";
            // 
            // ndArtisMiktar
            // 
            this.ndArtisMiktar.Location = new System.Drawing.Point(205, 35);
            this.ndArtisMiktar.Margin = new System.Windows.Forms.Padding(4);
            this.ndArtisMiktar.Maximum = new decimal(new int[] {
            50,
            0,
            0,
            0});
            this.ndArtisMiktar.Name = "ndArtisMiktar";
            this.ndArtisMiktar.Size = new System.Drawing.Size(77, 26);
            this.ndArtisMiktar.TabIndex = 4;
            this.ndArtisMiktar.Value = new decimal(new int[] {
            5,
            0,
            0,
            0});
            // 
            // btnHesapla
            // 
            this.btnHesapla.Location = new System.Drawing.Point(242, 68);
            this.btnHesapla.Name = "btnHesapla";
            this.btnHesapla.Size = new System.Drawing.Size(85, 30);
            this.btnHesapla.TabIndex = 6;
            this.btnHesapla.Text = "Hesapla";
            this.btnHesapla.UseVisualStyleBackColor = true;
            this.btnHesapla.Click += new System.EventHandler(this.btnHesapla_Click);
            // 
            // rdFor
            // 
            this.rdFor.AutoSize = true;
            this.rdFor.Checked = true;
            this.rdFor.Location = new System.Drawing.Point(15, 72);
            this.rdFor.Name = "rdFor";
            this.rdFor.Size = new System.Drawing.Size(175, 23);
            this.rdFor.TabIndex = 7;
            this.rdFor.TabStop = true;
            this.rdFor.Text = "For ile Ardışık Toplam";
            this.rdFor.UseVisualStyleBackColor = true;
            // 
            // rdWhile
            // 
            this.rdWhile.AutoSize = true;
            this.rdWhile.Location = new System.Drawing.Point(15, 101);
            this.rdWhile.Name = "rdWhile";
            this.rdWhile.Size = new System.Drawing.Size(195, 23);
            this.rdWhile.TabIndex = 8;
            this.rdWhile.TabStop = true;
            this.rdWhile.Text = "While ile Ardışık Çarpımı";
            this.rdWhile.UseVisualStyleBackColor = true;
            // 
            // rdDoWhile
            // 
            this.rdDoWhile.AutoSize = true;
            this.rdDoWhile.Location = new System.Drawing.Point(15, 130);
            this.rdDoWhile.Name = "rdDoWhile";
            this.rdDoWhile.Size = new System.Drawing.Size(211, 23);
            this.rdDoWhile.TabIndex = 9;
            this.rdDoWhile.TabStop = true;
            this.rdDoWhile.Text = "Do while ile kareler toplamı";
            this.rdDoWhile.UseVisualStyleBackColor = true;
            // 
            // txtSonuc
            // 
            this.txtSonuc.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.txtSonuc.Location = new System.Drawing.Point(15, 190);
            this.txtSonuc.Name = "txtSonuc";
            this.txtSonuc.ReadOnly = true;
            this.txtSonuc.Size = new System.Drawing.Size(312, 26);
            this.txtSonuc.TabIndex = 10;
            this.txtSonuc.Text = "İşlem sonucu";
            // 
            // lbSonuc
            // 
            this.lbSonuc.AutoSize = true;
            this.lbSonuc.Location = new System.Drawing.Point(18, 168);
            this.lbSonuc.Name = "lbSonuc";
            this.lbSonuc.Size = new System.Drawing.Size(49, 19);
            this.lbSonuc.TabIndex = 11;
            this.lbSonuc.Text = "Sonuç";
            // 
            // lbTekrarAdet
            // 
            this.lbTekrarAdet.AutoSize = true;
            this.lbTekrarAdet.Location = new System.Drawing.Point(18, 220);
            this.lbTekrarAdet.Name = "lbTekrarAdet";
            this.lbTekrarAdet.Size = new System.Drawing.Size(106, 19);
            this.lbTekrarAdet.TabIndex = 12;
            this.lbTekrarAdet.Text = "Tekrar Adedi :";
            // 
            // pgTekrarAdet
            // 
            this.pgTekrarAdet.Location = new System.Drawing.Point(15, 242);
            this.pgTekrarAdet.Maximum = 50;
            this.pgTekrarAdet.Name = "pgTekrarAdet";
            this.pgTekrarAdet.Size = new System.Drawing.Size(312, 23);
            this.pgTekrarAdet.TabIndex = 13;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 19F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(340, 276);
            this.Controls.Add(this.pgTekrarAdet);
            this.Controls.Add(this.lbTekrarAdet);
            this.Controls.Add(this.lbSonuc);
            this.Controls.Add(this.txtSonuc);
            this.Controls.Add(this.rdDoWhile);
            this.Controls.Add(this.rdWhile);
            this.Controls.Add(this.rdFor);
            this.Controls.Add(this.btnHesapla);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.ndArtisMiktar);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.ndUstSinir);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.ndAltSinir);
            this.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "              ";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.ndAltSinir)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.ndUstSinir)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.ndArtisMiktar)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.NumericUpDown ndAltSinir;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.NumericUpDown ndUstSinir;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.NumericUpDown ndArtisMiktar;
        private System.Windows.Forms.Button btnHesapla;
        private System.Windows.Forms.RadioButton rdFor;
        private System.Windows.Forms.RadioButton rdWhile;
        private System.Windows.Forms.RadioButton rdDoWhile;
        private System.Windows.Forms.TextBox txtSonuc;
        private System.Windows.Forms.Label lbSonuc;
        private System.Windows.Forms.Label lbTekrarAdet;
        private System.Windows.Forms.ProgressBar pgTekrarAdet;
    }
}

