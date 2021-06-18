namespace HotelAutomation
{
    partial class Form_MainPage
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
            this.msProgram = new System.Windows.Forms.ToolStripMenuItem();
            this.tsRestart = new System.Windows.Forms.ToolStripMenuItem();
            this.tsClose = new System.Windows.Forms.ToolStripMenuItem();
            this.msDatabase = new System.Windows.Forms.ToolStripMenuItem();
            this.tsConnectionTest = new System.Windows.Forms.ToolStripMenuItem();
            this.msAbout = new System.Windows.Forms.ToolStripMenuItem();
            this.btnProduct = new System.Windows.Forms.Button();
            this.btnStock = new System.Windows.Forms.Button();
            this.btnSales = new System.Windows.Forms.Button();
            this.btnCategory = new System.Windows.Forms.Button();
            this.btnBrand = new System.Windows.Forms.Button();
            this.btnDatabase = new System.Windows.Forms.Button();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.stlbStatus = new System.Windows.Forms.ToolStripStatusLabel();
            this.menuStrip1.SuspendLayout();
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.msProgram,
            this.msDatabase,
            this.msAbout});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Padding = new System.Windows.Forms.Padding(8, 2, 0, 2);
            this.menuStrip1.Size = new System.Drawing.Size(626, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // msProgram
            // 
            this.msProgram.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.msProgram.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsRestart,
            this.tsClose});
            this.msProgram.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.msProgram.Name = "msProgram";
            this.msProgram.Size = new System.Drawing.Size(65, 20);
            this.msProgram.Text = "Program";
            // 
            // tsRestart
            // 
            this.tsRestart.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.tsRestart.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.tsRestart.Name = "tsRestart";
            this.tsRestart.Size = new System.Drawing.Size(110, 22);
            this.tsRestart.Text = "Restart";
            this.tsRestart.Click += new System.EventHandler(this.tsRestart_Click);
            // 
            // tsClose
            // 
            this.tsClose.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.tsClose.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.tsClose.Name = "tsClose";
            this.tsClose.Size = new System.Drawing.Size(110, 22);
            this.tsClose.Text = "Close";
            this.tsClose.Click += new System.EventHandler(this.tsClose_Click);
            // 
            // msDatabase
            // 
            this.msDatabase.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.msDatabase.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsConnectionTest});
            this.msDatabase.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.msDatabase.Name = "msDatabase";
            this.msDatabase.Size = new System.Drawing.Size(67, 20);
            this.msDatabase.Text = "Database";
            // 
            // tsConnectionTest
            // 
            this.tsConnectionTest.BackColor = System.Drawing.Color.DimGray;
            this.tsConnectionTest.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.tsConnectionTest.Name = "tsConnectionTest";
            this.tsConnectionTest.Size = new System.Drawing.Size(159, 22);
            this.tsConnectionTest.Text = "Connection Test";
            this.tsConnectionTest.Click += new System.EventHandler(this.tsConnectionTest_Click);
            // 
            // msAbout
            // 
            this.msAbout.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.msAbout.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.msAbout.Name = "msAbout";
            this.msAbout.Size = new System.Drawing.Size(52, 20);
            this.msAbout.Text = "About";
            this.msAbout.Click += new System.EventHandler(this.msAbout_Click);
            // 
            // btnProduct
            // 
            this.btnProduct.BackColor = System.Drawing.Color.AliceBlue;
            this.btnProduct.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnProduct.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnProduct.ForeColor = System.Drawing.Color.Black;
            this.btnProduct.Location = new System.Drawing.Point(23, 41);
            this.btnProduct.Name = "btnProduct";
            this.btnProduct.Size = new System.Drawing.Size(189, 125);
            this.btnProduct.TabIndex = 1;
            this.btnProduct.Text = "CUSTOMER OPERATION";
            this.btnProduct.UseVisualStyleBackColor = false;
            this.btnProduct.Click += new System.EventHandler(this.btn1_Click);
            // 
            // btnStock
            // 
            this.btnStock.BackColor = System.Drawing.Color.AliceBlue;
            this.btnStock.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnStock.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnStock.ForeColor = System.Drawing.Color.Black;
            this.btnStock.Location = new System.Drawing.Point(218, 41);
            this.btnStock.Name = "btnStock";
            this.btnStock.Size = new System.Drawing.Size(189, 125);
            this.btnStock.TabIndex = 2;
            this.btnStock.Text = "EMPLOYEES OPERATION";
            this.btnStock.UseVisualStyleBackColor = false;
            this.btnStock.Click += new System.EventHandler(this.btn2_Click);
            // 
            // btnSales
            // 
            this.btnSales.BackColor = System.Drawing.Color.AliceBlue;
            this.btnSales.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSales.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnSales.ForeColor = System.Drawing.Color.Black;
            this.btnSales.Location = new System.Drawing.Point(413, 41);
            this.btnSales.Name = "btnSales";
            this.btnSales.Size = new System.Drawing.Size(189, 125);
            this.btnSales.TabIndex = 3;
            this.btnSales.Text = "ROOM OPERATION";
            this.btnSales.UseVisualStyleBackColor = false;
            this.btnSales.Click += new System.EventHandler(this.btn3_Click);
            // 
            // btnCategory
            // 
            this.btnCategory.BackColor = System.Drawing.Color.AliceBlue;
            this.btnCategory.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnCategory.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnCategory.ForeColor = System.Drawing.Color.Black;
            this.btnCategory.Location = new System.Drawing.Point(23, 172);
            this.btnCategory.Name = "btnCategory";
            this.btnCategory.Size = new System.Drawing.Size(189, 125);
            this.btnCategory.TabIndex = 4;
            this.btnCategory.Text = "REZARVATION OPERATION";
            this.btnCategory.UseVisualStyleBackColor = false;
            this.btnCategory.Click += new System.EventHandler(this.btn4_Click);
            // 
            // btnBrand
            // 
            this.btnBrand.BackColor = System.Drawing.Color.AliceBlue;
            this.btnBrand.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnBrand.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnBrand.ForeColor = System.Drawing.Color.Black;
            this.btnBrand.Location = new System.Drawing.Point(218, 172);
            this.btnBrand.Name = "btnBrand";
            this.btnBrand.Size = new System.Drawing.Size(189, 125);
            this.btnBrand.TabIndex = 5;
            this.btnBrand.Text = "USER OPERATION";
            this.btnBrand.UseVisualStyleBackColor = false;
            this.btnBrand.Click += new System.EventHandler(this.btn5_Click);
            // 
            // btnDatabase
            // 
            this.btnDatabase.BackColor = System.Drawing.Color.AliceBlue;
            this.btnDatabase.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnDatabase.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.btnDatabase.ForeColor = System.Drawing.Color.Black;
            this.btnDatabase.Location = new System.Drawing.Point(413, 172);
            this.btnDatabase.Name = "btnDatabase";
            this.btnDatabase.Size = new System.Drawing.Size(189, 125);
            this.btnDatabase.TabIndex = 6;
            this.btnDatabase.Text = "DATABASE OPERATION";
            this.btnDatabase.UseVisualStyleBackColor = false;
            this.btnDatabase.Click += new System.EventHandler(this.btn6_Click);
            // 
            // statusStrip1
            // 
            this.statusStrip1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stlbStatus});
            this.statusStrip1.Location = new System.Drawing.Point(0, 299);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(626, 22);
            this.statusStrip1.SizingGrip = false;
            this.statusStrip1.TabIndex = 7;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // stlbStatus
            // 
            this.stlbStatus.Name = "stlbStatus";
            this.stlbStatus.Size = new System.Drawing.Size(16, 17);
            this.stlbStatus.Text = "...";
            // 
            // Form_MainPage
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.ClientSize = new System.Drawing.Size(626, 321);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.btnDatabase);
            this.Controls.Add(this.btnBrand);
            this.Controls.Add(this.btnCategory);
            this.Controls.Add(this.btnSales);
            this.Controls.Add(this.btnStock);
            this.Controls.Add(this.btnProduct);
            this.Controls.Add(this.menuStrip1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.MainMenuStrip = this.menuStrip1;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MaximizeBox = false;
            this.Name = "Form_MainPage";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Main Page";
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
        private System.Windows.Forms.ToolStripMenuItem msProgram;
        private System.Windows.Forms.ToolStripMenuItem tsRestart;
        private System.Windows.Forms.ToolStripMenuItem tsClose;
        private System.Windows.Forms.ToolStripMenuItem msDatabase;
        private System.Windows.Forms.ToolStripMenuItem tsConnectionTest;
        private System.Windows.Forms.Button btnProduct;
        private System.Windows.Forms.Button btnStock;
        private System.Windows.Forms.Button btnSales;
        private System.Windows.Forms.Button btnCategory;
        private System.Windows.Forms.Button btnBrand;
        private System.Windows.Forms.Button btnDatabase;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel stlbStatus;
        private System.Windows.Forms.ToolStripMenuItem msAbout;
    }
}