<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form_Giris
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
        Me.txtKullaniciAd = New System.Windows.Forms.TextBox()
        Me.txtParola = New System.Windows.Forms.TextBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.btnGiris = New System.Windows.Forms.Button()
        Me.llSifremiUnuttum = New System.Windows.Forms.LinkLabel()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(17, 25)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(64, 13)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Kullanıcı Adı"
        '
        'txtKullaniciAd
        '
        Me.txtKullaniciAd.Location = New System.Drawing.Point(96, 22)
        Me.txtKullaniciAd.Name = "txtKullaniciAd"
        Me.txtKullaniciAd.Size = New System.Drawing.Size(210, 20)
        Me.txtKullaniciAd.TabIndex = 0
        '
        'txtParola
        '
        Me.txtParola.Location = New System.Drawing.Point(96, 48)
        Me.txtParola.Name = "txtParola"
        Me.txtParola.Size = New System.Drawing.Size(210, 20)
        Me.txtParola.TabIndex = 1
        Me.txtParola.UseSystemPasswordChar = True
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(17, 51)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(37, 13)
        Me.Label2.TabIndex = 2
        Me.Label2.Text = "Parola"
        '
        'btnGiris
        '
        Me.btnGiris.Location = New System.Drawing.Point(200, 74)
        Me.btnGiris.Name = "btnGiris"
        Me.btnGiris.Size = New System.Drawing.Size(106, 40)
        Me.btnGiris.TabIndex = 2
        Me.btnGiris.Text = "GİRİŞ"
        Me.btnGiris.UseVisualStyleBackColor = True
        '
        'llSifremiUnuttum
        '
        Me.llSifremiUnuttum.AutoSize = True
        Me.llSifremiUnuttum.Location = New System.Drawing.Point(17, 98)
        Me.llSifremiUnuttum.Name = "llSifremiUnuttum"
        Me.llSifremiUnuttum.Size = New System.Drawing.Size(81, 13)
        Me.llSifremiUnuttum.TabIndex = 3
        Me.llSifremiUnuttum.TabStop = True
        Me.llSifremiUnuttum.Text = "Şifremi Unuttum"
        '
        'Form_Giris
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(331, 135)
        Me.Controls.Add(Me.llSifremiUnuttum)
        Me.Controls.Add(Me.btnGiris)
        Me.Controls.Add(Me.txtParola)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.txtKullaniciAd)
        Me.Controls.Add(Me.Label1)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
        Me.Name = "Form_Giris"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Giriş"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents txtKullaniciAd As TextBox
    Friend WithEvents txtParola As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents btnGiris As Button
    Friend WithEvents llSifremiUnuttum As LinkLabel
End Class
