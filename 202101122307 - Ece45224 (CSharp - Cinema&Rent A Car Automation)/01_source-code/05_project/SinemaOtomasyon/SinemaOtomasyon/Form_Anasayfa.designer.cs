namespace SinemaOtomasyon
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
            this.btnBilet = new System.Windows.Forms.Button();
            this.btnSeans = new System.Windows.Forms.Button();
            this.btnFilm = new System.Windows.Forms.Button();
            this.btnSalon = new System.Windows.Forms.Button();
            this.btnKullanici = new System.Windows.Forms.Button();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.stLb_Durum = new System.Windows.Forms.ToolStripStatusLabel();
            this.button1 = new System.Windows.Forms.Button();
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
            this.yenidenBaşlatToolStripMenuItem.Size = new System.Drawing.Size(150, 22);
            this.yenidenBaşlatToolStripMenuItem.Text = "Yeniden Başlat";
            this.yenidenBaşlatToolStripMenuItem.Click += new System.EventHandler(this.yenidenBaşlatToolStripMenuItem_Click);
            // 
            // kapatToolStripMenuItem
            // 
            this.kapatToolStripMenuItem.BackColor = System.Drawing.Color.DimGray;
            this.kapatToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.kapatToolStripMenuItem.Name = "kapatToolStripMenuItem";
            this.kapatToolStripMenuItem.Size = new System.Drawing.Size(150, 22);
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
            this.kontrolToolStripMenuItem.Size = new System.Drawing.Size(117, 22);
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
            // btnBilet
            // 
            this.btnBilet.BackColor = System.Drawing.Color.Black;
            this.btnBilet.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnBilet.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnBilet.ForeColor = System.Drawing.Color.White;
            this.btnBilet.Location = new System.Drawing.Point(23, 41);
            this.btnBilet.Name = "btnBilet";
            this.btnBilet.Size = new System.Drawing.Size(189, 125);
            this.btnBilet.TabIndex = 1;
            this.btnBilet.Text = "BİLET İŞLEMLERİ";
            this.btnBilet.UseVisualStyleBackColor = false;
            this.btnBilet.Click += new System.EventHandler(this.btnBilet_Click);
            // 
            // btnSeans
            // 
            this.btnSeans.BackColor = System.Drawing.Color.Black;
            this.btnSeans.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSeans.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnSeans.ForeColor = System.Drawing.Color.White;
            this.btnSeans.Location = new System.Drawing.Point(218, 41);
            this.btnSeans.Name = "btnSeans";
            this.btnSeans.Size = new System.Drawing.Size(189, 125);
            this.btnSeans.TabIndex = 2;
            this.btnSeans.Text = "SEANS İŞLEMLERİ";
            this.btnSeans.UseVisualStyleBackColor = false;
            this.btnSeans.Click += new System.EventHandler(this.btnSeans_Click);
            // 
            // btnFilm
            // 
            this.btnFilm.BackColor = System.Drawing.Color.Black;
            this.btnFilm.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnFilm.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnFilm.ForeColor = System.Drawing.Color.White;
            this.btnFilm.Location = new System.Drawing.Point(413, 41);
            this.btnFilm.Name = "btnFilm";
            this.btnFilm.Size = new System.Drawing.Size(189, 125);
            this.btnFilm.TabIndex = 3;
            this.btnFilm.Text = "FİLM İŞLEMLERİ";
            this.btnFilm.UseVisualStyleBackColor = false;
            this.btnFilm.Click += new System.EventHandler(this.btnFilm_Click);
            // 
            // btnSalon
            // 
            this.btnSalon.BackColor = System.Drawing.Color.Black;
            this.btnSalon.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSalon.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnSalon.ForeColor = System.Drawing.Color.White;
            this.btnSalon.Location = new System.Drawing.Point(23, 172);
            this.btnSalon.Name = "btnSalon";
            this.btnSalon.Size = new System.Drawing.Size(189, 125);
            this.btnSalon.TabIndex = 4;
            this.btnSalon.Text = "SALON İŞLEMLERİ";
            this.btnSalon.UseVisualStyleBackColor = false;
            this.btnSalon.Click += new System.EventHandler(this.btnSalon_Click);
            // 
            // btnKullanici
            // 
            this.btnKullanici.BackColor = System.Drawing.Color.Black;
            this.btnKullanici.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnKullanici.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnKullanici.ForeColor = System.Drawing.Color.White;
            this.btnKullanici.Location = new System.Drawing.Point(218, 171);
            this.btnKullanici.Name = "btnKullanici";
            this.btnKullanici.Size = new System.Drawing.Size(189, 125);
            this.btnKullanici.TabIndex = 6;
            this.btnKullanici.Text = "KULLANICI İŞLEMLERİ";
            this.btnKullanici.UseVisualStyleBackColor = false;
            this.btnKullanici.Click += new System.EventHandler(this.btnKullanici_Click);
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
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.Black;
            this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button1.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.button1.ForeColor = System.Drawing.Color.White;
            this.button1.Location = new System.Drawing.Point(413, 171);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(189, 125);
            this.button1.TabIndex = 8;
            this.button1.Text = "ÇIKIŞ";
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form_Anasayfa
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.BackColor = System.Drawing.Color.DimGray;
            this.ClientSize = new System.Drawing.Size(626, 321);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.btnKullanici);
            this.Controls.Add(this.btnSalon);
            this.Controls.Add(this.btnFilm);
            this.Controls.Add(this.btnSeans);
            this.Controls.Add(this.btnBilet);
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
        private System.Windows.Forms.Button btnBilet;
        private System.Windows.Forms.Button btnSeans;
        private System.Windows.Forms.Button btnFilm;
        private System.Windows.Forms.Button btnSalon;
        private System.Windows.Forms.Button btnKullanici;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel stLb_Durum;
        private System.Windows.Forms.Button button1;
    }
}