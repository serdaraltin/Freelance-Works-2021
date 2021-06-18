Public Class Form_SifreYenile
    Public kullaniciAd As String = "admin"
    Dim cevap As String = ""
    Dim deneme As Integer = 0
    Dim islemler As Class_Islemler = New Class_Islemler
    Private Sub Form_SifreYenile_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        txtSoru.Text = islemler.Kullanici_Getir(kullaniciAd)(0)
        cevap = islemler.Kullanici_Getir(kullaniciAd)(1)
    End Sub

    Private Sub btnDogrula_Click(sender As Object, e As EventArgs) Handles btnDogrula.Click
        If txtCevap.Text <> cevap Then
            If deneme = 2 Then
                Application.Exit()
            End If
            MsgBox("Cevap hatalı. Tekrar deneyiniz")
            deneme += 1
            Return
        End If
        gbSifreYenile.Visible = True
        txtCevap.Enabled = False
        btnDogrula.Enabled = False
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles btnYenile.Click
        Dim md5 As String = islemler.Md5Uret(txtYeniSifre.Text)
        If islemler.Kullanici_SifreYenile(kullaniciAd, md5) Then
            MsgBox("Sifre Yenilendi.")
            Application.Restart()
        Else
            MsgBox("Sifre yenileme hatası")
        End If
    End Sub
End Class