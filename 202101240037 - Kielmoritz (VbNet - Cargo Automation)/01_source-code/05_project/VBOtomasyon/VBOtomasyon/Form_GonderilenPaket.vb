Public Class Form_GonderilenPaket
    Dim tablo As String = "Gonderilen_Paket" + "_Tablosu_F"
    Public Id As Integer = 0
    Dim islemler As Class_Islemler = New Class_Islemler

    Dim gonderiler As List(Of String) = islemler.Donustur(islemler.Kayitlar("Gonderi_Tablosu_F"), 0)
    Dim turler As List(Of String) = islemler.Donustur(islemler.Kayitlar("Paket_Turleri_Tablosu_F"), 0)

    Private Sub Form_GonderilenPaket_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        islemler.CBDoldur(cbTur, "Paket_Turleri_Tablosu_F", 1)
        islemler.CBDoldur(cbGonderi, "Gonderi_Tablosu_F", 0)
        If Id <> 0 Then
            Getir()
        End If
    End Sub
    Public Sub Getir()
        btnEkle.Text = "GÜNCELLE"
        btnSil.Visible = True
        Dim veriler As ArrayList = islemler.Getir(tablo, Id)

        islemler.CBSec(cbTur, turler, veriler(1))
        dtTarih.Value = veriler(2)
        txtAdres.Text = veriler(3)
        ndPaketAdedi.Value = veriler(4)
        cbGonderi.Text = veriler(5)

    End Sub
    Private Sub btnEkle_Click(sender As Object, e As EventArgs) Handles btnEkle.Click
        Dim idTur As Integer = Convert.ToInt32(turler(cbTur.SelectedIndex))

        Dim veriler As ArrayList = New ArrayList

        veriler.Add(New ArrayList() From {"Tur_No", idTur})
        veriler.Add(New ArrayList() From {"Tarih", dtTarih.Value})
        veriler.Add(New ArrayList() From {"Adres", txtAdres.Text})
        veriler.Add(New ArrayList() From {"Paket_Adedi", ndPaketAdedi.Value})
        veriler.Add(New ArrayList() From {"Gonderi_No", Convert.ToInt32(cbGonderi.Text)})

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

    End Sub
End Class