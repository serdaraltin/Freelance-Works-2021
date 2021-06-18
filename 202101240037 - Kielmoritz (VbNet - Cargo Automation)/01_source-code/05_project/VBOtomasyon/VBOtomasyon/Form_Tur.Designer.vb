<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form_Tur
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
        Me.btnSil = New System.Windows.Forms.Button()
        Me.btnEkle = New System.Windows.Forms.Button()
        Me.txtAd = New System.Windows.Forms.TextBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.txtPaketBirimi = New System.Windows.Forms.TextBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.txtBirimFiyati = New System.Windows.Forms.MaskedTextBox()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.SuspendLayout()
        '
        'btnSil
        '
        Me.btnSil.Location = New System.Drawing.Point(172, 141)
        Me.btnSil.Name = "btnSil"
        Me.btnSil.Size = New System.Drawing.Size(126, 50)
        Me.btnSil.TabIndex = 4
        Me.btnSil.Text = "SİL"
        Me.btnSil.UseVisualStyleBackColor = True
        Me.btnSil.Visible = False
        '
        'btnEkle
        '
        Me.btnEkle.Location = New System.Drawing.Point(22, 141)
        Me.btnEkle.Name = "btnEkle"
        Me.btnEkle.Size = New System.Drawing.Size(144, 50)
        Me.btnEkle.TabIndex = 3
        Me.btnEkle.Text = "EKLE"
        Me.btnEkle.UseVisualStyleBackColor = True
        '
        'txtAd
        '
        Me.txtAd.Location = New System.Drawing.Point(96, 27)
        Me.txtAd.Name = "txtAd"
        Me.txtAd.Size = New System.Drawing.Size(211, 21)
        Me.txtAd.TabIndex = 0
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(16, 30)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(45, 15)
        Me.Label1.TabIndex = 13
        Me.Label1.Text = "Tür Adı"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(16, 60)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(73, 15)
        Me.Label2.TabIndex = 15
        Me.Label2.Text = "Paket Birimi"
        '
        'txtPaketBirimi
        '
        Me.txtPaketBirimi.Location = New System.Drawing.Point(96, 57)
        Me.txtPaketBirimi.Name = "txtPaketBirimi"
        Me.txtPaketBirimi.Size = New System.Drawing.Size(211, 21)
        Me.txtPaketBirimi.TabIndex = 1
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(16, 90)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(67, 15)
        Me.Label3.TabIndex = 17
        Me.Label3.Text = "Birim Fiyatı"
        '
        'txtBirimFiyati
        '
        Me.txtBirimFiyati.Location = New System.Drawing.Point(96, 87)
        Me.txtBirimFiyati.Name = "txtBirimFiyati"
        Me.txtBirimFiyati.Size = New System.Drawing.Size(88, 21)
        Me.txtBirimFiyati.TabIndex = 2
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(190, 90)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(85, 15)
        Me.Label4.TabIndex = 18
        Me.Label4.Text = "Küsürat için ""."""
        '
        'Form_Tur
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(327, 210)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.txtBirimFiyati)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.txtPaketBirimi)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.btnSil)
        Me.Controls.Add(Me.btnEkle)
        Me.Controls.Add(Me.txtAd)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(162, Byte))
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
        Me.Name = "Form_Tur"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Tür"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents btnSil As Button
    Friend WithEvents btnEkle As Button
    Friend WithEvents txtAd As TextBox
    Friend WithEvents Label1 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents txtPaketBirimi As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents txtBirimFiyati As MaskedTextBox
    Friend WithEvents Label4 As Label
End Class
