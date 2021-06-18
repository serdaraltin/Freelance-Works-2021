Public Class Form_Anasayfa
    Dim tablo As String = "Gonderilen_Paket_Tablosu_F"
    Public Id As Integer = 0
    Dim islemler As Class_Islemler = New Class_Islemler

    Dim secilenSubeNo As Integer = 0
    Dim secilenPersonelNo As Integer = 0
    Dim secilenMusteriNo As Integer = 0
    Dim secilenGonderiNo As Integer = 0

    Dim personeller As List(Of String) = islemler.Donustur(islemler.Kayitlar("Personel_Tablosu_F"), 0)
    Dim musteriler As List(Of String) = islemler.Donustur(islemler.Kayitlar("Musteri_Tablosu_F"), 0)
    Dim subeler As List(Of String) = islemler.Donustur(islemler.Kayitlar("Sube_Tablosu_F"), 0)
    Public Sub Listele()
        dgVeriler.DataSource = islemler.Kayitlar(tablo).Tables(0)
        Dim paketToplam As Integer = 0
        For Each satir In islemler.Kayitlar(tablo).Tables(0).Rows
            paketToplam += satir(4)
        Next
        txtAdet.Text = paketToplam
    End Sub
    Private Sub Form_Anasayfa_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        islemler.CBDoldur(cbPersonel, "Personel_Tablosu_F", New Integer() {1, 2})
        islemler.CBDoldur(cbSube, "Sube_Tablosu_F", 1)
        Listele()

    End Sub

    Private Sub btnYeniKayit_Click(sender As Object, e As EventArgs) Handles btnYeniKayit.Click
        Dim gonderilenPaket As Form_GonderilenPaket = New Form_GonderilenPaket
        gonderilenPaket.ShowDialog()
    End Sub

    Private Sub YenidenBaşlatToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles YenidenBaşlatToolStripMenuItem.Click
        Application.Restart()
    End Sub

    Private Sub KapatToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles KapatToolStripMenuItem.Click
        Application.Exit()
    End Sub

    Private Sub PersonelEkleToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles PersonelEkleToolStripMenuItem.Click
        Dim personelEkle As Form_Personel = New Form_Personel
        personelEkle.ShowDialog()

    End Sub

    Private Sub EkleToolStripMenuItem2_Click(sender As Object, e As EventArgs) Handles EkleToolStripMenuItem2.Click
        Dim sube As Form_sube = New Form_sube
        sube.ShowDialog()
    End Sub

    Private Sub EkleToolStripMenuItem1_Click(sender As Object, e As EventArgs) Handles EkleToolStripMenuItem1.Click
        Dim tur As Form_Tur = New Form_Tur
        tur.ShowDialog()
    End Sub

    Private Sub EkleToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles EkleToolStripMenuItem.Click
        Dim musteri As Form_Musteri = New Form_Musteri
        musteri.ShowDialog()
    End Sub

    Private Sub GönderiEkleToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles GönderiEkleToolStripMenuItem.Click
        Dim gonderi As Form_Gonderi = New Form_Gonderi
        gonderi.ShowDialog()
    End Sub

    Private Sub ContextMenuStrip1_Opening(sender As Object, e As System.ComponentModel.CancelEventArgs) Handles ContextMenuStrip1.Opening

    End Sub

    Private Sub ToolStripMenuItem1_Click(sender As Object, e As EventArgs) Handles ToolStripMenuItem1.Click
        Dim gonderilenPaket As Form_GonderilenPaket = New Form_GonderilenPaket
        gonderilenPaket.ShowDialog()
    End Sub

    Private Sub dgVeriler_RowEnter(sender As Object, e As DataGridViewCellEventArgs) Handles dgVeriler.RowEnter
        Try
            Id = Convert.ToInt32(dgVeriler.Rows(e.RowIndex).Cells(0).Value)
            Getir()
        Catch ex As Exception

        End Try
    End Sub

    Public Sub Getir()
        Dim paketler As ArrayList = islemler.Getir(tablo, Id)
        secilenGonderiNo = paketler(5)

        Dim veriler As ArrayList = islemler.Getir("Gonderi_Tablosu_F", secilenGonderiNo)
        dtTarih.Value = veriler(1)
        secilenSubeNo = veriler(2)
        secilenPersonelNo = veriler(3)
        secilenMusteriNo = veriler(4)

        islemler.CBSec(cbSube, subeler, secilenSubeNo)
        islemler.CBSec(cbPersonel, personeller, secilenPersonelNo)

        Dim musteri As ArrayList = islemler.Getir("Musteri_Tablosu_F", secilenMusteriNo)
        txtTc.Text = musteri(1)
        txtAd.Text = musteri(2)
        txtSoyad.Text = musteri(3)
        txtAdres.Text = musteri(4)


    End Sub


    Private Sub ToolStripMenuItem2_Click(sender As Object, e As EventArgs) Handles ToolStripMenuItem2.Click
        Dim gonderilenPaket As Form_GonderilenPaket = New Form_GonderilenPaket
        gonderilenPaket.Id = Id
        gonderilenPaket.ShowDialog()
    End Sub

    Private Sub ToolStripMenuItem3_Click(sender As Object, e As EventArgs) Handles ToolStripMenuItem3.Click
        islemler.Sil(Me, tablo, Id)
    End Sub

    Private Sub YenileToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles YenileToolStripMenuItem.Click
        Listele()
    End Sub

    Private Sub btnMusteriSec_Click(sender As Object, e As EventArgs) Handles btnMusteriSec.Click
        Dim musteriSec As Form_MusteriSec = New Form_MusteriSec
        musteriSec.form = Me
        musteriSec.ShowDialog()
    End Sub

    Public Sub MusteriSec(ByVal MusteriNo As Integer)
        secilenMusteriNo = MusteriNo
        Dim musteri As ArrayList = islemler.Getir("Musteri_Tablosu_F", MusteriNo)
        txtTc.Text = musteri(1)
        txtAd.Text = musteri(2)
        txtSoyad.Text = musteri(3)
        txtAdres.Text = musteri(4)
    End Sub

    Private Sub btnKaydet_Click(sender As Object, e As EventArgs) Handles btnKaydet.Click

        Dim idPersonel As Integer = Convert.ToInt32(personeller(cbPersonel.SelectedIndex))
        Dim idSube As Integer = Convert.ToInt32(subeler(cbSube.SelectedIndex))

        Dim veriler As ArrayList = New ArrayList
        veriler.Add(New ArrayList From {"Id", secilenGonderiNo})
        veriler.Add(New ArrayList From {"Gonderi_Tarihi", dtTarih.Value})
        veriler.Add(New ArrayList From {"Sube_No", idSube})
        veriler.Add(New ArrayList From {"Personel_No", idPersonel})
        veriler.Add(New ArrayList From {"Musteri_No", secilenMusteriNo})

        If islemler.Guncelle("Gonderi_Tablosu_F", veriler) Then
            MsgBox("Kayıt Güncellendi")
        Else
            MsgBox("Kayıt güncellenemedi")
        End If
    End Sub

    Private Sub btnSil_Click(sender As Object, e As EventArgs) Handles btnSil.Click
        islemler.Sil(Me, tablo, Id)
    End Sub

    Private Sub btnAra_Click(sender As Object, e As EventArgs) Handles btnAra.Click
        Dim gonderiAra As Form_GonderiAra = New Form_GonderiAra
        gonderiAra.ShowDialog()
    End Sub

    Private Sub Form_Anasayfa_FormClosing(sender As Object, e As FormClosingEventArgs) Handles MyBase.FormClosing
        Application.Exit()
    End Sub

    Private Sub HakkındaToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles HakkındaToolStripMenuItem.Click
        Dim hakkinda As AboutBox1 = New AboutBox1
        hakkinda.ShowDialog()
    End Sub
End Class
