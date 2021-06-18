Public Class Form_Giris
    Dim islemler As Class_Islemler = New Class_Islemler
    Private Sub llSifremiUnuttum_LinkClicked(sender As Object, e As LinkLabelLinkClickedEventArgs) Handles llSifremiUnuttum.LinkClicked
        If txtKullaniciAd.Text = "" Then
            MsgBox("Kullanıcı adını giriniz !")
            Return
        End If
        If islemler.Kullanici_Kontrol(txtKullaniciAd.Text) = False Then
            MsgBox("Kullanıcı Adı bulunamadı")
            Return
        End If
        Dim sifreYenile As Form_SifreYenile = New Form_SifreYenile
        sifreYenile.kullaniciAd = txtKullaniciAd.Text
        sifreYenile.ShowDialog()
    End Sub

    Private Sub btnGiris_Click(sender As Object, e As EventArgs) Handles btnGiris.Click
        If txtKullaniciAd.Text = "" Or txtParola.Text = "" Then
            MsgBox("Gerekli alanları doldurunuz")
            Return
        End If
        Dim md5 As String = islemler.Md5Uret(txtParola.Text)
        If islemler.Kullanici_Giris(txtKullaniciAd.Text, md5) Then
            MsgBox("Giriş başarılı")
            Dim anasayfa As Form_Anasayfa = New Form_Anasayfa
            anasayfa.Show()
            Me.Hide()
        Else
            MsgBox("Kullanıcı adı veya parola hatalı")
        End If
    End Sub
End Class