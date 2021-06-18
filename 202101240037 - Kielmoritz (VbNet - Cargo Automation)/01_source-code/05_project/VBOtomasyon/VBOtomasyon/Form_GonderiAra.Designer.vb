<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form_GonderiAra
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
        Me.dgVeriler = New System.Windows.Forms.DataGridView()
        Me.btnAra = New System.Windows.Forms.Button()
        Me.txtAra = New System.Windows.Forms.TextBox()
        CType(Me.dgVeriler, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'dgVeriler
        '
        Me.dgVeriler.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill
        Me.dgVeriler.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.dgVeriler.Location = New System.Drawing.Point(12, 38)
        Me.dgVeriler.Name = "dgVeriler"
        Me.dgVeriler.ReadOnly = True
        Me.dgVeriler.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect
        Me.dgVeriler.Size = New System.Drawing.Size(556, 233)
        Me.dgVeriler.TabIndex = 2
        '
        'btnAra
        '
        Me.btnAra.Location = New System.Drawing.Point(491, 7)
        Me.btnAra.Name = "btnAra"
        Me.btnAra.Size = New System.Drawing.Size(75, 23)
        Me.btnAra.TabIndex = 3
        Me.btnAra.Text = "Ara"
        Me.btnAra.UseVisualStyleBackColor = True
        '
        'txtAra
        '
        Me.txtAra.Location = New System.Drawing.Point(317, 9)
        Me.txtAra.Name = "txtAra"
        Me.txtAra.Size = New System.Drawing.Size(168, 20)
        Me.txtAra.TabIndex = 4
        '
        'Form_GonderiAra
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(580, 283)
        Me.Controls.Add(Me.txtAra)
        Me.Controls.Add(Me.btnAra)
        Me.Controls.Add(Me.dgVeriler)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
        Me.Name = "Form_GonderiAra"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Gönderi Ara"
        CType(Me.dgVeriler, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents dgVeriler As DataGridView
    Friend WithEvents btnAra As Button
    Friend WithEvents txtAra As TextBox
End Class
