Public Class Form1
    Public Function HESAPLA(sayi As Integer) As Integer
        Dim fibonacci(sayi + 1) As Integer
        fibonacci(0) = 0
        fibonacci(1) = 1
        For index = 2 To sayi + 1
            fibonacci(index) = fibonacci(index - 1) + fibonacci(index - 2)
        Next
        Return fibonacci(sayi + 1)
    End Function
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim sayi As Integer = Convert.ToInt32(TextBox1.Text)
        MsgBox("Fibonacci " + sayi.ToString + ". elemani : " + HESAPLA(sayi).ToString)
    End Sub
End Class
