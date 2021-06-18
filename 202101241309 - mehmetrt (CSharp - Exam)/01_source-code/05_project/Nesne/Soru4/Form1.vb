Imports System.Data.OleDb
Imports System.Data
Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        ComboBox1.Items.Clear()
        Dim baglanti As OleDbConnection = New OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=market.mdb")
        baglanti.Open()
        Dim komut As OleDbCommand = New OleDbCommand("Select Ad,Soyad From musteriler Where Bakiye>1000", baglanti)
        Dim da As OleDbDataReader = komut.ExecuteReader
        While da.Read
            ComboBox1.Items.Add(da("Ad").ToString + " " + da("Soyad").ToString)
        End While
        ComboBox1.SelectedIndex = 0
        baglanti.Close()
    End Sub
End Class
