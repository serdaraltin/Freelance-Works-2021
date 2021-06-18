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
        Me.txtUrunAd = New System.Windows.Forms.TextBox()
        Me.txtBirimFiyat = New System.Windows.Forms.TextBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.txtAdet = New System.Windows.Forms.TextBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.chKdv = New System.Windows.Forms.CheckBox()
        Me.btnHesapla = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(21, 31)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(54, 15)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Ürün Adı"
        '
        'txtUrunAd
        '
        Me.txtUrunAd.Location = New System.Drawing.Point(81, 28)
        Me.txtUrunAd.Name = "txtUrunAd"
        Me.txtUrunAd.Size = New System.Drawing.Size(165, 21)
        Me.txtUrunAd.TabIndex = 1
        '
        'txtBirimFiyat
        '
        Me.txtBirimFiyat.Location = New System.Drawing.Point(81, 55)
        Me.txtBirimFiyat.Name = "txtBirimFiyat"
        Me.txtBirimFiyat.Size = New System.Drawing.Size(165, 21)
        Me.txtBirimFiyat.TabIndex = 3
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(8, 58)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(67, 15)
        Me.Label2.TabIndex = 2
        Me.Label2.Text = "Birim Fiyatı"
        '
        'txtAdet
        '
        Me.txtAdet.Location = New System.Drawing.Point(81, 82)
        Me.txtAdet.Name = "txtAdet"
        Me.txtAdet.Size = New System.Drawing.Size(165, 21)
        Me.txtAdet.TabIndex = 5
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(44, 85)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(31, 15)
        Me.Label3.TabIndex = 4
        Me.Label3.Text = "Adet"
        '
        'chKdv
        '
        Me.chKdv.AutoSize = True
        Me.chKdv.Location = New System.Drawing.Point(81, 111)
        Me.chKdv.Name = "chKdv"
        Me.chKdv.Size = New System.Drawing.Size(110, 19)
        Me.chKdv.TabIndex = 6
        Me.chKdv.Text = "%15 KDV Dahil"
        Me.chKdv.UseVisualStyleBackColor = True
        '
        'btnHesapla
        '
        Me.btnHesapla.Location = New System.Drawing.Point(81, 136)
        Me.btnHesapla.Name = "btnHesapla"
        Me.btnHesapla.Size = New System.Drawing.Size(165, 36)
        Me.btnHesapla.TabIndex = 7
        Me.btnHesapla.Text = "HESAPLA"
        Me.btnHesapla.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(269, 189)
        Me.Controls.Add(Me.btnHesapla)
        Me.Controls.Add(Me.chKdv)
        Me.Controls.Add(Me.txtAdet)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.txtBirimFiyat)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.txtUrunAd)
        Me.Controls.Add(Me.Label1)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "KDV"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents txtUrunAd As TextBox
    Friend WithEvents txtBirimFiyat As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents txtAdet As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents chKdv As CheckBox
    Friend WithEvents btnHesapla As Button
End Class
