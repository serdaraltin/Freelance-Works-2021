<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form_Musteri
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
        Me.txtTc = New System.Windows.Forms.MaskedTextBox()
        Me.txtAd = New System.Windows.Forms.TextBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.txtSoyad = New System.Windows.Forms.TextBox()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.txtAdres = New System.Windows.Forms.TextBox()
        Me.btnEkle = New System.Windows.Forms.Button()
        Me.btnSil = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(17, 28)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(76, 15)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Tc Kimlik No"
        '
        'txtTc
        '
        Me.txtTc.Location = New System.Drawing.Point(102, 25)
        Me.txtTc.Mask = "00000000000"
        Me.txtTc.Name = "txtTc"
        Me.txtTc.Size = New System.Drawing.Size(123, 21)
        Me.txtTc.TabIndex = 0
        '
        'txtAd
        '
        Me.txtAd.Location = New System.Drawing.Point(102, 53)
        Me.txtAd.Name = "txtAd"
        Me.txtAd.Size = New System.Drawing.Size(190, 21)
        Me.txtAd.TabIndex = 1
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(17, 56)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(21, 15)
        Me.Label2.TabIndex = 3
        Me.Label2.Text = "Ad"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(17, 83)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(44, 15)
        Me.Label3.TabIndex = 5
        Me.Label3.Text = "Soyadı"
        '
        'txtSoyad
        '
        Me.txtSoyad.Location = New System.Drawing.Point(102, 80)
        Me.txtSoyad.Name = "txtSoyad"
        Me.txtSoyad.Size = New System.Drawing.Size(190, 21)
        Me.txtSoyad.TabIndex = 2
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(17, 110)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(38, 15)
        Me.Label4.TabIndex = 7
        Me.Label4.Text = "Adres"
        '
        'txtAdres
        '
        Me.txtAdres.Location = New System.Drawing.Point(102, 107)
        Me.txtAdres.Multiline = True
        Me.txtAdres.Name = "txtAdres"
        Me.txtAdres.Size = New System.Drawing.Size(190, 73)
        Me.txtAdres.TabIndex = 3
        '
        'btnEkle
        '
        Me.btnEkle.Location = New System.Drawing.Point(20, 191)
        Me.btnEkle.Name = "btnEkle"
        Me.btnEkle.Size = New System.Drawing.Size(141, 49)
        Me.btnEkle.TabIndex = 4
        Me.btnEkle.Text = "EKLE"
        Me.btnEkle.UseVisualStyleBackColor = True
        '
        'btnSil
        '
        Me.btnSil.Location = New System.Drawing.Point(167, 191)
        Me.btnSil.Name = "btnSil"
        Me.btnSil.Size = New System.Drawing.Size(125, 49)
        Me.btnSil.TabIndex = 5
        Me.btnSil.Text = "SİL"
        Me.btnSil.UseVisualStyleBackColor = True
        Me.btnSil.Visible = False
        '
        'Form_Musteri
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(311, 267)
        Me.Controls.Add(Me.btnSil)
        Me.Controls.Add(Me.btnEkle)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.txtAdres)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.txtSoyad)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.txtAd)
        Me.Controls.Add(Me.txtTc)
        Me.Controls.Add(Me.Label1)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(162, Byte))
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
        Me.Name = "Form_Musteri"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Müşteri"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents txtTc As MaskedTextBox
    Friend WithEvents txtAd As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents txtSoyad As TextBox
    Friend WithEvents Label4 As Label
    Friend WithEvents txtAdres As TextBox
    Friend WithEvents btnEkle As Button
    Friend WithEvents btnSil As Button
End Class
