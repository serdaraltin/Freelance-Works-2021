namespace GTS_Project
{
    partial class Form_Anasayfa
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.programToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.yenidenBaşlatToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.kapatToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.veritabanıToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.kontrolToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.hakkındaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.btn_Tez = new System.Windows.Forms.Button();
            this.btn_Yazar = new System.Windows.Forms.Button();
            this.btn_Danisman = new System.Windows.Forms.Button();
            this.btn_Universite = new System.Windows.Forms.Button();
            this.btn_Enstitu = new System.Windows.Forms.Button();
            this.btn_Baslik = new System.Windows.Forms.Button();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.stLb_Durum = new System.Windows.Forms.ToolStripStatusLabel();
            this.menuStrip1.SuspendLayout();
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.BackColor = System.Drawing.Color.DimGray;
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.programToolStripMenuItem,
            this.veritabanıToolStripMenuItem,
            this.hakkındaToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Padding = new System.Windows.Forms.Padding(8, 2, 0, 2);
            this.menuStrip1.Size = new System.Drawing.Size(626, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // programToolStripMenuItem
            // 
            this.programToolStripMenuItem.BackColor = System.Drawing.Color.DimGray;
            this.programToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.yenidenBaşlatToolStripMenuItem,
            this.kapatToolStripMenuItem});
            this.programToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.programToolStripMenuItem.Name = "programToolStripMenuItem";
            this.programToolStripMenuItem.Size = new System.Drawing.Size(65, 20);
            this.programToolStripMenuItem.Text = "Program";
            // 
            // yenidenBaşlatToolStripMenuItem
            // 
            this.yenidenBaşlatToolStripMenuItem.BackColor = System.Drawing.Color.DimGray;
            this.yenidenBaşlatToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.yenidenBaşlatToolStripMenuItem.Name = "yenidenBaşlatToolStripMenuItem";
            this.yenidenBaşlatToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.yenidenBaşlatToolStripMenuItem.Text = "Yeniden Başlat";
            this.yenidenBaşlatToolStripMenuItem.Click += new System.EventHandler(this.yenidenBaşlatToolStripMenuItem_Click);
            // 
            // kapatToolStripMenuItem
            // 
            this.kapatToolStripMenuItem.BackColor = System.Drawing.Color.DimGray;
            this.kapatToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.kapatToolStripMenuItem.Name = "kapatToolStripMenuItem";
            this.kapatToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.kapatToolStripMenuItem.Text = "Kapat";
            this.kapatToolStripMenuItem.Click += new System.EventHandler(this.kapatToolStripMenuItem_Click);
            // 
            // veritabanıToolStripMenuItem
            // 
            this.veritabanıToolStripMenuItem.BackColor = System.Drawing.Color.DimGray;
            this.veritabanıToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.kontrolToolStripMenuItem});
            this.veritabanıToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.veritabanıToolStripMenuItem.Name = "veritabanıToolStripMenuItem";
            this.veritabanıToolStripMenuItem.Size = new System.Drawing.Size(71, 20);
            this.veritabanıToolStripMenuItem.Text = "Veritabanı";
            // 
            // kontrolToolStripMenuItem
            // 
            this.kontrolToolStripMenuItem.BackColor = System.Drawing.Color.DimGray;
            this.kontrolToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.kontrolToolStripMenuItem.Name = "kontrolToolStripMenuItem";
            this.kontrolToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.kontrolToolStripMenuItem.Text = "Bağlantı";
            this.kontrolToolStripMenuItem.Click += new System.EventHandler(this.kontrolToolStripMenuItem_Click);
            // 
            // hakkındaToolStripMenuItem
            // 
            this.hakkındaToolStripMenuItem.BackColor = System.Drawing.Color.DimGray;
            this.hakkındaToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.hakkındaToolStripMenuItem.Name = "hakkındaToolStripMenuItem";
            this.hakkındaToolStripMenuItem.Size = new System.Drawing.Size(69, 20);
            this.hakkındaToolStripMenuItem.Text = "Hakkında";
            this.hakkındaToolStripMenuItem.Click += new System.EventHandler(this.hakkındaToolStripMenuItem_Click);
            // 
            // btn_Tez
            // 
            this.btn_Tez.BackColor = System.Drawing.Color.Black;
            this.btn_Tez.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Tez.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btn_Tez.ForeColor = System.Drawing.Color.White;
            this.btn_Tez.Location = new System.Drawing.Point(23, 41);
            this.btn_Tez.Name = "btn_Tez";
            this.btn_Tez.Size = new System.Drawing.Size(189, 125);
            this.btn_Tez.TabIndex = 1;
            this.btn_Tez.Text = "TEZ İŞLEMLERİ";
            this.btn_Tez.UseVisualStyleBackColor = false;
            this.btn_Tez.Click += new System.EventHandler(this.btn_Tez_Click);
            // 
            // btn_Yazar
            // 
            this.btn_Yazar.BackColor = System.Drawing.Color.Black;
            this.btn_Yazar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Yazar.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btn_Yazar.ForeColor = System.Drawing.Color.White;
            this.btn_Yazar.Location = new System.Drawing.Point(218, 41);
            this.btn_Yazar.Name = "btn_Yazar";
            this.btn_Yazar.Size = new System.Drawing.Size(189, 125);
            this.btn_Yazar.TabIndex = 2;
            this.btn_Yazar.Text = "YAZAR İŞLEMLERİ";
            this.btn_Yazar.UseVisualStyleBackColor = false;
            this.btn_Yazar.Click += new System.EventHandler(this.btn_Yazar_Click);
            // 
            // btn_Danisman
            // 
            this.btn_Danisman.BackColor = System.Drawing.Color.Black;
            this.btn_Danisman.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Danisman.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btn_Danisman.ForeColor = System.Drawing.Color.White;
            this.btn_Danisman.Location = new System.Drawing.Point(413, 41);
            this.btn_Danisman.Name = "btn_Danisman";
            this.btn_Danisman.Size = new System.Drawing.Size(189, 125);
            this.btn_Danisman.TabIndex = 3;
            this.btn_Danisman.Text = "DANIŞMAN İŞLEMLERİ";
            this.btn_Danisman.UseVisualStyleBackColor = false;
            this.btn_Danisman.Click += new System.EventHandler(this.btn_Danisman_Click);
            // 
            // btn_Universite
            // 
            this.btn_Universite.BackColor = System.Drawing.Color.Black;
            this.btn_Universite.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Universite.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btn_Universite.ForeColor = System.Drawing.Color.White;
            this.btn_Universite.Location = new System.Drawing.Point(23, 172);
            this.btn_Universite.Name = "btn_Universite";
            this.btn_Universite.Size = new System.Drawing.Size(189, 125);
            this.btn_Universite.TabIndex = 4;
            this.btn_Universite.Text = "ÜNİVERSİTE İŞLEMLERİ";
            this.btn_Universite.UseVisualStyleBackColor = false;
            this.btn_Universite.Click += new System.EventHandler(this.btn_Universite_Click);
            // 
            // btn_Enstitu
            // 
            this.btn_Enstitu.BackColor = System.Drawing.Color.Black;
            this.btn_Enstitu.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Enstitu.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btn_Enstitu.ForeColor = System.Drawing.Color.White;
            this.btn_Enstitu.Location = new System.Drawing.Point(218, 172);
            this.btn_Enstitu.Name = "btn_Enstitu";
            this.btn_Enstitu.Size = new System.Drawing.Size(189, 125);
            this.btn_Enstitu.TabIndex = 5;
            this.btn_Enstitu.Text = "ENSTİTÜ İŞLEMLERİ";
            this.btn_Enstitu.UseVisualStyleBackColor = false;
            this.btn_Enstitu.Click += new System.EventHandler(this.btn_Enstitu_Click);
            // 
            // btn_Baslik
            // 
            this.btn_Baslik.BackColor = System.Drawing.Color.Black;
            this.btn_Baslik.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_Baslik.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btn_Baslik.ForeColor = System.Drawing.Color.White;
            this.btn_Baslik.Location = new System.Drawing.Point(413, 172);
            this.btn_Baslik.Name = "btn_Baslik";
            this.btn_Baslik.Size = new System.Drawing.Size(189, 125);
            this.btn_Baslik.TabIndex = 6;
            this.btn_Baslik.Text = "BAŞLIK İŞLEMLERİ";
            this.btn_Baslik.UseVisualStyleBackColor = false;
            this.btn_Baslik.Click += new System.EventHandler(this.btn_Baslik_Click);
            // 
            // statusStrip1
            // 
            this.statusStrip1.BackColor = System.Drawing.Color.DimGray;
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stLb_Durum});
            this.statusStrip1.Location = new System.Drawing.Point(0, 299);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(626, 22);
            this.statusStrip1.SizingGrip = false;
            this.statusStrip1.TabIndex = 7;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // stLb_Durum
            // 
            this.stLb_Durum.Name = "stLb_Durum";
            this.stLb_Durum.Size = new System.Drawing.Size(16, 17);
            this.stLb_Durum.Text = "...";
            // 
            // Form_Anasayfa
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.BackColor = System.Drawing.Color.DimGray;
            this.ClientSize = new System.Drawing.Size(626, 321);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.btn_Baslik);
            this.Controls.Add(this.btn_Enstitu);
            this.Controls.Add(this.btn_Universite);
            this.Controls.Add(this.btn_Danisman);
            this.Controls.Add(this.btn_Yazar);
            this.Controls.Add(this.btn_Tez);
            this.Controls.Add(this.menuStrip1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.MainMenuStrip = this.menuStrip1;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MaximizeBox = false;
            this.Name = "Form_Anasayfa";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Anasayfa";
            this.Load += new System.EventHandler(this.Form_Anasayfa_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.statusStrip1.ResumeLayout(false);
            this.statusStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem programToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem yenidenBaşlatToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem kapatToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem veritabanıToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem kontrolToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem hakkındaToolStripMenuItem;
        private System.Windows.Forms.Button btn_Tez;
        private System.Windows.Forms.Button btn_Yazar;
        private System.Windows.Forms.Button btn_Danisman;
        private System.Windows.Forms.Button btn_Universite;
        private System.Windows.Forms.Button btn_Enstitu;
        private System.Windows.Forms.Button btn_Baslik;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel stLb_Durum;
    }
}