
Public Class Form1
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load


    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click

        Dim myBrush As SolidBrush = New SolidBrush(Color.Yellow)
        Dim formGraphics As Graphics
        formGraphics = Me.CreateGraphics
        formGraphics.FillPie(myBrush, New Rectangle(40, 5, 200, 200), -45, 135)
    End Sub
End Class
