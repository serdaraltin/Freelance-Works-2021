namespace CafeOtomasyon
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_Anasayfa));
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.programToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.yenidenBaşlatToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.kapatToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.veritabanıToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.kontrolToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.hakkındaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.btnMasa = new System.Windows.Forms.Button();
            this.btnPersonel = new System.Windows.Forms.Button();
            this.btnKullanici = new System.Windows.Forms.Button();
            this.btnSiparis = new System.Windows.Forms.Button();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.stLb_Durum = new System.Windows.Forms.ToolStripStatusLabel();
            this.btnCikis = new System.Windows.Forms.Button();
            this.btnVeritabnai = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.BackColor = System.Drawing.Color.Transparent;
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
            this.programToolStripMenuItem.BackColor = System.Drawing.Color.Transparent;
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
            this.yenidenBaşlatToolStripMenuItem.BackColor = System.Drawing.Color.Black;
            this.yenidenBaşlatToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.yenidenBaşlatToolStripMenuItem.Name = "yenidenBaşlatToolStripMenuItem";
            this.yenidenBaşlatToolStripMenuItem.Size = new System.Drawing.Size(150, 22);
            this.yenidenBaşlatToolStripMenuItem.Text = "Yeniden Başlat";
            this.yenidenBaşlatToolStripMenuItem.Click += new System.EventHandler(this.yenidenBaşlatToolStripMenuItem_Click);
            // 
            // kapatToolStripMenuItem
            // 
            this.kapatToolStripMenuItem.BackColor = System.Drawing.Color.Black;
            this.kapatToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.kapatToolStripMenuItem.Name = "kapatToolStripMenuItem";
            this.kapatToolStripMenuItem.Size = new System.Drawing.Size(150, 22);
            this.kapatToolStripMenuItem.Text = "Kapat";
            this.kapatToolStripMenuItem.Click += new System.EventHandler(this.kapatToolStripMenuItem_Click);
            // 
            // veritabanıToolStripMenuItem
            // 
            this.veritabanıToolStripMenuItem.BackColor = System.Drawing.Color.Transparent;
            this.veritabanıToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.kontrolToolStripMenuItem});
            this.veritabanıToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.veritabanıToolStripMenuItem.Name = "veritabanıToolStripMenuItem";
            this.veritabanıToolStripMenuItem.Size = new System.Drawing.Size(71, 20);
            this.veritabanıToolStripMenuItem.Text = "Veritabanı";
            // 
            // kontrolToolStripMenuItem
            // 
            this.kontrolToolStripMenuItem.BackColor = System.Drawing.Color.Black;
            this.kontrolToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.kontrolToolStripMenuItem.Name = "kontrolToolStripMenuItem";
            this.kontrolToolStripMenuItem.Size = new System.Drawing.Size(140, 22);
            this.kontrolToolStripMenuItem.Text = "Bağlantı Test";
            this.kontrolToolStripMenuItem.Click += new System.EventHandler(this.kontrolToolStripMenuItem_Click);
            // 
            // hakkındaToolStripMenuItem
            // 
            this.hakkındaToolStripMenuItem.BackColor = System.Drawing.Color.Transparent;
            this.hakkındaToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.hakkındaToolStripMenuItem.Name = "hakkındaToolStripMenuItem";
            this.hakkındaToolStripMenuItem.Size = new System.Drawing.Size(69, 20);
            this.hakkındaToolStripMenuItem.Text = "Hakkında";
            this.hakkındaToolStripMenuItem.Click += new System.EventHandler(this.hakkındaToolStripMenuItem_Click);
            // 
            // btnMasa
            // 
            this.btnMasa.BackColor = System.Drawing.Color.Transparent;
            this.btnMasa.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMasa.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnMasa.ForeColor = System.Drawing.Color.White;
            this.btnMasa.Location = new System.Drawing.Point(23, 41);
            this.btnMasa.Name = "btnMasa";
            this.btnMasa.Size = new System.Drawing.Size(189, 125);
            this.btnMasa.TabIndex = 1;
            this.btnMasa.Text = "MASA";
            this.btnMasa.UseVisualStyleBackColor = false;
            this.btnMasa.Click += new System.EventHandler(this.btnMasa_Click);
            // 
            // btnPersonel
            // 
            this.btnPersonel.BackColor = System.Drawing.Color.Transparent;
            this.btnPersonel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnPersonel.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnPersonel.ForeColor = System.Drawing.Color.White;
            this.btnPersonel.Location = new System.Drawing.Point(218, 41);
            this.btnPersonel.Name = "btnPersonel";
            this.btnPersonel.Size = new System.Drawing.Size(189, 125);
            this.btnPersonel.TabIndex = 2;
            this.btnPersonel.Text = "PERSONEL";
            this.btnPersonel.UseVisualStyleBackColor = false;
            this.btnPersonel.Click += new System.EventHandler(this.btnPersonel_Click);
            // 
            // btnKullanici
            // 
            this.btnKullanici.BackColor = System.Drawing.Color.Transparent;
            this.btnKullanici.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnKullanici.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnKullanici.ForeColor = System.Drawing.Color.White;
            this.btnKullanici.Location = new System.Drawing.Point(413, 41);
            this.btnKullanici.Name = "btnKullanici";
            this.btnKullanici.Size = new System.Drawing.Size(189, 125);
            this.btnKullanici.TabIndex = 3;
            this.btnKullanici.Text = "KULLANICI";
            this.btnKullanici.UseVisualStyleBackColor = false;
            this.btnKullanici.Click += new System.EventHandler(this.btnKullanici_Click);
            // 
            // btnSiparis
            // 
            this.btnSiparis.BackColor = System.Drawing.Color.Transparent;
            this.btnSiparis.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSiparis.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnSiparis.ForeColor = System.Drawing.Color.White;
            this.btnSiparis.Location = new System.Drawing.Point(23, 172);
            this.btnSiparis.Name = "btnSiparis";
            this.btnSiparis.Size = new System.Drawing.Size(189, 125);
            this.btnSiparis.TabIndex = 6;
            this.btnSiparis.Text = "SİPARİŞ";
            this.btnSiparis.UseVisualStyleBackColor = false;
            this.btnSiparis.Click += new System.EventHandler(this.btnSiparis_Click);
            // 
            // statusStrip1
            // 
            this.statusStrip1.BackColor = System.Drawing.Color.Transparent;
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stLb_Durum});
            this.statusStrip1.Location = new System.Drawing.Point(0, 321);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(626, 22);
            this.statusStrip1.SizingGrip = false;
            this.statusStrip1.TabIndex = 7;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // stLb_Durum
            // 
            this.stLb_Durum.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.stLb_Durum.Name = "stLb_Durum";
            this.stLb_Durum.Size = new System.Drawing.Size(16, 17);
            this.stLb_Durum.Text = "...";
            // 
            // btnCikis
            // 
            this.btnCikis.BackColor = System.Drawing.Color.Transparent;
            this.btnCikis.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnCikis.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnCikis.ForeColor = System.Drawing.Color.White;
            this.btnCikis.Location = new System.Drawing.Point(413, 172);
            this.btnCikis.Name = "btnCikis";
            this.btnCikis.Size = new System.Drawing.Size(189, 125);
            this.btnCikis.TabIndex = 8;
            this.btnCikis.Text = "ÇIKIŞ";
            this.btnCikis.UseVisualStyleBackColor = false;
            this.btnCikis.Click += new System.EventHandler(this.btnCikis_Click);
            // 
            // btnVeritabnai
            // 
            this.btnVeritabnai.BackColor = System.Drawing.Color.Transparent;
            this.btnVeritabnai.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnVeritabnai.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnVeritabnai.ForeColor = System.Drawing.Color.White;
            this.btnVeritabnai.Location = new System.Drawing.Point(218, 172);
            this.btnVeritabnai.Name = "btnVeritabnai";
            this.btnVeritabnai.Size = new System.Drawing.Size(189, 125);
            this.btnVeritabnai.TabIndex = 9;
            this.btnVeritabnai.Text = "VERİTABANI";
            this.btnVeritabnai.UseVisualStyleBackColor = false;
            this.btnVeritabnai.Click += new System.EventHandler(this.btnVeritabnai_Click);
            // 
            // Form_Anasayfa
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.BackColor = System.Drawing.Color.DimGray;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(626, 343);
            this.Controls.Add(this.btnVeritabnai);
            this.Controls.Add(this.btnCikis);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.btnSiparis);
            this.Controls.Add(this.btnKullanici);
            this.Controls.Add(this.btnPersonel);
            this.Controls.Add(this.btnMasa);
            this.Controls.Add(this.menuStrip1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.MainMenuStrip = this.menuStrip1;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MaximizeBox = false;
            this.Name = "Form_Anasayfa";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Anasayfa";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form_Anasayfa_FormClosing);
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
        private System.Windows.Forms.Button btnMasa;
        private System.Windows.Forms.Button btnPersonel;
        private System.Windows.Forms.Button btnKullanici;
        private System.Windows.Forms.Button btnSiparis;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel stLb_Durum;
        private System.Windows.Forms.Button btnCikis;
        private System.Windows.Forms.Button btnVeritabnai;
    }
}