Imports System.IO

Public Class Form1
    Dim ogrenciNo As String = ""
    Dim secilenIndex As Integer = -1
    Private Sub Listele()
        lstVeri.Items.Clear()
        Dim dosyaAdi As String = "ogrenci.txt"

        For Each satir As String In File.ReadLines(dosyaAdi)

            Dim veri = satir.Split(",")
            Dim veriler As New ListViewItem
            veriler.Text = veri(0)
            veriler.SubItems.Add(veri(1))
            veriler.SubItems.Add(veri(2))

            lstVeri.Items.Add(veriler)
        Next satir


    End Sub

    Private Sub Yazdir()

        File.CreateText("ogrenci.txt").Close()

        Dim dosya As New StreamWriter("ogrenci.txt")


        For index = 0 To lstVeri.Items.Count - 1
            Dim satir As String = lstVeri.Items(index).SubItems(0).Text + "," + lstVeri.Items(index).SubItems(1).Text + "," + lstVeri.Items(index).SubItems(2).Text
            dosya.WriteLine(satir)

        Next
        dosya.Close()

        ogrenciNo = ""
        txtOgrenciNo.Text = ""
        txtAd.Text = ""
        txtSoyad.Text = ""
        secilenIndex = -1

        Listele()
    End Sub
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Listele()

    End Sub

    Private Sub lstVeri_DoubleClick(sender As Object, e As EventArgs) Handles lstVeri.DoubleClick
        txtOgrenciNo.Text = lstVeri.Items(lstVeri.SelectedIndices(0)).SubItems(0).Text
        txtAd.Text = lstVeri.Items(lstVeri.SelectedIndices(0)).SubItems(1).Text
        txtSoyad.Text = lstVeri.Items(lstVeri.SelectedIndices(0)).SubItems(2).Text
        ogrenciNo = txtOgrenciNo.Text
        secilenIndex = lstVeri.SelectedIndices(0)
    End Sub

    Private Sub btnKaydet_Click(sender As Object, e As EventArgs) Handles btnKaydet.Click

        Dim veriler As New ListViewItem
        veriler.Text = txtOgrenciNo.Text
        veriler.SubItems.Add(txtAd.Text)
        veriler.SubItems.Add(txtSoyad.Text)

        lstVeri.Items.Add(veriler)
        Yazdir()

    End Sub

    Private Sub btnGuncelle_Click(sender As Object, e As EventArgs) Handles btnGuncelle.Click
        If secilenIndex = -1 Then
            MsgBox("Kayıt seçiniz")
            Return
        End If
        lstVeri.Items(lstVeri.SelectedIndices(0)).SubItems(0).Text = txtOgrenciNo.Text
        lstVeri.Items(lstVeri.SelectedIndices(0)).SubItems(1).Text = txtAd.Text
        lstVeri.Items(lstVeri.SelectedIndices(0)).SubItems(2).Text = txtSoyad.Text

        Yazdir()


    End Sub

    Private Sub btnSil_Click(sender As Object, e As EventArgs) Handles btnSil.Click
        If secilenIndex = -1 Then
            MsgBox("Kayıt seçiniz")
            Return
        End If
        lstVeri.Items.RemoveAt(secilenIndex)
        Yazdir()

    End Sub
End Class
