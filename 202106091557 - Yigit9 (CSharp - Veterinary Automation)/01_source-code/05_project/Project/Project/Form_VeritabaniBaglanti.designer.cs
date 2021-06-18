namespace Project
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
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(18, 36);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(52, 16);
            this.label1.TabIndex = 0;
            this.label1.Text = "Sunucu";
            // 
            // txt_Sunucu
            // 
            this.txt_Sunucu.BackColor = System.Drawing.Color.White;
            this.txt_Sunucu.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txt_Sunucu.ForeColor = System.Drawing.Color.Black;
            this.txt_Sunucu.Location = new System.Drawing.Point(98, 33);
            this.txt_Sunucu.Margin = new System.Windows.Forms.Padding(4);
            this.txt_Sunucu.Name = "txt_Sunucu";
            this.txt_Sunucu.Size = new System.Drawing.Size(259, 22);
            this.txt_Sunucu.TabIndex = 0;
            // 
            // txt_Veritabani
            // 
            this.txt_Veritabani.BackColor = System.Drawing.Color.White;
            this.txt_Veritabani.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txt_Veritabani.ForeColor = System.Drawing.Color.Black;
            this.txt_Veritabani.Location = new System.Drawing.Point(98, 65);
            this.txt_Veritabani.Margin = new System.Windows.Forms.Padding(4);
            this.txt_Veritabani.Name = "txt_Veritabani";
            this.txt_Veritabani.Size = new System.Drawing.Size(259, 22);
            this.txt_Veritabani.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.Color.Transparent;
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(18, 68);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(69, 16);
            this.label2.TabIndex = 2;
            this.label2.Text = "Veritabani";
            // 
            // btn_Test
            // 
            this.btn_Test.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.btn_Test.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Test.ForeColor = System.Drawing.Color.Black;
            this.btn_Test.Location = new System.Drawing.Point(98, 118);
            this.btn_Test.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Test.Name = "btn_Test";
            this.btn_Test.Size = new System.Drawing.Size(116, 37);
            this.btn_Test.TabIndex = 2;
            this.btn_Test.Text = "Test";
            this.btn_Test.UseVisualStyleBackColor = false;
            this.btn_Test.Click += new System.EventHandler(this.btn_Test_Click);
            // 
            // btn_Kayit
            // 
            this.btn_Kayit.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.btn_Kayit.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Kayit.ForeColor = System.Drawing.Color.Black;
            this.btn_Kayit.Location = new System.Drawing.Point(222, 118);
            this.btn_Kayit.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Kayit.Name = "btn_Kayit";
            this.btn_Kayit.Size = new System.Drawing.Size(136, 37);
            this.btn_Kayit.TabIndex = 3;
            this.btn_Kayit.Text = "Kaydet";
            this.btn_Kayit.UseVisualStyleBackColor = false;
            this.btn_Kayit.Click += new System.EventHandler(this.btn_Kayit_Click);
            // 
            // Form_VeritabaniBaglanti
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(399, 184);
            this.Controls.Add(this.btn_Kayit);
            this.Controls.Add(this.btn_Test);
            this.Controls.Add(this.txt_Veritabani);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txt_Sunucu);
            this.Controls.Add(this.label1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(4);
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
    }
}