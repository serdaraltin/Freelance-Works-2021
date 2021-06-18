namespace GazeteOtomasyon
{
    partial class Form_Teslimat
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
            this.dt_TeslimatTarih = new System.Windows.Forms.DateTimePicker();
            this.label5 = new System.Windows.Forms.Label();
            this.txt_Aciklama = new System.Windows.Forms.TextBox();
            this.txt_Sayi = new System.Windows.Forms.MaskedTextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.dg_AboneUrun = new System.Windows.Forms.DataGridView();
            this.txt_Abone = new System.Windows.Forms.TextBox();
            this.txt_Urun = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.dg_AboneUrun)).BeginInit();
            this.SuspendLayout();
            // 
            // btn_Sil
            // 
            this.btn_Sil.Location = new System.Drawing.Point(233, 270);
            this.btn_Sil.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Sil.Name = "btn_Sil";
            this.btn_Sil.Size = new System.Drawing.Size(91, 46);
            this.btn_Sil.TabIndex = 7;
            this.btn_Sil.Text = "SİL";
            this.btn_Sil.UseVisualStyleBackColor = true;
            this.btn_Sil.Visible = false;
            this.btn_Sil.Click += new System.EventHandler(this.btn_Sil_Click);
            // 
            // btn_Ekle
            // 
            this.btn_Ekle.Location = new System.Drawing.Point(96, 270);
            this.btn_Ekle.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Ekle.Name = "btn_Ekle";
            this.btn_Ekle.Size = new System.Drawing.Size(129, 46);
            this.btn_Ekle.TabIndex = 6;
            this.btn_Ekle.Text = "EKLE";
            this.btn_Ekle.UseVisualStyleBackColor = true;
            this.btn_Ekle.Click += new System.EventHandler(this.btn_Ekle_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(309, 172);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(61, 17);
            this.label3.TabIndex = 55;
            this.label3.Text = "Teslimat";
            // 
            // dt_TeslimatTarih
            // 
            this.dt_TeslimatTarih.Location = new System.Drawing.Point(385, 169);
            this.dt_TeslimatTarih.Name = "dt_TeslimatTarih";
            this.dt_TeslimatTarih.Size = new System.Drawing.Size(201, 23);
            this.dt_TeslimatTarih.TabIndex = 4;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(314, 201);
            this.label5.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(64, 17);
            this.label5.TabIndex = 61;
            this.label5.Text = "Açıklama";
            // 
            // txt_Aciklama
            // 
            this.txt_Aciklama.Location = new System.Drawing.Point(385, 198);
            this.txt_Aciklama.Multiline = true;
            this.txt_Aciklama.Name = "txt_Aciklama";
            this.txt_Aciklama.Size = new System.Drawing.Size(201, 49);
            this.txt_Aciklama.TabIndex = 5;
            // 
            // txt_Sayi
            // 
            this.txt_Sayi.Location = new System.Drawing.Point(96, 227);
            this.txt_Sayi.Mask = "00000";
            this.txt_Sayi.Name = "txt_Sayi";
            this.txt_Sayi.Size = new System.Drawing.Size(100, 23);
            this.txt_Sayi.TabIndex = 3;
            this.txt_Sayi.ValidatingType = typeof(int);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(54, 230);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(35, 17);
            this.label2.TabIndex = 64;
            this.label2.Text = "Sayi";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(50, 201);
            this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(39, 17);
            this.label4.TabIndex = 68;
            this.label4.Text = "Ürün";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(43, 171);
            this.label6.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(49, 17);
            this.label6.TabIndex = 67;
            this.label6.Text = "Abone";
            // 
            // dg_AboneUrun
            // 
            this.dg_AboneUrun.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dg_AboneUrun.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dg_AboneUrun.Location = new System.Drawing.Point(12, 12);
            this.dg_AboneUrun.MultiSelect = false;
            this.dg_AboneUrun.Name = "dg_AboneUrun";
            this.dg_AboneUrun.ReadOnly = true;
            this.dg_AboneUrun.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dg_AboneUrun.Size = new System.Drawing.Size(599, 142);
            this.dg_AboneUrun.TabIndex = 0;
            this.dg_AboneUrun.RowEnter += new System.Windows.Forms.DataGridViewCellEventHandler(this.dg_AboneUrun_RowEnter);
            // 
            // txt_Abone
            // 
            this.txt_Abone.Location = new System.Drawing.Point(96, 169);
            this.txt_Abone.Name = "txt_Abone";
            this.txt_Abone.ReadOnly = true;
            this.txt_Abone.Size = new System.Drawing.Size(201, 23);
            this.txt_Abone.TabIndex = 69;
            // 
            // txt_Urun
            // 
            this.txt_Urun.Location = new System.Drawing.Point(96, 198);
            this.txt_Urun.Name = "txt_Urun";
            this.txt_Urun.ReadOnly = true;
            this.txt_Urun.Size = new System.Drawing.Size(201, 23);
            this.txt_Urun.TabIndex = 70;
            // 
            // Form_Teslimat
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(623, 329);
            this.Controls.Add(this.txt_Urun);
            this.Controls.Add(this.txt_Abone);
            this.Controls.Add(this.dg_AboneUrun);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txt_Sayi);
            this.Controls.Add(this.txt_Aciklama);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.dt_TeslimatTarih);
            this.Controls.Add(this.btn_Sil);
            this.Controls.Add(this.btn_Ekle);
            this.Controls.Add(this.label3);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form_Teslimat";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Teslimat";
            this.Load += new System.EventHandler(this.Form_Personel_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dg_AboneUrun)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btn_Sil;
        private System.Windows.Forms.Button btn_Ekle;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.DateTimePicker dt_TeslimatTarih;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txt_Aciklama;
        private System.Windows.Forms.MaskedTextBox txt_Sayi;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.DataGridView dg_AboneUrun;
        private System.Windows.Forms.TextBox txt_Abone;
        private System.Windows.Forms.TextBox txt_Urun;
    }
}