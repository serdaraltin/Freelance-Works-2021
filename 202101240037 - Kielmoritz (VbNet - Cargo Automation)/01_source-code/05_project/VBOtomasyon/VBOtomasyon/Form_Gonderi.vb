Public Class Form_Gonderi
    Dim tablo As String = "Gonderi" + "_Tablosu_F"
    Public Id As Integer = 0
    Dim islemler As Class_Islemler = New Class_Islemler

    Dim personeller As List(Of String) = islemler.Donustur(islemler.Kayitlar("Personel_Tablosu_F"), 0)
    Dim musteriler As List(Of String) = islemler.Donustur(islemler.Kayitlar("Musteri_Tablosu_F"), 0)
    Dim subeler As List(Of String) = islemler.Donustur(islemler.Kayitlar("Sube_Tablosu_F"), 0)
    Private Sub Form_Gonderi_Load(sender As Object, e As EventArgs) Handles MyBase.Load

        islemler.CBDoldur(cbPersonel, "Personel_Tablosu_F", New Integer() {1, 2})
        islemler.CBDoldur(cbMusteri, "Musteri_Tablosu_F", New Integer() {1, 2, 3})
        islemler.CBDoldur(cbSube, "Sube_Tablosu_F", 1)

        If Id <> 0 Then
            Getir()
        End If
    End Sub
    Public Sub Getir()
        btnEkle.Text = "GÜNCELLE"
        btnSil.Visible = True
        Dim veriler As ArrayList = islemler.Getir(tablo, Id)
        dtTarih.Value = veriler(1)

        islemler.CBSec(cbSube, subeler, veriler(2))
        islemler.CBSec(cbPersonel, personeller, veriler(3))
        islemler.CBSec(cbMusteri, musteriler, veriler(4))

    End Sub
    Private Sub btnEkle_Click(sender As Object, e As EventArgs) Handles btnEkle.Click

        Dim idPersonel As Integer = Convert.ToInt32(personeller(cbPersonel.SelectedIndex))
        Dim idMusteri As Integer = Convert.ToInt32(musteriler(cbMusteri.SelectedIndex))
        Dim idSube As Integer = Convert.ToInt32(subeler(cbSube.SelectedIndex))

        Dim veriler As ArrayList = New ArrayList

        veriler.Add(New ArrayList() From {"Gonderi_Tarihi", dtTarih.Value})
        veriler.Add(New ArrayList() From {"Sube_No", idSube})
        veriler.Add(New ArrayList() From {"Personel_No", idPersonel})
        veriler.Add(New ArrayList() From {"Musteri_No", idMusteri})

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