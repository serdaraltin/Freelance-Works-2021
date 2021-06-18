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
        Me.Label1 = New System.Windows.Forms.Label()
        Me.txtOgrenciNo = New System.Windows.Forms.TextBox()
        Me.btnKaydet = New System.Windows.Forms.Button()
        Me.btnGuncelle = New System.Windows.Forms.Button()
        Me.txtAd = New System.Windows.Forms.TextBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.btnSil = New System.Windows.Forms.Button()
        Me.txtSoyad = New System.Windows.Forms.TextBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.lstVeri = New System.Windows.Forms.ListView()
        Me.SNo = CType(New System.Windows.Forms.ColumnHeader(), System.Windows.Forms.ColumnHeader)
        Me.Ad = CType(New System.Windows.Forms.ColumnHeader(), System.Windows.Forms.ColumnHeader)
        Me.Soyad = CType(New System.Windows.Forms.ColumnHeader(), System.Windows.Forms.ColumnHeader)
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(38, 33)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(69, 15)
        Me.Label1.TabIndex = 1
        Me.Label1.Text = "Öğrenci No"
        '
        'txtOgrenciNo
        '
        Me.txtOgrenciNo.Location = New System.Drawing.Point(113, 30)
        Me.txtOgrenciNo.Name = "txtOgrenciNo"
        Me.txtOgrenciNo.Size = New System.Drawing.Size(145, 21)
        Me.txtOgrenciNo.TabIndex = 2
        '
        'btnKaydet
        '
        Me.btnKaydet.Location = New System.Drawing.Point(266, 29)
        Me.btnKaydet.Name = "btnKaydet"
        Me.btnKaydet.Size = New System.Drawing.Size(94, 27)
        Me.btnKaydet.TabIndex = 3
        Me.btnKaydet.Text = "Kaydet"
        Me.btnKaydet.UseVisualStyleBackColor = True
        '
        'btnGuncelle
        '
        Me.btnGuncelle.Location = New System.Drawing.Point(266, 59)
        Me.btnGuncelle.Name = "btnGuncelle"
        Me.btnGuncelle.Size = New System.Drawing.Size(94, 27)
        Me.btnGuncelle.TabIndex = 6
        Me.btnGuncelle.Text = "Güncelle"
        Me.btnGuncelle.UseVisualStyleBackColor = True
        '
        'txtAd
        '
        Me.txtAd.Location = New System.Drawing.Point(113, 60)
        Me.txtAd.Name = "txtAd"
        Me.txtAd.Size = New System.Drawing.Size(145, 21)
        Me.txtAd.TabIndex = 5
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label2.Location = New System.Drawing.Point(86, 63)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(21, 15)
        Me.Label2.TabIndex = 4
        Me.Label2.Text = "Ad"
        '
        'btnSil
        '
        Me.btnSil.Location = New System.Drawing.Point(266, 89)
        Me.btnSil.Name = "btnSil"
        Me.btnSil.Size = New System.Drawing.Size(94, 27)
        Me.btnSil.TabIndex = 9
        Me.btnSil.Text = "Sil"
        Me.btnSil.UseVisualStyleBackColor = True
        '
        'txtSoyad
        '
        Me.txtSoyad.Location = New System.Drawing.Point(113, 90)
        Me.txtSoyad.Name = "txtSoyad"
        Me.txtSoyad.Size = New System.Drawing.Size(145, 21)
        Me.txtSoyad.TabIndex = 8
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label3.Location = New System.Drawing.Point(66, 93)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(41, 15)
        Me.Label3.TabIndex = 7
        Me.Label3.Text = "Soyad"
        '
        'lstVeri
        '
        Me.lstVeri.Columns.AddRange(New System.Windows.Forms.ColumnHeader() {Me.SNo, Me.Ad, Me.Soyad})
        Me.lstVeri.FullRowSelect = True
        Me.lstVeri.GridLines = True
        Me.lstVeri.Location = New System.Drawing.Point(12, 122)
        Me.lstVeri.Name = "lstVeri"
        Me.lstVeri.Size = New System.Drawing.Size(348, 122)
        Me.lstVeri.TabIndex = 10
        Me.lstVeri.UseCompatibleStateImageBehavior = False
        Me.lstVeri.View = System.Windows.Forms.View.Details
        '
        'SNo
        '
        Me.SNo.Text = "SNo"
        '
        'Ad
        '
        Me.Ad.Text = "Ad"
        Me.Ad.Width = 130
        '
        'Soyad
        '
        Me.Soyad.Text = "Soyad"
        Me.Soyad.Width = 130
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(377, 256)
        Me.Controls.Add(Me.lstVeri)
        Me.Controls.Add(Me.btnSil)
        Me.Controls.Add(Me.txtSoyad)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.btnGuncelle)
        Me.Controls.Add(Me.txtAd)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.btnKaydet)
        Me.Controls.Add(Me.txtOgrenciNo)
        Me.Controls.Add(Me.Label1)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Öğrn_Kyt"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Label1 As Label
    Friend WithEvents txtOgrenciNo As TextBox
    Friend WithEvents btnKaydet As Button
    Friend WithEvents btnGuncelle As Button
    Friend WithEvents txtAd As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents btnSil As Button
    Friend WithEvents txtSoyad As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents lstVeri As ListView
    Friend WithEvents SNo As ColumnHeader
    Friend WithEvents Ad As ColumnHeader
    Friend WithEvents Soyad As ColumnHeader
End Class
