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
        Me.components = New System.ComponentModel.Container()
        Me.lstSayilar = New System.Windows.Forms.ListBox()
        Me.RadioButton1 = New System.Windows.Forms.RadioButton()
        Me.RadioButton2 = New System.Windows.Forms.RadioButton()
        Me.RadioButton3 = New System.Windows.Forms.RadioButton()
        Me.RadioButton4 = New System.Windows.Forms.RadioButton()
        Me.Timer1 = New System.Windows.Forms.Timer(Me.components)
        Me.txtSure = New System.Windows.Forms.Label()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.txtSayi = New System.Windows.Forms.TextBox()
        Me.btnEkle = New System.Windows.Forms.Button()
        Me.btnHesapla = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'lstSayilar
        '
        Me.lstSayilar.FormattingEnabled = True
        Me.lstSayilar.ItemHeight = 15
        Me.lstSayilar.Location = New System.Drawing.Point(12, 54)
        Me.lstSayilar.Name = "lstSayilar"
        Me.lstSayilar.Size = New System.Drawing.Size(57, 214)
        Me.lstSayilar.TabIndex = 0
        '
        'RadioButton1
        '
        Me.RadioButton1.AutoSize = True
        Me.RadioButton1.Location = New System.Drawing.Point(75, 91)
        Me.RadioButton1.Name = "RadioButton1"
        Me.RadioButton1.Size = New System.Drawing.Size(173, 19)
        Me.RadioButton1.TabIndex = 1
        Me.RadioButton1.TabStop = True
        Me.RadioButton1.Text = "Negatif sayıların ortalaması"
        Me.RadioButton1.UseVisualStyleBackColor = True
        '
        'RadioButton2
        '
        Me.RadioButton2.AutoSize = True
        Me.RadioButton2.Location = New System.Drawing.Point(75, 118)
        Me.RadioButton2.Name = "RadioButton2"
        Me.RadioButton2.Size = New System.Drawing.Size(167, 19)
        Me.RadioButton2.TabIndex = 2
        Me.RadioButton2.TabStop = True
        Me.RadioButton2.Text = "Pozitif sayıların ortalaması"
        Me.RadioButton2.UseVisualStyleBackColor = True
        '
        'RadioButton3
        '
        Me.RadioButton3.AutoSize = True
        Me.RadioButton3.Location = New System.Drawing.Point(75, 145)
        Me.RadioButton3.Name = "RadioButton3"
        Me.RadioButton3.Size = New System.Drawing.Size(241, 19)
        Me.RadioButton3.TabIndex = 3
        Me.RadioButton3.TabStop = True
        Me.RadioButton3.Text = "Ortalamadan büyük olan sayıların listesi"
        Me.RadioButton3.UseVisualStyleBackColor = True
        '
        'RadioButton4
        '
        Me.RadioButton4.AutoSize = True
        Me.RadioButton4.Location = New System.Drawing.Point(75, 171)
        Me.RadioButton4.Name = "RadioButton4"
        Me.RadioButton4.Size = New System.Drawing.Size(241, 19)
        Me.RadioButton4.TabIndex = 4
        Me.RadioButton4.TabStop = True
        Me.RadioButton4.Text = "Ortalamadan küçük olan sayıların listesi"
        Me.RadioButton4.UseVisualStyleBackColor = True
        '
        'Timer1
        '
        Me.Timer1.Interval = 1000
        '
        'txtSure
        '
        Me.txtSure.AutoSize = True
        Me.txtSure.Location = New System.Drawing.Point(10, 281)
        Me.txtSure.Name = "txtSure"
        Me.txtSure.Size = New System.Drawing.Size(14, 15)
        Me.txtSure.TabIndex = 5
        Me.txtSure.Text = "0"
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(8, 28)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(61, 15)
        Me.Label1.TabIndex = 6
        Me.Label1.Text = "Sayı Girişi"
        '
        'txtSayi
        '
        Me.txtSayi.Location = New System.Drawing.Point(75, 25)
        Me.txtSayi.Name = "txtSayi"
        Me.txtSayi.Size = New System.Drawing.Size(100, 21)
        Me.txtSayi.TabIndex = 7
        '
        'btnEkle
        '
        Me.btnEkle.Location = New System.Drawing.Point(181, 24)
        Me.btnEkle.Name = "btnEkle"
        Me.btnEkle.Size = New System.Drawing.Size(75, 23)
        Me.btnEkle.TabIndex = 8
        Me.btnEkle.Text = "EKLE"
        Me.btnEkle.UseVisualStyleBackColor = True
        '
        'btnHesapla
        '
        Me.btnHesapla.Enabled = False
        Me.btnHesapla.Location = New System.Drawing.Point(75, 228)
        Me.btnHesapla.Name = "btnHesapla"
        Me.btnHesapla.Size = New System.Drawing.Size(241, 40)
        Me.btnHesapla.TabIndex = 9
        Me.btnHesapla.Text = "HESAPLA"
        Me.btnHesapla.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(330, 304)
        Me.Controls.Add(Me.btnHesapla)
        Me.Controls.Add(Me.btnEkle)
        Me.Controls.Add(Me.txtSayi)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.txtSure)
        Me.Controls.Add(Me.RadioButton4)
        Me.Controls.Add(Me.RadioButton3)
        Me.Controls.Add(Me.RadioButton2)
        Me.Controls.Add(Me.RadioButton1)
        Me.Controls.Add(Me.lstSayilar)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents lstSayilar As ListBox
    Friend WithEvents RadioButton1 As RadioButton
    Friend WithEvents RadioButton2 As RadioButton
    Friend WithEvents RadioButton3 As RadioButton
    Friend WithEvents RadioButton4 As RadioButton
    Friend WithEvents Timer1 As Timer
    Friend WithEvents txtSure As Label
    Friend WithEvents Label1 As Label
    Friend WithEvents txtSayi As TextBox
    Friend WithEvents btnEkle As Button
    Friend WithEvents btnHesapla As Button
End Class
