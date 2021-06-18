Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim metin As String = TextBox1.Text
        Dim metinKarakter As Char() = metin.ToCharArray
        Dim sayiAdet As Integer = 0
        For Each karakter In metinKarakter
            If Char.IsNumber(karakter) Then
                sayiAdet += 1
            End If
        Next
        Label1.Text = "Sayi Adet : " + sayiAdet.ToString
        MsgBox(sayiAdet.ToString + " adet sayi vardir")
    End Sub
End Class
