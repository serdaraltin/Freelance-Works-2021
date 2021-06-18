<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form_Gonderi
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
        Me.dtTarih = New System.Windows.Forms.DateTimePicker()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.cbSube = New System.Windows.Forms.ComboBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.cbPersonel = New System.Windows.Forms.ComboBox()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.cbMusteri = New System.Windows.Forms.ComboBox()
        Me.btnSil = New System.Windows.Forms.Button()
        Me.btnEkle = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'dtTarih
        '
        Me.dtTarih.Location = New System.Drawing.Point(113, 23)
        Me.dtTarih.Name = "dtTarih"
        Me.dtTarih.Size = New System.Drawing.Size(206, 21)
        Me.dtTarih.TabIndex = 0
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(21, 26)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(85, 15)
        Me.Label1.TabIndex = 1
        Me.Label1.Text = "Gönderi Tarihi"
        '
        'cbSube
        '
        Me.cbSube.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.cbSube.FormattingEnabled = True
        Me.cbSube.Location = New System.Drawing.Point(113, 53)
        Me.cbSube.Name = "cbSube"
        Me.cbSube.Size = New System.Drawing.Size(206, 23)
        Me.cbSube.TabIndex = 1
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(21, 57)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(36, 15)
        Me.Label2.TabIndex = 3
        Me.Label2.Text = "Şube"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(21, 88)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(56, 15)
        Me.Label3.TabIndex = 5
        Me.Label3.Text = "Personel"
        '
        'cbPersonel
        '
        Me.cbPersonel.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.cbPersonel.FormattingEnabled = True
        Me.cbPersonel.Location = New System.Drawing.Point(113, 84)
        Me.cbPersonel.Name = "cbPersonel"
        Me.cbPersonel.Size = New System.Drawing.Size(206, 23)
        Me.cbPersonel.TabIndex = 2
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(21, 120)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(48, 15)
        Me.Label4.TabIndex = 7
        Me.Label4.Text = "Müşteri"
        '
        'cbMusteri
        '
        Me.cbMusteri.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.cbMusteri.FormattingEnabled = True
        Me.cbMusteri.Location = New System.Drawing.Point(113, 115)
        Me.cbMusteri.Name = "cbMusteri"
        Me.cbMusteri.Size = New System.Drawing.Size(206, 23)
        Me.cbMusteri.TabIndex = 3
        '
        'btnSil
        '
        Me.btnSil.Location = New System.Drawing.Point(184, 172)
        Me.btnSil.Name = "btnSil"
        Me.btnSil.Size = New System.Drawing.Size(126, 50)
        Me.btnSil.TabIndex = 5
        Me.btnSil.Text = "SİL"
        Me.btnSil.UseVisualStyleBackColor = True
        Me.btnSil.Visible = False
        '
        'btnEkle
        '
        Me.btnEkle.Location = New System.Drawing.Point(34, 172)
        Me.btnEkle.Name = "btnEkle"
        Me.btnEkle.Size = New System.Drawing.Size(144, 50)
        Me.btnEkle.TabIndex = 4
        Me.btnEkle.Text = "EKLE"
        Me.btnEkle.UseVisualStyleBackColor = True
        '
        'Form_Gonderi
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(342, 243)
        Me.Controls.Add(Me.btnSil)
        Me.Controls.Add(Me.btnEkle)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.cbMusteri)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.cbPersonel)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.cbSube)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.dtTarih)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(162, Byte))
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
        Me.Name = "Form_Gonderi"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Gönderi"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents dtTarih As DateTimePicker
    Friend WithEvents Label1 As Label
    Friend WithEvents cbSube As ComboBox
    Friend WithEvents Label2 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents cbPersonel As ComboBox
    Friend WithEvents Label4 As Label
    Friend WithEvents cbMusteri As ComboBox
    Friend WithEvents btnSil As Button
    Friend WithEvents btnEkle As Button
End Class
