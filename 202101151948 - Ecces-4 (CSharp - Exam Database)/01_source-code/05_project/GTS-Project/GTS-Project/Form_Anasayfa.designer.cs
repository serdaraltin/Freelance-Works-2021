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
            this.bBolum = new System.Windows.Forms.Button();
            this.bDers = new System.Windows.Forms.Button();
            this.bDonem = new System.Windows.Forms.Button();
            this.bFakulte = new System.Windows.Forms.Button();
            this.bOgretimUyesi = new System.Windows.Forms.Button();
            this.bSinav = new System.Windows.Forms.Button();
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
            this.veritabanıToolStripMenuItem});
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
            this.kontrolToolStripMenuItem.Size = new System.Drawing.Size(117, 22);
            this.kontrolToolStripMenuItem.Text = "Bağlantı";
            this.kontrolToolStripMenuItem.Click += new System.EventHandler(this.kontrolToolStripMenuItem_Click);
            // 
            // bBolum
            // 
            this.bBolum.BackColor = System.Drawing.Color.Black;
            this.bBolum.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bBolum.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.bBolum.ForeColor = System.Drawing.Color.White;
            this.bBolum.Location = new System.Drawing.Point(23, 41);
            this.bBolum.Name = "bBolum";
            this.bBolum.Size = new System.Drawing.Size(189, 125);
            this.bBolum.TabIndex = 1;
            this.bBolum.Text = "BÖLÜM";
            this.bBolum.UseVisualStyleBackColor = false;
            this.bBolum.Click += new System.EventHandler(this.btn_Tez_Click);
            // 
            // bDers
            // 
            this.bDers.BackColor = System.Drawing.Color.Black;
            this.bDers.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bDers.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.bDers.ForeColor = System.Drawing.Color.White;
            this.bDers.Location = new System.Drawing.Point(218, 41);
            this.bDers.Name = "bDers";
            this.bDers.Size = new System.Drawing.Size(189, 125);
            this.bDers.TabIndex = 2;
            this.bDers.Text = "DERS";
            this.bDers.UseVisualStyleBackColor = false;
            this.bDers.Click += new System.EventHandler(this.btn_Yazar_Click);
            // 
            // bDonem
            // 
            this.bDonem.BackColor = System.Drawing.Color.Black;
            this.bDonem.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bDonem.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.bDonem.ForeColor = System.Drawing.Color.White;
            this.bDonem.Location = new System.Drawing.Point(413, 41);
            this.bDonem.Name = "bDonem";
            this.bDonem.Size = new System.Drawing.Size(189, 125);
            this.bDonem.TabIndex = 3;
            this.bDonem.Text = "DÖNEM";
            this.bDonem.UseVisualStyleBackColor = false;
            this.bDonem.Click += new System.EventHandler(this.btn_Danisman_Click);
            // 
            // bFakulte
            // 
            this.bFakulte.BackColor = System.Drawing.Color.Black;
            this.bFakulte.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bFakulte.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.bFakulte.ForeColor = System.Drawing.Color.White;
            this.bFakulte.Location = new System.Drawing.Point(23, 172);
            this.bFakulte.Name = "bFakulte";
            this.bFakulte.Size = new System.Drawing.Size(189, 125);
            this.bFakulte.TabIndex = 4;
            this.bFakulte.Text = "FAKÜLTE";
            this.bFakulte.UseVisualStyleBackColor = false;
            this.bFakulte.Click += new System.EventHandler(this.btn_Universite_Click);
            // 
            // bOgretimUyesi
            // 
            this.bOgretimUyesi.BackColor = System.Drawing.Color.Black;
            this.bOgretimUyesi.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bOgretimUyesi.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.bOgretimUyesi.ForeColor = System.Drawing.Color.White;
            this.bOgretimUyesi.Location = new System.Drawing.Point(218, 172);
            this.bOgretimUyesi.Name = "bOgretimUyesi";
            this.bOgretimUyesi.Size = new System.Drawing.Size(189, 125);
            this.bOgretimUyesi.TabIndex = 5;
            this.bOgretimUyesi.Text = "ÖĞRETİM ÜYESİ";
            this.bOgretimUyesi.UseVisualStyleBackColor = false;
            this.bOgretimUyesi.Click += new System.EventHandler(this.btn_Enstitu_Click);
            // 
            // bSinav
            // 
            this.bSinav.BackColor = System.Drawing.Color.Black;
            this.bSinav.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bSinav.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.bSinav.ForeColor = System.Drawing.Color.White;
            this.bSinav.Location = new System.Drawing.Point(413, 172);
            this.bSinav.Name = "bSinav";
            this.bSinav.Size = new System.Drawing.Size(189, 125);
            this.bSinav.TabIndex = 6;
            this.bSinav.Text = "SINAV";
            this.bSinav.UseVisualStyleBackColor = false;
            this.bSinav.Click += new System.EventHandler(this.btn_Baslik_Click);
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
            this.Controls.Add(this.bSinav);
            this.Controls.Add(this.bOgretimUyesi);
            this.Controls.Add(this.bFakulte);
            this.Controls.Add(this.bDonem);
            this.Controls.Add(this.bDers);
            this.Controls.Add(this.bBolum);
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
        private System.Windows.Forms.Button bBolum;
        private System.Windows.Forms.Button bDers;
        private System.Windows.Forms.Button bDonem;
        private System.Windows.Forms.Button bFakulte;
        private System.Windows.Forms.Button bOgretimUyesi;
        private System.Windows.Forms.Button bSinav;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel stLb_Durum;
    }
}