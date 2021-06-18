<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form_GonderilenPaket
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
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.cbTur = New System.Windows.Forms.ComboBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.dtTarih = New System.Windows.Forms.DateTimePicker()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.cbGonderi = New System.Windows.Forms.ComboBox()
        Me.txtAdres = New System.Windows.Forms.TextBox()
        Me.ndPaketAdedi = New System.Windows.Forms.NumericUpDown()
        CType(Me.ndPaketAdedi, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'btnSil
        '
        Me.btnSil.Location = New System.Drawing.Point(202, 240)
        Me.btnSil.Name = "btnSil"
        Me.btnSil.Size = New System.Drawing.Size(147, 51)
        Me.btnSil.TabIndex = 6
        Me.btnSil.Text = "SİL"
        Me.btnSil.UseVisualStyleBackColor = True
        Me.btnSil.Visible = False
        '
        'btnEkle
        '
        Me.btnEkle.Location = New System.Drawing.Point(27, 240)
        Me.btnEkle.Name = "btnEkle"
        Me.btnEkle.Size = New System.Drawing.Size(168, 51)
        Me.btnEkle.TabIndex = 5
        Me.btnEkle.Text = "EKLE"
        Me.btnEkle.UseVisualStyleBackColor = True
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(16, 163)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(72, 15)
        Me.Label4.TabIndex = 19
        Me.Label4.Text = "Paket Adedi"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(16, 88)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(38, 15)
        Me.Label3.TabIndex = 17
        Me.Label3.Text = "Adres"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(16, 29)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(25, 15)
        Me.Label2.TabIndex = 15
        Me.Label2.Text = "Tür"
        '
        'cbTur
        '
        Me.cbTur.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.cbTur.FormattingEnabled = True
        Me.cbTur.Location = New System.Drawing.Point(109, 24)
        Me.cbTur.Name = "cbTur"
        Me.cbTur.Size = New System.Drawing.Size(240, 23)
        Me.cbTur.TabIndex = 0
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(16, 59)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(35, 15)
        Me.Label1.TabIndex = 13
        Me.Label1.Text = "Tarih"
        '
        'dtTarih
        '
        Me.dtTarih.Location = New System.Drawing.Point(109, 56)
        Me.dtTarih.Name = "dtTarih"
        Me.dtTarih.Size = New System.Drawing.Size(240, 21)
        Me.dtTarih.TabIndex = 1
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(16, 192)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(70, 15)
        Me.Label5.TabIndex = 23
        Me.Label5.Text = "Gönderi No"
        '
        'cbGonderi
        '
        Me.cbGonderi.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.cbGonderi.FormattingEnabled = True
        Me.cbGonderi.Location = New System.Drawing.Point(109, 186)
        Me.cbGonderi.Name = "cbGonderi"
        Me.cbGonderi.Size = New System.Drawing.Size(240, 23)
        Me.cbGonderi.TabIndex = 4
        '
        'txtAdres
        '
        Me.txtAdres.Location = New System.Drawing.Point(109, 83)
        Me.txtAdres.Multiline = True
        Me.txtAdres.Name = "txtAdres"
        Me.txtAdres.Size = New System.Drawing.Size(240, 70)
        Me.txtAdres.TabIndex = 2
        '
        'ndPaketAdedi
        '
        Me.ndPaketAdedi.Location = New System.Drawing.Point(109, 159)
        Me.ndPaketAdedi.Minimum = New Decimal(New Integer() {1, 0, 0, 0})
        Me.ndPaketAdedi.Name = "ndPaketAdedi"
        Me.ndPaketAdedi.Size = New System.Drawing.Size(96, 21)
        Me.ndPaketAdedi.TabIndex = 3
        Me.ndPaketAdedi.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        Me.ndPaketAdedi.Value = New Decimal(New Integer() {1, 0, 0, 0})
        '
        'Form_GonderilenPaket
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(370, 309)
        Me.Controls.Add(Me.ndPaketAdedi)
        Me.Controls.Add(Me.txtAdres)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.cbGonderi)
        Me.Controls.Add(Me.btnSil)
        Me.Controls.Add(Me.btnEkle)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.cbTur)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.dtTarih)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(162, Byte))
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
        Me.Name = "Form_GonderilenPaket"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Gönderilen Paket"
        CType(Me.ndPaketAdedi, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents btnSil As Button
    Friend WithEvents btnEkle As Button
    Friend WithEvents Label4 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents cbTur As ComboBox
    Friend WithEvents Label1 As Label
    Friend WithEvents dtTarih As DateTimePicker
    Friend WithEvents Label5 As Label
    Friend WithEvents cbGonderi As ComboBox
    Friend WithEvents txtAdres As TextBox
    Friend WithEvents ndPaketAdedi As NumericUpDown
End Class
