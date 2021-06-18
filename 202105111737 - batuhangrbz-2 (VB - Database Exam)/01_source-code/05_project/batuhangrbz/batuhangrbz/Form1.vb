Imports System.Data.OleDb
Imports System.Data
Imports hesapla

Public Class Form1
    Dim baglanti As OleDbConnection = New OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=ogrenci.mdb")
    Dim id As Integer = 0
    Private Sub Listele()
        baglanti.Open()
        Dim komut As OleDbCommand = New OleDbCommand("Select *From ogrenciler", baglanti)
        Dim da As OleDbDataAdapter = New OleDbDataAdapter(komut)
        Dim ds As DataSet = New DataSet()
        da.Fill(ds)
        komut.Dispose()
        baglanti.Close()
        dtOgrenciler.DataSource = ds.Tables(0)
    End Sub

    Private Function OkulNoKontrol(ByVal okul_no As String) As Boolean
        baglanti.Open()
        Dim komut As OleDbCommand = New OleDbCommand("Select *From ogrenciler Where okul_no='" + okul_no + "'", baglanti)
        Dim reader As OleDbDataReader = komut.ExecuteReader()

        If (reader.Read()) Then
            baglanti.Close()
            Return True
        End If
        baglanti.Close()
        Return False
    End Function

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Listele()

    End Sub

    Private Sub btnYenile_Click(sender As Object, e As EventArgs) Handles btnYenile.Click
        Listele()

    End Sub

    Private Sub btnEkle_Click(sender As Object, e As EventArgs) Handles btnEkle.Click
        If OkulNoKontrol(txtOkulNo.Text) Then
            MsgBox("Aynı okul numarasına sahi öğrenci var !")
            txtOkulNo.Text = ""
            Return
        End If
        baglanti.Open()
        Dim komut As OleDbCommand = New OleDbCommand("Insert Into ogrenciler (okul_no,adi,soyadi,vize1,vize2,final,basari_notu)
        Values(@okul_no,@adi,@soyadi,@vize1,@vize2,final,basari_notu)", baglanti)
        komut.Parameters.AddWithValue("@okul_no", txtOkulNo.Text)
        komut.Parameters.AddWithValue("@adi", txtAdi.Text)
        komut.Parameters.AddWithValue("@soyadi", txtSoyadi.Text)

        Dim vize1 As Integer = Convert.ToInt32(txtVize1.Text)
        Dim vize2 As Integer = Convert.ToInt32(txtVize2.Text)
        Dim final As Integer = Convert.ToInt32(txtFinal.Text)
        Dim hesap = New hesapla.Hesapla

        Dim basariNotu As Integer = hesap.BasariNotu(vize1, vize2, final)

        komut.Parameters.AddWithValue("@vize1", vize1)
        komut.Parameters.AddWithValue("@vize2", vize2)
        komut.Parameters.AddWithValue("@final", final)

        txtBasariNotu.Text = basariNotu.ToString()

        komut.Parameters.AddWithValue("@basari_notu", basariNotu)

        komut.ExecuteNonQuery()
        baglanti.Close()
        Listele()


    End Sub

    Private Sub dtOgrenciler_RowEnter(sender As Object, e As DataGridViewCellEventArgs) Handles dtOgrenciler.RowEnter
        Try
            id = Convert.ToInt32(dtOgrenciler.Rows(e.RowIndex).Cells(0).Value)
            txtId.Text = id.ToString()

            baglanti.Open()
            Dim komut As OleDbCommand = New OleDbCommand("Select *From ogrenciler Where id=" + txtId.Text, baglanti)
            Dim reader As OleDbDataReader = komut.ExecuteReader()

            If (reader.Read()) Then
                txtOkulNo.Text = reader(1).ToString()
                txtAdi.Text = reader(2).ToString()
                txtSoyadi.Text = reader(3).ToString()
                txtVize1.Text = reader(4).ToString()
                txtVize2.Text = reader(5).ToString()
                txtFinal.Text = reader(6).ToString()
                txtBasariNotu.Text = reader(7).ToString()
            End If
            baglanti.Close()
        Catch ex As Exception
            id = 0
        End Try

    End Sub

    Private Sub btnSil_Click(sender As Object, e As EventArgs) Handles btnSil.Click
        If id = 0 Then
            MsgBox("Silmek icin bir kaydin secilmesi gerekli !")
            Return
        End If
        baglanti.Open()
        Dim komut As OleDbCommand = New OleDbCommand("Delete From ogrenciler Where id=" + txtId.Text, baglanti)
        komut.ExecuteNonQuery()
        baglanti.Close()

        Listele()


    End Sub

    Private Sub btnGuncelle_Click(sender As Object, e As EventArgs) Handles btnGuncelle.Click
        If id = 0 Then
            MsgBox("Güncellemek icin bir kaydin secilmesi gerekli !")
            Return
        End If
        baglanti.Open()
        Dim komut As OleDbCommand = New OleDbCommand("Update ogrenciler set
        okul_no=@okul_no,adi=@adi,soyadi=@soyadi,vize1=@vize1,vize2=@vize2,final=@final,basari_notu=@basari_notu", baglanti)
        komut.Parameters.AddWithValue("@okul_no", txtOkulNo.Text)
        komut.Parameters.AddWithValue("@adi", txtAdi.Text)
        komut.Parameters.AddWithValue("@soyadi", txtSoyadi.Text)

        Dim vize1 As Integer = Convert.ToInt32(txtVize1.Text)
        Dim vize2 As Integer = Convert.ToInt32(txtVize2.Text)
        Dim final As Integer = Convert.ToInt32(txtFinal.Text)
        Dim hesap = New hesapla.Hesapla

        Dim basariNotu As Integer = hesap.BasariNotu(vize1, vize2, final)

        komut.Parameters.AddWithValue("@vize1", vize1)
        komut.Parameters.AddWithValue("@vize2", vize2)
        komut.Parameters.AddWithValue("@final", final)

        txtBasariNotu.Text = basariNotu.ToString()

        komut.Parameters.AddWithValue("@basari_notu", basariNotu)
        komut.ExecuteNonQuery()
        baglanti.Close()

        Listele()

    End Sub
End Class
