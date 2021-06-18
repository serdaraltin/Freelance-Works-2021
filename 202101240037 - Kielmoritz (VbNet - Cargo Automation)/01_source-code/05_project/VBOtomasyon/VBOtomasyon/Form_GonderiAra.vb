Public Class Form_GonderiAra
    Dim tablo As String = "Gonderi_Tablosu_F"
    Public Id As Integer = 0
    Dim islemler As Class_Islemler = New Class_Islemler
    Private Sub Form_GonderiAra_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        dgVeriler.DataSource = islemler.Kayitlar(tablo).Tables(0)
    End Sub

    Private Sub btnAra_Click(sender As Object, e As EventArgs) Handles btnAra.Click
        If txtAra.Text = "" Then
            dgVeriler.DataSource = islemler.Kayitlar(tablo).Tables(0)
            Return
        End If
        dgVeriler.DataSource = islemler.GonderiAra(txtAra.Text).Tables(0)
    End Sub
End Class