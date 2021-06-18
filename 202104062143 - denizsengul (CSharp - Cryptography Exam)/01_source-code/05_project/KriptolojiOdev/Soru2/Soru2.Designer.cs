namespace Soru2
{
    partial class Soru2
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
            this.label1 = new System.Windows.Forms.Label();
            this.txtSifrelenecekMetin = new System.Windows.Forms.TextBox();
            this.txtSifrelenmisMetin = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.ndAnahtar = new System.Windows.Forms.NumericUpDown();
            this.label3 = new System.Windows.Forms.Label();
            this.btnSifrele = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.ndAnahtar)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(11, 15);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(118, 16);
            this.label1.TabIndex = 0;
            this.label1.Text = "Şifrelenecek Metin";
            // 
            // txtSifrelenecekMetin
            // 
            this.txtSifrelenecekMetin.Location = new System.Drawing.Point(14, 34);
            this.txtSifrelenecekMetin.Multiline = true;
            this.txtSifrelenecekMetin.Name = "txtSifrelenecekMetin";
            this.txtSifrelenecekMetin.Size = new System.Drawing.Size(385, 77);
            this.txtSifrelenecekMetin.TabIndex = 1;
            // 
            // txtSifrelenmisMetin
            // 
            this.txtSifrelenmisMetin.Location = new System.Drawing.Point(14, 149);
            this.txtSifrelenmisMetin.Multiline = true;
            this.txtSifrelenmisMetin.Name = "txtSifrelenmisMetin";
            this.txtSifrelenmisMetin.ReadOnly = true;
            this.txtSifrelenmisMetin.Size = new System.Drawing.Size(385, 77);
            this.txtSifrelenmisMetin.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(11, 130);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(109, 16);
            this.label2.TabIndex = 2;
            this.label2.Text = "Şifrelenmiş Metin";
            // 
            // ndAnahtar
            // 
            this.ndAnahtar.Location = new System.Drawing.Point(488, 34);
            this.ndAnahtar.Maximum = new decimal(new int[] {
            29,
            0,
            0,
            0});
            this.ndAnahtar.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.ndAnahtar.Name = "ndAnahtar";
            this.ndAnahtar.Size = new System.Drawing.Size(70, 22);
            this.ndAnahtar.TabIndex = 4;
            this.ndAnahtar.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.ndAnahtar.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(427, 36);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(54, 16);
            this.label3.TabIndex = 5;
            this.label3.Text = "Anahtar";
            // 
            // btnSifrele
            // 
            this.btnSifrele.Location = new System.Drawing.Point(430, 71);
            this.btnSifrele.Name = "btnSifrele";
            this.btnSifrele.Size = new System.Drawing.Size(128, 40);
            this.btnSifrele.TabIndex = 6;
            this.btnSifrele.Text = "ŞİFRELE";
            this.btnSifrele.UseVisualStyleBackColor = true;
            this.btnSifrele.Click += new System.EventHandler(this.btnSifrele_Click);
            // 
            // Soru2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(583, 244);
            this.Controls.Add(this.btnSifrele);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.ndAnahtar);
            this.Controls.Add(this.txtSifrelenmisMetin);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtSifrelenecekMetin);
            this.Controls.Add(this.label1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.MaximizeBox = false;
            this.Name = "Soru2";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.ndAnahtar)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtSifrelenecekMetin;
        private System.Windows.Forms.TextBox txtSifrelenmisMetin;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.NumericUpDown ndAnahtar;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnSifrele;
    }
}

