

Public Class Form1
    Private Function test() As String
        MsgBox("normal")
        Return "normal"
    End Function

    Private Function test(ByVal param As String) As String
        MsgBox("overloading")
        Return "normal" + param

    End Function
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        test()
        test("a")
    End Sub
End Class
