﻿namespace AracKiralamaOtomasyon
{
    partial class Form_Islem
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
            this.panel1 = new System.Windows.Forms.Panel();
            this.btn_Kapat = new System.Windows.Forms.Button();
            this.btn_Yenile = new System.Windows.Forms.Button();
            this.btn_Sil = new System.Windows.Forms.Button();
            this.btn_Guncelle = new System.Windows.Forms.Button();
            this.btn_Ekle = new System.Windows.Forms.Button();
            this.dg_veriler = new System.Windows.Forms.DataGridView();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dg_veriler)).BeginInit();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.panel1.BackColor = System.Drawing.Color.Transparent;
            this.panel1.Controls.Add(this.btn_Kapat);
            this.panel1.Controls.Add(this.btn_Yenile);
            this.panel1.Controls.Add(this.btn_Sil);
            this.panel1.Controls.Add(this.btn_Guncelle);
            this.panel1.Controls.Add(this.btn_Ekle);
            this.panel1.Location = new System.Drawing.Point(13, 9);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(725, 49);
            this.panel1.TabIndex = 10;
            // 
            // btn_Kapat
            // 
            this.btn_Kapat.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btn_Kapat.Location = new System.Drawing.Point(616, 5);
            this.btn_Kapat.Name = "btn_Kapat";
            this.btn_Kapat.Size = new System.Drawing.Size(100, 38);
            this.btn_Kapat.TabIndex = 4;
            this.btn_Kapat.Text = "KAPAT";
            this.btn_Kapat.UseVisualStyleBackColor = true;
            this.btn_Kapat.Click += new System.EventHandler(this.btn_Kapat_Click);
            // 
            // btn_Yenile
            // 
            this.btn_Yenile.Location = new System.Drawing.Point(13, 5);
            this.btn_Yenile.Name = "btn_Yenile";
            this.btn_Yenile.Size = new System.Drawing.Size(100, 38);
            this.btn_Yenile.TabIndex = 3;
            this.btn_Yenile.Text = "YENİLE";
            this.btn_Yenile.UseVisualStyleBackColor = true;
            this.btn_Yenile.Click += new System.EventHandler(this.btn_Yenile_Click);
            // 
            // btn_Sil
            // 
            this.btn_Sil.Location = new System.Drawing.Point(331, 5);
            this.btn_Sil.Name = "btn_Sil";
            this.btn_Sil.Size = new System.Drawing.Size(100, 38);
            this.btn_Sil.TabIndex = 2;
            this.btn_Sil.Text = "SİL";
            this.btn_Sil.UseVisualStyleBackColor = true;
            this.btn_Sil.Click += new System.EventHandler(this.btn_Sil_Click);
            // 
            // btn_Guncelle
            // 
            this.btn_Guncelle.Location = new System.Drawing.Point(225, 5);
            this.btn_Guncelle.Name = "btn_Guncelle";
            this.btn_Guncelle.Size = new System.Drawing.Size(100, 38);
            this.btn_Guncelle.TabIndex = 1;
            this.btn_Guncelle.Text = "GÜNCELLE";
            this.btn_Guncelle.UseVisualStyleBackColor = true;
            this.btn_Guncelle.Click += new System.EventHandler(this.btn_Guncelle_Click);
            // 
            // btn_Ekle
            // 
            this.btn_Ekle.Location = new System.Drawing.Point(119, 5);
            this.btn_Ekle.Name = "btn_Ekle";
            this.btn_Ekle.Size = new System.Drawing.Size(100, 38);
            this.btn_Ekle.TabIndex = 0;
            this.btn_Ekle.Text = "EKLE";
            this.btn_Ekle.UseVisualStyleBackColor = true;
            this.btn_Ekle.Click += new System.EventHandler(this.btn_Ekle_Click);
            // 
            // dg_veriler
            // 
            this.dg_veriler.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dg_veriler.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dg_veriler.BackgroundColor = System.Drawing.SystemColors.ActiveCaption;
            this.dg_veriler.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dg_veriler.Location = new System.Drawing.Point(13, 64);
            this.dg_veriler.MultiSelect = false;
            this.dg_veriler.Name = "dg_veriler";
            this.dg_veriler.ReadOnly = true;
            this.dg_veriler.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dg_veriler.Size = new System.Drawing.Size(725, 355);
            this.dg_veriler.TabIndex = 9;
            this.dg_veriler.RowEnter += new System.Windows.Forms.DataGridViewCellEventHandler(this.dg_veriler_RowEnter);
            this.dg_veriler.DoubleClick += new System.EventHandler(this.dg_veriler_DoubleClick);
            // 
            // Form_Islem
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Navy;
            this.ClientSize = new System.Drawing.Size(751, 431);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.dg_veriler);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MinimizeBox = false;
            this.Name = "Form_Islem";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "İşlemler";
            this.Load += new System.EventHandler(this.Islem_Load);
            this.panel1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dg_veriler)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button btn_Kapat;
        private System.Windows.Forms.Button btn_Yenile;
        private System.Windows.Forms.Button btn_Sil;
        private System.Windows.Forms.Button btn_Guncelle;
        private System.Windows.Forms.Button btn_Ekle;
        private System.Windows.Forms.DataGridView dg_veriler;
    }
}