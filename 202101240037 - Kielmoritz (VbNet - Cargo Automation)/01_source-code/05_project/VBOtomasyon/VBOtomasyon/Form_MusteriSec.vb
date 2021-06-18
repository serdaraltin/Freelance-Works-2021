Public Class Form_MusteriSec
    Public Id As Integer = 0
    Dim islemler As Class_Islemler = New Class_Islemler
    Public form As Form_Anasayfa

    Private Sub Form_MusteriSec_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        dgVeriler.DataSource = islemler.Kayitlar("Musteri_Tablosu_F").Tables(0)
    End Sub

    Private Sub dgVeriler_RowEnter(sender As Object, e As DataGridViewCellEventArgs) Handles dgVeriler.RowEnter
        Try
            Id = Convert.ToInt32(dgVeriler.Rows(e.RowIndex).Cells(0).Value)
            form.MusteriSec(Id)
        Catch ex As Exception

        End Try
    End Sub
End Class