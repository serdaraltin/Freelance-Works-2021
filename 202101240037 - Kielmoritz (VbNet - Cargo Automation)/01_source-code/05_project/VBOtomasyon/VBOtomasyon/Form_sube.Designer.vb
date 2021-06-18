<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form_sube
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
        Me.SuspendLayout()
        '
        'btnSil
        '
        Me.btnSil.Location = New System.Drawing.Point(196, 68)
        Me.btnSil.Name = "btnSil"
        Me.btnSil.Size = New System.Drawing.Size(118, 52)
        Me.btnSil.TabIndex = 9
        Me.btnSil.Text = "SİL"
        Me.btnSil.UseVisualStyleBackColor = True
        Me.btnSil.Visible = False
        '
        'btnEkle
        '
        Me.btnEkle.Location = New System.Drawing.Point(42, 68)
        Me.btnEkle.Name = "btnEkle"
        Me.btnEkle.Size = New System.Drawing.Size(136, 52)
        Me.btnEkle.TabIndex = 7
        Me.btnEkle.Text = "EKLE"
        Me.btnEkle.UseVisualStyleBackColor = True
        '
        'txtAd
        '
        Me.txtAd.Location = New System.Drawing.Point(86, 14)
        Me.txtAd.Name = "txtAd"
        Me.txtAd.Size = New System.Drawing.Size(228, 21)
        Me.txtAd.TabIndex = 4
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(16, 17)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(21, 15)
        Me.Label1.TabIndex = 5
        Me.Label1.Text = "Ad"
        '
        'Form_sube
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(356, 147)
        Me.Controls.Add(Me.btnSil)
        Me.Controls.Add(Me.btnEkle)
        Me.Controls.Add(Me.txtAd)
        Me.Controls.Add(Me.Label1)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(162, Byte))
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
        Me.Name = "Form_sube"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Şube"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents btnSil As Button
    Friend WithEvents btnEkle As Button
    Friend WithEvents txtAd As TextBox
    Friend WithEvents Label1 As Label
End Class
