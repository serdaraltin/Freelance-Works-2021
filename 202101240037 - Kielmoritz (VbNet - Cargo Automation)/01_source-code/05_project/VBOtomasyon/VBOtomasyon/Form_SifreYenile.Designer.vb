<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form_SifreYenile
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
        Me.txtSoru = New System.Windows.Forms.TextBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.txtCevap = New System.Windows.Forms.TextBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.btnDogrula = New System.Windows.Forms.Button()
        Me.txtYeniSifre = New System.Windows.Forms.TextBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.btnYenile = New System.Windows.Forms.Button()
        Me.gbSifreYenile = New System.Windows.Forms.GroupBox()
        Me.gbSifreYenile.SuspendLayout()
        Me.SuspendLayout()
        '
        'txtSoru
        '
        Me.txtSoru.Enabled = False
        Me.txtSoru.Location = New System.Drawing.Point(71, 25)
        Me.txtSoru.Multiline = True
        Me.txtSoru.Name = "txtSoru"
        Me.txtSoru.ReadOnly = True
        Me.txtSoru.Size = New System.Drawing.Size(210, 53)
        Me.txtSoru.TabIndex = 4
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(13, 28)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(29, 13)
        Me.Label1.TabIndex = 2
        Me.Label1.Text = "Soru"
        '
        'txtCevap
        '
        Me.txtCevap.Location = New System.Drawing.Point(71, 84)
        Me.txtCevap.Name = "txtCevap"
        Me.txtCevap.Size = New System.Drawing.Size(210, 20)
        Me.txtCevap.TabIndex = 0
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(13, 89)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(38, 13)
        Me.Label2.TabIndex = 4
        Me.Label2.Text = "Cevap"
        '
        'btnDogrula
        '
        Me.btnDogrula.Location = New System.Drawing.Point(175, 110)
        Me.btnDogrula.Name = "btnDogrula"
        Me.btnDogrula.Size = New System.Drawing.Size(106, 44)
        Me.btnDogrula.TabIndex = 1
        Me.btnDogrula.Text = "DOĞRULA"
        Me.btnDogrula.UseVisualStyleBackColor = True
        '
        'txtYeniSifre
        '
        Me.txtYeniSifre.Location = New System.Drawing.Point(64, 30)
        Me.txtYeniSifre.Name = "txtYeniSifre"
        Me.txtYeniSifre.Size = New System.Drawing.Size(204, 20)
        Me.txtYeniSifre.TabIndex = 2
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(6, 34)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(52, 13)
        Me.Label3.TabIndex = 7
        Me.Label3.Text = "Yeni Şifre"
        '
        'btnYenile
        '
        Me.btnYenile.Location = New System.Drawing.Point(162, 58)
        Me.btnYenile.Name = "btnYenile"
        Me.btnYenile.Size = New System.Drawing.Size(106, 31)
        Me.btnYenile.TabIndex = 3
        Me.btnYenile.Text = "YENİLE"
        Me.btnYenile.UseVisualStyleBackColor = True
        '
        'gbSifreYenile
        '
        Me.gbSifreYenile.Controls.Add(Me.btnYenile)
        Me.gbSifreYenile.Controls.Add(Me.txtYeniSifre)
        Me.gbSifreYenile.Controls.Add(Me.Label3)
        Me.gbSifreYenile.Location = New System.Drawing.Point(7, 157)
        Me.gbSifreYenile.Name = "gbSifreYenile"
        Me.gbSifreYenile.Size = New System.Drawing.Size(274, 99)
        Me.gbSifreYenile.TabIndex = 10
        Me.gbSifreYenile.TabStop = False
        Me.gbSifreYenile.Text = "Yeni Şifre Belirleme"
        Me.gbSifreYenile.Visible = False
        '
        'Form_SifreYenile
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(300, 268)
        Me.Controls.Add(Me.gbSifreYenile)
        Me.Controls.Add(Me.btnDogrula)
        Me.Controls.Add(Me.txtCevap)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.txtSoru)
        Me.Controls.Add(Me.Label1)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
        Me.Name = "Form_SifreYenile"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Şifre Yenile"
        Me.gbSifreYenile.ResumeLayout(False)
        Me.gbSifreYenile.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents txtSoru As TextBox
    Friend WithEvents Label1 As Label
    Friend WithEvents txtCevap As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents btnDogrula As Button
    Friend WithEvents txtYeniSifre As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents btnYenile As Button
    Friend WithEvents gbSifreYenile As GroupBox
End Class
