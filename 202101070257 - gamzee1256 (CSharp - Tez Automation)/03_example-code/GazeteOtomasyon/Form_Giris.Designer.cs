namespace GazeteOtomasyon
{
    partial class Form_Giris
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
            this.txt_Parola = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txt_KullaniciAd = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.btn_Giris = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txt_Parola
            // 
            this.txt_Parola.BackColor = System.Drawing.Color.DimGray;
            this.txt_Parola.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txt_Parola.ForeColor = System.Drawing.Color.White;
            this.txt_Parola.Location = new System.Drawing.Point(108, 65);
            this.txt_Parola.Margin = new System.Windows.Forms.Padding(4);
            this.txt_Parola.Name = "txt_Parola";
            this.txt_Parola.Size = new System.Drawing.Size(200, 23);
            this.txt_Parola.TabIndex = 57;
            this.txt_Parola.UseSystemPasswordChar = true;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.label3.Location = new System.Drawing.Point(51, 69);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(49, 17);
            this.label3.TabIndex = 59;
            this.label3.Text = "Parola";
            // 
            // txt_KullaniciAd
            // 
            this.txt_KullaniciAd.BackColor = System.Drawing.Color.DimGray;
            this.txt_KullaniciAd.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txt_KullaniciAd.ForeColor = System.Drawing.Color.White;
            this.txt_KullaniciAd.Location = new System.Drawing.Point(108, 34);
            this.txt_KullaniciAd.Margin = new System.Windows.Forms.Padding(4);
            this.txt_KullaniciAd.Name = "txt_KullaniciAd";
            this.txt_KullaniciAd.Size = new System.Drawing.Size(200, 23);
            this.txt_KullaniciAd.TabIndex = 56;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.label2.Location = new System.Drawing.Point(16, 37);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(84, 17);
            this.label2.TabIndex = 58;
            this.label2.Text = "Kullanıcı Adı";
            // 
            // btn_Giris
            // 
            this.btn_Giris.BackColor = System.Drawing.Color.DimGray;
            this.btn_Giris.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btn_Giris.ForeColor = System.Drawing.Color.White;
            this.btn_Giris.Location = new System.Drawing.Point(198, 106);
            this.btn_Giris.Name = "btn_Giris";
            this.btn_Giris.Size = new System.Drawing.Size(110, 36);
            this.btn_Giris.TabIndex = 60;
            this.btn_Giris.Text = "Giriş";
            this.btn_Giris.UseVisualStyleBackColor = false;
            this.btn_Giris.Click += new System.EventHandler(this.btn_Giris_Click);
            // 
            // Form_Giris
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.BackColor = System.Drawing.Color.Black;
            this.ClientSize = new System.Drawing.Size(339, 160);
            this.Controls.Add(this.btn_Giris);
            this.Controls.Add(this.txt_Parola);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txt_KullaniciAd);
            this.Controls.Add(this.label2);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form_Giris";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Giriş";
            this.Load += new System.EventHandler(this.Form_Giris_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txt_Parola;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txt_KullaniciAd;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btn_Giris;
    }
}