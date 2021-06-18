<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form_Anasayfa
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Me.dgVeriler = New System.Windows.Forms.DataGridView()
        Me.GroupBox1 = New System.Windows.Forms.GroupBox()
        Me.cbPersonel = New System.Windows.Forms.ComboBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.cbSube = New System.Windows.Forms.ComboBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.dtTarih = New System.Windows.Forms.DateTimePicker()
        Me.GroupBox2 = New System.Windows.Forms.GroupBox()
        Me.btnMusteriSec = New System.Windows.Forms.Button()
        Me.txtAdres = New System.Windows.Forms.TextBox()
        Me.Label7 = New System.Windows.Forms.Label()
        Me.txtSoyad = New System.Windows.Forms.TextBox()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.txtAd = New System.Windows.Forms.TextBox()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.txtTc = New System.Windows.Forms.TextBox()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.btnYeniKayit = New System.Windows.Forms.Button()
        Me.btnSil = New System.Windows.Forms.Button()
        Me.btnKaydet = New System.Windows.Forms.Button()
        Me.btnAra = New System.Windows.Forms.Button()
        Me.txtAdet = New System.Windows.Forms.TextBox()
        Me.Label8 = New System.Windows.Forms.Label()
        Me.MenuStrip1 = New System.Windows.Forms.MenuStrip()
        Me.ProgramToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.YenidenBaşlatToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.KapatToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.PersonelToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.PersonelEkleToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.ŞubeToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.TürToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.MüşteriToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.GönderiToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.GönderiEkleToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.EkleToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.EkleToolStripMenuItem1 = New System.Windows.Forms.ToolStripMenuItem()
        Me.EkleToolStripMenuItem2 = New System.Windows.Forms.ToolStripMenuItem()
        Me.ContextMenuStrip1 = New System.Windows.Forms.ContextMenuStrip(Me.components)
        Me.ToolStripMenuItem1 = New System.Windows.Forms.ToolStripMenuItem()
        Me.ToolStripMenuItem2 = New System.Windows.Forms.ToolStripMenuItem()
        Me.ToolStripMenuItem3 = New System.Windows.Forms.ToolStripMenuItem()
        Me.YenileToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.HakkındaToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        CType(Me.dgVeriler, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.GroupBox1.SuspendLayout()
        Me.GroupBox2.SuspendLayout()
        Me.MenuStrip1.SuspendLayout()
        Me.ContextMenuStrip1.SuspendLayout()
        Me.SuspendLayout()
        '
        'dgVeriler
        '
        Me.dgVeriler.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill
        Me.dgVeriler.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.dgVeriler.ContextMenuStrip = Me.ContextMenuStrip1
        Me.dgVeriler.Location = New System.Drawing.Point(12, 179)
        Me.dgVeriler.Name = "dgVeriler"
        Me.dgVeriler.ReadOnly = True
        Me.dgVeriler.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect
        Me.dgVeriler.Size = New System.Drawing.Size(1008, 359)
        Me.dgVeriler.TabIndex = 0
        '
        'GroupBox1
        '
        Me.GroupBox1.Controls.Add(Me.cbPersonel)
        Me.GroupBox1.Controls.Add(Me.Label3)
        Me.GroupBox1.Controls.Add(Me.cbSube)
        Me.GroupBox1.Controls.Add(Me.Label2)
        Me.GroupBox1.Controls.Add(Me.Label1)
        Me.GroupBox1.Controls.Add(Me.dtTarih)
        Me.GroupBox1.Location = New System.Drawing.Point(12, 41)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(306, 132)
        Me.GroupBox1.TabIndex = 1
        Me.GroupBox1.TabStop = False
        Me.GroupBox1.Text = "Gönderi Bilgileri"
        '
        'cbPersonel
        '
        Me.cbPersonel.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.cbPersonel.FormattingEnabled = True
        Me.cbPersonel.Location = New System.Drawing.Point(92, 87)
        Me.cbPersonel.Name = "cbPersonel"
        Me.cbPersonel.Size = New System.Drawing.Size(200, 21)
        Me.cbPersonel.TabIndex = 5
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(13, 91)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(48, 13)
        Me.Label3.TabIndex = 4
        Me.Label3.Text = "Personel"
        '
        'cbSube
        '
        Me.cbSube.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.cbSube.FormattingEnabled = True
        Me.cbSube.Location = New System.Drawing.Point(92, 54)
        Me.cbSube.Name = "cbSube"
        Me.cbSube.Size = New System.Drawing.Size(200, 21)
        Me.cbSube.TabIndex = 3
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(13, 58)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(32, 13)
        Me.Label2.TabIndex = 2
        Me.Label2.Text = "Şube"
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(13, 26)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(73, 13)
        Me.Label1.TabIndex = 1
        Me.Label1.Text = "Gönderi Tarihi"
        '
        'dtTarih
        '
        Me.dtTarih.Location = New System.Drawing.Point(92, 23)
        Me.dtTarih.Name = "dtTarih"
        Me.dtTarih.Size = New System.Drawing.Size(200, 20)
        Me.dtTarih.TabIndex = 0
        '
        'GroupBox2
        '
        Me.GroupBox2.Controls.Add(Me.btnMusteriSec)
        Me.GroupBox2.Controls.Add(Me.txtAdres)
        Me.GroupBox2.Controls.Add(Me.Label7)
        Me.GroupBox2.Controls.Add(Me.txtSoyad)
        Me.GroupBox2.Controls.Add(Me.Label6)
        Me.GroupBox2.Controls.Add(Me.txtAd)
        Me.GroupBox2.Controls.Add(Me.Label5)
        Me.GroupBox2.Controls.Add(Me.txtTc)
        Me.GroupBox2.Controls.Add(Me.Label4)
        Me.GroupBox2.Location = New System.Drawing.Point(324, 41)
        Me.GroupBox2.Name = "GroupBox2"
        Me.GroupBox2.Size = New System.Drawing.Size(440, 132)
        Me.GroupBox2.TabIndex = 2
        Me.GroupBox2.TabStop = False
        Me.GroupBox2.Text = "Müşteri Bilgileri"
        '
        'btnMusteriSec
        '
        Me.btnMusteriSec.Location = New System.Drawing.Point(351, 16)
        Me.btnMusteriSec.Name = "btnMusteriSec"
        Me.btnMusteriSec.Size = New System.Drawing.Size(75, 107)
        Me.btnMusteriSec.TabIndex = 8
        Me.btnMusteriSec.Text = "Müşteri Seç"
        Me.btnMusteriSec.UseVisualStyleBackColor = True
        '
        'txtAdres
        '
        Me.txtAdres.Location = New System.Drawing.Point(85, 75)
        Me.txtAdres.Multiline = True
        Me.txtAdres.Name = "txtAdres"
        Me.txtAdres.ReadOnly = True
        Me.txtAdres.Size = New System.Drawing.Size(258, 51)
        Me.txtAdres.TabIndex = 7
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.Location = New System.Drawing.Point(11, 78)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(34, 13)
        Me.Label7.TabIndex = 6
        Me.Label7.Text = "Adres"
        '
        'txtSoyad
        '
        Me.txtSoyad.Location = New System.Drawing.Point(238, 50)
        Me.txtSoyad.Name = "txtSoyad"
        Me.txtSoyad.ReadOnly = True
        Me.txtSoyad.Size = New System.Drawing.Size(105, 20)
        Me.txtSoyad.TabIndex = 5
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(195, 52)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(37, 13)
        Me.Label6.TabIndex = 4
        Me.Label6.Text = "Soyad"
        '
        'txtAd
        '
        Me.txtAd.Location = New System.Drawing.Point(85, 49)
        Me.txtAd.Name = "txtAd"
        Me.txtAd.ReadOnly = True
        Me.txtAd.Size = New System.Drawing.Size(104, 20)
        Me.txtAd.TabIndex = 3
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(11, 52)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(20, 13)
        Me.Label5.TabIndex = 2
        Me.Label5.Text = "Ad"
        '
        'txtTc
        '
        Me.txtTc.Location = New System.Drawing.Point(85, 23)
        Me.txtTc.Name = "txtTc"
        Me.txtTc.ReadOnly = True
        Me.txtTc.Size = New System.Drawing.Size(171, 20)
        Me.txtTc.TabIndex = 1
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(11, 26)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(68, 13)
        Me.Label4.TabIndex = 0
        Me.Label4.Text = "TC Kimlik No"
        '
        'btnYeniKayit
        '
        Me.btnYeniKayit.Location = New System.Drawing.Point(770, 41)
        Me.btnYeniKayit.Name = "btnYeniKayit"
        Me.btnYeniKayit.Size = New System.Drawing.Size(58, 132)
        Me.btnYeniKayit.TabIndex = 9
        Me.btnYeniKayit.Text = "Yeni Kayıt"
        Me.btnYeniKayit.UseVisualStyleBackColor = True
        '
        'btnSil
        '
        Me.btnSil.Location = New System.Drawing.Point(834, 41)
        Me.btnSil.Name = "btnSil"
        Me.btnSil.Size = New System.Drawing.Size(58, 132)
        Me.btnSil.TabIndex = 10
        Me.btnSil.Text = "Sil"
        Me.btnSil.UseVisualStyleBackColor = True
        '
        'btnKaydet
        '
        Me.btnKaydet.Location = New System.Drawing.Point(898, 41)
        Me.btnKaydet.Name = "btnKaydet"
        Me.btnKaydet.Size = New System.Drawing.Size(58, 132)
        Me.btnKaydet.TabIndex = 11
        Me.btnKaydet.Text = "Kaydet"
        Me.btnKaydet.UseVisualStyleBackColor = True
        '
        'btnAra
        '
        Me.btnAra.Location = New System.Drawing.Point(962, 41)
        Me.btnAra.Name = "btnAra"
        Me.btnAra.Size = New System.Drawing.Size(58, 132)
        Me.btnAra.TabIndex = 12
        Me.btnAra.Text = "Ara"
        Me.btnAra.UseVisualStyleBackColor = True
        '
        'txtAdet
        '
        Me.txtAdet.Location = New System.Drawing.Point(864, 552)
        Me.txtAdet.Name = "txtAdet"
        Me.txtAdet.ReadOnly = True
        Me.txtAdet.Size = New System.Drawing.Size(104, 20)
        Me.txtAdet.TabIndex = 10
        '
        'Label8
        '
        Me.Label8.AutoSize = True
        Me.Label8.Location = New System.Drawing.Point(759, 556)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(98, 13)
        Me.Label8.TabIndex = 9
        Me.Label8.Text = "Toplam Paket Adet"
        '
        'MenuStrip1
        '
        Me.MenuStrip1.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.ProgramToolStripMenuItem, Me.YenileToolStripMenuItem, Me.PersonelToolStripMenuItem, Me.ŞubeToolStripMenuItem, Me.TürToolStripMenuItem, Me.MüşteriToolStripMenuItem, Me.GönderiToolStripMenuItem, Me.HakkındaToolStripMenuItem})
        Me.MenuStrip1.Location = New System.Drawing.Point(0, 0)
        Me.MenuStrip1.Name = "MenuStrip1"
        Me.MenuStrip1.Size = New System.Drawing.Size(1032, 24)
        Me.MenuStrip1.TabIndex = 13
        Me.MenuStrip1.Text = "MenuStrip1"
        '
        'ProgramToolStripMenuItem
        '
        Me.ProgramToolStripMenuItem.DropDownItems.AddRange(New System.Windows.Forms.ToolStripItem() {Me.YenidenBaşlatToolStripMenuItem, Me.KapatToolStripMenuItem})
        Me.ProgramToolStripMenuItem.Name = "ProgramToolStripMenuItem"
        Me.ProgramToolStripMenuItem.Size = New System.Drawing.Size(65, 20)
        Me.ProgramToolStripMenuItem.Text = "Program"
        '
        'YenidenBaşlatToolStripMenuItem
        '
        Me.YenidenBaşlatToolStripMenuItem.Name = "YenidenBaşlatToolStripMenuItem"
        Me.YenidenBaşlatToolStripMenuItem.Size = New System.Drawing.Size(152, 22)
        Me.YenidenBaşlatToolStripMenuItem.Text = "Yeniden Başlat"
        '
        'KapatToolStripMenuItem
        '
        Me.KapatToolStripMenuItem.Name = "KapatToolStripMenuItem"
        Me.KapatToolStripMenuItem.Size = New System.Drawing.Size(152, 22)
        Me.KapatToolStripMenuItem.Text = "Kapat"
        '
        'PersonelToolStripMenuItem
        '
        Me.PersonelToolStripMenuItem.DropDownItems.AddRange(New System.Windows.Forms.ToolStripItem() {Me.PersonelEkleToolStripMenuItem})
        Me.PersonelToolStripMenuItem.Name = "PersonelToolStripMenuItem"
        Me.PersonelToolStripMenuItem.Size = New System.Drawing.Size(64, 20)
        Me.PersonelToolStripMenuItem.Text = "Personel"
        '
        'PersonelEkleToolStripMenuItem
        '
        Me.PersonelEkleToolStripMenuItem.Name = "PersonelEkleToolStripMenuItem"
        Me.PersonelEkleToolStripMenuItem.Size = New System.Drawing.Size(152, 22)
        Me.PersonelEkleToolStripMenuItem.Text = "Ekle"
        '
        'ŞubeToolStripMenuItem
        '
        Me.ŞubeToolStripMenuItem.DropDownItems.AddRange(New System.Windows.Forms.ToolStripItem() {Me.EkleToolStripMenuItem2})
        Me.ŞubeToolStripMenuItem.Name = "ŞubeToolStripMenuItem"
        Me.ŞubeToolStripMenuItem.Size = New System.Drawing.Size(45, 20)
        Me.ŞubeToolStripMenuItem.Text = "Şube"
        '
        'TürToolStripMenuItem
        '
        Me.TürToolStripMenuItem.DropDownItems.AddRange(New System.Windows.Forms.ToolStripItem() {Me.EkleToolStripMenuItem1})
        Me.TürToolStripMenuItem.Name = "TürToolStripMenuItem"
        Me.TürToolStripMenuItem.Size = New System.Drawing.Size(36, 20)
        Me.TürToolStripMenuItem.Text = "Tür"
        '
        'MüşteriToolStripMenuItem
        '
        Me.MüşteriToolStripMenuItem.DropDownItems.AddRange(New System.Windows.Forms.ToolStripItem() {Me.EkleToolStripMenuItem})
        Me.MüşteriToolStripMenuItem.Name = "MüşteriToolStripMenuItem"
        Me.MüşteriToolStripMenuItem.Size = New System.Drawing.Size(59, 20)
        Me.MüşteriToolStripMenuItem.Text = "Müşteri"
        '
        'GönderiToolStripMenuItem
        '
        Me.GönderiToolStripMenuItem.DropDownItems.AddRange(New System.Windows.Forms.ToolStripItem() {Me.GönderiEkleToolStripMenuItem})
        Me.GönderiToolStripMenuItem.Name = "GönderiToolStripMenuItem"
        Me.GönderiToolStripMenuItem.Size = New System.Drawing.Size(61, 20)
        Me.GönderiToolStripMenuItem.Text = "Gönderi"
        '
        'GönderiEkleToolStripMenuItem
        '
        Me.GönderiEkleToolStripMenuItem.Name = "GönderiEkleToolStripMenuItem"
        Me.GönderiEkleToolStripMenuItem.Size = New System.Drawing.Size(152, 22)
        Me.GönderiEkleToolStripMenuItem.Text = "Ekle"
        '
        'EkleToolStripMenuItem
        '
        Me.EkleToolStripMenuItem.Name = "EkleToolStripMenuItem"
        Me.EkleToolStripMenuItem.Size = New System.Drawing.Size(152, 22)
        Me.EkleToolStripMenuItem.Text = "Ekle"
        '
        'EkleToolStripMenuItem1
        '
        Me.EkleToolStripMenuItem1.Name = "EkleToolStripMenuItem1"
        Me.EkleToolStripMenuItem1.Size = New System.Drawing.Size(152, 22)
        Me.EkleToolStripMenuItem1.Text = "Ekle"
        '
        'EkleToolStripMenuItem2
        '
        Me.EkleToolStripMenuItem2.Name = "EkleToolStripMenuItem2"
        Me.EkleToolStripMenuItem2.Size = New System.Drawing.Size(152, 22)
        Me.EkleToolStripMenuItem2.Text = "Ekle"
        '
        'ContextMenuStrip1
        '
        Me.ContextMenuStrip1.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.ToolStripMenuItem1, Me.ToolStripMenuItem2, Me.ToolStripMenuItem3})
        Me.ContextMenuStrip1.Name = "ContextMenuStrip1"
        Me.ContextMenuStrip1.Size = New System.Drawing.Size(108, 70)
        '
        'ToolStripMenuItem1
        '
        Me.ToolStripMenuItem1.Name = "ToolStripMenuItem1"
        Me.ToolStripMenuItem1.Size = New System.Drawing.Size(107, 22)
        Me.ToolStripMenuItem1.Text = "Ekle"
        '
        'ToolStripMenuItem2
        '
        Me.ToolStripMenuItem2.Name = "ToolStripMenuItem2"
        Me.ToolStripMenuItem2.Size = New System.Drawing.Size(107, 22)
        Me.ToolStripMenuItem2.Text = "Düzelt"
        '
        'ToolStripMenuItem3
        '
        Me.ToolStripMenuItem3.Name = "ToolStripMenuItem3"
        Me.ToolStripMenuItem3.Size = New System.Drawing.Size(107, 22)
        Me.ToolStripMenuItem3.Text = "Sil"
        '
        'YenileToolStripMenuItem
        '
        Me.YenileToolStripMenuItem.Name = "YenileToolStripMenuItem"
        Me.YenileToolStripMenuItem.Size = New System.Drawing.Size(50, 20)
        Me.YenileToolStripMenuItem.Text = "Yenile"
        '
        'HakkındaToolStripMenuItem
        '
        Me.HakkındaToolStripMenuItem.Name = "HakkındaToolStripMenuItem"
        Me.HakkındaToolStripMenuItem.Size = New System.Drawing.Size(69, 20)
        Me.HakkındaToolStripMenuItem.Text = "Hakkında"
        '
        'Form_Anasayfa
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(1032, 580)
        Me.Controls.Add(Me.txtAdet)
        Me.Controls.Add(Me.Label8)
        Me.Controls.Add(Me.btnAra)
        Me.Controls.Add(Me.btnKaydet)
        Me.Controls.Add(Me.btnSil)
        Me.Controls.Add(Me.btnYeniKayit)
        Me.Controls.Add(Me.GroupBox2)
        Me.Controls.Add(Me.GroupBox1)
        Me.Controls.Add(Me.dgVeriler)
        Me.Controls.Add(Me.MenuStrip1)
        Me.MainMenuStrip = Me.MenuStrip1
        Me.MaximizeBox = False
        Me.Name = "Form_Anasayfa"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Kargo"
        CType(Me.dgVeriler, System.ComponentModel.ISupportInitialize).EndInit()
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox1.PerformLayout()
        Me.GroupBox2.ResumeLayout(False)
        Me.GroupBox2.PerformLayout()
        Me.MenuStrip1.ResumeLayout(False)
        Me.MenuStrip1.PerformLayout()
        Me.ContextMenuStrip1.ResumeLayout(False)
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents dgVeriler As DataGridView
    Friend WithEvents GroupBox1 As GroupBox
    Friend WithEvents cbPersonel As ComboBox
    Friend WithEvents Label3 As Label
    Friend WithEvents cbSube As ComboBox
    Friend WithEvents Label2 As Label
    Friend WithEvents Label1 As Label
    Friend WithEvents dtTarih As DateTimePicker
    Friend WithEvents GroupBox2 As GroupBox
    Friend WithEvents btnMusteriSec As Button
    Friend WithEvents txtAdres As TextBox
    Friend WithEvents Label7 As Label
    Friend WithEvents txtSoyad As TextBox
    Friend WithEvents Label6 As Label
    Friend WithEvents txtAd As TextBox
    Friend WithEvents Label5 As Label
    Friend WithEvents txtTc As TextBox
    Friend WithEvents Label4 As Label
    Friend WithEvents btnYeniKayit As Button
    Friend WithEvents btnSil As Button
    Friend WithEvents btnKaydet As Button
    Friend WithEvents btnAra As Button
    Friend WithEvents txtAdet As TextBox
    Friend WithEvents Label8 As Label
    Friend WithEvents MenuStrip1 As MenuStrip
    Friend WithEvents ProgramToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents YenidenBaşlatToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents KapatToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents PersonelToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents PersonelEkleToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents ŞubeToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents EkleToolStripMenuItem2 As ToolStripMenuItem
    Friend WithEvents TürToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents EkleToolStripMenuItem1 As ToolStripMenuItem
    Friend WithEvents MüşteriToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents EkleToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents GönderiToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents GönderiEkleToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents ContextMenuStrip1 As ContextMenuStrip
    Friend WithEvents ToolStripMenuItem1 As ToolStripMenuItem
    Friend WithEvents ToolStripMenuItem2 As ToolStripMenuItem
    Friend WithEvents ToolStripMenuItem3 As ToolStripMenuItem
    Friend WithEvents YenileToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents HakkındaToolStripMenuItem As ToolStripMenuItem
End Class
