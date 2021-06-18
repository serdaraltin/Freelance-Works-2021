namespace Soru1
{
    partial class Soru1
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
            this.txtAcikMetin = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.btnSifrele = new System.Windows.Forms.Button();
            this.txtSifreliDizin = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtAcikMetinBit = new System.Windows.Forms.TextBox();
            this.txtSifreDizini = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(17, 33);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(69, 16);
            this.label1.TabIndex = 0;
            this.label1.Text = "Açık Metin";
            // 
            // txtAcikMetin
            // 
            this.txtAcikMetin.Location = new System.Drawing.Point(94, 30);
            this.txtAcikMetin.Margin = new System.Windows.Forms.Padding(4);
            this.txtAcikMetin.Name = "txtAcikMetin";
            this.txtAcikMetin.Size = new System.Drawing.Size(218, 22);
            this.txtAcikMetin.TabIndex = 0;
            this.txtAcikMetin.TextChanged += new System.EventHandler(this.txtAcikMetin_TextChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(17, 106);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(70, 16);
            this.label2.TabIndex = 2;
            this.label2.Text = "Şifre Dizini";
            // 
            // btnSifrele
            // 
            this.btnSifrele.Location = new System.Drawing.Point(319, 98);
            this.btnSifrele.Name = "btnSifrele";
            this.btnSifrele.Size = new System.Drawing.Size(107, 32);
            this.btnSifrele.TabIndex = 3;
            this.btnSifrele.Text = "Şifrele";
            this.btnSifrele.UseVisualStyleBackColor = true;
            this.btnSifrele.Click += new System.EventHandler(this.btnSifrele_Click);
            // 
            // txtSifreliDizin
            // 
            this.txtSifreliDizin.Location = new System.Drawing.Point(94, 158);
            this.txtSifreliDizin.Margin = new System.Windows.Forms.Padding(4);
            this.txtSifreliDizin.Name = "txtSifreliDizin";
            this.txtSifreliDizin.ReadOnly = true;
            this.txtSifreliDizin.Size = new System.Drawing.Size(377, 22);
            this.txtSifreliDizin.TabIndex = 4;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(17, 161);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(73, 16);
            this.label3.TabIndex = 5;
            this.label3.Text = "Şifreli Dizin";
            // 
            // txtAcikMetinBit
            // 
            this.txtAcikMetinBit.Location = new System.Drawing.Point(94, 60);
            this.txtAcikMetinBit.Margin = new System.Windows.Forms.Padding(4);
            this.txtAcikMetinBit.Name = "txtAcikMetinBit";
            this.txtAcikMetinBit.ReadOnly = true;
            this.txtAcikMetinBit.Size = new System.Drawing.Size(377, 22);
            this.txtAcikMetinBit.TabIndex = 1;
            // 
            // txtSifreDizini
            // 
            this.txtSifreDizini.Location = new System.Drawing.Point(94, 103);
            this.txtSifreDizini.Name = "txtSifreDizini";
            this.txtSifreDizini.Size = new System.Drawing.Size(219, 22);
            this.txtSifreDizini.TabIndex = 2;
            this.txtSifreDizini.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtSifreDizini_KeyPress);
            // 
            // Soru1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(497, 199);
            this.Controls.Add(this.txtSifreDizini);
            this.Controls.Add(this.txtAcikMetinBit);
            this.Controls.Add(this.txtSifreliDizin);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.btnSifrele);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtAcikMetin);
            this.Controls.Add(this.label1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MaximizeBox = false;
            this.Name = "Soru1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Soru 1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtAcikMetin;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnSifrele;
        private System.Windows.Forms.TextBox txtSifreliDizin;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtAcikMetinBit;
        private System.Windows.Forms.TextBox txtSifreDizini;
    }
}

