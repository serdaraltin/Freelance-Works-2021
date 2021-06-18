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
        Me.txtGirilen = New System.Windows.Forms.TextBox()
        Me.txtBaslangicPozisyon = New System.Windows.Forms.TextBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.txtCikarilacakSayi = New System.Windows.Forms.TextBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.txtSonHal = New System.Windows.Forms.TextBox()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.btnCikar = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(84, 25)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(43, 15)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Girilen"
        '
        'txtGirilen
        '
        Me.txtGirilen.Location = New System.Drawing.Point(133, 21)
        Me.txtGirilen.Name = "txtGirilen"
        Me.txtGirilen.Size = New System.Drawing.Size(312, 21)
        Me.txtGirilen.TabIndex = 1
        '
        'txtBaslangicPozisyon
        '
        Me.txtBaslangicPozisyon.Location = New System.Drawing.Point(133, 48)
        Me.txtBaslangicPozisyon.Name = "txtBaslangicPozisyon"
        Me.txtBaslangicPozisyon.Size = New System.Drawing.Size(59, 21)
        Me.txtBaslangicPozisyon.TabIndex = 3
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label2.Location = New System.Drawing.Point(7, 51)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(120, 15)
        Me.Label2.TabIndex = 2
        Me.Label2.Text = "Başlangıç Pozisyonu"
        '
        'txtCikarilacakSayi
        '
        Me.txtCikarilacakSayi.Location = New System.Drawing.Point(133, 75)
        Me.txtCikarilacakSayi.Name = "txtCikarilacakSayi"
        Me.txtCikarilacakSayi.Size = New System.Drawing.Size(59, 21)
        Me.txtCikarilacakSayi.TabIndex = 5
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label3.Location = New System.Drawing.Point(34, 79)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(93, 15)
        Me.Label3.TabIndex = 4
        Me.Label3.Text = "Çıkarılacak Sayı"
        '
        'txtSonHal
        '
        Me.txtSonHal.Location = New System.Drawing.Point(133, 102)
        Me.txtSonHal.Name = "txtSonHal"
        Me.txtSonHal.ReadOnly = True
        Me.txtSonHal.Size = New System.Drawing.Size(312, 21)
        Me.txtSonHal.TabIndex = 7
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label4.Location = New System.Drawing.Point(73, 105)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(54, 15)
        Me.Label4.TabIndex = 6
        Me.Label4.Text = "Son Hali"
        '
        'btnCikar
        '
        Me.btnCikar.Location = New System.Drawing.Point(340, 129)
        Me.btnCikar.Name = "btnCikar"
        Me.btnCikar.Size = New System.Drawing.Size(105, 33)
        Me.btnCikar.TabIndex = 8
        Me.btnCikar.Text = "ÇIKAR"
        Me.btnCikar.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(463, 174)
        Me.Controls.Add(Me.btnCikar)
        Me.Controls.Add(Me.txtSonHal)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.txtCikarilacakSayi)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.txtBaslangicPozisyon)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.txtGirilen)
        Me.Controls.Add(Me.Label1)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Çıkar"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents txtGirilen As TextBox
    Friend WithEvents txtBaslangicPozisyon As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents txtCikarilacakSayi As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents txtSonHal As TextBox
    Friend WithEvents Label4 As Label
    Friend WithEvents btnCikar As Button
End Class
