Public Class Form_Musteri
    Dim tablo As String = "Musteri_Tablosu_F"
    Public Id As Integer = 0

    Dim islemler As Class_Islemler = New Class_Islemler
    Private Sub Form_Musteri_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        If Id <> 0 Then
            Getir()
        End If
    End Sub

    Public Sub Getir()
        btnEkle.Text = "GÜNCELLE"
        btnSil.Visible = True
        Dim veriler As ArrayList = islemler.Getir(tablo, Id)
        txtTc.Text = veriler(1).ToString
        txtAd.Text = veriler(2).ToString
        txtSoyad.Text = veriler(3).ToString
        txtAdres.Text = veriler(4).ToString
    End Sub

    Private Sub btnEkle_Click(sender As Object, e As EventArgs) Handles btnEkle.Click
        Dim veriler As ArrayList = New ArrayList

        veriler.Add(New ArrayList() From {"TC_KimlikNo", txtTc.Text})
        veriler.Add(New ArrayList() From {"Adi", txtAd.Text})
        veriler.Add(New ArrayList() From {"Soyadi", txtSoyad.Text})
        veriler.Add(New ArrayList() From {"Adres", txtAdres.Text})

        If Id <> 0 Then
            veriler.Add(New ArrayList() From {"Id", Id})
            If islemler.Guncelle(tablo, veriler) Then
                islemler.MesajKutu(tablo + " güncelleme")
            Else
                islemler.MesajKutu(2, tablo + " güncelleme")
            End If
            Return
        End If

        If islemler.Ekle(tablo, veriler) Then
            islemler.MesajKutu(tablo + " ekleme")
        Else
            islemler.MesajKutu(2, tablo + " ekleme")
        End If

    End Sub

    Private Sub btnSil_Click(sender As Object, e As EventArgs) Handles btnSil.Click
        islemler.Sil(Me, tablo, Id)
    End Sub
End Class