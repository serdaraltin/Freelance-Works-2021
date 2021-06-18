namespace GTS_Project
{
    partial class Form_Donem
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
            this.label1 = new System.Windows.Forms.Label();
            this.cbDonem = new System.Windows.Forms.ComboBox();
            this.cbBas = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.cbBitis = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btn_Sil
            // 
            this.btn_Sil.Location = new System.Drawing.Point(222, 134);
            this.btn_Sil.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Sil.Name = "btn_Sil";
            this.btn_Sil.Size = new System.Drawing.Size(91, 46);
            this.btn_Sil.TabIndex = 3;
            this.btn_Sil.Text = "SİL";
            this.btn_Sil.UseVisualStyleBackColor = true;
            this.btn_Sil.Visible = false;
            this.btn_Sil.Click += new System.EventHandler(this.btn_Sil_Click);
            // 
            // btn_Ekle
            // 
            this.btn_Ekle.Location = new System.Drawing.Point(84, 134);
            this.btn_Ekle.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Ekle.Name = "btn_Ekle";
            this.btn_Ekle.Size = new System.Drawing.Size(129, 46);
            this.btn_Ekle.TabIndex = 2;
            this.btn_Ekle.Text = "EKLE";
            this.btn_Ekle.UseVisualStyleBackColor = true;
            this.btn_Ekle.Click += new System.EventHandler(this.btn_Ekle_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 31);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 17);
            this.label1.TabIndex = 56;
            this.label1.Text = "Dönem";
            // 
            // cbDonem
            // 
            this.cbDonem.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbDonem.FormattingEnabled = true;
            this.cbDonem.Items.AddRange(new object[] {
            "Güz",
            "Bahar",
            "Yaz"});
            this.cbDonem.Location = new System.Drawing.Point(84, 29);
            this.cbDonem.Name = "cbDonem";
            this.cbDonem.Size = new System.Drawing.Size(227, 24);
            this.cbDonem.TabIndex = 57;
            // 
            // cbBas
            // 
            this.cbBas.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbBas.FormattingEnabled = true;
            this.cbBas.Location = new System.Drawing.Point(84, 59);
            this.cbBas.Name = "cbBas";
            this.cbBas.Size = new System.Drawing.Size(227, 24);
            this.cbBas.TabIndex = 59;
            this.cbBas.SelectedIndexChanged += new System.EventHandler(this.cbBas_SelectedIndexChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 61);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(69, 17);
            this.label2.TabIndex = 58;
            this.label2.Text = "Başlangıç";
            // 
            // cbBitis
            // 
            this.cbBitis.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbBitis.FormattingEnabled = true;
            this.cbBitis.Location = new System.Drawing.Point(84, 89);
            this.cbBitis.Name = "cbBitis";
            this.cbBitis.Size = new System.Drawing.Size(227, 24);
            this.cbBitis.TabIndex = 61;
            this.cbBitis.SelectedIndexChanged += new System.EventHandler(this.cbBitis_SelectedIndexChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(13, 91);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(34, 17);
            this.label3.TabIndex = 60;
            this.label3.Text = "Bitiş";
            // 
            // Form_Donem
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(332, 193);
            this.Controls.Add(this.cbBitis);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.cbBas);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.cbDonem);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btn_Sil);
            this.Controls.Add(this.btn_Ekle);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form_Donem";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Dönem";
            this.Load += new System.EventHandler(this.Form_Personel_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btn_Sil;
        private System.Windows.Forms.Button btn_Ekle;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cbDonem;
        private System.Windows.Forms.ComboBox cbBas;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox cbBitis;
        private System.Windows.Forms.Label label3;
    }
}