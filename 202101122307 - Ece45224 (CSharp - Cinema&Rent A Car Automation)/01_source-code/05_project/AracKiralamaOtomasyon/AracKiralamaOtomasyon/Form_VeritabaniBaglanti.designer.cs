namespace AracKiralamaOtomasyon
{
    partial class Form_VeritabaniBaglanti
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
            this.txt_Sunucu = new System.Windows.Forms.TextBox();
            this.txt_Veritabani = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.btn_Test = new System.Windows.Forms.Button();
            this.btn_Kayit = new System.Windows.Forms.Button();
            this.txtKullanici = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtParola = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(25, 41);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(44, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Sunucu";
            // 
            // txt_Sunucu
            // 
            this.txt_Sunucu.Location = new System.Drawing.Point(85, 38);
            this.txt_Sunucu.Name = "txt_Sunucu";
            this.txt_Sunucu.Size = new System.Drawing.Size(195, 20);
            this.txt_Sunucu.TabIndex = 0;
            // 
            // txt_Veritabani
            // 
            this.txt_Veritabani.Location = new System.Drawing.Point(85, 64);
            this.txt_Veritabani.Name = "txt_Veritabani";
            this.txt_Veritabani.Size = new System.Drawing.Size(195, 20);
            this.txt_Veritabani.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(25, 67);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(54, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Veritabanı";
            // 
            // btn_Test
            // 
            this.btn_Test.Location = new System.Drawing.Point(85, 155);
            this.btn_Test.Name = "btn_Test";
            this.btn_Test.Size = new System.Drawing.Size(87, 30);
            this.btn_Test.TabIndex = 4;
            this.btn_Test.Text = "Test";
            this.btn_Test.UseVisualStyleBackColor = true;
            this.btn_Test.Click += new System.EventHandler(this.btn_Test_Click);
            // 
            // btn_Kayit
            // 
            this.btn_Kayit.Location = new System.Drawing.Point(178, 155);
            this.btn_Kayit.Name = "btn_Kayit";
            this.btn_Kayit.Size = new System.Drawing.Size(102, 30);
            this.btn_Kayit.TabIndex = 5;
            this.btn_Kayit.Text = "Kayıt";
            this.btn_Kayit.UseVisualStyleBackColor = true;
            this.btn_Kayit.Click += new System.EventHandler(this.btn_Kayit_Click);
            // 
            // txtKullanici
            // 
            this.txtKullanici.Location = new System.Drawing.Point(85, 90);
            this.txtKullanici.Name = "txtKullanici";
            this.txtKullanici.Size = new System.Drawing.Size(195, 20);
            this.txtKullanici.TabIndex = 2;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(25, 93);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(46, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Kullanıcı";
            // 
            // txtParola
            // 
            this.txtParola.Location = new System.Drawing.Point(85, 116);
            this.txtParola.Name = "txtParola";
            this.txtParola.Size = new System.Drawing.Size(195, 20);
            this.txtParola.TabIndex = 3;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(25, 119);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(37, 13);
            this.label4.TabIndex = 7;
            this.label4.Text = "Parola";
            // 
            // Form_VeritabaniBaglanti
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.ClientSize = new System.Drawing.Size(325, 202);
            this.Controls.Add(this.txtParola);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.txtKullanici);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.btn_Kayit);
            this.Controls.Add(this.btn_Test);
            this.Controls.Add(this.txt_Veritabani);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txt_Sunucu);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "Form_VeritabaniBaglanti";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Veritabanı Bağlantı";
            this.Load += new System.EventHandler(this.Form_VeritabaniBaglanti_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txt_Sunucu;
        private System.Windows.Forms.TextBox txt_Veritabani;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btn_Test;
        private System.Windows.Forms.Button btn_Kayit;
        private System.Windows.Forms.TextBox txtKullanici;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtParola;
        private System.Windows.Forms.Label label4;
    }
}