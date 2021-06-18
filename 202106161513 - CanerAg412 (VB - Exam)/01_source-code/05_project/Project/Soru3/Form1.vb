Public Class Form1
    Dim sayac As Integer = 0
    Private Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick
        sayac += 1
        txtSure.Text = sayac.ToString
        If sayac = 15 Then
            Timer1.Stop()
            MsgBox("Süre aşımı")
            Me.Close()
        End If
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles btnHesapla.Click
        Timer1.Stop()
        Dim toplam As Double = 0
        Dim adet As Integer = 0
        Dim sonuc As String = ""
        If RadioButton1.Checked Then
            For index = 0 To lstSayilar.Items.Count - 1
                If Convert.ToInt32(lstSayilar.Items(index)) < 0 Then
                    toplam = toplam + Convert.ToInt32(lstSayilar.Items(index))
                    adet = adet + 1
                End If
            Next
            sonuc = (toplam / adet).ToString()
        End If

        If RadioButton2.Checked Then
            For index = 0 To lstSayilar.Items.Count - 1
                If Convert.ToInt32(lstSayilar.Items(index)) > 0 Then
                    toplam = toplam + Convert.ToInt32(lstSayilar.Items(index))
                    adet = adet + 1
                End If
            Next
            sonuc = (toplam / adet).ToString()
        End If

        If RadioButton3.Checked Then
            For index = 0 To lstSayilar.Items.Count - 1
                toplam = toplam + Convert.ToInt32(lstSayilar.Items(index))
                adet = adet + 1
            Next
            Dim ortalama As Double = toplam / adet
            For index = 0 To lstSayilar.Items.Count - 1
                If Convert.ToInt32(lstSayilar.Items(index)) > ortalama Then
                    sonuc = sonuc + " " + lstSayilar.Items(index).ToString
                End If
            Next
        End If

        If RadioButton4.Checked Then
            For index = 0 To lstSayilar.Items.Count - 1
                toplam = toplam + Convert.ToInt32(lstSayilar.Items(index))
                adet = adet + 1
            Next
            Dim ortalama As Double = toplam / adet
            For index = 0 To lstSayilar.Items.Count - 1
                If Convert.ToInt32(lstSayilar.Items(index)) < ortalama Then
                    sonuc = sonuc + " " + lstSayilar.Items(index).ToString
                End If
            Next
        End If

        Dim form2 As New Form2
        form2.Label1.Text = "Sonuç : " + sonuc
        form2.ShowDialog()

    End Sub

    Private Sub btnEkle_Click(sender As Object, e As EventArgs) Handles btnEkle.Click
        If txtSayi.Text = "" Then
            MsgBox("Sayı giriniz !")
            Return
        End If
        lstSayilar.Items.Add(Convert.ToInt32(txtSayi.Text))
        txtSayi.Text = ""

        If lstSayilar.Items.Count = 10 Then
            txtSayi.Enabled = False
            btnEkle.Enabled = False
            btnHesapla.Enabled = True
            Timer1.Enabled = True
        End If
    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        RadioButton1.Checked = True
    End Sub
End Class
