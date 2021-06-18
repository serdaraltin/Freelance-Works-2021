<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
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
        Me.dtOgrenciler = New System.Windows.Forms.DataGridView()
        Me.btnYenile = New System.Windows.Forms.Button()
        Me.btnEkle = New System.Windows.Forms.Button()
        Me.btnGuncelle = New System.Windows.Forms.Button()
        Me.btnSil = New System.Windows.Forms.Button()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.txtId = New System.Windows.Forms.TextBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.txtAdi = New System.Windows.Forms.TextBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.txtSoyadi = New System.Windows.Forms.TextBox()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.txtVize1 = New System.Windows.Forms.TextBox()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.txtVize2 = New System.Windows.Forms.TextBox()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.txtFinal = New System.Windows.Forms.TextBox()
        Me.Label7 = New System.Windows.Forms.Label()
        Me.txtBasariNotu = New System.Windows.Forms.TextBox()
        Me.Label8 = New System.Windows.Forms.Label()
        Me.txtOkulNo = New System.Windows.Forms.TextBox()
        CType(Me.dtOgrenciler, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'dtOgrenciler
        '
        Me.dtOgrenciler.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill
        Me.dtOgrenciler.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.dtOgrenciler.Location = New System.Drawing.Point(13, 56)
        Me.dtOgrenciler.Margin = New System.Windows.Forms.Padding(4)
        Me.dtOgrenciler.MultiSelect = False
        Me.dtOgrenciler.Name = "dtOgrenciler"
        Me.dtOgrenciler.ReadOnly = True
        Me.dtOgrenciler.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect
        Me.dtOgrenciler.Size = New System.Drawing.Size(564, 336)
        Me.dtOgrenciler.TabIndex = 0
        '
        'btnYenile
        '
        Me.btnYenile.Location = New System.Drawing.Point(13, 13)
        Me.btnYenile.Margin = New System.Windows.Forms.Padding(4)
        Me.btnYenile.Name = "btnYenile"
        Me.btnYenile.Size = New System.Drawing.Size(100, 35)
        Me.btnYenile.TabIndex = 0
        Me.btnYenile.Text = "YENİLE"
        Me.btnYenile.UseVisualStyleBackColor = True
        '
        'btnEkle
        '
        Me.btnEkle.Location = New System.Drawing.Point(672, 289)
        Me.btnEkle.Margin = New System.Windows.Forms.Padding(4)
        Me.btnEkle.Name = "btnEkle"
        Me.btnEkle.Size = New System.Drawing.Size(100, 35)
        Me.btnEkle.TabIndex = 9
        Me.btnEkle.Text = "EKLE"
        Me.btnEkle.UseVisualStyleBackColor = True
        '
        'btnGuncelle
        '
        Me.btnGuncelle.Location = New System.Drawing.Point(672, 332)
        Me.btnGuncelle.Margin = New System.Windows.Forms.Padding(4)
        Me.btnGuncelle.Name = "btnGuncelle"
        Me.btnGuncelle.Size = New System.Drawing.Size(190, 35)
        Me.btnGuncelle.TabIndex = 11
        Me.btnGuncelle.Text = "GÜNCELLE"
        Me.btnGuncelle.UseVisualStyleBackColor = True
        '
        'btnSil
        '
        Me.btnSil.Location = New System.Drawing.Point(780, 289)
        Me.btnSil.Margin = New System.Windows.Forms.Padding(4)
        Me.btnSil.Name = "btnSil"
        Me.btnSil.Size = New System.Drawing.Size(82, 35)
        Me.btnSil.TabIndex = 10
        Me.btnSil.Text = "SİL"
        Me.btnSil.UseVisualStyleBackColor = True
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(647, 59)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(19, 17)
        Me.Label1.TabIndex = 5
        Me.Label1.Text = "Id"
        '
        'txtId
        '
        Me.txtId.Location = New System.Drawing.Point(672, 56)
        Me.txtId.Name = "txtId"
        Me.txtId.ReadOnly = True
        Me.txtId.Size = New System.Drawing.Size(50, 23)
        Me.txtId.TabIndex = 1
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(607, 88)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(59, 17)
        Me.Label2.TabIndex = 7
        Me.Label2.Text = "Okul No"
        '
        'txtAdi
        '
        Me.txtAdi.Location = New System.Drawing.Point(672, 114)
        Me.txtAdi.Name = "txtAdi"
        Me.txtAdi.Size = New System.Drawing.Size(190, 23)
        Me.txtAdi.TabIndex = 3
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(638, 117)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(28, 17)
        Me.Label3.TabIndex = 9
        Me.Label3.Text = "Adı"
        '
        'txtSoyadi
        '
        Me.txtSoyadi.Location = New System.Drawing.Point(672, 143)
        Me.txtSoyadi.Name = "txtSoyadi"
        Me.txtSoyadi.Size = New System.Drawing.Size(190, 23)
        Me.txtSoyadi.TabIndex = 4
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(615, 146)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(51, 17)
        Me.Label4.TabIndex = 11
        Me.Label4.Text = "Soyadı"
        '
        'txtVize1
        '
        Me.txtVize1.Location = New System.Drawing.Point(672, 172)
        Me.txtVize1.Name = "txtVize1"
        Me.txtVize1.Size = New System.Drawing.Size(190, 23)
        Me.txtVize1.TabIndex = 5
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(619, 175)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(47, 17)
        Me.Label5.TabIndex = 13
        Me.Label5.Text = "Vize 1"
        '
        'txtVize2
        '
        Me.txtVize2.Location = New System.Drawing.Point(672, 201)
        Me.txtVize2.Name = "txtVize2"
        Me.txtVize2.Size = New System.Drawing.Size(190, 23)
        Me.txtVize2.TabIndex = 6
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(619, 204)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(47, 17)
        Me.Label6.TabIndex = 15
        Me.Label6.Text = "Vize 2"
        '
        'txtFinal
        '
        Me.txtFinal.Location = New System.Drawing.Point(672, 230)
        Me.txtFinal.Name = "txtFinal"
        Me.txtFinal.Size = New System.Drawing.Size(190, 23)
        Me.txtFinal.TabIndex = 7
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.Location = New System.Drawing.Point(628, 233)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(38, 17)
        Me.Label7.TabIndex = 17
        Me.Label7.Text = "Final"
        '
        'txtBasariNotu
        '
        Me.txtBasariNotu.Location = New System.Drawing.Point(672, 259)
        Me.txtBasariNotu.Name = "txtBasariNotu"
        Me.txtBasariNotu.Size = New System.Drawing.Size(190, 23)
        Me.txtBasariNotu.TabIndex = 8
        '
        'Label8
        '
        Me.Label8.AutoSize = True
        Me.Label8.Location = New System.Drawing.Point(584, 262)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(82, 17)
        Me.Label8.TabIndex = 19
        Me.Label8.Text = "Başarı Notu"
        '
        'txtOkulNo
        '
        Me.txtOkulNo.Location = New System.Drawing.Point(672, 85)
        Me.txtOkulNo.Name = "txtOkulNo"
        Me.txtOkulNo.Size = New System.Drawing.Size(190, 23)
        Me.txtOkulNo.TabIndex = 20
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(8.0!, 16.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(874, 404)
        Me.Controls.Add(Me.txtOkulNo)
        Me.Controls.Add(Me.txtBasariNotu)
        Me.Controls.Add(Me.Label8)
        Me.Controls.Add(Me.txtFinal)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.txtVize2)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.txtVize1)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.txtSoyadi)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.txtAdi)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.txtId)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.btnSil)
        Me.Controls.Add(Me.btnGuncelle)
        Me.Controls.Add(Me.btnEkle)
        Me.Controls.Add(Me.btnYenile)
        Me.Controls.Add(Me.dtOgrenciler)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(162, Byte))
        Me.Margin = New System.Windows.Forms.Padding(4)
        Me.MaximizeBox = False
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = " batuangrbz"
        CType(Me.dtOgrenciler, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents dtOgrenciler As DataGridView
    Friend WithEvents btnYenile As Button
    Friend WithEvents btnEkle As Button
    Friend WithEvents btnGuncelle As Button
    Friend WithEvents btnSil As Button
    Friend WithEvents Label1 As Label
    Friend WithEvents txtId As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents txtAdi As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents txtSoyadi As TextBox
    Friend WithEvents Label4 As Label
    Friend WithEvents txtVize1 As TextBox
    Friend WithEvents Label5 As Label
    Friend WithEvents txtVize2 As TextBox
    Friend WithEvents Label6 As Label
    Friend WithEvents txtFinal As TextBox
    Friend WithEvents Label7 As Label
    Friend WithEvents txtBasariNotu As TextBox
    Friend WithEvents Label8 As Label
    Friend WithEvents txtOkulNo As TextBox
End Class
