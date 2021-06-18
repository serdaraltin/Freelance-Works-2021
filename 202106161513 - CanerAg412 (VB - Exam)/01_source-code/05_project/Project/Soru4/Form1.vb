Public Class Form1
    Private Sub btnCikar_Click(sender As Object, e As EventArgs) Handles btnCikar.Click
        Try
            Dim baslangic As Integer = Convert.ToInt32(txtBaslangicPozisyon.Text)
            Dim cikarilacak As Integer = Convert.ToInt32(txtCikarilacakSayi.Text)
            txtSonHal.Text = txtGirilen.Text.Substring(baslangic - 1, cikarilacak)
        Catch ex As Exception
            MsgBox("Hata : " + ex.Message.ToString)
        End Try
    End Sub
End Class
