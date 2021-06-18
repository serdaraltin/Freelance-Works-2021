Imports System.Collections.Generic
Imports System.Data.SqlClient
Imports System.Data
Imports System.Collections
Imports System
Imports System.Windows.Forms
Imports System.Security.Cryptography
Imports System.Text


Class Class_Islemler
    Private baglanti As SqlConnection = New SqlConnection("Data Source =localhost, 1433; Network Library = DBMSSOCN; Initial Catalog =G2FinalKargo; User ID=remote; Password=celeron;")

    Public Function BaglantiTest() As Boolean
        Try
            baglanti.Open()
            baglanti.Close()
            Return True
        Catch
            baglanti.Close()
            Return False
        End Try
    End Function


    Public Function Md5Uret(theInput As String) As String
        Using hasher As MD5 = MD5.Create()
            Dim dbytes As Byte() =
             hasher.ComputeHash(Encoding.UTF8.GetBytes(theInput))
            Dim sBuilder As New StringBuilder()
            For n As Integer = 0 To dbytes.Length - 1
                sBuilder.Append(dbytes(n).ToString("X2"))
            Next n
            Return sBuilder.ToString()
        End Using

    End Function

    Public Function Kullanici_Giris(ByVal KullaniciAd As String, ByVal Sifre As String) As Boolean
        Try
            baglanti.Open()
            Dim komut As SqlCommand = New SqlCommand("Select User_Name From Login_Tablosu_F Where User_Name='" + KullaniciAd + "' and Password='" + Sifre + "'", baglanti)
            Dim oku As SqlDataReader = komut.ExecuteReader()

            If oku.Read() Then
                baglanti.Close()
                Return True
            End If

            baglanti.Close()
            Return False
        Catch
            baglanti.Close()
            Return False
        End Try
    End Function

    Public Function Kullanici_Kontrol(ByVal KullaniciAd As String) As Boolean
        Try
            baglanti.Open()
            Dim komut As SqlCommand = New SqlCommand("Select User_Name From Login_Tablosu_F Where User_Name='" + KullaniciAd + "'", baglanti)
            Dim oku As SqlDataReader = komut.ExecuteReader()

            If oku.Read() Then
                baglanti.Close()
                Return True
            End If

            baglanti.Close()
            Return False
        Catch
            baglanti.Close()
            Return False
        End Try
    End Function
    Public Function Kullanici_SifreYenile(ByVal KullaniciAd As String, ByVal Sifre As String) As Boolean
        Try
            baglanti.Open()
            Dim komut As SqlCommand = New SqlCommand("Update Login_Tablosu_F Set Password='" + Sifre + "' Where User_Name='" + KullaniciAd + "'", baglanti)
            komut.ExecuteNonQuery()

            baglanti.Close()
            Return True
        Catch
            baglanti.Close()
            Return False
        End Try
    End Function
    Public Function Kullanici_Getir(ByVal KullaniciAd As String) As String()
        Try
            baglanti.Open()
            Dim komut As SqlCommand = New SqlCommand("Select Question,Answer From Login_Tablosu_F Where User_Name='" + KullaniciAd + "'", baglanti)
            Dim oku As SqlDataReader = komut.ExecuteReader()

            If oku.Read() Then
                Dim veriler As String() = New String() {oku("Question"), oku("Answer")}

                baglanti.Close()
                Return veriler
            End If

            baglanti.Close()
            Return Nothing
        Catch
            baglanti.Close()
            Return Nothing
        End Try
    End Function

    Public Function Kontrol(ByVal tablo As String, ByVal Id As Integer) As Boolean
        Try
            baglanti.Open()
            Dim komut As SqlCommand = New SqlCommand(tablo + "_Getir", baglanti)
            komut.CommandType = CommandType.StoredProcedure
            komut.Parameters.AddWithValue("@Tablo", tablo)
            komut.Parameters.AddWithValue("@Id", Id)
            Dim oku As SqlDataReader = komut.ExecuteReader()

            If oku.Read() Then
                baglanti.Close()
                Return True
            End If

            baglanti.Close()
            Return False
        Catch
            baglanti.Close()
            Return False
        End Try
    End Function

    Public Function Ekle(ByVal tablo As String, ByVal veriler As ArrayList) As Boolean
        Try
            baglanti.Open()
            Dim komut As SqlCommand = New SqlCommand(tablo & "_Ekle", baglanti)
            komut.CommandType = CommandType.StoredProcedure

            For Each Kolon As ArrayList In veriler
                komut.Parameters.AddWithValue("@" & Kolon(0), Kolon(1))
            Next

            komut.ExecuteNonQuery()
            komut.Dispose()
            baglanti.Close()
            Return True
        Catch
            baglanti.Close()
            Return False
        End Try
    End Function

    Public Function Guncelle(ByVal tablo As String, ByVal veriler As ArrayList) As Boolean
        Try
            baglanti.Open()
            Dim komut As SqlCommand = New SqlCommand(tablo & "_Guncelle", baglanti)
            komut.CommandType = CommandType.StoredProcedure

            For Each Kolon As ArrayList In veriler
                komut.Parameters.AddWithValue("@" & Kolon(0), Kolon(1))
            Next

            komut.ExecuteNonQuery()
            komut.Dispose()
            baglanti.Close()
            Return True
        Catch
            baglanti.Close()
            Return False
        End Try
    End Function

    Public Function Sil(ByVal tablo As String, ByVal Id As Integer) As Boolean


        Try
            baglanti.Open()
            Dim komut As SqlCommand = New SqlCommand(tablo + "_Sil", baglanti)
            komut.CommandType = CommandType.StoredProcedure
            komut.Parameters.AddWithValue("@Tablo", tablo)
            komut.Parameters.AddWithValue("@Id", Id)
            komut.ExecuteNonQuery()
            komut.Dispose()
            baglanti.Close()
            Return True
        Catch
            baglanti.Close()
            Return False
        End Try
    End Function

    Public Function Getir(ByVal tablo As String, ByVal Id As Integer) As ArrayList
        Try
            baglanti.Open()
            Dim komut As SqlCommand = New SqlCommand(tablo + "_Getir", baglanti)
            komut.CommandType = CommandType.StoredProcedure
            komut.Parameters.AddWithValue("@Tablo", tablo)
            komut.Parameters.AddWithValue("@Id", Id)
            Dim oku As SqlDataReader = komut.ExecuteReader()
            Dim veriler As ArrayList = New ArrayList()

            If oku.Read() Then
                Dim i As Integer = 0
                While True
                    Try
                        veriler.Add(oku(i))
                    Catch
                        Exit While
                        Exit Try
                    End Try
                    i += 1
                End While
            End If

            komut.Dispose()
            baglanti.Close()
            Return veriler
        Catch
            baglanti.Close()
            Return Nothing
        End Try
    End Function

    Public Function Getir(ByVal tablo As String, ByVal sorulan As String) As String()
        Try
            Dim veriler As DataSet = Kayitlar(tablo)
            Dim liste As ArrayList = Donustur(veriler)

            For Each items As String() In liste

                For Each veri As String In items
                    If veri = sorulan Then Return items
                Next
            Next

            Return Nothing
        Catch
            Return Nothing
        End Try
    End Function

    Public Function Kayitlar(ByVal tablo As String) As DataSet
        Try
            baglanti.Open()
            Dim komut As SqlCommand = New SqlCommand("Kayitlar", baglanti)
            komut.CommandType = CommandType.StoredProcedure
            komut.Parameters.AddWithValue("@Tablo", tablo)
            Dim da As SqlDataAdapter = New SqlDataAdapter(komut)
            Dim ds As DataSet = New DataSet()
            da.Fill(ds)
            komut.Dispose()
            baglanti.Close()
            Return ds
        Catch

            baglanti.Close()
            Return Nothing
        End Try
    End Function

    Public Function GonderiAra(ByVal aranan As String) As DataSet
        Try
            baglanti.Open()
            Dim sorgu As String = "Select * From Gonderi_Tablosu_F Where Gonderi_Tarihi LIKE '%" + aranan + "%' or Sube_No=" + aranan + " or Personel_No=" + aranan + " or Musteri_No=" + aranan + ""
            Dim komut As SqlCommand = New SqlCommand(sorgu, baglanti)
            Dim da As SqlDataAdapter = New SqlDataAdapter(komut)
            Dim ds As DataSet = New DataSet()
            da.Fill(ds)
            komut.Dispose()
            baglanti.Close()
            Return ds
        Catch

            baglanti.Close()
            Return Nothing
        End Try
    End Function

    Public Function Donustur(ByVal veri As DataSet) As ArrayList
        Try
            Dim veriler As ArrayList = New ArrayList()

            For Each satir As DataRow In veri.Tables(0).Rows
                Dim parcalanmis As String() = String.Join(",", satir.ItemArray).Split(",")
                veriler.Add(parcalanmis)
            Next
            Return veriler
        Catch
            Return Nothing
        End Try
    End Function

    Public Sub CBDoldur(ByVal box As ComboBox, ByVal tablo As String, ByVal kolon As Integer)
        Dim veriler As DataSet = Kayitlar(tablo)

        For Each satir As DataRow In veriler.Tables(0).Rows
            Dim veri As Object() = satir.ItemArray
            box.Items.Add(veri(kolon))
        Next
        box.SelectedIndex = 0
    End Sub

    Public Sub CBDoldur(ByVal box As ComboBox, ByVal tablo As String, ByVal kolonlar As Integer())
        Try
            Dim veriler As DataSet = Kayitlar(tablo)
            For Each satir As DataRow In veriler.Tables(0).Rows
                Dim veri As Object() = satir.ItemArray
                Dim eklenecek As String = ""
                For Each no In kolonlar
                    eklenecek += veri(no) + " "
                Next
                box.Items.Add(eklenecek)
            Next
            box.SelectedIndex = 0
        Catch ex As Exception
            MesajKutu(2, "listeleme")
        End Try
    End Sub

    Public Function Donustur(ByVal veri As DataSet, ByVal kolon As Integer) As List(Of String)
        Try
            Dim veriler As List(Of String) = New List(Of String)()

            For Each satir As DataRow In veri.Tables(0).Rows
                Dim satirVeriler As Object() = satir.ItemArray
                veriler.Add(satirVeriler(kolon))
            Next

            Return veriler
        Catch
            Return Nothing
        End Try
    End Function

    Public Sub Ekle(ByVal form As Form, ByVal tablo As String, ByVal veriler As ArrayList)
        If Ekle(tablo, veriler) Then
            MesajKutu(tablo & " ekleme")
        Else
            MesajKutu(2, tablo & " ekleme")
        End If

    End Sub

    Public Sub Guncelle(ByVal form As Form, ByVal tablo As String, ByVal veriler As ArrayList, ByVal Id As Integer)
        veriler.Add(New ArrayList() From {
            "Id",
            Id
        })

        If Guncelle(tablo, veriler) Then
            MesajKutu(tablo & " güncelleme")
        Else
            MesajKutu(2, tablo & " güncelleme")
        End If

        Return
    End Sub

    Public Sub Sil(ByVal form As Form, ByVal tablo As String, ByVal Id As Integer)
        If SoruKutu(tablo & " tablosundan " + Id.ToString + " nolu kaydı silmek") Then

            If Sil(tablo, Id) Then
                MesajKutu("silme")
                form.Close()
            Else
                MesajKutu(2, "silme")
            End If
        End If
    End Sub

    Public Sub CBSec(ByVal box As ComboBox, ByVal veriler As List(Of String), ByVal Id As Integer)
        For i As Integer = 0 To veriler.Count - 1
            If Id = Convert.ToInt32(veriler(i)) Then
                box.SelectedIndex = i
            End If
        Next
    End Sub

    Public Sub MesajKutu(ByVal tur As Integer, ByVal islem As String)
        Select Case tur
            Case 1
                MessageBox.Show(islem.ToUpper() & " işlemi için gerekli alanları doldurunuz.", "Uyarı", MessageBoxButtons.OK, MessageBoxIcon.Warning)
            Case 2
                MessageBox.Show(islem.ToUpper() & " işlemi başarısız !!!", "Hata", MessageBoxButtons.OK, MessageBoxIcon.[Error])
        End Select
    End Sub

    Public Sub MesajKutu(ByVal islem As String)
        MessageBox.Show(islem.ToUpper() & " işlemi başarılı.", "Bilgi", MessageBoxButtons.OK, MessageBoxIcon.Information)
    End Sub

    Public Function SoruKutu(ByVal soru As String) As Boolean
        Dim cevap As DialogResult = MessageBox.Show(soru.ToUpper() & " istediğinize emin misiniz?", "Soru", MessageBoxButtons.YesNo, MessageBoxIcon.Question)

        If cevap = DialogResult.Yes Then
            Return True
        Else
            Return False
        End If
    End Function


End Class

