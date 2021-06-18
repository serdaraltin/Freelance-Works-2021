<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form_Personel
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
        Me.txtAd = New System.Windows.Forms.TextBox()
        Me.txtSoyad = New System.Windows.Forms.TextBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.btnSil = New System.Windows.Forms.Button()
        Me.btnEkle = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(27, 34)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(21, 15)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Ad"
        '
        'txtAd
        '
        Me.txtAd.Location = New System.Drawing.Point(87, 31)
        Me.txtAd.Name = "txtAd"
        Me.txtAd.Size = New System.Drawing.Size(196, 21)
        Me.txtAd.TabIndex = 0
        '
        'txtSoyad
        '
        Me.txtSoyad.Location = New System.Drawing.Point(87, 58)
        Me.txtSoyad.Name = "txtSoyad"
        Me.txtSoyad.Size = New System.Drawing.Size(196, 21)
        Me.txtSoyad.TabIndex = 1
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(27, 61)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(41, 15)
        Me.Label2.TabIndex = 2
        Me.Label2.Text = "Soyad"
        '
        'btnSil
        '
        Me.btnSil.Location = New System.Drawing.Point(166, 112)
        Me.btnSil.Name = "btnSil"
        Me.btnSil.Size = New System.Drawing.Size(125, 49)
        Me.btnSil.TabIndex = 3
        Me.btnSil.Text = "SİL"
        Me.btnSil.UseVisualStyleBackColor = True
        Me.btnSil.Visible = False
        '
        'btnEkle
        '
        Me.btnEkle.Location = New System.Drawing.Point(19, 112)
        Me.btnEkle.Name = "btnEkle"
        Me.btnEkle.Size = New System.Drawing.Size(141, 49)
        Me.btnEkle.TabIndex = 2
        Me.btnEkle.Text = "EKLE"
        Me.btnEkle.UseVisualStyleBackColor = True
        '
        'Form_Personel
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(319, 183)
        Me.Controls.Add(Me.btnSil)
        Me.Controls.Add(Me.btnEkle)
        Me.Controls.Add(Me.txtSoyad)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.txtAd)
        Me.Controls.Add(Me.Label1)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(162, Byte))
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.SizableToolWindow
        Me.Name = "Form_Personel"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Personel"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents txtAd As TextBox
    Friend WithEvents txtSoyad As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents btnSil As Button
    Friend WithEvents btnEkle As Button
End Class
