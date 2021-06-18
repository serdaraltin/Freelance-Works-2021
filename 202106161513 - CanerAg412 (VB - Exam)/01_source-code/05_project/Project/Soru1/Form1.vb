Imports System.IO

Public Class Form1
    Private Sub btnHesapla_Click(sender As Object, e As EventArgs) Handles btnHesapla.Click

        If txtAdet.Text = "" Or txtBirimFiyat.Text = "" Or txtUrunAd.Text = "" Then
            MsgBox("İlgili alanları doldurunuz !")
            Return
        End If
        Dim fiyat As Double = Convert.ToDouble(txtBirimFiyat.Text)
        Dim dosya As New StreamWriter("KDV.txt")
        Dim kdvDurum As String = "dahil degil"
        If chKdv.Checked Then
            kdvDurum = "dahil"
            fiyat += (fiyat / 100) * 15
        End If
        dosya.WriteLine(txtUrunAd.Text + "," + fiyat.ToString + "," + txtAdet.Text + "," + kdvDurum)
        dosya.Close()
        MsgBox("Kaydedildi.")
    End Sub
End Class
